class Solution {
    public boolean checkXMatrix(int[][] grid) {
      int i = 0, j = 0;
		int n = grid.length;
		for (i = 0; i < n; i++) {
			for (j = 0; j < grid[i].length; j++) {
				if (i == j || i + j == n - 1) {
					if (grid[i][j] == 0)//diagonal
						return false;
				} else {//non -diagonal
					if (grid[i][j] != 0)
						return false;
				}
			}
		}
		return true;  
    }
}