#include <iostream>
using namespace std;

class Paging
{
    public:

    void technique();        
};


void Paging::technique()
{
    int ms, ps, nop, np, rempages, i, j, x, y, pa, offset;
    int s[10], fno[10][20];

        cout << "\nPAGING TECHNIQUE OF MEMORY MANAGEMENT " << endl;

        cout  << "\nEnter the memory size --\t";
        cin >> ms;


        cout  << "\nEnter the page size --\t\t";
        cin >> ps;

        nop = ms / ps;

        cout  << "\nThe no. of pages available in memory are -- " << nop;
        cout  << "\nEnter number of processes -- ";
        cin >> np;

        rempages = nop;

        for (i = 1; i <= np; i++) {
            cout  << "\nEnter no. of pages required for p["<<i<<"]-- ";
            cin >> s[i];

            if (s[i] > rempages) {
                cout  << "\nMemory is Full\n" << endl;
                break;
            }

            rempages = rempages - s[i];

            cout  << "\nEnter pagetable for p[" << i<<"]--";
            for (j = 0; j < s[i]; j++) {
            cin >> fno[i][j];
            }

        }

        cout  << "\nEnter Logical Address to find Physical Address " << endl;
        cout  << "\nEnter process no. and pagenumber and offset separated with spaces -- ";

        cin >> x;
        cin >> y;
        cin >> offset;

        if (x > np || y >= s[i] || offset >= ps) {
            cout  << "\nInvalid Process or Page Number or offset" << endl;
        }

        else {
            pa = fno[x][y] * ps + offset;
            cout  << "\nThe Physical Address is -- " << pa;
        }
}


