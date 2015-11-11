//CISC3150
//Xin Guan
//11/10/15
//
//Short Description:
// this calculator is for long expression calculating, ex:2 + 3 - 7 * 9 / 3 + 11.
// it takes odd length of args; even args are numbers; odd args are operations.
//
// Therefore, I will check the following errors:
// If the length of args is not odd, throw a NotEnoughNumbersException2.
// If even args are not numbers, throw a NOTANumberException.
// If odd args are not operations, throw a IllegalOperationException.
// now I have a correct input expression.
//
// Calculate the solution.
// I used linked list for holding the long expression.
// check from the beginning of the list, 
// if found *,/,%, calculate the answer, then shrink the list in current position by one.
// check from the beginning again,
// if found +, -, calculate the answer, then shrink the list in current position by one.
// If any number divide by 0, throw an ArithmeticException.



public class HW6Calculator2{
	
	public static void main(String[] args){

		myList list;
		myList current;

		//check the length of the input args
		//if the length is even, throw an exception.
		try{
			if((args.length%2)!=1){
				throw new NotEnoughNumbersException2();
			}
		}
		catch(NotEnoughNumbersException2 ex){
			System.out.println("please enter enough numbers or operations.");
			System.exit(1);
		}
		
		//check the even args are all numbers or not
		//if not, throw an exception.
		try{	
			for(int i=0; i<args.length; i=i+2){
				for(int j=0; j<args[i].length(); j++){
					if(args[i].charAt(j)<'0' || args[i].charAt(j)>'9'){
						throw new NotANumberException2();
					}
				}	
			}
		}
		catch(NotANumberException2 ex){
			System.out.println("not a number, please re-enter your number.");
			System.exit(1);
		}
		
		//check the odd args are operation or not
		//if not, throw an exception.
		try{
			for(int i=1; i<args.length-1; i=i+2){
				if(args[i].length()>1){
					throw new IllegalOperationException2();
				}
				
				if(args[i].charAt(0)=='+' ||
						args[i].charAt(0)=='-' ||
						args[i].charAt(0)=='/' ||
						args[i].charAt(0)=='*' ||
						args[i].charAt(0)=='%'){
				}
				else{
					throw new IllegalOperationException2();
				}
			}
		}
		catch(IllegalOperationException2 ex){
			System.out.println("the operation is not correct.");
			System.exit(1);
		}
		
		//now here are all the numbers in even args with operations in odd args
		//calculate them.
		//if there's a number divide by 0, throw an ArithmeticException.
		try{
			
			//store all the args in linked list.
			list = new myList(Integer.parseInt(args[0]), args[1]);
			current=list;
			int i;
			for(i=2; i<args.length-1; i=i+2){
				current.next= new myList(Integer.parseInt(args[i]), args[i+1]);
				current=current.next;
			}
			current.next= new myList(Integer.parseInt(args[i]), "$");
				
			//for debugging
//			System.out.println("1===============");
//			list.printList();
//			System.out.println("1===============");
				
			//for * / %
			//check from the beginning of the list
			//calculate all the *, /, % partially 
			//then shrink the list in current position by one.
			current=list;		
			while(current.next!=null){   
				if(current.s.compareTo("*")==0){
					current.n=current.n*current.next.n;
					current.s=current.next.s;
					if(current.next.s.compareTo("$")!=0){
						current.next=current.next.next;
					}
					else{
						current.next=null;
					}
				}
				else if(current.s.compareTo("/")==0){
					current.n=current.n/current.next.n;
					current.s=current.next.s;
					if(current.next.s.compareTo("$")!=0){
						current.next=current.next.next;
					}
					else{
						current.next=null;
					}
				}
				else if(current.s.compareTo("%")==0){
					current.n=current.n%current.next.n;
					current.s=current.next.s;
					if(current.next.s.compareTo("$")!=0){
						current.next=current.next.next;
					}
					else{
						current.next=null;
					}
				}
				else if(current.s.compareTo("+")==0){
					current=current.next;
				}
				else if(current.s.compareTo("-")==0){
					current=current.next;
				}
						
			}
					
			//for + and -, and now the list will only remain + and - operations.
			//check from the beginning of the list
			//calculate the answer, then shrink the list in current position by one.
			current=list;
			while(current.next!=null){
				if(current.s.compareTo("+")==0){
					current.n=current.n+current.next.n;
					current.s=current.next.s;	
				}
				else if(current.s.compareTo("-")==0){
					current.n=current.n-current.next.n;
					current.s=current.next.s;
				}
						
				if(current.next.s.compareTo("$")!=0){
					current.next=current.next.next;
				}
				else{
					current.next=null;
				}
			}

			System.out.println(current.n);	
		}
		catch(ArithmeticException ex){
			System.out.println("cannot divide by zero.");
			System.exit(1);
		}

	}

}

//custom exceptions
class NotANumberException2 extends IllegalArgumentException{

}

class IllegalOperationException2 extends IllegalArgumentException{
	
}

class NotEnoughNumbersException2 extends IllegalArgumentException{
	
}

//linked list for holding long expression
class myList{
	public String s;
	public int n;
	public myList next;
	
	myList(){
		n=0;
		s="$";
		next=null;
	}
	
	myList(int n, String s){
		this.n=n;
		this.s=s;
		next=null;
	}
	
	//print out the list
	public void printList(){
		myList temp=this;
		while(temp!=null){
			System.out.println(temp.n+ "|"+temp.s);
			temp=temp.next;
		}
	}
}





