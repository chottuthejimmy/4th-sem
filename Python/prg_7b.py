"""
Write a python program by creating a class called Employee to store the details of Name, Employee_ID, Department and Salary, and implement a method to update salary of employees belonging to a given department.
"""

class Employee:
    def __init__(self):
        self.name = ""
        self.empId = ""
        self.dept = ""
        self.salary = 0
        
    def get_emp_details(self):
        self.name = input("Enter Employee name : ")
        self.empId = input("Enter Employee ID : ")
        self.dept = input("Enter Employee Dept : ")
        self.salary = int(input("Enter Employee Salary : "))
        
    def show_emp_details(self):
        print("Employee Details")
        print("Name :", self.name)
        print("ID :", self.empId)
        print("Dept :", self.dept)
        print("Salary :", self.salary)
        
    def update_salary(self):
        self.salary = int(input("Enter new Salary : "))
        print("Updated Salary", self.salary)

e = Employee()
e.get_emp_details()
e.show_emp_details()
e.update_salary()
