## Descrição do Projeto
Este projeto visa em construir uma aplicação com os conceitos aprendidos no decorrer da Academia CX.

_Obs¹_: Infelizmente meu conhecimento com tecnologias de frontend não é avançado, por isso o projeto está bem simples e pode ter alguns erros no front.

A aplicação é uma plataforma de cadastro de endereços para usuários.

Os usuários podem cadastrar diversos endereços e visualizar suas respectivas posições no mapa.

A aplicação está dividida em duas partes:

O backend é o responsável por gerenciar a conexão com o banco de dados, utilizei o H2 para facilitar o acesso. E por alimentar o front-end com dados salvos no sistema.

O front-end é responsável por exibir e interagir com as informações recolhidas do backend pelo o usuário.

## Execução do projeto

Para rodar este projeto, você precisará dos seguintes softwares instalados em sua máquina:

1. IntelliJ: Este é o ambiente de desenvolvimento integrado (IDE) recomendada para rodar o código do back-end.

2. Visual Studio Code: Esta é a IDE recomendada para rodar o código do front-end.

3. Além disso, é necessário instalar o Live Server para rodar o código do front-end no VSCode.

Instruções para execução

1. Clone o repositório do projeto em sua máquina.

2. Abra o a pasta `back-end` no IntelliJ e execute a aplicação.

3. Abra a pasta `front-end` no Visual Studio Code.

4. Certifique-se de que o plugin Live Server está instalado e ativo no Visual Studio Code.

5. Inicie o `login.html` usando o Live Server.

_IMPORTANTE_

_Obs¹:_ Caso você tente rodar o front-end outro plugin, deve-se alterar o `SimpleCorsFilter` e adicionar a URL na Lista `ALLOWED_ORIGINS`

_Obs²:_ NÃO HÁ DADOS CADASTRADOS NO SISTEMA
