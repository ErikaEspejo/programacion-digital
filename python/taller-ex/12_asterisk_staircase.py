def ask_until_valid_number(new_number):
    while new_number <= 0:
        new_number = read_new_number()

    return new_number


def read_new_number():
    print("Ingrese un número entero positivo:")
    new_number = int(input())
    return new_number


def increase_asterisk_text(asterisk_text):
    result = asterisk_text + "*"
    return result


def print_asterisk_text(asterisk_text):
    print(asterisk_text)


def asterisk_staircase():
    new_number = 0
    counter = 1
    asterisk_text = ""

    new_number = ask_until_valid_number(new_number)

    while counter <= new_number:
        asterisk_text = increase_asterisk_text(asterisk_text)
        print_asterisk_text(asterisk_text)
        counter += 1


asterisk_staircase()