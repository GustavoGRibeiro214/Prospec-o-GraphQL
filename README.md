Trabalho de Engenharia de Software

Tema: GraphQL
	

Descrição: API GraphQL simples com operações CRUD para membros de academia.


Tecnologias Utilizadas


Java 17
Spring Boot 3
Spring for GraphQL
Gradle (Build Tool)

Schema GraphQL

type Membro { id: ID!

nome: String!

email: String!

}

type Query {

membros: [Membro!]!

membro(id: ID!): Membro

}

type Mutation {

criarMembro(nome: String!,
email: String!): Membro!

atualizarMembro(id: ID!,
nome: String,
email: String):Membro 

deletarMembro(id: ID!): Boolean! }



Como compilar

Clonar o projeto git clone Acessar a pasta 

spring-boot-graphql

Linux
Abra o terminal no Diretorio acima

execute

chmod +x gradlew // para criar um executavel

./gradlew bootRun //Para rodar

ou no Windows:

gradlew.bat bootRun

CRUD no POWERSHELL com administrador

Read

Invoke-RestMethod
-Uri "http://localhost:8080/graphql" 
-Method POST 
-ContentType "application/json" 
-Body '{"query":"{ membros { id nome email } }"}' |(pode alterar dentro dos parenteses para retornar apenas os dados necessarios EX(nome email) vai retornar apenas o nome e o email) 
ConvertTo-Json -Depth 10

Creat

Invoke-RestMethod 
-Uri "http://localhost:8080/graphql" 
-Method POST -ContentType "application/json" 
-Body '{"query":"mutation { criarMembro(nome:"NOME NOVO", email:"EMAIL NOVO") { id nome email } }"}' | 
ConvertTo-Json -Depth 10

Alterar 

Invoke-RestMethod 
-Uri "http://localhost:8080/graphql" 
-Method POST -ContentType "application/json" 
-Body '{"query":"mutation { atualizarMembro(id:"ID_DESEJADO", nome:"NOME DESEJADO", email:"EMAIL DESEJADO") { id nome email } }"}' | 
ConvertTo-Json -Depth 10

Delete

Invoke-RestMethod
-Uri "http://localhost:8080/graphql" 
-Method POST -ContentType "application/json" 
-Body '{"query":"mutation { deletarMembro(id:"ID Desejado para deletara") }"}' | 
ConvertTo-Json -Depth 10


Conclusão Final 

Principais Vantagens do GraphQL Redução de Overfetching.
Maior flexibilidade para o cliente.
Único endpoint para consultas e alterações.
Melhor aproveitamento da rede Facilidade de evolução da API

Uma otima API para sistemas que necessitam de maior controle e flexibilidades com so dados, mas em casos de sistemas menores e simples o REST ainda pode ser a melhor opção
