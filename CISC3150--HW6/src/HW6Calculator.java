//Xin Guan
//11/10/15
//CISC3150

//import java.io.*;

public class HW6Calculator{
	
	
	public static void main(String[] args){
		
		int n1, n2, n3;
		String s1, s2, s3;
		
//		n1=2;
//		s1="+";
//		n2=3;
		
		//n3=args[0].length();
		//n1=Integer.parseInt(args[0]);
		//s1=args[1];
		//n2=Integer.parseInt(args[2]);
		
//		s2=args[0];
//		
//		System.out.println(s2.charAt(0));
//		
//		if(args[0].charAt(0)<'0' || args[0].charAt(0)>'9'){
//			System.out.println("111");
//		}
		
		try{
			if(args.length!=3){
				throw new NotEnoughNumbersException();
			}
			
		}
		catch(NotEnoughNumbersException ex){
			System.out.println("please enter the second number.");
			System.exit(1);
		}
		
		
		try{
			
			if(args[0].length()!=1||
					args[0].charAt(0)<'0' || 
					args[0].charAt(0)>'9'){
				throw new NotANumberException();
			}
			
			if(args[2].length()!=1||
					args[2].charAt(0)<'0' || 
					args[2].charAt(0)>'9'){
				throw new NotANumberException();
			}
			
		}
		catch(NotANumberException ex){
			System.out.println("not a number, please re-enter your number.");
			System.exit(1);
		}
		
		try{
			if(args[1].length()==1||
					args[1].charAt(0)=='+' ||
					args[1].charAt(0)=='-' ||
					args[1].charAt(0)=='/' ||
					args[1].charAt(0)=='*' ||
					args[1].charAt(0)=='%'){
				
			}
			else{
				throw new IllegalOperationException();
			}
		}
		catch(IllegalOperationException ex){
			System.out.println("the operation is not correct.");
			System.exit(1);
		}
		
		
		
		
		
		try{
			n1=Integer.parseInt(args[0]);
			s1=args[1];
			n2=Integer.parseInt(args[2]);
			if(s1.equalsIgnoreCase("+")){
				System.out.println(n1+n2);
			}
			else if(s1.equalsIgnoreCase("-")){
				System.out.println(n1-n2);
			}
			else if(s1.equalsIgnoreCase("/")){
				System.out.println(n1/n2);
			}
			else if(s1.equalsIgnoreCase("*")){
				System.out.println(n1*n2);
			}
			else if(s1.equalsIgnoreCase("%")){
				System.out.println(n1%n2);
			}
		}
		catch(ArithmeticException ex){
			System.out.println("cannot divide by zero.");
			System.exit(1);
		}

		
		
	}
	
	
	
}



class NotANumberException extends IllegalArgumentException{

}

class IllegalOperationException extends Exception{
	
}

class NotEnoughNumbersException extends Exception{
	
}






