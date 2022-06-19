# 实验 2.1 动态规划算法的实现与时间复杂度测试

## 学号：20201060353  

## （一）实验目的：  
编程实现经典的动态规划算法，理解动态规划算法设计的基本思想、程序实现的相关技巧，加深对动态规划算法设计与分析思想的理解。通过程序的执行时间测试结果，与理论上的时间复杂度结论进行对比、分析和验证。  

## （二）实验原理：
### 1.动态规划算法的基本思想
动态规划是一种在数学和计算机科学中使用的、用于求解包含重叠子问题的最优化问题的有效方法。其基本思想是：将原问题分解为相似的子问题，在求解的过程中通过子问题的解描述并求出原问题的解。动态规划的思想是多种算法的
基础，被广泛应用于计算机科学和工程领域，在查找有很多重叠子问题的情况的最优解时有效。它将问题重新组合成子问题，为了避免多次解决这些子问题，它们的结果都逐渐被计算并保存，从小规模的子问题直到整个问题都被解决。因此，
动态规划对每一子问题只做一次计算，具有较高的效率。
### 2.测试算法
0-1 背包问题是使用动态规划算法求解的代表问题，算法如下：
    KnapsackDP ({w1, w2, …, wn}, {v1, v2, …, vn}, C) 
    for i=0 to n do 
     m[i,0]=0 
    end for 
    for j=0 to C do 
     m[0,j]=0 
    end for 
    for i=1 to n do 
     for j=1 to C do 
     m[i,j]=m[i-1,j] 
     if wij then 
     m[i,j]=max{m[i,j],m[i-1,j-wi]+vi} 
     end if 
    end for 
    end for 
    return m[n,C] 
算法的时间复杂度为 O(nC)。

## （三）实验输入数据集
文本数据集：每次运用线性同余法得出不同数量的随机数集合

## （四）实验内容
###  1.要求：
编程实现以上求解 0-1 背包问题的动态规划算法，并通过手动设置、生成随机数获得实验数据。记录随着输入规模增加算法的执行时间，分析并以图形方式展现增长率；测试、验证、对比算法的时间复杂度。
### 2.代码：
[实验代码](https://github.com/AlinaClr/homewrok_template/blob/main/code/DP.java#L32)

## （五）实验预期结果与实际结果
### 1.验证程序正确性：

#### 实验预期结果：37

#### 实验过程及实验结果

:
gitpod /workspace/homewrok_template/code (main) $ cd "/workspace/homewrok_template/code/" && javac DP.java && java DP
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
执行时间为：0.00479ms
最大价值为：37

### 2.测试 C 值不变的情形下随着 n 增加、程序执行时间增加的趋势。

#### 实验预期结果：C值不变时，随着n的增加，程序执行时间呈现上升趋势

#### 实验过程及实验结果：

①当C=200时：

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
200
请输入n的值：
10
执行时间为：0.21437ms
最大价值为：314

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
200
请输入n的值：
20
执行时间为：0.41492ms
最大价值为：584

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
200
请输入n的值：
40
执行时间为：0.745439ms
最大价值为：480

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
200
请输入n的值：
100
执行时间为：1.66025ms
最大价值为：1003

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
200
请输入n的值：
200
执行时间为：3.13071ms
最大价值为：1540

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
200
请输入n的值：
400
执行时间为：5.84123ms
最大价值为：2049

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
200
请输入n的值：
800
执行时间为：5.828369ms
最大价值为：3472

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
200
请输入n的值：
2000
执行时间为：7.891799ms
最大价值为：5588

②当C=400时

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
400
请输入n的值：
10
执行时间为：0.48687ms
最大价值为：533

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
400
请输入n的值：
20
执行时间为：0.83885ms
最大价值为：733

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
400
请输入n的值：
40
执行时间为：1.39269ms
最大价值为：1198

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
400
请输入n的值：
100
执行时间为：3.30378ms
最大价值为：1615

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
400
请输入n的值：
200
执行时间为：6.43723ms
最大价值为：1951

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
400
请输入n的值：
400
执行时间为：7.353289ms
最大价值为：3191

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
400
请输入n的值：
800
执行时间为：7.709689ms
最大价值为：4553

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
400
请输入n的值：
2000
执行时间为：10.017279ms
最大价值为：7377

③当C=800时：

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
800
请输入n的值：
10
执行时间为：0.74097ms
最大价值为：593

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
800
请输入n的值：
20
执行时间为：1.55527ms
最大价值为：979

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
800
请输入n的值：
40
执行时间为：2.773539ms
最大价值为：1657

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
800
请输入n的值：
100
执行时间为：6.40455ms
最大价值为：2130

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
800
请输入n的值：
200
执行时间为：8.110759ms
最大价值为：3264

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
800
请输入n的值：
400
执行时间为：7.755009ms
最大价值为：4603

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
800
请输入n的值：
800
执行时间为：11.110109ms
最大价值为：6444

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
800
请输入n的值：
2000
执行时间为：17.877249ms
最大价值为：10792

④当C=2000时

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
2000
请输入n的值：
10
执行时间为：1.80896ms
最大价值为：537

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
2000
请输入n的值：
20
执行时间为：3.58025ms
最大价值为：1010

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
2000
请输入n的值：
40
执行时间为：6.45253ms
最大价值为：1867

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
2000
请输入n的值：
100
执行时间为：7.990389ms
最大价值为：3592

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
2000
请输入n的值：
200
执行时间为：10.670709ms
最大价值为：5210

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
2000
请输入n的值：
400
执行时间为：13.344669ms
最大价值为：7550

Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
Picked up JAVA_TOOL_OPTIONS:  -Xmx3435m
请输入最大容量：
2000
请输入n的值：
800
执行时间为：20.351778ms
最大价值为：10089

请输入最大容量：
2000
请输入n的值：
2000
执行时间为：47.276096ms
最大价值为：16762

⑤各不同 C 值情形下程序执行时间的对比曲线图：
![C值固定时执行时间随着n的增加的趋势图.png](https://s2.loli.net/2022/06/19/WM5fr6ZI4ECLkT3.png)

### 3.实验结果分析与结论：
由④所画的曲线图分析可以得出，在C值不变的情况下，随着n的增加执行时间呈现逐步上升的趋势，并且假设n的数量不变，随着C值的增大，执行时间同样呈现上升趋势，因此通过实验可以发现0-1背包的时间复杂度确实与nC的值有关系，与理论上的时间复杂度结论吻合。