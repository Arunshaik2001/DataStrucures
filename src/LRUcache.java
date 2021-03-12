import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUcache {
    final int windowSize;
    final LinkedList<Integer> window;
    final HashSet<Integer> entrySet;
    int pageFaults;
    LRUcache(int size){
        this.windowSize=size;
        window=new LinkedList<Integer>();
        entrySet= new HashSet<>();
        pageFaults=0;
    }

    public void refer(Integer value){

        if(!entrySet.contains(value)){
            if(entrySet.size()==windowSize){
                int last=window.removeLast();
                entrySet.remove(last);
            }
            pageFaults++;
        }
        else{
            window.removeLast();

        }
        window.addFirst(value);
        entrySet.add(value);

    }

    public void display(){
        for (Integer integer : window) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        
        LRUcache cache = new LRUcache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        System.out.println(cache.pageFaults);
        cache.display();
    }

}
