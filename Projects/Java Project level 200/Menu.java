import java.sql.*;
import java.util.*;
import java.lang.String;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Menu {

    Pin p = new Pin();
    
    //CHECKING IF YOU'RE IN THE DATABASE********************************************************************

    //underGrad Check***************************************************************************************
    public boolean check(String inputID){

        String table = "";

        try {
            dbConnection I = new dbConnection();
            Connection Database =  I.getDatabase();
            Statement stmt = Database.createStatement();
            ResultSet id = stmt.executeQuery("select ID from underGrad");


            while (id.next()) {
                int i = 0;
                ArrayList<String> ids = new ArrayList<>();
                ids.add(id.getString("ID"));

                table = table + String.format("%s\n",ids.get(i));  
            
            }
        
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(table.contains(inputID)){
            System.out.println("Access Granted");
            return true; 
        }

        else{
            return false;
        } 
            
    }



    //Grad Check********************************************************************************************
    public boolean check2(String inputID){

        String table = "";

        try {
            dbConnection I = new dbConnection();
            Connection Database =  I.getDatabase();
            Statement stmt = Database.createStatement();
            ResultSet id = stmt.executeQuery("select GID from grad");


            while (id.next()) {
                int i = 0;
                ArrayList<String> ids = new ArrayList<>();
                ids.add(id.getString("GID"));

                table = table + String.format("%s\n",ids.get(i));  
            }
        
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(table.contains(inputID)){
            System.out.println("Access Granted");
            return true; 
        }
        else{
            return false;
        }
            
    }



    //Setting and getting ID as Code************************************************************************
    private String code;

    public Menu(String IDs){
        code = IDs;
    }
    public void setCode(String IDs){
        code = IDs;
    }
    public String getCode(){
       return code;
    }



    //SCANNER CLASS TO RECEIVE INPUTS FROM USER*************************************************************
    Scanner input = new Scanner(System.in);
    



    //METHOD FOR THE WELCOME PAGE***************************************************************************

    public void  Welcome(){

        System.out.println("\nWELCOME TO VALLEY VIEW UNIVERSTIY,\nPLEASE SELECT CAMPUS \n");

        System.out.println(
        "1. Oyibi\n"+
        "2. Tachiman\n"+
        "3. Kumasi\n"+
        "4. Takoradi\n"+
        "5. Tamale\n"+
        "6. Swedru"
        );
    }



    //METHOD FOR CHOICES************************************************************************************

    public int choices(){
        System.out.print("\nChoice:  ");
        int choice = input.nextInt();
        return choice;
    }



    //METHOD FOR AFTER BEING ACCEPTED***********************************************************************
    public void Npage(){
        

    //SWITCH STATEMENT FOR CHOICES FROM 1 - 6 **************************************************************

        switch (choices()) {
            case 1:oyibi();
                switch (choices())
                {
                    case 1:payTution();
                        switch (choices())
                        {
                            case 1:underGradAcc();
                                    payOpt();
                                    input.nextLine();
                                    number();
                                    amount();
                                    receipt();

                                    if (choices()==1) {

                                        try {
                                            p.Pins();
                                        } catch (Exception e) {
                                        System.out.println(e);
                                        }

                                    } else {
                                        System.out.println("Thank you come again when raeady");
                                    }


                                    Connection conn = null;
                                    Statement stmt = null;

                                    try {
                                        dbConnection I = new dbConnection();
                                        conn =  I.getDatabase();
                                        stmt = conn.createStatement();

                                        String sql = "select Amount from underGrad WHERE ID = '"+getCode()+"';";
                                        ResultSet rs = stmt.executeQuery(sql);
                                        stmt.executeQuery(sql);

                                        if(rs.next())
                                        {
                                            double amt = rs.getDouble("Amount");

                                            
                                                Random num = new Random();
                                                
                                                JOptionPane.showMessageDialog(null, "Transaction was Successfull\nPayment made for GHS "+amt+
                                                "0 to\nGeneral Payment ova. \nTransaction ID: "+ num.nextInt(999999999) +1  +
                                                "\nFee charged: 5.00 " );
                                            

                                        }
                                            
                                        else
                                        {
                                            System.out.println("Record Not Found...");
                                        }
                                                    
                                                    
                                            rs.close();
                                        }catch(Exception e){
                                        System.out.println(e);
                                        }
                                    
                                break;

                            case 2:GradAcc();
                                    payOpt2();
                                    input.nextLine();
                                    number2();
                                    amount2();
                                    receipt2();
                                    if (choices()==1) {

                                        try {
                                            p.Pins();
                                        } catch (Exception e) {
                                        System.out.println(e);
                                        }

                                    } else {
                                        System.out.println("Thank you come again when raeady");
                                    }

                                    Connection conn1 = null;
                                    Statement stmt1 = null;

                                    try {
                                        dbConnection I = new dbConnection();
                                        conn1 =  I.getDatabase();
                                        stmt1 = conn1.createStatement();

                                        String sql = "select Amount from grad WHERE GID = '"+getCode()+"';";
                                        ResultSet rs = stmt1.executeQuery(sql);
                                        stmt1.executeQuery(sql);

                                        if(rs.next())
                                        {
                                            double amt = rs.getDouble("Amount");

                                            
                                                Random num = new Random();
                                                
                                                JOptionPane.showMessageDialog(null, "Transaction was Successfull\nPayment made for GHS "+amt+
                                                "0 to\nGeneral Payment ova. \nTransaction ID: "+ num.nextInt(999999999) +1  +
                                                "\nFee charged: 0.00 " );
                                            

                                        }
                                            
                                        else
                                        {
                                            System.out.println("Record Not Found...");
                                        }
                                                    
                                                    
                                            rs.close();
                                        }catch(Exception e){
                                        System.out.println(e);
                                        }

                                break;

                            default: System.out.println("Wrong Input Re-run and try again."); 
                                    break;
                        }

                            
                        break;

                    case 2:OtherPayments();
                        break;
                    case 3:enquiries();
                        break;

                    default: System.out.println("Wrong Input Re-run and try again."); 
                }   
                
            break;


            case 2: Tachiman();
                if (choices()!=1){
                    System.out.println("Wrong Input Re-run and try again."); 
                    System.exit(0);
                }

                enquary();

            break;


            case 3:Kumasi();
            break;

            case 4: Takoradi();
            break;

            case 5: Tamale();
            break;

            case 6: Swedru();
            break;

        default: System.out.println("Wrong Input re-run the program and try again."+
        " Thanks for using our pay system come again.");

        }       
    }



    //METHOD FOR ENQUIREIES FOR 3 THROUGH 6*****************************************************************

    private void Swedru() {
        enquiries();
    }

    private void Tamale() {
        enquiries();
    }

    private void Takoradi() {
        enquiries();
    }

    private void Kumasi() {
        enquiries();
    }



    //METHOD FOR UNDER GRADUATE ACCOUNT CODE / NUMBER*******************************************************
    public void underGradAcc(){
        input.nextLine();
        System.out.println("\nEnter Account Code:  ");
        String account = input.nextLine();
        
        try {
            
            dbConnection I = new dbConnection();
            Connection Database =  I.getDatabase();
            Statement stinsert2 = Database.createStatement();

            stinsert2.executeUpdate(
            "UPDATE underGrad SET AccCode = '"+account+"' WHERE (ID = '"+getCode()+"');"
            );

            stinsert2.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //METHOD FOR GRADUATE ACCOUNT CODE / NUMBER*************************************************************

    public void GradAcc(){
        input.nextLine();
        System.out.println("\nEnter Account Code:  ");
        String account = input.nextLine();
       
        try {
            
            dbConnection I = new dbConnection();
            Connection Database =  I.getDatabase();
            Statement stinsert3 = Database.createStatement();

            stinsert3.executeUpdate(
            "UPDATE grad SET AccCode = '"+account+"' WHERE (GID = '"+getCode()+"');"
            );

            stinsert3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } 

    }



    //METHOD FOR underGrad PAYMENT OPTIONS******************************************************************

    public void payOpt(){
        System.out.println(
            "\nSelect Payment Option\n"+
            "1. MTN Mobile Money\n"+
            "2. Tigo Cash\n"+
            "3. Vodafone Cash"
        );


        System.out.print("\nChoice: ");
        int choice1 = input.nextInt();
        if (choice1==1) { 
            
    //Vodafone Cash database updater************************************************************************
            try {
            
                dbConnection I = new dbConnection();
                Connection Database =  I.getDatabase();
                Statement stinsert3 = Database.createStatement();

                stinsert3.executeUpdate(
                "UPDATE underGrad SET Wallet = 'MTN Mobile Money' WHERE (ID = '"+getCode()+"');"
                );

                stinsert3.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } 

    //Tigo Cash database updater****************************************************************************

        } else if (choice1==2){
             
            try {
            
                dbConnection I = new dbConnection();
                Connection Database =  I.getDatabase();
                Statement stinsert3 = Database.createStatement();

                stinsert3.executeUpdate(
                "UPDATE underGrad SET Wallet = 'Tigo Cash' WHERE (ID = '"+getCode()+"');"
                );

                stinsert3.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } 

    //Vodafone Cash database updater************************************************************************

        } else if (choice1==3){
            try {
            
                dbConnection I = new dbConnection();
                Connection Database =  I.getDatabase();
                Statement stinsert3 = Database.createStatement();

                stinsert3.executeUpdate(
                "UPDATE underGrad SET Wallet = 'Vodafone Cash' WHERE (ID = '"+getCode()+"');"
                );

                stinsert3.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } 
        } else{
            System.out.println("Wrong Input re-run the program and try again.");
            System.exit(0);
        }

    }



    //METHOD FOR GRADUATE PAYMENT OPTIONS*******************************************************************

    public void payOpt2(){
        System.out.println(
            "\nSelect Payment Option\n"+
            "1. MTN Mobile Money\n"+
            "2. Tigo Cash\n"+
            "3. Vodafone Cash"
        );


        System.out.print("\nChoice: ");
        int choice1 = input.nextInt();
        if (choice1==1) { 
            

    //Vodafone Cash database updater************************************************************************
            try {
            
                dbConnection I = new dbConnection();
                Connection Database =  I.getDatabase();
                Statement stinsert3 = Database.createStatement();

                stinsert3.executeUpdate(
                "UPDATE grad SET Wallet = 'MTN Mobile Money' WHERE (GID = '"+getCode()+"');"
                );

                stinsert3.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } 


    //Tigo Cash database updater****************************************************************************

        } else if (choice1==2){
             
            try {
            
                dbConnection I = new dbConnection();
                Connection Database =  I.getDatabase();
                Statement stinsert3 = Database.createStatement();

                stinsert3.executeUpdate(
                "UPDATE grad SET Wallet = 'Tigo Cash' WHERE (GID = '"+getCode()+"');"
                );

                stinsert3.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } 


    //Vodafone Cash database updater************************************************************************

        } else if (choice1==3){
            try {
            
                dbConnection I = new dbConnection();
                Connection Database =  I.getDatabase();
                Statement stinsert3 = Database.createStatement();

                stinsert3.executeUpdate(
                "UPDATE grad SET Wallet = 'Vodafone Cash' WHERE (GID = '"+getCode()+"');"
                );

                stinsert3.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } 

        } else{
            System.out.println("Wrong Input re-run the program and try again.");
            System.exit(0);
        }

    }



    //METHOD FOR underGrad WALLET***************************************************************************
    public void number(){
        System.out.println("\nEnter Mobile Number: ");
        String num = input.nextLine();

        try {
            
            dbConnection I = new dbConnection();
            Connection Database =  I.getDatabase();
            Statement stinsert3 = Database.createStatement();

            stinsert3.executeUpdate(
            "UPDATE underGrad SET Number = '"+num+"' WHERE (ID = '"+getCode()+"');"
            );

            stinsert3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //METHOD FOR grad WALLET********************************************************************************
    public void number2(){
        System.out.println("\nEnter Mobile Number: ");
        String num = input.nextLine();

        try {
            
            dbConnection I = new dbConnection();
            Connection Database =  I.getDatabase();
            Statement stinsert3 = Database.createStatement();

            stinsert3.executeUpdate(
            "UPDATE grad SET Number = '"+num+"' WHERE (GID = '"+getCode()+"');"
            );

            stinsert3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //METHOD FOR OTHER PAYMENTS*****************************************************************************

    private void OtherPayments() {
        System.out.println(
                "\nwhat else would you like to pay for\n"+
                "1. Feeding\n"+
                "2. Graduation" 
            );


            System.out.print("\nChoice: ");
            int choice1 = input.nextInt();

            switch (choice1) {
                case 1: final double full = 804.00;
                        final double part = 402.00;

                        System.out.println(
                            "1. Full feeding GHS 804.00\n" +
                            "2. Partial feeding GHS 402.00\n" 
                        );


                        System.out.print("\nChoice: ");
                        int choice = input.nextInt();

                        if (choice == 1) {

                            payOpt();
                            input.nextLine();
                            number();

                            System.out.print("\nEnter Mobile money pin\nPin: ");
                            String a = input.nextLine();

                            System.out.println("\nPayment of GHS " + full + "0 has been" + 
                                " made into the universities account\nYou are now a full feeder.");

                        } else if (choice == 2){

                            payOpt();
                            input.nextLine();
                            number();

                            System.out.print("\nEnter Mobile money pin\nPin: ");
                            String a = input.nextLine();

                            System.out.println("\nPayment of GHS " + part + "0 has been" + 
                                " made into the universities account\nYou are now a partial feeder.");
                            
                            System.out.println(" ");

                        }


                    break;
                
                case 2: final double graduation = 1200.00;
                        System.out.println("You can only pay in full. Are you ready\n1. Yes\t2.No");
                        
                        System.out.print("\nChoice: ");
                        int choice2 = input.nextInt();

                            switch (choice2) {
                                case 1: payOpt();
                                        input.nextLine();
                                        number();

                                        System.out.print("\nEnter Mobile money pin\nPin: ");
                                        String a = input.nextLine();

                                        System.out.println("\nPayment of GHS " + graduation + "0 has been" + 
                                        " made into the universities account\n Happy Graduation and Goodluck out there!!!." );
                                    
                                    break;
                            
                                default:System.out.println("Come back when fully ready. Thank you.");
                                    break;
                            }
                    break;
            
                default:System.out.println("Wrong Input re-run the program and try again.");
                        System.exit(0);
                    break;
            }

    }



    //METHOD FOR underGrad AMOUNT TO BE PAID****************************************************************

    private void amount() {
        System.out.print("\nEnter amount to be paid in (GH$)\nGHS : ");

        double ghc = input.nextDouble();
        final double fees = 4000;
        double balance = fees - ghc;

        try {
            
            dbConnection I = new dbConnection();
            Connection Database =  I.getDatabase();
            Statement stinsert2 = Database.createStatement();

            stinsert2.executeUpdate(
            "UPDATE underGrad SET Amount = '"+ghc+"',Balance = '"+balance+"' WHERE (ID = '"+getCode()+"');"
            );

            stinsert2.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //METHOD FOR underGrad AMOUNT TO BE PAID****************************************************************

    private void amount2() {
        System.out.print("\nEnter amount to be paid in (GH$)\nGHS : ");

        double ghc = input.nextDouble();
        final double fees = 4000;
        double balance = fees - ghc;

        try {
            
            dbConnection I = new dbConnection();
            Connection Database =  I.getDatabase();
            Statement stinsert2 = Database.createStatement();

            stinsert2.executeUpdate(
            "UPDATE grad SET Amount = '"+ghc+"',Balance = '"+balance+"' WHERE (GID = '"+getCode()+"');"
            );

            stinsert2.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //METHOD FOR OPTION ENQUIRIES***************************************************************************

    private void enquiries() {
        System.out.println(
                "\nContact Us\n"+
                "\n1. Call us on: 0248570832"+
                "\n2. Email us at: michaelkellyosei@gmial.com"+
                "\n3. Find us on Facebook, Instagram and many more with @_VVU.\nThank you and we'll be in touch." 
            );
    }

    

    //METHOD FOR OPTION OYIBI*******************************************************************************
    public void oyibi(){
        System.out.println(
                "\nWhat are we doing today\n"+
                "1. Pay Tution\n"+
                "2. Other Payments\n"+
                "3. Enquiries" 
            );
    }


    //METHOD FOR OPTION TACHIMAN****************************************************************************
    public void Tachiman(){
        System.out.println(
            "\n1. Enquaries"
        );

    }



    //METHOD FOR PAY TUTION*********************************************************************************
    public void payTution(){
        System.out.println(
            "\n1. Under Graduate\n"+
            "2. Graduate School"       
        );

    }



    //METHOD FOR TECHIMAN ENQUIREY**************************************************************************

    public void enquary(){
        System.out.println(
            "\n1. Regular\n"+
            "2. Distane\n"+
            "3. Sandwich\n"+
            "4. Graduate Studies\n" 
        );



    //Regular***********************************************************************************************
        
        System.out.print("Choice: ");
        int choice = input.nextInt();
        
                if (choice==1) {
                    System.out.println(
                        "\n1. Programmes\n"+
                        "2. General Requirements\n"+
                        "3. Admission Period" 
                    );


                //Programmes*********************************************************************************
                    System.out.print("\nChoice: ");
                    int choice1 = input.nextInt();

                    if (choice1==1) {
                        System.out.println(
                            "\nBBA Accounting\nBBA Banking and Finance\nBBA HRM\nBBA Management"+
                            "\nBBA Marketing\nBSc Agribusiness\nand many more"
                        );
                        

                //General Requirements***********************************************************************

                    } else if (choice1==2) {
                    enquiries();


                //Admission Period***************************************************************************

                    } else if (choice1==3){
                        System.out.println(
                            "\n1. January for Fulltime/Distance\n2. September for Fulltime/Distance"
                        );

                        System.out.println("\nWe hope this helps. Come again.");
                    } 

                    else{
                        System.out.println("Wrong Input re-run the program and try again.");
                        System.exit(0);
                    }
                    
                }
    

    //Distance***********************************************************************************************
            
            else if (choice==2){
                System.out.println(
                    "\n1. Programmes\n"+
                    "2. General Requirements\n"+
                    "3. Admission Period" 
                );
            

            //Programmes*************************************************************************************
                
                System.out.print("\nChoice: ");
                int choices = input.nextInt();

                if (choices==1) {
                        System.out.println(
                            "\nMBA Banking and Finance\nMBA Human Resource Management\nMBA Strategic Management"
                        );
                        
                        System.out.println("More to be uploaded soon. Thank you for your leniancy");
                }


            //General Requirements***************************************************************************
                else if (choices==2) {
                    System.out.println(
                        "\n1. SSSCE/WASSCE\n"+
                        "2. GBCE holders\n"+
                        "3. HND  and Diploma holders\n"+
                        "4. Diploma in Basic Education\n"+
                        "5. Teachers Cert A holders\n"+
                        "6. GCE O and A Levels\n"+
                        "7. Baccalaureate\n"+
                        "8. High School Diploma\n"+
                        "9. Diploma in Nursing\n"+
                        "10. Mature Students\n"+
                        "10. Mature Students\n"+
                        "11. First Degree for Masters"
                    );


                    System.out.print("\nChoice: ");
                    int choice2 = input.nextInt();

                        if (choice2<12 && choice2>0) {
                            System.out.println(
                                "Invalid option or no data available now. Please check again soon"
                            );

                            System.exit(0);

                        } else {
                                System.out.println("Wrong Input re-run the program and try again.");
                                System.exit(0);
                            }

                }


            //Admission Period******************************************************************************
                    
                else if (choices==3){
                    System.out.println(
                        "1. January for Fulltime/Distance\n2. September for Fulltime/Distance"
                    )
                    ;
                    System.out.println("\nWe hope this helps. Come again.");

                } else {
                        System.out.println("Wrong Input re-run the program and try again.");
                        System.exit(0);
                    }

            }
        

    //Sandwich**********************************************************************************************
            
            else if (choice==3){
                System.out.println(
                    "\n1. Programmes\n"+
                    "2. General Requirements\n"+
                    "3. Admission Period" 
                );
            

            //Programmes************************************************************************************

                System.out.print("\nChoice: ");
                int choices = input.nextInt();

                if (choices==1) {
                        System.out.println(
                            "\n1. BEd Accounting\n"+
                            "2. BEd Mathematics\n"+
                            "3. BEd English\n"+
                            "4. BEd Management\n"+
                            "5. BEd I.T\n"+
                            "6. BEd Social Studies\n"
                        );

                        System.out.println("More to be uploaded soon. Thank you for your leniancy");
                }


            //General Requirements**************************************************************************
                else if (choices==2) {
                    System.out.println(
                        "\n1. SSSCE/WASSCE\n"+
                        "2. GBCE holders\n"+
                        "3. HND  and Diploma holders\n"+
                        "4. Diploma in Basic Education\n"+
                        "5. Teachers Cert A holders\n"+
                        "6. GCE O and A Levels\n"+
                        "7. Baccalaureate\n"+
                        "8. High School Diploma\n"+
                        "9. Diploma in Nursing\n"+
                        "10. Mature Students\n"+
                        "10. Mature Students\n"+
                        "11. First Degree for Masters"
                    );

                    System.out.print("\nChoice: ");
                    int choice2 = input.nextInt();

                        if (choice2<12 && choice2>0) {
                            System.out.println(
                                "Invalid option or no data available now. Please check again soon");
                            System.exit(0);

                        } else {
                                System.out.println("Wrong Input re-run the program and try again.");
                                System.exit(0);
                            }

                }


            //Admission Period******************************************************************************
                    
                else if (choices==3){
                    System.out.println("1. June/July for Sandwich Education");
                    System.out.println("\nWe hope this helps. Come again.");

                } else {
                        System.out.println("Wrong Input re-run the program and try again.");
                        System.exit(0);
                    }

            }


    //Graduate Studies**************************************************************************************       
                else if (choice==4){
                System.out.println(
                    "\n1. Programmes\n"+
                    "2. General Requirements\n"+
                    "3. Admission Period" 
                );
            

            //Programmes************************************************************************************
                
                System.out.print("\nChoice: ");
                int choices = input.nextInt();

                if (choices==1) {
                        System.out.println(
                            "\nMBA Banking and Finance\nMBA HRM\nMBA Strategic Management"
                        );

                        System.out.println("More to be uploaded soon. Thank you for your leniancy");
                }


            //General Requirements**************************************************************************
                else if (choices==2) {
                    System.out.println(
                        "\n1. SSSCE/WASSCE\n"+
                        "2. GBCE holders\n"+
                        "3. HND  and Diploma holders\n"+
                        "4. Diploma in Basic Education\n"+
                        "5. Teachers Cert A holders\n"+
                        "6. GCE O and A Levels\n"+
                        "7. Baccalaureate\n"+
                        "8. High School Diploma\n"+
                        "9. Diploma in Nursing\n"+
                        "10. Mature Students\n"+
                        "10. Mature Students\n"+
                        "11. First Degree for Masters"
                    );


                    System.out.print("\nChoice: ");
                    int choice2 = input.nextInt();

                        if (choice2<12 && choice2>0) {
                            System.out.println(
                                "Invalid option or no data available now. Please check again soon"
                            );

                            System.exit(0);

                        } else {
                                System.out.println("Wrong Input re-run the program and try again.");
                                System.exit(0);
                            }
                }


        //Admission Period*********************************************************************************
                    
                else if (choices==3){
                    System.out.println("Invalid option or no data available now. Please check again soon");

                } else {
                        System.out.println("Wrong Input re-run the program and try again.");
                        System.exit(0);
                    }

                }

    }



    //METHOD TO PRINT underGrad INFORMATION*****************************************************************

    public void receipt(){

        Connection conn = null;
        Statement stmt = null;

         try {
            dbConnection I = new dbConnection();
            conn =  I.getDatabase();
            stmt = conn.createStatement();

            String sql = "select AccCode,Lname,Fname,Mname,Wallet,Amount,Balance,Number from underGrad WHERE ID = '"+getCode()+"';";
            ResultSet rs = stmt.executeQuery(sql);
            stmt.executeQuery(sql);

            if(rs.next())
			{
                String lname = rs.getString("Lname");
                String fname = rs.getString("Fname");
                String mname = rs.getString("Mname");

                System.out.println("\nBank: PBL\nAccCode: " + rs.getString("AccCode") +

                "\nName: "+ lname+ " " + fname + " " + mname +
                "\nWallet: "+ rs.getString("Wallet") +
                "\nAmount: "+ rs.getDouble("Amount") +
                "\nBalance: "+ rs.getDouble("Balance") +
                "\nNumber: " + rs.getString("Number") +
                "\n\nPlease confirm 1. Yes\t2. No"

                );

            }
            
			else
			{
				System.out.println("Record Not Found...");
			}
                   
            rs.close();
            
            }catch(Exception e){
			System.out.println(e);
            }

    }



    //METHOD TO PRINT Grad INFORMATION**********************************************************************
        
        public void receipt2() {

            Connection conn = null;
            Statement stmt = null;

            try {
                dbConnection I = new dbConnection();
                conn =  I.getDatabase();
                stmt = conn.createStatement();

                String sql = "select AccCode,Lname,Fname,Mname,Wallet,Amount,Balance,Number from grad WHERE GID = '"+getCode()+"';";
                ResultSet rs = stmt.executeQuery(sql);
                stmt.executeQuery(sql);

                if(rs.next()){

                    String lname = rs.getString("Lname");
                    String fname = rs.getString("Fname");
                    String mname = rs.getString("Mname");

                    System.out.println("\nBank: PBL\nAccCode: " + rs.getString("AccCode") +

                    "\nName: "+ lname+ " " + fname + " " + mname +
                    "\nWallet: "+ rs.getString("Wallet") +
                    "\nAmount: "+ rs.getDouble("Amount") +
                    "\nBalance: "+ rs.getDouble("Balance") +
                    "\nNumber: " + rs.getString("Number") +
                    "\n\nPlease confirm 1. Yes\t2. No"

                    );

                }
                
                else{
                    System.out.println("Record Not Found...");
                }
                    
                rs.close();

                }catch(Exception e){
                System.out.println(e);
            }


        }

        
}