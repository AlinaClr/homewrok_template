/*
 * @Author: AlinaClr 1516690324@qq.com
 * @Date: 2022-06-18 14:21:28
 * @LastEditors: AlinaClr 1516690324@qq.com
 * @LastEditTime: 2022-06-18 16:03:44
 * @FilePath: /homewrok_template/code/KnapsackGreedy.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import java.util.Scanner;

public class KnapsackGreedy {
    public static void main(String args[]){
        int n,i,j;
        double C;
        System.out.println("请输入待选择的物品的个数：");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        //System.out.println("请输入背包容量：");
        C = 134;
        double[] w = new double[n];    //物品重量数组
        double[] v = new double[n];    //物品价值数组
        double[] x = new double[n];//平均价值
        for(i = 0; i < n; i++){
            w[i] = (int)((Math.random() * 1103515245 + 12345) % 500);
        }
        for(i = 0; i < n; i++){
            v[i] = (int)((Math.random() * 1103515245 + 12345) % 500);
        }
		long start=System.nanoTime();
        double value = Knapsack(w,v,x,C,n);
		long end=System.nanoTime();
        System.out.println("最大价值为："+value);
		System.out.println("执行时间为："+(end-start)/1000000.0+"ms");
    }

    static void sort(double[] a, double[] b, int n){
        double[] c = new double[n];
        double temp;
        for(int i = 0; i < n; i++){
            c[i] = b[i]/a[i];
        }
        //利用冒泡排序对平均价值进行排序并交换
        for(int i=0;i<n;i++){
            for(int j=i;j<n-1;j++){
                if(c[j]<c[j+1]){
                    temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    temp = b[j];
                    b[j] = b[j+1];
                    b[j+1] = temp;
                 }
            }
        }
    }

    static double Knapsack(double[] a, double[] b, double[] x, double C, int n){
        int i,j;
        double cu;
        double result = 0;
        sort(a,b,n);
        for(i=0;i<n;i++){
            x[i] = 0;
        }
        cu = C;
        for(i=0;i<n;i++){
            if(a[i] > cu)
                break;
            x[i] = 1;
            cu = cu - a[i];
        }
        if(i<=n)
            x[i] = cu / a[i];
        for(i=0;i<n;i++){
            result += x[i]*b[i];
        }
        return result;
    }
}
