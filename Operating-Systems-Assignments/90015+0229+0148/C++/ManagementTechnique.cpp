//Adding the library iostream which allows the user to input data and see outputs on the screen 
#include <iostream>

//declaration for outputting to the screen
using namespace std;

//Class ManagementTechnique, All code in this class run from here
class ManagementTechnique{


public: 

    void contiguous(int choice, char again){
        
        

        do{
            cout << "\n1. Multiprogramming with a Fixed number of task  "
            "\n2. Multiprogramming with a Variable number of task\n\nChoice: ";
            cin >> choice;
            cin.clear();

            switch (choice) {
                case 1:
                    mft();

                    break;

                case 2:
                    mvt();

                    break;

                default:
                    cout << "Wrong Input, Not part of list!!!" << endl;
                    break;
            }

            cout << "\n\nAnother Test???: ";
            cin >> again;
            //cout << "\n\nWrong Input Re-run the program and try again!!!" << endl;
        }

        while(again == 'y');

        

    }






    void mft() {

        //Declaration and initialization of variables
        int memoryProcessRequired, blockSize, noOfBlocks, externalFragmentation,numberOfProcesses, mp[10],totalInternalFragmentation=0; 
        int i,p=0;
        int temp,n=0; char ch = 'y';
        

         //Promptting the use to give inputs
            cout << "\nMFT\nEnter the total memory available (in Bytes) -- "; 
            cin >> memoryProcessRequired;

            cout << "Enter the block size (in Bytes) -- ";
            cin >> blockSize;

            //computation for the number of block size and external Fragmentation
            noOfBlocks = memoryProcessRequired / blockSize;
            externalFragmentation = memoryProcessRequired - noOfBlocks * blockSize;

            //Promptting the use to give input
            cout << "\nEnter the number of processes -- "; 
            cin >> numberOfProcesses;

            // This is a for loop that accepts the memory required for the number of processes
            for(i=0; i<numberOfProcesses; i++)
            {
            cout << "Enter memory required for process " << (i+1) << " bin Bytes)-- " ; 
            cin >> mp[i];
            }

            //Displaying the number of blocks available in memory
            cout << "\nNo. of Blocks available in memory -- " << noOfBlocks;

            //Displaying output
            cout << "\n\nPROCESS\t\tMEMORY REQUIRED\t\t ALLOCATED\tINTERNAL FRAGMENTATION" << endl;
            cout << "------------------------------------------------------------------------------" << endl;

            // for loop check the condition that the number of processes "and" the number of blocks a true
            for(i=0;i<numberOfProcesses && p<noOfBlocks;i++)
            {
                //Displaying the output in a neat format with "\t"
                cout << "\n" << i+1 << "\t\t" << mp[i];
                if(mp[i] > blockSize){
                    cout << "\t\t\t NO\t\t\t---";
                }

                else{
                    cout << "\t\t\t YES\t\t\t" << blockSize-mp[i];
                    totalInternalFragmentation = totalInternalFragmentation + blockSize-mp[i];
                    p++;
                }

        }



        //final output based on computation and execution
        if(i<numberOfProcesses){
            cout << "\n\nMemory is Full, Remaining Processes cannot be accomodated" << endl;
            cout << "\n\nTotal Internal Fragmentation is " << totalInternalFragmentation; 
            cout << "\nTotal External Fragmentation is " << externalFragmentation; 
            
        }

    }

    void mvt() {

        //Declaration and initialization of variables
        int memoryProcessRequired, blockSize, noOfBlocks, externalFragmentation,numberOfProcesses, mp[10],totalInternalFragmentation=0; 
        int i,p=0;
        int temp,n=0; char ch = 'y';
        

         //Promting the user for input
            cout << "\nMVT\nEnter the total memory available (in Bytes)-- "; 
                cin >> memoryProcessRequired;
                temp=memoryProcessRequired;

                //gives the user a chance to continue to input memory required for process
                for(i=0;ch=='y';i++,n++)
                {
                    cout << "\n\nEnter memory required for process  " << (i+1) << " (in Bytes) -- "; 
                    cin >> mp[i];
                    
                    //is statment uses to check whether temp is less than or equal to memory required for process
                    if(mp[i]<=temp)
                    {
                        //Displays the information below
                        cout << "\nMemory is allocated for Process " << (i+1) << endl; 
                        temp = temp - mp[i];
                        cout << "\nDo you want to continue(y/n) -- "; 
                        cin >> ch;
                        
                    } else {
                        
                        //clear or breaks the program 
                        break; 
                    }
                    
                }

                // displays the information to the screen 
                cout << "\n\nMemory is Full" << endl;
                cout << "\n\nTotal Memory Available --" << memoryProcessRequired << endl;
                cout << "\n\nPROCESS\t\t MEMORY ALLOCATED "<< endl;
                cout << "---------------------------------" << endl;

                //Displaying the output in a neat format with "\t"
                for(i=0;i<n;i++){
                    cout << "\n " << (i+1) << "\t\t " << (mp[i]) << endl;
                    cout << "" << endl;

                }

                cout << "" << endl;

                //final output based on computation and execution
                cout << "\n\nTotal Memory Allocated is " << (memoryProcessRequired-temp) << endl;
                cout << "Total External Fragmentation is " << temp;    

    }


};