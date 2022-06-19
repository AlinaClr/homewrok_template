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



'''
先  2 2 排序
再  4 4 排序
依次类推
'''


def mergeSort(a, n):
    s = 1
    b = [i for i in range(n)]
    # print(b)
    while (s < n):
        mergePass(a, b, s, n)  # 合并到数组b
        s += s
        mergePass(b, a, s, n)  # 合并到数组a
        s += s


def mergePass(x, y, s, n):  # 合并大小为s 的相邻子数组
    i = 0
    while (i <= n - 2 * s):  # 合并大小为s 的相邻连段子数组
        merge(x, y, i, i + s - 1, i + 2 * s - 1)
        i = i + 2 * s
    if (i + s < n):  # 剩下的元素小于2s
        merge(x, y, i, i + s - 1, n - 1)
    else:
        for j in range(i, n):
            y[j] = x[j]


def merge(c, d, l, m, r):  # 合并c[l:m] 和 c[m+1:r] 到d[1:r]
    i = l
    k = l
    j = m + 1
    while ((i <= m) and (j <= r)):
        global count2
        count2 = count2 + 1
        if (c[i] <= c[j]):  # 依次比较两个数的大小，选择性加入
            d[k] = c[i]
            k = k + 1
            i = i + 1
        else:
            d[k] = c[j]
            k = k + 1
            j = j + 1
    if (i > m):  # 剩余右方的数列加入
        for q in range(j, r + 1):
            d[k] = c[q]
            k = k + 1

    else:  # 剩余左方的数列加入
        for q in range(i, m + 1):
            d[k] = c[q]
            k = k + 1

def partition(nums, low, high):
    high_flag = True
    low_flag = False
    pivot = nums[low]
    while low < high and low < len(nums) and high < len(nums):
        if high_flag:
            if nums[high] < pivot:
                nums[low] = nums[high]
                high_flag = False
                low_flag = True
            else:
                high -= 1
        if low_flag:
            if nums[low] > pivot:
                nums[high] = nums[low]
                high_flag = True
                low_flag = False
            else:
                low += 1
    nums[low] = pivot
    return low

def quickSort(nums):
    arr = []
    low = 0
    high = len(nums) - 1
    if low < high:
        mid = partition(nums, low, high)
        if low < mid - 1:
            arr.append(low)
            arr.append(mid - 1)
        if mid + 1 < high:
            arr.append(mid + 1)
            arr.append(high)
        while arr:
            global count3
            count3 = count3 + 1
            r = arr.pop()
            l = arr.pop()
            mid = partition(nums, l, r)
            if l < mid - 1:
                arr.append(l)
                arr.append(mid - 1)
            if mid + 1 < r:
                arr.append(mid + 1)
                arr.append(r)

if __name__ == '__main__':
    seed(randint(0,10000))
    randomNum = []
    n = int(input('请输入生成随机数的个数'))
    for i in range(n):
        r = myrandint(100000,randint(1,100000))
        randomNum.append(next(r))
    bubbleSort(randomNum)
    mergeSort(randomNum,len(randomNum))
    quickSort(randomNum)
    print(f'冒泡排序基本操作执行次数：{count1}')
    print(f'归并排序基本操作执行次数：{count2}')
    print(f'快速排序基本操作执行次数：{count3}')
