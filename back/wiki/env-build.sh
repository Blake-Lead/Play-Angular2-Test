#!/bin/bash

# extract app arguments from container environment variables

appprefix="APP_VARS="

OLDIFS=$IFS

IFS='
'
arguments=""
for item in `env`; do
  if [[ $item == $appprefix* ]]; then
    part=`echo $item | sed "s/^$appprefix//"`
    arguments+="$part"
  fi
done

IFS=$OLDIFS

# launch app with app and jvm arguments
/opt/docker/bin/$1 $arguments
