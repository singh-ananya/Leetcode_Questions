class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
         //sort the array in decreasing order of units in the box
        Arrays.sort(boxTypes,(a,b) -> b[1] - a[1]);
        
        int res = 0;
        
        for(int[] ar : boxTypes){
            if(ar[0] > truckSize){
                res = res + (truckSize * ar[1]);
                return res;
            }
            else{
                res = res + (ar[0] * ar[1]);
                truckSize = truckSize - ar[0];
            }
        }   
        return res;       
                

    }
}