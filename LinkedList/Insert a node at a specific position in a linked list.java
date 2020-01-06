

    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode temp=head;
        SinglyLinkedListNode nn=new SinglyLinkedListNode(data);
        nn.next=null;
        for(int i=0;i<position-1;i++){
            temp=temp.next;
        }
        nn.next=temp.next;
        temp.next=nn;
        return head;
    }

