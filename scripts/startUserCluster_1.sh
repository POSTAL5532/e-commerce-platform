#!/bin/bash

COMMAND="java -jar ../user-service/build/libs/user-service.jar"
PORTS=(8010)

for PORT in "${PORTS[@]}"; do
    $COMMAND --server.port=$PORT &
    echo "Ecommerce users service - Instance $PORT"
done