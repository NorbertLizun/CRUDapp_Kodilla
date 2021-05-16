#!/usr/bin/env bash


runcrud()
{
  /Users/norbert/Desktop/Projects/CRUDapp_Kodilla/runcrud.sh
}


openLocalhostInChrome()
{
  open -a /Applications/Chrome.app http://localhost:8080/crud/v1/task/getTasks
}


fail()
{
   echo "There were errors"
}


if runcrud; then
  openLocalhostInChrome
else
  fail
fi



