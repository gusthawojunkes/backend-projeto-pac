<h1 align="center">
REST API para o projeto do PAC (Terceiro semestre) :chess_pawn:
</h1>

<p align="center">
<b>Tecnologias</b> |
<b>Como executar</b> |
<b>Rotas</b> |
<b>Formatação</b>
</p>

### Tecnologias:

- `SpringBoot v2.4.5`
- `MySQL 8`
- `JDK 15.0.2`
- `Java 11`

### Passos para rodar a aplicação:
1. Clonar o projeto
2. Importar em uma IDE (Eclipse, IntelliJ, etc.) como um `Maven Project`
3. Instalar plugins necessários compatíveis com o SpringBoot (Spring Tools 4 no caso do Eclipse)
4. Criar base de dados chamada `pac` |
``CREATE DATABASE pac CHARACTER SET utf8 COLLATE utf8_general_ci;``
5. Subir uma instância do banco de dados criado
6. Subir a aplicação pela IDE via plugin ou linha de comando segundo a documentação oficial [https://spring.io/quickstart]

### Rotas:

```
LoginController: /login
---------------------- 
Path: /login
Method: POST
Consumes: application/json
Produces: application/json
```
```
UserController: /users
---------------------- 
Path: /create 
Method: POST
Consumes: application/json
Expected (example):

/*
    name: VARCHAR(70)
    email: VARCHAR(100)
    userName: VARCHAR(255)
    password: VARCHAR(50)
    phone: VARCHAR(20)
    flagMaster: INT(1)
    userToken: VARCHAR(255)
    points: INT(3)
    extraTime: INT(3)
    birth: VARCHAR(10)
    group.name: VARCHAR(30)
    group.description: VARCHAR(100)
    group.permission.code: VARCHAR(255)
    group.permission.description: VARCHAR(255)
    group.permission.viewChallenges: INT(1)
    group.permission.viewRanking: INT(1)
    group.permission.viewReports: INT(1)
    group.permission.viewConfig: INT(1)
    group.action.confChallenges: INT(1)
    group.action.playChallenges: INT(1)
    group.action.confUsers: INT(1)
    group.action.viewUsers: INT(1)
    group.action.confGroups: INT(1)
    group.action.viewGroups: INT(1)
    address.city: VARCHAR(60)
    address.uf.uf: VARCHAR(2)
    address.uf.name: VARCHAR(30)
    
*/

{
   "name": "Root User",
   "email": "root@system.com",
   "userName": "root",
   "password": "root",
   "phone": "(99) 99876-5432",
   "flagMaster" : 1,
   "userToken": "AAABBBCCC",
   "points": 999,
   "extraTime": 999,
   "birth": "17/10/2002",
   "group": {
      "name": "Root",
      "description": "Root",
      "permission": {
         "code": "1",
         "description": "Root",
         "viewChallenges": 1,
         "viewRanking": 1,
         "viewReports": 1,
         "viewConfig": 1
      },
      "action": {
         "confChallenges": 1,
         "playChallenges": 1,
         "confUsers": 1,
         "viewUsers": 1,
         "confGroups": 1,
         "viewGroups": 1
      }
   },
   "address": {
      "city": "City",
      "uf": {
         "uf": "UF",
         "name": "UF name"
      }
   }
}

---------------------- 
Path: /update
Method: POST
Consumes: application/json
----------------------
Path: /delete/{id}
Method: DELETE
----------------------
Path: /name/{userName}
Method: GET
----------------------
Path: /{id}
Method: GET
Produces: application/json
----------------------
Path: /ranking
Method: GET
Produces: application/json
```
```
QuestionController: /questions
---------------------- 
Path: /create
Method: POST
Consumes: application/json
Expected (example): 

/*
    title: VARCHAR(50)
    description: VARCHAR(255)
    level: INT(1)
    correctResponse: CHAR
    alternatives.option: CHAR
    alternatives.description: VARCHAR(255)
*/

{
    "title": "Questão 1", 
    "description": "1 + 1", 
    "level": 1, 
    "correctResponse": "A", 
    "alternatives": [
        {
            "option": "A", 
            "description": "2" 
        },
        {
            "option": "B",
            "description": "3"
        },
        {
            "option": "C",
            "description": "4"
        },
        {
            "option": "D",
            "description": "5"
        },
        {
            "option": "E",
            "description": "6"
        }
    ]
}
----------------------
Path: /update
Method: POST
Consumes: application/json
Produces: application/json
Expected (example): Same of /create but with ID
----------------------
Path: /delete/{id}
Method: DELETE
Parameters: Question ID INT(1)
----------------------
Path: /{id}
Method: GET
Parameters: Question ID INT(1)
Produces: application/json
----------------------
Path: /level/{level}
Method: GET
Parameters: Level INT(1)
Produces: application/json
----------------------
Path: /{student}/{level}
Method: GET
Parameters: Level INT(1), Student Long (Student ID)
Produces: application/json

```
```
UserGroupController: /groups
---------------------- 
Path: /create 
Method: POST
Consumes: application/json
Expected (example):

/*
    name: VARCHAR(30)
    description: VARCHAR(100)
    permission.code: VARCHAR(255)
    permission.description: VARCHAR(255)
    permission.viewChallenges: INT(1)
    permission.viewRanking: INT(1)
    permission.viewReports: INT(1)
    permission.viewConfig: INT(1)
    action.confChallenges: INT(1)
    action.playChallenges: INT(1)
    action.confUsers: INT(1)
    action.viewUsers: INT(1)
    action.confGroups: INT(1)
    action.viewGroups: INT(1)
*/

{
    "name": "Dev",
    "description": "Developers",
    "permission": {
        "viewChallenges": 1,
        "viewRanking": 1,
        "viewReports": 1,
        "viewConfig": 1
    },
    "action": {
        "confChallenges": 1,
        "playChallenges": 1,
        "confUsers": 1,
        "viewUsers": 1,
        "confGroups": 1,
        "viewGroups": 1
    }
}
---------------------- 
Path: /delete/{id} 
Method: DELETE
```

### Formatação

Formatação da data: `dd/MM/yyyy`
