"""
Question: Write a Python program that accepts a sentence and 
find the number of words, digits, uppercase letters and lowercase letters.
"""

sentence = input("Enter a sentence: ")
word_count = sentence.split(" ") # We need to count no of words and NOT no of chars
digit_count = upper_count = lower_count = 0
for char in sentence:
    if '0' <= char <= '9':
        digit_count += 1 
    elif 'A' <= char <= 'Z':
        upper_count += 1
    else:
        lower_count += 1
print("This sentence has: \n", len(word_count), "words\n", digit_count, "digits\n", upper_count, "upper case letters\n", lower_count, "lower case letters")  