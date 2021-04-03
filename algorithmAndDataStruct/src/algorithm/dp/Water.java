package algorithm.dp;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 浇灌草场｛在一片草场上，有长度为L的线段，有N头奶牛在线段上吃草，每头牛的活动范围是一个开区间（S，E）并且可以重叠，John要安装喷水头浇灌草场。
 * 每个喷水头的喷洒半径可以随意调节。要求：
 * 1.线段上的每个整点恰好位于一个喷水头的喷洒范围内
 * 2.每头奶牛的活动范围要位于一个喷水头的喷洒范围内
 * 3.任何喷水头的喷洒范围不能超过线段的两端
 * 问：
 * 最少要安装多少个喷水头｝
 * 分析：
 * ｛
 * 划分为的子问题为：F[x]表示喷洒范围恰好覆盖直线上的区间[0,X]时，最少需要多少个喷头。
 *
 * X需要满足以下条件：
 *
 * 1.X为偶数
 *
 * 2.X不位于任何奶牛的活动范围内
 *
 * 3.X>=2A
 *
 * 4.当X>2B时，存在Y∈[X-2B,X-2A]且满足上述条件时，F[x] = F[y] +1(状态转移方程）
 *
 * 我们借助于优先级队列来找最小的F[y]
 *
 * 当求F[X]时，必须保证队列中的点的坐标必须位于[X-2B,X-2A]的范围内，
 *
 * 完全不允许点的坐标大于X-2A
 *
 * 当点的坐标小于X-2A时，pop出去即可
 *
 * 当求完F[X]时，可将二元组(X-2A+2,F(X-2A+2))放入队列，为下次求解做准备。｝
 *
 */

public class Water {

	static final int INFIITE = 1 << 30;
	static final int MAXL = 1000010;
	static final int MAXN = 1010;
	static int[] f = new int[MAXL];
	static int[] cowNum = new int[MAXL];
	static boolean[] cowThere = new boolean[MAXL];
	static int N, L, A, B;
	static Queue<Fx> queue = new PriorityQueue<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		L = scanner.nextInt();
		A = scanner.nextInt();
		B = scanner.nextInt();
		A <<= 1;
		B <<= 1;
		for (int i = 0; i < N; i++) {
			int s, e;
			s = scanner.nextInt();
			e = scanner.nextInt();
			cowNum[s + 1]++;
			cowNum[e]--;
		}
		int inCows = 0;
		for (int i = 0; i <= L; i++) {
			f[i] = INFIITE;
			inCows += cowNum[i];
			cowThere[i] = inCows > 0 ? true : false;
		}
		// 初始值
		for (int i = A; i <= B; i += 2) {
			if (!cowThere[i]) {
				f[i] = 1;
				if (i <= B + 2 - A) {
					queue.add(new Fx(i, 1));
				}
			}
		}
		// 计算值
		for (int i = B + 2; i <= L; i += 2) {
			if (!cowThere[i]) {
				Fx tmp = null;
				while (!queue.isEmpty()) {
					tmp = queue.peek();
					if (tmp.x < i - B) {
						queue.poll();
					} else {
						break;
					}
				}
				if (!queue.isEmpty()) {
					f[i] = tmp.f + 1;
				}
			}
			if (f[i - A + 2] != INFIITE) {
				queue.add(new Fx(i - A + 2, f[i - A + 2]));
			}
		}
		if (f[L] == INFIITE) {
			System.out.println(-1);
		} else {
			System.out.println(f[L]);
		}
	}

	static class Fx implements Comparable<Fx> {
		int x;
		int f;

		public Fx(int x, int f) {
			this.x = x;
			this.f = f;
		}

		@Override
		public int compareTo(Fx o) {
			return f - o.f;
		}

	}

}
