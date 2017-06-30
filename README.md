# EgenCodingChallenge
# README #

Steps to execute project:

1-Clone the project
2-go to the Project root director where the pom.xml file is located, From cmd/terminal and run mvn jetty:run (make sure that you have maven installed).
3-open postman or any rest client app and make json requests.
OR Executing in Eclipse
1.Import the project in to the Project Explorer
2.Run as Maven build (In run configurations use the goals clean jetty:run)
3.open postman or any rest client app and make json requests
Example of json requests:

url : http://localhost:8080/createuser
1-POST:(Content-Type →application/json)

{    
    "id" : 1,
    "firstName": "firstName", 
    "middleName": "middleName",       
    "lastName" : "lastName",   
    "age" : 30,
    "gender" : "F",
    "phone" : 9545587457,
"zip":"zip"
}


http://localhost:8080/updateuser
2-PUT:
{    
    "id" : 1,
    "firstName": "firstNameupdate", 
    "lastName" : "lastName",   
    "age" : 20,
    "gender" : "M",
    "phone" : 9545587457,
"zip":"zip"
}

3- Get:
http://localhost:8080/getallusers
