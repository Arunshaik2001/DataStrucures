package DataStructures;

import java.util.HashSet;

class Node{
    int data;
    Node next;
    Node(int x){
        this.data=x;
    }
}

public class LinkedListDataStructure {
    private Node head,tail;
    private int size=0;

    public Node insert(int value){

        Node temp=new Node(value);
        if (head==null){
            return head=tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
        this.size++;
        return head;
    }


    public Node insertAtEnd(int value,Node head){
        Node temp = new Node(value);
        temp.next=head;
        head=temp;
        size++;
        return head;

    }

    public boolean search(int value){
        Node pointer=head;
        while (pointer != null){
            if (pointer.data==value)return true;
            pointer=pointer.next;
        }
        return false;
    }

    public Node deletion(int value){
        Node p=head,q=null;
        if (p.data==value){
            head=head.next;
            this.size--;
            return head;
        }
        while (p!=null){
            if (p.data==value){
                q.next=p.next;
                System.gc();
                this.size--;
                return head;
            }
            q=p;
            p=p.next;
        }
        return head;
    }

    public Node reverseALinkedList(){
        Node p=head,q=null,temp;
        tail=head;
        while (p!=null){
            temp=p.next;
            p.next=q;
            q=p;
            p=temp;
        }
        return head=q;
    }

    public boolean detectLoop(){
        Node fast=head,slow=head;
        do{
            fast=fast.next;
            if (fast!=null)fast=fast.next;
            slow=slow.next;
        }while (fast!=null && fast!=slow);
        return fast != null;
    }

    public Node findMiddle(){
        Node fast,slow;
        fast=slow=head;
        while (fast!=null) {
            fast=fast.next;
            if (fast==null || fast.next==null)break;
            fast=fast.next;
            slow=slow.next;
        }

        return slow;
    }

    public void removeDuplicatesIfAny(){
        HashSet<Integer> duplicateDetectionSet = new HashSet<>();
        Node checker=head,p=null;
        while (checker!=null){
            if (duplicateDetectionSet.contains(checker.data)){
                p.next=checker.next;
                System.gc();
            }
            else {
                duplicateDetectionSet.add(checker.data);
                p = checker;

            }
            checker=checker.next;
        }
    }

    public Node intersectionOfTwoLinkedList(Node first , Node second){
        Node newHead=null;
        HashSet<Integer> set = new HashSet<>();
        while (first!=null){
            set.add(first.data);
            first=first.next;
        }
        while (second!=null){
            if (set.contains(second.data)){
                newHead=insertAtEnd(second.data,newHead);
            }
            second=second.next;
        }
        return newHead;
    }

    
}
