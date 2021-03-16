public class DoublyLinkedList {

    Node head; // head of list

    // Doubly Linked list Node
    class Node {

        String data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(String d) {
            data = d;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Start with the empty list 
         DoublyLinkedList dll = new DoublyLinkedList();
 
        // Insert at the beginning. 
        dll.push("Gaddiel Acquaah-Ashun");
 
        // Add at the end
        dll.append("Victor Awortwe Ashun");
        dll.append("Victor Kwame Essuon Ashun");
 
        System.out.println("Created linked list is: ");
        dll.printlist(dll.head);
    }

    // Adding a node at the front of the list
    public void push(String new_data) {
        // 1. allocate node 
        //  2. put in the data 
        Node new_Node = new Node(new_data);

        // 3. Make next of new node as head and previous as NULL 
        new_Node.next = head;
        new_Node.prev = null;

        // 4. change prev of head node to new node 
        if (head != null) {
            head.prev = new_Node;
        }

        // 5. move the head to point to the new node 
        head = new_Node;
    }

    // Add a node at the end of the list
    void append(String new_data) {
        // 1. allocate node 
        // 2. put in the data 
        Node new_node = new Node(new_data);

        Node last = head;
        // used in step 5

        // 3. This new node is going to be the last node, so
        // make next of it as NULL
        new_node.next = null;

        // 4. If the Linked List is empty, then make the new
        // node as head 
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        // 5. Else traverse till the last node 
        while (last.next != null) {
            last = last.next;
        }

        // 6. Change the next of last node 
        last.next = new_node;

        // 7. Make last node as previous of new node 
        new_node.prev = last;
    }

    
    // linked list starting from the given node
    public void printlist(Node node) {
        
        
        while (node != null) {
            System.out.print(node.data + " ==> ");
            
            node = node.next;
        }
        
    }
}