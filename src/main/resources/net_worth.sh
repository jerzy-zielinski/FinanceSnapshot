#!/bin/bash
date "+%A %B %d %T %Y"
full_path=$(realpath $0)
dir_path=$(dirname $full_path)
java -jar $dir_path/../FinanceSnapshot-0.0.1-SNAPSHOT.jar
