import java.util.Scanner;

class STUDENT {
    int StuId = 2345;
    String[] firstNames = new String[100];
    String[] lastNames = new String[100];
    int[] rollnums = new int[100];
    int[] marksArr = new int[100];
    int count = 0; // Number of student records stored

    public void checkId() {
        System.out.print("Please Enter Your Student Id : ");
        Scanner sc = new Scanner(System.in);
        int Id = sc.nextInt();
        if (Id == StuId) {
            System.out.println("Welcome : " + Id);
            menu();
        } else {
            System.out.println("Pls Enter a valid Student Id");
        }
    }

    public void menu() {
        System.out.println("\n1: Add Student Record");
        System.out.println("2: Delete Student Record");
        System.out.println("3: Update Student Record");
        System.out.println("4: Display All Records");
        System.out.println("5: Exit");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int opt = sc.nextInt();

        switch (opt) {
            case 1: addRecords(); break;
            case 2: deleteRecords(); break;
            case 3: updateRecords(); break;
            case 4: displayRecords(); break;
            case 5: System.out.println("Thank you!"); break;
            default:
                System.out.println("Invalid choice.");
                menu();
        }
    }

    public void addRecords() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The First Name : ");
        firstNames[count] = sc.nextLine();

        System.out.print("Enter The Last Name : ");
        lastNames[count] = sc.nextLine();

        System.out.print("Enter The Roll Number : ");
        rollnums[count] = sc.nextInt();

        System.out.print("Enter The Marks : ");
        marksArr[count] = sc.nextInt();

        count++;
        System.out.println("Record added successfully.");
        menu();
    }

    public void deleteRecords() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll Number to delete: ");
        int rollToDelete = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (rollnums[i] == rollToDelete) {
                // Shift all remaining students
                for (int j = i; j < count - 1; j++) {
                    firstNames[j] = firstNames[j + 1];
                    lastNames[j] = lastNames[j + 1];
                    rollnums[j] = rollnums[j + 1];
                    marksArr[j] = marksArr[j + 1];
                }
                count--;
                found = true;
                System.out.println("Record deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Roll number not found.");
        }

        menu();
    }

    public void updateRecords() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll Number to update: ");
        int rollToUpdate = sc.nextInt();
        sc.nextLine(); // consume newline

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (rollnums[i] == rollToUpdate) {
                System.out.println("Current Record:");
                System.out.println("Name: " + firstNames[i] + " " + lastNames[i]);
                System.out.println("Marks: " + marksArr[i]);

                System.out.print("Enter New First Name: ");
                firstNames[i] = sc.nextLine();

                System.out.print("Enter New Last Name: ");
                lastNames[i] = sc.nextLine();

                System.out.print("Enter New Marks: ");
                marksArr[i] = sc.nextInt();

                System.out.println("Record updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Roll number not found.");
        }

        menu();
    }

    public void displayRecords() {
        if (count == 0) {
            System.out.println("No records available.");
        } else {
            System.out.println("\n --------- All Student Records --------- ");
            for (int i = 0; i < count; i++) {
                System.out.println("Name: " + firstNames[i] + " " + lastNames[i]);
                System.out.println("Roll Number: " + rollnums[i]);
                System.out.println("Marks: " + marksArr[i]);
                System.out.println("------------------------------");
            }
        }
        menu();
    }
}
