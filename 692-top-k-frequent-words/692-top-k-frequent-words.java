class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> mp=new HashMap<>();
        for(String word:words){
            mp.put(word,mp.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>(){
           //@override
            public int compare(String s1,String s2){
                if(mp.get(s1)==mp.get(s2))
                    return s2.compareTo(s1);
                return mp.get(s1)-mp.get(s2);
            }
        });
        for(String word:mp.keySet()){
            pq.add(word);
            if(pq.size()>k)
                pq.remove();
        }
        List<String> ans=new ArrayList<>();
        while(pq.size()>0){
            ans.add(pq.remove());
        }
     Collections.reverse(ans);
        return ans;
    }
}