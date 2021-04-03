package leetCode.test;

public class Leet36 {
	
	public boolean isValidSudoku(char[][] board) {
        int[][] rowMap = new int[9][9];
        int[][] columnMap = new int[9][9];
        int[][][] subBoxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - 48 - 1;
                if (rowMap[i][value] != 0) {
                    return false;
                }
                //mark exist
                rowMap[i][value] = 1;

                if (columnMap[j][value] != 0) {
                    return false;
                }
                columnMap[j][value] = 1;

                int subX = i / 3;
                int subY = j / 3;
                if (subBoxes[subX][subY][value] != 0) {
                    return false;

                }
                subBoxes[subX][subY][value] = 1;
            }
        }

        return true;
    }
}
