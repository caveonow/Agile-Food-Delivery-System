package Menu;

/**
 *
 * @author Oon Bing Jie
 */
import Menu.Staff;
import Menu.WorkloadAssignment;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import Menu.WorkloadAssignmentInterface;

public class WorkloadAssignmentDriver extends JFrame {

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//    private ImageIcon logoImage = new ImageIcon(getClass().getResource("/Menu/logo.png"));
//    private ImageIcon backImage = new ImageIcon(getClass().getResource("/icon/backIcon.png"));
//    private ImageIcon foodTabImage = new ImageIcon(getClass().getResource("/icon/foodTabIcon.png"));
//    private ImageIcon victimTabImage = new ImageIcon(getClass().getResource("/icon/victimTabIcon.png"));
//    private ImageIcon patientTabImage = new ImageIcon(getClass().getResource("/icon/patientTabIcon.png"));
//    private ImageIcon staffTabImage = new ImageIcon(getClass().getResource("/icon/staffTabIcon.png"));
//    private ImageIcon addImage = new ImageIcon(getClass().getResource("/icon/addIcon.png"));
//    private ImageIcon clearImage = new ImageIcon(getClass().getResource("/icon/clearIcon.png"));

    JLabel jlbTitle = new JLabel("Workload Assignment                                                               ");
    JButton jbtBack = new JButton("Back to Main Menu");

    //Staff Components
    static WorkloadAssignmentInterface<Staff> stafflist = new WorkloadAssignment<>();
    //Register Page
    //JLabel
    private JLabel jlbStaffName = new JLabel("Name :");
    private JLabel jlbStaffContactNo = new JLabel("Contact No. :");
    private JLabel jlbStaffGender = new JLabel("Gender :");
    private JLabel jlbStaffAge = new JLabel("Age :");
    private JLabel jlbStaffStatus = new JLabel("Task Status :");
    private JLabel jlbStaffRequestTask = new JLabel("Request Area Can Do :");
    private JLabel jlbAreaAssign = new JLabel("Area Assign :");
    private JLabel jlbNoOfStaffAssign = new JLabel("Number Of Staff Assign :");
    //JTextField
    private JTextField jtfStaffName = new JTextField("");
    private JTextField jtfStaffContactNo = new JTextField("", 11);
    private JTextField jtfStaffStatus = new JTextField("Pending");
    //JModel
    private DefaultComboBoxModel ageModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel statusModel = new DefaultComboBoxModel();
    //JCombobox
    private JComboBox jcbStaffAge = new JComboBox(ageModel);
    //JCheckBox
    private JCheckBox jcbRequestTask1 = new JCheckBox("Selangor(T1)");
    private JCheckBox jcbRequestTask2 = new JCheckBox("Kuala Lumpur(T2)");
    private JCheckBox jcbRequestTask3 = new JCheckBox("Seremban(T3)");
    //JButtonGroup
    private ButtonGroup bgGender = new ButtonGroup();
    //JRadioButton
    private JRadioButton jrbMale = new JRadioButton("Male");
    private JRadioButton jrbFemale = new JRadioButton("Female");
    //JButton  
    private JButton jbtRegister = new JButton("Register");
    private JButton jbtClear = new JButton("Clear");
    //JTable1
    Object[] columns = {"Staff Name", "Contact No", "Gender", "Age", "Request Area"};
    Object[] row = new Object[6];
    DefaultTableModel model = new DefaultTableModel();
    JTable staffTable = new JTable();
    JScrollPane staffT = new JScrollPane(staffTable);

    //Workload Assignment Page
    //JLabel
    private JLabel jlbAssignStaffName = new JLabel("Name :");
    private JLabel jlbAssignStaffStatus = new JLabel("Task Status :");
    private JLabel jlbAssignStaffRequestTask = new JLabel("Request Area Can Do :");
//    private JLabel jlbAssignTask = new JLabel("Assign Task :");
    private JLabel jlbAssignFood = new JLabel("Assign Food :");
    //JTextField
    private JTextField jtfAssignStaffName = new JTextField();
    private JTextField jtfAssignStaffStatus = new JTextField();
    private JTextField jtfAssignStaffRequestTask = new JTextField();
    //JModel
    private DefaultComboBoxModel taskModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel areaModel = new DefaultComboBoxModel();
    //JCombobox
    private JComboBox jcbAssignStaffTask = new JComboBox(taskModel);
    private JComboBox jcbAssignStaffArea = new JComboBox(areaModel);
    //JButton  
    private JButton jbtAssign = new JButton("Assign");
    private JButton jbtComplete = new JButton("Complete");
    private JButton jbtReject = new JButton("Reject");
    private JButton jbtGenerateReport = new JButton("Generate Report");
    //JTabel2
    Object[] columns2 = {"Staff Name", "Contact No", "Gender", "Age", "Status", "Delivery Area"};
    Object[] row2 = new Object[6];
    DefaultTableModel model2 = new DefaultTableModel();
    JTable staffTable2 = new JTable();
    JScrollPane staffT2 = new JScrollPane(staffTable2);
    //End of Staff Components

    public WorkloadAssignmentDriver() {

        Font TitleFont = new Font("sans-serif", Font.BOLD, 26);
        Font LabelFont = new Font("sans-serif", Font.BOLD, 13);
        Font btnFont = new Font("sans-serif", Font.BOLD, 15);
        Font tabFont = new Font("sans-serif", Font.BOLD, 15);
        Font jtfFont = new Font("sans-serif", Font.BOLD, 12);

        JTabbedPane tabbebPanel = new JTabbedPane();

        //Registration Panel module
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel titleFlowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        //End of registration Panel module

        //Staff Panel
        JPanel staffRegistrerMainPanel = new JPanel(new BorderLayout());
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) staffTable.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        model.setColumnIdentifiers(columns);
        staffTable.setModel(model);
        staffTable.setFont(LabelFont);
        staffTable.getTableHeader().setBackground(Color.getHSBColor(178, 34, 34));
        staffTable.getTableHeader().setFont(LabelFont);
        staffTable.setRowHeight(27);

        initializeAgeModel();
        jcbStaffAge.setSelectedItem(18);
        TitledBorder tb1 = new TitledBorder("Enter Staff Details");
        tb1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        TitledBorder tb2 = new TitledBorder("Staff Details Lists");
        tb2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel staffMainPanel = new JPanel(new BorderLayout());
        JPanel staffLeftPanel = new JPanel(new BorderLayout());
        JPanel staffRightPanel = new JPanel(new BorderLayout());
        JPanel staffFormPanel = new JPanel(new BorderLayout());
        JPanel staffFormSubPanel = new JPanel(new BorderLayout());
        JPanel staffFormSubSubPanel = new JPanel(new GridLayout(7, 2, 20, 30));
        JPanel staffGenderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        JPanel staffRequestTask = new JPanel(new GridLayout(3, 1));
        JPanel staffListPanel = new JPanel(new BorderLayout());
        JPanel staffListSubPanel = new JPanel(new BorderLayout());
        JPanel staffListSubSubPanel = new JPanel(new BorderLayout());
        //End of Staff Panel

        //Staff Panel
        //Staff Form
        staffRegistrerMainPanel.add(staffLeftPanel, BorderLayout.WEST);
        staffLeftPanel.add(staffFormPanel);
        staffFormPanel.add(staffFormSubPanel);
        staffFormSubPanel.setBackground(new Color(248, 248, 248));
        staffFormSubPanel.add(staffFormSubSubPanel);
        staffFormPanel.setBorder(new EmptyBorder(20, 13, 20, 20));
        staffFormPanel.setBackground(new Color(248, 248, 248));
        staffLeftPanel.setPreferredSize(new Dimension(350, 0));
        staffFormSubPanel.setBorder(tb1);
        staffFormSubPanel.setBackground(new Color(248, 248, 248));
        staffFormSubSubPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        staffFormSubSubPanel.setBackground(new Color(248, 248, 248));
        staffFormSubSubPanel.add(jlbStaffName);
        jlbStaffName.setFont(LabelFont);
        staffFormSubSubPanel.add(jtfStaffName);
        jtfStaffName.setFont(jtfFont);
        jtfStaffName.setBackground(Color.white);
        staffFormSubSubPanel.add(jlbStaffContactNo);
        jlbStaffContactNo.setFont(LabelFont);
        staffFormSubSubPanel.add(jtfStaffContactNo);
        jtfStaffContactNo.setFont(jtfFont);
        jtfStaffContactNo.setBackground(Color.white);
        staffFormSubSubPanel.add(jlbStaffGender);
        jlbStaffGender.setFont(LabelFont);
        staffFormSubSubPanel.add(staffGenderPanel);
        staffGenderPanel.setBackground(new Color(248, 248, 248));
        bgGender.add(jrbMale);
        jrbMale.setBackground(new Color(248, 248, 248));
        bgGender.add(jrbFemale);
        jrbMale.setSelected(true);
        jrbFemale.setBackground(new Color(248, 248, 248));
        staffGenderPanel.add(jrbMale);
        staffGenderPanel.add(jrbFemale);
        jrbMale.setActionCommand("Male");
        jrbFemale.setActionCommand("Female");
        staffFormSubSubPanel.add(jlbStaffAge);
        jlbStaffAge.setFont(LabelFont);
        staffFormSubSubPanel.add(jcbStaffAge);
        staffFormSubSubPanel.add(jlbStaffStatus);
        jlbStaffAge.setFont(LabelFont);
        staffFormSubSubPanel.add(jtfStaffStatus);
        jtfStaffStatus.setFont(jtfFont);
        jtfStaffStatus.setBackground(Color.white);
        jtfStaffStatus.setEditable(false);
        staffFormSubSubPanel.add(jlbStaffRequestTask);
        jlbStaffAge.setFont(LabelFont);
        staffRequestTask.add(jcbRequestTask1);
        staffRequestTask.add(jcbRequestTask2);
        staffRequestTask.add(jcbRequestTask3);
        jcbRequestTask1.setSelected(true);
        jcbRequestTask1.setEnabled(false);
        staffFormSubSubPanel.add(staffRequestTask);

        staffFormSubSubPanel.add(jbtRegister).setFont(btnFont);
        jbtRegister.setVerticalAlignment(SwingConstants.CENTER);
        jbtRegister.setHorizontalAlignment(SwingConstants.CENTER);
        jbtRegister.setVerticalTextPosition(SwingConstants.CENTER);
        jbtRegister.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbtRegister.setBackground(Color.getHSBColor(178, 34, 34));
        jbtRegister.setFocusPainted(false);
        jbtRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

        staffFormSubSubPanel.add(jbtClear).setFont(btnFont);
        jbtClear.setVerticalAlignment(SwingConstants.CENTER);
        jbtClear.setHorizontalAlignment(SwingConstants.CENTER);
        jbtClear.setVerticalTextPosition(SwingConstants.CENTER);
        jbtClear.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbtClear.setBackground(Color.getHSBColor(178, 34, 34));
        jbtClear.setFocusPainted(false);
        jbtClear.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Staff List
        staffRegistrerMainPanel.add(staffRightPanel);
        staffRightPanel.add(staffListPanel);
        staffListPanel.setBackground(new Color(248, 248, 248));
        staffListPanel.setBorder(new EmptyBorder(60, 0, 60, 10));
        staffListPanel.add(staffListSubPanel);
        staffListSubPanel.setBackground(new Color(248, 248, 248));
        staffListSubPanel.setBorder(tb2);
        staffListSubPanel.add(staffListSubSubPanel);
        staffListSubSubPanel.setBorder(new EmptyBorder(20, 6, 30, 6));
        staffListSubSubPanel.setBackground(new Color(248, 248, 248));
        staffListSubSubPanel.add(staffT);
        //End of Staff List
        // End of Staff Form

        //Workload Assignment Panel
        JPanel taskAssignmentMainPanel = new JPanel(new BorderLayout());
        JPanel staffTopPanel = new JPanel(new BorderLayout());
        JPanel staffBottomPanel = new JPanel(new BorderLayout());
        JPanel staffAssignFormPanel = new JPanel(new BorderLayout());
        JPanel staffAssignFormSubPanel = new JPanel(new BorderLayout());
        JPanel staffAssignFormSubSubPanel = new JPanel(new GridLayout(5, 2, 20, 30));
        JPanel staffAssignButtonPanel = new JPanel(new BorderLayout());
        JPanel staffAssignButtonSubPanel = new JPanel(new BorderLayout());
        JPanel staffAssignButtonSubSubPanel = new JPanel(new GridLayout(5, 1, 20, 30));
        JPanel staffWorkListPanel = new JPanel(new BorderLayout());
        JPanel staffWorkListSubPanel = new JPanel(new BorderLayout());
        JPanel staffWorkListSubSubPanel = new JPanel(new BorderLayout());

        DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer) staffTable2.getDefaultRenderer(Object.class);
        renderer2.setHorizontalAlignment(SwingConstants.CENTER);
        model2.setColumnIdentifiers(columns2);
        staffTable2.setModel(model2);
        staffTable2.setFont(LabelFont);
        staffTable2.getTableHeader().setBackground(Color.getHSBColor(178, 34, 34));
        staffTable2.getTableHeader().setFont(LabelFont);
        staffTable2.setRowHeight(27);

        initializeTaskModel();
        initializeAreaModel();
        initializeStatusModel();
//        jcbAssignStaffTask.setSelectedItem(null);
        jcbAssignStaffArea.setSelectedItem(null);
        TitledBorder tb3 = new TitledBorder("Staff Work Lists");
        tb1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        TitledBorder tb4 = new TitledBorder("Assign Staff Details");
        tb2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        taskAssignmentMainPanel.add(staffTopPanel, BorderLayout.NORTH);
        staffTopPanel.add(staffWorkListPanel);
        staffWorkListPanel.setBackground(new Color(248, 248, 248));
        staffWorkListPanel.add(staffWorkListSubPanel);
        staffWorkListSubPanel.setBackground(new Color(248, 248, 248));
        staffWorkListSubPanel.setBorder(tb3);
        staffWorkListSubPanel.add(staffWorkListSubSubPanel);
        staffWorkListSubSubPanel.setBorder(new EmptyBorder(20, 6, 30, 6));
        staffWorkListSubSubPanel.setBackground(new Color(248, 248, 248));
        staffWorkListSubSubPanel.add(staffT2);
        staffWorkListSubSubPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        staffWorkListSubSubPanel.setPreferredSize(new Dimension(0, 200));

        taskAssignmentMainPanel.add(staffBottomPanel);
        staffBottomPanel.add(staffAssignFormPanel);
        staffAssignFormPanel.add(staffAssignFormSubPanel);
        staffAssignFormSubPanel.setBackground(new Color(248, 248, 248));
        staffAssignFormSubPanel.add(staffAssignFormSubSubPanel, BorderLayout.WEST);
        staffAssignFormPanel.setBorder(new EmptyBorder(20, 13, 20, 20));
        staffAssignFormPanel.setBackground(new Color(248, 248, 248));
        staffBottomPanel.setPreferredSize(new Dimension(0, 50));
        staffAssignFormSubPanel.setBorder(tb4);
        staffAssignFormSubPanel.setBackground(new Color(248, 248, 248));
        staffAssignFormSubSubPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        staffAssignFormSubSubPanel.setBackground(new Color(248, 248, 248));
        staffAssignFormSubSubPanel.add(jlbAssignStaffName);
        jlbAssignStaffName.setFont(LabelFont);
        staffAssignFormSubSubPanel.add(jtfAssignStaffName);
        jtfAssignStaffName.setFont(jtfFont);
        jtfAssignStaffName.setBackground(Color.white);
        staffAssignFormSubSubPanel.add(jlbAssignStaffStatus);
        jlbAssignStaffStatus.setFont(LabelFont);
        staffAssignFormSubSubPanel.add(jtfAssignStaffStatus);
        jtfAssignStaffStatus.setFont(jtfFont);
        jtfAssignStaffStatus.setBackground(Color.white);
        jtfAssignStaffStatus.setEditable(false);
        staffAssignFormSubSubPanel.add(jlbAssignStaffRequestTask);
        jlbAssignStaffRequestTask.setFont(LabelFont);
        staffAssignFormSubSubPanel.add(jtfAssignStaffRequestTask);
        jtfAssignStaffRequestTask.setFont(jtfFont);
        jtfAssignStaffRequestTask.setBackground(Color.white);
        jtfAssignStaffRequestTask.setEditable(false);
//        staffAssignFormSubSubPanel.add(jlbAssignTask);
//        jlbAssignTask.setFont(LabelFont);
//        staffAssignFormSubSubPanel.add(jcbAssignStaffTask);
        staffAssignFormSubSubPanel.add(jlbAssignFood);
        jlbAssignFood.setFont(LabelFont);
        staffAssignFormSubSubPanel.add(jcbAssignStaffArea);
        staffAssignFormSubSubPanel.setPreferredSize(new Dimension(600, 0));

        staffAssignFormSubPanel.add(staffAssignButtonPanel);
        staffAssignButtonPanel.add(staffAssignButtonSubPanel);
        staffAssignButtonSubPanel.setBackground(new Color(248, 248, 248));
        staffAssignButtonSubPanel.add(staffAssignButtonSubSubPanel);
        staffAssignButtonPanel.setBorder(new EmptyBorder(20, 13, 20, 20));
        staffAssignButtonPanel.setBackground(new Color(248, 248, 248));
        staffAssignButtonSubPanel.setBackground(new Color(248, 248, 248));
        staffAssignButtonSubSubPanel.setBorder(new EmptyBorder(0, 70, 0, 70));
        staffAssignButtonSubSubPanel.setBackground(new Color(248, 248, 248));

        staffAssignButtonSubSubPanel.add(jbtComplete).setFont(btnFont);
        jbtComplete.setVerticalAlignment(SwingConstants.CENTER);
        jbtComplete.setHorizontalAlignment(SwingConstants.CENTER);
        jbtComplete.setVerticalTextPosition(SwingConstants.CENTER);
        jbtComplete.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbtComplete.setBackground(Color.getHSBColor(178, 34, 34));
        jbtComplete.setFocusPainted(false);
        jbtComplete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        staffAssignButtonSubSubPanel.add(jbtReject).setFont(btnFont);
        jbtReject.setVerticalAlignment(SwingConstants.CENTER);
        jbtReject.setHorizontalAlignment(SwingConstants.CENTER);
        jbtReject.setVerticalTextPosition(SwingConstants.CENTER);
        jbtReject.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbtReject.setBackground(Color.getHSBColor(178, 34, 34));
        jbtReject.setFocusPainted(false);
        jbtReject.setCursor(new Cursor(Cursor.HAND_CURSOR));

        staffAssignButtonSubSubPanel.add(new JLabel());

        staffAssignButtonSubSubPanel.add(jbtAssign).setFont(btnFont);
        jbtAssign.setVerticalAlignment(SwingConstants.CENTER);
        jbtAssign.setHorizontalAlignment(SwingConstants.CENTER);
        jbtAssign.setVerticalTextPosition(SwingConstants.CENTER);
        jbtAssign.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbtAssign.setBackground(Color.getHSBColor(178, 34, 34));
        jbtAssign.setFocusPainted(false);
        jbtAssign.setCursor(new Cursor(Cursor.HAND_CURSOR));

        staffAssignButtonSubSubPanel.add(jbtGenerateReport).setFont(btnFont);
        jbtGenerateReport.setVerticalAlignment(SwingConstants.CENTER);
        jbtGenerateReport.setHorizontalAlignment(SwingConstants.CENTER);
        jbtGenerateReport.setVerticalTextPosition(SwingConstants.CENTER);
        jbtGenerateReport.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbtGenerateReport.setBackground(Color.getHSBColor(178, 34, 34));
        jbtGenerateReport.setFocusPainted(false);
        jbtGenerateReport.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //End of Workload Assignment Panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel);
        topPanel.add(titleFlowPanel);
        centerPanel.add(tabbebPanel);
        centerPanel.setBackground(Color.white);
        titleFlowPanel.setBackground(new Color(190, 244, 244));
//        titleFlowPanel.add(new JLabel(logoImage));
        titleFlowPanel.add(jlbTitle);
        jlbTitle.setFont(TitleFont);

        titleFlowPanel.add(jbtBack).setFont(btnFont);
        jbtBack.setVerticalAlignment(SwingConstants.CENTER);
        jbtBack.setHorizontalAlignment(SwingConstants.CENTER);
        jbtBack.setVerticalTextPosition(SwingConstants.CENTER);
        jbtBack.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbtBack.setBackground(Color.getHSBColor(178, 34, 34));
        jbtBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbtBack.setPreferredSize(new Dimension(220, 40));
        jbtBack.setFocusPainted(false);

        //Staff Panel
        //End of Staff Panel
        tabbebPanel.addTab("Staff Registration", staffRegistrerMainPanel);
        tabbebPanel.addTab("Task Area",  taskAssignmentMainPanel);
        tabbebPanel.setFont(tabFont);
        tabbebPanel.setBackground(Color.getHSBColor(178, 34, 34));
        tabbebPanel.setFocusable(true);

        add(mainPanel);

        jbtBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                new MainMenu_New();
            }
        });

        jbtClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Clear();
            }
        });

        jbtRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (RegisterValidation()) {
                    String name = jtfStaffName.getText();
                    String contactNo = jtfStaffContactNo.getText();
                    String gender = bgGender.getSelection().getActionCommand();
                    int age = (int) jcbStaffAge.getSelectedItem();
                    String status = jtfStaffStatus.getText();

                    int[] requestTask = {0, 0, 0};
                    int i = 0;
                    requestTask[i] = 1;
                    i++;
                    if (jcbRequestTask2.isSelected()) {
                        requestTask[i] = 2;
                        i++;
                    }
                    if (jcbRequestTask3.isSelected()) {
                        requestTask[i] = 3;
                        i++;
                    }
                    Staff s = new Staff(name, contactNo, gender, age, status, requestTask);
                    stafflist.addStaff(s);
                    row[0] = s.getName();
                    row[1] = s.getContactNo();
                    row[2] = s.getGender();
                    row[3] = s.getAge();
                    row[4] = s.getRequestTaskString();
                    model.addRow(row);
                    DisplayStaffWorkList();
                }
            }
        });

        jtfAssignStaffName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String staffName = jtfAssignStaffName.getText();
                boolean found = false;

                for (int l = 0; l < stafflist.getNumberOfEntries(); l++) {
                    if (staffName.equals(stafflist.getAllStaff()[l].getName())) {
                        if (!stafflist.getAllStaff()[l].getStatus().equals("Pending")) {
                            for (int i = 0; i < stafflist.getNumberOfAssigned(); i++) {
                                if (staffName.equals(stafflist.getAssginedStaff()[i].getName())) {
                                    jtfAssignStaffStatus.setText(stafflist.getAllStaff()[l].getStatus());
                                    jtfAssignStaffRequestTask.setText(stafflist.getAllStaff()[l].getRequestTaskString());
//                                    jcbAssignStaffTask.setSelectedItem(stafflist.getAssginedStaff()[i].getCompleteTask());
                                    jcbAssignStaffArea.setSelectedItem(stafflist.getAssginedStaff()[i].getAssignFood());
                                    found = true;
                                }
                            }
                        } else {
                            jtfAssignStaffStatus.setText(stafflist.getAllStaff()[l].getStatus());
                            jtfAssignStaffRequestTask.setText(stafflist.getAllStaff()[l].getRequestTaskString());
//                            jcbAssignStaffTask.setSelectedItem(null);
                            jcbAssignStaffArea.setSelectedItem(null);
                            found = true;
                        }
                    }
                }
                if (found == false) {
                    JOptionPane.showMessageDialog(null, "Record not found", "Data Missing", JOptionPane.ERROR_MESSAGE);
                    jtfAssignStaffStatus.setText("");
                    jtfAssignStaffRequestTask.setText("");
//                    jcbAssignStaffTask.setSelectedItem(null);
                    jcbAssignStaffArea.setSelectedItem(null);
                }
            }
        });

        jbtAssign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (AssignValidation()) {
                    int autoAssignTask = jcbAssignStaffTask.getSelectedIndex();
                    String assignTask = (String) jcbAssignStaffTask.getSelectedItem();
                    String assignArea = (String) jcbAssignStaffArea.getSelectedItem();
                    Date date = new Date();
                    String currentDate = dateFormat.format(date);
                    Staff sl = stafflist.assignStaffWork(autoAssignTask);
                    if (sl == null) {                //if return false,prompt no staff is fulfill the assign task
                        JOptionPane.showMessageDialog(null, "No staff can be assign", "Staff Status Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Staff s = new Staff(sl.getName(), sl.getStatus(), sl.getRequestTaskString(), assignTask, assignArea, currentDate);
                        s.setStatus("Working");
                        JOptionPane.showMessageDialog(null, s.getName() + " is start to work " + assignTask, "Staff Working", JOptionPane.INFORMATION_MESSAGE);
                        stafflist.addAssignmentReport(s);
                        DisplayStaffWorkList();
                    }
                }
            }
        });

        jbtComplete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (CompleteValidation()) {
                    String name = jtfAssignStaffName.getText();
                    String taskStatus = jtfAssignStaffStatus.getText();
                    String taskRequest = jtfAssignStaffRequestTask.getText();
                    String assignTask = (String) jcbAssignStaffTask.getSelectedItem();
                    String assignArea = (String) jcbAssignStaffArea.getSelectedItem();
                    Date date = new Date();
                    String currentDate = dateFormat.format(date);

                    Staff s = new Staff(name, taskStatus, taskRequest, assignTask, assignArea, currentDate);
                    if (!s.getStatus().equals("Working")) {  //prompt error message if the staff are not working
                        JOptionPane.showMessageDialog(null, "Task Status are NOT Working", "Staff Status Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        s.setStatus("Complete");
                        stafflist.completeStaffWork(s);
                        JOptionPane.showMessageDialog(null, s.getName() + " is complete the work which is " + assignTask, "Staff Complete Work", JOptionPane.INFORMATION_MESSAGE);
                        stafflist.addAssignmentReport(s);
                        jtfAssignStaffStatus.setText("Complete");
                        DisplayStaffWorkList();
                    }
                }
            }
        });

        jbtReject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (RejectValidation()) {
                    int choice;
                    String name = jtfAssignStaffName.getText();
                    String taskStatus = jtfAssignStaffStatus.getText();
                    String taskRequest = jtfAssignStaffRequestTask.getText();
                    choice = JOptionPane.showConfirmDialog(null, "Do you sure want to reject '" + name + "' work?", "Confirm your Decision", JOptionPane.INFORMATION_MESSAGE);

                    if (choice == JOptionPane.OK_OPTION) {
                        Staff s = new Staff(name, taskStatus, taskRequest);
                        stafflist.rejectWork(s);
                        DisplayStaffWorkList();
                        JOptionPane.showMessageDialog(null, "Staff Had Be Rejected \nName : " + s.getName(),
                                "Rejected Staff", JOptionPane.INFORMATION_MESSAGE);
                        jtfAssignStaffName.setText("");
                        jtfAssignStaffStatus.setText("");
                        jtfAssignStaffRequestTask.setText("");
//                        jcbAssignStaffTask.setSelectedItem(null);
                        jcbAssignStaffArea.setSelectedItem(null);
                    }
                }
            }
        });

        jbtGenerateReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, stafflist.toString());
            }
        });

        //Oon Bing Jie: Staff Listener
        //End of Staff Listener
        setTitle("Registration");
        setSize(1010, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeAgeModel() {
        for (int i = 12; i <= 90; i++) {
            ageModel.addElement(i);
        }
    }

    private void initializeStatusModel() {
        statusModel.addElement("Pending");
        statusModel.addElement("Working");
        statusModel.addElement("Completed");
    }

    private void initializeTaskModel() {
        taskModel.addElement("Selangor(T1)");
        taskModel.addElement("Kuala Lumpur(T2)");
        taskModel.addElement("Seremban(T3)");
    }

    private void initializeAreaModel() {
        areaModel.addElement("Food Set A");
        areaModel.addElement("Food Set B");
        areaModel.addElement("Food Set C");
    }

    public void Clear() {
        jtfStaffName.setText("");
        jtfStaffContactNo.setText("");
        jrbMale.setSelected(true);
        jcbStaffAge.setSelectedItem(18);
        jcbRequestTask2.setSelected(false);
        jcbRequestTask3.setSelected(false);
    }

    public void DisplayStaffWorkList() {
        model2.setRowCount(0);
        if (stafflist.getNumberOfEntries() != 0) {
            for (int k = 0; k < stafflist.getNumberOfEntries(); k++) {
                row2[0] = stafflist.getAllStaff()[k].getName();
                row2[1] = stafflist.getAllStaff()[k].getContactNo();
                row2[2] = stafflist.getAllStaff()[k].getGender();
                row2[3] = stafflist.getAllStaff()[k].getAge();
                row2[4] = stafflist.getAllStaff()[k].getStatus();
                row2[5] = stafflist.getAllStaff()[k].getRequestTaskString();
                model2.addRow(row2);
            }
        }
    }

    public boolean RegisterValidation() {
        boolean valid = true;

        if (jtfStaffName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Name textfield must fillup", "Name Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (jtfStaffContactNo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Contact Number textfield must fillup", "Contact Number Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for (int i = 0; i < stafflist.getNumberOfEntries(); i++) {
            if (jtfStaffName.getText().equals(stafflist.getAllStaff()[i].getName())) {
                JOptionPane.showMessageDialog(null, "The staff already exist", "Existed Record", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return valid;
    }

    public boolean AssignValidation() {
        boolean valid = true;

////        if (jcbAssignStaffTask.getSelectedItem() == null) {
//            JOptionPane.showMessageDialog(null, "MUST Select a Task to Assign", "Task Missing", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
        if (jcbAssignStaffArea.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "MUST Select a Area to Assign", "Area Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return valid;
    }

    public boolean CompleteValidation() {
        boolean valid = true;

        if (jtfAssignStaffName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Name textfield must fillup", "Name Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jtfAssignStaffStatus.getText().equals("") && jtfAssignStaffRequestTask.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please search the staff which is working", "Data Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
//        if (jcbAssignStaffTask.getSelectedItem() == null) {
//            JOptionPane.showMessageDialog(null, "MUST Select a Task to Assign", "Task Missing", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
        if (jcbAssignStaffArea.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "MUST Select a Area to Assign", "Area Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return valid;
    }

    public boolean RejectValidation() {
        if (jtfAssignStaffName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Name textfield must fillup", "Name Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jtfAssignStaffStatus.getText().equals("") && jtfAssignStaffRequestTask.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please search the staff which is in the list", "Data Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean TaskValidation(Staff staff) {
        boolean valid = false;
        for (int l = 0; l < stafflist.getNumberOfEntries(); l++) {
            if (staff.getName().equals(stafflist.getAllStaff()[l].getName())) {
                for (int i = 0; i < stafflist.getAllStaff()[l].getRequestTask().length; i++) {
                    if (stafflist.getAllStaff()[l].getRequestTask()[i] == (jcbAssignStaffTask.getSelectedIndex() + 1)) {
                        return true;
                    }
                }
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new WorkloadAssignmentDriver();
    }
}
