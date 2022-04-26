class Solution {
    class UnionFind {
        int[] parent;
        int[] weight;
        
        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }
        
        public boolean union(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);
            
            if (rootA == rootB) {
                return false;
            }
            
            if (weight[rootA] > weight[rootB]) {
                weight[rootA] += weight[rootB];
                parent[rootB] = rootA;
            } else {
                weight[rootB] += weight[rootA];
                parent[rootA] = rootB;
            }
            
            return true;
        }
        
        private int root(int a) {
            if (a == parent[a]) {
                return a;
            }
            
            parent[a] = root(parent[a]);
            return parent[a];
        }
    }

    class ConnectionComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[2], b[2]);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new ConnectionComparator());
        
        int len = points.length;
        
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                pq.offer(new int[]{i, j, distance(points[i], points[j])});
            }
        }
        
        UnionFind uf = new UnionFind(len);

        int connectionCount = 0;
        int cost = 0;
        while(connectionCount < len - 1) {
            int[] connection = pq.poll();
            
            if (uf.union(connection[0], connection[1])) {
                cost += connection[2];
                connectionCount++;
            }
        }
        
        return cost;
    }
    
    private int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}