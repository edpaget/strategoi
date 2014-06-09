#!/bin/bash
DATE=`date +"%Y%m%d%H%M%S"`
touch "migrations/${DATE}_${1}.up.sql"
touch "migrations/${DATE}_${1}.down.sql"
