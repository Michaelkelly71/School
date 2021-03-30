/**********************************************************
Author:  Michael Kelly Osei
Date:    25/03/21
Program: A program to Implement Doubly Linked List (Family)
**********************************************************/

public class DoublyLinkList {
    
    Node head;                  //Start of linked dlist
    Node tail;                  //End of linked dlist

    class Node{                 //Class for Node
        Node next;              //Next element in the linked dlist
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
        DoublyLinkList dlist = new DoublyLinkList();

        //using the instance created to call push method
        dlist.push("Opanyin Okyere Osei");
        dlist.add("Mr. Osei Kwaku");
        dlist.add("Osei Michael Kelly");

        System.out.println("\n\tKelly's Doubly Linked List");//Titles Sorts
        System.out.println("\n*******   Adding Nodes   *******");
        System.out.println("\nLinked List After setting the head and adding nodes" );//Message
        dlist.display(dlist.head);//Displaying the linked dlist

        dlist.deleteNode(dlist.head);
        System.out.println("\n\n\n*******   Deleting Nodes   *******\n");
        System.out.println("Linked List After deleting a node" );//Message
        dlist.display(dlist.head);
    }


    //method to add a new node to the next of existing nodes in the dlist
    private void add(String newData) {
        
        //creating an object of the Node class for usage 
        Node newNode = new Node(newData);
        
        //head assigned to tail
        tail = head;

        newNode.next = null;//Making the next node null

        if (head == null) {             //If the Linked List is empty, then make the new node as head 
            newNode.previous = null;
            head = newNode;
            return;
        }

        while(tail.next != null){       //traversing dlist
            tail = tail.next;
        }

        //assign new node to tails next node
        tail.next = newNode;

        newNode.previous = tail;
    }

    //Method Push: For placing or replacing an element at the head of the dlist  
    public void push(String data){          //Argument passed and used as new data

        //creating an object of the Node class for usage 
        Node newNode = new Node(data);

        //let the head of the node be assigned to first element in the linked dlist
        newNode.next = head;

        //make the node before the first node null to show that node.next is first
        newNode.previous = null; 

        if(head != null){               //if statement to check heat emptiness
            head.previous = newNode;    //assign new node to heads previous
        }

        head = newNode;         //new node is being assigned to head
    }

    //method for display dlist
    public void display(Node node){
        while(node != null){                                //while condition check
            System.out.print(" ---->>  " + node.data);      //print the data at that node
            tail = node;
            node = node.next;                               //assign previous node to node
        }

        System.out.println();
        System.out.print("\nLinked List displayed in traverse\n");//Message
        while(tail != null){                                //while condition check
            System.out.print(" ---->>  " + tail.data);      //print the data at that node
            tail = tail.previous;                           //assign previous node to node
        }
    }
    

    //method to delete an node in the doubly linked list
    public void deleteNode(Node delete){
        
        //if deleting the head node itself
        while(head == null && delete == null){//If head item to be deleted are empty
            return;
        }

        //deleting head node
        if(head == delete){
            head = delete.next;//make the next node of head the new head node
        }

        //deleting a node that isn't the TAIL node
        if(delete.next != null){
            //assign what you're deletings previous node to be the new previous node
            // of what you're deletings next node
            delete.next.previous = delete.previous; 
        }

        //deleting a node that isn't the HEAD node
        if(delete.previous != null){
            //assign what you're deletings next node to be the new next node
            // of what you're deletings previous node
            delete.previous.next = delete.next; 
        }

        return;
    }
}
