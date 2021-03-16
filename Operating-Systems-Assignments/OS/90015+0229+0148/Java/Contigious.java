import java.util.Scanner;

public class Contigious {

    public Scanner input = new Scanner(System.in);

    public void list(int choice, Scanner input) {
        System.out.print("1. Worst-fit  \n2. Best-fit \n3. First-fit\n\nChoice: ");
        choice = input.nextInt();

        // do{

        // }

        // while();

        switch (choice) {
            case 1:
                worstFit(input);

                break;

            case 2:
                bestFit(input);

                break;

            case 3:
                firstFit(input);

                break;

            default:
                System.out.println("\nWrong Input Re-run the program and try again!!!");
                break;
        }

    }

    public void worstFit(Scanner input) {

        // declaring max as costant
        final int max = 25;

        int frag[] = new int[max], b[] = new int[max], f[] = new int[max];
        int i, j, nb, nf, temp = 0;
        int bf[] = new int[max], ff[] = new int[max];

        System.out.println("\n\tMemory Management Scheme - Worst Fit");

        System.out.print("\nEnter the number of blocks:");
        nb = input.nextInt();

        System.out.print("Enter the number of files:");
        nf = input.nextInt();

        System.out.print("\nEnter the size of the blocks:-\n");

        for (i = 1; i <= nb; i++) {
            System.out.printf("Block: ", i);
            b[i] = input.nextInt();
        }

        System.out.println("\nEnter the size of the files :-\n");

        for (i = 1; i <= nf; i++) {
            System.out.printf("File: ", i);
            f[i] = input.nextInt();
        }

        for (i = 1; i <= nf; i++) {
            for (j = 1; j <= nb; j++) {
                if (bf[j] != 1) {
                    temp = b[j] - f[i];
                    if (temp >= 0) {
                        ff[i] = j;
                        break;
                    }
                }
            }

            frag[i] = temp;
            bf[ff[i]] = 1;
        }

        System.out.println("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");

        for (i = 1; i <= nf; i++) {
            System.out.printf("\n%d\t\t%d\t\t%d\t\t%d\t\t%d",i,f[i],ff[i],b[ff[i]],frag[i]);
        }
    }

    public void bestFit(Scanner input) {
        // creates a new Scanner instance "input" pointing to the input stream passed
        // asargument
        // Scanner input = new Scanner(System.in);

        final int max = 25;

        int frag[] = new int[max], b[] = new int[max], f[] = new int[max];
        int i, j, nb, nf, temp = 0, lowest = 10000;
        int bf[] = new int[max], ff[] = new int[max];

        System.out.println("\n\tMemory Management Scheme - Best Fit");

        System.out.print("\nEnter the number of blocks:");
        nb = input.nextInt();

        System.out.print("Enter the number of files:");
        nf = input.nextInt();

        System.out.print("\nEnter the size of the blocks:-\n");

        for (i = 1; i <= nb; i++) {
            System.out.printf("Block: ", i);
            b[i] = input.nextInt();
        }

        System.out.println("\nEnter the size of the files :-\n");

        for (i = 1; i <= nf; i++) {
            System.out.printf("File: ", i);
            f[i] = input.nextInt();
        }

        for (i = 1; i <= nf; i++) {
            for (j = 1; j <= nb; j++) {
                if (bf[j] != 1) {
                    temp = b[j] - f[i];
                    if (lowest >= temp) {
                        ff[i] = j;
                        lowest = temp;
                    }
                }
            }

            frag[i] = lowest;
            bf[ff[i]] = 1;
            lowest = 10000;
        }

        System.out.println("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");

        for (i = 1; i <= nf && ff[i] != 0; i++) {
            System.out.printf("\n%d\t\t%d\t\t%d\t\t%d\t\t%d",i,f[i],ff[i],b[ff[i]],frag[i]);
        }

    }

    public void firstFit(Scanner input) {

        final int max = 25;

        int frag[] = new int[max], b[] = new int[max], f[] = new int[max];
        int i, j, nb, nf, temp = 0, highest = 0;
        int bf[] = new int[max], ff[] = new int[max];

        System.out.println("\n\tMemory Management Scheme - First Fit");

        System.out.print("\nEnter the number of blocks:");
        nb = input.nextInt();

        System.out.print("Enter the number of files:");
        nf = input.nextInt();

        System.out.print("\nEnter the size of the blocks:-\n");

        for (i = 1; i <= nb; i++) {
            System.out.printf("Block: ", i);
            b[i] = input.nextInt();
        }

        System.out.println("\nEnter the size of the files :-\n");

        for (i = 1; i <= nf; i++) {
            System.out.printf("File: ", i);
            f[i] = input.nextInt();
        }

        for (i = 1; i <= nf; i++) {
            for (j = 1; j <= nb; j++) {
                if (bf[j] != 1) {
                    temp = b[j] - f[i];
                    if (highest < temp) {
                        ff[i] = j;
                        highest = temp;
                    }
                }
            }

            frag[i] = highest;
            bf[ff[i]] = 1;
            highest = 0;
        }

        System.out.println("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");

        for (i = 1; i <= nf; i++) {
            System.out.printf("\n%d\t\t%d\t\t%d\t\t%d\t\t%d",i,f[i],ff[i],b[ff[i]],frag[i]);
        }

    }
}
