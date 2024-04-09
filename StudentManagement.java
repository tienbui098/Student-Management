import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentManagement {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== STUDENT MANAGEMENT =====");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by name");
            System.out.println("4. END");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: enterStudentList(studentList, scanner);
                    break;
                case 2: findStudentsByLastName(studentList, scanner);
                    break;
                case 3: findAndEditStudentsByName(studentList, scanner);
                    break;
                case 4: System.out.println("Program finished.");
                    break;
                default: System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void enterStudentList(List<Student> studentList, Scanner scanner)
    {
        System.out.print("Enter the number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Enter information for student " + (i + 1) + ":");
            Student student = createStudent(scanner);
            studentList.add(student);
        }
    }

    private static void findStudentsByLastName(List<Student> studentList, Scanner scanner)
    {
        System.out.print("Enter the last name of the student to find: ");
        String lastName = scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                displayStudentInfo(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found with the last name " + lastName);
        }
    }

    private static void findAndEditStudentsByName(List<Student> studentList, Scanner scanner)
    {
        System.out.print("Enter the name of the student to find and edit: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                System.out.println("Student information to be edited:");
                displayStudentInfo(student);

                updateStudentInfo(student, scanner);
                System.out.println("Edit successful.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with the name " + name);
        }
    }

    private static Student createStudent(Scanner scanner)
    {
        System.out.print("Full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Student ID: ");
        String studentID = scanner.nextLine();


        Student student = new Student();
        student.setFullName(fullName);
        student.setLastName(lastName);
        student.setStudentID(studentID);
        return student;
    }

    private static void updateStudentInfo(Student student, Scanner scanner)
    {
        System.out.println("Enter new student information:");
        System.out.print("Full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Student ID: ");
        String studentID = scanner.nextLine();

        student.setFullName(fullName);
        student.setLastName(lastName);
        student.setStudentID(studentID);
    }

    private static void displayStudentInfo(Student student)
    {
        System.out.println("Full name: " + student.getFullName());
        System.out.println("Last name: " + student.getLastName());
        System.out.println("Student ID: " + student.getStudentID());
    }
}