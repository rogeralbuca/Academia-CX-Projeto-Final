//Estabelece uma pequena base de dados de users e passwords
const users = [
  {
      username: 'admin',
      password: 'admin',
      role: 'admin'
  },
  {
      username: 'tiagoluis86',
      password: 'quadrado86?',
      role: 'user'
  },
  {
      username: 'brotoela',
      password: 'broto123',
      role : 'user'
  },
];

//Verifica se o usuário e senha existem e faz o login redirecionando a página ou dá erro 
function submitForm() {
  const username = document.querySelector('#username').value;
  const password = document.querySelector('#password').value;  

  const user = users.find(u => u.username === username && u.password === password);
  if (user) {      
      localStorage.setItem("username", username);
      window.location.href = `app.html?${username}`;     
  } else {
      document.querySelector('#message').innerHTML = 'Usuário ou senha inválido';
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
const lista = [];
const tabelaCorpo = document.getElementById("tabela-corpo");

//Condiciona que ao apertar o botão salvar os dados devem ser salvos na lista que vai pra tabela
form.addEventListener("submit", function(event) {
  event.preventDefault();
  if (event.submitter.id === "salvar") {
    const dados = {
      cep: this.cep.value,
      nome: this.nome.value,
      rua: this.rua.value,
      bairro: this.bairro.value,
      cidade: this.cidade.value,
      estado: this.estado.value,
      numero: this.numero.value
    };
    lista.push(dados);
    const tr = document.createElement("tr");
    for (const prop in dados) {
      const td = document.createElement("td");
      td.textContent = dados[prop];
      tr.appendChild(td);
    }
    tabelaCorpo.appendChild(tr);
  }
});