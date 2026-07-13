// Crear el programa asteriscos, en el que se introduce un número entero y se crea una escalera de asteriscos. 

Funcion new_number <- ask_until_valid_number(new_number)
	Mientras new_number <= 0 Hacer
		new_number = read_new_number()
	FinMientras
FinFuncion

Funcion new_number <- read_new_number
	Escribir "Ingrese un número entero positivo:"
	Leer new_number
FinFuncion

Funcion result <- increase_asterisk_text(asterisk_text)
	result = asterisk_text + "*"
FinFuncion

Funcion print_asterisk_text(asterisk_text)
	Escribir asterisk_text
FinFuncion

Algoritmo asterisk_staircase
	Definir new_number, counter Como Entero
	Definir asterisk_text Como Caracter
	
	new_number = ask_until_valid_number(new_number)
	counter = 1

	Mientras counter <= new_number Hacer
		asterisk_text = increase_asterisk_text(asterisk_text)
		print_asterisk_text(asterisk_text)
		counter = counter + 1
	FinMientras

FinAlgoritmo
