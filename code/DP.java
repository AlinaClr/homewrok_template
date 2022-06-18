/*
 * @Author: AlinaClr 1516690324@qq.com
 * @Date: 2022-06-18 14:17:54
 * @LastEditors: AlinaClr 1516690324@qq.com
 * @LastEditTime: 2022-06-18 16:33:17
 * @FilePath: /homewrok_template/DP.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

import java.util.*;

public class DP {
    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        System.out.println("请输入最大容量：");
        int c = s.nextInt();
        System.out.println("请输入n的值：");
        int n = s.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        w[0]=0;
        v[0]=0;
        
        for (int i = 1; i <= n; i++) {
            w[i] = (int)((Math.random() * 1103515245 + 12345) % 100);
        }
        for (int i = 1; i <= n; i++) {
            v[i] = (int)((Math.random() * 1103515245 + 12345) % 100);
        }
        
        int[][] dp = new int[n + 1][c + 1];

        long start=System.nanoTime();
        for (int i = 0; i <=n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <=c; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= w[j]) {
                    dp[j][i] = max(dp[j - 1][i], v[j] + dp[j - 1][i - w[j]]);
                } else if (i < w[j]) {
                    dp[j][i] = dp[j - 1][i];
                }

            }
        }
        long end=System.nanoTime();

        System.out.println("执行时间为："+(end-start)/1000000.0+"ms");
        System.out.println("最大价值为："+dp[n][c]);
    }

    private static int max(int a, int b) {
        return a >= b ? a : b;
    }

}
