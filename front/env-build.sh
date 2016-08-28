#!/bin/bash

wikiEnv="WIKI_URL="
ipbaseEnv="IPBASE_URL="
registryEnv="REGISTRY_URL="

OLDIFS=$IFS

IFS='
'
wikiurl=""
ipbaseurl=""
registryurl=""
for item in `env`; do
  if [[ $item == $wikiEnv* ]]; then
    wikiurl=`echo $item | sed "s/^$wikiEnv//"`
  elif [[ $item == $ipbaseEnv* ]]; then
    ipbaseurl=`echo $item | sed "s/^$ipbaseEnv//"`
  elif [[ $item == $registryEnv* ]]; then
    registryurl=`echo $item | sed "s/^$registryEnv//"`
  fi
done

IFS=$OLDIFS

sed -i "s/WIKI_URL/$wikiurl/" /etc/nginx/nginx.conf &&sed -i "s/IPBASE_URL/$ipbaseurl/" /etc/nginx/nginx.conf && sed -i "s/REGISTRY_URL/$registryurl/" /etc/nginx/nginx.conf && nginx -g "daemon off;"