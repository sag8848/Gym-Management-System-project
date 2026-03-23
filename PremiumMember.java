/**
 * it is a child class which also inherits the properties of a parent class GymMember and as well as it has it's own 
 * attributes such as a personal trainer and payment details.
 *
 * @author Sagar Acharya
 * @version 1.3
 * @since 2025-04-10
 */
public class PremiumMember extends GymMember {
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    /**
     * Constructs a new PremiumMember with the specified details.
     *
     * @param id                  the unique identifier for the member
     * @param name                the name of the member
     * @param location            the location of the member
     * @param phone               the phone number of the member
     * @param email               the email address of the member
     * @param gender              the gender of the member
     * @param DOB                 the date of birth of the member (format: DD/MM/YYYY)
     * @param membershipStartDate the membership start date (format: DD/MM/YYYY)
     * @param personalTrainer     the name of the assigned personal trainer
     */

    public PremiumMember(int id, String name, String location, String phone, String email,
                        String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0.0;
        this.discountAmount = 0.0;
    }

    // Accessor methods
    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean getIsFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    // Implementing the abstract method
    @Override
    public void markAttendance() {
        this.attendance += 1;
        this.loyaltyPoints += 10;
    }

    // Method to pay due amount
    public String payDueAmount(double amount) {
        if (isFullPayment) {
            return "Payment is already full.";
        }

        if (paidAmount + amount > premiumCharge) {
            return "Total paid amount exceeds the premium charge.";
        }

        paidAmount += amount;
        if (paidAmount == premiumCharge) {
            isFullPayment = true;
        }

        double remainingAmount = premiumCharge - paidAmount;
        return "Payment successful. Remaining amount: " + remainingAmount;
    }

    // Method to calculate discount
    public String calculateDiscount() {
        if (isFullPayment) {
            discountAmount = premiumCharge * 0.10;
            return "Discount calculated successfully. Discount amount: " + discountAmount;
        } else {
            discountAmount = 0.0;
            return "No discount available as payment is not full.";
        }
    }

    // Method to revert premium member
    public void revertPremiumMember() {
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0.0;
        this.discountAmount = 0.0;
    }

    // Display method
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Is Full Payment: " + isFullPayment);
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount: " + remainingAmount);
        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
    
    }
