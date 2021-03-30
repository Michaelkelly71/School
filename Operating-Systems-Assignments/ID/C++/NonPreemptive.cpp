#include <iostream>
#include <iomanip>
using namespace std;

class NonPreemptive{
    public:
    void list(int choice, char again){
        

    do{

        cout << "\n1. FIRST COME FIRST SERVE CPU SCHEDULING ALGORITHM  \n2. SHORTEST JOB FIRST CPU SCHEDULING ALGORITHM" <<
        "\n3. ROUND ROBIN CPU SCHEDULING ALGORITHM\n4. PRIORITY CPU SCHEDULING ALGORITHM\n\nChoice: ";
        cin >> choice;
        cin.clear();

        switch (choice) {
            case 1:
                FCFS();

                break;

            case 2:
                SJF();

                break;

            case 3:
                ROUND_ROBIN();

                break;

            case 4:
                PRIORITY();

                break;

            default:
                cout << ("\nWrong Input Re-run the program and try again!!!");
                break;
        }
     }

     while(again == 'y');
    }

    void FCFS(){
        int bt[20], wt[20], tat[20], i, n;
        float wtavg, tatavg;

        cout << "\nEnter the number of processes -- ";
        cin >> n; 
        
        for(i=0;i<n;i++)
        {
        cout << "\nEnter Burst Time for Process " << i << " -- "; 
        cin >> bt[i];
        }

        wt[0] = wtavg = 0; 
        tat[0] = tatavg = bt[0]; 
        
        for(i=1;i<n;i++)
        {
        wt[i] = wt[i-1] +bt[i-1]; 
        tat[i] = tat[i-1] +bt[i]; 
        wtavg = wtavg + wt[i]; 
        tatavg = tatavg + tat[i];
        }

        cout << "\nPROCESS \tBURST TIME \tWAITING TIME\tTURNAROUND TIME\n" << endl;

        for(i=0;i<n;i++)
        cout << "P"<< i<< "\t\t"<<bt[i]<< "\t\t" <<wt[i]<< "\t\t"<< tat[i];
        
        cout << "\n\nAverage Waiting Time -- "<< fixed<<setprecision(6)<< wtavg/n; 
        cout << "\nAverage Turnaround Time -- "<< tatavg/n;
    }

    void SJF(){
        int p[20], bt[20], wt[20], tat[20], i, k, n, temp; float wtavg, tatavg;

        cout << "\nEnter the number of processes -- "; 
        cin >> n;

        for(i=0;i<n;i++) {
        p[i]=i;

        cout << "Enter Burst Time for Process "<< i << " -- "; 
        cin >> bt[i];
        } 
        
        for(i=0;i<n;i++)
        for(k=i+1;k<n;k++) 
        
        if(bt[i]>bt[k])
        {
        temp=bt[i];
        bt[i]=bt[k]; bt[k]=temp;
        temp=p[i]; p[i]=p[k]; p[k]=temp;
        } 
        
        wt[0] = wtavg = 0;
        tat[0] = tatavg = bt[0]; 
        
        for(i=1;i<n;i++)
        {

        wt[i] = wt[i-1] +bt[i-1]; 
        tat[i] = tat[i-1] +bt[i]; 
        wtavg = wtavg + wt[i]; 
        tatavg = tatavg + tat[i];
        }

        cout << "\nPROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n" << endl; 
        for(i=0;i<n;i++)

        cout << "\n"<< p[i]<< "\t\t"<<bt[i]<< "\t\t" <<wt[i]<< "\t\t"<< tat[i];
        
        cout << "\n\nAverage Waiting Time -- " << fixed<<setprecision(6)<< wtavg/n;
        cout << "\nAverage Turnaround Time -- " << tatavg/n;

    }


    void ROUND_ROBIN(){
        int i,j,n,bu[10],wa[10],tat[10],t,ct[10],maxs; float awt=0,att=0,temp=0;

        cout << "Enter the no of processes -- "; 
        cin >> n;

        for(i=0;i<n;i++) 
        {
            cout << "\nEnter Burst Time for process "<< i+1 << " -- "; 
            cin >> bu[i];
            ct[i]=bu[i];
        }

        cout << "\nEnter the size of time slice -- "; 
        cin >> t;

        maxs=bu[0];

        for(i=1;i<n;i++)
            if(maxs<bu[i]) 
                maxs=bu[i];

        for(j=0;j<(maxs/t)+1;j++) 
            for(i=0;i<n;i++)
                if(bu[i]!=0) {
                    if(bu[i]<=t){
                    
                        tat[i]=temp+bu[i];
                        temp=temp+bu[i];
                        bu[i]=0; 
                    }
                    else{
                    
                        bu[i]=bu[i]-t;
                        temp=temp+t; 
                    }
                }
                    

        for(i=0;i<n;i++) {
            wa[i]=tat[i]-ct[i]; 
            att+=tat[i];
            awt+=wa[i]; 
        }

        cout << "\nThe Average Turnaround time is -- "<<fixed<<setprecision(6) << att/n;
        cout << "\nThe Average Waiting time is --  " << awt/n;
        cout << "\n\nPROCESS\t\tBURST TIME\tWAITING TIME\tTURNAROUND TIME\n" << endl; 
        
        for(i=0;i<n;i++)
        cout << "\n"<< i+1<< "\t\t"<<ct[i]<< "\t\t" <<wa[i]<< "\t\t"<< tat[i];
                    
    }



    void PRIORITY(){
        int p[20],bt[20],pri[20], wt[20],tat[20],i, k, n, temp; float wtavg, tatavg;

        cout << "Enter the number of processes --- "; 
        cin >> n;

        for(i=0;i<n;i++) {
            p[i] = i;
            cout << "Enter the Burst Time & Priority of Process "<< i << " -- ";
            cin >> bt[i];
            cin >> pri[i];
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
     
        for(i=1;i<n;i++) {
            wt[i] = wt[i-1] + bt[i-1]; 
            tat[i] = tat[i-1] + bt[i];
            wtavg = wtavg + wt[i]; 
            tatavg = tatavg + tat[i];
        }
        

        cout << "\nPROCESS\t\tPRIORITY\tBURSTTIME\tWAITINGTIME\tTURNAROUND TIME"<< endl; 
        
        for(i=0;i<n;i++)
        cout << "\n"<< p[i]<<"\t\t"<< pri[i] << "\t\t"<< bt[i]<< "\t\t" << wt[i] << "\t\t" << tat[i];
        cout << "\n\nAverage Waiting Time is --- " <<fixed<<setprecision(6)<< wtavg/n; 
        cout << "\nAverage Turnaround Time is --- " << tatavg/n;
    }

};