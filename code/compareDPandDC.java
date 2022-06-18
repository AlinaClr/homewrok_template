/*
 * @Author: AlinaClr 1516690324@qq.com
 * @Date: 2022-06-18 14:22:40
 * @LastEditors: AlinaClr 1516690324@qq.com
 * @LastEditTime: 2022-06-18 14:22:43
 * @FilePath: /homewrok_template/code/compareDPandDC.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import java.util.Scanner;

public class compareDPandDC {
    private static int count1 = 0;
    private static int count2 = 0;
    private static Scanner s;

    public compareDPandDC() {
    }

    public static void main(String[] args) {
        s = new Scanner(System.in);
        System.out.println("请输入n的值：");
        int n = s.nextInt();
        int result1 = dcf(n);
        int result2 = dpf(n);
        System.out.println(result1 + "分治法运行次数为" + count1);
        System.out.println(result2 + "动态规划运行次数为" + count2);
    }

    public static int dcf(int n) {
        ++count1;
        return n != 1 && n != 2 ? dcf(n - 1) + dcf(n - 2) : 1;
    }

    public static int dpf(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for(int i = 1; i <= n; ++i) {
            if (i != 1 && i != 2) {
                f[i] = f[i - 1] + f[i - 2];
                ++count2;
            } else {
                f[i] = 1;
            }
        }

        return f[n];
    }
}
