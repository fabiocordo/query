# query
java console tool which uses 2 different public websites API to retrieve informations about a given movie.

Java 8, Spring Boot, Maven

# Used API

OMDBAPI - https://www.themoviedb.org/documentation/apiMOV 

MOVIEDB - http://www.omdbapi.com/

API OMDBAPI is using "RestTemplate" and API MOVIEDB is using "HttpURLConnection".


# Samples Command line

java -jar -api MOVIEDB -movie "Indiana Jones" query.jar

java -jar -api OMDBAPI -movie "Matrix" query.jar


