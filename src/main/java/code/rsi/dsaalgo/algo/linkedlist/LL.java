package code.rsi.dsaalgo.algo.linkedlist;

public class LL {

    Node head;
    Node tail;

    int size = 0;

    public static void main(String[] args) {
        LL node = new LL();
        node.insertFirst(1);
        node.insertFirst(2);
        node.insertFirst(3);
        node.insertAtLastUsingTail(4);
        node.insertAtLast(5);
        node.insertFirst(6);
        node.insertAtIndex(10, 3);
//        node.deleteFirst();
//        node.deleteAtLastUsingTail();
//        node.deleteAtIndex(2);
        Node node1 = node.find(15);
        System.out.println(node1);
        node.display();
        node.printHeadAndTail();

    }

    private int deleteFirst() {
        int val = head.val;

        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public void deleteAtIndex(int index) {
        Node prev_node = getNode(index - 1);

        prev_node.next = prev_node.next.next;
        size--;

    }

    public Node getNode(int index) {
        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void deleteAtLastUsingTail() {
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    private void insertAtLastUsingTail(int val) {
        if (tail == head) {
            insertFirst(val);
            return;
        }
        Node new_node = new Node(val);
        tail.next = new_node;
        tail = new_node;
        size++;
    }

    private void insertAtLast(int val) {
        if (tail == head) {
            insertFirst(val);
            return;
        }
        Node new_node = new Node(val);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new_node;
        tail = new_node;
        size++;
    }

    public void insertAtIndex(int val, int index) {

        if (index >= size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size - 1) {
            insertAtLast(val);
            return;
        }

        Node new_node = new Node(val);
        Node prevNode = head;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
        }

        new_node.next = prevNode.next;
        prevNode.next = new_node;
        size++;
    }

    public void insertFirst(int val) {
        Node new_node = new Node(val);
        new_node.next = head;
        head = new_node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    private void printHeadAndTail() {
        System.out.println("\nSize is " + size);
        System.out.println("\nHead is " + head.val);
        System.out.println("\nTail is " + tail.val);
    }

    public Node find(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
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

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", next=" + next + '}';
        }
    }
}
