@echo off

gcc hello.c -o hello
echo Running the program...
hello.exe
set return_value=%errorlevel%
echo Return value: %return_value%
