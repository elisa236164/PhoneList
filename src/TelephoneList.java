import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class TelephoneList {
    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        boolean running = true;


        Scanner fileInput = new Scanner(new File("C:\\eksamen\\Mappe\\mappeintelliji\\PhoneList\\src\\numberName.txt"));


        readFromFile(fileInput);

         while (running) {
             System.out.println("---------------------------------------");
             System.out.println("Welcome to your phone list. enter:");
            System.out.println("              <Menu>");
            System.out.println("1. for show list");
            System.out.println("2. for add new name and phoneNumber");
            System.out.println("3. for new entry");
            System.out.println("4. for quit");
             System.out.println("---------------------------------------");

            int choice = userInput.nextInt();

            switch (choice) {
                case 1:
                    // Vis menu
                    showMenu(fileInput);
                    break;

                case 2:
                    // add new name and phonenumber
                    addNewContact();

                    break;

                case 3:
                    //New entry that is automatically  placed in the first free index
                    deleteEntry(fileInput);

                    break;
                case 4:
                    running = false;
                    System.out.print("fejl, prøv igen");
                    break;
                default:
                    running = false;
                    System.out.print("Fejl, prøv igen");
                    break;
            }
         //   showMenu(fileInput);
           // addNewContact();
            //deleteEntry(fileInput);

        }


        System.out.println("\nDu har lukket programmet");

        userInput.close();
        fileInput.close();
    }

    private static void deleteEntry(Scanner fileInput) throws FileNotFoundException {
        fileInput = new Scanner(new File("C:\\eksamen\\Mappe\\mappeintelliji\\PhoneList\\src\\numberName.txt"));

        ArrayList <String>  fileToArray = new ArrayList<>();

        int lineNumber = 1;
        while(fileInput.hasNextLine()) {

            String line = fileInput.nextLine();
            fileToArray.add(line);
            //System.out.println("antal tal");

            lineNumber++;

        }
        if (!fileToArray.isEmpty()) { //fjern den tomme streng der tilbage
            fileToArray.remove(fileToArray.size() - 1);
        }

        System.out.print("\nIndtast det nummer du gerne vil fjerne\n" + fileToArray);
        Scanner userInput = new Scanner(System.in);
        int deleteUser = userInput.nextInt();
        fileToArray.remove(deleteUser);
        System.out.println("det der er fjernet\n" + fileToArray);

    }

    public static void showMenu(Scanner fileInput) throws FileNotFoundException {

        fileInput = new Scanner(new File("C:\\eksamen\\Mappe\\mappeintelliji\\PhoneList\\src\\numberName.txt"));
        int linenumber = 1;
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
            String[] parts = line.split(" ");

            System.out.println("Number " + linenumber + " " +"Navn: " + parts[0] + "\nTelefonNummer " + parts[1]);
          //  System.out.println("Number " + linenumber + " " +"Telefonnummer: " + parts[1]);
            linenumber++;
        }
    }

    public static void addNewContact() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\eksamen\\Mappe\\mappeintelliji\\PhoneList\\src\\numberName.txt", true));

        Scanner userInput = new Scanner(System.in);
        int linenumber = 1;
        System.out.println("Vil du tilføje en ny kontakt?");
        System.out.print("Indtast navn: ");
        String name = userInput.nextLine();
        System.out.print("Indtast telefonnummer: ");
        String phoneNumber = userInput.nextLine();

        writer.write("Number " + linenumber + " " + name + " " + phoneNumber);
        writer.newLine();

        linenumber++;

        writer.close();
        System.out.println("Ny kontakt tilføjet. Opdateret liste:");
        showMenu(new Scanner(new File("C:\\eksamen\\Mappe\\mappeintelliji\\PhoneList\\src\\numberName.txt")));

    }


    public static void readFromFile(Scanner fileInput) throws FileNotFoundException {

        fileInput = new Scanner(new File("C:\\eksamen\\Mappe\\mappeintelliji\\PhoneList\\src\\numberName.txt"));

        int lineNumber = 1;
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();

            lineNumber++;
        }
    }
}
