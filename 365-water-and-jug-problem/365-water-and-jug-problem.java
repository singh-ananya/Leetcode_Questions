class Solution {
    public boolean canMeasureWater(int j1, int j2, int t) {
        if (t > j1 + j2) return false;
        boolean[] v = new boolean[j1 + j2 + 1];        
        return dfs(v, j1, j2, 0, t);
    }
    public boolean dfs(boolean[] v, int j1, int j2, int c, int t) {  
        
        if (c < 0 || c > j1 + j2 || v[c]) return false;
        v[c] = true;
        if (c == t) return true;
        return dfs(v, j1, j2, c + j1, t) ||
            dfs(v, j1, j2, c - j1, t) ||
            dfs(v, j1, j2, c + j2, t) ||
            dfs(v, j1, j2, c - j2, t);
            
    }
}