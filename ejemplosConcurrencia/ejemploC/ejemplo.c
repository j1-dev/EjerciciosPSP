#include<stdio.h>
int main() {
	FILE* fichero;
	fichero = fopen("salida.txt","wt");
	fputs("Este texto esta generado por el proceso en C", fichero);
	fclose(fichero);
	return 0;
}
