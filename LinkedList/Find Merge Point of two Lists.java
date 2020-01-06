

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
        HashMap<SinglyLinkedListNode,Integer> map=new HashMap<>();
        SinglyLinkedListNode temp=head1;
        while(temp!=null){
            map.put(temp,1);
            temp=temp.next;
        }
        temp=head2;
        while(temp!=null){
            if(map.containsKey(temp))
                return temp.data;
            temp=temp.next;
        }
        return 0;
    }

