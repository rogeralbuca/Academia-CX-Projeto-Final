# Projeto Final Frontend - Academia CX NTT Data

* Aluno: Gianluca Notari Magnabosco da Silva

<br/>
<br/>


## Credenciais

* Existem dois usuários cadastrados no sistema;

* Para realizar login, escolha um dos usuários e insira suas respectivas credenciais;

* Username: `Roger`; password = `senhalegal123`;

* Username: `Gianluca`; password = `senhalegal123`;

<br/>
<br/>


## Requisitos para iniciar a aplicação

* É necessário possuir Java instalado;

* É necessário possuir a IDE IntelliJ instalada;


<br/>
<br/>


## Passo a passo

* Para rodar a aplicação, é necessário que você faça clone deste repositório na sua máquina local;

* Após clonar o repositório, abra o IntelliJ;

* Com o IntelliJ aberto, navegue até a aba `File` no cabeçalho da IDE e selecione `Open...`;

* Navegue até o diretório onde se encontra o repositório em sua máquina local;

* Selecione a pasta `academiacx` e a abra;

* Agora é só rodar o projeto, clique no `ícone de play` no canto superior direito da IDE;

* Para acessar a aplicação `vá para a seguinte URL`: http://localhost:8080

* Você irá se deparar com uma página de Login;

* Insira as credenciais (username: Roger; password: senhalegal123 OU username: Gianluca; password: senhalegal123);

* Se o login ocorrer bem, você será redirecionado para a página app.html;

* Na página app.html, você poderá cadastrar um endereço no sistema;

* Após cadastrar um endereço, será disponibilizado um link para abrir o endereço no `Google Maps`;


<br/>
<br/>


## Validações

* O usuário e a senha precisam ser informados para submissão do formulário;

* Existe também uma validação no Backend caso o usuário ou senha não sejam informados;

* O usuário precisa estar presente no banco de dados (Roger ou Gianluca);

* A senha é criptografada com algoritmo `SHA-256`;

* Caso o usuário informado não exista, o cliente será informado;

* Caso a senha esteja incorreta, o cliente será informado;

* O CEP possui máscara;

* O CEP e o número possuem validações tanto no Front quanto no Backend;

* O número pode ser informado como [nº ; Nº ; n; n. ; e apenas números;];

* Caso o usuário não seja informado, o cliente será avisado;

* Caso o usuário não seja encontrado, o cliente será avisado;

* Nenhum dos campos de endereço pode ser vazio, havendo validação para todos;