#!/bin/bash

trap 'echo "Señal SIGINT (Ctrl+C) recibida. No se puede detener."' INT
trap 'echo "Señal SIGTERM recibida. No se puede detener."' TERM

echo "PID del script: $$"
echo "Inhibiendo las señales SIGINT y SIGTERM durante 40 segundos..."
sleep 40

# Restaurar el manejo predeterminado de las señales
trap - INT TERM

echo "Terminando el script normalmente."
