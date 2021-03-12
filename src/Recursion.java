import java.util.ArrayList;

public class Recursion {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int a[]=new int[23];
        recursion(arrayList,a,6);
        for (int val:arrayList)System.out.println(val);
        System.out.println("aaa");
        for(int i=0;i<23;i++)System.out.println(a[i]);
    }

    private static void recursion(ArrayList<Integer> arrayList, int[] a,int n) {
        if(n==0)return;
        a[n]=n;
        arrayList.add(n);
        recursion(arrayList,a,n-1);
    }
}
