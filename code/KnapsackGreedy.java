/*
 * @Author: AlinaClr 1516690324@qq.com
 * @Date: 2022-06-18 14:21:28
 * @LastEditors: AlinaClr 1516690324@qq.com
 * @LastEditTime: 2022-06-18 14:26:19
 * @FilePath: /homewrok_template/code/KnapsackGreedy.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import java.util.*;

public class KnapsackGreedy {
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = new Scanner(System.in);
		int c = s.nextInt();// ��������
		int n = s.nextInt();// ��Ʒ����
		things[] t = new things[n];
		for (int i = 0; i < n; i++) {
			t[i]=new things();
			//�ڲ����Ƕ�̬�ģ�Ҳ���ǿ�ͷ��public class��ͷ������������public static class main��
			//��Java�У����еľ�̬��������ֱ�ӵ��ö�̬������
			//ֻ�н�ĳ���ڲ�������Ϊ��̬�࣬Ȼ����ܹ��ھ�̬���е��ø���ĳ�Ա�������Ա������
			//�����ڲ��������䶯������£���򵥵Ľ���취�ǽ�public class��Ϊpublic static class
			t[i].value = Math.random() * 100;
			t[i].weight =Math.random() * 10%c;
			t[i].valuep = t[i].value / t[i].weight;

		}
		long start=System.nanoTime();
		for (int i = 1; i < n; i++) {
			double temp = t[i].valuep;
			int j = i;
			while (j > 0 && t[j - 1].valuep > temp) {
				t[j].valuep = t[j - 1].valuep;
				t[j].value = t[j - 1].value;
				t[j].weight = t[j - 1].weight;
				j--;
			}
			t[j].valuep = temp;
			double temp1 = t[i].weight;
			t[i].weight = t[j].weight;
			t[j].weight = temp1;
			double temp2=t[i].value;
			t[i].value = t[j].value;
			t[j].value = temp2;
		}
		double total=0;
		int k=n-1;
		while(c>0&&k>=0) {
			if(c>=t[k].weight) {
				total+=t[k].value;
				c-=t[k].weight;
				k--;
			}else if(c<t[k].weight){//��������װ����
				total+=t[k].valuep*c;
				c=0;
			}
		}
		long end=System.nanoTime();
		System.out.println("����ʱ��Ϊ"+(end-start)/1000000.0+"ms");
		//System.out.println("�ܼ�ֵΪ"+total);
	}

	public static class things {
		double value;
		double weight;
		double valuep;
		
	}

}
