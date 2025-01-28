abstract class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    abstract void displayDetails();
}

class Student extends Person {
    private int rollNumber;
    
    public Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }
    
    @Override
    void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll Number: " + rollNumber);
    }
}

class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    @Override
    void displayDetails() {
        System.out.println("\nTeacher Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
    }
}

public class School {
    public static void main(String[] args) {
        Student student = new Student("Kumar Devashish", 21, 10248);
        Teacher teacher = new Teacher("Er. Manpreet Kaur", 40, "Mathematics");
        
        student.displayDetails();
        teacher.displayDetails();
    }
}