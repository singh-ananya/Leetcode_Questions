class Solution {
    // we will find number of components in the graph, for n components we need n-1 wires to connect
    //so in this ques we will count number of components by union fine
    // if par[i]==i then it means there is one comp, then we will increase the count of component.
    int par[];
    int size[];
    public int findPar(int u){
        if(par[u]==u)
            return u;
        return par[u]=findPar(par[u]);
    }
    public void merge(int p1,int p2){
        if(size[p1]>=size[p2]){
            par[p2]=p1;
            size[p1]+=size[p2];
        }else{
            par[p1]=p2;
            size[p2]+=size[p1];
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
        for(int[] edge:connections){
            int u=edge[0];
            int v=edge[1];
            int p1=findPar(u);
            int p2=findPar(v);
            if(p1!=p2)
                merge(p1,p2);
        }
        int comp=0;
        for(int i=0;i<n;i++)
        {
            int p=findPar(i);
            if(p==i)
                comp++;
        }
        return comp-1;
    }
}