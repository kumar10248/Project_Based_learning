import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private final String name;
    private final int maxEnrollment;
    private final boolean requiresPrerequisite;
    private int currentEnrollment = 0;

    public Course(String name, int maxEnrollment, boolean requiresPrerequisite) {
        this.name = name;
        this.maxEnrollment = maxEnrollment;
        this.requiresPrerequisite = requiresPrerequisite;
    }

    public String getName() {
        return name;
    }

    public void enroll(boolean hasCompletedPrerequisite)
            throws CourseFullException, PrerequisiteNotMetException {
        if (currentEnrollment >= maxEnrollment) {
            throw new CourseFullException("Course " + name + " is already full.");
        }
        if (requiresPrerequisite && !hasCompletedPrerequisite) {
            throw new PrerequisiteNotMetException("Prerequisite not met for " + name + ".");
        }
        currentEnrollment++;
        System.out.println("✅ Successfully enrolled in " + name + ". Current students: " + currentEnrollment);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined courses
        Course[] courses = {
            new Course("Java", 2, false),
            new Course("Python", 1, true),
            new Course("Data Structures", 2, true)
        };

        System.out.println("📚 Welcome to the University Enrollment System!");
        System.out.println("Available courses:");
        for (int i = 0; i < courses.length; i++) {
            System.out.println((i + 1) + ". " + courses[i].getName());
        }

        System.out.print("\nEnter the course number you want to enroll in: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice < 1 || choice > courses.length) {
            System.out.println("❌ Invalid course selection.");
            scanner.close();
            return;
        }

        Course selectedCourse = courses[choice - 1];

        System.out.print("Have you completed the prerequisite for " + selectedCourse.getName() + "? (yes/no): ");
        String prerequisiteInput = scanner.nextLine().trim().toLowerCase();
        boolean hasCompletedPrerequisite = prerequisiteInput.equals("yes");

        try {
            selectedCourse.enroll(hasCompletedPrerequisite);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("⚠️ " + e.getMessage());
        }

        scanner.close();
        System.out.println("🎓 Thank you for using the University Enrollment System!");
    }
}
