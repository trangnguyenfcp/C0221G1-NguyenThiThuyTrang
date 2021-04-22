package bai_10_dsa_danhsach.bai_tap;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;
    public MyLinkedList(Object data){
        head = new Node(data);
        numNodes++;
    }
    private class Node {
        private Node next;
        private Object data;
        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        if (index >= numNodes || index <= 0){
            throw new IndexOutOfBoundsException("OverCapacity");
        }
        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(E e){
        Node temp = new Node(e);
        temp.next = head;
        head = temp;
        numNodes++;
    }
    public void addLast(E e){
        Node tail = head;
        for (int i = 0; i < numNodes -1; i++){
            tail = tail.next;
        }
        tail.next = new Node(e);
        tail = tail.next;
        numNodes++;
    }
    public void printList(){
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void remove(int index){
        Node temp = head;
        Node holder;
        if (index > numNodes-1|| index < 0){
            throw new IndexOutOfBoundsException("OverCapacity");
        }
        if (index == 0){
            head = temp.next;
        } else if (index > 0 && index < numNodes-1){
        for (int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        holder = temp.next.next;
        temp.next = holder;}
        else if (index == numNodes -1){
            for (int i = 0; i < index-1; i++){
                temp = temp.next;
            }
            temp.next = null;
        }
        numNodes--;
    }
    public Object get (int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public boolean contains (E o){
    Node temp = head;
    for (int i =0; i < numNodes-1; i++){
        temp = temp.next;
        if (temp.data == o){
            return true;
        }
    }
    return false;
    }
}
