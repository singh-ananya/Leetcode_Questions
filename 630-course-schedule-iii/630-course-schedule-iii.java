class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(int[] a,int[] b)->{  //lambda function to sort array on the basis of last day
            return a[1]-b[1];
        });
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        int time = 0;
        for(int[] course: courses) {
            int duration = course[0], lastDay = course[1];
            time += duration;
            heap.add(duration);
            // if pass the last day, remove courses these take longest time.
            if(time > lastDay) {
                time -= heap.poll();
            }
        }
        return heap.size();
    }
}