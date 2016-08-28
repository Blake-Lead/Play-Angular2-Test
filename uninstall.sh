#!/bin/bash

echo && echo "==========> Stopping containers..."
docker stop mytoolbox_ui_1
docker stop mytoolbox_wiki_1
docker stop mytoolbox_ipbase_1
docker stop mytoolbox_db_1

echo && echo "==========> Deleting containers..."
docker rm -f mytoolbox_ui_1
docker rm -f mytoolbox_wiki_1
docker rm -f mytoolbox_ipbase_1
docker rm -f mytoolbox_db_1

echo && echo "==========> Deleting images..."
docker rmi mytoolbox/ui
docker rmi mytoolbox/wiki
docker rmi mytoolbox/ipbase
docker rmi mytoolbox/postgres
