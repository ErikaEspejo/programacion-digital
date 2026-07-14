// Dados dos números enteros positivos calcular:
// a. La combinación del primero en el segundo
// b. La permutación del primero en el segundo

Funcion new_number <- read_new_number
	Escribir "Ingresa un número"
	Leer new_number
FinFuncion

Funcion result <- calculate_factorial(number)
	Definir factor Como Entero
	result = 1
	factor = number
	
	Mientras factor > 1 Hacer
		result = result * factor
		factor = factor - 1
	FinMientras
FinFuncion

Funcion result <- calculate_combinatoric(n_factorial, r_factorial, n_minus_r_factorial)
	result = n_factorial / (r_factorial * n_minus_r_factorial)	
FinFuncion

Funcion result <- calculate_permutation(n_factorial, n_minus_r_factorial)
	result = n_factorial / n_minus_r_factorial	
FinFuncion

Funcion calculate_combinatoric_results(n,r)
	Definir n_factorial, r_factorial, n_minus_r_factorial Como Entero
	Definir combinatoric, permutation Como Real
	
	n_factorial = calculate_factorial(n)
	r_factorial = calculate_factorial(r)
	n_minus_r_factorial = calculate_factorial(n - r)
	
	combinatoric = calculate_combinatoric(n_factorial, r_factorial, n_minus_r_factorial)
	Escribir "La combinación de ", n, " en ", r, " es: ", combinatoric
	
	permutation = calculate_permutation(n_factorial, n_minus_r_factorial)
	Escribir "La permutación de ", n, " en ", r, " es: ", permutation
FinFuncion

Algoritmo combinatorics_calculator
	Definir n, r Como Entero
	n = read_new_number()
	r = read_new_number()
	
	Si n < 0 O r < 0 Entonces
		Escribir "No se ingresaron números válidos para el cálculo."
	SiNo
		Si r > n Entonces
			Escribir "El segundo número no puede ser mayor al primero."
		SiNo
			calculate_combinatoric_results(n, r)
		FinSi
	FinSi
FinAlgoritmo