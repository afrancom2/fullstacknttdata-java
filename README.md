# Hola a todos!👋
## Esta es la prueba con java - spring boot
### Curl para obtener los datos de prueba
```json
curl --location 'http://localhost:8090/api/23445322'
```

### JSON ejecutado de manera exitosa

```json
{
    "code": 200,
    "httpStatus": "OK",
    "message": "OK",
    "body": {
        "firstName": "andres",
        "secondName": "felipe",
        "firstLastName": "franco",
        "secondLastName": "monroy",
        "phone": 315466789,
        "address": "Calle 1 # 12",
        "city": "Bogota"
    }
}
```

### JSON si falla el servicio

```json
{
    "code": 400,
    "httpStatus": "BAD_REQUEST",
    "message": "BAD REQUEST - ID"
}
```