public class classQueues<T extends Object> {

    class Node<N> {
        public N entry;
        public Node<N> next = null;
        public Node<N> previous = null;
    
        public Node(N entry){
            this.entry = entry;
        }

        public Node(Node<N> n)
        {
            next = n;
        }

        //Method to set Link to next Node
        public void setLink(Node<N> n)
        {
            next = n; 
        }
    }

    private int size;
    private int elements;
    private Node<T> head;
    private Node<T> last;

 

    /**
     * constructor to create Queue with size
     * @param size
     */
    public classQueues(int size) {
        this.size = size;
        elements = 0;
        head = null;
        last = null;
    }
 


    /**
     * Adds new entry to the head of the Queue
     * @param entry
     * @throws Exception 
     */
    public void first(T entry) {

        Node<T> newNode = new Node<T>(entry);       //Creates an object of class node with object T
        System.out.println("Adding: "+entry);
        newNode.next=head;
        head=newNode;                          //put new node on head as first since there wasn't a node already
    }



    /**
     * Adds new entry to the top of the stack
     * @param entry
     * @throws Exception 
     */
    public void enqueue(T entry) {

        Node<T> newNode = new Node<T>(entry);       //Creates an object of class node with object T
        //head = last;

        System.out.println("Adding: "+entry);
        if(head == null){                            //checks conditions for true to continue or falls to skip 
            head = newNode;
            last = newNode;                         //put new node on top as first since there wasn't a node already
            return;
        }

        newNode.next = null;

        last = head;
        while (last.next != null){
            last = last.next;
        }
        
        last.next = newNode;
        return;
    }
 


    /**
     * Returns true if the Queue is empty
     * @return
     */
    public boolean isQueueEmpty() {
        return (head == null);
    }


    /**
     * Removes an entry from the head of the Queue.
     * @return
     * @throws Exception 
     */
    public Node dequeue() {

        if(isQueueEmpty()){
        	System.out.println("\nQueue underflow or Empty.");
            return null;
        }
     
        T dequeued = head.entry;
        System.out.println("Removed entry: " + dequeued);
        head = head.next;
        
        elements--;
        
        return head;
    }
 
    /**
     * Returns head of the Queue without removing it.
     * @return
     */
    public T getHead() {
        if(!isQueueEmpty()){
            return head.entry;
            
        }else{
            System.out.println("\nQueue Empty");
            return null;
        }

    }
 
    
    
 
    /**
     * Returns true if the Queue is full
     * @return
     */
    public boolean isQueueFull() {
        if (size == getEelemets()){
            System.out.println("\nQueue is Full");
        }
        return true;
    }

    public int getEelemets(){
        return elements;
    }
 
    //Method to display queues members
    public void display() {
        //Node currentHead will point to head    
        Node currentHead = head;

        if(currentHead == null) {
            System.out.println("\nQueue is empty");
        }
        System.out.println("\nNodes of Queues linked list: ");
        while(currentHead != null) {
            //Prints each node by incrementing pointer    
            System.out.print(currentHead.entry + " <<--- ");
            currentHead = currentHead.next;
        }
    
    }
	
}
