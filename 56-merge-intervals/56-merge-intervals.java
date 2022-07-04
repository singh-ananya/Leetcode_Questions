class Solution {
    public static class Pair implements Comparable<Pair>{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
            
        }
        public int compareTo(Pair o){
            if(this.first!=o.first){
                return this.first-o.first;
            }
            else{
                return this.second-o.second;
            }
        }
    }
    public int[][] merge(int[][] intervals) {
        Pair pairs[]=new Pair[intervals.length];
    
        for(int i=0;i<intervals.length;i++){
            pairs[i]=new Pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<pairs.length;i++){
            if(i==0){
                st.push(pairs[i]);
            }else{
                Pair top=st.peek();
                if(pairs[i].first>top.second){
                    st.push(pairs[i]);
                }
                else{
                    top.second=Math.max(top.second,pairs[i].second);
                    //st.push(top);
                    st.pop();
                    st.push(top);
                }
            }
        }
        Stack<Pair> rs=new Stack<>();
        while(st.size()>0){
            rs.push(st.pop());
        }
        int ans[][]=new int[rs.size()][2];
        int size=rs.size();
        for(int i=0;i<size;i++){
            Pair p=rs.pop();
            ans[i][0]=p.first;
            ans[i][1]=p.second;
            
        }
        return ans;
    }
}