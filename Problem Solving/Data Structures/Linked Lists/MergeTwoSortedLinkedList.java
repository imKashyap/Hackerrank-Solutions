import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;
        SinglyLinkedListNode temp1=head1;
        SinglyLinkedListNode temp2=head2;
        SinglyLinkedListNode ans=null, heady=null;
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                SinglyLinkedListNode temp=new SinglyLinkedListNode(temp1.data);
                if(ans==null){ans=temp;heady=ans;}
                else ans.next=temp;
                if(ans.next!=null)ans=ans.next;
                temp1=temp1.next;
            }
            else if(temp2.data<temp1.data){
                SinglyLinkedListNode temp=new SinglyLinkedListNode(temp2.data);
                if(ans==null){ans=temp;heady=ans;}
                else ans.next=temp;
                if(ans.next!=null)ans=ans.next;
                temp2=temp2.next;
            }
            else{
                if(ans==null){
                    SinglyLinkedListNode temp=new SinglyLinkedListNode(temp1.data);
                    ans=temp;
                    heady=ans;
                    temp=new SinglyLinkedListNode(temp2.data);
                    ans.next=temp;
                }
                else{
                    SinglyLinkedListNode temp=new SinglyLinkedListNode(temp1.data);
                    ans.next=temp;
                    ans=ans.next; 
                    temp=new SinglyLinkedListNode(temp2.data);                   
                    ans.next=temp;
                }
                if(ans.next!=null)ans=ans.next;
                temp1=temp1.next;
                temp2=temp2.next; 
            }
            
        }
        if(temp1!=null)
            ans.next=temp1;
        if(temp2!=null)
            ans.next=temp2;
        return heady;
        
    }

    private static final Scanner scanner = new Scanner(System.in);