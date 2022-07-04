class Solution {
    //tc=o(n)
    //sc=0(n)
    //if the (i-1)th & ith children has same rating then ith child recieves no extra candy but if ith child have larger rating then (i-1)th then ith child recieves children[i-1]+1 candies. The children array is actually store the number of candies for each child.
//I'm traversing the ratings array twice, first time in forward direction & second time in backward direction if the ratings array has any parts which are in decending order.
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