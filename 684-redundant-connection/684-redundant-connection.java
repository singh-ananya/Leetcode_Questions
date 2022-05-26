class Solution {
    int[] par;
    int[] size;
    public int findPar(int u){
        if(par[u]==u)
            return u;
        int p=findPar(par[u]);
        par[u]=p;
        return p;
    }
    public void merge(int p1,int p2){
        if(size[p1]>=size[p2]){
            par[p2]=p1;
            size[p1]+=size[p2];
        }else{
            par[p1]=par[p2];
            size[p2]+=size[p1];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
       ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=edges.length;i++)
            graph.add(new ArrayList<>());
        par=new int[edges.length+1];
        size=new int[edges.length+1];
        
        
        for(int i=1;i<=edges.length;i++){
            par[i]=i;
            size[i]=1;
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int p1=findPar(u);
            int p2=findPar(v);
            if(p1!=p2)
            {  
                merge(p1,p2);
                graph.get(p1).add(p2);
                graph.get(p2).add(p1);
            }
            else
                return edge;
        }
        return new int[]{};
        
    }
}