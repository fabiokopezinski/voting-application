# Projeto de sistemas de pautas

# Objetivo

Crie uma solução de backend para ser executada em nuvem que proveja as seguintes funcionalidades através de serviços REST:

 + Cadastrar uma nova pauta
 + Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default)
 + Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta)
 + Contabilizar os votos e dar o resultado da votação na pauta
 
 Considerações técnicas: 
 
 Nesse projeto foi considerado 4 entidades principais:
 
  + Question
  + Session
  + Vote
  + Associate
  
# Ferramentas 
  + Java
  + Spring boot
  + Postgresql
  + Java Message Service

# Executando o projeto
  + [Heroku](https://sicredi-pauta.herokuapp.com/v1/swagger-ui/index.html?configUrl=/v1/v3/api-docs/swagger-config)
