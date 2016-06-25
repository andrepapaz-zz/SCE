# SCE - Sistema de Controle de Estoque
Projeto Universitário de controle de estoque com:
- AngularJS
- Bootstrap
- JavaEE
- Hibernate - MySQL
- RestFul
- Testes em Selenium e JUnit

### Hibernate
Configuração de deleção em cascata não funciona na criação das tabelas. Por isso foi necessário criar o arquivo manutencaoBanco.sql na pasta web/scripts.

### AngularJS
Não foi usado Angular Route para a troca das páginas, para isso foi usado o ng-show para controlar lista ou cadastro.

### Selenium Test Case
Na pasta web/seleniumTestCase temos o Arquivo AllCases que contém os testes efetuados no Selenium IDE no Firefox

### WildFly 8
Muitas bibliotecas estão sendo usadas do Servidor de aplicação WildFly 8 (CDI, Transaction, RestFul)

Usamos conexão por JNDI pelo WildFly, logo é necessário fazer a configuração de um novo datasource, aqui usamos o MySql.

Use esse seguinte link para configuração: [Configurando Datasource no JBoss Wildfly (com MySQL)Configurando Datasource no JBoss Wildfly (com MySQL)](https://desenvolvo.wordpress.com/2013/08/27/configurando-datasource-no-jboss-wildfly-com-mysql/) 

### IReport / Jasper Report
`Versão Utilizada - 3.6.2`

Fazemos utilização também da pasta ext do IReport para geração dos reports. Essas bibliotecas não foram adicionadas ao projeto, epenas as utilizamos.

Ou seja, é necessário a instalação, ou pelo menos a configuração da pasta com todos jars do Jasper na sua IDE.