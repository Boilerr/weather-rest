# Bash Automation



## GET
```shell
curl -v http://localhost:8080/weather
```
```shell
curl localhost:8080/weather
```


## POST
```shell
curl -X POST localhost:8080/weather
```  
```shell
# POST with body
curl -X POST localhost:8080/weather -H 'Content-type:application/json' -d '{"name": "String", "role": "String"}'
```


## PUT
```shell
# PUT with body
curl -X PUT localhost:8080/weather -H 'Content-type:application/json' -d ''{"name": "String", "role": "String"}'
```


## DELETE
```shell
curl -X DELETE localhost:8080/employees/3
```



## Prettify json with json_pp
```shell
# GET weather and prettify with json_pp
curl -v localhost:8080/weather | json_pp
```