# 
#     Autor: JUAN GARCIA MARIN
#     Curso: Desarrollo de Aplicaciones Multiplataforma
#     Modulo: Programacion de servicios y procesos
# 

def LeerFecha():
    while True:
        try:
            dia = int(input("Introduce el día: "))
            mes = int(input("Introduce el mes: "))
            año = int(input("Introduce el año: "))
            return dia, mes, año
        except ValueError:
            print("Por favor, introduce valores numéricos para el día, mes y año.")

def DiasDelMes(mes, año):
    if mes in {1, 3, 5, 7, 8, 10, 12}:
        return 31
    elif mes in {4, 6, 9, 11}:
        return 30
    elif mes == 2:
        if EsBisiesto(año):
            return 29
        else:
            return 28

def EsBisiesto(año):
    return año % 4 == 0

def CalcularDiaJuliano(dia, mes, año):
    dias_totales = dia
    for m in range(1, mes):
        dias_totales += DiasDelMes(m, año)
    return dias_totales

def main():
    dia, mes, año = LeerFecha()
    dia_juliano = CalcularDiaJuliano(dia, mes, año)
    print("El día juliano correspondiente a la fecha {}-{}-{} es: {}".format(dia, mes, año, dia_juliano))

if __name__ == "__main__":
    main()
