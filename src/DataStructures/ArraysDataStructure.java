package DataStructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ArraysDataStructure {

    public static String arrayToString(int arr[]){
        if (arr.length > 0){
            String result = "";
            for(int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        }
        else {
            return "Empty Array!";
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, -5};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + arrayToString(prodArray));
    }

    private static int[] removeEvenIntegers(int[] myArray) {
        int evenArray[]=new int[myArray.length];
        int index=0;
        for (int i=0;i<myArray.length;i++){
            if(myArray[i]%2!=0)evenArray[index++]=myArray[i];
        }
        return evenArray;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2)
    {
        // write your code here
        int arr1Length=arr1.length,arr2Length=arr2.length;
        int[] resultantArray=new int[arr1Length+arr2Length];
        int firstPointer=0,seconPointer=0,index=0;
        while (firstPointer<arr1Length && seconPointer<arr2Length){
            if (arr1[firstPointer]<arr2[seconPointer]){
                resultantArray[index++]=arr1[firstPointer++];
            }
            else{
                resultantArray[index++]=arr1[seconPointer++];
            }
        }
        while (firstPointer<arr1Length)resultantArray[index++]=arr1[firstPointer++];
        while (seconPointer<arr2Length)resultantArray[index++]=arr1[seconPointer++];
        return resultantArray; // make a new resultant array and return your results in that
    }

    public static int[] findTwoElementSumUsingSorting(int[] arr, int n)
    {
        int[] result = new int[]{-1,-1};
        Arrays.sort(arr);
        int start=0,end=arr.length-1;
        while(start<end){
            int sum=arr[start]+arr[end];
            if (sum>n){
                end--;
            }
            else if (sum<n){
                start++;
            }
            else{
                return new int[]{arr[start],arr[end]};
            }
        }
        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static int[] findTwoElementSumUsingSet(int[] arr, int n)
    {
        int[] result = new int[]{-1,-1};
        int length=arr.length;
        // write your code here
        HashSet<Integer> sumSet = new HashSet<>();
        for (int j : arr) {
            if (sumSet.contains(n - j)) return new int[]{j, n - j};
            sumSet.add(j);
        }
        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static int[] findProduct(int arr[])
    {


        // write your code here
        int product=1,length=arr.length,cnt=0;
        for (int i=0;i<length;i++)if (arr[i]!=0){
            if (arr[i]<0)cnt++;
            product*=arr[i];
        }
        for (int i=0;i<length;i++){
            if (arr[i]==0)arr[i]=product;
            else{
                int value=product;
                if (arr[i]<0){
                    if (((cnt-1)&1)==1)value*=-1;
                }
                arr[i]=value/arr[i];
            }
        }
        return arr;
    }

    public static int findMiniumInArray(int[] arr)
    {
        int result = Integer.MAX_VALUE;
        int n=arr.length;
        for (int i=0;i<n;i++){
            result = Math.min(arr[i],result);
        }
        // write your code here
        return result;
    }

    public static int findFirstUniqueUsingSorting(int[] arr)
    {
        int result = -1;
        // write your code here
        int length=arr.length;
        int i=0;
        Arrays.sort(arr);
        while (i<length-1){
            if (arr[i]!=arr[i+1])return arr[i];
            i++;
        }
        return -1;
    }


    public static void rotateArrayByOne(int[] arr){

        // Write - Your - Code
        int length=arr.length;
        int temp=arr[length-1];
        for (int i=length-2;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=temp;
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void reArrange(int[] arr) {

        //Write - Your - Code
        int i=0,j=arr.length-1;
        while (i<j){
            while(arr[i]>=0){
                swap(arr,i,j);
                j--;
            }
            while(arr[j]<0){
                swap(arr,j,i);
                i++;
            }
            i++;
            j--;
        }
    }

    public static int[] maxMinUsingExtraSpace(int[] arr) {

        // Write - Your - Code
        int length=arr.length;
        int[] result=new int[length];
        int start=0,end=length-1,index=0;
        while (start<=end){
            if ((index&1)==0){
                result[index]=arr[end--];
            }
            else{
                result[index]=arr[start++];
            }
            index++;
        }
        return result;
    }

    public static void maxMinUsingWithoutExtraSpace(int[] arr) {

        // Write - Your - Code
        int length=arr.length,small=arr[0],big=arr[length-1],start=0,end=length-1,denominator=big+1,cnt=0;
        while (cnt<length) {
            if (cnt%2==0){
                arr[cnt]+=(arr[end]%denominator)*denominator;
                end--;
            }
            else{
                arr[cnt]+=(arr[start]%denominator)*denominator;

                start++;
            }
            cnt++;
        }
        for (int i=0;i<length;i++)arr[i]/=denominator;
    }

}
