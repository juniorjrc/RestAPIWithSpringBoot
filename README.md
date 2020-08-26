# RestAPIWithSpringBoot
Repositório destinado à aplicação dos aprendizados do curso de criação de API REST com SpringBoot AWS

## PASSOS PARA ADICIONAR O PACOTE DO SQLSERVER NA APLICAÇÃO ##
1. Baixar o jar referente ao driver do SQLServer **sqljdbc4-4.0**
2. Colocar o pacote na pasta do maven em **m2\repository\com\microsoft\sqlserver\sqljdbc4\4.0**
3. Se o banco de dados for local, é necessário habilitar o acesso pelo protocolo TCP/IP através do SQL Server [ano da versçai] Configuration Manager.
4. No **application.properties** inserir:
```
	spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
	spring.datasource.url=jdbc:sqlserver://localhost;databaseName=NOME_DO_SEU_BANCO
	spring.datasource.username=NOME_DO_USUARIO
	spring.datasource.password=SENHA

	spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServer2019Dialect

	spring.jpa.hibernate.ddl-auto = update
	spring.jpa.show-sql=false
```
5. No pom.xml inserir:
```
<dependency>
	<groupId>com.microsoft.sqlserver</groupId>
	<artifactId>sqljdbc4</artifactId>
	<version>4.0</version>
</dependency>
```
6. Pronto, o driver esta configurado.

## PASSOS DO DESAFIO PROPOSTO NA AULA 104 - SESSÃO 15 ##
1. Criar as migrations referente à nova entidade
2. Criar a entidade
3. Criar o repository
4. Criar o VO
5. Criar o service
6. Criar o controller com suporte ao Content Negotiation, HATEOAS e swagger