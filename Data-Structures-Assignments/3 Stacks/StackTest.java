public class StackTest<S extends Object> {

    class Node<N> {
        public N entry;
        public Node<N> next = null;

    
        public Node(N entry){
            this.entry = entry;
        }
    }

    private int stackSize;
    private int elements;
    private Node<S> top;
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public StackTest(int size) {
        stackSize = size;
        elements = 0;
        top = null;
    }
 


    /**
     * Adds new entry to the top of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(S entry) {

        Node<S> newNode = new Node<S>(entry);       //Creates an object of class node with object S

        if(top == null){                            //checks conditions for true to continue or falls to skip 
            System.out.println("Adding: "+entry);
            top = newNode;                          //put new node on top as first since there wasn't a node already
            
        }

        else{
            System.out.println("Adding: "+entry);
            newNode.entry = entry;      //assigns the new entry to new node
            newNode.next = top;         //the next of the top node becomes the new top
            top = newNode;              //new entry is assigned to the new top created
            elements++;
        }
        
    }
 
    /**
     * Removes an entry from the top of the stack.
     * @return
     * @throws Exception 
     */
    public S pop() {

        if(isStackEmpty()){
        	System.out.println("Stack underflow or Empty.");
            return null;
        }
     
        S popped = top.entry;
        top = top.next;
        elements--;
        
        System.out.println("Removed entry: " + popped);
        
        
            
        return popped;
    }
 
    /**
     * Returns top of the stack without removing it.
     * @return
     */
    public S peek() {
        if(!isStackEmpty()){
            return top.entry;
            
        }else{
            System.out.println("Stack Empty");
            return null;
        }

    }
 
    
    /**
     * Returns true if the stack is empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == null);
    }
 
    /**
     * Returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        if (stackSize == getEelemets()){
            System.out.println("Stack is Full");
        }
        return true;
    }

    public int getEelemets(){
        return elements;
    }
 
    public void display()
    {
        // check for stack empty
        if (top == null) {
            System.out.print("\nStack Empty");
            return;
        }
        else {
            // create a node and assign top to it
            Node list = top;
            // traverse through the elements while displaying their entry
            while (list != null) {

                // print node entry
                System.out.println(list.entry);
                list = list.next;
            }
        }
    }
	
}
