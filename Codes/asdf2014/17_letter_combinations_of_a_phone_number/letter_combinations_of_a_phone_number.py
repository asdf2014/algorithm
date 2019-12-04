# https://leetcode.com/problems/letter-combinations-of-a-phone-number/


chars = [
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "g",
    "h",
    "i",
    "j",
    "k",
    "l",
    "m",
    "n",
    "o",
    "p",
    "q",
    "r",
    "s",
    "t",
    "u",
    "v",
    "w",
    "x",
    "y",
    "z",
]


def letter_combinations_of_a_phone_number(digits):
    if len(digits) == 0:
        return []
    if len(digits) == 1:
        return [i for i in letters(digits[0])]
    previous = letter_combinations_of_a_phone_number(digits[:-1])
    return [i + j for i in previous for j in letters(digits[-1])]


def letters(n):
    n = int(n)
    if n < 1 or n > 9:
        return []
    elif n == 1:
        return []
    elif n <= 6:
        return chars[(n - 2) * 3 : (n - 1) * 3]
    elif n == 7:
        return chars[15:19]
    elif n == 8:
        return chars[19:22]
    elif n == 9:
        return chars[22:26]


assert letter_combinations_of_a_phone_number("") == []
assert letter_combinations_of_a_phone_number("2") == ["a", "b", "c"]
assert letter_combinations_of_a_phone_number("23") == [
    "ad",
    "ae",
    "af",
    "bd",
    "be",
    "bf",
    "cd",
    "ce",
    "cf",
]
