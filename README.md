# CEPManager
Usando a API de CEP, busca CEPS e salva no banco de dados local MySQL
Tem duas partes:  
- aplicação javascript que é o front, onde o usuário pesquisa CEPS e envia requisições POST para salvar no servidor  
- aplicação spring, que é o back, que recebe as requisições pra salvar e administra o banco MySQL e que joga de volta requisições GET pra exibir no front  

## como usar
- baixe esse repositório  
- abra a pasta do backend no seu IntelliJ e altere o username e password para o que você usa no seu MySQL no application.properties  
- as duas controllers estão definidas para receber CORS { * } como padrão para que qualquer pessoa que for rodar essa aplicação rode com menos burocracia, mas é recomendável por segurança que você coloque apenas seu localhost de onde estará rodando seu front  
- Execute mvn spring-boot:run  
- o banco de dados "cepmanagerserver", tabela "endereco" e "user" serão erguidos automaticamente
- abra a pasta do frontend e execute index.html  
- front 
- você pode fazer login com admin / admin ou user / user de username e password, respectivamente, dados que já sobem como padrão na tabela "user"  
- após fazer login você pode fazer pesquisas na API de CEPs e salvar (POST) na tabela MySQL "endereco", que será exibida de acordo no front através de um GET  
- você pode testar todas as rotas no Postman para GET ALL, GET by ID, POST, PUT e DELETE para as rotas /users e /enderecos  
- instruções mais específicas podem ser encontradas no readme de cada projeto  
