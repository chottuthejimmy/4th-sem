"""
Question: Write a python program to find the best of two test average marks out of three test’s
marks accepted from the user.
"""

m1 = int(input("Enter marks of test1: "))
m2 = int(input("Enter marks of test2: "))
m3 = int(input("Enter marks of test3: "))

if m1<=m2 and m1<=m3:
    avg = (m2+m3)/2
elif m2<=m1 and m2<=m3:
    avg = (m1+m3)/2
else:
    avg = (m1+m2)/2
print("The best average score obtained is: ",avg)
