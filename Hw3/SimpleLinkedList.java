package Hw3;
// BAI 2
public class SimpleLinkedList<T> {

    class Node {

        T data;
        Node next;

        public String toString() {
            return data.toString();
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;


        top = newNode;


        this.n += 1;
    }

    public void addBot(T data) {


        Node current = this.top;

        while (current.next != null) {
            current = current.next;
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        current.next = newNode;

        bot = newNode;

        this.n = this.n + 1;
    }

    public T get(int i) {

        Node current = top;

        for (int idx=0; idx<i; idx++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int i, T data){

        Node current = top;

        for (int idx=0; idx<i; idx++) {
            current = current.next;
        }

        current.data = data;
    }

    public boolean isContain(T data) {

        Node current = this.top;
        if (current.data != data) return true;

        while (current.next != null) {
            current = current.next;
            if (current.data != data) return true;
        }

        return false;
    }

    public int size() {

        return this.n;
    }

    public boolean isEmpty() {

        return (this.top == null);
    }

    public T removeTop() {

        if (this.isEmpty()) return null;


        if (this.size() == 1) {

            T data = this.top.data;

            this.top = null;

            this.n -= 1;

            return data;
        }


        Node oldTop = this.top;

        this.top = this.top.next;

        this.n -= 1;

        return oldTop.data;
    }

    public T removeBot() {

        if (top == null) return null;

        if (top.next == null) {

            T data = this.top.data;

            this.top = null;

            this.n -= 1;

            return data;
        }


        Node secondLast = top;
        while (secondLast.next.next != null) secondLast = secondLast.next;

        Node last = secondLast.next;
        secondLast.next = null;


        this.n -= 1;

        return last.data;
    }

    public void remove(T data) {

        Node temp = this.top, prev = null;


        while (temp != null && temp.data == data){
            top = temp.next;
            temp = top;

            this.n -= 1;
        }


        while (temp != null){

            while (temp != null && temp.data != data) {
                prev = temp;
                temp = temp.next;
            }

            if (temp == null)
                return;

            prev.next = temp.next;

            temp = prev.next;

            this.n -= 1;
        }
    }


    public String toString() {
        String message = " ";
        Node current = top;
        while (current != null) {
            message += current.toString() + ", ";
            current = current.next;
        }
        return message;
    }

    public static void main(String[] args) {

        SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();

        System.out.println("Size of original linked list: " + linkedList.size());

        linkedList.add("Anh");
        linkedList.add("Quy");
        linkedList.add("Dang");
        linkedList.add("Quy");
        linkedList.add("Quys");
        linkedList.add("Quy");
        System.out.println("\nSTATUS NOW");
        System.out.println("Linked list: " + linkedList.toString() );
        System.out.println("Size: " + linkedList.size());


        System.out.println("\nADD BOTTOM METHOD");
        linkedList.addBot("AAnh");
        System.out.println("Linked list: " + linkedList.toString() );
        System.out.println("Size: " + linkedList.size());


        System.out.println("\nREMOVE TOP");
        System.out.println("Element is removed: " + linkedList.removeTop().toString());
        System.out.println("Linked list: " + linkedList.toString() );
        System.out.println("Size: " + linkedList.size());


        System.out.println("\nREMOVE BOTTOM");
        System.out.println("Element is removed: " + linkedList.removeBot().toString());
        System.out.println("Linked list: " + linkedList.toString() );
        System.out.println("Size: " + linkedList.size());


        System.out.println("\nGET ELEMENY AT ANY POSITION");
        System.out.println("Get second element in linked list: " + linkedList.get(1).toString());


        System.out.println("\nSET VALUE ELEMENT IN LINKED LIST");
        linkedList.set(0, "Quy");
        System.out.println("Linked list: " + linkedList.toString() );
        System.out.println("Size: " + linkedList.size());

       
        System.out.println("\nREMOVE ALL");
        System.out.println("Remove all 'Quy' in linked list: ");
        linkedList.remove("Quy");
        System.out.println("Linked list: " + linkedList.toString() );
        System.out.println("Size: " + linkedList.size());
    }

}