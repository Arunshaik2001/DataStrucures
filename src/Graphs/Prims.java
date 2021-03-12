package Graphs;

import java.util.Arrays;
////////    (V-1)E


public class Prims {
    public static void main(String[] args)
    {
        /* Let us create the following graph
        2 3
        (0)--(1)--(2)
        | / \ |
        6| 8/ \5 |7
        | /     \ |
        (3)-------(4)
            9         */
        Prims t = new Prims();
        int min=Integer.MAX_VALUE;
        int[][] graph = new int[][] { {min , 2, min, 6, min },
                { 2, min, 3, 8, 5 },
                { 0, 3, min, min, 7 },
                { 6, 8, min , min, 9 },
                { min, 5, 7, 9, min } };

        // Print the solution
        int n=graph.length;
        t.primMST(graph,n);
    }

    private void primMST(int[][] graph,int n) {
        int[] near=new int[n];
        int min=Integer.MAX_VALUE;
        Arrays.fill(near,min);
        int[][] t=new int[2][n-1];
        int u=-1,v=-1;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (graph[i][j]<min){
                    min=graph[i][j];
                    u=i;v=j;
                }
            }
        }
        t[0][0]=u;t[1][0]=v;
        near[u]=near[v]=0;
        for (int i=0;i<n;i++){
            if (near[i]!=0 && graph[i][u]<graph[i][v])near[i]=u;
            else near[i]=v;
        }
        int k=-1;
        for(int i=1;i<n-1;i++){
            int minimum=Integer.MAX_VALUE;

            for (int j=0;j<n;j++){
                if (near[j]!=0 && graph[j][near[j]]<minimum){

                    minimum=graph[j][near[j]];
                    k=j;

                }
            }
            System.out.println(k);
            t[0][i]=k;t[1][i]=near[k];
            near[k]=0;
            for (int j=0;j<n;j++){
                if (near[j]!=0 && graph[j][k]<graph[j][near[j]])near[j]=k;

            }
        }

        printMyT(t,graph);



    }

    private void printMyT(int[][] t,int[][] graph) {
        for (int i=0;i<2;i++){
            for (int j=0;j<t.length;j++){
                System.out.println(t[0][j]+" "+t[1][j]+" "+graph[t[0][j]][t[1][j]]);
            }
        }
    }
}
