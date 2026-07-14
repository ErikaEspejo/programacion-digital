// Hallar el MCM de todos los números leídos antes de recibir un número negativo.

Funcion new_number <- read_new_number
	Escribir "Ingresa un número"
	Leer new_number
FinFuncion

Funcion higher_number <- get_higher_number(number1, number2)
	Si number1 > number2 Entonces
		higher_number = number1
	Sino
		higher_number = number2
	FinSi
FinFuncion

Funcion is_divisible <- validate_divisibility(number, divisor)
	is_divisible = number MOD divisor = 0
FinFuncion

Funcion current_mcm <- calculate_mcm(current_mcm, new_number)
	Definir candidate Como Entero
	Definir  flag Como Logico
	
	Si current_mcm = 0 O new_number = 0 Entonces
		current_mcm = 0
	Sino
		candidate = get_higher_number(current_mcm, new_number)
		mcm_found = Falso
		
		Mientras NO mcm_found Hacer
			Si validate_divisibility(candidate, current_mcm) Y validate_divisibility(candidate, new_number) Entonces
				current_mcm = candidate
				mcm_found = Verdadero
			Sino 
				candidate = candidate + 1
			FinSi
		FinMientras
	FinSi
FinFuncion

Funcion print_result(current_mcm)
	Escribir "El MCM de los números ingresados es: ", current_mcm
FinFuncion

Algoritmo mcm_calculator
	Definir new_number, current_mcm Como Entero
	
	new_number = read_new_number()
	
	Si new_number < 0 Entonces
		Escribir "No se ingresaron números válidos para calcular el MCM."
	Sino
		current_mcm = new_number
		new_number = read_new_number()
		
		Mientras new_number >= 0 Hacer
			current_mcm = calculate_mcm(current_mcm, new_number)
			new_number = read_new_number()
		FinMientras
		
		print_result(current_mcm)
	FinSi
FinAlgoritmo