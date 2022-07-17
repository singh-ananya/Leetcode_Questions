class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        if (s == null || s.length() == 0) return new int[]{};
        
        int res[] = new int[s.length()];
        for (int i = 0; i < res.length; i++) {
            int r = startPos[0], c = startPos[1];
            int cnt = 0;
            for (int j = i; j < res.length; j++) {
                char ch = s.charAt(j);
                if (ch == 'L')
                    c--;
                if (ch == 'R')
                    c++;
                if (ch == 'U')
                    r--;
                if (ch == 'D')
                    r++;
                if (r < 0 || r >= n || c < 0 || c >= n) {
                    break;
                }
                cnt++;
            }
            res[i] = cnt;
        }
        
        return res;
    }
}