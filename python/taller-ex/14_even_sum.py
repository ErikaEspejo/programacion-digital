def read_number():
    print("Ingrese un número entero positivo:")
    number = int(input())
    return number


def ask_until_valid_number(number):
    while number <= 0:
        number = read_number()

    return number


def calculate_first_even_number(number):
    if number % 2 == 0:
        first_even_number = number
    else:
        first_even_number = number + 1

    return first_even_number


def add_even_number(current_sum, current_even_number):
    updated_sum = current_sum + current_even_number
    return updated_sum


def calculate_next_even_number(current_even_number):
    next_even_number = current_even_number + 2
    return next_even_number


def print_result(number, even_sum):
    print(f"La suma de los {number} números pares es: {even_sum}")


def even_sum_program():
    number = 0
    even_sum = 0
    numbers_added = 0

    number = ask_until_valid_number(number)
    current_even_number = calculate_first_even_number(number)

    while numbers_added < number:
        even_sum = add_even_number(even_sum, current_even_number)
        current_even_number = calculate_next_even_number(current_even_number)
        numbers_added += 1

    print_result(number, even_sum)


even_sum_program()