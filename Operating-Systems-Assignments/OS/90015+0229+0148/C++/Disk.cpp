//including the iostream liabrary for input and output
#include <iostream>
//including the vector library to use array like list in the code
#include <vector>

//helps defind cout for output
using namespace std;

//class disk begins
class Disk{

//public to show this function is accessible by all
public: 

    void algorithm(int choice, char again){
        
        
        // do while loop for printing menu till condition is false
         do{
            cout << "\nDISK SCHEDULING ALGORITHM\n\n1. FCFS  \n2. SCAN \n3. C-SCAN\n\nChoice: ";
            cin >> choice;
            cin.clear();

            switch (choice) {
                case 1:
                    FCFS();

                    break;

                case 2:
                    SCAN();

                    break;

                case 3:
                    CSCAN();

                    break;

                default:
                    cout << "\nWrong Input Re-run the program and try again!!!";
                    break;
            }

            cout << "\n\nAnother Test???: ";
            cin >> again;
            
        }

        while(again == 'y');

        

    }





    // function FCFS to take care of first come first serve algorithm
    void FCFS() {

        /*
            FCFS Disk Scheduling Algorithm
            As the name suggests, the I/O requests are addressed in the order of their arrival.
        */

        //Declaring variable for use 
        int i,j,k,n,m,sum=0,x,y,h;

        // Ouput and Input of data from system to user and vise versa
        cout<<"\nEnter the size of disk\n";
        cin>>m;
        cout<<"\nEnter number of requests\n";
        cin>>n;
        cout<<"\nEnter the requests\n";

        // creating an array of size n
        vector <int> a(n);
        for(i=0;i<n;i++){
            cin>>a[i];
        }
        for(i=0;i<n;i++){
            if(a[i]>m){
                cout<<"\nError, Unknown position "<<a[i]<<"\n";
            }
        }
        cout<<"\nEnter the head position\n";
        cin>>h;
        
        // head will be at h at the starting
        int temp=h;
        cout<<temp;
        for(i=0;i<n;i++){
            cout<<" -> "<<a[i]<<' ';
            // calculating the difference for the head movement
            sum+=abs(a[i]-temp);
            // head is now at the next I/O request
            temp=a[i];
        }
        cout<<'\n';
        cout<<"Total head movements = "<< sum<<'\n';
        
    }



    void SCAN() {

        /*
            SCAN Disk Scheduling Algorithm 
            In SCAN algorithm the disk arm moves into a particular direction and 
            services the requests coming in its path and after reaching the end of the disk, 
            it reverses its direction and again services the request arriving in its path. 
            This algorithm  kind of works like an elevator therefore with another name as the elevator algorithm. 
            As a result, the requests at the midrange are serviced more and 
            those arriving behind the disk arm will have to wait.
        */

       // Variable declaration
        int i,j,k,n,m,sum=0,x,y,h;

        //Output to user and accepting input
        cout<<"\nEnter the size of disk: ";
        cin>>m;
        cout<<"\nEnter number of requests: ";
        cin>>n;
        cout<<"\nEnter the requests: ";

        //vector/ array-like declaration of 'a' with n numbers and b 
        vector <int> a(n),b;
        for(i=0;i<n;i++){
            cin>>a[i];
        }
        for(i=0;i<n;i++){
            if(a[i]>m){
                cout<<"\nError, Unknown position "<<a[i]<<"\n";
            
            }
        }
        cout<<"\nEnter the head position: ";
        cin>>h;
        int temp=h;

        //inserting h = head in the list of of disk requests
        a.push_back(h);
        a.push_back(m);
        a.push_back(0);

        //sorting the list of disk request from start to end with the new head
        sort(a.begin(),a.end());

        //
        for(i=0;i<a.size();i++){
            if(h==a[i])
                break;
        }
        k=i;
        if(k<n/2){
            for(i=k;i<a.size();i++){
                b.push_back(a[i]);
            }
            for(i=k-1;i>=0;i--){
                b.push_back(a[i]);
            }
        }
        else{    
            for(i=k;i>=0;i--){
                b.push_back(a[i]);
            }
            for(i=k+1;i<a.size();i++){
                b.push_back(a[i]);
            }
        }
        temp=b[0];
        cout<<temp;
        for(i=1;i<b.size();i++){
            cout<<" -> "<<b[i];
            sum+=abs(b[i]-temp);
            temp=b[i];
        }
        cout<<'\n';

        // total and average head movement shown to the user after computations
        cout<<"\nTotal head movements = "<< sum<<'\n';
        cout<<"\nAverage head movement = "<<(float)sum/n<<'\n';

    }



    void CSCAN(){

        /*
            CSCAN Disk Scheduling Algorithm 
            In CSCAN algorithm, the disk arm instead of reversing its direction goes 
            to the other end of the disk and starts servicing the requests from there. 
            So, the disk arm moves in a circular fashion and this algorithm is also 
            similar to CSCAN algorithm and hence it is known as C-SCAN (Circular SCAN).

        */

         // Variable declaration      
        int i,j,k,n,m,sum=0,x,y,h;


        //Output to user and accepting input
        cout<<"\nEnter the size of disk: ";
        cin>>m;
        cout<<"\nEnter number of requests: ";
        cin>>n;
        cout<<"\nEnter the requests: ";
        
        // creating an array a and b, a of size n
        vector <int> a(n),b;
        for(i=0;i<n;i++){
            cin>>a[i];
        }
        for(i=0;i<n;i++){
            if(a[i]>m){
                cout<<"\nError, Unknown position "<<a[i]<<"\n";

            }
        }



        
        //inserting h = head in the list of of disk requests
        cout<<"\nEnter the head position: ";
        cin>>h;
        int temp=h;
        a.push_back(h);
        a.push_back(m);
        a.push_back(0);


        //sorting the list of disk request from start to end with the new head
        sort(a.begin(),a.end());
        for(i=0;i<a.size();i++){
            if(h==a[i])
                break;
        }
        k=i;
        if(k<n/2){
            for(i=k;i<a.size();i++){
                b.push_back(a[i]);
            }
            for(i=0;i<=k-1;i++){
                b.push_back(a[i]);
            }
        }
        else{    
            for(i=k;i>=0;i--){
                b.push_back(a[i]);
            }
            for(i=a.size()-1;i>=k+1;i--){
                b.push_back(a[i]);
            }
        }
        temp=b[0];
        cout<<temp;
        for(i=1;i<b.size();i++){
            cout<<" -> "<<b[i];
            sum+=abs(b[i]-temp);
            temp=b[i];
        }
        

        // total and average head movement shown to the user after computations
        cout<<'\n';
        cout<<"\nTotal head movements = "<< sum<<'\n';
        cout<<"\nAverage head movement = "<<(float)sum/n<<'\n';

    }

};