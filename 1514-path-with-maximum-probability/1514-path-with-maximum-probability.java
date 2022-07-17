 class Pair implements Comparator<Pair>{
        int v;
        double prob;
        Pair(int v,double prob){
            this.v=v;
            this.prob=prob;
        }
     Pair(){
         
     }
        @Override
        public int compare(Pair p1,Pair p2){
            if(p1.prob<p2.prob)
                return 1;
            else if(p1.prob>p2.prob)
                return -1;
            else 
                return 0;
        }
    }
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Pair>());
        }
       
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        HashSet<Integer> hs = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(n,new Pair());
        pq.offer(new Pair(start,1.0));
        while(pq.size()>0){
            Pair node=pq.remove();
            int v=node.v;
            double prob=node.prob;
            hs.add(v);
            if(end==v)
                return prob;
            for(Pair temp:graph.get(v)){
                if(!hs.contains(temp.v))
                    pq.add(new Pair(temp.v,prob*temp.prob));
            }
        }
        return 0;
        
    }
}