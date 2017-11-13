package Menu;
/**
 *
 * @author Oon Bing Jie
 */
import Menu.Staff;

public class WorkloadAssignment<T> implements WorkloadAssignmentInterface<T> {

    private Node StaffFirstNode; // reference to first node of staff
    private Node ReportFirstNode;// reference to first node of report
    private int numberOfEntries;// number of entries in list
    private int numberOfAssigned;// number of staff have assigned task  in list

    public WorkloadAssignment() {
        clear();
    }

    @Override
    public void addStaff(T data) {
        Node newNode = new Node(data);	// create the new node
        Node nodeBefore = null;	//  to reference the node before the current node
        Node currentNode = StaffFirstNode;//  to reference the current node

        if (StaffFirstNode != null) {
            Staff existedStaff = (Staff) currentNode.data;
            Staff newStaff = (Staff) newNode.data;

            while (currentNode != null && newStaff.getTotalTaskLevel() >= existedStaff.getTotalTaskLevel()) {
                nodeBefore = currentNode;
                currentNode = currentNode.next;
                if (currentNode != null) {
                    existedStaff = (Staff) currentNode.data;
                }
            }
        }
        if (isEmpty() || (nodeBefore == null)) { // CASE 1: add at beginning if (isEmpty() || (nodeBefore == null)) {
            newNode.next = StaffFirstNode;
            StaffFirstNode = newNode;
        } else {	// CASE 2: add in the middle or at the end, i.e. after nodeBefore
            newNode.next = currentNode;
            nodeBefore.next = newNode;
        }
        numberOfEntries++;
    }

    @Override
    public T assignStaffWork(int task) {

        Node currentNode = StaffFirstNode;// For linked list traversal: to reference the current node

        Staff existedStaff = (Staff) currentNode.data;

        while (currentNode != null && existedStaff.getTotalTaskLevel() < (task+1)) {// find the node with the entry data
            currentNode = currentNode.next;
            if (currentNode != null) {
                existedStaff = (Staff) currentNode.data;
            }
        }
        while (currentNode != null && !existedStaff.getStatus().equals("Pending")) {
            currentNode = currentNode.next;
            if (currentNode != null) {
                existedStaff = (Staff) currentNode.data;
            }
        }
        if (currentNode == null) {
            return null;
        } else {
            existedStaff.setStatus("Working");
        }
        return (T) existedStaff;
    }

    @Override
    public T completeStaffWork(T data) {
        Node newNode = new Node(data);	// create the new node
        Node currentNode = StaffFirstNode;// For linked list traversal: to reference the current node

        Staff existedStaff = (Staff) currentNode.data;
        Staff newStaff = (Staff) newNode.data;

        while (currentNode != null && !newStaff.getName().equals(existedStaff.getName())) { // find the node with the entry data
            currentNode = currentNode.next;
            if (currentNode != null) {
                existedStaff = (Staff) currentNode.data;
            }
        }
        existedStaff.setStatus("Complete");
        return (T) existedStaff;
    }

    @Override
    public T rejectWork(T data) {
        Node newNode = new Node(data);	// create the new node
        Node currentNode = StaffFirstNode;// For linked list traversal: to reference the current node
        Node nodeBefore = currentNode;//to reference the node before the current node

        Staff existedStaff = (Staff) currentNode.data;
        Staff newStaff = (Staff) newNode.data;
        
        if (currentNode.next == null || newStaff.getName().equals(existedStaff.getName())) { //Case 1: remove the first node if only one node inside
            StaffFirstNode = StaffFirstNode.next;
        } else { //Case 2: remove on middle or end
            while (currentNode != null && !newStaff.getName().equals(existedStaff.getName())) {
                nodeBefore = currentNode;
                currentNode = currentNode.next;
                if (currentNode != null) {
                    existedStaff = (Staff) currentNode.data;
                }
            }
            nodeBefore.next = currentNode.next;
        }
        numberOfEntries--;
        return (T) existedStaff;
    }

    @Override
    public void addAssignmentReport(T data) {
        Node newNode = new Node(data);	// create the new node
        Node currentNode = ReportFirstNode;	// traverse linked list with p pointing to the current node
        Node nodeBefore = currentNode;//to reference the node before the current node

        if (ReportFirstNode == null) //Case 1: if empty list or the new staff is same with first node
        {
            newNode.next = ReportFirstNode;
            ReportFirstNode = newNode;
            numberOfAssigned++;
        } else {                        // Case 2: the node is not empty
            Staff existedStaff = (Staff) currentNode.data;
            Staff newStaff = (Staff) newNode.data;
            if (!newStaff.getName().equals(existedStaff.getName())) {//Case 3: the new node compare the first note
                while (currentNode != null && !newStaff.getName().equals(existedStaff.getName())) { // compare all other node 
                    if (currentNode.next != null) { //check wherether is last node or not
                        nodeBefore = currentNode;
                        currentNode = currentNode.next;
                        existedStaff = (Staff) currentNode.data;
                    } else {//if it is last node, do the following thing to move to next node
                        currentNode.next = newNode;
                        currentNode = currentNode.next;
                        existedStaff = (Staff) currentNode.data;
                    }
                }
                if (newStaff.getName().equals(existedStaff.getName())) {//After move to next node,if the staff is same with current node
                    currentNode.data = newNode.data;
                }
            } else {
                currentNode.data = newNode.data;
            }
        }
    }

    @Override
    public T[] getAllStaff() {
        Node tempNode = StaffFirstNode;//reference to first node
        Staff[] newWorkers = new Staff[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++) {
            if (tempNode != null) {
                newWorkers[i] = (Staff) tempNode.data;
                tempNode = tempNode.next;
            } else {
                newWorkers[i] = null;
            }
        }
        return (T[]) newWorkers;
    }

    @Override
    public T[] getAssginedStaff() {
        Node tempNode = ReportFirstNode;//reference to first node
        Staff[] newWorkers = new Staff[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++) {
            if (tempNode != null) {
                newWorkers[i] = (Staff) tempNode.data;
                tempNode = tempNode.next;
            } else {
                newWorkers[i] = null;
            }
        }
        return (T[]) newWorkers;
    }
    
    
    
    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public int getNumberOfAssigned() {
        return numberOfAssigned;
    }

    @Override
    public final void clear() {
        StaffFirstNode = null;
        ReportFirstNode = null;
        numberOfEntries = 0;
        numberOfAssigned = 0;
    }
    
    @Override
    public boolean isEmpty() {
        boolean result;

        result = numberOfEntries == 0;

        return result;
    }

    @Override
    public String toString() {
        String outputStr = "No  Name         Task Status    Assigned Task     Assigned Area     Assign Date and Time\n";
        Node currentNode = ReportFirstNode;//reference to first node
        int NoOfEntry = 1;

        while (currentNode != null) {
            Staff staffReport = (Staff) currentNode.data;
            outputStr += NoOfEntry + "     " + staffReport.getName() + "       " + staffReport.getStatus() + "       "
                    + staffReport.getCompleteTask()+ "           " + staffReport.getAssignFood() + "              " + staffReport.getDate() + "\n";
            currentNode = currentNode.next;
            if (currentNode != null) {
                staffReport = (Staff) currentNode.data;
            }
            NoOfEntry++;
        }
        return outputStr;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
