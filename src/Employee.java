public class Employee {
    private static int idCount = 0;

    private final int id;
    private final String fullName;
    private int department;     // 1 - 5
    private int salary;

    public Employee(String fullName, int department, int salary) {
        this.id = idCount;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;

        idCount++;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public String toStringWithoutDepartment() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
}
