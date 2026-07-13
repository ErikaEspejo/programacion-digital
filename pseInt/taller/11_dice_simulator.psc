// Programa en que el ordenador lanza 50 veces un dado y cuenta las veces que sale el número 1.

Funcion random_number <- generate_random_number
	random_number = Azar(6) + 1
FinFuncion

Funcion one_counter <- increase_one_counter(one_counter)
	one_counter = one_counter + 1
FinFuncion

Funcion print_result(one_counter)
	Escribir "Después de lanzar el dado 50 veces, se obtuvo el número *1* ", one_counter, " veces."
FinFuncion

Algoritmo dice_simulator
	Definir dice_roll, dice_result, one_counter Como Entero
	dice_roll = 1
	
	Mientras dice_roll <= 50 Hacer
		dice_result = generate_random_number()
		
		Si dice_result = 1 Entonces
			one_counter = increase_one_counter(one_counter)
		FinSi
		
		dice_roll = dice_roll + 1
	FinMientras
	print_result(one_counter)
FinAlgoritmo