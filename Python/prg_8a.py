"""
Write a python program to find whether the given input is palindrome or not (for both string and integer) using the concept of polymorphism and inheritance.
"""

class PalinStr:
    def __init__(self):
        self.ispalin = False
    def check_palin(self, str):
        if str == str[::-1]:
            self.ispalin = True
        return self.ispalin

class PalinInt(PalinStr):
    def check_palin(self, num):
        temp = num
        rev = 0
        while(temp != 0):
            digit = temp % 10
            rev = (rev * 10) + digit
            temp = temp // 10
        if rev == num:
            self.ispalin = True
        return self.ispalin

st = input("Enter a string : ")

stObj = PalinStr()
if stObj.check_palin(st):
    print("Given string is a Palindrome")
else:
    print("Given string is not a Palindrome")

val = int(input("Enter a integer : "))    

intObj = PalinInt()
if intObj.check_palin(val):
    print("Given integer is a Palindrome")
else:
    print("Given integer is not a Palindrome")
