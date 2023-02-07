async function submitForm() {
  const username = document.querySelector('#username').value;
  const password = document.querySelector('#password').value;
  
  try {
  const response = await fetch(`http://localhost:8090/users/?username=${username}&password=${password}`);
  const users = await response.json();
  const user = users.find(u => u.username === username && u.password === password);
  if (user) {
  localStorage.setItem("username", username);
  window.location.href = `app.html?${username}`;
  } else {
  document.querySelector('#message').innerHTML = 'Dados de acesso inválidos';
  }
  } catch (error) {
  console.error(error);
  document.querySelector('#message').innerHTML = 'Erro ao conectar com o servidor';
  }
  }

//Faz logout
function logout() { 
    window.location.href = `/index.html`;
}

//Faz a consulta na API de CEP e retorna os dados no formulário
const buscarBtn = document.getElementById("buscar");
buscarBtn.addEventListener("click", function() {
  const cep = document.getElementById("cep").value;
  fetch(`https://viacep.com.br/ws/${cep}/json/`)
    .then(res => res.json())
    .then(data => {
      document.getElementById("rua").value = data.logradouro;
      document.getElementById("bairro").value = data.bairro;
      document.getElementById("cidade").value = data.localidade;
      document.getElementById("estado").value = data.uf;
    })
    .catch(err => console.error(err));
});

//cria a lista dos endereços e estabelece constantes para form e corpo da tabela
const form = document.querySelector("form");
const tabelaCorpo = document.getElementById("tabela-corpo");

// Envia a requisição POST para adicionar um novo endereço
form.addEventListener("submit", async function(event) {
  event.preventDefault();
  if (event.submitter.id === "salvar") {
    const username = localStorage.getItem("username");
    const dados = {
      username: username,
      cep: this.cep.value,
      nome: this.nome.value,
      rua: this.rua.value,
      bairro: this.bairro.value,
      cidade: this.cidade.value,
      estado: this.estado.value,
      numero: this.numero.value,
      datetime: new Date().toISOString()
    };

    try {
      const response = await fetch("http://localhost:8090/enderecos", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(dados)        
      });      
      const novoEndereco = await response.json();
      const tr = document.createElement("tr");
      for (const prop in novoEndereco) {
        const td = document.createElement("td");
        td.textContent = novoEndereco[prop];
        tr.appendChild(td);
      }
      tabelaCorpo.appendChild(tr);
    } catch (err) {
      console.error(err);
      console.error(response.status);
      console.error(response.statusText);
    }
  }
});

// Carrega todos os endereços e atualiza a tabela
window.addEventListener("load", async function() {
  try {
    const response = await fetch("http://localhost:8090/enderecos");
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