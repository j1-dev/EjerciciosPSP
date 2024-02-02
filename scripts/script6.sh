#!/bin/bash

if [ "$#" -ne 2 ]; then
    echo "Error: Por favor, proporciona exactamente dos números como parámetros."
    exit 1
fi

# Función para calcular la potencia de un número
base=$1
exponente=$2
resultado=1

for (( i=1; i<=$exponente; i++ )); do
    resultado=$((resultado * base))
done

echo "El resultado de $base elevado a la $exponente es: $resultado"

