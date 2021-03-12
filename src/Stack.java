public class Stack {
    int size;
    int top=-1;
    int[] stack;
    Stack(int size){
        this.size=size;
        stack=new int[size];
    }

    int push(int value){
        if(top>size-1)return -1;
        return stack[++top]=value;
    }

    int pop(){
        if(top<0)return -1;
        return stack[top--];
    }

    public static void main(String[] args) {
        Stack stack1=new Stack(5);
        System.out.println(stack1.push(10));
        System.out.println(stack1.pop());
    }

}



