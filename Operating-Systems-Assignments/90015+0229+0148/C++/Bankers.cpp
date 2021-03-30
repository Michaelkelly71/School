//iostream is included to help with input and output in this file
#include <iostream>

//iomanip library helps with output manipulation and styling
#include <iomanip>

using namespace std;
class Bankers
{

    struct file
    {
        int all[10];
        int maxx[10];
        int need[10];
        int flag;
    };

public:
    void main()
    {
        int Max[10][10], need[10][10], alloc[10][10], avail[10], completed[10], safeSequence[10];
        int p, r, i, j, process, count;
        count = 0;

        cout << "Enter the no of processes: ";
    cin >> p;

    for(i = 0; i< p; i++)
        completed[i] = 0;

    cout << "\nEnter the no of resources: ";
    cin >> r;

    cout << "\nEnter the Max Matrix for each process: ";
    for(i = 0; i < p; i++)
    {
        cout << "\nFor process " << i + 1 << ": ";
        for(j = 0; j < r; j++)
            cin >> Max[i][j];
    }

    cout << "\n\nEnter the allocation for each process: ";
    for(i = 0; i < p; i++)
    {
        cout << "\nFor process " << i + 1 << ": ";
        for(j = 0; j < r; j++)
            cin >> alloc[i][j];
    }

    cout << "\n\nEnter the Available Resources: ";
    for(i = 0; i < r; i++)
        cin >> avail[i];

    for(i = 0; i < p; i++)

        for(j = 0; j < r; j++)
            need[i][j] = Max[i][j] - alloc[i][j];

        do
        {
            cout << "\n Max matrix:\tAllocation matrix:\n";

            for(i = 0; i < p; i++)
            {
                for( j = 0; j < r; j++)
                    cout << " "<<  Max[i][j];
                cout << "\t\t";
                for( j = 0; j < r; j++)
                    cout <<setw(2)<< alloc[i][j];
                cout << "\n";
            }

            process = -1;

            for(i = 0; i < p; i++)
            {
                if(completed[i] == 0)//if not completed
                {
                    process = i ;
                    for(j = 0; j < r; j++)
                    {
                        if(avail[j] < need[i][j])
                        {
                            process = -1;
                            break;
                        }
                    }
                }
                if(process != -1)
                    break;
            }

            if(process != -1)
            {
                cout << "\nProcess "<< process + 1<< " runs to completion!";
                safeSequence[count] = process + 1;
                count++;
                for(j = 0; j < r; j++)
                {
                    avail[j] += alloc[process][j];
                    alloc[process][j] = 0;
                    Max[process][j] = 0;
                    completed[process] = 1;
                }
            }
        }
        while(count != p && process != -1);

        if(count == p)
        {
            //cout system is safe to the user
            cout << "\nThe system is in a safe state!!\n";
            cout << "Safe Sequence: < ";
            for( i = 0; i < p; i++)
                cout <<setw(2)<< safeSequence[i];
            cout << ">\n";
        }
        else
            cout << "\nThe system is in an unsafe state!!";

            
    }
};
