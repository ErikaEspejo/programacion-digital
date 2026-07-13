// Dado un monto, un número de meses y un valor de interés mensual de un préstamo.
// Calcular el valor total a pagar.

Funcion new_number <- read_new_data(data)
	Escribir "Ingresa el ", data
	Leer new_number
FinFuncion

Funcion total_interest <- calculate_total_interest(amount, month_number, monthly_interest_rate)
	total_interest = amount * month_number * monthly_interest_rate
FinFuncion

Funcion total_payment <- calculate_total_payment(amount, total_interest)
	total_payment = amount + total_interest
FinFuncion

Funcion print_result(amount, month_number, monthly_interest_rate, total_payment)
	Escribir "El valor total a pagar por el monto de $", amount, " con interés mensual del ", monthly_interest_rate * 100, "% en un plazo de ", month_number, " meses, es de: $", total_payment
FinFuncion

Algoritmo loan_calculator
	Definir month_number Como Entero
	Definir amount, monthly_interest_rate, total_interest, total_payment Como Real
	
	Mientras amount <= 0 Hacer
		amount = read_new_data("monto")
	FinMientras
	
	Mientras month_number < 1 Hacer
		month_number = read_new_data("número de meses")
	FinMientras
	
	monthly_interest_rate = read_new_data("porcentaje de interés mensual")
	
	Mientras monthly_interest_rate < 0 Hacer
		monthly_interest_rate = read_new_data("porcentaje de interés mensual")
	FinMientras
	
	monthly_interest_rate = monthly_interest_rate / 100
	
	total_interest = calculate_total_interest(amount, month_number, monthly_interest_rate)
	total_payment = calculate_total_payment(amount, total_interest)
	
	print_result(amount, month_number, monthly_interest_rate, total_payment)
FinAlgoritmo