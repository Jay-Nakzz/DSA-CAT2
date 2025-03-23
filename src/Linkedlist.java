public class Linkedlist {

    // A private nested class that represents each node in the linked list.
    // Each node stores an integer value and a pointer to the next node.
    private static class Node {
        int data;
        Node next;

        // Creates a new node with the given integer value.
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 'head' points to the first node in the list (or null if the list is empty).
    private Node head;

    // Initializes an empty linked list.
    public Linkedlist() {
        head = null;
    }

    // Inserts a new node at the front of the list.
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Link the new node to the old head
        head = newNode;      // The new node becomes the new head
    }

    // Inserts a new node at the end of the list.
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, make the new node the head.
            head = newNode;
        } else {
            // Otherwise, walk through the list until the last node.
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            // Attach the new node at the end.
            current.next = newNode;
        }
    }

    // Removes the node at the beginning of the list.
    // If the list is empty, it prints a message instead.
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else {
            // Move 'head' to the next node, effectively removing the first node.
            head = head.next;
        }
    }

    // Prints the entire list, starting from 'head' and following each 'next' link.
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("Null"); // Mark the end of the list.
    }

    // A basic test to show that insertions and deletions work as expected.
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();

        // Insert data elements at the front.
        list.insertAtBeginning(40);
        list.insertAtBeginning(50);

        // Insert one element at the end.
        list.insertAtEnd(20);

        // Print the list to verify the insertions.
        System.out.println("Linked List after Insertions:");
        list.printList(); // 50 -> 40 -> 20 -> Null

        // Remove the first element and print the list again.
        list.deleteFromBeginning();
        System.out.println("Linked List after deletion of The First Element:");
        list.printList(); // 40 -> 20 -> Null
    }
}