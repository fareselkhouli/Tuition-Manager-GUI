/**
 * This is the abstract class that represents a student
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public abstract class Student implements Comparable{
    private String fname;
    private String lname;
    protected int credit;

    /**
     * constructor
     * @param fname
     * @param lname
     * @param credit
     */
    public Student(String fname, String lname, int credit){
        this.fname = fname;
        this.lname = lname;
        this.credit = credit;
    }

    /**
     * compares two students to each other
     * @param obj student to be compared
     * @return -1 if students first and last name are less than obj
     *          1 if students first and last name are greater than obj
     *          0 if students first and last name are equal
     */
    public int compareTo(Object obj){
        Student st = (Student) obj;
        int EQUAL = 0;

        if(this.fname.equals(st.fname) && this.lname.equals(st.lname)){
            return EQUAL;
        }

        if(this.fname.equals(st.fname))
            return lname.compareToIgnoreCase(st.lname);

        return fname.compareToIgnoreCase(st.fname);
    }

    /**
     * overrides toString method
     * @return string representation of a student
     */
    @Override
    public String toString(){
        return fname + " " + lname + " has " + credit + " credits";
    }

    public abstract int tuitionDue();
}
