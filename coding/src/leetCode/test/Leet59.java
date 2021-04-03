package leetCode.test;

public class Leet59 {
	public int[][] generateMatrix(int n) {
		int[][] area = new int[n][n];
		int num = 1;
		int rowi = 0;
		int rowj = n - 1;
		int coli = 0;
		int colj = n - 1;
		while (rowi <= rowj || coli <= colj) {
			for (int i = coli; i <= colj&&rowi<=rowj; i++) {
				area[rowi][i] = num++;
			}
			rowi++;
			for (int i = rowi; i <= rowj&&coli<=colj; i++) {
				area[i][colj] = num++;
			}
			colj--;
			for (int i = colj; i >= coli&&rowi<=rowj; i--) {
				area[rowj][i] = num++;
			}
			rowj--;
			for (int i = rowj; i >= rowi&&coli<=colj; i--) {
				area[i][coli] = num++; 
			}
			coli++;
		}
		return area;

	}
}
