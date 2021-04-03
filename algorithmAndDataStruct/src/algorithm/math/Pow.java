package algorithm.math;


import java.lang.reflect.Proxy;
import java.util.Date;

public class Pow {
	
	public static void main(String[] args) {
		test();
		Date date= new Date();
		System.out.println(date.getTime());
		System.out.println(0.001==0.001);
		
	}

	public static double pow(double x, int n) {
		if (n==0) {
			return 1;
		}else if(n<0){
			return 1/x*pow(1/x, -(n+1));
		}else {
			return (n&1)==1?x*pow(x*x, n>>1):pow(x*x, n>>1);
		}
	}
	
	public static void test() {
		String str = "asd,cm,tt,feng,cf,dnf,空防国保支队,方盛雄,杨苑林,龙映,张小纯,侯瑞林,姜长春,蔡妍珊,李胜,黄创彬,彭柯,赵荣霞,于冰,王东亚,李海钰,周钊锋,冯煜瑜,空房国保护支队大屏,测试用户1,宋莎莎,荀宇阳,测试员01,监管员,夏侯康,监管,监管1,监管2";
		System.out.println(str.split(",").length);
	}
	
}
