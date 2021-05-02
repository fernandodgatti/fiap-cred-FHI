# Sping Data JPA + SDK MOIP + SWAGGER + MYSQL(Local)
Sistema de cadastro de alunos, pedidos e pagamentos em um portal de autorizador de pagamentos(Wirecard)

## Justificativa de escolha e decisões técnicas
O Grupo optou por usar MOIP/Wirecard, pois possui um sistema de sandbox para testes de desenvolvedores.
Já a escolha por JPA + MYSQL foi pela facilidade de configuração local.

## Configuração da Aplicação\DB 
#### MySQL
As propriedades de acesso ao banco de dados estão disponíveis no arquivo application.yml, 
você poderá alterar a porta de execução da aplicação e o local do arquivo temporário do banco de dados.

````Java
server:
  port: 8084

spring:
  datasource:
    url: jdbc:h2:file:C:/temp/fiapcreditodb;DB_CLOSE_ON_EXIT=FALSE
    username: fiap
    password: fiap
  jpa:
    hibernate:
      ddl-auto: update
````
      
## Emissão de Extrato do Aluno 
Para emissão do extrato do aluno, necessário fazer uma requisição(GET) com *basic authorization utilizando o seguinte endpoint com QueryString:
````
https://sandbox.moip.com.br/v2/orders?q=NOME+DO+ALUNO
````
* As informações do basic authorization se encontram no arquivo txt que foi enviado no portal da FIAP

## SWAGGER
````
http://localhost:8084/swagger-ui/index.html#/
````

---------------------------------------

## Colaboradores
| Colaborador | Github |
| ------ | ------ |
| Fernando Gatti | [fernandodgatti][Gatti] |
| Henrique Abdala | [henriqueabdala][Abdala] |
| Iller Boromello | [boromello][Boromello] |

Professor Rafael Matsuyama

Licença
----
FIAP



[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>
   [Gatti]: <https://github.com/fernandodgatti>
   [Abdala]: <https://github.com/henriqueabdala>
   [Boromello]: <https://github.com/Boromello>
   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
