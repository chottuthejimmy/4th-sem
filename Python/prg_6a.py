"""
Write a python program to accept a file name from the user and perform the
following operations
1. Display the first N line of the file
2. Find the frequency of occurrence of the word accepted from the user in the file
"""

import os
import pathlib

fname = input("Enter the file name: ")
# Super important to make sure you are in the right directory !!before executing!!

if not os.path.isfile(fname):
    print("File does not exists")
    exit(0)
infile = open(fname, 'r')
line_list = infile.readlines()

n = int(input("Enter the number of lines to be printed: "))

for i in range(n):
    print(i + 1, ":", line_list[i])

word = input("Enter a word: ")
count = 0
for line in line_list:
    count += line.count(word)

print("The word:", word, "appears", count, "times")

