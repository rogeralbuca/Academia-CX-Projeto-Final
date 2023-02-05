import { setUsuario } from './usuario.js';

const username = document.querySelector('input[type="text"]');
const password = document.querySelector('input[type="password"]');
const submitButton = document.querySelector('button[type="submit"]');

try {
  submitButton.addEventListener('click', function (event) {
    event.preventDefault();
    fetchData(username.value, password.value);
  });
} catch (e) {}

modifyUrl(`login`);

async function fetchData(inputUser, inputSenha) {
  try {
    const response = await fetch('http://localhost:8080/client', {
      method: 'GET',
      mode: 'cors',
    });
    const usuarios = await response.json();
    usuarios.forEach((usuario) => {
      if (inputUser === usuario.username) {
        if (inputSenha === usuario.password) {
          console.log('Acesso permitido');
          setUsuario({
            id: usuario.id,
            nome: usuario.nome,
          });

          window.location.href = './cadastro.html';

          setTimeout(() => {
            const h1 = document.querySelector('.usuario');
            h1.textContent = `Cadastro de Endereço: ${usuario.nome} `;
          }, 2000);
        } else {
          window.alert('SENHA INCORRETA');
          console.log('SENHA INCORRETA');
        }
      }
    });
  } catch (error) {
    console.error(error);
  }
}

function modifyUrl(suffix) {
  var currentUrl = window.location.href;
  window.history.pushState({}, '', suffix);
}
