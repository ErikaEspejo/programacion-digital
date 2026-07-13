// Dado un valor, descomponerlo en sus factores primos.
Funcion new_number <- read_new_number
	Escribir "Ingresa un número"
	Leer new_number
FinFuncion

Funcion result <- is_divisible(remaining_number, divisor)
	result = remaining_number MOD divisor = 0
FinFuncion

Funcion result <- calculate_new_remaining_number(remaining_number, divisor)
	result = remaining_number / divisor
FinFuncion

Funcion result <- concatenate_prime_factors(prime_factors, divisor)
	Si prime_factors == "" Entonces
		result = ConvertirATexto(divisor)
	SiNo
		result = prime_factors + " * " + ConvertirATexto(divisor)
	FinSi
FinFuncion

Funcion result <- calculate_new_divisor(divisor)
	result = divisor + 1
FinFuncion

Funcion print_prime_factors_result(new_number, prime_factors)
		Escribir "Los factores primos del número ", new_number, " son: ", prime_factors
FinFuncion

Algoritmo prime_factorization
	Definir new_number, remaining_number, divisor Como Entero
	Definir prime_factors Como Caracter
	
	new_number = read_new_number()
	
	si new_number <= 1 Entonces
		Escribir "No se ingresaron números válidos para el cálculo."
	SiNo
		divisor = 2
		remaining_number = new_number
		
		Mientras remaining_number > 1 Hacer	
			
			Si is_divisible(remaining_number,divisor) Entonces
				remaining_number = calculate_new_remaining_number(remaining_number, divisor)
				prime_factors = concatenate_prime_factors(prime_factors, divisor)
			SiNo 
				divisor = calculate_new_divisor(divisor)
			FinSi			
			
		FinMientras
		
		print_prime_factors_result(new_number, prime_factors)
		
	FinSi
	
FinAlgoritmo
