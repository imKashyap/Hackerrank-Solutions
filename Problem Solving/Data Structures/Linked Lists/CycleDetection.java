 // Complete the hasCycle function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        Set<SinglyLinkedListNode> nodes= new HashSet<>();
        SinglyLinkedListNode temp= head;
        while(temp!=null){
            boolean a= nodes.add(temp);
            if(!a)return true;
            temp= temp.next;
        }
        return false;
    }