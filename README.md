# REST API para o projeto do PAC (Terceiro semestre)

### Tecnologias:

- `SpringBoot v2.4.5`
- `MySQL 8`
- `JDK 15.0.2`

Nota: Lembre-se de importar como `Maven Project`

```
Comando para criar o banco de dados:
-> CREATE DATABASE pac CHARACTER SET utf8 COLLATE utf8_general_ci;
```

### Rotas:

```
LoginController: /login
---------------------- 
Path: /login
Method: POST
Consumes: application/json
```
```
UserController: /users
---------------------- 
Path: /create
Method: POST
Consumes: application/json
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
```

### Cadastros no geral

Formatação da data: `dd/MM/yyyy`
