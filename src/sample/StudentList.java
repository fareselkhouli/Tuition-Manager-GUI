/**
 * This class holds the growable student list
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public class StudentList {
    private Student[] students;
    private int numStudents;
    private int initialSize = 4;
    private int NOT_FOUND = -1;

    /**
     * constructor for StudentList
     */
    public StudentList(){
        students = new Student[initialSize];
        numStudents = 0;
    }

    /**
     * doubles array when threshold is reached
     */
    private void grow(){
        int doubler = 2;
        Student[] oldArray = students;
        students = new Student[oldArray.length * doubler];

        //copy over old elements
        for(int i = 0; i < oldArray.length; ++i){
            students[i] = oldArray[i];
        }
    }

    /**
     * adds a student to the array of students
     * @param s student to be added
     */
    public void add(Student s){
        if(numStudents == students.length){
            grow();
        }
        students[numStudents] = s;
        numStudents++;
    }

    /**
     * search for a student in the student list
     * @param s student to be found
     * @return integer index of the student. -1 if the student is not in the array
     */
    private int find(Student s){
        int i = 0;

        if(numStudents == 0){
            return NOT_FOUND;
        }
        while(i < numStudents) {
            if (students[i].compareTo(s) == 0) {
                return i;
            }
            i++;
        }
        return NOT_FOUND;
    }

    /**
     * this method removes a student from the student list
     * @param s student to be removed
     * @return true if the student is successfully removed, false if the student is not removed
     */
    public boolean remove(Student s){
        int memberIndex =find(s);
        if (memberIndex == NOT_FOUND) {
            return false;
        }
        students[memberIndex] = students[numStudents-1];
        students[numStudents-1] = null;
        numStudents--;
        return true;
    }


    /**
     * This method checks if the student is in the list already
     * @param s student
     * @return true if student is in the list, false if he is not
     */
    public boolean contains(Student s)
    {
        if(numStudents == 0){
            return false;
        }
        int index = find(s);
        if(index == -1) {
            return false;
        }
        return true;
    }

    /**
     * checks if the list is empty
     * @return true if list is empty false if list is not empty
     */
    public boolean isEmpty(){
        if(numStudents == 0){
            return true;
        }
        return false;
    }
    /**
     * This method prints out all the students in the student list
     */
    public void print(){
        for(int i = 0; i < numStudents; ++i){
            System.out.println(students[i].toString() + " tuition due: $" + students[i].tuitionDue());
        }
    }
}
