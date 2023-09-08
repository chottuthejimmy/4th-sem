"""
By using the concept of inheritance write a python program to find the area of triangle,
circle and rectangle.
"""

import math

class Shape:
    def __init__(self):
        self.area = 0
        self.name = ""

    def show_area(self):
        print(f"The are of the {self.name} is {self.area} square units")

class Circle(Shape):
    def __init__(self, radius):
        self.area = 0
        self.name = "Circle"
        self.radius = radius

    def calc_area(self):
        self.area = math.pi * self.radius ** 2

class Triangle(Shape):
    def __init__(self, base, height):
        self.area = 0
        self.name = "Triangle" 
        self.base = base
        self.height = height

    def calc_area(self):
        self.area = 0.5 * self.base * self.height

class Rectangle(Shape):
    def __init__(self, length, breadth):
        self.area = 0
        self.name = "Rectangle" 
        self.length = length
        self.breadth = breadth

    def calc_area(self):
        self.area = self.length * self.breadth

c = Circle(5)
c.calc_area()
c.show_area()

r = Rectangle(5, 4)
r.calc_area()
r.show_area()

t = Triangle(3, 4)
t.calc_area()
t.show_area()
