#!/bin/bash

# Verificamos si se proporcionan dos parámetros
if [ "$#" -ne 2 ]; then
    echo "Error: Por favor, proporciona exactamente dos números como parámetros."
    exit 1
fi

# Verificamos si los parámetros son números
re='^[0-9]+$'
if ! [[ $1 =~ $re ]] || ! [[ $2 =~ $re ]]; then
    echo "Error: Ambos parámetros deben ser números enteros."
    exit 1
fi

# Almacenamos los números en variables
numero1="$1"
numero2="$2"

# Comparamos los números y mostramos el resultado
if [ "$numero1" -gt "$numero2" ]; then
    echo "$numero1 es mayor que $numero2."
elif [ "$numero1" -lt "$numero2" ]; then
    echo "$numero2 es mayor que $numero1."
else
    echo "Ambos números son iguales."
fi

