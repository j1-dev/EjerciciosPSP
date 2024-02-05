# Ejercicio 4
def LongitudPila(pila):
    return len(pila)

def EstaVaciaPila(pila):
    return len(pila) == 0

def EstaLlenaPila(pila, max_tamano):
    return len(pila) == max_tamano

def AddPila(elemento, pila, max_tamano):
    if not EstaLlenaPila(pila, max_tamano):
        pila.append(elemento)
        print(f"Elemento '{elemento}' añadido a la pila.")
    else:
        print("La pila está llena. No se puede añadir.")

def SacarDeLaPila(pila):
    if not EstaVaciaPila(pila):
        elemento = pila.pop()
        print(f"Elemento '{elemento}' sacado de la pila.")
    else:
        print("La pila está vacía. No se puede sacar.")

def EscribirPila(pila):
    print("Elementos en la pila:")
    for elemento in pila:
        print(elemento)

# Programa principal
pila_usuarios = []
max_tamano_pila = 5

while True:
    print("\n1. Añadir elemento a la pila")
    print("2. Sacar elemento de la pila")
    print("3. Longitud de la pila")
    print("4. Mostrar pila")
    print("5. Salir")

    opcion = int(input("Selecciona una opción: "))

    if opcion == 1:
        nombre_usuario = input("Introduce el nombre de usuario: ")
        AddPila(nombre_usuario, pila_usuarios, max_tamano_pila)
    elif opcion == 2:
        SacarDeLaPila(pila_usuarios)
    elif opcion == 3:
        print(f"Longitud de la pila: {LongitudPila(pila_usuarios)}")
    elif opcion == 4:
        EscribirPila(pila_usuarios)
    elif opcion == 5:
        print("Saliendo del programa.")
        break
    else:
        print("Opción no válida. Inténtalo de nuevo.")

