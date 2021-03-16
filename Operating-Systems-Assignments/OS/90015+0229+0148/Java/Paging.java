import java.util.Scanner;

public class Paging {

    public Scanner input = new Scanner(System.in);

    public void Page(Scanner input) {
        int ms, ps, nop, np, rempages, i, j, x, y, pa, offset;
        int s[] = new int[10], fno[][] = new int[10][20];

        System.out.print("\nEnter the memory size --\t");
        ms = input.nextInt();

        System.out.print("\nEnter the page size --\t\t");
        ps = input.nextInt();

        nop = ms / ps;

        System.out.printf("\nThe no. of pages available in memory are -- %d ", nop);
        System.out.print("\nEnter number of processes -- ");
        np = input.nextInt();

        rempages = nop;

        for (i = 1; i <= np; i++) {
            System.out.printf("\nEnter no. of pages required for p[%d]-- ", i);
            s[i] = input.nextInt();

            if (s[i] > rempages) {
                System.out.printf("\nMemory is Full\n");
                break;
            }

            rempages = rempages - s[i];

            System.out.printf("\nEnter pagetable for p[%d] --- ", i);
            for (j = 0; j < s[i]; j++) {
                fno[i][j] = input.nextInt();
            }

        }

        System.out.println("\nEnter Logical Address to find Physical Address ");
        System.out.print("\nEnter process no. and pagenumber and offset separated with spaces -- ");

        x = input.nextInt();
        y = input.nextInt();
        offset = input.nextInt();

        if (x > np || y >= s[i] || offset >= ps) {
            System.out.println("\nInvalid Process or Page Number or offset");
        }

        else {
            pa = fno[x][y] * ps + offset;
            System.out.printf("\nThe Physical Address is -- %d", pa);
        }

    }

}
