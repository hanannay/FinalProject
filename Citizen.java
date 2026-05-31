public class Citizen {

    private String firstName;
    private String lastName;

    public Citizen() {
        firstName = "TBD";
        lastName = "TBD";
    }

    public Citizen(String inFirst, String inLast) {
        firstName = inFirst;
        lastName = inLast;
    }

    public void setFirstName(String inFirst) {
        firstName = inFirst;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String inLast) {
        lastName = inLast;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}