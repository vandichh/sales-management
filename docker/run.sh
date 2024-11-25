#!/bin/bash

echo "Building modules..."
cd ../ || exit 1
mvn clean package -DskipTests || exit 1

echo "Starting Docker containers..."
docker-compose up -d --build
