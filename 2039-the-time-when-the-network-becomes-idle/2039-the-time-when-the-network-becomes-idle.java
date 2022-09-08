class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<patience.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] dist=dijkestra(graph);int ans = 0;
        
		
		// performing the calculations discussed above for each index
        for(int x = 1; x < patience.length ; x++) {
            
			// round trip time
            int time = 2*dist[x];
			
            int p = patience[x];
			
			//total number of messages the station will send until it receives the reply of first message
            int numberOfMessagesSent = (time)/p;
            
			//handling an edge case if round trip time is a multiple of patience example time =24 patience = 4  
			//then the reply would be received at 24 therefore station will not send any message at t = 24 
            if(time%p == 0) {
                numberOfMessagesSent--;
            }
        
		// time of last message
            int lastMessage = numberOfMessagesSent*p;
			
			// updating the ans to store max of time at which the station becomes idle
            ans = Math.max(ans,lastMessage+ 2*dist[x]+1);
            
        }

        return ans;
    }
    public int[] dijkestra(ArrayList<ArrayList<Integer>> graph){
        int n=graph.size();
        int dist[]=new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[]{0,0});
        while(pq.size()>0){
            int node[]=pq.remove();
            if(!vis[node[0]]){
                vis[node[0]]=true;
                for(int nbr:graph.get(node[0])){
                    if(dist[nbr]>dist[node[0]]+1){
                        dist[nbr]=dist[node[0]]+1;
                        pq.add(new int[]{nbr,dist[nbr]});
                    }
                }
            }
            
        }
        return dist;
    }
}