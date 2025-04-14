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
    private String name;
    private int capacity;
    private int enrolled;
    private boolean prerequisiteCompleted;

    public Course(String name, int capacity, boolean prerequisiteCompleted) {
        this.name = name;
        this.capacity = capacity;
        this.enrolled = 0;
        this.prerequisiteCompleted = prerequisiteCompleted;
    }

    public void enroll() throws CourseFullException, PrerequisiteNotMetException {
        if (!prerequisiteCompleted) {
            throw new PrerequisiteNotMetException("Complete Core Java before enrolling in " + name + ".");
        }
        if (enrolled >= capacity) {
            throw new CourseFullException("Course is full.");
        }
        enrolled++;
        System.out.println("Enrolled successfully in " + name + ".");
    }
}

public class UniversityEnrollment {
    public static void main(String[] args) {
        Course advancedJava = new Course("Advanced Java", 2, false); // change to true to allow enrollment

        try {
            advancedJava.enroll();
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
