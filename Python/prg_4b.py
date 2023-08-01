"""
Question: Write a program to convert roman numbers into integer values using dictionaries.
"""

def rom2int(str):
    roman_values = {'I': 1, 'V': 5, 'X': 10, 'L':50, 'C':100, 'D':500, 'M':1000}
    total = 0
    pre_value = 0
    for char in reversed(str):
        value = roman_values[char]
        if value < pre_value:
            total -= value
        else:
            total += value
        pre_value = value
    return total

str = input("Enter the Roman number: ")
print("Roman value: {} equivalent in integer is: {}".format(str,rom2int(str)))
