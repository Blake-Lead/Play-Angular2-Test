#!/bin/bash

echo -e "\n==========> Stopping containers...\n"
docker stop mytoolbox_ui_1
docker stop mytoolbox_wiki_1
docker stop mytoolbox_ipbase_1
docker stop mytoolbox_db_1
docker stop registrator
docker stop haproxy
docker stop consul

echo -e "\n==========> Deleting containers...\n"
docker rm -f mytoolbox_ui_1
docker rm -f mytoolbox_wiki_1
docker rm -f mytoolbox_ipbase_1
docker rm -f mytoolbox_db_1
docker rm -f registrator
docker rm -f haproxy
docker rm -f consul

echo -e "\n==========> Deleting images...\n"
docker rmi mytoolbox/ui
docker rmi mytoolbox/wiki
docker rmi mytoolbox/ipbase
docker rmi mytoolbox/postgres
docker rmi haproxy-consultemplate