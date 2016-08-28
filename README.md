# MY TOOLBOX

## What it is

**my-toolbox** is a project developed for my certification at AFPA.
It consists of 4 Docker containers :
- PostgreSQL database
- 2 Play APIs
- UI served by Nginx

## Prerequisites

All developement is done in a Linux Ubuntu environment. The following documentation assumes you also are on a Linux machine in order to build & deploy the project.

You must have **docker** & **docker-compose** installed to create the database, **sbt** to build the APIs, **node** (>= 4) & **npm** (>= 3) to build the UI. **make** is also needed, but should already be installed.

## Deploy


To deploy and run all project:

```
make runAll
```

This command runs all the commands below so it is not necessary to execute them unless you know what you do.

***

It is also possible to build front & create Dockerfiles for APIs:

```
make build
```

create Docker images:

```
make images
```

and run containers:

```
make run
```

***

It is possible to create a specific image if needed:

```
docker-compose -f docker-compose.build.yml build <db, wiki, ipbase, or ui>
```

This applies to running containers:

```
docker-compose up -d <db, wiki, ipbase or ui>
```


Of course, you can build & run each application independently, but it could mean changing some parts of the code. If you have questions about that, feel free to ask.