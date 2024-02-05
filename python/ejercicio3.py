# Ejercicio 3
while True:
    print("1. Opción 1")
    print("2. Opción 2")
    print("3. Salir")
    
    opcion = int(input("Selecciona una opción: "))
    
    if opcion == 1:
        print("Realizando tarea de la Opción 1")
    elif opcion == 2:
        print("Realizando tarea de la Opción 2")
    elif opcion == 3:
        print("Saliendo del programa")
        break
    else:
        print("Opción no válida. Inténtalo de nuevo.")

