# Trabalho de Engenharia de Software

## Tema

**GraphQL**

## Descrição

API GraphQL simples com operações CRUD para membros de academia.

## Tecnologias Utilizadas

* Java 17
* Spring Boot 3
* Spring for GraphQL
* Gradle (Build Tool)

## Schema GraphQL

```graphql
type Membro {
    id: ID!
    nome: String!
    email: String!
}

type Query {
    membros: [Membro!]!
    membro(id: ID!): Membro
}

type Mutation {
    criarMembro(
        nome: String!
        email: String!
    ): Membro!

    atualizarMembro(
        id: ID!
        nome: String
        email: String
    ): Membro

    deletarMembro(id: ID!): Boolean!
}
```

## Como Compilar

### Clonar o Projeto

```bash
git clone <URL_DO_REPOSITORIO>
```

### Acessar a Pasta

```bash
cd spring-boot-graphql
```

### Linux

Abra o terminal no diretório do projeto e execute:

```bash
chmod +x gradlew
./gradlew bootRun
```

### Windows

```cmd
gradlew.bat bootRun
```

## Operações CRUD via PowerShell

### Read

Altere a parte `query` para consultar apenas os dados desejados.

```powershell
Invoke-RestMethod `
-Uri "http://localhost:8080/graphql" `
-Method POST `
-ContentType "application/json" `
-Body '{"query":"{ membros { id nome email } }"}' |
ConvertTo-Json -Depth 10
```

### Create

```powershell
Invoke-RestMethod `
-Uri "http://localhost:8080/graphql" `
-Method POST `
-ContentType "application/json" `
-Body '{"query":"mutation { criarMembro(nome:\"NOME NOVO\", email:\"EMAIL NOVO\") { id nome email } }"}' |
ConvertTo-Json -Depth 10
```

### Update

```powershell
Invoke-RestMethod `
-Uri "http://localhost:8080/graphql" `
-Method POST `
-ContentType "application/json" `
-Body '{"query":"mutation { atualizarMembro(id:\"ID_DESEJADO\", nome:\"NOME DESEJADO\", email:\"EMAIL_DESEJADO\") { id nome email } }"}' |
ConvertTo-Json -Depth 10
```

### Delete

```powershell
Invoke-RestMethod `
-Uri "http://localhost:8080/graphql" `
-Method POST `
-ContentType "application/json" `
-Body '{"query":"mutation { deletarMembro(id:\"ID_DESEJADO\") }"}' |
ConvertTo-Json -Depth 10
```

## Conclusão

### Principais Vantagens do GraphQL

* Redução de overfetching
* Maior flexibilidade para o cliente
* Único endpoint para consultas e alterações
* Melhor aproveitamento da rede
* Facilidade de evolução da API

GraphQL é uma excelente opção para sistemas que necessitam de maior controle e flexibilidade sobre os dados consumidos. Em aplicações menores e mais simples, uma API REST ainda pode ser a melhor escolha devido à sua simplicidade e ampla adoção.
