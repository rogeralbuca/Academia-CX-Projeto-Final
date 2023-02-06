import { getUsuario } from './usuario.js';

const cepBtn = document.getElementById('btn-buscar-cep');

modifyUrl(`?username=${getUsuario().nome}`);

try {
  cepBtn.addEventListener('click', function () {
    console.log(getUsuario());
    const cep = document.getElementById('cep').value;

    fetch(`https://viacep.com.br/ws/${cep}/json/`)
      .then((response) => response.json())
      .then((data) => {
        document.getElementById('logradouro').value = data.logradouro;
        document.getElementById('bairro').value = data.bairro;
        document.getElementById('cidade').value = data.localidade;
        document.getElementById('estado').value = data.uf;
      })
      .catch((error) => {
        window.alert('CEP INVÁLIDO');
        console.error(error);
      });
  });
} catch (e) {}

try {
  const cadastro = document.getElementById('cadastro');
  cadastro.addEventListener('submit', function (event) {
    event.preventDefault();

    const inputs = cadastro.querySelectorAll('input');
    let isValid = true;

    for (const input of inputs) {
      if (!input.value) {
        alert(`Por favor, preencha o campo ${input.name}`);
        isValid = false;
        break;
      }
    }

    if (isValid) {
      const address = {
        id: null,
        cep: cadastro.cep.value,
        logradouro: cadastro.logradouro.value,
        numero: cadastro.numero.value,
        bairro: cadastro.bairro.value,
        cidade: cadastro.cidade.value,
        estado: cadastro.estado.value,
        client_id: getUsuario().id,
      };
      fetch('http://localhost:8080/address/save', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(address),
      })
        .then((response) => {
          if (response.status == 200) {
            window.alert(
              `Novo endereço de ${getUsuario().nome} cadastrado com sucesso`
            );
          } else {
            window.alert('Falha ao cadastrar endereço');
          }
          response.json();
        })
        .catch((error) => console.error(error));
    }
  });
} catch (e) {}

function modifyUrl(suffix) {
  window.history.pushState({}, '', suffix);
}
