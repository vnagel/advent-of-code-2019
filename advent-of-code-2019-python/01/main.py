from functools import reduce

MASSES_FILENAME = "masses.txt"


def calculate_required_fuel(mass):
    total = 0
    fuel = mass // 3 - 2
    while fuel > 0:
        total += fuel
        fuel = fuel // 3 - 2
    return total


def sum_required_fuel(total_fuel, mass):
    return total_fuel + calculate_required_fuel(mass)


def calculate_total_fuel_requirement(masses_filename):
    with open(masses_filename) as masses_file:
        mass_strs = masses_file.read().split()
        mass_nums = list(map(int, mass_strs))
        return reduce(sum_required_fuel, mass_nums, 0)


if __name__ == "__main__":
    print(calculate_total_fuel_requirement(MASSES_FILENAME))
