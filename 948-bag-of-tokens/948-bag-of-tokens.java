class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length==0)
            return 0;
        Arrays.sort(tokens);
        if(tokens[0]>power)
            return 0;
        int li=0;
        int hi=tokens.length-1;
        int score=0;
        while(li<hi){
            if(tokens[li]<=power){
                power-=tokens[li];
                li++;
                score++;
            }else{
                power+=tokens[hi];
                hi--;
                score--;
            }
        }
        if(tokens[li]<=power){
            score++;
        }
        return score;
    }
}