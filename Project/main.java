/*****************************************************************************************
Author:  Osei Michael Kelly
Date:    15/06/2020
Program: A program to allow you make the necessary payments and fees via your mobile phone 
******************************************************************************************/

import java.util.*;


public class main {
    
    //MAIN PROGRAM****************************************************************
    public static void main(String[] args){
        System.out.println("To proceed, Enter your ID: ");
        String ID = new Scanner(System.in).nextLine();

        
        //LINKS MENU CLASS TO MAIN CODE*******************************************
        Menu Fpage = new Menu(ID);

        //linking and calling the dbConnection class******************************
         if(Fpage.check(ID)){

            System.out.println("Proceed");
        } else if (Fpage.check2(ID)){
            
        }else{
            System.out.println("Wrong ID re-run the program and try again.");
            System.exit(0);
        }

        
        //FIRST PAGE CALL**********************************************************
        Fpage.Welcome();

        //CONSECUTIVE PAGES CALL***************************************************
        Fpage.Npage();
    }

}