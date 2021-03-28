public class mainQueue {
    //Main
    public static void main(String[] args){
        classQueues<Integer> intQueue = new classQueues<Integer>(5);
        classQueues<String> strQueue = new classQueues<String>(5);

        System.out.println("\n\tKelly's Implementation of Queues");
        System.out.println("\n*******   Enqueueing Strings   *******\n");
        strQueue.first("Kelly");//Inserting the start of queue
        strQueue.enqueue("Emma");//adding 4 to the queue
        strQueue.enqueue("Kella");//adding 5 to the queue

        //displaying linked list
        strQueue.display();

        System.out.println("\n\n*******   Dequeueing Strings  *******");
        strQueue.dequeue();//Removing the first item from the queue

        //displaying linked list
        strQueue.display();


        System.out.println("\n\n\n\n*******   Enqueueing Integers   *******\n");
        intQueue.first(2);//Inserting the start of queue
        intQueue.enqueue(4);//adding 4 to the queue
        intQueue.enqueue(5);//adding 5 to the queue

        //displaying linked list
        intQueue.display();

        System.out.println("\n\nn*******   Dequeueing Integers  *******");
        intQueue.dequeue();//Removing the first item from the queue

        //displaying linked list
        intQueue.display();

    
        System.out.println("\n\nEND OF QUEUE");
    }


    
    
}
