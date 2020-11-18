package structure.list;

import structure.list.impl.SingleLinkedList;
import structure.list.doubly.*;

public class Main {

    static GBList list = new SingleLinkedList();

    static GBDoublyList doublyList = new DoublyLinkedList();

    public static void main(String[] args) {
        list.add("BMW");
        list.add("TOYOTA");
        list.add("GAZ");
        list.add("TOYOTA");

        System.out.println(list);

        System.out.println(list.get(2));

        /**
            *GBDoubleList
         */
        addDoubleList();
        printDoubleList();
        removeDoubleList();
        printDoubleList();
        System.out.println(doublyList);
    }
    public static void addDoubleList(){
        doublyList.add("ODIN");
        doublyList.add("DVA");
        doublyList.add("TRE");
        doublyList.add("CHETIRE");
        doublyList.add("PYATJ");
        doublyList.add("HECH");
        System.out.println(doublyList);
    }
    public static void removeDoubleList(){
        doublyList.remove("DVA");
        doublyList.remove("TRE");
        doublyList.remove("CHETIRE");
        doublyList.remove("PYATJ");

    }
    public static void printDoubleList(){
        for (int i = 0; i < doublyList.size(); i++) {
            System.out.println("___________________________");
            System.out.println(doublyList.get(i));
            System.out.println("___________________________");
        }
    }
}
