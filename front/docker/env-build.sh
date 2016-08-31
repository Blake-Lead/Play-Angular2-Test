#!/bin/bash

sed -i "s|WIKI_URL|${WIKI_URL}|g" /etc/nginx/nginx.conf
sed -i "s|IPBASE_URL|${IPBASE_URL}|g" /etc/nginx/nginx.conf

nginx -g "daemon off;"