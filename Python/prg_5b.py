"""
Question: Develop a python program that could search the text in a file for phone numbers
(+919900889977) and email addresses (sample@gmail.com)
"""

import re

phone_pattern = re.compile(r'\+\d{12}')
email_pattern = re.compile(r'[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$')

file_path = r'example.txt'
with open(file_path, 'r') as f:
    text = f.read()

phones = phone_pattern.findall(text)
emails = email_pattern.findall(text)

print(f"Phone numbers found: {phones}")
print(f"Emails found: {emails}")
