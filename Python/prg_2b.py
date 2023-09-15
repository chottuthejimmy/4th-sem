"""
Question: Develop a python program to convert binary to decimal, octal to hexadecimal using functions.
"""

def bin2dec(num):
    dec = 0
    for digit in num:
        dec = dec*2 + int(digit)
    return dec

def oct2hex(num):
    dec = 0
    for digit in num:
        dec = dec*8 + int(digit)
    hexa = ""
    while dec > 0:
        rem = dec%16
        if rem < 10:
            hexa = str(rem) + hexa
        else:
            hexa = chr(ord('A') + rem-10) + hexa
        dec //= 16
    return hexa

n1 = input("Enter a binary number: ")
print("Binary",n1,"in decimal is",bin2dec(n1))
n2 = input("Enter a octal number: ")
print("Octal",n2,"in hexadecimal is",oct2hex(n2))