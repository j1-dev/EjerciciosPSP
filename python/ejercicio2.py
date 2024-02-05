# Ejercicio 2
nombre = input("Introduce tu nombre: ")
apellidos = input("Introduce tus apellidos: ")
ciclo_formativo = input("Introduce el nombre del ciclo formativo: ")
fecha_nacimiento = input("Introduce tu fecha de nacimiento: ")
dni_sin_letra = input("Introduce tu DNI (sin letra): ")

edad = int(input("Introduce tu edad: "))
dni_letra = "TRWAGMYFPDXBNJZSQVHLCKE"[int(dni_numero)%23]



print(f"{nombre} {apellidos} tiene la edad de {edad} años y su DNI es el siguiente {dni_sin_letra}{dni_letra}")

