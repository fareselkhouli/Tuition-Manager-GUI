import java.util.Scanner;

/**
 * this is the interface class that handles the inputs and outputs of the program
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public class TuitionManager {
	Scanner stdin;
	StudentList cs213 = new StudentList();

	/**
	 * run method to drive input/output
	 */
	 public void run()
	   {
	      stdin = new Scanner(System.in);
	      boolean done = false;
	      while ( !done )
	      {
	         String command = stdin.next();
	         char ccommand=command.charAt(0);
	         switch (ccommand)  
	         {   
	            case 'I': add('I');
			      break; 
	            case 'O': add('O');
	              break;
	            case 'N': add('N');
	              break;
	            case 'R': remove();
	              break;
	            case 'P': print();
	              break;
	            case 'Q': 
	            System.out.println("Program terminated");
	            done = true;
	            break;
	            default: //deal with bad command here 
	            System.out.println("Command"+"'"+command+"'"+"not supported!");		
	         }  
	      }
	   }

	/**
	 * calls the add method in StudentList
 	 * @param studenttype
	 */
	public void add(char studenttype) {
	/**
	 * If the command is Instate student
	 * check the fund.
	 */
	String fname = stdin.next();
	String lname = stdin.next();
	int credit = stdin.nextInt();
	if (credit <= 0) {
		System.out.println(credit + " is not a vaild credit!");
		return;
	}
	if (studenttype == 'I') {
		int fund = stdin.nextInt();
		Student s = new Instate(fname, lname, credit,fund);
		if (cs213.contains(s)) {
			System.out.println("Student is already in!");
		}
		cs213.add(new Instate(fname,lname,credit,fund));
		return;
	}
	/**
	 * if the command is outstate student
	 * check the tristate
	 */
	if (studenttype == 'O') {
		boolean tristate = false;
		String tri = stdin.next();
		if(tri.equals("T")){
			tristate = true;
		}
		Student s = new Outstate(fname,lname,credit,tristate);
		if(cs213.contains(s)) {
			System.out.println("Student is already in!");
		}
		cs213.add(new Outstate(fname,lname,credit,tristate));
		return;
	}
	/**
	 * if the command is a international student
	 * check the exchange
	 * check the credit is smaller than 9
	 */
	if (studenttype == 'N') {
		if (credit < 9) {
			System.out.println(credit+" is not a valid credit!");
			return;
		}
		String ex = stdin.next();
		boolean exchange = false;
		if(ex.equals("T")){
			exchange = true;
		}
		Student s = new International(fname,lname,credit,exchange);
		if(cs213.contains(s)) {
			System.out.println("Student is already in!");
		}
		cs213.add(new International(fname,lname,credit,exchange));
		return;
	}
	}

	/**
	 * if the command is remove the student.
	 */
	public void remove() {
	String fname = stdin.next();
	String lname = stdin.next();
	Student s = new Instate(fname,lname,1,1); //temporary Instate object to allow us to remove

	boolean successfullyRemoved = cs213.remove(s);
	if (!successfullyRemoved) {
		System.out.println(fname + " " +  lname + " is not a student!");
		}
		else {
		System.out.println(fname + " " +  lname + " has been removed!");
		}
		return;
	}

	/**
	 * the command is to print the whole chart out.
	 */
	public void print() {
		if (cs213.isEmpty()) {
			System.out.println("List is empty!");
			return;
		}
		else {
			cs213.print();
		}
		return;
		}
	}