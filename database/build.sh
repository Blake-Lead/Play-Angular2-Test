#!/bin/bash

docker build -t afpa_db .

docker run -d --name afpa_db1 -p 5432:5432 afpa_db
