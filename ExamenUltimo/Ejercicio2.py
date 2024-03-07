# 
#     Autor: JUAN GARCIA MARIN
#     Curso: Desarrollo de Aplicaciones Multiplataforma
#     Modulo: Programacion de servicios y procesos
# 

import sys

def EsPrimo(n):
    if n <= 1:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def NumerosPrimos():
    numeros_primos = []
    suma = 0
    for num in range(1, 101):
        if EsPrimo(num):
            numeros_primos.append(num)
            suma += num
    print("Numeros primos:", numeros_primos)
    print("Suma de numeros primos:", suma)

def NumerosNoPrimos():
    numeros_no_primos = []
    suma = 0
    for num in range(1, 101):
        if not EsPrimo(num):
            numeros_no_primos.append(num)
            suma += num
    print("Numeros no primos:", numeros_no_primos)
    print("Suma de numeros no primos:", suma)

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Uso: python Ejercicio2.py [opcion]")
        print("Opciones: primo - Mostrar nomeros primos y su suma.")
        print("          noprimo - Mostrar numeros no primos y su suma.")
    else:
        opcion = sys.argv[1]
        if opcion == "primo":
            NumerosPrimos()
        elif opcion == "noprimo":
            NumerosNoPrimos()
        else:
            print("Opción incorrecta. Por favor, seleccione 'primo' o 'noprimo'.")
