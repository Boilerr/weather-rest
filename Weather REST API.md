# Weather REST API
This REST manage weather data in this format 
## Weather data
Each object describe hourly temperatures recorded at a given location on a given date

- id: the unique integer
- date: the date of the record, in YYYY-MM-DD format,
- lat: the latitude of the record
- lon: the longitude of the record
- city: the name of the city of the record
- state: the name of the state of the record
- temperatures: an array of 24 float values, in Celsius

### Example
```json
{
   "id": 1, 
   "date": "1935-02-04",
   "lat": 56.6178,
   "lon": -46.6692,
   "city": "Nashville",
   "state": "Tennessee",
   "temperatures": [15.3, 13.8, 14.4, 15.0, 16.6, 17.3, 18.0, 14.9, 15.8, 18.0, 20.2, 22.3, 23.8, 24.9, 25.5, 25.7, 24.9, 23.0, 21.7, 20.8, 29.9, 29.2, 28.6, 28.1]
}
```

## Endpoints

## POST request to `/weather`:
- Crates a new weather data record
- the response code is 201, and the response body is the created record, including its unique id


## GET request to `/weather`:
- Get weather data with response code is 200, the response body is an array of records, ordered by their ids in increasing order
- accepts an optional query string parameter, 
    - `date`, for example `/weather/?date=2014-06-11`, only the records with the matching date are returned.
    - `city`,for example `/weather/?city=London`, only the records with the matching city are returned. It might contain several values, e.g., `city=london,Moscow`, meaning that records with a city matching any of these values must be returned.
    - `sort`, either "date" or "-date", for example `/weather/?sort=-date.` If the value is "date", then the ordering is by date in ascending order.If it is "-date", then the ordering is by date in descending order.If there are two records with the same date, the one with the smaller id must come first.


## GET request to `/weather/id`:
- Get record with the given id
- if the matching record exists, the response code is 200 and the response body is the matching object
- if there is no record in the collection with the given id, the response code is 404


## DELETE request to `/weather/<id>`:
- Deletes the record with the given id from the database and return status code 200
- if there was no record in the database with the given id, the response code is 404