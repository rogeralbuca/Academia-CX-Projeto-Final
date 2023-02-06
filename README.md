## Descrição do Projeto

Este projeto consiste em construir uma aplicação de ponta a ponta que aplica os conceitos aprendidos no decorrer de três semanas na Academia CX da NTT Data Business Solutions.

A aplicação é uma plataforma de gerenciamento de endereços para usuários. Os usuários podem criar endereços e visualizar uma lista de endereços criados.

A aplicação tem uma parte de back-end (Spring), que é responsável por gerenciar a conexão com o banco de dados (MySQL) e por fornecer as informações solicitadas pela parte de front-end (HTML/CSS/Javscript). A parte de front-end é responsável por exibir as informações para o usuário e permitir a interação com a aplicação.

## Execução do projeto

Para rodar este projeto, você precisará dos seguintes softwares instalados em sua máquina:

1. MySQL: É necessário ter um banco de dados MySQL instalado e configurado para poder rodar a aplicação de back-end.

2. IntelliJ: Este é o ambiente de desenvolvimento integrado (IDE) recomendada para rodar o código do back-end.

3. Visual Studio Code: Esta é a IDE recomendada para rodar o código do front-end. Além disso, é necessário instalar o plugin Five Server para rodar o código do front-end.

Instruções para execução

1. Clone o repositório do projeto em sua máquina.

2. Inicie o servidor MySQL. Crie um banco de dados com o nome `commercenttcx` é importante verificar se a configuração do `application.proporties` esta acessando o servidor sql na porta correta

3. Abra o a pasta `back-end` no IntelliJ e execute a aplicação.

4. Abra a pasta `front-end` no Visual Studio Code.

5. Certifique-se de que o plugin Five Server está instalado e ativo no Visual Studio Code.

6. Inicie o `index.html` usando o Five Server.

_IMPORTANTE_

_Obs¹:_ Caso você tente rodar o front-end sem o Five Server, você receberá um erro de violação CORS Policy.

_Obs²:_ Para que funcione corretamente é importante que o `import.sql` tenha sido lido corretamente pelo hibernate.

## Usuários Cadastrados

### `Usuários`

joaosilva

mariasouza

josepereira

anarodriguez

fabioalmeida

carlanunes

### `Senha`

Todos os usuários possuem a mesma senha: senha123

## Ilustração do projeto 
### Tela de Login
![image](https://user-images.githubusercontent.com/101530871/216881265-8e63968f-fc8b-4e9a-898b-47667b6b3cd2.png)

### Formulário de Cadastro de Endereços

![image](https://user-images.githubusercontent.com/101530871/216881487-1e96c2ce-7590-4329-81ee-bdc42349a75c.png)

### Preenchimento automático

![image](https://user-images.githubusercontent.com/101530871/216881569-016e34b3-925c-44b3-83ac-a968df92582c.png)

### Confirmação de Cadastro

![image](https://user-images.githubusercontent.com/101530871/216881644-45c0f649-5edd-47d5-b4e4-b232a30c9b08.png)

### Lista de Endereços do Usuário

![image](https://user-images.githubusercontent.com/101530871/216881706-dcb8caea-4595-438f-8208-e214aeef3a68.png)

### O Botão `ver no mapa` te direciona para o endereço no google maps

![image](https://user-images.githubusercontent.com/101530871/216881798-d1e4791f-5732-486d-a871-d1a8f98be0ae.png)

### Imagem do banco de dados com o novo endereço inserido

![image](https://user-images.githubusercontent.com/101530871/216882335-772397ca-0301-4ce8-b7f4-2ca1ea5394fa.png)

