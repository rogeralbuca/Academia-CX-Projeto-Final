const form = document.getElementById("form");
const cep = document.getElementById("cep");
const nome = document.getElementById("nome");
const rua = document.getElementById("rua");
const bairro = document.getElementById("bairro");
const cidade = document.getElementById("cidade");
const estado = document.getElementById("estado");
const numero = document.getElementById("numero");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  checkInput();
});

// VALIDAÇÕES DOS CAMPOS
function checkInput() {
  const cepValue = cep.value;
  const nomeValue = nome.value;
  const ruaValue = rua.value;
  const bairroValue = bairro.value;
  const cidadeValue = cidade.value;
  const estadoValue = estado.value;
  const numeroValue = numero.value;

  if (cepValue === "") {
    setErrorFor(cep, "O cep é obrigatório");
  } else {
    setSucessFor(cep);
  }

  if (nomeValue === "") {
    setErrorFor(nome, "O nome é obrigatório");
  } else {
    setSucessFor(nome);
  }

  if (ruaValue === "") {
    setErrorFor(rua, "A rua é obrigatória");
  } else {
    setSucessFor(rua);
  }

  if (bairroValue === "") {
    setErrorFor(bairro, "O bairro é obrigatório");
  } else {
    setSucessFor(bairro);
  }

  if (cidadeValue === "") {
    setErrorFor(cidade, "A cidade é obrigatória");
  } else {
    setSucessFor(cidade);
  }

  if (estadoValue === "") {
    setErrorFor(estado, "O estado é obrigatório");
  } else {
    setSucessFor(estado);
  }

  if (numeroValue === "") {
    setErrorFor(numero, "O número deve ser informado");
  } else {
    setSucessFor(numero);
  }
}

function setErrorFor(input, mensagem) {
  const formControl = input.parentElement;
  const small = formControl.querySelector("small");

  // Adiciona mensagem de erro
  small.innerText = mensagem;

  // Adiciona a classe de erro
  formControl.className = "form-control error";
}

function setSucessFor(input) {
  const formControl = input.parentElement;

  formControl.className = "form-control success";
}

// CHAMAR API VIA CEP
const limparFormulario = (endereco) => {
  document.getElementById("rua").value = "";
  document.getElementById("bairro").value = "";
  document.getElementById("cidade").value = "";
  document.getElementById("estado").value = "";
};

const preencherFormulario = (endereco) => {
  document.getElementById("rua").value = endereco.logradouro;
  document.getElementById("bairro").value = endereco.bairro;
  document.getElementById("cidade").value = endereco.localidade;
  document.getElementById("estado").value = endereco.uf;
};

const eNumero = (numero) => /^[0-9]+$/.test(numero);

const cepValido = (cep) => cep.length == 8 && eNumero(cep);

const pesquisarCep = async () => {
  limparFormulario();
  const cep = document.getElementById("cep").value;
  const url = `https://viacep.com.br/ws/${cep}/json/`;

  if (cepValido(cep)) {
    const dados = await fetch(url);
    const endereco = await dados.json();

    if (endereco.hasOwnProperty("erro")) {
      document.getElementById("rua").value = "CEP não encontrado!";
    } else {
      preencherFormulario(endereco);
    }
  } else {
    document.getElementById("rua").value = "CEP inválido! Tente novamente! ";
  }
};

document.getElementById("cep").addEventListener("focusout", pesquisarCep);

// APAGAR FORMULÁRIO APÓS CADASTRO
let apagarFormulario = () => {
  document.getElementById('cep').value = "";
  document.getElementById('nome').value = "";
  document.getElementById("rua").value = "";
  document.getElementById("bairro").value = "";
  document.getElementById("cidade").value = "";
  document.getElementById("estado").value = "";
  document.getElementById("numero").value = "";

};

// CADASTRAR ENDEREÇOS
const btnCadastro = document.getElementById('btn-cadastrar');
async function login(event) {

  event.preventDefault();

  const inputCep = document.getElementById('cep').value;
  const inputNome = document.getElementById('nome').value;
  const inputRua = document.getElementById('rua').value;
  const inputBairro = document.getElementById('bairro').value;
  const inputCidade = document.getElementById('cidade').value;
  const inputEstado = document.getElementById('estado').value;
  const inputNumero = document.getElementById('numero').value;
  const cadastroRealizado = document.getElementById('cadastrado');


  const dados = {
    'cep': inputCep,
    'rua': inputRua,
    'bairro': inputBairro,
    'cidade': inputCidade,
    'estado': inputEstado,
    'numero': inputNumero,
  }

  if(inputCep === '' || inputRua === '' || inputBairro === '' || inputCidade === '' || inputEstado === '' || inputNumero === ''){
    return false;
  }

  const response = await fetch('http://localhost:8090/address/save', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(dados)
  });

  const content = await response.json();
  console.log(content);
  cadastroRealizado.innerText = 'Cadastro realizado com sucesso! ';

// DIRECIONAMENTO PARA GOOGLE MAPS
  const btnGoogle = document.querySelector(".btn-google");

  if (true) {
    btnGoogle.classList.add("ativo");
    btnGoogle.addEventListener('click', function(){
      event.preventDefault();
      window.open(
          `https://www.google.com/maps/search/?api=1&query=${encodeURIComponent(
              `${dados.rua} ${dados.numero} ${dados.bairro} ${dados.cidade} ${dados.estado}`
          )}`)
    })
  }
  apagarFormulario();
};


btnCadastro.addEventListener("click", login);

// LOGOUT
function sair(){
  window.location.href = '/index'
}

const logout = document.getElementById('btn-logout');
logout.addEventListener('click', sair);