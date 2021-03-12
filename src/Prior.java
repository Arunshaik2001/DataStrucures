import java.util.Collections;
import java.util.PriorityQueue;

public class Prior implements Comparable<Prior>{
    int x,y;
    Prior(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Prior p2){
        if(this.y>p2.x)return 1;
        return this.x-p2.x;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>(5, Collections.reverseOrder());
        priorityQueue.add(23);
        priorityQueue.add(12);
        priorityQueue.add(1000);
        System.out.println(priorityQueue.poll());
    }

}



