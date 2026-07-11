Funcion nuevo_numero <- ingresar_nuevo_num 
	Escribir "Ingrese un número entero"
	Leer x
	nuevo_numero = x
FinFuncion

Funcion maximo <- calcular_maximo(x, max)
	si x > max Entonces
		maximo = x	
	SiNo  		maximo = max
FinSi	
FinFuncion

Funcion minimo <- calcular_minimo(x, min)
	si x < min Entonces
		min = x
	FinSi
	minimo = min
FinFuncion

Funcion sumatoria <- calcular_sumatoria(x, sum)
	sumatoria = sum + x
FinFuncion

Funcion mean <- calcular_promedio(sum, numero_datos)
	si numero_datos > 0 Entonces
		mean = sum/numero_datos
	FinSi
FinFuncion

Funcion generar_respuesta(max, min, mean, n)
	Si n > 0 Entonces
		Escribir "El max es: ", max, "; El min es: ", min, "; El promedio es: ", mean
	SiNo
		Escribir "Los datos ingresados son inválidos, no se pudo generar el cálculo correctamente."
	FinSi
FinFuncion

Algoritmo calculos_estadisticos
	Definir x, max, min, n, sum Como Entero	
	x = ingresar_nuevo_num 
	min = x
	Mientras x > 0 Hacer
		n = n + 1
		max = calcular_maximo(x, max) 
		min = calcular_minimo(x, min)
		sum = calcular_sumatoria(x, sum)
		x = ingresar_nuevo_num 
	FinMientras
	mean = calcular_promedio(sum, n)
	generar_respuesta(max, min, mean, n)
	
FinAlgoritmo
