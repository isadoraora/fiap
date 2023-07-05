# Alura - Tech Challenge Fase I

## Resumo:
Este projeto implementa o desenvolvimento de um sistema WEB com interfaces e APIs para:
- Gestão de pessoas que tenham relação com os clientes. 
- Cadastro dos endereços dos clientes, nos quais estarão os nossos adaptadores. 
- Gestão de eletrodométicos para informações relacionadas aos eletrodomésticos de cada cliente. 

## Descrição dos Endpoints da API

### Cadastro de pessoas

- Endpoint: `POST localhost:8080/power_tracker/people`
- Descrição: Este endpoint é usado para cadastrar novas pessoas.
- Exemplo de entrada:
    ```json
    {
        "name": "Isadora",
        "cpf": "39946083094",
        "birthday": "26/01/1989",
        "gender": "female",
        "relation": "daughter",
        "liveTogether": false
    }
    ```
- Resposta: Retorna uma mensagem de confirmação com o nome da pessoa se o cadastro foi bem-sucedido.

### Cadastro de endereços

- Endpoint: `POST localhost:8080/power_tracker/address`
- Descrição: Este endpoint é usado para cadastrar novos endereços.
- Exemplo de entrada:
    ```json
    {
        "street": "9 drive st",
        "number": 702,
        "neighbourhood": "Silbury",
        "city": "Milton Keynes",
        "state": "Buckinghamshire"
    }
    ```
- Resposta: Retorna uma mensagem de confirmação se o cadastro do endereço foi bem-sucedido.

### Cadastro de eletrodomésticos

- Endpoint: `POST localhost:8080/power_tracker/appliance`
- Descrição: Este endpoint é usado para cadastrar novos eletrodomésticos.
- Exemplo de entrada:
    ```json
    {
        "name": "Oven",
        "model": "Phillips-24636837R",
        "wattage": 900,
        "voltage": "220V"
    }
    ```
- Resposta: Retorna uma mensagem de confirmação se o cadastro do eletrodoméstico foi bem-sucedido.

## Requisitos
* JDK 17+
* Maven
* JMapper 1+
* Spring Web

## Testes

## Desenvolvedora
* Isadora Mendonça de Oliveira [isadora.mendonca@mercadolivre.com](mailto:isadora.mendonca@mercadolivre.com)
