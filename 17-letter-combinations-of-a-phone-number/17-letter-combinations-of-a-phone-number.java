class Solution {
    String []code={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        
        
        List<String> ans=getPhoneNumbers(digits);
        return ans;
        
    }
    public List<String> getPhoneNumbers(String str){
        if(str.length()==0){
            List<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        List<String> res=getPhoneNumbers(ros);
        List<String> myres=new ArrayList<>();
        String codeforch=code[ch-'0'];
        for(int i=0;i<codeforch.length();i++){
            char chcode=codeforch.charAt(i);
            for(String j:res){
                myres.add(chcode+j);
            }
        }
        return myres;
    }
    
}