package queue.basic.intermediate;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    private String name;
    private int priority; // Lower number means higher priority (e.g., 1 is critical)

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Patient{" + "name='" + name + '\'' + ", priority=" + priority + '}';
    }
}

public class HospitalPatientPriority {
    public static void main(String[] args) {
        // Problem 8: Design hospital patient priority system.
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();

        // Patients arriving at the hospital with different priorities
        patientQueue.add(new Patient("John Doe", 3)); // Minor injury
        patientQueue.add(new Patient("Jane Smith", 1)); // Critical condition
        patientQueue.add(new Patient("Peter Jones", 2)); // Serious but stable

        System.out.println("Current patient queue: " + patientQueue);

        // Doctors see patients based on priority
        while (!patientQueue.isEmpty()) {
            Patient nextPatient = patientQueue.poll();
            System.out.println("Treating: " + nextPatient);
        }
    }
}
