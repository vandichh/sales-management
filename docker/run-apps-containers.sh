#!/bin/bash

echo "Building modules..."
cd ../ || exit 1
mvn clean package -DskipTests || exit 1

echo "Starting Apps containers..."
docker-compose -f docker-compose-apps.yml up -d --build
