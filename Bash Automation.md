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