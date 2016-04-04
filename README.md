# WeatherEmailer
Sends daily weather forecast emails

## Current features
* Hosted on Heroku
* Hard-code contacts in Main.java in the form "contacts.add(new Contact("example@email.com","AA112BB"));"
* Uses Postcodes.io to validate postcodes and lookup lat and long values
* Uses k-dimensional tree to map postcode to Met Office's list of weather stations
* Uses Met Office's weather API to weather data in JSON format
* Converts JSON data to AllForecasts object, which contains two ForecastDay objects, which contain, Forecast3Hr objects (which contain weather data for each 3-hour interval)
* Uses a hard-coded responsive HTML email, inserting in a table for each day and rows for each hour (based on number of intervals available)
* Uses Heroku Scheduler and SendGrid to send the emails at ~7.30am every day

## Planned features
* Remove hard-coded contacts and store them in a Heroku Postgres database
* Create webapp where users can sign up to the email service

## Tests
* To be added
