//Xin Guan
//11/10/15
//CISC3150

public class HW6Calculator{
	
	public static void main(String[] args){
		
		int n1, n2;
		String s1;
		
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

class NotANumberException extends IllegalArgumentException{

}

class IllegalOperationException extends Exception{
	
}

class NotEnoughNumbersException extends Exception{
	
}






