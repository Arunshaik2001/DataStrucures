import java.util.LinkedList;

public class Queue {
    int size;
    int front=-1,rear=-1;
    LinkedList<Integer> queue;
    Queue(int size){
        this.size=size;
        this.queue=new LinkedList<>();
    }

    boolean push(int value){
        if (rear>size-2)return false;
        rear++;
        System.out.println(front+" "+rear);
        return queue.add(value);
    }

    int poll(){

        if (front==rear)return -1;
        return queue.remove(++front);
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        System.out.println(queue.push(5454));
        System.out.println(queue.poll());
    }

}
