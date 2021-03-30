import java.util.Scanner;

public class NonPreemptive {

    public Scanner input = new Scanner(System.in);

    public void list(int choice, Scanner input) {
        System.out.print(
            "1. FCFS CPU SCHEDULING ALGORITHM  \n2. SJF CPU SCHEDULING ALGORITHM \n"+
            "3. ROUND ROBIN CPU SCHEDULING ALGORITHM\n4. PRIORITY CPU SCHEDULING ALGORITHM \n\nChoice: ");
        choice = input.nextInt();

        // do{

        // }

        // while();

        switch (choice) {
            case 1:
                FCFS(input);

                break;

            case 2:
                SJF(input);

                break;

            case 3:
                ROUND_ROBIN(input);

                break;
            
            case 4:
                PRIORITY(input);

                break;

            default:
                System.out.println("\nWrong Input Re-run the program and try again!!!");
                break;
        }

    }

    private void FCFS(Scanner input) {

        int bt[] = new int[20], tat[] = new int[20], wt[] = new int[20];
        int i, n;
        float wtavg, tatavg;

        System.out.print("\nEnter the number of processes -- ");
        n = input.nextInt();
        
        
        for(i=0;i<n;i++)
        {
            System.out.printf("\nEnter Burst Time for Process %d -- ", i+1); 
            bt[i]= input.nextInt();
        }

        wt[0] = (int) (wtavg = 0);
        tat[0] = (int) (tatavg = bt[0]);
        
        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] +bt[i-1];
            tat[i] = tat[i-1] +bt[i]; wtavg = wtavg + wt[i]; tatavg = tatavg + tat[i];
        }

        System.out.println("\n\nPROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
        for(i=0;i<n;i++)
        System.out.printf("\nP%d \t\t %d \t\t %d \t\t %d", i, bt[i], wt[i], tat[i]);
        System.out.printf("\n\nAverage Waiting Time -- %f", wtavg/n); 
        System.out.printf("\nAverage Turnaround Time -- %f", tatavg/n);
    }


    private void SJF(Scanner input) {
        int p[] = new int[20],bt[] = new int[20], tat[] = new int[20], wt[] = new int[20];
        int i, k, n, temp;
        float wtavg, tatavg;
        

        System.out.print("\nEnter the number of processes -- ");
        n = input.nextInt();

        for(i=0;i<n;i++) {
            p[i]=i;
            System.out.printf("Enter Burst Time for Process %d -- ", i); 
            bt[i]= input.nextInt();
        } 
        
        for(i=0;i<n;i++)
        for(k=i+1;k<n;k++) 
        if(bt[i]>bt[k])
        {
            temp=bt[i];
            bt[i]=bt[k]; bt[k]=temp;
            temp=p[i]; p[i]=p[k]; p[k]=temp;
        } 
        
        
        wt[0] = (int) (wtavg = 0);
        tat[0] = (int) (tatavg = bt[0]); 

        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] + bt[i-1]; 
            tat[i] = tat[i-1] +bt[i]; 
            wtavg = wtavg + wt[i]; 
            tatavg = tatavg + tat[i];
        }

        System.out.println("\n\nPROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n"); 
        for(i=0;i<n;i++){
        
            System.out.printf("\nP%d \t\t %d \t\t %d \t\t %d", p[i], bt[i], wt[i], tat[i]); 
            
        }

        System.out.printf("\n\nAverage Waiting Time -- %f", wtavg/n);
        System.out.printf("\nAverage Turnaround Time -- %f", tatavg/n);
    }


    private void ROUND_ROBIN(Scanner input) {
        int i,j,n,t,max, bu[] = new int[20];
        int wa[] = new int[20];
        int tat[] = new int[20];
        int ct[] = new int[20];
        float awt=0,att=0,temp=0;

        
        System.out.print("Enter the no of processes -- "); 
        n = input.nextInt();

        for(i=0;i<n;i++) {
            System.out.printf("\nEnter Burst Time for process %d -- ", i+1); 
            bu[i]= input.nextInt();
            ct[i]=bu[i];
        }

        System.out.print("\nEnter the size of time slice -- "); 
        t = input.nextInt();

        max=bu[0];

        for(i=1;i<n;i++)
            if(max<bu[i])
                max=bu[i];
                
        for(j=0;j<(max/t)+1;j++)
            for(i=0;i<n;i++)
                if(bu[i]!=0)
                    if(bu[i]<=t)
                    {
                        tat[i]= (int) (temp + bu[i]);
                        temp=temp+bu[i];
                        bu[i]=0;
                    }
                    else{
                        bu[i]=bu[i]-t;
                        temp=temp+t;
                    }

        for(i=0;i<n;i++){
            wa[i]=tat[i]-ct[i]; 
            att+=tat[i];
            awt+=wa[i];
        }  

        System.out.printf("\nThe Average Turnaround time is -- %f",att/n);
        System.out.printf("\nThe Average Waiting time is -- %f ",awt/n);

        System.out.printf("\n\nPROCESS\t\tBURST TIME\tWAITING TIME\tTURNAROUND TIME\n"); 
        for(i=0;i<n;i++)

            System.out.printf("\n%d\t\t%d\t\t%d\t\t%d\n",i+1,ct[i],wa[i],tat[i]);
            
        
    }

    
    private void PRIORITY(Scanner input) {

        int i,k,n,temp, p[] = new int[20];
        int bt[] = new int[20]; 
        int pri[] = new int[20];
        int wt[] = new int[20];
        int tat[] = new int[20];
        float wtavg, tatavg;

        System.out.print("Enter the number of processes --- ");
        n = input.nextInt();

        for(i=0;i<n;i++)
        {
            p[i] = i;
            System.out.printf("Enter the Burst Time & Priority of Process %d --- ",i); 
            bt[i]= input.nextInt();
            pri[i] = input.nextInt();
        } 
        
        for(i=0;i<n;i++)
            for(k=i+1;k<n;k++)
                if(pri[i] > pri[k])
                {
                    temp=p[i];
                    p[i]=p[k];
                    p[k]=temp;

                    temp=bt[i];
                    bt[i]=bt[k]; 
                    bt[k]=temp;

                    temp=pri[i]; 
                    pri[i]=pri[k]; 
                    pri[k]=temp;
                }

        wtavg = wt[0] = 0;
        tatavg = tat[0] = bt[0];

        for(i=1;i<n;i++){
            wt[i] = wt[i-1] + bt[i-1];
            tat[i] = tat[i-1] + bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }

        System.out.println("\n\nPROCESS\t\tPRIORITY\tBURSTTIME\tWAITINGTIME\tTURNAROUND TIME"); 
        
        for(i=0;i<n;i++){
            System.out.printf("\n%d \t\t %d \t\t %d \t\t %d \t\t %d ",p[i],pri[i],bt[i],wt[i],tat[i]);
        }
                
        System.out.printf("\n\nAverage Waiting Time is --- %f",wtavg/n);
        System.out.printf("\nAverage Turnaround Time is --- %f",tatavg/n);
            
                
           
    }       
}