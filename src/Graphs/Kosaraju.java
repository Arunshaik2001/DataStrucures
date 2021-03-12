package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

///////   O(V)

public class Kosaraju {
    ArrayList<ArrayList<Integer>> arrayLists,arrayLists2;
    static Scanner scanner=new Scanner(System.in);
    Stack<Integer> stack;
    final int N,e;
    boolean[] visited;
    int[] color;
    Kosaraju(int N,int e){
        this.N=N;
        this.e=e;
        construct();
    }

    private void construct() {
        arrayLists=new ArrayList<>(this.N);
        arrayLists2=new ArrayList<>(this.N);
        visited=new boolean[N];
        color=new int[N];
        stack=new Stack<>();
        for(int i=0;i<N;i++){
            arrayLists.add(new ArrayList<>());
            arrayLists2.add(new ArrayList<>());
            visited[i]=false;
        }
        for(int i=0;i<e;i++){
            int s=scanner.nextInt(),e=scanner.nextInt();
            arrayLists.get(s).add(e);
            arrayLists2.get(e).add(s);
        }
        kosaraju();
    }

    private void kosaraju(){
        for (int i=0;i<N;i++){
            if(!visited[i]){
                dfs1(i);
            }
        }
        for (int i=0;i<N;i++)visited[i]=false;
        int c=0;
        while(!stack.empty()) {
            int par=stack.pop();
           if (!visited[par])dfs2(par, c++);

        }
        for (int i=0;i<N;i++)System.out.print(color[i]+" ");
    }

    private void dfs2(int parent,int color) {

        visited[parent]=true;
        this.color[parent]=color;
        for (int neigh:arrayLists2.get(parent)){
            if (!visited[neigh]){
                dfs2(neigh,color);
            }
        }

    }

    private void dfs1(int parent) {
        visited[parent]=true;
        for (int neigh:arrayLists.get(parent)){
            if (!visited[neigh])dfs1(neigh);
        }
        stack.push(parent);
    }


    public static void main(String[] args) {
        int n=scanner.nextInt(),e=scanner.nextInt();
        Kosaraju k=new Kosaraju(n,e);

    }
}
