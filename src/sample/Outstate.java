/**
 * This class implements the out of state student case and it extends Student
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public class Outstate extends Student {
    private boolean tristate;

    /**
     * constructor for Outstate Student
     * @param fname
     * @param lname
     * @param credit
     * @param tristate
     */
    public Outstate(String fname, String lname,int credit, boolean tristate){
        super(fname,lname,credit);
        this.tristate = tristate;
    }

    /**
     * Tuition calculator for outstate student
     * @return tuition due
     */
    public int tuitionDue(){
        int perCreditPrice = 756;
        int partTimeCredits = 12;
        int partTimeFee = 846;
        int fullTimeFee = 1441;
        int triStateDiscount = 200;
        int maxCredits = 15;
        int tuition = 0;
        int ccredit = 0;

        if(credit > maxCredits){
            ccredit = maxCredits;
        }
        else{
            ccredit = credit;
        }

        if(tristate && credit >= partTimeCredits){
            tuition = perCreditPrice*ccredit - triStateDiscount*ccredit;
        }
        else{
            tuition = perCreditPrice*ccredit;
        }

        if(ccredit<partTimeCredits){
            tuition += partTimeFee;
        }
        else{
            tuition += fullTimeFee;
        }

        return tuition;
    }

    /**
     * override tostring method in Student
     * @return string representation of a student
     */
    public String toString(){
        if(tristate){
            return super.toString() + " is a tristate student.";
        }
        else{
            return super.toString() + " is not a tristate student.";
        }

    }

    public static void main(String[] args){
        String firstName = "John";
        String lastName = "Man";
        int creds = 18;
        boolean tri = true;

        //testing constructor
        Student johny = new Outstate(firstName,lastName,creds,tri);
        //testing toString method
        System.out.println(johny.toString());
        //testing tuitionDue
        System.out.println(johny.tuitionDue());

        String firstName2 = "John";
        String lastName2 = "Lamb";
        int creds2 = 9;
        boolean tri2 = false;

        Student johny2 = new Outstate(firstName2,lastName2,creds2,tri2);
        //testing tuitionDue
        System.out.println(johny2.tuitionDue());
        //testing compareTo
        System.out.println(johny.compareTo(johny2));
    }
}
