#!/bin/bash

cd ../ || exit 1
echo "Shut down Infra containers..."
docker-compose -f docker-compose-infra.yml down

echo "Starting Infra containers..."
docker-compose -f docker-compose-infra.yml up -d
