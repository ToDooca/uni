#include <stdio.h>


int main()
{
	int cena, r, a, b;;
	printf("Unesite cenu proizvoda u dinarima: ");
	scanf_s("%d", &cena);

	if (cena < 0) 
	{
		printf("Uneli ste nevalidnu cenu.");
		return 1;
	}

	if (r = cena / 500) {
		cena -= r * 500;
		a = r;
	}
	if (r = cena / 100) {
		cena -= r * 100;
		b = r;
	}
	printf("Potrebno vam je:\n %d novcanica od 500 dinara,\n %d novcanica od 100 dinara, i\n %d novcanica od 1 dinar", a, b, cena);
	return 0;
}