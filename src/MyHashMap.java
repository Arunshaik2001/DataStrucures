public class MyHashMap<K,V> {
    private static class Entry<K,V>{
        final K key;
        V value;
        Entry next=null;

        Entry(K key,V val){
            this.key=key;
            this.value=val;
        }

    }

    private static final int SIZE=16;
    private Entry entries[]=new Entry[SIZE];

    void put(K key,V val){
        int index=key.hashCode()%SIZE;
        Entry entry=entries[index];
        if(entry==null){
            entry= new Entry(key, val);
            entries[index]=entry;
        }
        else{
            while(!entry.key.equals(key)){
                if (entry.next==null)break;
                entry=entry.next;
            }
            if (!entry.key.equals(key) && entry.next==null){
                entry.next= new Entry(key, val);
                entry=entry.next;
            }
            entry.value=val;
        }
    }

    V get(K key){

        int index=key.hashCode()%SIZE;
        Entry entry=entries[index];
        if (entry==null)return null;
        while(!entry.key.equals(key)){
            if (entry.next==null)break;
            entry=entry.next;
        }
        if (entry.key.equals(key))return (V)entry.value;
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap = new MyHashMap<>();

        myHashMap.put("Awadh", "SSE");
        myHashMap.put("Rahul", "SSE");
        myHashMap.put("Sattu", "SE");
        myHashMap.put("Awadh", "SE");

        System.out.println(myHashMap.get("Awadh"));

    }
}


