package leetCode.test;

public class Leet134 {

	public static void main(String[] args) {
		Leet134 leet134 = new Leet134();
		System.out.println(leet134.canCompleteCircuit(new int[] { 5, 1, 2, 3, 4 }, new int[] { 4, 4, 1, 5, 1 }));
	}

//低效算法
	public int canCompleteCircuit(int[] gas, int[] cost) {

		outer: for (int i = 0; i < gas.length; i++) {
			int count1 = 0;
			int count2 = 0;
			if (gas[i] >= cost[i]) {
				int j = i;
				do {
					count1 += gas[j];
					count2 += cost[j];
					if (count1 < count2) {
						continue outer;
					}
					j = (j + 1) % gas.length;
				} while (j != i);
				return i;
			}
		}
		return -1;
	}

//O(n)时间复杂度的算法
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int start = 0; // start position
		int remain = 0; // current remain gas
		int debt = 0; // previous trips owes gas

		for (int i = 0; i < gas.length; i++) {
			remain += gas[i] - cost[i];
			if (remain < 0) {
				debt += remain;
				start = i + 1;
				remain = 0;
			}
		}

		return remain + debt >= 0 ? start : -1;
	}
}
