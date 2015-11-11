//CISC3150
//Xin Guan
//11/10/15
//
//Short Description:
// this calculator is the simple one.
// It takes only two integer numbers and one operator.
// So, there are totally 3 args from command line will be accepted.
// The answer will be an integer too.
// 
// Therefore, I basically check the following errors:
// If the length of args is not 3, throw a NotEnoughNumbersException.
// If args[0] and args[2] are not numbers, throw a NOTANumberException.
// If args[1] is not an operation, throw a IllegalOperationException.
// now I have a correct input.
// Calculate the solution.
// If any number divide by 0, throw an ArithmeticException.


public class HW6Calculator{
	
	public static void main(String[] args){
		
		int n1, n2; //two numbers
		String s1; //one operation
		
		//check the length of args
		//if it's not 3, throw a NotEnoughNumbersException.
		try{
			if(args.length!=3){
				throw new NotEnoughNumbersException();
			}
		}
		catch(NotEnoughNumbersException ex){
			System.out.println("please enter 2 numbers with 1 operation, ex: 7 + 7.");
			System.exit(1);
		}
		
		//check args[0] and args[2] 
		//if it's not a number, throw a NOTANumberException.
		try{
			
			for(int i=0; i<args[0].length(); i++){
				if(args[0].charAt(i)<'0' || args[0].charAt(i)>'9'){
					throw new NotANumberException();
				}
			}
			
			for(int i=0; i<args[2].length(); i++){
				if(args[2].charAt(i)<'0' || args[2].charAt(i)>'9'){
					throw new NotANumberException();
				}
			}
			
		}
		catch(NotANumberException ex){
			System.out.println("not a number, please re-enter your number.");
			System.exit(1);
		}
		
		//check args[1] 
		//if it's not an operation, throw a IllegalOperationException.
		try{
			if(args[1].length()>1){
				throw new IllegalOperationException();
			}
			
			if(args[1].charAt(0)=='+' ||
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
		
		//now calculate the solution
		//if there's a number divide by 0, throw an ArithmeticException.
		try{
			n1=Integer.parseInt(args[0]);
			s1=args[1];
			n2=Integer.parseInt(args[2]);
			if(s1.compareTo("+")==0){
				System.out.println(n1+n2);
			}
			else if(s1.compareTo("-")==0){
				System.out.println(n1-n2);
			}
			else if(s1.compareTo("/")==0){
				System.out.println(n1/n2);
			}
			else if(s1.compareTo("*")==0){
				System.out.println(n1*n2);
			}
			else if(s1.compareTo("%")==0){
				System.out.println(n1%n2);
			}
		}
		catch(ArithmeticException ex){
			System.out.println("cannot divide by zero.");
			System.exit(1);
		}

	}

}

//custom exceptions
class NotANumberException extends IllegalArgumentException{

}

class IllegalOperationException extends IllegalArgumentException{
	
}

class NotEnoughNumbersException extends IllegalArgumentException{
	
}






