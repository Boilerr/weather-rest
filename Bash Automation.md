# Bash Automation



## GET
```shell
curl -v http://localhost:8080/weather
```
```shell
curl localhost:8080/weather
```
```shell
## data from file and two Headers
curl -d @request.json -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/weather
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
curl -X PUT localhost:8080/weather -H 'Content-type:application/json' -d '{"name": "String", "role": "String"}'
```
```shell
## data from file and PUT method
curl -d @request.json -H 'Content-Type: application/json' -X PUT http://localhost:8080/weather
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



## curl parameters
-v, --verbose              Make the operation more talkative

-d, --data <data>          HTTP POST data
-f, --fail                 Fail silently (no output at all) on HTTP errors
-i, --include              Include protocol response headers in the output
-o, --output <file>        Write to file instead of stdout. curl -o out.json http://www.example.com/index.html
-O, --remote-name          Write output to a file named as the remote file
-s, --silent               Silent mode
-T, --upload-file <file>   Transfer local FILE to destination
-u, --user <user:password> Server user and password
-A, --user-agent <name>    Send User-Agent <name> to server

-H, --header <header/@file> Pass custom header(s) to server
-X, --request <method> Change the method to use when starting the transfer. Without it GET