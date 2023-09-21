"""
Question: Write a program to convert roman numbers into integer values using dictionaries.
"""

def rom2int(string):
    roman_values = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    total = 0
    pre_value = 0
    for char in reversed(string):
        value = roman_values[char]
        if value < pre_value:
            total -= value
        else:
            total += value
        pre_value = value
    return total

string = input("Enter the Roman number: ")
print(f"Roman value: {string} equivalent in integer is: {rom2int(string)}")
