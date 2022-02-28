package code.rsi.dsaalgo.algo.linkedlist;

public class DLL {

    Node head;
    Node tail;

    int size;

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertAtLast(5);
        list.insertAtIndex(6, 2);
        System.out.println("Deleted first : " + list.deleteFirst());
        System.out.println("Deleted last : " + list.deleteLast());
        System.out.println("Deleted index : " + list.deleteAtIndex(2));
        list.display();
        list.printHeadAndTail();
        list.reverseWithTail();
        list.reverse();
    }

    private void printHeadAndTail() {
        if (head != null) {
            System.out.println("\nSize is " + size);
            System.out.println("\nHead is " + head.val);
            System.out.println("\nTail is " + tail.val);
        } else {
            System.out.println("List is empty");
        }

    }

    private void insertFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (head.next == null) {
            tail = head;
        }

        size++;

    }

    public void reverseWithTail() {
        System.out.println("Display Reverse");
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.prev;
        }
        System.out.print("null\n");
    }

    public void insertAtIndex(int val, int index) {
        Node node = new Node(val);
        Node prevNode = getNode(index - 1);

        node.next = prevNode.next;
        prevNode.next.prev = node;
        prevNode.next = node;
        node.prev = prevNode;
        size++;
    }

    public Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void reverse() {

        Node node = head;
        Node last = null;

        while (node != null) {
            last = node;
            node = node.next;

        }


        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.print("null");
    }

    private int deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        int val = head.val;
        head.next.prev = null;
        head = head.next;
        size--;
        return val;
    }

    private int deleteLast() {
        Node last = getNode(size - 1);
        if (last == null) {
            System.out.println("Last cannot be deleted as list is empty");
            return -1;
        }
        int val = last.val;
        last.prev.next = null;
        tail = last.prev;
        size--;
        return val;
    }

    private int deleteAtIndex(int index) {
        Node last = getNode(index);
        int val = last.val;
        last.prev.next = last.next;
        last.next.prev = last.prev;
        size--;
        return val;
    }


    private void insertAtLast(int val) {
        Node node = new Node(val);

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.next = null;
        node.prev = last;
        tail = node;
        size++;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");

    }

    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", next=" + next + ", prev=" + prev + '}';
        }
    }
}
