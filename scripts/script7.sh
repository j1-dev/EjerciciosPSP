#!/bin/bash

# Función para realizar la suma
function suma {
    resultado=$(($1 + $2))
    echo "La suma de $1 y $2 es: $resultado"
}

# Función para realizar la resta
function resta {
    resultado=$(($1 - $2))
    echo "La resta de $1 y $2 es: $resultado"
}

# Función para realizar el producto
function producto {
    resultado=$(($1 * $2))
    echo "El producto de $1 y $2 es: $resultado"
}

# Función para realizar la división
function division {
    if [ $2 -eq 0 ]; then
        echo "Error: No se puede dividir por cero."
    else
        resultado=$(($1 / $2))
        echo "La división de $1 entre $2 es: $resultado"
    fi
}

# Menú principal
while true; do
    echo "Seleccione una opción:"
    echo "1. Suma"
    echo "2. Resta"
    echo "3. Producto"
    echo "4. División"
    echo "5. Salir"
    read -p "Opción: " opcion

    case $opcion in
        1)
            read -p "Ingrese el primer número: " num1
            read -p "Ingrese el segundo número: " num2
            suma $num1 $num2
            ;;
        2)
            read -p "Ingrese el primer número: " num1
            read -p "Ingrese el segundo número: " num2
            resta $num1 $num2
            ;;
        3)
            read -p "Ingrese el primer número: " num1
            read -p "Ingrese el segundo número: " num2
            producto $num1 $num2
            ;;
        4)
            read -p "Ingrese el primer número: " num1
            read -p "Ingrese el segundo número: " num2
            division $num1 $num2
            ;;
        5)
            echo "¡Hasta luego!"
            exit 0
            ;;
        *)
            echo "Opción no válida. Por favor, seleccione una opción del 1 al 5."
            ;;
    esac
done
