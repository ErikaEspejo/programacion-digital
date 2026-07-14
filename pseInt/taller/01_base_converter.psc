// Convertir números entre las diferentes bases:
// Decimal -> Octal
// Decimal -> Hexadecimal
// Binario -> Decimal
// Binario -> Hexadecimal
// Octal -> Binario
// Octal -> Hexadecimal

Funcion conversion <- ask_until_valid_conversion(conversion)
	Mientras conversion < 1 O conversion > 6 Hacer
		Escribir "Seleccione la conversión:"
		Escribir "1. Decimal -> Octal"
		Escribir "2. Decimal -> Hexadecimal"
		Escribir "3. Binario -> Decimal"
		Escribir "4. Binario -> Hexadecimal"
		Escribir "5. Octal -> Binario"
		Escribir "6. Octal -> Hexadecimal"
		Leer conversion
	FinMientras
FinFuncion

Funcion number <- ask_until_valid_number(number, conversion)
	
	Definir digit, number_copy Como Entero
	Definir is_valid Como Logico
	
	is_valid = Falso
	
	Mientras NO is_valid Hacer
		
		number = read_number()
		number_copy = number
		is_valid = Verdadero
		
		Si number < 0 Entonces
			is_valid = Falso
		SiNo			
			Segun conversion Hacer
				3,4:
					Mientras number_copy > 0 Y is_valid Hacer
						digit = number_copy MOD 10
						
						Si digit <> 0 Y digit <> 1 Entonces
							is_valid = Falso
						FinSi
						
						number_copy = Trunc(number_copy / 10)
					FinMientras
				5,6:
					Mientras number_copy > 0 Y is_valid Hacer
						digit = number_copy MOD 10
						
						Si digit < 0 O digit > 7 Entonces
							is_valid = Falso
						FinSi
						
						number_copy = Trunc(number_copy / 10)
					FinMientras
			FinSegun
		FinSi
		
		
		Si NO is_valid Entonces
			Escribir "El número ingresado no pertenece a la base seleccionada."
		FinSi
	FinMientras
FinFuncion

Funcion number <- read_number
	Escribir "Ingrese el número:"
	Leer number
FinFuncion

Funcion character <- hexadecimal_character(value)
	Segun value Hacer
		10:
			character = "A"
		11:
			character = "B"
		12:
			character = "C"
		13:
			character = "D"
		14:
			character = "E"
		15:
			character = "F"
		De Otro Modo:
			character = ConvertirATexto(value)
	FinSegun
FinFuncion

Funcion result <- decimal_to_base(decimal, base)
	Definir remainder Como Entero
	result = ""
	
	Si decimal = 0 Entonces
		result = "0"
	SiNo
		Mientras decimal > 0 Hacer
			remainder = decimal MOD base
			
			Si base = 16 Entonces
				result = hexadecimal_character(remainder) + result
			SiNo
				result = ConvertirATexto(remainder) + result
			FinSi
			
			decimal = Trunc(decimal / base)
		FinMientras
	FinSi
FinFuncion

Funcion result <- base_to_decimal(number, base)
	Definir digit, exponent Como Entero
	
	result = 0
	exponent = 0
	
	Mientras number > 0 Hacer
		digit = number MOD 10
		result = result + digit * base ^ exponent
		number = Trunc(number / 10)
		exponent = exponent + 1
	FinMientras
FinFuncion

Funcion print_result(result)
	Escribir "Resultado: ", result
FinFuncion

Algoritmo base_converter
	Definir conversion, number, decimal Como Entero
	
	conversion = ask_until_valid_conversion(conversion)
	number = ask_until_valid_number(number, conversion)
	
	Segun conversion Hacer
		
		1:
			result = decimal_to_base(number, 8)
			
		2:
			result = decimal_to_base(number, 16)
			
		3:
			print_result(base_to_decimal(number, 2))
			
		4:
			decimal = base_to_decimal(number, 2)
			result = decimal_to_base(decimal, 16)
			
		5:
			decimal = base_to_decimal(number, 8)
			result = decimal_to_base(decimal, 2)
			
		6:
			decimal = base_to_decimal(number, 8)
			result = decimal_to_base(decimal, 16)
			
	FinSegun
	
	Si conversion <> 3 Entonces
		print_result(result)
	FinSi
	
FinAlgoritmo