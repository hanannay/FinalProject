public class CarOwner extends Citizen {

    private String license;
    private int month;
    private int year;

    public CarOwner() {
        super();
        license = "TBD";
        month = 0;
        year = 0;
    }

    public CarOwner(String inFirst, String inLast, String inLicense, int inMonth, int inYear) {
        super(inFirst, inLast);
        license = inLicense;
        month = inMonth;
        year = inYear;
    }

    public void setLicense(String inLicense) {
        license = inLicense;
    }

    public String getLicense() {
        return license;
    }

    public void setmonth(int inMonth) {
        month = inMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int inYear) {
        year = inYear;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return super.toString() + "\t" + license + "\t" + month + "/" + year;
    }
}