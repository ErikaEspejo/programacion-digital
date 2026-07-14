// Crear un programa que escriba dos columnas de números: en la primera, del 1 al 100; en la segunda, del 100 al 1.

Algoritmo number_columns
	Definir ascending_number, descending_number Como Entero
	ascending_number = 1
	descending_number = 100
	Mientras ascending_number <= 100 Hacer
		Escribir ascending_number, " - ", descending_number
		descending_number = descending_number - 1
		ascending_number = ascending_number + 1
	FinMientras
FinAlgoritmo
