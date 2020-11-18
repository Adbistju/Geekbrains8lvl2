package structure.list.doubly;

import structure.list.impl.SingleLinkedList;

public class DoublyLinkedList implements GBDoublyList {
    private Node first , tail = null;
    private int size = 0;
    static Node EMPYNODE = new Node();

//////////////////////////////////////////////////////////////////////////////
    @Override
    public void add(String item) {
        //Создали новую node
        Node newNode = new Node(item);
        //если список пуст, голова и хвост указывают на newNode
        if(first == null) {
            first = tail = newNode;
            //предыдущая голова будет нулевой
            first.previous = new Node();
            //следующий хвост будет нулевым
            tail.next = new Node();
        }
        else {
            tail.next = newNode;
            //newNode-> предыдущую установить хвост
            newNode.previous = tail;
            //newNode становится новым хвостом
            tail = newNode;
            //следующая точка хвоста к нулю
            System.out.println("хвост");
            tail.next = new Node();
        }
        size++;
    }
/////////////////////////////////////////////////////////////
    public String get(int index){
        int currentIndex=0;
        Node prev = first;
        Node current = first.next;
        while(index!=currentIndex){
            currentIndex++;
            prev = current;
            current = current.next;
        }
        if(index<currentIndex){return null;}
        System.out.println(prev.previous.getVal()+" "+prev.getVal()+" "+prev.next.getVal());
        return prev.val;
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            first.previous=new Node(null,null,first/*.next*/);
            size--;
            return true;
        }
        Node node = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                node.setNext(current.next);
                current.next.setPrevious(current.previous);
                size--;
                return true;
            }
            node = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public GBDoublyIterator iterator() {
        return new StraightForwardDoublyIterator(first);
    }

    @Override
    public String toString() {
//        return "SingleLinkedList{" +
//                "first=" + first +
//                '}';
        return "first( "+first;
    }

    private static class Node {
        private String val;
        private Node next;
        private Node previous;

        public Node(String val) {
            this(val, null, null);
        }

        public Node() {
            this("null", null, null);

        }

        public Node(String val, Node previous) {
            this(val, previous, null);
        }

        public Node(String val,Node previous, Node next) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }

        public String getVal(){
            if (this.val==null){
                return null;
            }
            return this.val;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "<- previous - val->'" + this.getVal() + '\'' + ", ) next-(" + next ;
        }

    }

    public static class StraightForwardDoublyIterator implements GBDoublyIterator {
        private Node current;

        public StraightForwardDoublyIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public boolean hasPrevious() {
            return current != null;
        }

        @Override
        public String previous() {
            String val = current.val;
            current = current.previous;
            return val;
        }

    }
}
