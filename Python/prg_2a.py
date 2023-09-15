"""
Question: Defined as a function F as Fn = Fn-1 + Fn-2. Write a Python program which accepts a
value for N (where N >0) as input and pass this value to the function.
Display suitable error message if the condition for input value is not followed.
"""
def f(n):
    if n==1:
         return 0
    if n==2:
        return 1
    else:
        return f(n-1) + f(n-2)

n = int(input("Enter the value of n: "))
if n>0:
    print(f"f({n}) = {f(n)}")
else:
    print("Error in input")