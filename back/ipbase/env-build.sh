#!/bin/bash

postgrePrefix="JDBC_DATABASE_URL"
cryptoPrefix="PLAY_CRYPTO_SECRET"

OLDIFS=$IFS

IFS='
'
postgre=""
crypto=""
for item in `env`; do
  if [[ $item == $postgrePrefix* ]]; then
    postgre=`echo $item | sed "s|^$postgrePrefix|-Ddb.default.url|"`
  elif [[ $item == $cryptoPrefix* ]]; then
    crypto=`echo $item | sed "s|^$cryptoPrefix|-Dplay.crypto.secret|"`
  fi
done

IFS=$OLDIFS

# launch app with app arguments
/opt/docker/bin/$1 $postgre $crypto
