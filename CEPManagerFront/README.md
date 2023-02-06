# CEPManagerFront
Usando a API de CEP, busca CEPS e salva no banco de dados MySQL administrado pela outra aplicaçao Spring

## Como usar
- baixe e rode o CEPManagerBack  
- baixe e rode essa aplicação através do index.html  
- faça login como admin e senha admin  
![image](https://user-images.githubusercontent.com/70555750/216853486-fbc8ccf7-f298-4e10-a591-4760b47ac1bb.png)

- na tela inicial, você pode buscar endereços digitando o CEP  
![image](https://user-images.githubusercontent.com/70555750/216854369-0267bd29-d469-4207-af3c-775c4528beae.png)

- complete o formulário e clique para salvar  

## Como funciona
- Usa a API https://viacep.com.br/ para puxar os endereços pelo CEP  
- Ao salvar os endereços, salva no serviço CEPManagerBack, que atua como servidor se relacionando com um banco de dados MySQL  
![image](https://user-images.githubusercontent.com/70555750/216854507-44e27945-f016-435a-89b0-e58c6873f591.png)

- Salvar envia uma requisição POST para o backend da aplicação e a tabela atualiza automaticamente (quase) realizando no mesmo instante um GET para o backend  
