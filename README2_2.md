# 实验 2.1 动态规划算法的适应性测试

## 学号：20201060353  

## （一）实验目的：  
对于同一问题，编程实现其分治算法和动态规划算法，通过对比分析，理解
动态规划算法的适用情形。通过程序的执行时间测试结果，与理论结论进行对比、
分析和验证。

## （二）实验原理：
### 1.分治算法与动态规划算法的对比：针对子问题是否重叠
虽然很多问题均可分解为子问题、动态规划和分治算法都是通过子问题的解
决来获得原问题的解。然而，分治算法适用于子问题不重叠（即相互独立）的情
形，对于子问题重叠的情形分治法具有较高的时间复杂度，动态规划是针对这类
情形的有效算法。
### 2.测试算法
斐波纳契数列在现代物理、准晶体结构、化学等领域都有直接的应用。斐波
那契数列指的是这样一个数列：1、1、2、3、5、8、13、21、……，这个数列从
第三项开始，每一项都等于前两项之和，即：
直观地，斐波纳契数列可递归地得到，算法如下：
DAC_f(n) 
if(n == 1) or (n == 2) then 
 return 1 
else 
return f(n-1)+f(n-2) 
end if 
通过理论分析已经得出结论：以上递归算法随着 n 增大有指数计算时间。对
于 n 的多项式个数的子问题，显然指数计算时间是不现实的。基于动态规划算法
可高效地求解 Fibonacci 数问题，算法如下：
DP_f(n) 
Initialize f[1..n] 
for i=1 to n do 
if(i == 1) or (i == 2) then 
 f[i]=1 
else 
f[i]=f[i-1]+f[i-2] 
end if 
end for 
return f[n] 
算法的时间复杂度为 O(n)。

## （三）实验输入数据集
文本数据集：每次运用线性同余法得出不同数量的随机数集合

## （四）实验内容
###  1.要求：
编程实现以上求斐波纳契数的分治算法和动态规划算法。对于每个算法，记
录随着斐波纳契数数列大小增加基本操作的执行次数，分析并以图形方式展现增
长率；对比这两个算法，随着数列大小增加算法增长率的变化趋势；测试、验证、
对比理论结论。
### 2.代码：
[实验代码](https://github.com/AlinaClr/homewrok_template/blob/main/code/compareDPandDC.java#L31)

## （五）实验预期结果与实际结果
### 1.验证程序正确性：

#### 实验预期结果：5

#### 实验过程及实验结果

gitpod /workspace/homewrok_template (main) $ cd "/workspace/homewrok_template/code/" && javac compareDPandDC.java && java compareDPandDC
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入n的值：
5
基本操作次数为:5  分治法运行次数为9
基本操作次数为:5  动态规划运行次数为3

### 2.分别测试不同n值情形下 DAC_f 和 DP_f 算法的加法次数

#### 实验预期结果：随着n的增加加法次数逐渐增加，且分治法的加法次数大于动态规划法

#### 实验过程及实验结果：

(1)代码运行结果：

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac compareDPandDC.java && java compareDPandDC
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入n的值：
5
基本操作次数为:5分治法运行次数为9
基本操作次数为:5动态规划运行次数为3

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac compareDPandDC.java && java compareDPandDC
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入n的值：
10
基本操作次数为:55  分治法运行次数为109
基本操作次数为:55  动态规划运行次数为8

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac compareDPandDC.java && java compareDPandDC
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入n的值：
15
基本操作次数为:610  分治法运行次数为1219
基本操作次数为:610  动态规划运行次数为13

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac compareDPandDC.java && java compareDPandDC
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入n的值：
20
基本操作次数为:6765  分治法运行次数为13529
基本操作次数为:6765  动态规划运行次数为18

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac compareDPandDC.java && java compareDPandDC
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入n的值：
25
基本操作次数为:75025  分治法运行次数为150049
基本操作次数为:75025  动态规划运行次数为23

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac compareDPandDC.java && java compareDPandDC
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入n的值：
30
基本操作次数为:832040  分治法运行次数为1664079
基本操作次数为:832040  动态规划运行次数为28

(2)加法操作与n的关系曲线图：
①分治法：
![分治法](https://s3.bmp.ovh/imgs/2022/06/19/2473fa9a0799e18c.png)
②动态规划法：
![动态规划](https://s3.bmp.ovh/imgs/2022/06/19/1365f1c3b8591eec.png)

### 3.实验结果分析与结论：
①由(2)所画的曲线图分析可以得出，动态规划法的加法操作执行次数远小于分治法，并且分治法的曲线呈现指数型曲线，而动态规划法的曲线为线性曲线。与理论上动态规划法的时间复杂度为O（n)相吻合，使用动态规划法来解决斐波那契数列问题的效率远远高于分治法。

②我们知道斐波那契数列是子问题重叠的问题，实验证明使用动态规划法的效率远高于分治法。因此动态规划法适用于子问题重叠的问题，而分治法则适用于子问题独立的问题。








