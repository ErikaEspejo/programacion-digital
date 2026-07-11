Algoritmo calculos_estadisticos
	Definir x, max, min, n, sum Como Entero	
	Escribir "Ingrese un número entero"
	Leer x
	si x >= 0 Entonces
		min = x
	FinSi
	
	Mientras x>0 Hacer
		// Counter
		n = n + 1
		
		// Max
		si x > max Entonces
			max = x
		FinSi
		
		// Min
		si x < min Entonces
			min = x
		FinSi
		
		// Sum
		sum = sum + x
		
		Escribir "Ingrese un número entero"
		Leer x
	FinMientras
	
	// Mean
	mean = sum / n
	
	Escribir "El max es: ", max, "; El min es: ", min, "; El promedio es: ", mean
	
FinAlgoritmo
