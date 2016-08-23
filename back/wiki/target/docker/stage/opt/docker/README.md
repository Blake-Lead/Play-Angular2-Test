# wiki

## Prerequisites
You must have *docker* & *docker-compose* installed to create the database.
You must have sbt to compile **wiki**.

## Database

To start the database, go to *database/* folder and type :
`./build.sh`

## Application

To run **wiki**, type (replace localhost according to database ip):
`sbt run -Ddb.postgresql.url="jdbc:postgresql://localhost:5432/wiki"`

To create a local Docker image of **wiki**, type :
`sbt docker:publishLocal`
Then run it with (replace localhost & secret) :
` docker run --name wiki --env APP_VARS='-Ddb.postgresql.url="jdbc:postgresql://172.17.0.2:5432/wiki" -Dplay.crypto.secret="QCY?tAnfk?aZ?iwrNwnxIlR6CTf:G3gf:90Latabg@5241AB/R5W:1uDFN];Ik@n"' wiki:1.0-SNAPSHOT`