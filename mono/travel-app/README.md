# travel-app

#### Requerido
- JDK +11 (Projeto está usando o 21 pra compilar);
- IDE de sua prefencia;
- Maven

Você roda a aplicação usando o comando abaixo
```shell script
./mvnw compile quarkus:dev
```
#### Recursos usados:
- JDK 21
- Records [pra camada de apresentação]
- MapStruct [para a serialização e deserialização de objetos]
- H2database [banco de dados em memória]
- Dependencias do Quarkus atualizadas: https://github.com/quarkusio/quarkus/wiki/Migration-Guide-3.9
  - quarkus-resteasy-reactive -> quarkus-rest
  - quarkus-resteasy-reactive-jsonb -> quarkus-rest-jsonb