#!/bin/bash

COMMAND="java -jar ../catalog-service/build/libs/catalog-service.jar"
PORTS=(8040 8041 8042)

for PORT in "${PORTS[@]}"; do
    $COMMAND --server.port=$PORT &
    echo "Ecommerce catalog service - Instance $PORT"
done

wait
