Algoritmo es_par_o_impar
	Definir x como entero
	Escribir "Ingrese un número entero"
	Leer x
	Mientras  x > 0 Hacer
		si x MOD 2 == 0 Entonces
			Escribir x," es par"
		SiNo
			Escribir x, " es impar"
		FinSi
		Escribir "Ingrese un número entero"
		Leer x
	FinMientras
FinAlgoritmo
