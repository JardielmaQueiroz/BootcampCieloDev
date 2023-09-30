# Pré-cadastro de clientes

Projeto desenvolvido durante o bootcamp da Ada + Cielo.

## Pré-requisitos

Certifique-se de ter instalado o seguinte antes de começar:

- Java (versão 17.0.8)
- Maven (versão 3.9.4)
- MySQL (versão 8.0.34)	

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL com o nome `cielo.clientes`.
2. Atualize as configurações de conexão com o banco de dados no arquivo `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost/cielo.clientes
   spring.datasource.username=`seu usuario`
   spring.datasource.password=`sua senha`

## Getting started 

1.Clone o repositório;
2.Navegue até o diretório do projeto: `cd nome-do-projeto`;
3. Compile o projeto: `mvn clean install`;
4. Execute o aplicativo: `java -jar target/nome-do-jar.jar`.





