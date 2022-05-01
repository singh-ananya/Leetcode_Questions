class Solution {
    public boolean backspaceCompare(String s, String t) {
       Stack<Character> s1=new Stack<Character>() ;
       Stack<Character> s2=new Stack<Character>() ;
        for(char ch : s.toCharArray()){
            if(ch=='#'){
                if(s1.size()>0)
                    s1.pop();
                continue;
            }
            s1.push(ch);
        }
        for(char ch : t.toCharArray()){
            if(ch=='#'){
                if(s2.size()>0)
                    s2.pop();
                continue;
            }
            s2.push(ch);
        }
        String res1="";
        String res2="";
        while(s1.size()>0){
            res1+=s1.pop();
        }
        while(s2.size()>0){
            res2+=s2.pop();
        }
        return res1.equals(res2);
        
        
    }
}