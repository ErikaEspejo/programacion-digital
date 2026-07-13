// Leer tres números que denoten una fecha: dia, mes, año. Comprobar que es una fecha válida. 
// Si no es válida, escribir  un mensaje de error.
// Si es válida, escribir la fecha cambiando el número del mes por su nombre.
// El año debe ser mayor que 0. 

Funcion new_number <- read_new_data(data)
	Escribir "Ingresa el ", data
	Leer new_number
FinFuncion

Funcion result <- is_valid_year(year)
	result = Falso
	Si year > 0 Entonces
		result = Verdadero
	FinSi
FinFuncion

Funcion result <- is_valid_month(month)
	result = Falso
	Si month >= 1 y month <= 12 Entonces
		result = Verdadero
	FinSi
FinFuncion

Funcion result <- is_month_with_31_days(month)
	result = Falso
	Si month == 1 O month == 3 O month == 5 O month == 7 O month == 8 O month == 10 O month == 12 Entonces
		result = Verdadero
	FinSi
FinFuncion

Funcion result <- is_month_with_30_days(month)
	result = Falso
	Si month == 4 O month == 6 O month == 9 O month == 11 Entonces
		result = Verdadero
	FinSi
FinFuncion

Funcion result <- is_leap_year(year)
	result = Falso
	Si year MOD 400 == 0 O (year MOD 4 == 0 Y year MOD 100 <> 0)  Entonces
		result = Verdadero
	FinSi
FinFuncion


Funcion result <- is_valid_day(day, month, year)
	result = Falso
	Si day > 0 Entonces
		Si is_month_with_31_days(month) Y day <= 31 Entonces
			result = Verdadero
		SiNo 
			Si is_month_with_30_days(month) Y day <= 30 Entonces
				result = Verdadero
			SiNo 
				Si is_leap_year(year) Entonces
					Si day <= 29 Entonces
						result = Verdadero
					FinSi
				SiNo
					Si day <= 28 Entonces
						result = Verdadero
					FinSi		
				FinSi
			FinSi
		FinSi		
	FinSi	
FinFuncion



Funcion result <- is_valid_date(day, month, year)
	result = Falso
	Si is_valid_year(year) y is_valid_month(month) y is_valid_day(day,month,year) Entonces
		result = Verdadero
	FinSi
FinFuncion

Funcion  result <- recalculate_month(month)
	Segun month Hacer
		1:
			result = "enero"
		2:
			result = "febrero"
		3:
			result = "marzo"
		4:
			result = "abril"
		5:
			result = "mayo"
		6:
			result = "junio"
		7:
			result = "julio"
		8:
			result = "agosto"
		9:
			result = "septiembre"
		10:
			result = "octubre"
		11:
			result = "noviembre"
		12:
			result = "diciembre"
	FinSegun
FinFuncion

Algoritmo date_validator
	Definir day, month, year Como Entero
	Definir month_recalculated Como Caracter
	
	day = read_new_data("día:")
	month = read_new_data("mes:")
	year = read_new_data("año:")
	
	Si is_valid_date(day, month, year) Entonces
		month_recalculated = recalculate_month(month)
		Escribir day, " de ", month_recalculated, " de ", year
	SiNo
		Escribir "La fecha ingresada no es válida."
	FinSi
FinAlgoritmo
