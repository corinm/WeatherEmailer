# WeatherEmailer
Sends daily weather forecast emails via Heroku

## Current features
* Accepts multiple contacts, allowing multiple postcodes per email address
* Weather forecast data obtained from the Met Office
* Sends a responsive HTML email at ~7.30am every day, which contains a table for 'today' and 'tomorrow' and a row for every 3-hour forecast interval
* Rows are colour coded to provide a quick overview of weather (e.g. bright yellow = sunny and warm, dark blue = heavy rain etc.)
* Data provided includes a description of the weather (e.g. "Cloudy"), actual temperature, 'feels like' temperature, chance of rain, wind speed and maximum wind speed (i.e. gusts)

## Examplanation of implementation
* Hosted on Heroku
* Hard-code contacts in Main.java in the form `contacts.add(new Contact("example@email.com","AA112BB"));`
* Uses Postcodes.io to validate postcodes and lookup lat and long values
* Uses k-dimensional tree to map postcodes to Met Office's 3,000 weather stations
* Uses Met Office's weather API to request weather data in JSON format
* Converts JSON data to AllForecasts object, which contains two ForecastDay objects, which contain multiple Forecast3Hr objects (which represent each 3-hour forecast interval)
* Uses a hard-coded responsive HTML email, inserts a table for each ForecastDay and a row for each Forecast3hr
* Uses Heroku Scheduler and SendGrid to send the emails at ~7.30am every day

## Planned changes
* Remove hard-coded contacts and store them in a Heroku Postgres database
* Create webapp where users can sign up to the email service

## Tests
* To be added