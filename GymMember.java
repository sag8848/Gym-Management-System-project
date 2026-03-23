/**
 * it is an abstract base class which represents common attributes and behaviors.
 * it Provides methods for managing membership status, attendance, and loyalty points.
 *
 * @author Sagar Acharya
 * @version 1.0
 * @since 2025-04-10
 */
public abstract class GymMember {
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    /**
     * Constructs a new GymMember with the specified details.
     *
     * @param id                  the unique identifier for the member
     * @param name                the name of the member
     * @param location            the location of the member
     * @param phone               the phone number of the member
     * @param email               the email address of the member
     * @param gender              the gender of the member
     * @param DOB                 the date of birth of the member (format: DD/MM/YYYY)
     * @param membershipStartDate the membership start date (format: DD/MM/YYYY)
     */

    public GymMember(int id, String name, String location, String phone, String email,
                     String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public int getAttendance() {
        return attendance;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean getActiveStatus() {
        return activeStatus;
    }

    // Abstract method
    public abstract void markAttendance();

    // Method to activate membership
    public void activateMembership() {
        this.activeStatus = true;
    }

    // Method to deactivate membership
    public void deactivateMembership() {
        this.activeStatus = false;
    }

    // Method to reset member details
    public void resetMember() {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
    }

    // Display method
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
}