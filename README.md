# demo-contacts-api
Contacts API Demo

Steps for running the application
1) clone the project
2) open terminal (or use IDE's built in terminal)
3) cd to the path of the project folder in your computer 
4) execute the following command "mvn clean install"
5) run the application

The application is deployed in heroku with the following url : https://airasia-demo-contacts-api.herokuapp.com

------------------------------------------------------------------------------------------------------------------------------------------------------
POST method
------------------------------------------------------------------------------------------------------------------------------------------------------
There are 2 endpoints for POST method : 
1) https://airasia-demo-contacts-api.herokuapp.com/people

Sample request body : 
{
	"name": "James",
	"age": "45",
	"height": "165.00"
}

This end point creates a "people" record in the database

------------------------------------------------------------------------------------------------------------------------------------------------------

2) https://airasia-demo-contacts-api.herokuapp.com/people/{people_id}/contacts

Sample request body : 
{
	"email": "james@gmail.com",
	"number": "0176646603"
}

This end point updates the contact of the "people"

------------------------------------------------------------------------------------------------------------------------------------------------------
GET method
------------------------------------------------------------------------------------------------------------------------------------------------------
There is 1 endpoint created for GET method :

https://airasia-demo-contacts-api.herokuapp.com/contacts?name=Mark Anthony&contact.email=haneef5244@gmail.com&contact.number=0176646603

This endpoint can be queried with the following query parameters:

1) name - e.g : https://airasia-demo-contacts-api.herokuapp.com/contacts?name=Mark Anthony
2) email - e.g : https://airasia-demo-contacts-api.herokuapp.com/contacts?contact.email=haneef5244@gmail.com
3) number - e.g : https://airasia-demo-contacts-api.herokuapp.com/contacts?contact.number=0176646603

Any combination of the above 3 query parameters works, an invalid query parameter will throw an error

Demo video

[![Watch the video](https://i.imgur.com/vKb2F1B.png)](https://youtu.be/_hsxirtlE14)

