class Solution {
    //by using kahn's algo
    //BFS algo to find cycle in directed graph
    //topological sort by using BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int e[]:prerequisites){
            int a=e[0];
            int b=e[1];
            graph.get(b).add(a);
            
        }
        int vis[]=new int[numCourses];
        int ind[]=new int[numCourses];
        for(int u=0;u<numCourses;u++){
            for(int v:graph.get(u)){//increase indegree of v that starts from the given u i.e the number of dependent source node on dest node
                ind[v]++;
            }
        }
        Queue<Integer> q=new ArrayDeque<>();
        ArrayList<Integer> topo=new ArrayList<>();
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0){
                q.add(i);
                topo.add(i);
            }
        }
        while(q.size()>0){
            int t=q.remove();
            for(int nbr:graph.get(t)){
                ind[nbr]--;//decrease indegree because no of dependent nodes are decreasing
                if(ind[nbr]==0){
                    q.add(nbr);
                    topo.add(nbr);
                }
            }
        }
        if(topo.size()==numCourses){ // if topological order is eqaul to no of nodes means no cycle
            int ans[]=new int[numCourses];
            int k=0;
            for(int i=0;i<numCourses;i++){
                ans[k++]=topo.get(i);
            }
            return ans;
        }else{// we detected cycle because there some elements whose indegree never becomes 0 , no sol exists
            return new int[]{};
        }
    }
}