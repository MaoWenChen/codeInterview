package algorithm.sort;

public class FastSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 5, 7, 1, 4, 8 };
		fastSort(arr, 0, arr.length - 1);
		for (int num : arr) {
			System.out.println(num);
		}

	}

	public static void fastSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = division(arr, start, end);
		fastSort(arr, start, mid - 1);
		fastSort(arr, mid + 1, end);
	}

	public static int division(int[] arr, int start, int end) {
		int tmp = arr[start];
		int m = 0;
		for (int i = start; i <= end; i++) {
			if (tmp > arr[i]) {
				m = arr[i];
				arr[i] = arr[start];
				arr[start++] = m;
			} else if (tmp < arr[i]) {
				m = arr[i];
				arr[i] = arr[end];
				arr[end--] = m;
				i--;
			}
		}
		return start;
	}
}
