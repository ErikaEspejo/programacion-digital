Funcion new_number <- read_new_number
	Escribir "Ingresa un número"
	Leer new_number
FinFuncion

Funcion print_prime_result(is_prime, new_number)
	Si is_prime Entonces
		Escribir "El número ", new_number, " es primo"
	Sino
		Escribir "El número ", new_number, " no es primo"
	FinSi
FinFuncion

Funcion is_divisible <- validate_divisibility(new_number, divisor)
	is_divisible = new_number MOD divisor = 0
FinFuncion

Algoritmo prime_checker
	Definir new_number, divisor Como Entero
	Definir is_prime Como Logico
	
	new_number = read_new_number()
	is_prime = Verdadero
	divisor = 2
	
	Si new_number <= 1 Entonces
		is_prime = Falso
	SiNo
		Mientras divisor < new_number Y is_prime Hacer
			Si validate_divisibility(new_number, divisor) Entonces
				is_prime = Falso
			FinSi
			
			divisor = divisor + 1
		FinMientras
	FinSi
	
	print_prime_result(is_prime, new_number)
FinAlgoritmo