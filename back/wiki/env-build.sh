#!/bin/bash

# when running the Docker container, APP_VARS environment variable
# will be defined  with arguments to pass to the Play application.
# this  script  extract APP_VARS  and give them  to the  wiki app.

prefix="APP_VARS="

OLDIFS=$IFS

IFS='
'
arguments=""
for item in `env`; do
  if [[ $item == $prefix* ]]; then
    arguments=`echo $item | sed "s/^$prefix//"`
  fi
done

IFS=$OLDIFS

# launch app with app arguments
/opt/docker/bin/$1 $arguments
