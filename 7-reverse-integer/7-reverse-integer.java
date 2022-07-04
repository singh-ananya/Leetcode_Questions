class Solution {
    public int reverse(int x) {
        int sign=1;
        
        
        
        if(x<0){
            sign=-1;
            x=x*(sign);
        }
        int temp=x;
        int rem=0;
        int res=0;
        int newRes=0;
        
        while(temp>0){
            rem=temp%10;
            newRes=newRes*10+rem;
            if((newRes-rem)/10!=res){
                return 0; //This part is for checking the overflow
            }
            res=newRes;
            temp=temp/10;
        }
        // System.out.println(sign*res);
        res=sign*res;
        return res;
    }
}