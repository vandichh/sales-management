#!/bin/bash

echo "Building modules..."
cd ../ || exit 1
mvn clean package -DskipTests || exit 1

echo "Starting All containers..."
docker-compose -f docker-compose-apps.yml -f docker-compose-infra.yml up -d --build
