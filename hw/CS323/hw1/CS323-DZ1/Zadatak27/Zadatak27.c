#include <stdio.h>

int main()
{
	int sati, dani, godine, r;
	printf("Unesite broj sati: ");
	scanf_s("%d", &sati);

	dani = sati / 24;

	if (godine = dani / 365) {
		dani -= godine * 365;
	}
	printf("Godina: %d\nDani: %d", godine, dani);
}