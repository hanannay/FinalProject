import java.io.IOException;

public class RegistrationDemo {

    public static void main(String[] args) throws IOException {

        RegistrationMethods dmv = new RegistrationMethods();

        dmv.setFileNames();

        int size = dmv.getArraySize();

        CarOwner[] ltState = new CarOwner[size];

        dmv.processTextToArray(ltState);

        dmv.printArray(ltState, "List of Car Owners");

        CarOwner[] overdue = dmv.flagOverdueOwners(ltState);
        dmv.printArray(overdue, "Owners with Expired Registration");

        CarOwner[] almostDue = dmv.flagAlmostDueOwners(ltState);
        dmv.printArray(almostDue, "Owners with registration expiring in three months or less");

        System.out.println("Output file location: " + dmv.getOutputFileName());
    }
}