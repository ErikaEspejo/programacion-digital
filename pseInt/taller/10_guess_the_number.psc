// Realizar un programa en el que el ordenador "piensa" en un número al azar entre 1 y 50.
// El usuario debe adivinarlo en 5 oportunidades. El ordenador señalará si el número es mayor o menor.

Funcion random_number <- generate_random_number
	random_number = Azar(50) + 1
FinFuncion

Funcion guess_number <- read_guess_number
	Escribir "Ingresa el número que crees que pensé:"
	Leer guess_number
FinFuncion

Funcion print_hint(random_number, guess_number, remaining_attempts)
	Si random_number > guess_number Entonces
		Escribir "El número que debes adivinar es mayor que ", guess_number, "."
	SiNo
		Escribir "El número que debes adivinar es menor que ", guess_number, "."
	FinSi
	
	Escribir "Te quedan ", remaining_attempts, " oportunidades."
FinFuncion

Funcion print_winner(random_number, attempt)
	Escribir "¡Has adivinado el número en ", attempt, " intento(s)! El número era: ", random_number
FinFuncion

Funcion print_loser(random_number)
	Escribir "¡Has perdido! El número era: ", random_number
FinFuncion

Algoritmo guess_the_number
	Definir random_number, guess_number, attempt, remaining_attempts Como Entero
	Definir number_guessed Como Logico
	
	random_number = generate_random_number()
	attempt = 1
	number_guessed = Falso
	
	Escribir "¡Hola! He pensado un número entre 1 y 50."
	Escribir "Tienes 5 oportunidades para adivinarlo."
	
	Mientras attempt <= 5 Y NO number_guessed Hacer
		guess_number = read_guess_number()
		
		Si guess_number = random_number Entonces
			number_guessed = Verdadero
		SiNo
			remaining_attempts = 5 - attempt
			
			Si remaining_attempts > 0 Entonces
				print_hint(random_number, guess_number, remaining_attempts)
			FinSi
			
			attempt = attempt + 1
		FinSi
	FinMientras
	
	Si number_guessed Entonces
		print_winner(random_number, attempt)
	SiNo
		print_loser(random_number)
	FinSi
FinAlgoritmo