class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s1=new Stack<>();
        for(int i=0;i<logs.length;i++){
            if(!logs[i].equals("./") && !logs[i].equals("../"))
                s1.push(logs[i]);
            if(s1.size()>0 && logs[i].equals("../"))
                s1.pop();
        }
        return s1.size();
    }
}