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

## PASSOS PARA CRIAR UM ENVIROMENT NO POST PARA ARMAZENAMENTO AUTOMÁTICO DO TOKEN ##
1. Clicar em "Manage enviroments" no canto superior direito do postman
2. Clicar em "ADD"
3. Dar um nome ao enviroment
4. Adicionar nos campos:
	- VARIABLE = host 			| INITIAL VALUE = http://localhost:8080
	- VARIABLE = user 			| INITIAL VALUE = admincontractz
	- VARIABLE = password 		| INITIAL VALUE = admin123
	- VARIABLE = bearer_token	| INITIAL VALUE = 
5. Pronto, ambiente criado.
6. Após criação do ambiente e setagem das variavéis no Body da chamada, na aba "Tests" da chamada do token, inserir os dados abaixo:
	```
		//Verifica se a requisição encontra-se no range de sucesso!!
		if(responseCode.code >= 200 && responseCode.code <= 299){
		    var jsonData = JSON.parse(responseBody);
		    postman.setEnvironmentVariable('bearer_token', jsonData.token);
		}
	```

## INTEGRANDO COM O DOCKER ##
1. Inserir no arquivo docker-compose.yml uma pasta acima da aplicação, as configurações:
```
version: '3.4'
services:
  rest-with-spring-boot-udemy:
    image: juniorjrc/rest_with_springboot
    restart: always
    build: ./RestAPIWithSpringBoot
    working_dir: /RestAPIWithSpringBoot
    environment:
      TZ: America/Sao_Paulo
      SPRING_BOOT_ENVIRONMENT: Production
    volumes:
      - ./RestAPIWithSpringBoot:/RestAPIWithSpringBoot
      - ~/.m2:/root/.m2
    ports:
      - "8080:8080"
    command: mvn clean spring-boot:run
    networks:
      - udemy-network
networks:
    udemy-network:
        driver: bridge
```
2. O mesmo já irá montar a imagem do spring
3. Para inserir as imagens no docker hub, é necéssário mudar o nome da imagem conforme a escola:
	1. docker image ls
	2. docker image tag [ID_DA_IMAGEM] [SEU_REPOSITORIO]/[NOME_DA_IMAGEM]
	3. docker push [SEU_REPOSITORIO]/[NOME_DA_IMAGEM]