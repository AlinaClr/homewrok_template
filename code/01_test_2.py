'''
Author: AlinaClr 1516690324@qq.com
Date: 2022-06-17 16:35:38
LastEditors: AlinaClr 1516690324@qq.com
LastEditTime: 2022-06-17 16:39:57
FilePath: /homewrok_template/code/01_test_2.py
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

def mergeSort(seq):
    """归并排序"""
    if len(seq) <= 1:
        return seq
    mid = len(seq) / 2  # 将列表分成更小的两个列表
    # 分别对左右两个列表进行处理，分别返回两个排序好的列表
    left = mergeSort(seq[:mid])
    right = mergeSort(seq[mid:])
    # 对排序好的两个列表合并，产生一个新的排序好的列表
    return merge(left, right)

def merge(left, right):
    """合并两个已排序好的列表，产生一个新的已排序好的列表"""
    result = []  # 新的已排序好的列表
    i = 0  # 下标
    j = 0
    # 对两个列表中的元素 两两对比。
    # 将最小的元素，放到result中，并对当前列表下标加1
    while i < len(left) and j < len(right):
        global count2
        count2 = count2 + 1
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result += left[i:]
    result += right[j:]
    return result

def quickSort(lista, first, last):
    # 递归的退出条件
    if first >= last:
        return
    # 设定起始元素为要寻找位置的基准元素
    mid_value = lista[first]
    # low为序列左边的由左向右移动的游标
    # high为序列右边的由右向左移动的游标
    low = first
    hight = last

    while low < hight:
        global count3
        count3 = count3 + 1
        # 当hight位的值大于mid_value的值则一直向左移动
        while low < hight and lista[hight] >= mid_value:
            hight -= 1
        # 停止移动要么low与hight重合,要么到了hight位值小于mid_value
        lista[low] = lista[hight]

        while low < hight and lista[low] < mid_value:
            low += 1
        lista[hight] = lista[low]
        # hight -= 1
    # 退出循环后，low与high重合，此时所指位置为基准元素的正确位置
    # 将基准元素放到该位置
    lista[low] = mid_value
    # 在做递归的时候没有用切片,是为了保证在做多次递归的时候操作排序的永远只会是这一个列表
    # 先对标志位左边的先进行排序
    quick_sort(lista, first, low-1)
    # 再对标志位右边的先进行排序
    quick_sort(lista, low+1, last)
    return lista

if __name__ == '__main__':
    seed(randint(0,10000))
    randomNum = []
    n = int(input('请输入生成随机数的个数'))
    for i in range(n):
        r = myrandint(100000,randint(1,100000))
        randomNum.append(next(r))
    bubbleSort(randomNum)
    mergeSort(randomNum)
    quickSort(randomNum,0,len(randomNum))
    print(count1)
    print(count2)
    print(count3)
