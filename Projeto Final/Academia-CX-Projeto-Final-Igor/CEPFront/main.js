async function submitForm() {
  const username = document.querySelector('#username').value;
  const password = document.querySelector('#password').value;
  
  document.querySelector('#message').innerHTML = 'Carregando';
  
  try {
    const response = await fetch(`http://localhost:8090/users/?username=${username}&password=${password}`);
    
    if (!response.ok) {
      throw new Error('Erro ao conectar com o servidor');
    }
    
    const users = await response.json();
    const user = users.find(u => u.username === username && u.password === password);
    
    if (user) {
      localStorage.setItem("username", username);
      window.location.href = `app.html?${username}`;
    } else {
      document.querySelector('#message').innerHTML = 'Nome ou senha incorreto';
    }
  } catch (error) {
    console.error(error);
    document.querySelector('#message').innerHTML = error.message;
  }
}

function logout() { 
  localStorage.removeItem("username");
  window.location.href = `/index.html`;
}

const CEP_API_URL = 'https://viacep.com.br/ws/';

const buscarBtn = document.getElementById("buscar");
buscarBtn.addEventListener("click", function() {
  const cep = document.getElementById("cep").value;
  
  fetch(`${CEP_API_URL}${cep}/json/`)
    .then(res => {
      if (!res.ok) {
        throw new Error('Erro ao consultar a API de CEP');
      }
      
      return res.json();
    })
    .then(data => {
      document.getElementById("rua").value = data.logradouro;
      document.getElementById("bairro").value = data.bairro;
      document.getElementById("cidade").value = data.localidade;
      document.getElementById("estado").value = data.uf;
    })
    .catch(err => {
      console.error(err);
      alert(err.message);
    });
});



//cria a lista dos endereços e estabelece constantes para form e corpo da tabela
const form = document.querySelector("form");
const tabelaCorpo = document.getElementById("tabela-corpo");

form.addEventListener("submit", async (event) => {
  event.preventDefault();
  if (event.submitter.id !== "salvar") {
    return;
  }

  const username = localStorage.getItem("username") || "";
  const dados = {
    username,
    cep: form.cep.value,
    nome: form.nome.value,
    rua: form.rua.value,
    bairro: form.bairro.value,
    cidade: form.cidade.value,
    estado: form.estado.value,
    numero: form.numero.value,
    datetime: new Date().toISOString(),
  };

  try {
    const response = await fetch("http://localhost:8090/enderecos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(dados),
    });

    if (!response.ok) {
      throw new Error(`Erro ao adicionar endereço: ${response.status} ${response.statusText}`);
    }

    const novoEndereco = await response.json();
    const tr = document.createElement("tr");
    Object.values(novoEndereco).forEach((valor) => {
      const td = document.createElement("td");
      td.textContent = valor;
      tr.appendChild(td);
    });
    tabelaCorpo.appendChild(tr);
  } catch (err) {
    console.error(err);
  }
});



// Carrega todos os endereços e atualiza a tabela
window.addEventListener("load", async function () {
  const tabelaCorpo = document.getElementById("tabela-corpo");
  try {
    const response = await fetch("http://localhost:8090/enderecos");
    if (!response.ok) {
      throw new Error(`Erro ao recuperar endereços: ${response.status} - ${response.statusText}`);
    }
    const enderecos = await response.json();
    for (const endereco of enderecos) {
      const tr = document.createElement("tr");
      for (const prop in endereco) {
        const td = document.createElement("td");
        td.textContent = endereco[prop];
        tr.appendChild(td);
      }
      tabelaCorpo.appendChild(tr);
    }
  } catch (err) {
    console.error(err);
  }
});
