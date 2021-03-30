import java.util.Scanner;

public class MultiLevel{

    public Scanner input = new Scanner(System.in);
    
    public void level(){

        int p[] = new int[20], bt[] = new int[20], su[] = new int[20],tat[] = new int[20],wt[] = new int[20];
        int i, k, n, temp;
        float wtavg, tatavg;

        System.out.print("\nEnter the number of processes -- ");
        n = input.nextInt();

        for(i=0;i<n;i++) {
            p[i] = i;
            System.out.printf("Enter the Burst Time of Process %d --- ", i); 
            bt[i] = input.nextInt();

            System.out.printf("System/User Process (0/1) ? --- "); 
            su[i] = input.nextInt();
        }

        for(i=0;i<n;i++)
            for(k=i+1;k<n;k++) 
                if(su[i] > su[k])
                {
                    temp=p[i];
                    p[i]=p[k]; 
                    p[k]=temp;

                    temp=bt[i]; 
                    bt[i]=bt[k]; 
                    bt[k]=temp;

                    temp=su[i]; 
                    su[i]=su[k]; 
                    su[k]=temp;
                }    

        wtavg = wt[0] = 0;
        tatavg = tat[0] = bt[0];

        for(i=1;i<n;i++) {
            wt[i] = wt[i-1] + bt[i-1]; 
            tat[i] = tat[i-1] + bt[i];
            wtavg = wtavg + wt[i]; 
            tatavg = tatavg + tat[i];
        }

        System.out.println("\nPROCESS\t\t SYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");

        for(i=0;i<n;i++){
            System.out.printf("\n%d \t\t %d \t\t\t %d \t\t%d \t\t %d ",p[i],su[i],bt[i],wt[i],tat[i]);
        }

        System.out.printf("\nAverage Waiting Time is --- %f",wtavg/n); 
        System.out.printf("\nAverage Turnaround Time is --- %f",tatavg/n);
    }
}
