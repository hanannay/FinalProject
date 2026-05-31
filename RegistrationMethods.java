import java.util.*;
import java.io.*;

public class RegistrationMethods {

    private String inputFileName;
    private String outputFileName;

    public static final int REG_MONTH = 4;
    public static final int REG_YEAR = 2025;

    public void setFileNames() {

        Scanner kb = new Scanner(System.in);
        File file;

        do {
            System.out.print("Enter registration.csv file path: ");
            inputFileName = kb.nextLine();
            file = new File(inputFileName);
        } while (!file.exists());

        System.out.print("Enter output file path: ");
        outputFileName = kb.nextLine();
    }

    public int getArraySize() throws IOException {

        Scanner sc = new Scanner(new File(inputFileName));

        sc.nextLine(); // skip header

        int count = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            count++;
        }

        sc.close();
        return count;
    }

    public void processTextToArray(CarOwner[] inArray) throws IOException {

        Scanner sc = new Scanner(new File(inputFileName));
        sc.nextLine(); // skip header

        int i = 0;

        while (sc.hasNextLine() && i < inArray.length) {

            String[] data = sc.nextLine().split(",");

            inArray[i] = new CarOwner(
                data[0],
                data[1],
                data[2],
                Integer.parseInt(data[3]),
                Integer.parseInt(data[4])
            );

            i++;
        }

        sc.close();
    }

    public void printArray(CarOwner[] inArray, String inMsg) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter(outputFileName, true));

        pw.println(inMsg);
        pw.println("Name\tLicense\tMonth/Year");

        for (CarOwner c : inArray) {
            if (c != null) {
                pw.println(c.toString());
            }
        }

        pw.println();
        pw.close();
    }

    public CarOwner[] flagOverdueOwners(CarOwner[] inArray) {

        int monthsTotal = REG_YEAR * 12 + REG_MONTH;
        int count = 0;

        for (CarOwner c : inArray) {
            int m = c.getYear() * 12 + c.getMonth();
            if (monthsTotal - m > 12) {
                count++;
            }
        }

        CarOwner[] result = new CarOwner[count];
        int index = 0;

        for (CarOwner c : inArray) {
            int m = c.getYear() * 12 + c.getMonth();
            if (monthsTotal - m > 12) {
                result[index++] = c;
            }
        }

        return result;
    }

    public CarOwner[] flagAlmostDueOwners(CarOwner[] inArray) {

        int monthsTotal = REG_YEAR * 12 + REG_MONTH;
        int count = 0;

        for (CarOwner c : inArray) {
            int m = c.getYear() * 12 + c.getMonth();
            int diff = monthsTotal - m;

            if (diff > 9 && diff <= 12) {
                count++;
            }
        }

        CarOwner[] result = new CarOwner[count];
        int index = 0;

        for (CarOwner c : inArray) {
            int m = c.getYear() * 12 + c.getMonth();
            int diff = monthsTotal - m;

            if (diff > 9 && diff <= 12) {
                result[index++] = c;
            }
        }

        return result;
    }

    public String getOutputFileName() {
        return outputFileName;
    }
}