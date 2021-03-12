package Graphs;

import java.util.Arrays;
import java.util.Scanner;


//////E(logE)+ElogV

public class MST {
    static int N;
    static int[] parent;
    MST(int n){
        N=n;
        construct();
    }

    private void construct() {
        parent=new int[N];
        for (int i=0;i<N;i++){
            parent[i]=i;
        }
    }

    static private int find(int a){
        if (parent[a]==a)return a;
        return find(parent[a]);
    }

    static void  union(int a,int b){
        int p1=find(a);
        int p2=find(b);
        parent[p2]=p1;

    }

    static void kruskal(Edge[] edges,int n,int e){
        Edge[] edges1=new Edge[n-1];
        int cnt=0,i=0;
        while(cnt<n-1 && i<e){
            Edge edge=edges[i];
            int s1=edge.s;
            int e1=edge.e;
            int p1=find(s1),p2=find(e1);
            if(p1==p2){
                i++;
                continue;
            }
            union(p1,p2);
            edges1[cnt]=new Edge();
            edges1[cnt].s=s1;
            edges1[cnt].e=e1;
            edges1[cnt].wt=edge.wt;
            i++;
            cnt++;
        }
        for(int j=0;j<n-1;j++){
            System.out.print(edges1[j].s+" ");
            System.out.print(edges1[j].e+" ");
            System.out.println(edges1[j].wt);

        }
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),e=scanner.nextInt();
        MST mst=new MST(n);

        Edge[] edges=new Edge[e];
        for(int i=0;i<e;i++){
            edges[i]=new Edge();
            edges[i].s=scanner.nextInt();
            edges[i].e=scanner.nextInt();
            edges[i].wt=scanner.nextInt();
        }
        Arrays.sort(edges);

        kruskal(edges,n,e);
    }
}

class Edge implements Comparable<Edge>{
    int s,e,wt;

    @Override
    public int compareTo(Edge edge){
        return this.wt-edge.wt;
    }
}

