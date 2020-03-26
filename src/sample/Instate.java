/**
 *This class implements the in-state student case and it extends Student
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public class Instate extends Student {
    private int funds;

	/**
	 * the constructor for instate student
	 * @param fname
	 * @param lname
	 * @param credit
	 * @param funds
	 */
	public Instate(String fname, String lname, int credit, int funds) {
    	super(fname, lname, credit);
    	this.funds = funds;
    }
    /**
     * Tuition calculator for instate student
     * @return tuition due
     */
    public int tuitionDue() {
    	int perCreditPrice = 433;
    	int partTimeCredits = 12;
    	int partTimeFee = 846;
    	int fullTimeFee = 1441;
    	int maxCredits = 15;
    	int tuition = 0;
    	int ccredit = 0;
    	
    	if (credit > maxCredits) {
    		ccredit = maxCredits;
    	}
    	else {
    		ccredit = credit;
    	}
    	
    	if (ccredit >= partTimeCredits && funds != 0) {
    		tuition = perCreditPrice*ccredit - funds;
    	}
    	else {
    		tuition = perCreditPrice*ccredit;
    	}
    	if (ccredit < partTimeCredits) {
    		tuition += partTimeFee;
    	}
    	else {
    		tuition += fullTimeFee;
    	}
    	return tuition;
    }

	/**
	 * string representation of instate student
	 * @return string
	 */
	public String toString() {
    	return super.toString()+" the number of funds are: "+funds;
    }

	//test bed main
	public static void main(String[] args) {
    	String firstName = "John";
    	String lastName = "Man";
    	int creds = 18;
    	int funding = 180;

    	//testing constructor
    	Student johny = new Instate(firstName,lastName,creds,funding);
		//testing toString method
		System.out.println(johny.toString());
		//testing tuitionDue
		System.out.println(johny.tuitionDue());

		String firstName2 = "John";
		String lastName2 = "Lamb";
		int creds2 = 9;
		int funding2 = 100;

		Student johny2 = new Instate(firstName2,lastName2,creds2,funding2);
		//testing tuitionDue
		System.out.println(johny2.tuitionDue());
		//testing compareTo
		System.out.println(johny.compareTo(johny2));
    }
}

