#!/bin/bash

mostrar_procesos() {
    echo "Procesos activos en este momento:"
    ps aux
}

listar_hilos() {
    echo "Hilos de ejecución ligeros:"
    ps -eLf
}

identificar_terminal() {
    echo "Terminal utilizado:"
    tty
}

listar_servicios() {
    echo "Servicios activos en el sistema:"
    systemctl list-units --type=service
}

pid_script() {
    echo "PID del script actual:"
    echo "$$"
}

pid_programa() {
    read -p "Introduce el nombre del programa: " programa
    pid=$(pidof "$programa")
    if [ -z "$pid" ]; then
        echo "El programa $programa no está en ejecución."
    else
        echo "PID del programa $programa: $pid"
    fi
}

leer_archivo() {
    read -p "Introduce el nombre del archivo a leer: " archivo
    if [ ! -f "$archivo" ]; then
        echo "El archivo $archivo no existe."
    else
        echo "Contenido de $archivo:"
        cat "$archivo"
    fi
}

menu() {
    echo "Selecciona una opción:"
    echo "1. Mostrar procesos activos"
    echo "2. Listar hilos de ejecución ligeros"
    echo "3. Identificar el terminal"
    echo "4. Listar servicios activos"
    echo "5. PID del script actual"
    echo "6. PID de un programa"
    echo "7. Leer contenido de un archivo"
    echo "8. Salir"
}

while true; do
    menu
    read -p "Ingrese el número de la opción deseada: " opcion
    case $opcion in
        1) mostrar_procesos ;;
        2) listar_hilos ;;
        3) identificar_terminal ;;
        4) listar_servicios ;;
        5) pid_script ;;
        6) pid_programa ;;
        7) leer_archivo ;;
        8) echo "Saliendo del script. ¡Hasta luego!"; break ;;
        *) echo "Opción inválida. Por favor, elige una opción del 1 al 8." ;;
    esac
done
