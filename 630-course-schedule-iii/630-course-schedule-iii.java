class Solution {
// Sort courses by last day in ascending order.
// Max Heap to track the max duration courses using Priority Queue.
// Time + duration and put duration to max heap.
// If pass the last day, remove the courses takes longest time.
// Heap size is the max courses number we take.
// Time complexity: O(n.logn)
// Space complexity: O(n)
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(int[] a,int[] b)->{  //lambda function to sort array on the basis of last day
            return a[1]-b[1];
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;//sort in desc order, max heap
        });
        int time = 0;
        for(int c[]:courses){
            int duration=c[0];
            int lastday=c[1];
            pq.add(duration);
            time+=duration;
            if(time>lastday){
                time-=pq.remove();  
            }
        }
        return pq.size();
    }
}