#!/usr/bin/env bash
mvn clean package #java package
#docker image build -t jakarta-project:latest . #build the image
#docker container run jakarta-project:latest #execute as container
cd docker && docker-compose up --build