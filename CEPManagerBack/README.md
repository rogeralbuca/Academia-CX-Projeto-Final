# CEPManagerBack

É a parte backend da aplicação de CEP. Os CEPs salvos pelo front são enviados para o back para relacionamento com o banco de dados.  

## Detalhes

- Rotas existentes: GET ALL, GET por ID, POST, PUT e DELETE.
- Abrange as classes de Endereco e User.  

## Como usar

- Rode o CEPManagerFront.
- Clone esse repositório  
- Configure o seu banco de dados localmente (MORE DETAILS TO DO)  
- Rode essa aplicação através do mvn spring-boot:run  
- Abra seu POSTMAN e divirta-se usando as seguintes mencionadas
- A partir do Front, salve e busque endereços para ver todo o processo funcionando  

## Testando requisições pelo Postman  
- Crie requisições nesse sentido  
![image](https://user-images.githubusercontent.com/70555750/216785741-0d402835-349d-4434-9d88-7b84cc1123b1.png)  

- Requisições GET ALL e POST devem ser feitas para a rota /enderecos ou /users  
- Requisições GET por ID, PUT e DELETE devem ser feitas para /enderecos/{id} ou /users/{id} 


## Exemplo de requisições POST e PUT  
Para os dois tipos de requisições HTTP você pode usar esse exemplo de JSON:  
> {  
"username": "tiagoluis86",  
"cep": "12345678",  
"nome": "Tiago",  
"rua": "Rua Manaus",  
"bairro": "Ipiranga",  
"cidade": "Nova Milles",  
"estado": "North Simmia",  
"numero": 123,  
"datetime": "2022-12-31T23:59:59.999Z"  
}


