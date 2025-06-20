import java.util.Scanner;


class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("\nStudent Details:");
        System.out.println("Name  : " + name);
        System.out.println("ID    : " + id);
        System.out.println("Grade : " + grade);
    }
}


class StudentController {
    private final Student model;
    private final StudentView view;
    private final Scanner scanner = new Scanner(System.in);

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStudentManually() {
        System.out.println("\nUpdate Student Details (press Enter to skip any):");

        System.out.print("New Name (current: " + model.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            model.setName(name);
        }

        System.out.print("New Grade (current: " + model.getGrade() + "): ");
        String grade = scanner.nextLine();
        if (!grade.isEmpty()) {
            model.setGrade(grade);
        }


    }

    public void showStudent() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}


public class MVCPatternExample {
    public static void main(String[] args) {

        Student student = new Student("Thanuja", "S105", "A");


        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.showStudent();


        controller.updateStudentManually();


        controller.showStudent();
    }
}

