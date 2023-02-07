import { getUsuario } from './usuario.js';

const main = document.querySelector('main');

let index = 1;

modifyUrl(`?username=${getUsuario().nome}`);
document.getElementById('userheader').innerHTML = `Endereços: ${
  getUsuario().nome
}`;

getClientData();

function modifyUrl(suffix) {
  window.history.pushState({}, '', suffix);
}
async function getClientData() {
  try {
    const response = await fetch(
      `http://localhost:8080/client/${getUsuario().id}`
    );
    const data = await response.json();
    console.log(data.addresses);
    data.addresses.map((address) => {
      const addressCard = createAddressCard(address);
      main.appendChild(addressCard);
    });
  } catch (error) {
    console.error(error);
  }
}

function createAddressCard(address) {
  const card = document.createElement('div');
  card.classList.add('card');

  const header = document.createElement('h2');
  header.textContent = `Endereço ${index++}`;
  card.appendChild(header);

  const cep = document.createElement('p');
  cep.classList.add('card-cep');
  cep.textContent = `CEP: ${address.cep}`;
  card.appendChild(cep);

  const logradouro = document.createElement('p');
  logradouro.classList.add('card-logradouro');
  logradouro.textContent = `Logradouro: ${address.logradouro}`;
  card.appendChild(logradouro);

  const numero = document.createElement('p');
  numero.classList.add('card-numero');
  numero.textContent = `Número: ${address.numero}`;
  card.appendChild(numero);

  const bairro = document.createElement('p');
  bairro.classList.add('card-bairro');
  bairro.textContent = `Bairro: ${address.bairro}`;
  card.appendChild(bairro);

  const cidade = document.createElement('p');
  cidade.classList.add('card-cidade');
  cidade.textContent = `Cidade: ${address.cidade}`;
  card.appendChild(cidade);

  const estado = document.createElement('p');
  estado.classList.add('card-estado');
  estado.textContent = `Estado: ${address.estado}`;
  card.appendChild(estado);

  const mapButton = document.createElement('button');
  mapButton.textContent = 'Ver no mapa';
  mapButton.classList.add('btn-mapa');
  mapButton.addEventListener('click', () => {
    window.open(
      `https://www.google.com/maps/search/?api=1&query=${encodeURIComponent(
        `${address.logradouro} ${address.numero} ${address.bairro} ${address.cidade} ${address.estado}`
      )}`
    );
  });
  card.appendChild(mapButton);

  return card;
}
