public class DoublyLinkList {
    
    Node head;                 //Start of linked list
    Node tail;               //End of linked list

    class Node{                 //Class for Node
        Node next;              //Next element in the linked list
        Node previous;
        String data;

        public Node(String data){   //Constructor with arguments for class Node
            this.data = data;       //Parameter data assigned to string data
        }
    }


    /**
     * @param main class begins here
     * @return nothing to return
     */

    public static void main(String[] args){

        //creating an object of the class DoublyLinkList
        DoublyLinkList list = new DoublyLinkList();

        //using the instance created to call push method
        list.push("Opanyin Okyere Osei");
        list.add("Mr. Osei Kwaku");
        list.add("Osei Michael Kelly");

        System.out.println("\t\nKelly's Doubly Linked List");
        System.out.println("\nLinked List After setting the head and adding nodes" );
        list.display(list.head);

        System.out.println("\n\nLinked List displayed in traverse");
        list.displayTraverse(list.head);
    }


    //method to add a new node to the next of existing nodes in the list
    private void add(String newData) {
        
        //creating an object of the Node class for usage 
        Node newNode = new Node(newData);
        
        //head assigned to tail
        tail = head;

        newNode.next = null;

        if (head == null) {             //If the Linked List is empty, then make the new node as head 
            newNode.previous = null;
            head = newNode;
            return;
        }

        while(tail.next != null){       //traversing list
            tail = tail.next;
        }

        //assign new node to tails next node
        tail.next = newNode;

        newNode.previous = tail;
    }

    //Method Push: For placing or replacing an element at the head of the list  
    public void push(String data){          //Argument passed and used as new data

        //creating an object of the Node class for usage 
        Node newNode = new Node(data);

        //let the head of the node be assigned to first element in the linked list
        newNode.next = head;

        //make the node before the first node null to show that node.next is first
        newNode.previous = null; 

        if(head != null){               //if statement to check heat emptiness
            head.previous = newNode;    //assign new node to heads previous
        }

        head = newNode;         //new node is being assigned to head
    }

    //method for display list
    public void display(Node node){
        while(node != null){                //while condition check
            System.out.print(" ---->>  " + node.data);    //print the data at that node
            tail = node;
            node = node.next;               //assign previous node to node
            System.out.println();
        }
    }

    //method for display list in traverse
    public void displayTraverse(Node node){
        while(tail != null){                //while condition check
            System.out.print(" ---->>  " + tail.data);    //print the data at that node
            tail = tail.previous;           //assign previous node to node
            System.out.println();
        }
    }
    
}
