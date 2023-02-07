const url = `http://localhost:8091/cep/cadastrar`;

function postCep(url, body) {
  console.log("Body=", body);
  let request = new XMLHttpRequest();
  request.open("POST", url, true);
  request.setRequestHeader("Content-type", "application/json");
  request.send(JSON.stringify(body));

  request.onload = function () {
    console.log(this.responseText);
  };
  return request.responseText;
}

function cadastraCep() {
  event.preventDefault();
  const url = `http://localhost:8091/cep/cadastrar`;
  let cep = document.getElementById("cep").value;
  let endereco = document.getElementById("endereco").value;
  let numero = document.getElementById("numero").value;
  let bairro = document.getElementById("bairro").value;
  let cidade = document.getElementById("cidade").value;
  let estado = document.getElementById("estado").value;

  body = {
    cep: cep,
    logradouro: endereco,
    numero: numero,
    bairro: bairro,
    localidade: cidade,
    uf: estado,
  };

  postCep(url, body);
}

///////////////// user cadastro

const urlCadastro = `http://localhost:8091/usuarios/cadastrar`;

function postUser(urlCadastro, body) {
  console.log("Body=", body);
  let request = new XMLHttpRequest();
  request.open("POST", urlCadastro, true);
  request.setRequestHeader("Content-type", "application/json");
  request.send(JSON.stringify(body));

  request.onload = function () {
    console.log(this.responseText);
  };
  return request.responseText;
}

function cadastraUsuario() {
  event.preventDefault();
  const urlCadastro = `http://localhost:8091/usuarios/cadastrar`;
  let nome = document.getElementById("nome").value;
  let email = document.getElementById("email").value;
  let username = document.getElementById("username").value;
  let senha = document.getElementById("senha").value;

  body = {
    nome: nome,
    email: email,
    username: username,
    senha: senha,
  };

  postUser(urlCadastro, body);
}

///////////////// user login

const urlLogin = `http://localhost:8091/usuarios/logar`;

function postUserLogar(urlLogin, body) {
  console.log("Body=", body);
  let request = new XMLHttpRequest();
  request.open("POST", urlLogin, true);
  request.setRequestHeader("Content-type", "application/json");
  request.send(JSON.stringify(body));

  request.onload = function () {
    console.log(this.responseText);
  };
  return request.responseText;
}

function logarUsuario() {
  event.preventDefault();
  const urlLogin = `http://localhost:8091/usuarios/logar`;

  let email = document.getElementById("email").value;
  let senha = document.getElementById("senha").value;

  body = {
    email: email,
    senha: senha,
  };

  postUserLogar(urlLogin, body);
}

function redirecionarIndex() {
  window.location.href = "./index.html";
}

function redirecionarLogin() {
    window.location.href = "./login.html";
  }
  
  function save() {
    Swal.fire({
      position: "center",
      icon: "success",
      title: "Endereço cadastrado com sucesso",
      timer: 1500,
      showConfirmButton: false,
      
    });
  }

  function error() {
    Swal.fire({
      icon: "error",
    title: "Oops...",
    text: "Algo deu errado.",
    showConfirmButton: true,
  });
 
}

//////////////////// VALIDAÇÕES

function validarCep() {
  if (nome.value == "") {
    error();
    nome.focus();
  } else if (cep.value == "") {
    error();
    cep.focus();
  } else if (endereco.value == "") {
    error();
    endereco.focus();
  } else if (numero.value == "") {
    error();
    numero.focus();
  } else if (bairro.value == "") {
    error();
    bairro.focus();
  } else if (cidade.value == "") {
    error();
    cidade.focus();
  } else if (estado.value == "") {
    error();
    estado.focus();
  }
}

function validarCadastro() {
  if (nome.value == "") {
    error();
    nome.focus();
  } else if (email.value == "") {
    error();
    email.focus();
  } else if (username.value == "") {
    error();
    username.focus();
  } else if (senha.value == "") {
    error();
    senha.focus();
  }
}

function validarLogin() {
  if (email.value == "") {
    error();
    email.focus();
  } else if (senha.value == "") {
    error();
    senha.focus();
  }
  
 
  
}
