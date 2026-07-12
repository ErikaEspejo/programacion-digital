Funcion new_number <- read_new_number 
	Escribir "Ingresa un número"
	Leer new_number
FinFuncion

Funcion odd_counter <- increase_odd_counter(new_number, odd_counter)
	Si new_number MOD 2 <> 0 Entonces
		odd_counter = odd_counter + 1
	FinSi
FinFuncion

Funcion print_result(odd_counter)
	Escribir "Ingresaste ", odd_counter, " números impares."
FinFuncion

Algoritmo ascending_odd_counter
	Definir new_number, prev_number, odd_counter Como Entero
	new_number = read_new_number()
	prev_number = new_number
	
	Mientras new_number >= prev_number Hacer	
		prev_number = new_number			
		odd_counter = increase_odd_counter(new_number, odd_counter)
		new_number = read_new_number() 		
	FinMientras
	
	print_result(odd_counter)
	
FinAlgoritmo
