#!/bin/bash

COMMAND="java -jar ../order-service/build/libs/order-service.jar"
PORTS=(8020)

for PORT in "${PORTS[@]}"; do
    $COMMAND --server.port=$PORT &
    echo "Ecommerce orders service - Instance $PORT"
done
