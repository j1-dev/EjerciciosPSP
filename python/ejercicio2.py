# Ejercicio 2
def calcular_letra_dni(numero_dni):
    letras = 'TRWAGMYFPDXBNJZSQVHLCKE'
    indice = int(numero_dni) % 23
    return letras[indice]

nombre = input("Ingrese su nombre: ")
apellidos = input("Ingrese sus apellidos: ")
edad = input("Ingrese su edad: ")
dni = input("Ingrese los números de su DNI (sin letra): ")

letra_dni = calcular_letra_dni(dni)

print(f"{nombre} {apellidos} tiene la edad de {edad} años y su DNI es: {dni}{letra_dni}")


