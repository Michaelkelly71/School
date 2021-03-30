class SinglyLinkedList {
    //Represent a node of the  linked list
    class Node{
        
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }


        public Node(Node n)
        {
            next = n;
        }

        //function to set Link to next Node
        public void setLink(Node n)
        {
            next = n; 
        }
   
    }

    //Represent the head and tail of the  linked list    
    public Node head = null;
    public Node tail = null;
    public int size =0;




    //addNode() will add a new node to the list    
    public void addNode(int data) {
        //Create a new node    
        Node newNode = new Node(data);

        //Checks if the list is empty    
        if(head == null) {
            //If list is empty, both head and tail will point to new node    
            head = newNode;
            tail = newNode;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;
            //newNode will become new tail of the list    
            tail = newNode;
        }
    }



    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        display();
        return head == null;
       
    }




    public void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;

        deleteList(key);
    }


    
    public void deleteList(int data) 
    { 
        Node newNode = new Node(data);
        
        if (head == null) 
            return; 
        head = newNode.next;
    } 


    /*  Function to get size of list  */
    public int size() 
    { 
        //Node temp = head; 
        int count = 0; 
        while (head != null) 
        { 
            count++; 
            head = head.next; 
        } 
        return count; 
    }


    
    
     



    //display() will display all the nodes present in the list    
    public void display() {
        //Node current will point to head    
        Node current = head;

        if(head == null) {
            System.out.println("\n\nList is empty");
        }
        System.out.println("\nNodes of linked list: ");
        while(current != null) {
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }



    public void push(int newdata){
        Node newnode =new Node(newdata);
        newnode.next=head;
        head=newnode;
    }



    public void insertAfter(Node prevnode, int data){

        if(prevnode ==null){
            System.out.println("The given node cannot be null");
            return;
        }
           
        Node newnode=new Node(data);
        newnode.next=prevnode.next;
        prevnode.next=newnode;

    }



    /*  Function to insert an element at begining  */
    public void insertAtStart(int data)
    {
        Node new_node = new Node(data);    
        size++ ;    
        if(head == null) 
        {
            head = new_node;
            tail = head;
        }
        else 
        {
            new_node.setLink(head);
            head = new_node;
        }
    }




    public void insertAtEnd(int data){

                Node new_node = new Node(data);

                if (head == null) {
                    head = new Node(data);
                    return;
                }

                new_node.next = null;

                Node last = head;
                while (last.next != null)
                    last = last.next;

                last.next = new_node;
                return;
    }
}