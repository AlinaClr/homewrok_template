# 实验 2.1 贪心算法

## 学号：20201060353  

## （一）实验目的：  
编程实现经典的贪心算法，理解贪心算法设计的基本思想、程序实现的相关技巧，加深对贪心算法设计与分析思想的理解。通过程序的执行时间测试结果，
与理论上的时间复杂度结论进行对比、分析和验证。

## （二）实验原理：

### 1.贪心算法的基本思想
贪心算法求解优化问题的基本思想是：采用逐步构造最优解的方法。在每个阶段，都作出一个当前最优的决策（在一定的标准下）。决策一旦作出，就不可再更改（作出贪心决策的依据称为贪心准则）。
贪心算法的一般步骤如下：
(1) 根据拟解决问题选取一种贪心准则；
(2) 按贪心准侧标准对 n 个候选输入排序（以这一方法为代表，仍可基于堆来存储选；
(3) 依次选择输入量加入部分解中：如果当前这个输入量的加入，不满足约束条件，则把此输入加到这部分解中。
贪心算法的基本设计范式如下：
Greedy(A,n) 
A: include n inputs 
Solution=Ф
for i=1 to n do 
 x=Select(A) 
 if Feasible(solution,x) then 
 solution=Union(solution,x) 
 end if 
end for 
return solution

### 2.测试算法
背包问题是使用贪心算法求解的代表问题，算法如下：
KnapsackGreedy(p，w，m，x，n) 
 //v[1..n]和 w[1..n]分别含有按 vi/wiv(i+1)/v(i+1)排序的n件物品的价值和重量。M 是背包的容量大小，而 x[1..n]是解向量// 
 for i=1 to n do 
xi=0 //将解向量初始化为零// 
 end for 
 cu=m //cu 是背包剩余容量// 
 for i=1 to n do 
 if wi>cu then 
exit 
end if 
 xi=1 
 cu=cu-wi 
 repeat 
 if i≤n then 
xi=cu/wi 
 end if 
算法的时间复杂度取决于对 vi/wi 排序的时间复杂度，若选择 MergeSort 排序算法，则以上算法的时间复杂度为 O(nlogn)。

## （三）实验输入数据集
文本数据集：每次运用线性同余法得出不同数量的随机数集合

## （四）实验内容
###  1.要求：
编程实现以上求解背包问题的贪心算法，并通过手动设置、生成随机数获得实验数据。记录随着输入规模增加算法的执行时间，分析并以图形方式展现增长率；测试、验证、对比算法的时间复杂度。

### 2.代码：
[实验代码](https://github.com/AlinaClr/homewrok_template/blob/main/code/KnapsackGreedy.java#L13)

## （五）实验预期结果与实际结果
### 1.验证程序正确性：

#### 实验预期结果：31.5

#### 实验过程及实验结果

测试数据集：w = {18,15,10},v = {25,24,15},C = 20,n=3

gitpod /workspace/homewrok_template (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
3
请输入背包容量：
20
最大价值为：31.5

### 2.设定一个 m 值，测试随着 n 增加、程序执行时间增加的趋势。

#### 实验预期结果：随着n的增加执行时间逐渐增加

#### 实验过程及实验结果：

实验数据：m = 134

(1)代码运行结果：

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
10
最大价值为：40.091644204851754
执行时间为：0.009531ms

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
20
最大价值为：156.48322147651007
执行时间为：0.02577ms

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
40
最大价值为：75.69931662870158
执行时间为：0.055279ms

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
100
最大价值为：228.14869888475837
执行时间为：0.31698ms

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
200
最大价值为：178.1317365269461
执行时间为：1.34496ms

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
400
最大价值为：37.741602067183464
执行时间为：4.46088ms

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
800
最大价值为：188.23809523809524
执行时间为：6.977029ms

gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac KnapsackGreedy.java && java KnapsackGreedy
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入待选择的物品的个数：
2000
最大价值为：46.696969696969695
执行时间为：10.464239ms

(2)执行时间与n的关系曲线图：
![](https://upload.cc/i1/2022/06/19/l1SEx6.png)

### 3.实验结果分析与结论：
①由(2)所画的曲线图分析可以得出，因实验中采用的是冒泡排序算法，本问题的时间复杂度主要取决于排序算法的时间复杂度，因此可以从图中看出随着n的增长执行时间增长越来越快，与理论上的时间复杂度O(n^2)相近，由于数据太少，曲线可能不是很精准。




