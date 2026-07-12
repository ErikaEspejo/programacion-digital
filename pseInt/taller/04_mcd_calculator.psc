Funcion new_number <- read_new_number
	Escribir "Ingresa un número"
	Leer new_number
FinFuncion

Funcion lower_number <- get_lower_number(number1, number2)
	Si number1 < number2 Entonces
		lower_number = number1
	Sino
		lower_number = number2
	FinSi
FinFuncion

Funcion result <- is_divisible(number, divisor)
	result = number MOD divisor = 0
FinFuncion

Funcion result <- calculate_mcd(current_mcd, new_number)
	Definir divisor Como Entero
	
	Si current_mcd = 0 Y new_number = 0 Entonces
		result = 0
	Sino
		Si current_mcd = 0 Entonces
			result = new_number
		Sino
			Si new_number = 0 Entonces
				result = current_mcd
			Sino
				result = 0
				divisor = get_lower_number(current_mcd, new_number)
				
				Mientras divisor >= 1 Y result = 0 Hacer
					Si is_divisible(current_mcd, divisor) Y is_divisible(new_number, divisor) Entonces
						result = divisor
					Sino
						divisor = divisor - 1
					FinSi
				FinMientras
			FinSi
		FinSi
	FinSi
FinFuncion

Funcion print_result(current_mcd)
	Escribir "El MCD de los números ingresados es: ", current_mcd
FinFuncion

Algoritmo mcd_calculator
	Definir new_number, current_mcd Como Entero
	new_number = read_new_number()
	
	Si new_number < 0 Entonces
		Escribir "No se ingresaron números válidos para calcular el MCD."
	Sino
		current_mcd = new_number
		new_number = read_new_number()
		
		Mientras new_number >= 0 Hacer
			Si current_mcd <> 1 Entonces
				current_mcd = calculate_mcd(current_mcd, new_number)
			FinSi
			
			new_number = read_new_number()
		FinMientras
		
		print_result(current_mcd)
	FinSi
FinAlgoritmo