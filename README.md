# Treinamento MongoDB

Criação de uma API de posts e comentários utilizando o banco de dados NoSQL MongoDB

## Endpoints


### `GET /users` 
- retorna todos os usuários cadastrados

```json
[
    {
        "id": "602920918ce6e11763a21db9",
        "nome": "Maria",
        "email": "maria@gmail.com"
    },
    {
        "id": "602920918ce6e11763a21dba",
        "nome": "João",
        "email": "Joao@gmail.com"
    },
    {
        "id": "602920918ce6e11763a21dbb",
        "nome": "Ray",
        "email": "ray@gmail.com"
    }
]
```

### ` GET /users/{id}/posts ` 
- retorna todos os posts de um usuário

```json
[
    {
        "id": "602920918ce6e11763a21dbc",
        "date": "2021-02-13T00:00:00.000+00:00",
        "title": "EAE!",
        "body": "ovo viajar amanhã, tmj?",
        "author": {
            "id": "602920918ce6e11763a21db9",
            "nome": "Maria"
        },
        "comments": [
            {
                "text": "nas horas, boa viagem!",
                "date": "2021-02-13T00:00:00.000+00:00",
                "author": {
                    "id": "602920918ce6e11763a21dba",
                    "nome": "João"
                }
            },
            {
                "text": "obrigada",
                "date": "2021-02-13T00:00:00.000+00:00",
                "author": {
                    "id": "602920918ce6e11763a21db9",
                    "nome": "Maria"
                }
            }
        ]
    }
]
```

### ` GET /posts/titlesearch?text=` 
- busca e retorna todos os post que possuírem no __Título__ o mesmo texto do parametro `text`

`text=bom%20dia` returns:

```json
[
    {
        "id": "602920918ce6e11763a21dbc",
        "date": "2021-02-13T00:00:00.000+00:00",
        "title": "Bom dia!",
        "body": "Um ótimo dia a todos :)",
        "author": {
            "id": "602920918ce6e11763a21db9",
            "nome": "Maria"
        }, "comments": [
            {
                "text": "Está um lindo dia ^^/",
                "date": "2021-02-13T00:00:00.000+00:00",
                "author": {
                    "id": "602920918ce6e11763a21dba",
                    "nome": "João"
                }
            }
        ]
    }
]

```

### ` GET /posts/fullsearch?text=&minDate=&maxDate=` 
 busca e retorna os posts que possuírem no __Título, Corpo ou Comentário__ o texto do parametro `text` e entre as datas `minDate` e `maxDate`

`text=ola`
&
`minDate=2021/02/10`
&
`maxDate=2021/02/15` returns:

```json
[
    {
        "id": "602920918ce6e11763a21dbc",
        "date": "2021-02-13T00:00:00.000+00:00",
        "title": "....",
        "body": "...",
        "author": {
            "id": "602920918ce6e11763a21db9",
            "nome": "João"
        }, "comments": [
            {
                "text": "OLA, João, então...",
                "date": "2021-02-13T00:00:00.000+00:00",
                "author": {
                    "id": "602920918ce6e11763a21dba",
                    "nome": "Maria"
                }
            }
        ]
    }
]

```

### Outros

### ` POST: /users ` 
- cadastra um usuário


### ` GET: /users/{id} ` 
- retorna o usuário com o id passado


### ` GET: /post/{id} ` 
- retorna o post e comentários com o id  do post passado


### ` DELETE: /users/{id} ` 
- deleta o usuário com o id passado


### ` PUT: /users/{id} ` 
- edita o usuário com o id passado

### Mensagem genérica caso id não exista 
![not_found](https://github.com/Rayllanderson/assets/blob/master/workshop-mongodb/not_found.png)

