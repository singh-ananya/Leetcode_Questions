class Solution {
    public boolean isValid(String s) {
       ArrayList<Character> st=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='{' || ch=='[' || ch=='('){
                st.add(ch);
            }else{
                if(st.size()==0)
                    return false;
                int idx=st.size()-1;
                if(ch=='}'){
                    if(st.get(idx)=='{')
                        st.remove(idx);
                    else
                        return false;
                }
                if(ch==']'){
                    if(st.get(idx)=='[')
                        st.remove(idx);
                    else
                        return false;
                }
                if(ch==')'){
                    if(st.get(idx)=='(')
                        st.remove(idx);
                    else
                        return false;
                }
            }
        }
        if(st.size()!=0)
            return false;
        return true;
    }
}