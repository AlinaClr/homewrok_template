/*
 * @Author: AlinaClr 1516690324@qq.com
 * @Date: 2022-06-18 14:23:54
 * @LastEditors: AlinaClr 1516690324@qq.com
 * @LastEditTime: 2022-06-18 14:25:03
 * @FilePath: /homewrok_template/code/sort.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import java.util.*;

public class sort {
    private static Scanner s;

    private static long count1=0;
    private static long count2=0;
    private static long count3=0;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        System.out.println("请输入测试数据的数目");
        int n = s.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (int) ((Math.random() * 1103515245 + 12345) % 100000);
        }

        long start1=System.nanoTime();
        bubbleSort(numbers, n);
        long end1=System.nanoTime();
        System.out.println("基本操作执行次数："+count1+"次");
        System.out.println("冒泡排序执行时间:" + (end1-start1)/1000000.0+"ms");

        long start2=System.nanoTime();
        mergeSort(numbers, 0, n - 1);
        long end2=System.nanoTime();
        System.out.println();
        System.out.println("归并排序基本操作执行次数："+count2+"次");
        System.out.println("归并排序执行时间："+(end2-start2)/1000000.0+"ms");

        long start3=System.nanoTime();
        quickSort(numbers, 0, n - 1);
        long end3=System.nanoTime();
        System.out.println();
        System.out.println("快速排序基本操作执行次数："+count3+"次");
        System.out.println("快速排序执行时间："+(end3-start3)/1000000.0+"ms");
    }

    private static void bubbleSort(int[] numbers, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (numbers[j - 1] > numbers[j]) {
                    count1++;
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    private static void mergeSort(int[] numbers, int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(numbers, first, middle);
            mergeSort(numbers, middle + 1, last);
            mergeList(numbers, first, middle, last);
        }
    }

    private static void mergeList(int[] numbers, int first, int middle, int last) {
        int l1 = middle - first + 1;
        int l2 = last - middle;
        int[] m = new int[l1];
        int[] n = new int[l2];
        int x = 0, y = 0;
        for (int i = first; i <= middle; i++) {
            m[x++] = numbers[i];
        }
        for (int j = middle + 1; j <= last; j++) {
            n[y++] = numbers[j];
        }
        int a = 0, b = 0;
        int k = first;
        while (a < l1 && b < l2) {
            count2++;
            if (m[a] <= n[b]) {
                numbers[k++] = m[a++];
            } else if (m[a] > n[b]) {
                numbers[k++] = n[b++];
            }
        }
        while (a < l1) {
            count2++;
            numbers[k++] = m[a++];
        }
        while (b < l2) {
            count2++;
            numbers[k++] = n[b++];
        }
    }

    private static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int pos = partition(numbers, start, end);
            quickSort(numbers, start, pos - 1);
            quickSort(numbers, pos + 1, end);
        }
    }

    private static int partition(int[] numbers, int start, int end) {
        int mid = numbers[start];// ÿ��ȷ����һ����Ϊ����Ԫ��
        int i = start, j = end;
        while (i < j) {
            count3++;
            while (numbers[j] >= mid && i < j) {
                j--;
            }
            while (numbers[i] <= mid && i < j) {
                i++;
            }
            if (i < j) {
                int temp;
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            } else
                break;
        }
        int temp;
        temp = numbers[start];
        numbers[start] = numbers[j];
        numbers[j] = temp;
        return j;
    }
}
