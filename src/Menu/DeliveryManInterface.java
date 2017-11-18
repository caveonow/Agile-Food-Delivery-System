package Menu;
/**
 *
 * @author Oon Bing Jie
 */
import Menu.Staff;

public interface DeliveryManInterface <T> {
    public void addStaff(T data); //the method of add new staff in the staff list 
    public T[] getAllStaff(); // the method to get all staff who register
    public T[] getAssginedStaff(); // the method to get all staff who had assign to work or completed the task
    public T assignStaffWork(int task); // the method to update the staff status who get assign to work
    public T completeStaffWork(T data); // the method to update the staff status who had completed the task
    public T rejectWork(T data); // the method to reject the task 
    public void addAssignmentReport(T data); // the method to add the staff details in report list
    public int getNumberOfEntries(); // the method to get the number of staff entries
    public int getNumberOfAssigned(); // the method to get the number of staff assigned task
    public void clear(); // the method to clear the staff list and report list
    public boolean isEmpty(); // the method to identify the staff list is empty or not
}
