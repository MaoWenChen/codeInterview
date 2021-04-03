package leetCode.test;

public class Leet1005 {

	public static void main(String[] args) {
		System.out.println(new Leet1005().largestSumAfterKNegations(new int[] { 2,-3,-1,5,-4 }, 2));
	}

	public int largestSumAfterKNegations(int[] A, int K) {
		int sum = 0;
		for (int i = ((A.length - 1) - 1) / 2; i >= 0; i--) {
			downshift(A, i);
		}
		for (int i = 0; i < K; i++) {
			int tmp = A[0];
			tmp = tmp == 0 ? tmp : -tmp;
			A[0] = tmp;
			downshift(A, 0);
		}
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		return sum;
	}

	public void downshift(int[] A, int index) {
		int parent = index;
		int tmpVal = A[index];
		int cur = 2 * index + 1;
		int curVal = A[cur];
		while (cur < A.length) {
			curVal = A[cur];
			if (cur + 1 < A.length && curVal > A[cur + 1]) {
				cur++;
				curVal = A[cur];
			}
			if (curVal<tmpVal) {
				A[parent] = curVal;
				parent = cur;
				cur = cur * 2 + 1;
			}else {
				break;
			}
		
		}
		A[parent] = tmpVal;
	}

	public void upShift(int[] A, int index) {
		int tmpVal = A[index];
		int cur = index;
		int curVal = A[cur];

		while (cur - 1 >= 0) {
			int parent = (cur - 1) / 2;
			if (A[parent] > tmpVal) {
				A[cur] = A[parent];
				cur = parent;
			} else {
				break;
			}
		}
		A[cur] = tmpVal;

	}

}
