// Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        Set<SinglyLinkedListNode> nodes= new HashSet<>();
        SinglyLinkedListNode temp= head1;
        for(;temp!=null;temp=temp.next)nodes.add(temp);
        temp= head2;
        for(;temp!=null;temp=temp.next){
            boolean b=nodes.add(temp);
            if(!b)break;
        }
        return temp.data;
    }