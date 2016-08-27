# MY TOOLBOX

## What it is

**my-toolbox** is a project developed for my certification at AFPA.
It consists of 4 Docker containers :
- PostgreSQL database
- 2 Play APIs
- UI served by Nginx

## Prerequisites

All developement is done in a Linux Ubuntu environment. The following documentation assumes you also are on a Linux machine in order to build & run the project.

You must have **docker** & **docker-compose** installed to create the database, **sbt** to build the APIs, **node** (>= 4) & **npm** (>= 3) to build the UI.

## Database

To start the database, go to *database/* folder and do :

`./build.sh`

## APIs

To run an API without **Docker**:

`sbt run -Ddb.postgresql.url="jdbc:postgresql://<host>:5432/<database>"`

To create a **Docker** image an API :

`sbt docker:publishLocal`

then :

` docker run --name <container_name> --env APP_VARS='-Ddb.postgresql.url="jdbc:postgresql://<host>:5432/<database>" -Dplay.crypto.secret="QCY?tAnfk?aZ?iwrNwnxIlR6CTf:G3gf:90Latabg@5241AB/R5W:1uDFN];Ik@n"' <api_docker_image>`

> TODO : Currently, the last command does not work when specifying -Ddb.postgresql.url. The Docker container crashes with error `java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept JDBC URL "jdbc:postgresql://172.17.0.2:5432/ipbase"`.

## UI

Install dependencies :

`npm install`

Run server & app :

`npm start`

If you run into troubles concerning **marked** plugin, run this line :

`typings install && tsd install marked`

To dockerise the UI :