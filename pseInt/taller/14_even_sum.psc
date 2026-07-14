// Se pide representar el algoritmo que calcule la suma de los N primeros números pares.
// Es decir, si insertamos un 5, debe sumar 6 + 8 + 10 + 12 + 14.

Funcion number <- read_number
	Escribir "Ingrese un número entero positivo:"
	Leer number
FinFuncion

Funcion number <- ask_until_valid_number(number)
	Mientras number <= 0 Hacer
		number = read_number()
	FinMientras
FinFuncion

Funcion first_even_number <- calculate_first_even_number(number)
	Si number MOD 2 = 0 Entonces
		first_even_number = number
	SiNo
		first_even_number = number + 1
	FinSi
FinFuncion

Funcion updated_sum <- add_even_number(current_sum, current_even_number)
	updated_sum = current_sum + current_even_number
FinFuncion

Funcion next_even_number <- calculate_next_even_number(current_even_number)
	next_even_number = current_even_number + 2
FinFuncion

Funcion print_result(number, even_sum)
	Escribir "La suma de los ", number, " números pares es: ", even_sum
FinFuncion

Algoritmo even_sum_program
	Definir number, even_sum, current_even_number, numbers_added Como Entero
	
	number = ask_until_valid_number(number)
	current_even_number = calculate_first_even_number(number)
	numbers_added = 0
	
	Mientras numbers_added < number Hacer
		even_sum = add_even_number(even_sum, current_even_number)
		current_even_number = calculate_next_even_number(current_even_number)
		numbers_added = numbers_added + 1
	FinMientras
	
	print_result(number, even_sum)
FinAlgoritmo