package leetCode.test;

public class Leet1008 {
	
	public static void main(String[] args) {
		System.out.println(minDominoRotations1(new int[] {5,2,6,2,3,2}, new int[] {2,1,2,4,2,2}));;
	}

	public int minDominoRotations(int[] A, int[] B) {
		if (A.length!=B.length) {
			return -1;
		}
		int[][] dp = new int[A.length+1][7];
		for(int i = 1;i<=A.length;i++) {
			for (int j = 1; j <= 6; j++) {
				if (dp[i-1][j]!=-1&&(A[i-1]==j||B[i-1]==j)) {
					dp[i][j] = A[i-1]==j?dp[i-1][j]:dp[i-1][j]+1;
				}else  {
					dp[i][j]=-1;
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for(int i = 1;i<=6;i++) {
			if (dp[A.length][i]!=-1) {
				res = Math.min(res, dp[A.length][i]);
			}
		}
		return Integer.MAX_VALUE==res?-1:res;
	}
	
	public static int minDominoRotations1(int[] A, int[] B) {
		if (A.length!=B.length) {
			return -1;
		}
		int[] a = new int[7];
		int[] b = new int[7];
		int maxA = 0;
		int maxB = 0;
		int indexA = 0;
		int indexB = 0;
		for(int i = 0;i<A.length;i++) {
			a[A[i]]++;
			b[B[i]]++;
		}
		for (int i = 1; i < 7; i++) {
			if (maxA<a[i]) {
				maxA = a[i];
				indexA = i;
			}
			if (maxB<b[i]) {
				maxB = b[i];
				indexB = i;
			}
		}
		int resA = 0;
		int resB = 0;
		for(int i = 0;i < A.length;i++) {
			if (resA!=-1) {
				resA = A[i]==indexA?resA:B[i]==indexA?resA+1:-1;
			}
			if (resB!=-1) {
				resB = B[i]==indexB?resB:A[i]==indexB?resB+1:-1;
			}
		}
		return resA==-1?resB:resB==-1?resA:Math.min(resA, resB);
		
	}
}
