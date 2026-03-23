import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
/**
 * The GymGUI class implements a graphical user interface for a gym management system.
 * It enables users to manage gym memberships by adding, activating, deactivating, and reverting
 * regular and premium members, marking attendance, processing payments, calculating discounts,
 * upgrading plans, and saving/loading member data to/from a file. The interface is built using
 * Swing components, including text fields, combo boxes, radio buttons, and action buttons, organized
 * in a custom layout.
 * @author [Sagar Acharya]
 * @version 1.3
 * @since 2025-04-10
 */

public class GymGUI extends JFrame {
    private ArrayList<GymMember> members = new ArrayList<>();
    // GUI Components
    private JTextField memberIdTextField, nameTextField, locationTextField, phoneTextField, emailTextField,
            referralSourceTextField, paidAmountTextField, removalReasonTextField, personalTrainerTextField;
    private JTextField priceTextField, premiumChargeTextField, discountAmountTextField;
    private JComboBox<String> dobDayComboBox, dobMonthComboBox, dobYearComboBox,
            msDayComboBox, msMonthComboBox, msYearComboBox, planComboBox;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;
    private JButton addRegularButton, addPremiumButton, activateButton, deactivateButton,
            markAttendanceButton, revertRegularButton, revertPremiumButton, displayButton, clearButton, payDueButton;
    /**
     * Constructs the GymGUI, initializing the graphical user interface with all components
     * and event listeners for user interactions.
     * version 1.3
     * @since 2025-04-10
     */
    public GymGUI() {
        super("Gym Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 850);
        getContentPane().setBackground(new Color(0x123456));
        setLayout(null);
        
        // Welcome label
        JLabel label = new JLabel("Welcome to the Gym Management System");
        label.setFont(label.getFont().deriveFont(24.0f));
        label.setBounds(400, 40, 500, 50);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        add(label);

        // Member Details section
        JLabel memberDetail = new JLabel("Member Details");
        memberDetail.setBounds(100, 100, 200, 30);
        memberDetail.setHorizontalAlignment(JLabel.CENTER);
        memberDetail.setFont(memberDetail.getFont().deriveFont(20.0f));
        memberDetail.setForeground(Color.WHITE);
        add(memberDetail);

        // Member ID
        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdLabel.setBounds(100, 150, 200, 30);
        memberIdLabel.setHorizontalAlignment(JLabel.CENTER);
        memberIdLabel.setFont(memberIdLabel.getFont().deriveFont(14.0f));
        memberIdLabel.setForeground(Color.WHITE);
        add(memberIdLabel);

        memberIdTextField = new JTextField();
        memberIdTextField.setBounds(300, 150, 200, 30);
        add(memberIdTextField);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 200, 200, 30);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(nameLabel.getFont().deriveFont(14.0f));
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 200, 200, 30);
        add(nameTextField);

        // Location
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(100, 250, 200, 30);
        locationLabel.setHorizontalAlignment(JLabel.CENTER);
        locationLabel.setFont(locationLabel.getFont().deriveFont(14.0f));
        locationLabel.setForeground(Color.WHITE);
        add(locationLabel);

        locationTextField = new JTextField();
        locationTextField.setBounds(300, 250, 200, 30);
        add(locationTextField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(100, 300, 200, 30);
        phoneLabel.setHorizontalAlignment(JLabel.CENTER);
        phoneLabel.setFont(phoneLabel.getFont().deriveFont(14.0f));
        phoneLabel.setForeground(Color.WHITE);
        add(phoneLabel);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(300, 300, 200, 30);
        add(phoneTextField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 350, 200, 30);
        emailLabel.setHorizontalAlignment(JLabel.CENTER);
        emailLabel.setFont(emailLabel.getFont().deriveFont(14.0f));
        emailLabel.setForeground(Color.WHITE);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 350, 200, 30);
        add(emailTextField);

        // DOB
        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(100, 400, 200, 30);
        dobLabel.setHorizontalAlignment(JLabel.CENTER);
        dobLabel.setFont(dobLabel.getFont().deriveFont(14.0f));
        dobLabel.setForeground(Color.WHITE);
        add(dobLabel);

        dobDayComboBox = new JComboBox<>();
        dobDayComboBox.setBounds(300, 400, 60, 30);
        dobDayComboBox.addItem("Day");
        for (int i = 1; i <= 31; i++) {
            dobDayComboBox.addItem(String.valueOf(i));
        }
        dobMonthComboBox = new JComboBox<>();
        dobMonthComboBox.setBounds(360, 400, 60, 30);
        dobMonthComboBox.addItem("Month");
        for (int i = 1; i <= 12; i++) {
            dobMonthComboBox.addItem(String.valueOf(i));
        }
        dobYearComboBox = new JComboBox<>();
        dobYearComboBox.setBounds(420, 400, 80, 30);
        dobYearComboBox.addItem("Year");
        for (int i = 1900; i <= 2025; i++) {
            dobYearComboBox.addItem(String.valueOf(i));
        }
        add(dobDayComboBox);
        add(dobMonthComboBox);
        add(dobYearComboBox);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(100, 450, 200, 30);
        genderLabel.setHorizontalAlignment(JLabel.CENTER);
        genderLabel.setFont(genderLabel.getFont().deriveFont(14.0f));
        genderLabel.setForeground(Color.WHITE);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setOpaque(false);
        maleRadioButton.setBounds(300, 450, 100, 30);
        maleRadioButton.setForeground(Color.WHITE);
        maleRadioButton.setFocusable(false);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(400, 450, 100, 30);
        femaleRadioButton.setOpaque(false);
        femaleRadioButton.setForeground(Color.WHITE);
        femaleRadioButton.setFocusable(false);
        add(femaleRadioButton);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Membership Start Date
        JLabel membershipStartDateLabel = new JLabel("Membership Start Date:");
        membershipStartDateLabel.setBounds(100, 500, 200, 30);
        membershipStartDateLabel.setHorizontalAlignment(JLabel.CENTER);
        membershipStartDateLabel.setFont(membershipStartDateLabel.getFont().deriveFont(14.0f));
        membershipStartDateLabel.setForeground(Color.WHITE);
        add(membershipStartDateLabel);

        msDayComboBox = new JComboBox<>();
        msDayComboBox.setBounds(300, 500, 70, 30);
        msDayComboBox.addItem("Day");
        for (int i = 1; i <= 31; i++) {
            msDayComboBox.addItem(String.valueOf(i));
        }
        msMonthComboBox = new JComboBox<>();
        msMonthComboBox.setBounds(380, 500, 70, 30);
        msMonthComboBox.addItem("Month");
        for (int i = 1; i <= 12; i++) {
            msMonthComboBox.addItem(String.valueOf(i));
        }
        msYearComboBox = new JComboBox<>();
        msYearComboBox.setBounds(460, 500, 80, 30);
        msYearComboBox.addItem("Year");
        for (int i = 2000; i <= 2025; i++) {
            msYearComboBox.addItem(String.valueOf(i));
        }
        add(msDayComboBox);
        add(msMonthComboBox);
        add(msYearComboBox);

        // Paid Amount
        JLabel paidAmountLabel = new JLabel("Paid Amount:");
        paidAmountLabel.setBounds(100, 550, 200, 30);
        paidAmountLabel.setHorizontalAlignment(JLabel.CENTER);
        paidAmountLabel.setFont(paidAmountLabel.getFont().deriveFont(14.0f));
        paidAmountLabel.setForeground(Color.WHITE);
        add(paidAmountLabel);

        paidAmountTextField = new JTextField();
        paidAmountTextField.setBounds(300, 550, 200, 30);
        add(paidAmountTextField);

        // Regular Member section
        JLabel regularMemberLabel = new JLabel("Regular Member");
        regularMemberLabel.setBounds(700, 100, 300, 30);
        regularMemberLabel.setHorizontalAlignment(JLabel.CENTER);
        regularMemberLabel.setFont(regularMemberLabel.getFont().deriveFont(20.0f));
        regularMemberLabel.setForeground(Color.WHITE);
        add(regularMemberLabel);

        // Referral Source
        JLabel referralSourceLabel = new JLabel("Referral Source:");
        referralSourceLabel.setBounds(800, 150, 200, 30);
        referralSourceLabel.setHorizontalAlignment(JLabel.CENTER);
        referralSourceLabel.setFont(referralSourceLabel.getFont().deriveFont(14.0f));
        referralSourceLabel.setForeground(Color.WHITE);
        add(referralSourceLabel);

        referralSourceTextField = new JTextField();
        referralSourceTextField.setBounds(1000, 150, 200, 30);
        add(referralSourceTextField);

        // Removal Reason
        JLabel removalReasonLabel = new JLabel("Removal Reason:");
        removalReasonLabel.setBounds(800, 200, 200, 30);
        removalReasonLabel.setHorizontalAlignment(JLabel.CENTER);
        removalReasonLabel.setFont(removalReasonLabel.getFont().deriveFont(14.0f));
        removalReasonLabel.setForeground(Color.WHITE);
        add(removalReasonLabel);

        removalReasonTextField = new JTextField();
        removalReasonTextField.setBounds(1000, 200, 200, 30);
        add(removalReasonTextField);

        // Price
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(800, 250, 200, 30);
        priceLabel.setHorizontalAlignment(JLabel.CENTER);
        priceLabel.setFont(priceLabel.getFont().deriveFont(14.0f));
        priceLabel.setForeground(Color.WHITE);
        add(priceLabel);

        priceTextField = new JTextField("6500");
        priceTextField.setBounds(1000, 250, 200, 30);
        priceTextField.setEditable(false);
        add(priceTextField);

        // Plan
        JLabel planLabel = new JLabel("Plan:");
        planLabel.setBounds(800, 300, 200, 30);
        planLabel.setHorizontalAlignment(JLabel.CENTER);
        planLabel.setFont(planLabel.getFont().deriveFont(14.0f));
        planLabel.setForeground(Color.WHITE);
        add(planLabel);

        planComboBox = new JComboBox<>();
        planComboBox.setBounds(1000, 300, 200, 30);
        planComboBox.addItem("Basic");
        planComboBox.addItem("Standard");
        planComboBox.addItem("Deluxe");
        planComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPlan = (String) planComboBox.getSelectedItem();
                if (selectedPlan.equals("Basic")) {
                    priceTextField.setText("6500");
                } else if (selectedPlan.equals("Standard")) {
                    priceTextField.setText("12500");
                } else if (selectedPlan.equals("Deluxe")) {
                    priceTextField.setText("18500");
                }
            }
        });
        add(planComboBox);

        // Premium Member section
        JLabel premiumMemberLabel = new JLabel("Premium Member");
        premiumMemberLabel.setBounds(700, 350, 300, 30);
        premiumMemberLabel.setHorizontalAlignment(JLabel.CENTER);
        premiumMemberLabel.setFont(premiumMemberLabel.getFont().deriveFont(20.0f));
        premiumMemberLabel.setForeground(Color.WHITE);
        add(premiumMemberLabel);

        // Personal Trainer
        JLabel personalTrainerLabel = new JLabel("Personal Trainer:");
        personalTrainerLabel.setBounds(800, 400, 200, 30);
        personalTrainerLabel.setHorizontalAlignment(JLabel.CENTER);
        personalTrainerLabel.setFont(personalTrainerLabel.getFont().deriveFont(14.0f));
        personalTrainerLabel.setForeground(Color.WHITE);
        add(personalTrainerLabel);

        personalTrainerTextField = new JTextField();
        personalTrainerTextField.setBounds(1000, 400, 200, 30);
        add(personalTrainerTextField);

        // Discount Amount
        JLabel discountAmountLabel = new JLabel("Discount Amount:");
        discountAmountLabel.setBounds(800, 450, 200, 30);
        discountAmountLabel.setHorizontalAlignment(JLabel.CENTER);
        discountAmountLabel.setFont(discountAmountLabel.getFont().deriveFont(14.0f));
        discountAmountLabel.setForeground(Color.WHITE);
        add(discountAmountLabel);

        discountAmountTextField = new JTextField("0");
        discountAmountTextField.setBounds(1000, 450, 200, 30);
        discountAmountTextField.setEditable(false);
        add(discountAmountTextField);

        // Premium Charge
        JLabel premiumChargeLabel = new JLabel("Premium Charge:");
        premiumChargeLabel.setBounds(800, 500, 200, 30);
        premiumChargeLabel.setHorizontalAlignment(JLabel.CENTER);
        premiumChargeLabel.setFont(premiumChargeLabel.getFont().deriveFont(14.0f));
        premiumChargeLabel.setForeground(Color.WHITE);
        add(premiumChargeLabel);

        premiumChargeTextField = new JTextField("50000");
        premiumChargeTextField.setBounds(1000, 500, 200, 30);
        premiumChargeTextField.setEditable(false);
        add(premiumChargeTextField);

        // Action section
        JLabel actionLabel = new JLabel("Action:");
        actionLabel.setBounds(60, 610, 200, 30);
        actionLabel.setHorizontalAlignment(JLabel.CENTER);
        actionLabel.setFont(actionLabel.getFont().deriveFont(20.0f));
        actionLabel.setForeground(Color.WHITE);
        add(actionLabel);

        // Buttons
        addRegularButton = new JButton("Add Regular Member");
        addRegularButton.setBounds(100, 650, 200, 30);
        addRegularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRegularMember();
                clearFields();
            }
        });
        add(addRegularButton);

        addPremiumButton = new JButton("Add Premium Member");
        addPremiumButton.setBounds(320, 650, 200, 30);
        addPremiumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPremiumMember();
            }
        });
        add(addPremiumButton);

        activateButton = new JButton("Activate Membership");
        activateButton.setBounds(540, 650, 200, 30);
        activateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                activateMembership();
            }
        });
        add(activateButton);

        deactivateButton = new JButton("Deactivate Membership");
        deactivateButton.setBounds(760, 650, 200, 30);
        deactivateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deactivateMembership();
            }
        });
        add(deactivateButton);

        markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setBounds(980, 650, 200, 30);
        markAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markAttendance();
            }
        });
        add(markAttendanceButton);

        revertRegularButton = new JButton("Revert Regular Member");
        revertRegularButton.setBounds(100, 690, 200, 30);
        revertRegularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                revertRegularMember();
            }
        });
        add(revertRegularButton);

        revertPremiumButton = new JButton("Revert Premium Member");
        revertPremiumButton.setBounds(320, 690, 200, 30);
        revertPremiumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                revertPremiumMember();
            }
        });
        add(revertPremiumButton);

        payDueButton = new JButton("Pay Due Amount");
        payDueButton.setBounds(540, 690, 200, 30);
        payDueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                payDueAmount();
            }
        });
        add(payDueButton);

        // Calculate Discount button
        JButton calculateDiscountButton = new JButton("Calculate Discount");
        calculateDiscountButton.setBounds(760, 690, 200, 30);
        calculateDiscountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateDiscount();
            }
        });
        add(calculateDiscountButton);


        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(980, 690, 200, 30);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        add(clearButton);

        // upgrade plan button
        JButton upgradePlanButton = new JButton("Upgrade Plan");
        upgradePlanButton.setBounds(100, 730, 200, 30);
        upgradePlanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                upgradePlan();
            }
        });
        add(upgradePlanButton);
       
        JButton loadFromFileButton = new JButton("Load from File");
        loadFromFileButton.setBounds(320, 730, 200, 30);
        loadFromFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader fr = new FileReader("members.txt");
                    int i;
                    String content = "";
        
                    while ((i = fr.read()) != -1) {
                        content += (char) i; 
                    }
        
                    fr.close();
        
                    // Display in new JFrame
                    JFrame displayFrame = new JFrame("Loaded Members");
                    displayFrame.setSize(1200, 500);
                    displayFrame.setLocationRelativeTo(null);
        
                    JTextArea textArea = new JTextArea();
                    textArea.setText(content); 
                    textArea.setEditable(false);
                    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    displayFrame.add(scrollPane);
        
                    displayFrame.setVisible(true);
        
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error loading members from file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(loadFromFileButton);


        // save to file button
        JButton saveToFileButton = new JButton("Save to File");
        saveToFileButton.setBounds(540, 730, 200, 30);
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter("members.txt");
                    fw.write("-".repeat(240) + "\n");
                    // Header
                    fw.write(String.format("%-10s %-15s %-15s %-15s %-20s %-10s %-12s %-20s %-20s %-10s %-15s %-15s %-15s %-15s %-10s%n",
                            "Type", "ID", "Name", "Address", "Phone", "Gender", "DOB", "MemberShipStartDate", "Email", "Plan", "Attendance", "Due Amount", "Discount","ReferredBy", "Personal Trainer"));
                            fw.write("-".repeat(240) + "\n");
                    for (GymMember member : members) {
                        String type = (member instanceof PremiumMember) ? "Premium" : "Regular";
                        //object for regular member
                        if (member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;
                            fw.write(String.format("%-10s %-15s %-15s %-15s %-20s %-10s %-12s %-20s %-20s %-10s %-15s %-15s %-15s %-15s %-10s%n",
                                    type,
                                    member.getId(),
                                    member.getName(),
                                    member.getLocation(),
                                    member.getPhone(),
                                    member.getGender(),
                                    member.getDOB(),
                                    member.getMembershipStartDate(),
                                    member.getEmail(),
                                    regularMember.getPlan(),
                                    member.getAttendance(),
                                    "N/A",
                                    "N/A",
                                    regularMember.getReferralSource(),
                                    "N/A"
                            ));
                        } else if (member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;
                            fw.write(String.format("%-10s %-15s %-15s %-15s %-20s %-10s %-12s %-20s %-20s %-10s %-15s %-15s %-15s %-15s %-10s%n",
                                    type,
                                    member.getId(),
                                    member.getName(),
                                    member.getLocation(),
                                    member.getPhone(),
                                    member.getGender(),
                                    member.getDOB(),
                                    member.getMembershipStartDate(),
                                    member.getEmail(),
                                    "Premium",
                                    member.getAttendance(),
                                    premiumMember.getPaidAmount(),
                                    premiumMember.getDiscountAmount(),
                                    "N/A",
                                    premiumMember.getPersonalTrainer()
                            ));
                        }
                    }
                    fw.write("-".repeat(240) + "\n");
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Members saved successfully to 'members.txt'");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving to file: " + ex.getMessage());
                }
            }
        });
        
        add(saveToFileButton);

        displayButton = new JButton("Display");
        displayButton.setBounds(760, 730, 200, 30);
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayMembers();
            }
        });
        add(displayButton);
        setVisible(true);
    }
     
    private void addRegularMember() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            for (GymMember m : members) {
                if (m.getId() == id) {
                    JOptionPane.showMessageDialog(this, "Member ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            String name = nameTextField.getText().trim();
            String location = locationTextField.getText().trim();
            String phone = phoneTextField.getText().trim();
            String email = emailTextField.getText().trim();
            String gender = maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female" : "";
            String dob = validateDate(dobDayComboBox, dobMonthComboBox, dobYearComboBox);
            String msDate = validateDate(msDayComboBox, msMonthComboBox, msYearComboBox);
            String referral = referralSourceTextField.getText().trim();

            if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() ||
                dob == null || msDate == null || referral.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Phone must be a 10-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(this, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            RegularMember member = new RegularMember(id, name, location, phone, email, gender, dob, msDate, referral);
            String selectedPlan = (String) planComboBox.getSelectedItem();
            if (!selectedPlan.equals("Basic")) {
                member.upgradePlan(selectedPlan);
            }
            member.activateMembership();
            members.add(member);
            JOptionPane.showMessageDialog(this, "Regular Member added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addPremiumMember() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            for (GymMember m : members) {
                if (m.getId() == id) {
                    JOptionPane.showMessageDialog(this, "Member ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            String name = nameTextField.getText().trim();
            String location = locationTextField.getText().trim();
            String phone = phoneTextField.getText().trim();
            String email = emailTextField.getText().trim();
            String gender = maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female" : "";
            String dob = validateDate(dobDayComboBox, dobMonthComboBox, dobYearComboBox);
            String msDate = validateDate(msDayComboBox, msMonthComboBox, msYearComboBox);
            String trainer = personalTrainerTextField.getText().trim();

            if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() ||
                dob == null || msDate == null || trainer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Phone must be a 10-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(this, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PremiumMember member = new PremiumMember(id, name, location, phone, email, gender, dob, msDate, trainer);
            member.activateMembership();
            members.add(member);
            try {
                double paid = Double.parseDouble(paidAmountTextField.getText().trim());
                if (paid > 0) {
                    String result = member.payDueAmount(paid);
                    double remaining = member.getPremiumCharge() - member.getPaidAmount();
                    if (member.getIsFullPayment()) {
                        member.calculateDiscount();
                        discountAmountTextField.setText(String.valueOf(member.getDiscountAmount()));
                    }
                    JOptionPane.showMessageDialog(this, 
                        result + "\nDue Amount to be Paid: " + remaining + 
                        (member.getIsFullPayment() ? "\nDiscount Applied: " + member.getDiscountAmount() : ""), 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                
            }
            JOptionPane.showMessageDialog(this, "Premium Member added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void activateMembership() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            GymMember member = null;
            for (GymMember m : members) {
                if (m.getId() == id) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (member.getActiveStatus()) {
                JOptionPane.showMessageDialog(this, "Membership is already active.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            member.activateMembership();
            JOptionPane.showMessageDialog(this, "Membership activated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deactivateMembership() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            GymMember member = null;
            for (GymMember m : members) {
                if (m.getId() == id) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!member.getActiveStatus()) {
                JOptionPane.showMessageDialog(this, "Membership is already inactive.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            member.deactivateMembership();
            JOptionPane.showMessageDialog(this, "Membership deactivated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void markAttendance() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            GymMember member = null;
            for (GymMember m : members) {
                if (m.getId() == id) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!member.getActiveStatus()) {
                JOptionPane.showMessageDialog(this, "Cannot mark attendance: Member is not active.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int previousAttendance = member.getAttendance();
            double previousLoyaltyPoints = member.getLoyaltyPoints();
            member.markAttendance();
            int newAttendance = member.getAttendance();
            double newLoyaltyPoints = member.getLoyaltyPoints();
            JOptionPane.showMessageDialog(this, 
                "Attendance marked successfully.\nAttendance Count: " + previousAttendance + " -> " + newAttendance +
                "\nLoyalty Points: " + previousLoyaltyPoints + " -> " + newLoyaltyPoints, 
                "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void payDueAmount() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            GymMember member = null;
            for (GymMember m : members) {
                if (m.getId() == id) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double amount = Double.parseDouble(paidAmountTextField.getText().trim());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a positive amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String result;
            double remaining;
            if (member instanceof PremiumMember) {
                PremiumMember premiumMember = (PremiumMember) member;
                result = premiumMember.payDueAmount(amount);
                remaining = premiumMember.getPremiumCharge() - premiumMember.getPaidAmount();
                if (premiumMember.getIsFullPayment()) {
                    premiumMember.calculateDiscount();
                    JOptionPane.showMessageDialog(this, 
                        result + "\nDue Amount to be Paid: " + remaining, 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        result + "\nDue Amount to be Paid: " + remaining, 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (member instanceof RegularMember) {
                RegularMember regularMember = (RegularMember) member;
                double price;
                String plan = regularMember.getPlan();
                switch (plan) {
                    case "Basic": price = 6500; break;
                    case "Standard": price = 18500; break;
                    case "Deluxe": price = 12500; break;
                    default: price = 6500;
                }
                double paidAmount = amount;
                if (paidAmount > price) {
                    JOptionPane.showMessageDialog(this, 
                        "Payment exceeds plan price of " + price, 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                remaining = price - paidAmount;
                result = "Payment successful for Regular Member.";
                JOptionPane.showMessageDialog(this, 
                    result + "\nDue Amount to be Paid: " + remaining, 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID or amount format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateDiscount() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            GymMember member = null;
            for (GymMember m : members) {
                if (m.getId() == id) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (member instanceof PremiumMember) {
                PremiumMember premiumMember = (PremiumMember) member;
                premiumMember.calculateDiscount();
                double discount = premiumMember.getDiscountAmount();
                discountAmountTextField.setText(String.format("%.2f", discount));
                JOptionPane.showMessageDialog(this, 
                    "Discount Amount: " + String.format("%.2f", discount), 
                    "Discount Calculation", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                discountAmountTextField.setText("0.00");
                JOptionPane.showMessageDialog(this, 
                    "No discount applicable for Regular Members.", 
                    "Discount Calculation", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void revertRegularMember() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            GymMember member = null;
            for (GymMember m : members) {
                if (m.getId() == id) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!(member instanceof RegularMember)) {
                JOptionPane.showMessageDialog(this, "Member is not a Regular Member.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String reason = removalReasonTextField.getText().trim();
            if (reason.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide a removal reason.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ((RegularMember) member).revertRegularMember(reason);
            JOptionPane.showMessageDialog(this, "Regular Member reverted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void revertPremiumMember() {
        try {
            int id = Integer.parseInt(memberIdTextField.getText().trim());
            GymMember member = null;
            for (GymMember m : members) {
                if (m.getId() == id) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!(member instanceof PremiumMember)) {
                JOptionPane.showMessageDialog(this, "Member is not a Premium Member.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ((PremiumMember) member).revertPremiumMember();
            discountAmountTextField.setText("0");
            JOptionPane.showMessageDialog(this, "Premium Member reverted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    // Clear all input fields
    private void clearFields() {
        memberIdTextField.setText("");
        nameTextField.setText("");
        locationTextField.setText("");
        phoneTextField.setText("");
        emailTextField.setText("");
        referralSourceTextField.setText("");
        paidAmountTextField.setText("");
        removalReasonTextField.setText("");
        personalTrainerTextField.setText("");
        genderGroup.clearSelection();
        dobDayComboBox.setSelectedIndex(0);
        dobMonthComboBox.setSelectedIndex(0);
        dobYearComboBox.setSelectedIndex(0);
        msDayComboBox.setSelectedIndex(0);
        msMonthComboBox.setSelectedIndex(0);
        msYearComboBox.setSelectedIndex(0);
        planComboBox.setSelectedIndex(0);
        priceTextField.setText("6500");
        discountAmountTextField.setText("0");
    }

    private String validateDate(JComboBox<String> dayBox, JComboBox<String> monthBox, JComboBox<String> yearBox) {
        if (dayBox.getSelectedIndex() == 0 || monthBox.getSelectedIndex() == 0 || yearBox.getSelectedIndex() == 0) {
            return null;
        }
        return dayBox.getSelectedItem() + "/" + monthBox.getSelectedItem() + "/" + yearBox.getSelectedItem();
    }
    private void upgradePlan() {
                try {
                    int id = Integer.parseInt(memberIdTextField.getText().trim());
                    GymMember member = null;
                    for (GymMember m : members) {
                        if (m.getId() == id) {
                            member = m;
                            break;
                        }
                    }
        
                    if (member == null) {
                        JOptionPane.showMessageDialog(GymGUI.this, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
        
                    if (member instanceof RegularMember) {
                        RegularMember regularMember = (RegularMember) member;
        
                        if (regularMember.getAttendance() >= 30) {
                            String selectedPlan = (String) planComboBox.getSelectedItem();
                            regularMember.upgradePlan(selectedPlan);
                            JOptionPane.showMessageDialog(GymGUI.this, "Plan upgraded successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(GymGUI.this, "You need to attend at least 30 times to upgrade your plan.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
        
                    } else {
                        JOptionPane.showMessageDialog(GymGUI.this, "Only Regular Members can upgrade their plan.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GymGUI.this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }

        private void displayMembers() {
        String displayText = ""; 
    
        if (members.isEmpty()) {
            displayText = "No members to display.";
        } else {
            for (GymMember member : members) {
                displayText += "------------------------\n";
    
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                System.setOut(new java.io.PrintStream(out));
                member.display();
                System.setOut(System.out);
    
                displayText += out.toString() + "\n"; 
            }
        }
    
        JTextArea textArea = new JTextArea(displayText); 
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));
    
        JOptionPane.showMessageDialog(this, scrollPane, "All Members", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
            new GymGUI();
    }
}