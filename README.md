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
 
        "firstName": "Goutham",
        "middleName": "middleName",
        "lastName": "Kunduru",
        "age": 27,
        "gender": "M",
        "phone": 6145863720,
        "zip": "43402"
        }

2- Get: http://localhost:8080/getallusers
3-PUT: http://localhost:8080/updateuser
 
    { 
 
	 "id": "d2a9866d-ce13-48e3-a8e8-fcd5b374f9e9",
        "firstName": "Gouthamupdate",
        "middleName": "middleName",
        "lastName": "Kunduru",
        "age": 27,
        "gender": "M",
        "phone": 6145863720,
        "zip": "43402"
}


3- Get:
http://localhost:8080/getallusers
