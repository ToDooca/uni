#include <stdio.h>


int main() 
{
	int cena;
	printf("Unesite cenu proizvoda:");
	scanf_s("%d", &cena);

	int r, a, b, c;
	if (r = cena % 500) {
		cena -= r * 500;
		a = r;
	}
	if (r = cena % 100) {
		cena -= r * 100;
		b = r;
	}
	if (r = cena % 1) {
		cena -= r * 1;
		c = r;
	}
	printf("Potrebno vam je:\n %a novcanica od 500 dinara,\n %b novcanica od 100 dinara,\n i %c novcanica od 1 dinar");
	return 0;
}