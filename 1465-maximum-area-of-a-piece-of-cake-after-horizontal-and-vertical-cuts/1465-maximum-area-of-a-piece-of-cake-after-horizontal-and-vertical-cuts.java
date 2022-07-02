class Solution {
    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        
        int hcDiff= hCuts[0]-0;
        int vcDiff= vCuts[0]-0;
        
        for(int i=1; i<hCuts.length;i++) hcDiff= Math.max(hcDiff, hCuts[i]-hCuts[i-1]);
        hcDiff= Math.max(hcDiff, h- hCuts[hCuts.length-1]);
        
        for(int i=1; i<vCuts.length;i++) vcDiff= Math.max(vcDiff, vCuts[i]-vCuts[i-1]);
        vcDiff= Math.max(vcDiff, w- vCuts[vCuts.length-1]);
        return(int)(((long)hcDiff*vcDiff)%1000000007);
    }
}