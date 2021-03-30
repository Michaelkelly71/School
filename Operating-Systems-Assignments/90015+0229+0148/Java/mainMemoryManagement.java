/*
ID              NAME
219cs01090015   OSEI MICHAEL KELLY
0000000000029   KOBBINA AMOAH
0000000000148   BADOLO DEBORA

A program to simulate memory management techniques
**/

import java.util.*;

//Running from the class MemoryManagement.
public class mainMemoryManagement {

    // the whole code is being run from the main method.
    public static void main(String[] args) {

        // Declaration of variables and initializing those that need to be initialized.
        int memoryProcessRequired = 0, blockSize = 0;
        int noOfBlocks = 0, externalFragmentation = 0, numberOfProcesses = 0, totalInternalFragmentation = 0;
        int i = 1, p = 0;
        int temp = 0, n = 0;
        char ch = 'y';
        char again;

        // declaration of array mp taking
        int[] mp;

        // An instance of mp is created to take 10 inputs
        mp = new int[10];

        // creates a new Scanner instance "input" pointing to the input stream passed as
        // argument
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n"+
        "\t**************************************************************************\n"+
        "\tA program to simulate memory management techniques Positive Intergers Only \n"+
        "\t**************************************************************************");
        // Prints to the screeen what is in the "" A mean driven style

        do {
            System.out.println(

                    "\n1. Multiprogramming with a Fixed number of task  \n"
                            + "2. Multiprogramming with a Variable number of task\n"
                            + "3. Contiguous memory allocation techniques\n"
                            + "4. Paging technique of memory management.\n"
                            + "5. Non-preemptive CPU scheduling algorithms\n"
                            + "6. Multi-level queue scheduling algorithm\n");

            System.out.print("\nChoice (Positive Intergers Only Please): ");

            // decalers choices and takes an input at the same time
            int choice = input.nextInt();

            // Switch statemet executed if the condition choice is true
            switch (choice) {
                case 1:
                    MFT(memoryProcessRequired, blockSize, noOfBlocks, externalFragmentation, totalInternalFragmentation,
                            numberOfProcesses, i, p, mp, input);

                    break;

                case 2:
                    MVT(memoryProcessRequired, temp, ch, i, n, mp, input);

                    break;

                case 3:
                    Contigious memory = new Contigious();
                    memory.list(choice, input);

                    break;

                case 4:
                    Paging technique = new Paging();
                    technique.Page(input);
                    break;

                case 5:
                    NonPreemptive cpu = new NonPreemptive();
                    cpu.list(choice, input);
                    break;

                case 6:
                    MultiLevel multi = new MultiLevel(); 
                    multi.level();
                    break;

                // Default
                default:
                    System.out.println("\nWrong Input Re-run the program and try again!!!");

            }

            System.out.print("\n\nAnother Test???: ");
            String c = input.next();
            again = c.charAt(0);

        }

        while (again == 'y');

    }

    // A method to take care of the MFT technique with arguements passed to it
    public static void MFT(int memoryProcessRequired, int blockSize, int noOfBlocks, int externalFragmentation,
            int totalInternalFragmentation, int numberOfProcesses, int i, int p, int[] mp, Scanner input) {

        // Scanner input = new Scanner(System.in);
        System.out.print("\nMFT\nEnter the total memory available (in Bytes) -- ");
        memoryProcessRequired = input.nextInt();

        System.out.print("Enter the block size (in Bytes) -- ");
        blockSize = input.nextInt();

        // Computations
        noOfBlocks = memoryProcessRequired / blockSize;
        externalFragmentation = memoryProcessRequired - noOfBlocks * blockSize;

        System.out.print("\nEnter the number of processes -- ");
        numberOfProcesses = input.nextInt();

        // We know the number of itrations so the for loop with itrate for that number
        // of times
        for (i = 0; i < numberOfProcesses; i++) {
            System.out.print("Enter memory required for process " + (i + 1) + " (in Bytes): ");
            mp[i] = input.nextInt();
        }

        // Output to the Screen
        System.out.print("\nNo. of Blocks available in memory -- " + noOfBlocks);
        System.out.println("\n\nPROCESS\t\tMEMORY REQUIRED\t\t ALLOCATED\tINTERNAL FRAGMENTATION");
        System.out.println("------------------------------------------------------------------------------");

        // For loop with an embeded if statement to output the results to the screen
        for (i = 0; i <= numberOfProcesses && p < noOfBlocks; i++) {
            System.out.print("\n " + (i + 1) + "\t\t" + (mp[i]));
            if (mp[i] > blockSize) {
                System.out.print("\t\t\t NO\t\t\t---");
            }

            else {
                System.out.print("\t\t\t YES\t\t\t" + (blockSize - mp[i]));
                totalInternalFragmentation = totalInternalFragmentation + blockSize - mp[i];
                p++;
            }
        }

        // If statement chcking the condition of a full memory
        if (i <= numberOfProcesses) {
            System.out.println("\n\nMemory is Full, Remaining Processes cannot be accomodated");
        }

        // Output to screen
        System.out.println("\n\nTotal Internal Fragmentation is " + totalInternalFragmentation);
        System.out.println("\nTotal External Fragmentation is " + externalFragmentation);

    }

    // A method to take care of the MVT technique with arguements passed to it
    public static void MVT(int memoryProcessRequired, int temp, char ch, int i, int n, int[] mp, Scanner input) {
        // Outputting to Screen
        System.out.print("\nMVT\nEnter the total memory available (in Bytes)-- ");

        // Computations
        memoryProcessRequired = input.nextInt();
        temp = memoryProcessRequired;

        // For loop with an embeded if statement to outputting to screen and taken
        // inputs from user
        for (i = 0; ch == 'y'; i++, n++) {
            System.out.print("\n\nEnter memory required for process  " + (i + 1) + " (in Bytes) -- ");
            mp[i] = input.nextInt();

            if (mp[i] <= temp) {
                System.out.println("\nMemory is allocated for Process " + (i + 1));
                temp = temp - mp[i];
                System.out.print("\nDo you want to continue(y/n) -- ");
                input.nextLine();
                String c = input.nextLine();
                ch = c.charAt(0);
                System.out.println();

            }

            else {
                break;
            }

        }

        // Screen output
        System.out.println("\n\nMemory is Full");
        System.out.println("\n\nTotal Memory Available --" + memoryProcessRequired);
        System.out.println("\n\nPROCESS\t\t MEMORY ALLOCATED ");
        System.out.println("---------------------------------");

        // For loop to output number as a list with the array list as well
        for (i = 0; i < n; i++) {
            System.out.print("\n " + (i + 1) + "\t\t " + (mp[i]));
        }

        // Screen output
        System.out.println("\n\nTotal Memory Allocated is " + (memoryProcessRequired - temp));
        System.out.println("Total External Fragmentation is " + temp);

    }

}