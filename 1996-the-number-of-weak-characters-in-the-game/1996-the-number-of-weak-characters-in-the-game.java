class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->{
            if(a[0]!=b[0])
                return b[0]-a[0];//sort desc if attack[i] is different
            else
                return a[1]-b[1];//else sort asc
        });
        int cnt=0;
        int maxdef=properties[0][1];
        for(int i=1;i<properties.length;i++){
            if(properties[i][1]<maxdef)
                cnt++;
            maxdef=Math.max(maxdef,properties[i][1]);
        }
        return cnt;
        
    }
}