import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Node
{

    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        // TODO Auto-generated constructor stub
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Hello {

    static void storeit(Stack<Node > st1, Node r1){
        while(r1!=null){
            System.out.println(r1.data);
            st1.push(r1);
            r1=r1.left;
        }
    }



    static ArrayList<Integer> merge(Node root1, Node root2)
    {
        //Your code here
        Stack<Node > st1=new Stack<>(),st2=new Stack<>();
        ArrayList<Integer> v=new ArrayList<>();
        if(root1==null && root2==null)return v;
        Node t1=root1,t2=root2;
        storeit(st1,t1);
        storeit(st2,t2);

        while(!st1.empty() && !st2.empty()){
            t1=st1.peek();
            t2=st2.peek();
            System.out.println(t1.data +"   "+t2.data);
            if(t1.data > t2.data){

                v.add(t2.data);
                st2.pop();
                if(t2.right!=null)st2.push(t2.right);
                storeit(st2,t2.right);
            }else if(t1.data < t2.data){

                v.add(t1.data);
                st1.pop();
                if(t1.right!=null)st1.push(t1.right);

                storeit(st1,t1.right);
            }else {

                v.add(t2.data);
                v.add(t1.data);
                st1.pop();
                st2.pop();
                if(t2.right!=null)st2.push(t2.right);
                if(t1.right!=null)st1.push(t1.right);
                storeit(st1,t1.right);
                storeit(st2,t2.right);
            }

        }

        while(!st1.empty()){
            v.add(st1.peek().data);

            st1.pop();
        }

        while(!st2.empty()){
            v.add(st2.peek().data);

            st2.pop();
        }



        return v;

    }
    static int checkSpruceBaby(char[][] v,int i,int j,int m,int n){
        int cnt=0;
        int k=2;
        for( int l=i+1 ; l<k && k<=m ; l++){
            for(int o = j-l+1 ; o >= 0 && o <= j+l && o < n ; o++){
                if( v[l][o] == '.' ) return cnt;
            }
            k++;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[]args)
    {
        Scanner scan=new Scanner(System.in);

        int t;
        t=scan.nextInt();
        while(t-->0){
            int n;
            n=scan.nextInt();

            int[] v=new int[n];
            for(int i=0;i<n;i++)v[i]=scan.nextInt();
            int[] v1=getSumAbsoluteDifferences(v);
            for (int i = 0; i <n ; i++) {
                System.out.print(v1[i]+" ");
            }
        }
    }


    static public int[] getSumAbsoluteDifferences(int[] arr) {
        int n = arr.length;
        int[] result=new int[n];
        int sum=0,sub=0;
        for(int i=0;i<n;i++)sum+=arr[i];
        for (int i = 0; i < n; i++)
        {
            sum -= arr[i];

            int ans=sub + (i * arr[i]) -
                    ((n -i- 1) *arr[i]) + sum;
            result[i]=ans;

            sub -= arr[i];
        }
        System.out.println(sub);
        return result ;
    }

}
