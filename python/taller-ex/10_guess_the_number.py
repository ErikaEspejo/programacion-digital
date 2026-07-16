import random

def generate_random_number():
    random_number = random.randint(1, 50)
    return random_number

def read_guess_number():
    print("Ingresa el número que crees que pensé:")
    guess_number = int(input())
    return guess_number

def print_hint(random_number, guess_number, remaining_attempts):
    if random_number > guess_number:
        print(f"El número que debes adivinar es mayor que {guess_number}.")
    else:
        print(f"El número que debes adivinar es menor que {guess_number}.")

    print(f"Te quedan {remaining_attempts} oportunidades.")

def print_winner(random_number, attempt):
    print(f"¡Has adivinado el número en {attempt} intento(s)! El número era: {random_number}")

def print_loser(random_number):
    print(f"¡Has perdido! El número era: {random_number}")

def guess_the_number():
    random_number = generate_random_number()
    attempt = 1
    number_guessed = False

    print("¡Hola! He pensado un número entre 1 y 50.")
    print("Tienes 5 oportunidades para adivinarlo.")

    while attempt <= 5 and not number_guessed:
        guess_number = read_guess_number()

        if guess_number == random_number:
            number_guessed = True
        else:
            remaining_attempts = 5 - attempt

            if remaining_attempts > 0:
                print_hint(random_number, guess_number, remaining_attempts)

            attempt += 1

    if number_guessed:
        print_winner(random_number, attempt)
    else:
        print_loser(random_number)


guess_the_number()