"""
 Question: Develop a Python program to check whether a given number is palindrome or not and also count the number of occurrences of each digit in the input number.
 """

val = input("Enter a number: ")
if val == val[::-1]:
    print("Palindrome")
else:
    print("Not Palindrome")

for i in range(10): # 10 is exlcusive ; 0-9
    if val.count(str(i))>0:
        print(i,"appears",val.count(str(i)),"times")

