import java.util.*;

public class LinkedList1 {

    /* Link list node */

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        SinglyLinkedList sList = new SinglyLinkedList();
        
        char ch;

        System.out.println("\nSingly Linked List Operations\n");
            System.out.print("How many nodes would you like for testing: ");
            int num;
            num = input.nextInt();
            System.out.println("\nEnter "+num+" nodes to be added:");
            
            int node = 0;
            int count = 1;
            while (count <= num){
                System.out.print("Node  " + count + ": ");
                node = input.nextInt();
                
                sList.addNode(node);
                count++;
            }

            sList.display();
         /*  Perform list operations  */
        do
        {
            

            System.out.println("\n1. Insert at begining");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at position");
            System.out.println("5. Delete all nodes");
            System.out.println("6. Delete using recursion");
            System.out.println("7. Check empty");
            System.out.println("8. Get size");   
            System.out.print("\nChoice: ");         
            int choice = input.nextInt(); 

            
            
            
             switch (choice)
            {
                case 1 : 
                    System.out.print("\nInsert a node in front of the Linked list: ");
                    node = input.nextInt();
                    System.out.println("\nList after inserting "+node+ "in front");
                    sList.push(node);
                    sList.display();                   
                break;              

                case 2 : 
                    System.out.print("\nInsert a node at th end: ");
                    node = input.nextInt();
                    System.out.println("\nList after inserting "+node+ " at the end");
                    sList.insertAtEnd(node);
                    sList.display();   
                break;     

                case 3 : 
                    System.out.print("\nAfter which position would you like to insert(eg 1): ");
                    int postion;
                    postion = input.nextInt();

                    System.out.print("Enter node to be inserted: ");
                    node = input.nextInt();
                    System.out.println("\nList after inserting "+node+ " after position "+postion);
                    if(postion == 1){
                        sList.insertAfter(sList.head, node);
                    }else if(postion == 2){
                        sList.insertAfter(sList.head.next, node);
                    }else if(postion == 3){
                        sList.insertAfter(sList.head.next.next, node);
                    }else if(postion == 4){
                        sList.insertAfter(sList.head.next.next.next, node);
                    }else if(postion == 5){
                        sList.insertAfter(sList.head.next.next.next.next, node);
                    }

                    
                    sList.display();
                break;     
                                                        
                case 4 : 
                    System.out.print("\nDelete a node of your choice: ");
                    node = input.nextInt();
                    System.out.println("\nList after deleting node " +node);
                    sList.deleteNode(node);
                    sList.display();
                break;

                case 5 :
                    sList.deleteList(node);
                break;

                case 6 :
                    sList.deleteList(node);
                break;


                case 7 : 
                    System.out.println("Empty status = "+ sList.isEmpty());
                break;   

                case 8 : 
                    System.out.println("Size = "+ sList.size() +" \n");
                break;    

                default : 
                    System.out.println("Wrong Entry \n ");
                break;   
            }
            
            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = input.next().charAt(0);                        
        } 
        
        while (ch == 'Y'|| ch == 'y');     
        

    }
}


    