/**
 * This class implements the international student case and it extends Student
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public class International extends Student {
    private boolean exchange;
    
    public International(String fname, String lname, int credit, boolean exchange) {
    	super(fname,lname,credit);
    	this.exchange = exchange;
    }
    
    /**
     * Tuition calculator for International student
     * @return tuition due
     */
    
    public int tuitionDue() {
    	int perCreditPrice = 945;
    	int partTimeCredits = 12;
    	int partTimeFee = 846;
    	int fullTimeFee = 1441;
    	int maxCredits = 15;
    	int tuition = 0;
    	int ccredit = 0;
    	int intFee = 350; 
    	if (credit > maxCredits) {
    		ccredit = maxCredits;
    	}
    	else {
    		ccredit = credit;
    	}
    	if (exchange) {
    		tuition = fullTimeFee + intFee;
    		return tuition;
    	}
    	else {
    		tuition = perCreditPrice*ccredit+intFee;
    	}
    	
    	if(ccredit<partTimeCredits) {
    		tuition += partTimeFee;
    	}
    	else {
    		tuition += fullTimeFee;
    	}
    	return tuition;
    }
    public String toString() {
    	if (exchange) {
    		return super.toString()+" is an exchange student.";
    	}
    	else{
    		return super.toString()+" is not an exchange student.";
    	}
    }

    //test bed main
    public static void main(String[] args) {
		String firstName = "John";
		String lastName = "Man";
		int creds = 18;
		boolean exch = true;

		//testing constructor
		Student johny = new International(firstName,lastName,creds,exch);
		//testing toString method
		System.out.println(johny.toString());
		//testing tuitionDue
		System.out.println(johny.tuitionDue());

		String firstName2 = "John";
		String lastName2 = "Lamb";
		int creds2 = 9;
		boolean exch2 = false;

		Student johny2 = new International(firstName2,lastName2,creds2,exch2);
		//testing tuitionDue
		System.out.println(johny2.tuitionDue());
		//testing compareTo
		System.out.println(johny.compareTo(johny2));
    }
}
