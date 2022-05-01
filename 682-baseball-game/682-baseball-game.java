class Solution {
    public int calPoints(String[] ops) {
        //int sum=0;
        Stack<String> st=new Stack<>();
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")){
               st.pop(); 
            }else if(ops[i].equals("D")){
                int x=Integer.parseInt(st.peek());
                st.push(Integer.toString(x*2));
            }else if(ops[i].equals("+")){
                String x=st.pop();
                String y=st.peek();
                int ans=Integer.parseInt(x)+Integer.parseInt(y);
                st.push(x);
                st.push(Integer.toString(ans));
                
            }else{
                st.push(ops[i]);
            }
        }
        int sum=0;
        int r=0;
        for(int i=0;i<st.size();i++){
            r=Integer.parseInt(st.get(i));
            sum+=r;
        }
        return sum;
    }
}