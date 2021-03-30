#include <iostream>
#define max 25
using namespace std;


class Contiguous{

public: 

    void contiguous(int choice, char again){
        
        

        do{

            cout << "\nContiguous memory allocation techniques\n"
            "\n1. Worst-fit  \n2. Best-fit \n3. First-fit\n\nChoice: ";
            cin >> choice;
            cin.clear();
            
            switch (choice) {
            case 1:
                worstFit();

                break;

            case 2:
                bestFit();

                break;

            case 3:
                firstFit();

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






    void worstFit() {

        int frag[max],b[max],f[max],i,j,nb,nf,temp;
        int bf[max],ff[max];

        cout << "\n\tMemory Management Scheme - Worst Fit" << endl;

        cout << "\nEnter the number of blocks:";
        cin >> nb;

        cout << "Enter the number of files:";
        cin >> nf;

        cout << "\nEnter the size of the blocks:-\n";

        for (i = 1; i <= nb; i++) {
            cout << "Block " << i << ": ";
            cin >> b[i];
        }

        cout << "\nEnter the size of the files :-\n";

        for (i = 1; i <= nf; i++) {
            cout << "File "<< i << ": ";
            cin >> f[i];
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

        cout << "\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement" << endl;

        for (i = 1; i <= nf; i++) {
            cout << "\n"<< i<<"\t\t"<< f[i]<<"\t\t"<< ff[i]<<"\t\t"<< b[ff[i]]<<"\t\t"<< frag[i];
        }
    }

    void bestFit() {

        int frag[max],b[max],f[max],i,j,nb,nf; 
        int temp = 0, lowest = 10000;
        int bf[max],ff[max];

        cout << "\n\tMemory Management Scheme - Best Fit" << endl;

        cout << "\nEnter the number of blocks:";
        cin >> nb;

        cout << "Enter the number of files:";
        cin >> nf;

        cout << "\nEnter the size of the blocks:-\n";

        for (i = 1; i <= nb; i++) {
            cout << "Block " << i << ": ";
            cin >> b[i];
        }

        cout << "\nEnter the size of the files :-\n";

        for (i = 1; i <= nf; i++) {
            cout << "File "<< i << ": ";
            cin >> f[i];
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

        cout << "\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement" << endl;

        for (i = 1; i <= nf && ff[i] != 0; i++) {
            cout << "\n"<< i<<"\t\t"<< f[i]<<"\t\t"<< ff[i]<<"\t\t"<< b[ff[i]]<<"\t\t"<< frag[i];
        }

    }

    
    void firstFit(){

        int frag[max],b[max],f[max],i,j,nb,nf; 
        int temp = 0, highest = 0;
        int bf[max],ff[max];

        cout << "\n\tMemory Management Scheme - First Fit";

        cout << "\nEnter the number of blocks:";
        cin >> nb;

        cout << "Enter the number of files:";
        cin >> nf;

        cout << "\nEnter the size of the blocks:-\n";

        for (i = 1; i <= nb; i++) {
            cout << "Block " << i << ": ";
            cin >> b[i];
        }

        cout << "\nEnter the size of the files :-\n";

        for (i = 1; i <= nf; i++) {
            cout << "File "<< i << ": ";
            cin >> f[i];
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

        cout << ("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");

        for (i = 1; i <= nf; i++) {
            cout << "\n"<< i<<"\t\t"<< f[i]<<"\t\t"<< ff[i]<<"\t\t"<< b[ff[i]]<<"\t\t"<< frag[i];
        }

    }

};