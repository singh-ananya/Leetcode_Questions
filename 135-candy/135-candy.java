class Solution {
    public int candy(int[] ratings) {
        int candy=0;
        int children[]=new int[ratings.length];
        for(int i=0;i<ratings.length;i++){
            children[i]=1;
        }
        for(int i=1;i<ratings.length;i++){
            if((ratings[i-1]<ratings[i]) && (children[i-1]>=children[i])){
                children[i]=children[i-1]+1;
            }else if((ratings[i-1]>ratings[i]) && (children[i]>=children[i-1])){
                children[i-1]=children[i]+1;
            }
        }
        for(int i=ratings.length-1;i>=1;i--){
            if((ratings[i] > ratings[i-1]) && (children[i] <= children[i-1])) {
                children[i] = children[i-1] + 1;
            }
            else if((ratings[i] < ratings[i-1]) && (children[i] >= children[i-1])) {
                children[i-1] = children[i] + 1;
            }
        }
        for(int i=0 ;i<children.length ;i++) {
            candy += children[i];
        }
        return candy;
    }
}