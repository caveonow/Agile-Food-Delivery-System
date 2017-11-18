package Menu;
/**
 *
 * @author Oon Bing Jie
 */
import java.util.Date;

public class Staff {

    private String id; //Staff id
    private String name; // Staff name
    private String contactNo; // Staff contact number
    private String gender; // Staff gender
    private String ic; // Staff ic
    private String status; // Staff task status
    private String address; // Staff address
    private String assignTask; // Staff assigned task
    private String completeTask; // Staff complete task
    private String assignArea; // Staff assigned area
    private String currentDate; // Current date

    public Staff(String name, String contactNo, String gender, String ic, String status, String address) { //for register new staff details
        this.name = name;
        this.contactNo = contactNo;
        this.gender = gender;
        this.ic = ic;
        this.status = status;
        this.address = address;
    }

//    public Staff(String name, String status, String assignRequestTask, String completeTask, String assignArea, String currentDate) { 
//    // for assgined task staff details and completed task staff details
//        this.name = name;
//        this.status = status;
//        this.requestTask = requestTask;
//        this.completeTask = completeTask;
//        this.assignArea = assignArea;
//        this.currentDate = currentDate;
//    }
    
//    public Staff(String name, String status, String assignRequestTask) { // for reject staff
//        this.name = name;
//        this.status = status;
//        this.requestTask = requestTask;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return currentDate;
    }

    public void setDate(String currentDate) {
        this.currentDate = currentDate;
    }

//    public int getAssignTask() {
//        return assignTask;
//    }
//
//    public void setAssignTask(int assignTask) {
//        this.assignTask = assignTask;
//    }

    public String getAssignFood() {
        return assignArea;
    }

    public void setAssignFood(String assignArea) {
        this.assignArea = assignArea;
    }

    public String getCompleteTask() {
        return completeTask;
    }

    public void setCompleteTask(String completeTask) {
        this.completeTask = completeTask;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    
    
//
//    public int[] getRequestTask() { // get the selected request to do task
//        int[] rt = new int[3];
//        for (int i = 0; i < requestTask.length; i++) {
//            if (requestTask[i] != 0) {
//                rt[i] = requestTask[i];
//            }
//        }
//        return rt;
//    }
//
//    public int getTotalTaskLevel() { // get the total level of task
//        int totalLevel = 0;
//        for (int i = 0; i < requestTask.length; i++) {
//            if (requestTask[i] <= 3) {
//                totalLevel += requestTask[i];
//            }
//        }
//        return totalLevel;
//    }
//
//    public void setRequestTask(int[] requestTask) {
//        this.requestTask = requestTask;
//    }
//
//    public String getRequestTaskString() { // get the string convert from staff request task
//        String StrrequestTask = "";
//        for (int j = 0; j < getRequestTask().length; j++) {
//            if (getRequestTask()[j] != 0) {
//                if (getRequestTask()[j] == 1) {
//                    StrrequestTask += "T" + getRequestTask()[j];
//                } else {
//                    StrrequestTask += ",T" + getRequestTask()[j];
//                }
//            }
//        }
//        return StrrequestTask;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
