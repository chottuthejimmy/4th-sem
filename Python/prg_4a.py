"""
Question: Write a python program to implement insertion sort and merge sort using lists.
"""

def insert_sort(list):
    for i in range(1,len(list)):
        key = list[i]
        j = i - 1
        while j>=0 and key<list[j]:
            list[j+1] = list[j]
            j -= 1
        list[j+1] = key
    return list

def merge_sort(list):
    if len(list)>1:
        mid = len(list) // 2
        left = list[:mid]
        right = list[mid:]
        
        merge_sort(left)
        merge_sort(right)

        i = j = k = 0

        while i<len(left) and j<len(right):
            if left[i]<right[j]:
                list[k] = left[i]
                i += 1
            else:
                list[k] = right[j]
                j += 1
            k += 1
        
        while i<len(left):
            list[k] = left[i]
            i += 1
            k += 1

        while j<len(right):
            list[k] = right[j]
            j += 1
            k += 1
            
    return list

my_list = []
n = int(input("Enter the size of the list: "))
for x in range(n):
    my_list.append(int(input("Enter the {} element: ".format(x+1))))

ins_list = my_list.copy()
mrg_list = my_list.copy()
print("List before sorting: {}\nAfter using insertion sort: {}\nAfter using merge sort: {}".format(my_list, insert_sort(ins_list), merge_sort(mrg_list)))



  

