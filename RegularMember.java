/**
 * it is a child class which inherits the properties of parent class(GymMember) and
 * has it's  own attributes such as referral source and plan details.
 *
 * @author Sagar Acharya
 * @version 1.0
 * @since 2025-05-10
 */
public class RegularMember extends GymMember {
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    /**
     * Constructs a new RegularMember with the specified details.
     *
     * @param id                  the unique identifier for the member
     * @param name                the name of the member
     * @param location            the location of the member
     * @param phone               the phone number of the member
     * @param email               the email address of the member
     * @param gender              the gender of the member
     * @param DOB                 the date of birth of the member (format: DD/MM/YYYY)
     * @param membershipStartDate the membership start date (format: DD/MM/YYYY)
     * @param referralSource      the source of referral for the member
     */

    public RegularMember(int id, String name, String location, String phone, String email,
                        String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.removalReason = "";
        this.referralSource = referralSource;
        this.plan = "basic";
        this.price = 6500;
    }
    
    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    // Implementing the abstract method
    @Override
    public void markAttendance() {
        this.attendance += 1;
        this.loyaltyPoints += 5;
        if (this.attendance >= attendanceLimit) {
            this.isEligibleForUpgrade = true;
        }
    }

    // Method to get plan price
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        }
    }

    // Method to upgrade the plan
    public String upgradePlan(String newPlan) {
        if (!isEligibleForUpgrade) {
            return "Member is not eligible for upgrade.";
        }

        if (newPlan.equalsIgnoreCase(this.plan)) {
            return "You are already subscribed to the " + newPlan + " plan.";
        }

        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "Invalid plan. Please select a valid plan.";
        }

        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded to " + newPlan + " successfully.";
    }

    // Method to revert regular member
    public void revertRegularMember(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    // Display method
    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
   
}