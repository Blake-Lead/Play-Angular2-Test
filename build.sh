#!/bin/bash

echo -e "\n==========> Building front...\n"
cd front && rm -rf dist node_modules typings && npm install && typings install && tsd install marked && npm run tsc && cd ..

echo -e "\n==========> Creating wiki Dockerfile...\n"
cd back/wiki && sbt docker:stage

echo -e "\n==========> Creating ipbase Dockerfile...\n"
cd ../ipbase && sbt docker:stage