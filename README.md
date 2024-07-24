# mono-to-micro
Projeto para estudo da Confraria Dev - Do Monolito ao Microserviço

## Stack:
* Framework Quarkus;
* docker-compose (sonarqube local na porta 9000);

## Ambiente
* Linux;
* IntelliJ;
* Docker Engine (docker-ce);
* Quarkus-CLI;
* Java 21;

## Caminhos
* mono-to-micro/mono/ - monolito
  * travel-app  
    * ```mvn clean install``` irá instalar as dependencias;
    * ```quarkus: dev``` ativa app em modo desenvolvedor;

* mono-to-micro/micro/ - microservico
  * servicoA
    * ```mvn clean install``` irá instalar as dependencias;
    * ```quarkus: dev``` ativa app em modo desenvolvedor;
  * servicoB
    * ```mvn clean install``` irá instalar as dependencias;
    * ```quarkus: dev``` ativa app em modo desenvolvedor;
  * servicoC
    * ```mvn clean install``` irá instalar as dependencias;
    * ```quarkus: dev``` ativa app em modo desenvolvedor;