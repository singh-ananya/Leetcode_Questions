class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int n1=nums1.length;
        int n2=nums2.length;
        int sum=n1+n2; 
        int[] merged=new int[sum]; //New Arrays For Merge
        int i;
        for(i=0;i<n1;i++){
            merged[i]=nums1[i]; //Adding nums1 Elements in Merge
        }
        int k=0;
        for(int j=i;j<sum;j++){  //Here j=1 for Staring Next Vacant Location Of Merge Array
            merged[j]=nums2[k++]; //Start k=0 So that All Elements of nums2 Will Add.
        }
        Arrays.sort(merged); //Sort Merged Arrays For Safety Purpose
        int ress=0;
        int n = merged.length / 2;  //For Getting Middle Term/
        if (merged.length % 2 == 0){  //If Merged Array Length Is Even
           return (float)(merged[n-1] + merged[n])/2;
        }
        else {  //If Merged Array Length Is Odd.
           return (float)merged[n];
        } 
    }
}