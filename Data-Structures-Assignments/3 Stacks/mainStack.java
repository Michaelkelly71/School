/**********************************************************
Author:  Michael Kelly Osei
Date:    30/02/21
Program: A program to Implement Stacks
**********************************************************/


public class mainStack {
    public static void main(String args[]){
		try {

            //pushing Strings elements into stack of size 5
            System.out.println("\n\t KELLY's STACKS IMPLEMENTATION\n");


			StackTest<String> stringStack = new StackTest<String>(5);
            System.out.println("String list after pushing five books\n");
			stringStack.push("Physics Book");
            stringStack.push("Chemistry Book");
            stringStack.push("Mathematics Book");
            stringStack.push("Boilogy Book");
            stringStack.push("English Book");

            //pushing interger elements into stack of size 5
			StackTest<Integer> integerStack = new StackTest<Integer>(5);
            System.out.println("\n\nInteger list after pushing five numbers\n");

			integerStack.push(2);
            integerStack.push(5);
            integerStack.push(10);
            integerStack.push(50);
            integerStack.push(200);
          
            
            System.out.println();//print a line
            //poping the last string elements out of the stack of size 5
            stringStack.pop();
            
            //poping the last interger elements outta the stack of size 5
            integerStack.pop();

            System.out.println();//print a line

            System.out.println("String list after popping elements");
            stringStack.display();//displaying stack list

            System.out.println();//print a line

            System.out.println("\nInteger list after popping elements");
            integerStack.display();//displaying stack list
            
            System.out.println("\n\nPeeks of individual stacks");
            System.out.println("For String: " + stringStack.peek());
            

            System.out.println("For Integer: "+ integerStack.peek());
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
