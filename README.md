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

## Como Compilar e Executar

### Clonar o Projeto

```bash
git clone <URL_DO_REPOSITORIO>
```

### Acessar a Pasta

```bash
cd spring-boot-graphql
```

---

## Linux (Ubuntu/Debian)

### Instalar Java 17

```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

Verifique a instalação:

```bash
java -version
javac -version
```

Resultado esperado:

```text
openjdk version "17.x.x"
javac 17.x.x
```

### Dar Permissão ao Gradle Wrapper

```bash
chmod +x gradlew
```

### Compilar o Projeto

```bash
./gradlew build
```

### Executar a Aplicação

```bash
./gradlew bootRun
```

O servidor estará disponível em:

```text
http://localhost:8080/graphql
```

### Gerar Arquivo JAR

```bash
./gradlew clean bootJar
```

O arquivo será gerado em:

```text
build/libs/
```

### Executar o JAR

```bash
java -jar build/libs/*.jar
```

---

## Windows

### Verificar Instalação do Java

```cmd
java -version
javac -version
```

### Compilar

```cmd
gradlew.bat build
```

### Executar

```cmd
gradlew.bat bootRun
```

### Gerar JAR

```cmd
gradlew.bat clean bootJar
```

### Executar JAR

```cmd
java -jar build\libs\graphqpl-0.0.1-SNAPSHOT.jar
```

---

## Endpoint GraphQL

Todas as operações utilizam o endpoint:

```http
POST http://localhost:8080/graphql
```

## Operações CRUD via PowerShell WINDOWS

### Read

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

## Operações CRUD via Linux (curl)

### Read

```bash
curl -X POST http://localhost:8080/graphql \
-H "Content-Type: application/json" \
-d '{"query":"{ membros { id nome email } }"}'
```

### Create

```bash
curl -X POST http://localhost:8080/graphql \
-H "Content-Type: application/json" \
-d '{"query":"mutation { criarMembro(nome:\"Joao\", email:\"joao@email.com\") { id nome email } }"}'
```

### Update

```bash
curl -X POST http://localhost:8080/graphql \
-H "Content-Type: application/json" \
-d '{"query":"mutation { atualizarMembro(id:\"1\", nome:\"Joao Atualizado\", email:\"novo@email.com\") { id nome email } }"}'
```

### Delete

```bash
curl -X POST http://localhost:8080/graphql \
-H "Content-Type: application/json" \
-d '{"query":"mutation { deletarMembro(id:\"1\") }"}'
```

## Conclusão

### Principais Vantagens do GraphQL

* Redução de overfetching
* Maior flexibilidade para o cliente
* Único endpoint para consultas e alterações
* Melhor aproveitamento da rede
* Facilidade de evolução da API

GraphQL é uma excelente opção para sistemas que necessitam de maior controle e flexibilidade sobre os dados consumidos. Em aplicações menores e mais simples, uma API REST ainda pode ser a melhor escolha devido à sua simplicidade e ampla adoção.
