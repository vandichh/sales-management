#!/bin/bash

echo "Starting Infra containers..."
docker-compose -f docker-compose-infra.yml up -d
