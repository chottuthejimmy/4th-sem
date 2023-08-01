"""
Question: Write a Python program to find the string similarity between two given strings.
"""

str1 = input("Enter String 1: ")
str2 = input("Enter String 2: ")
if len(str2) < len(str1):
    short = len(str2)
    long = len(str1)
else:
    short = len(str1)
    long = len(str2)
match_cnt = 0
for i in range(short):
    if str1[i] == str2[i]:
        match_cnt+=1
print("Similarity between the two said strings is:",match_cnt/long)