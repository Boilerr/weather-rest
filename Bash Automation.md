# Bash Automation

This file formatted in IDEA style run script


## GET
----------------------------------------
```shell
curl http://localhost:8080/weather/43 | json_pp
```

```shell
curl -v http://localhost:8080/weather/55
```

```shell
curl -v -H "Accept: application/json" http://localhost:8080/weather
```

```shell
curl -vH "Accept: application/json" http://localhost:8080/weather/4
```

```shell
curl -H "Accept: application/json" http://localhost:8080/weather/18 | json_pp
```

```shell
curl --no-progress-meter -H "Accept: application/json" http://localhost:8080/weather/185 | json_pp
```

```shell
## data from file and two Headers
curl -d @request.json -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/weather
```


## POST
----------------------------------------
```shell
curl -X POST localhost:8080/weather
```  

```shell
# POST with body
curl -X POST localhost:8080/weather -H 'Content-type:application/json' -d '{"name": "String", "role": "String"}'
```

```shell
curl -X POST localhost:8080/weather -H 'Content-Type: application/json' -d '{"date":"1985-01-01","lat":36.1189,"lon":-86.6892,"city":"Nashville","state":"Tennessee","temperatures":[17.3,16.8,16.4,16.0,15.6,15.3,15.0,14.9,15.8,18.0,20.2,22.3,23.8,24.9,25.5,25.7,24.9,23.0,21.7,20.8,29.9,29.2,28.6,28.1]}'
```

```shell
curl -vX POST http://localhost:8080/weather -H 'Content-Type: application/json' -H "Accept: application/json" -d '{"date":"1985-01-01","lat":36.1189,"lon":-86.6892,"city":"ntgvuawjar","state":"eakkqhssvz","temperatures":[17.3,16.8,16.4,16.0,15.6,15.3,15.0,14.9,15.8,18.0,20.2,22.3,23.8,24.9,25.5,25.7,24.9,23.0,21.7,20.8,29.9,29.2,28.6,28.1]}'
```


## PUT
----------------------------------------

```shell
# PUT with body
curl -X PUT localhost:8080/weather -H 'Content-type:application/json' -d '{"name": "String", "role": "String"}'
```

```shell
## data from file and PUT method
curl -d @request.json -H 'Content-Type: application/json' -X PUT http://localhost:8080/weather
```


## DELETE
----------------------------------------
```shell
curl -vX DELETE localhost:8080/weather/3 | json_pp
```

```shell
curl -vX DELETE localhost:8080/weather/4
````

```shell
curl -vX DELETE localhost:8080/weather?city=Houston
````

```shell
curl -vX DELETE localhost:8080/weather?state=California
````



## Prettify json with json_pp

```shell
# GET weather and prettify with json_pp
curl -v localhost:8080/weather | json_pp
```

## curl parameters

-v, --verbose Make the operation more talkative

-d, --data <data>          HTTP POST data  
-f, --fail Fail silently (no output at all) on HTTP errors  
-i, --include Include protocol response headers in the output  
-o, --output <file>        Write to file instead of stdout. curl -o out.json http://www.example.com/index.html  
-O, --remote-name Write output to a file named as the remote file  
-s, --silent Silent mode  
-T, --upload-file <file>   Transfer local FILE to destination  
-u, --user <user:password> Server user and password  
-A, --user-agent <name>    Send User-Agent <name> to server

-H, --header <header/@file> Pass custom header(s) to server  
-X, --request <method> Change the method to use when starting the transfer. Without it GET  