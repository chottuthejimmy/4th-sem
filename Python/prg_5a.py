"""
Question: Write a function called isphonenumber () to recognize a pattern 415-555-4242
without using regular expression and also write the code to recognize the same pattern using regular expression.
"""

import re
def isphonenumber(num): # Without using regular expression
    if len(num) != 12:
        return False
    if num[3] != '-' or num[7] !='-':
        return False
    for i in range(12):
        if i in [3, 7]:
            continue
        if not num[i].isdigit():
            return False
    return True

def isphonenumber_regex(num): # Using regular expression
    ph_no_pattern = re.compile(r'^\d{3}-\d{3}-\d{4}$')
    return bool(ph_no_pattern.match(num))
 
n = input("Enter a phone number: ")
print("Without regular expression: ",end='')
if isphonenumber(n):
    print("Valid phone number")
else:
    print("Invalid phone number")
print("With regular expression: ",end='')
if isphonenumber_regex(n):
    print("Valid phone number")
else:
    print("Invalid phone number")
