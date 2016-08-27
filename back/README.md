# SERVER SIDE OF *MY TOOLBOX*

## Prerequisites
You must have *docker* & *docker-compose* installed to create the database.
You must have sbt to compile **ipbase**.

## Database

To start the database, go to *database/* folder and do :

`./build.sh`

## Application

To run **ipbase**, type (replace localhost with database ip):

`sbt run -Ddb.postgresql.url="jdbc:postgresql://localhost:5432/ipbase"`

To create a local Docker image of **ipbase**, type :

`sbt docker:publishLocal`

Then create container with (replace localhost & secret) :

` docker run --name ipbase --env APP_VARS='-Ddb.postgresql.url="jdbc:postgresql://172.17.0.2:5432/ipbase" -Dplay.crypto.secret="QCY?tAnfk?aZ?iwrNwnxIlR6CTf:G3gf:90Latabg@5241AB/R5W:1uDFN];Ik@n"' ipbase:1.0-SNAPSHOT`

> TODO : Currently, the last command does not work when specifying -Ddb.postgresql.url. The Docker container crashes with error `java.lang.RuntimeException: Driver org.postgresql.Driver claims to not accept JDBC URL "jdbc:postgresql://172.17.0.2:5432/ipbase"`.