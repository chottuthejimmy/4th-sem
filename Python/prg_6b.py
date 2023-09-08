"""
Write a python program to create a ZIP file of a particular folder which contains
several files inside it.
"""

import os
import pathlib
import zipfile

dir_name = input("Enter the name of the directory that you want to backup: ")

# Make sure to be in the parent directory of the dir whose zip you wish to create
if not os.path.isdir(dir_name):
    print("The directory does not exists")
    exit(0)

cur_dir = pathlib.Path(dir_name)

with zipfile.ZipFile(f"{dir_name}.zip", mode='w') as archive:
    for file_path in cur_dir.rglob('*'):
        archive.write(file_path, arcname=file_path.relative_to(cur_dir))

if os.path.isfile(f"{dir_name}.zip"):
    print(f"Archive {dir_name}.zip is created successfully")
else:
    print("Error in creating zip archive")


