//CISC3150
//Xin Guan
//11/10/15


import java.util.*;

public class HW6Calculator2{
	
	public static void main(String[] args){
		
//		int n1, n2;
//		String s1;
		myList list;
		myList current;
		myList temp;
		
		
		//check the length of the input args
		//if the length is even, throw a exception.
		try{
			if((args.length%2)!=1){
				throw new NotEnoughNumbersException2();
			}
		}
		catch(NotEnoughNumbersException2 ex){
			System.out.println("please enter the second number.");
			System.exit(1);
		}
		
		//check the even args are all numbers or not
		//if not, throw a exception.
		try{
			
			for(int i=0; i<args.length; i=i+2){
				
				for(int j=0; j<args[i].length(); j++){
					if(args[i].charAt(j)<'0' || args[i].charAt(j)>'9'){
						throw new NotANumberException2();
					}
				}
				
				
				
			}
			
//			for(int i=0; i<args[0].length(); i++){
//				if(args[0].charAt(i)<'0' || args[0].charAt(i)>'9'){
//					throw new NotANumberException();
//				}
//			}
//			
//			for(int i=0; i<args[2].length(); i++){
//				if(args[2].charAt(i)<'0' || args[2].charAt(i)>'9'){
//					throw new NotANumberException();
//				}
//			}
			
		}
		catch(NotANumberException2 ex){
			System.out.println("not a number, please re-enter your number.");
			System.exit(1);
		}
		
		
		//check the odd args are operation or not
		//if not, throw a exception.
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
//			if(args[1].length()>1){
//				throw new IllegalOperationException();
//			}
//			
//			if(args[1].charAt(0)=='+' ||
//					args[1].charAt(0)=='-' ||
//					args[1].charAt(0)=='/' ||
//					args[1].charAt(0)=='*' ||
//					args[1].charAt(0)=='%'){
//				
//			}
//			else{
//				throw new IllegalOperationException();
//			}
		}
		catch(IllegalOperationException2 ex){
			System.out.println("the operation is not correct.");
			System.exit(1);
		}
		
		//now here are all the numbers in even args with operations in odd args
		//calculate them.
		try{
//			n1=Integer.parseInt(args[0]);
//			s1=args[1];
//			n2=Integer.parseInt(args[2]);
			
			//=============
			System.out.println(args.length);
			
			list = new myList(Integer.parseInt(args[0]), args[1]);
			current=list;
			int i;
			for(i=2; i<args.length-1; i=i+2){
				//===============
				System.out.println(i + "   " + (i+1));
				current.next= new myList(Integer.parseInt(args[i]), args[i+1]);
				System.out.println(current.n + "|"+current.s);
				System.out.println(current.next.n + "|"+current.next.s);
				current=current.next;
			}
			current= new myList(Integer.parseInt(args[i]), "$");
			System.out.println(current.n + "|"+current.s);
			//System.out.println(current.next.n + "|"+current.next.s);
			
			//===============
			
			System.out.println("1===============");
			list.printList();
			System.out.println("1===============");
			
			current=list;
			//===============
			System.out.println(current.s);
			System.out.println(current.s.compareTo("$")!=0);
			current=current.next;
			System.out.println(current.n);
			
			//maybe write a method to check if there any  */% left?
			//if yes, then run over the while loop
//			while(current.s.compareTo("$")!=0){   //sth wrong here?
//				if(current.s.compareTo("*")==0){
//					current.n=current.n*current.next.n;
//					current.s=current.next.s;
//					//current.next=current.next.next;
//				}
//				else if(current.s.compareTo("/")==0){
//					current.n=current.n/current.next.n;
//					current.s=current.next.s;
//					//current.next=current.next.next;
//				}
//				else if(current.s.compareTo("%")==0){
//					current.n=current.n%current.next.n;
//					current.s=current.next.s;
//					//current.next=current.next.next;
//				}
//				
//				current = current.next;
//			}
			
			current=list;
			while(current!=null){
				if(current.s.compareTo("+")==0){
					current.n=current.n+current.next.n;
					current.s=current.next.s;
					current.next=current.next.next;
				}
				else if(current.s.compareTo("-")==0){
					current.n=current.n-current.next.n;
					current.s=current.next.s;
					current.next=current.next.next;
				}
				current = current.next;
			}
			
			System.out.println("0===============");
			System.out.println(list.n);
			
			
		}
		catch(ArithmeticException ex){
			System.out.println("cannot divide by zero.");
			System.exit(1);
		}

	}

}

class NotANumberException2 extends IllegalArgumentException{

}

class IllegalOperationException2 extends IllegalArgumentException{
	
}

class NotEnoughNumbersException2 extends IllegalArgumentException{
	
}

//linked list for solving polynomial
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
	
	public void printList(){
		myList temp=this;
		while(temp!=null){
			System.out.println(temp.n+ "|"+temp.s);
			temp=temp.next;
		}
		
		
	}
}





