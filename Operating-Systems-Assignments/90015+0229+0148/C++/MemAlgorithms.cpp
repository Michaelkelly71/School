#include <iostream>
#include "NonPreemptive.cpp"
#include "MultiLevel.cpp"
#include "Disk.cpp"
  

using namespace std;


class MemAlgorithms{

public: 

    NonPreemptive cpu;
    MultiLevel multi;
    Disk schedule;

    void algorithms(int choice, char again){
        

        do{

            cout << " \nMemory Allocation Techniques\n"
            "\n1. Non-preemptive CPU scheduling algorithms\n2. Multi-level queue scheduling algorithm\n3. Disk scheduling algorithms"
            "\n\nChoice: ";
            #include "Disk.cpp"
            cin >> choice;
            cin.clear();
            
            switch (choice) {
            case 1:
                cpu.list(choice, again);

                break;

            case 2:
                multi.level();
                break;

            case 3:
                schedule.algorithm(choice, again);

                break;

            default:
                cout << ("\nWrong Input Re-run the program and try again!!!");
                break;
        }

            cout << "\n\nAnother Test???: ";
            cin >> again;
        }

        while(again == 'y');

        

    }
};