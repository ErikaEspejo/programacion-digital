import random


def generate_random_number():
    random_number = random.randint(1, 6)
    return random_number


def increase_one_counter(one_counter):
    one_counter = one_counter + 1
    return one_counter


def print_result(one_counter):
    print(
        f"Después de lanzar el dado 50 veces, se obtuvo el número 1 {one_counter} veces."
    )


def dice_simulator():
    dice_roll = 1
    one_counter = 0

    while dice_roll <= 50:
        dice_result = generate_random_number()

        if dice_result == 1:
            one_counter = increase_one_counter(one_counter)

        dice_roll += 1

    print_result(one_counter)


dice_simulator()