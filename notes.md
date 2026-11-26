so here i'll be writing all the pain points that i encounter and how i delt with it along the way.... there were several concepts that i didn't knew and also i've recently switched to debian so it's more troublesome to fix anything....

--------------- Folder structure pain -----------------------

Trust me guys setting up any project is much much more difficult than writing lines of code, curating all the dependencies and aligning it. it's a tidious task no doubt about it...

let me tell you how this project has been structured .....

parent_folder
|
|---service1
|
|---service2
|
|---service3
|.......
|....
|
|----docker-compose.yml --> this is the parent docker-compose
|
|----pom.xml --> it has the type POM rather than JAR which tells compiler that this is the project that you need to execute and not the JAR one.

each services have their own pom.xml and they contain dependencies , version etc of that project but all the services have JAR type as their packaging...

All the services are actually child projects of parent project so how the relationship has been defined ??!!

it's defined via <parent> </parent> component inside each of the child project's pom.xml we define **groupId** and **artifactId** of the parent and give <relativePath>../pom.xml</relativePath> as the path of the parent project's pom.xml.

------------------------ Development Learning -------------------

1. i didn't have sql or redis or kafka on my local machine and i had never used them before so i was confused like how to do the connection and how to install it in local ?

But then i realized the power of services that runs in containers even though i won't upload it on cloud most probably , but then what's the harm of struggling right now ??!!

2. what the heck is groupId and how is it worth it ??!!

I got to know very soon while i was building this project because i had to make multiple services with their seperate respective db and they all need to by connected

3. lombok -->
   jakarta -->
   hibernate -->
   validation -->

4. ResponseEntity<T> --> this is a class of a Spring that gives full control on Http response so whenever we return from controller we can return status, header and body

status --> http status code

header --> content-type, location, custom header etc..

body --> The actual response of payload (Your DTO, String, etc..)

----> why not just return the object directly ??!! because spring always set the status code as 201 ok, and ResponseEntity give us the flexibility to return whatever we want as a status code, header and body.

5.
