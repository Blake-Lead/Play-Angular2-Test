#!/bin/bash

echo && echo "==========> Building front"
cd front && npm install && typings install && tsd install marked && npm run tsc && cd ..

echo && echo "==========> Creating wiki Dockerfile"
cd back/wiki && sbt docker:stage

echo && echo "==========> Creating ipbase Dockerfile"
cd ../ipbase && sbt docker:stage