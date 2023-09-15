"""
Write a python program to combine select pages from many PDFs from PyPDF2 import PdfWriter, PdfReader
"""

from PyPDF2 import PdfWriter, PdfReader

num = int(input("Enter page number you want to combine from multiple documents "))

pdf1 = open('1st sem.pdf', 'rb')
pdf2 = open('3.pdf', 'rb')

pdf_writer = PdfWriter()

pdf_writer.add_page(PdfReader(pdf1).pages[num - 1])
pdf_writer.add_page(PdfReader(pdf2).pages[num - 1])

with open('output.pdf', 'wb') as output:
    pdf_writer.write(output)