# REST API para o projeto do PAC (Terceiro semestre)

### Tecnologias:

- `SpringBoot v2.4.5`
- `MySQL 8`
- `JDK 15.0.2`

Nota: Lembre-se de importar como `Maven Project`

###Rotas:

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
Path: /delete/{id}
Method: DELETE
----------------------
Path: /name/{userName}
Method: GET
----------------------
Path: /{id}
Method: GET
```
    