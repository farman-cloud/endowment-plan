import java.util.Objects;
import java.util.Scanner;

abstract class Endowment {
    protected String endowmentId;
    protected String holderName;
    protected String endowmentType;
    protected String registrationDate;

    public Endowment(String endowmentId, String holderName, String endowmentType, String registrationDate) {
        this.endowmentId = endowmentId;
        this.holderName = holderName;
        this.endowmentType = getEndowmentType();
        this.registrationDate = registrationDate;
    }

    public void setEndowmentId(String endowmentId) {
        this.endowmentId = endowmentId;
    }

    public String getEndowmentId() {
        return endowmentId;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getEndowmentType() {
        return endowmentType;
    }

    public void setEndowmentType(String endowmentType) {
        this.endowmentType = endowmentType;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public abstract double calculateEndowment();
}

class EducationalEndowment extends Endowment {
    private String educationalInstitution;
    private String educationalDivision;

    public EducationalEndowment(String endowmentId, String holderName, String endowmentType, String registrationDate, String educationalInstitution, String educationalDivision) {
        super(endowmentId, holderName, endowmentType, registrationDate);
        this.educationalInstitution = educationalInstitution;
        this.educationalDivision = educationalDivision;
    }

    public void setEducationalDivision(String educationalDivision) {
        this.educationalDivision = educationalDivision;
    }

    public String getEducationalDivision() {
        return educationalDivision;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    @Override
    public double calculateEndowment() {
        double endowment=0;
        if (Objects.equals(educationalDivision.toLowerCase(), "school")) {
            endowment = 30000;
        }
        else if (Objects.equals(educationalDivision.toLowerCase(), "undergraduate")) {
            endowment = 60000;
        }
        else if (Objects.equals(educationalDivision.toLowerCase(), "postgraduate")) {
            endowment = 90000;
        }
        return endowment;
    }
}

class HealthEndowment extends Endowment {

    private String healthCareCenter;
    private int holderAge;

    public HealthEndowment(String endowmentId, String holderName, String endowmentType, String registrationDate, String healthCareCenter, int holderAge) {
        super(endowmentId, holderName, endowmentType, registrationDate);
        this.healthCareCenter = healthCareCenter;
        this.holderAge = holderAge;
    }

    public void setHealthCareCenter(String healthCareCenter) {
        this.healthCareCenter = healthCareCenter;
    }

    public String getHealthCareCenter() {
        return healthCareCenter;
    }

    public void setHolderAge(int holderAge) {
        this.holderAge = holderAge;
    }

    public int getHolderAge() {
        return holderAge;
    }

    @Override
    public double calculateEndowment() {
        double endowmentAmount = 0.0;
        if (holderAge<=30) {
            endowmentAmount = 120000;
        } else if (holderAge<60) {
            endowmentAmount = 200000;
        } else {
            endowmentAmount = 500000;
        }
        return endowmentAmount;
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Endowment ID");
        String endowmentID = scanner.next();
        scanner.nextLine();

        System.out.println("Enter Holder Name");
        String holderName = scanner.nextLine();

        System.out.println("Enter Endowment Type");
        String endowmentType = scanner.next();

        System.out.println("Enter Registration Date");
        String registrationDate = scanner.next();
        scanner.nextLine();

        if (Objects.equals(endowmentType.toLowerCase(), "educational")) {

            System.out.println("Enter Educational Institution");
            String educationalInstitution = scanner.nextLine();

            System.out.println("Enter Educational Division");
            String educationalDivision = scanner.nextLine();

            EducationalEndowment edu = new EducationalEndowment(endowmentID, holderName, endowmentType, registrationDate, educationalInstitution, educationalDivision );
            System.out.println("Endowment Amount "+edu.calculateEndowment());
        } else if (Objects.equals(endowmentType.toLowerCase(), "health")) {

            System.out.println("Enter Health Care Center");
            String healthCenter = scanner.nextLine();

            System.out.println("Enter Holder Age");
            int holderAge = scanner.nextInt();

            HealthEndowment health = new HealthEndowment(endowmentID, holderName, endowmentType, registrationDate, healthCenter, holderAge);
            System.out.println("Endowment Amount "+health.calculateEndowment());
        } else {
            System.out.println(endowmentType+" is an invalid endowment type");
        }
    }
}


