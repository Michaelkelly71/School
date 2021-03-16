/*
ID              NAME
219cs01090015   OSEI MICHAEL KELLY
219it02000229   KOBBINA AMOAH
0000000000148   BADOLO DEBORA

A program to simulate memory management techniques
**/


//Adding the library iostream which allows the user to input data and see outputs on the screen 
#include <iostream>

//Including the classes created so the main can create objects and use it
#include "ManagementTechnique.cpp"
#include "Contiguous.cpp"
#include "Paging.cpp"
#include "MemAlgorithms.cpp"
#include "Bankers.cpp"


//Helps the user to use the input and the output streams
using namespace std;

//the whole code is executed in the "main" function
int main(){

    //Creating an object of the classes
    ManagementTechnique memory;
    Contiguous fits;
    Paging tech;
    MemAlgorithms use;
    Bankers algorithm;
    
    //variable for running the program again is declared here
    char again = 'y';

    //Displays output to the screen
            cout << "\n\n"
            "\t*******************************************************************************\n"
            "\tA program to simulate memory management techniques with Positive Intergers Only\n" 
            "\t*******************************************************************************"<< endl;
            
    // a do while loop that executes code at least once checks if conditon is true and then either execute or 
    //exits  
    do  {
        
        //Displays this menu to the screen
        cout << 
        "\n1. Memory Management Techniques \n" <<
        "2. Contiguous memory allocation techniques\n"
        "3. Paging technique of memory management.\n"
        "4. Scheduling Algorithms\n"
        "5. Bankers algorithm for the purpose of deadlock avoidance\n"
       
        << endl; //goes to the next line 

        //choice is declared
        int choice;
        cout << "\nChoice (Positive Integers Only Please): ";
        //choice is input here
        cin >> choice;

        // clears buffer of int and char or int to char or vise versa
        cin.clear();
        
        if (choice == 1)
        {
            //if statement checking the condition that the input choice is 1
            memory.contiguous(choice, again);
        }
       
        else if (choice == 2)
        {
            //this portion is executed only if the choice input above is 2
            fits.contiguous(choice, again);
        }

        else if (choice == 3)
        {
             //this portion is executed only if the choice input above is 3
            tech.technique();
        }

        else if (choice == 4)
        {
             //this portion is executed only if the choice input above is 4
            use.algorithms(choice, again);
        }
        
        else if (choice == 5)
        {
             //this portion is executed only if the choice input above is 5
            algorithm.main();
        }
        
        else{

             //this portion is executed only if the choice was not in the list given
            cout << "Wrong Input, Not part of list!!!" << endl;
            
        }

        //gives the user the chance to either go to the main menu or exit the program
        cout << "\n\nMain Menu???: ";
        cin.clear();
        cin >> again;
        
        
    } 

    //menu and code repeats while again == y
    while(again == 'y');

}
