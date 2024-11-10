#!/bin/bash

COMMAND="java -jar ../inventory-service/build/libs/inventory-service.jar"
PORTS=(8030 8031)

for PORT in "${PORTS[@]}"; do
    $COMMAND --server.port=$PORT &
    echo "Ecommerce inventory service - Instance $PORT"
done
