'''
Author: AlinaClr 1516690324@qq.com
Date: 2022-06-16 16:11:03
LastEditors: AlinaClr 1516690324@qq.com
LastEditTime: 2022-06-16 16:14:21
FilePath: /homewrok_template/code/01_test.py
Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
'''
from random import *
import math

global count1,count2,count3
count1 = 0
count2 = 0
count3 = 0

def myrandint(m,seed):
    a=1103515245
    b=12345
    rOld=seed
    while True:
        rNew=(a*rOld+b)%m
        yield rNew #每调用一次这个函数，才生成一次随机数，所以要惰性求值
        rOld=rNew

def bubbleSort(list):
    numberOfPairs = len(list)
    swappedElements = True
    while swappedElements == True :
        numberOfPairs = numberOfPairs - 1
        swappedElements = False
        for i in range(1,numberOfPairs):
            global count1
            count1 = count1 + 1
            if list[i] > list[i+1]:
                swap = list[i]
                list[i] = list[i+1]
                list[i+1] = swap
                swappedElements = True

def merge(a, b):
    c = []
    h = j = 0
    while j < len(a) and h < len(b):
        global count2
        count2 = count2 + 1
        if a[j] < b[h]:
            c.append(a[j])
            j += 1
        else:
            c.append(b[h])
            h += 1
    if j == len(a):
        for i in b[h:]:
            c.append(i)
    else:
        for i in a[j:]:
            c.append(i)
    return c

def mergeSort(lists):
    if len(lists) <= 1:
        return lists
    middle = len(lists) // 2
    left = mergeSort(lists[:middle])
    right = mergeSort(lists[middle:])
    return merge(left, right)

def quickSort(lists,i,j):
    if i >= j:
        return list
    pivot = lists[i]
    low = i
    high = j
    while i < j:
        global count3
        count3 = count3 + 1
        while i < j and lists[j] >= pivot:
            j -= 1
        lists[i]=lists[j]
        while i < j and lists[i] <=pivot:
            i += 1
        lists[j]=lists[i]
    lists[j] = pivot
    quickSort(lists,low,i-1)
    quickSort(lists,i+1,high)
    return lists

if __name__ == '__main__':
    seed(10)
    randomNum = []
    n = int(input('请输入生成随机数的个数'))
    for i in range(n):
        r = myrandint(100000,randint(1,100000))
        randomNum.append(next(r))
    bubbleSort(randomNum)
    mergeSort(randomNum)
    quickSort(randomNum,0,len(randomNum)-1)
    print(count1)
    print(count2)
    print(count3)

