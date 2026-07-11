Funcion nuevo_numero <- ingresar_nuevo_num 
	Escribir "Ingrese un número entero"
	Leer x
	nuevo_numero = x
FinFuncion

funcion paridad <- validar_paridad(x) 
	si x MOD 2 == 0 Entonces
		paridad = " es par"
	SiNo
		paridad = " es impar"
	FinSi
FinFuncion

Algoritmo imprimir_es_par_o_impar
	Definir x como entero
	x = ingresar_nuevo_num
	Mientras  x > 0 Hacer
		paridad = validar_paridad(x) 
		Escribir  x, paridad
		x = ingresar_nuevo_num
	FinMientras
FinAlgoritmo
