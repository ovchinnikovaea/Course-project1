package Course_project1;

import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    private int size;

    public void addEmployeeBook(String fullName, int department, int salary) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить нового сотрудника");
            return;
        }
        Employee employee = new Employee(fullName, department, salary);
        employees[size++] = employee;
    }

    public void printEmployees() {
        System.out.println("Список всех сотрудников: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public int sumMonthSalary() {
        int sum = 0;
        for (Employee employee : employees)
            sum += employee.getSalary();
        return sum;
    }

    public Employee findEmployerWithMinSalary() {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() < employees[index].getSalary()) {
                index = i;
            }
        }
        return employees[index];
    }

    public Employee findEmployerWithMaxSalary() {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() > employees[index].getSalary()) {
                index = i;
            }
        }
        return employees[index];
    }

    public double calcMiddleSalary() {
        return (double) sumMonthSalary() / employees.length;
    }

    public void printFullName() {
        System.out.println("ФИО всех сотрудников: ");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getFullName());
        }
    }

    public void indexSalary(int percent) {
        System.out.println("Зарплата сотрудников после индексации: ");
        for (int i = 0; i < size; i++) {
            int newSalary = employees[i].getSalary() + (employees[i].getSalary() / 100 * percent);
            System.out.println(employees[i].getFullName() + " - " + newSalary);
        }
    }

    public Employee[] createListOfOneDepartment(int numberOfDepartment) {
        int newSize = 0;
        Employee[] tempArray = new Employee[employees.length];

        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                tempArray[newSize] = employees[i];
                newSize++;
            }
        }
        Employee[] listOfDepartment = new Employee[newSize];
        for (int i = 0; i < newSize; i++) {
            listOfDepartment[i] = tempArray[i];
        }
        return listOfDepartment;
    }

    public Employee findEmployerOfDepartmentWithMinSalary(Employee[] employees, int numberOfDepartment) {
        Employee[] listOfDepartment = createListOfOneDepartment(numberOfDepartment);
        int index = 0;
        for (int i = 0; i < listOfDepartment.length; i++) {
            if (listOfDepartment[i].getSalary() < listOfDepartment[index].getSalary()) {
                index = i;
            }
        }
        return listOfDepartment[index];
    }

    public Employee findEmployerOfDepartmentWithMaxSalary(Employee[] employees, int numberOfDepartment) {
        Employee[] listOfDepartment = createListOfOneDepartment(numberOfDepartment);
        int index = 0;
        for (int i = 0; i < listOfDepartment.length; i++) {
            if (listOfDepartment[i].getSalary() > listOfDepartment[index].getSalary()) {
                index = i;
            }
        }
        return listOfDepartment[index];
    }

    public double findMiddleSalaryOfDepartment(Employee[] employees, int numberOfDepartment) {
        Employee[] listOfOneDepartment = createListOfOneDepartment(numberOfDepartment);
        int sum = 0;
        for (int i = 0; i < listOfOneDepartment.length; i++) {
            sum += listOfOneDepartment[i].getSalary();
        }
        return sum / listOfOneDepartment.length;
    }

    public void indexSalaryOfDepartment(int numberOfDepartment, int percent) {
        System.out.println("Зарплата сотрудников отдела " + numberOfDepartment + " после индексации: ");
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                int newSalary = employees[i].getSalary() + (employees[i].getSalary() / 100 * percent);
                System.out.println(employees[i].getFullName() + " - " + newSalary);
            }
        }
    }

    public void printEmployeeOfDepartment(int numberOfDepartment) {
        System.out.println("Сотрудники отдела " + numberOfDepartment + ": ");
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                System.out.println(employees[i].getFullName() + ", зарплата " + employees[i].getSalary() + ", id: " + employees[i].getId());
            }
        }
    }

    public void findEmployerOfDepartmentWithSalaryLess(int standartSalary) {
        System.out.println("Сотрудники c зарплатой меньше " + standartSalary + ": ");
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() < standartSalary) {
                System.out.println(employees[i].getFullName() + ", зарплата " + employees[i].getSalary());
            }
        }
    }

    public void findEmployerOfDepartmentWithSalaryMore(int standartSalary) {
        System.out.println("Сотрудники c зарплатой больше " + standartSalary + ": ");
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() > standartSalary) {
                System.out.println(employees[i].getFullName() + ", зарплата " + employees[i].getSalary());
            }
        }
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                System.out.println(employees[i].getFullName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public void changeEmployeeSalary(String fullName, int newSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                throw new IllegalArgumentException("Нет такого сотрудника");
            } else if (employees[i].getFullName().equals(fullName)) {
                employees[i].setSalary(newSalary);
                System.out.println("Новая зарплата сотрудника " + employees[i].getFullName() + ": " + employees[i].getSalary() + " руб.");
                return;
            }
        }
    }



    public void changeEmployeeDepartment(String fullName, int newDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                throw new IllegalArgumentException("Нет такого сотрудника");
            } else if (employees[i].getFullName().equals(fullName)) {
                employees[i].setDepartment(newDepartment);
                System.out.println("Новый отдел сотрудника " + employees[i].getFullName() + ": " + employees[i].getDepartment());
                return;
            }
        }
    }


    public void createListOfAllDepartment() {
        int[] numbersOfDepartment = new int[size];
        for (int i = 0; i < size; i++) {
            numbersOfDepartment[i] = employees[i].getDepartment();
        }
        numbersOfDepartment = Arrays.stream(numbersOfDepartment).distinct().toArray();
        Arrays.sort(numbersOfDepartment);
        System.out.println(Arrays.toString(numbersOfDepartment));

        for (int i = 0; i < numbersOfDepartment.length; i++) {
            System.out.println("Сотрудники отдела " + numbersOfDepartment[i] + ": ");
            for (int j = 0; j < size; j++) {
                if (employees[j].getDepartment() == numbersOfDepartment[i]) {
                    System.out.println(employees[j].getFullName());
                }
            }
        }
    }
}

