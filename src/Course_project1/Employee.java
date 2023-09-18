package Course_project1;

public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private int id;

    private static int count = 0;


    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = ++count;
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

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return fullName + ", отдел " + department + ", зарплата " + salary + " руб. " + "id: " + id;
    }

}
