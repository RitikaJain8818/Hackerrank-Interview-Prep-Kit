/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    HashMap<Node,Integer> map=new HashMap<>();
    Node temp=head;
    while(temp!=null){
        if(!map.containsKey(temp))
            map.put(temp,1);
        else
            return true;
        temp=temp.next;
    }
    return false;
}