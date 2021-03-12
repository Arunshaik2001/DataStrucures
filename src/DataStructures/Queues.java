package DataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queues<T> {
    private int front,rear;
    private final int size;
    private final LinkedList<T> queues;
    Queues(int size){
        front=rear=-1;
        queues = new LinkedList<>();
        this.size=size;
    }

    public void add(T value){
        if (rear==size-1)return;
        queues.add(value);
        rear++;
    }

    public T remove(){
        if (front==rear)return null;
        T value = queues.removeFirst();
        front++;
        return value;
    }

    public static String getNextBinaryString(String currBinString){
        StringBuilder nextString=new StringBuilder(currBinString);
        for(int i=currBinString.length()-1;i>=0;i--){
            if (nextString.charAt(i)=='0'){
                nextString.replace(i,i+1,"1");
                break;
            }
            nextString.replace(i,i+1,"0");
        }
        boolean allZeros=true;
        String ans=nextString.toString();
        for (int i=0;i<currBinString.length();i++){
            if (ans.charAt(i)=='1'){
                allZeros=false;
                break;
            }
        }
        if (allZeros){
            return new StringBuilder(ans).insert(0,"1").toString();
        }
        return ans;
    }

    public static String[] findBin(int number) {
        String[] result = new String[number];
        if (number<1)return result;

        final Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i=0;i<number;i++){
            String num = queue.remove();
            result[i]=num;
            queue.add(getNextBinaryString(num));
        }
        return result;
    }

    public static <T> void reverseK(Queue<T> queue, int k) {
        // Write -- Your -- Code
        Stack<T> stack = new Stack<>();
        int size=queue.size();
        for (int i=0;i<k;i++){
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        for (int i=0;i<size-k;i++){
            queue.add(queue.poll());
        }
    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<arr.length;i++){

                while (!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                    result[stack.pop()]=arr[i];
                }
                stack.push(i);


        }
        while (!stack.isEmpty()){
            result[stack.pop()]=-1;
        }
        return result;
    }

    private static boolean knows(int a,int b,int[][] party){
        return party[a][b]==1;
    }

    public static int findCelebrity(int[][] party, int numPeople) {

        int firstPerson=0,secondPerson=1;
        while (firstPerson<numPeople && secondPerson<numPeople){
            if (knows(firstPerson,secondPerson,party)){
                firstPerson++;
            }
            else{
                secondPerson++;
            }
        }

        int potentialCeleb= Math.min(firstPerson, secondPerson);
        for (int i=0;i<numPeople;i++){
            if (i!=potentialCeleb && (!knows(i,potentialCeleb,party) || knows(potentialCeleb,i,party))){
                return -1;
            }
        }

        return potentialCeleb;
    }

    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();
        int length=exp.length();
        for (int i=0;i<length;i++){
            char brace=exp.charAt(i);
            if (brace=='('||brace=='{'||brace=='[')stack.push(brace);
            else{
                if (stack.isEmpty() || brace-stack.peek()>2)return false;
                stack.pop();
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String[] result = findBin(10);
        for (String value : result)System.out.println(value);
    }
}
