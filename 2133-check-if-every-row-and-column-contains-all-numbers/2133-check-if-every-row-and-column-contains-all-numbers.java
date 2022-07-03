class Solution {
    public boolean checkValid(int[][] matrix) {
        boolean[][] ith = new boolean[matrix.length][matrix.length];
        boolean[][] jth = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int value = matrix[i][j];
                if (ith[i][value - 1]) {
                    return false;
                }
                ith[i][value - 1] = true;
                if (jth[j][value - 1]) {
                    return false;
                }
                jth[j][value - 1] = true;
            }
        }
        return true;
    }
}