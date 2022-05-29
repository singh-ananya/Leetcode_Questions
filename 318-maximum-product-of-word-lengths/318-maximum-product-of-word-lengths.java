class Solution {
    public int maxProduct(String[] words) {
        int multi = 0, max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words.length - 1; j++) {
                if (! check(words[i], words[j])) 
                    multi = words[i].length()* words[j].length();
                if (multi > max)
                    max = multi;
            } 
        }
        return max;
    }
    
     static int MAX_CHAR = 26;
     
    // function to return true if strings have
    // common substring and no if strings have
    // no common substring
    public static boolean check(String s1, String s2)
    {
        // array for storing character occurrences
        boolean v[]=new boolean[MAX_CHAR];
        Arrays.fill(v,false);
     
        // increment array index for every
        // character of str1
        for (int i = 0; i < s1.length(); i++)
            v[s1.charAt(i) - 'a'] = true;
         
        // checking common substring of str2 in str1
        for (int i = 0; i < s2.length(); i++)
            if (v[s2.charAt(i) - 'a'])
            return true;
         
        return false;    
    }
}