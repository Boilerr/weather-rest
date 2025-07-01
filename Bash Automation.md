# Bash Automation

This file formatted in IDEA style run script, try open it in IntelliJ IDEA  
Works from file and markdown rendering with good look


GET
----------------------------------------

## getAllWeatherWithPageable

- GET with Page Number:2 and Page Size: 2

```shell
curl -v -H "Accept: application/json" 'http://localhost:8080/api/v1/weather?page=2&size=2' | json_pp
```

- Test Exception with GET with Page Number:99 and Page Size: 20

```shell
curl -v -H "Accept: application/json" 'http://localhost:8080/api/v1/weather?page=99&size=20'
```

## getAllWeatherWithPageableAndSorting

- GET with `Page Number:5` and `Page Size: 5` and `Sort by column: city` and `Sort Order: ascending`(false=descending)

```shell
curl -v -H "Accept: application/json" 'http://localhost:8080/api/v1/weather?page=5&size=5&sort=city&order=true' | json_pp
```

## getOneWeatherById

- GET with id = 23

```shell
curl -v -H "Accept: application/json" 'http://localhost:8080/api/v1/weather/23' | json_pp
```

POST
----------------------------------------

## saveNewWeather

```shell
curl -X POST localhost:8080/api/v1/weather -H 'Content-Type: application/json' -d '{"date":"1985-01-01","lat":36.1189,"lon":-86.6892,"city":"Nashville","state":"Tennessee","temperatures":[17.3,16.8,16.4,16.0,15.6,15.3,15.0,14.9,15.8,18.0,20.2,22.3,23.8,24.9,25.5,25.7,24.9,23.0,21.7,20.8,29.9,29.2,28.6,28.1]}'
```

```shell
curl -vX POST http://localhost:8080/api/v1/weather -H 'Content-Type: application/json' -H "Accept: application/json" -d '{"date":"1985-01-01","lat":36.1189,"lon":-86.6892,"city":"ntgvuawjar","state":"eakkqhssvz","temperatures":[17.3,16.8,16.4,16.0,15.6,15.3,15.0,14.9,15.8,18.0,20.2,22.3,23.8,24.9,25.5,25.7,24.9,23.0,21.7,20.8,29.9,29.2,28.6,28.1]}'
```

- Other

```shell
curl -X POST localhost:8080/api/v1/weather
```

- POST with `-H` one header and data `-d` in body

```shell
curl -X POST localhost:8080/api/v1/weather -H 'Content-type:application/json' -d '{"name": "String", "role": "String"}'
```

PUT
----------------------------------------

## putWeather

- PUT by id

```shell
curl -X PUT localhost:8080/api/v1/weather -H 'Content-type:application/json' -d '{"name": "String", "role": "String"}'
```

- data from file and PUT method

```shell
curl -X PUT http://localhost:8080/api/v1/weather -H 'Content-Type: application/json' -d @request.json  
```

DELETE
----------------------------------------

## deleteOneWeatherById

DELETE `/weather/id`:

```shell
curl -vX DELETE localhost:8080/api/v1/weather/3 | json_pp
```

