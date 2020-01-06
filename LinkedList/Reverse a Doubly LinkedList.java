

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode prev=null;
        DoublyLinkedListNode current=head;
        DoublyLinkedListNode nextn=current.next;
        while(nextn!=null){
            current.next=prev;
            current.prev=nextn;
            prev=current;
            current=nextn;
            nextn=nextn.next;
        }
        current.next=prev;
        current.prev=null;
        head=current;
        return head;
    }

