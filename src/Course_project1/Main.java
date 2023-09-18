package Course_project1;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Крючкова Мария Матвеевна", 1, 54_000);
        employees[1] = new Employee("Мельников Николай Маркович", 2, 73_000);
        employees[2] = new Employee("Голубев Михаил Святославович", 3, 69_000);
        employees[3] = new Employee("Волков Владимир Александрович", 4, 95_000);
        employees[4] = new Employee("Миронова Александра Юрьевна", 5, 68_000);
        employees[5] = new Employee("Давыдов Артём Тимурович", 1, 55_000);
        employees[6] = new Employee("Климов Даниил Дмитриевич", 2, 56_000);
        employees[7] = new Employee("Белоусов Виктор Даниилович", 3, 67_000);
        employees[8] = new Employee("Карпова Мария Константиновна", 4, 57_000);
        employees[9] = new Employee("Котов Сергей Михайлович", 5, 93_000);

        printEmployees(employees);

        int monthSalary = sumMonthSalary(employees);
        System.out.println("Сумма затрат на зарплаты в месяц составляет: " + monthSalary);

        Employee employeeWithMinSalary = findEmployerWithMinSalary(employees);
        System.out.println("Минимальная зарплата: " + employeeWithMinSalary.getSalary() + " руб. у сотрудника: " + employeeWithMinSalary.getFullName());

        Employee employeeWithMaxSalary = findEmployerWithMaxSalary(employees);
        System.out.println("Максимальная зарплата: " + employeeWithMaxSalary.getSalary() + " руб. у сотрудника: " + employeeWithMaxSalary.getFullName());

        double middleSalary = calcMiddleSalary(employees);
        System.out.println("Средняя зарплата: " + middleSalary);

        printFullName(employees);

        indexSalary(employees, 10);

        Employee[] listOfDepartment = createListOfOneDepartment(employees, 4);
        Employee employerOfDepartmentWithMinSalary = findEmployerWithMinSalary(listOfDepartment);
        System.out.println("Минимальная зарплата в отделе " + employerOfDepartmentWithMinSalary.getDepartment() + ": " + employerOfDepartmentWithMinSalary.getSalary() + " руб. у сотрудника " + employerOfDepartmentWithMinSalary.getFullName());

        Employee employerOfDepartmentWithMaxSalary = findEmployerWithMaxSalary(listOfDepartment);
        System.out.println("Максимальная зарплата в отделе " + employerOfDepartmentWithMaxSalary.getDepartment() + ": " + employerOfDepartmentWithMaxSalary.getSalary() + " руб. у сотрудника " + employerOfDepartmentWithMaxSalary.getFullName());


        double middleSalaryOfDepartment = calcMiddleSalary(listOfDepartment);
        System.out.println("Cредняя зарплата в отделе: " + middleSalaryOfDepartment + " руб.");

        indexSalaryOfDepartment(employees, 3, 10);

        printEmployeeOfDepartment(employees, 2);

        findEmployerOfDepartmentWithSalaryLess(employees, 60000);

        findEmployerOfDepartmentWithSalaryMore(employees, 70000);
    }

    private static void printEmployees(Employee[] employees) {
        System.out.println("Список всех сотрудников: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int sumMonthSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees)
            sum += employee.getSalary();
        return sum;
    }

    private static Employee findEmployerWithMinSalary(Employee[] employees) {
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < employees[index].getSalary()) {
                index = i;
            }
        }
        return employees[index];
    }

    private static Employee findEmployerWithMaxSalary(Employee[] employees) {
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > employees[index].getSalary()) {
                index = i;
            }
        }
        return employees[index];
    }

    private static double calcMiddleSalary(Employee[] employees) {
        return (double) sumMonthSalary(employees) / employees.length;
    }

    private static void printFullName(Employee[] employees) {
        System.out.println("ФИО всех сотрудников: ");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getFullName());
        }
    }

    private static void indexSalary(Employee[] employees, int percent) {
        System.out.println("Зарплата сотрудников после индексации: ");
        for (int i = 0; i < employees.length; i++) {
            int newSalary = employees[i].getSalary() + (employees[i].getSalary() / 100 * percent);
            System.out.println(employees[i].getFullName() + " - " + newSalary);
        }
    }

    private static Employee[] createListOfOneDepartment(Employee[] employees, int numberOfDepartment) {
        int newSize = 0;
        Employee[] tempArray = new Employee[employees.length];

        for (int i = 0; i < employees.length; i++) {
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

//    private static Employee findEmployerOfDepartmentWithMinSalary(Employee[] employees, int numberOfDepartment) {
//        Employee[] listOfDepartment = createListOfOneDepartment(employees, numberOfDepartment);
//        int index = 0;
//        for (int i = 0; i < listOfDepartment.length; i++) {
//            if (listOfDepartment[i].getSalary() < listOfDepartment[index].getSalary()) {
//                index = i;
//            }
//        }
//        return listOfDepartment[index];
//    }

//    private static Employee findEmployerOfDepartmentWithMaxSalary(Employee[] employees, int numberOfDepartment) {
//        Employee[] listOfDepartment = createListOfOneDepartment(employees, numberOfDepartment);
//        int index = 0;
//        for (int i = 0; i < listOfDepartment.length; i++) {
//            if (listOfDepartment[i].getSalary() > listOfDepartment[index].getSalary()) {
//                index = i;
//            }
//        }
//        return listOfDepartment[index];
//    }

//    private static double findMiddleSalaryOfDepartment(Employee[] employees, int numberOfDepartment) {
//        Employee[] listOfOneDepartment = createListOfOneDepartment(employees, numberOfDepartment);
//        int sum = 0;
//        for (int i = 0; i < listOfOneDepartment.length; i++) {
//            sum += listOfOneDepartment[i].getSalary();
//        }
//        return sum / listOfOneDepartment.length;
//    }

    private static void indexSalaryOfDepartment(Employee[] employees, int numberOfDepartment, int percent) {
        System.out.println("Зарплата сотрудников отдела " + numberOfDepartment + " после индексации: ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                int newSalary = employees[i].getSalary() + (employees[i].getSalary() / 100 * percent);
                System.out.println(employees[i].getFullName() + " - " + newSalary);
            }
        }
    }

    private static void printEmployeeOfDepartment(Employee[] employees, int numberOfDepartment) {
        System.out.println("Сотрудники отдела " + numberOfDepartment + ": ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                System.out.println(employees[i].getFullName() + ", зарплата " + employees[i].getSalary() + ", id: " + employees[i].getId());
            }
        }
    }

    private static void findEmployerOfDepartmentWithSalaryLess(Employee[] employees, int standartSalary) {
        System.out.println("Сотрудники c зарплатой меньше " + standartSalary + ": ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < standartSalary) {
                System.out.println(employees[i].getFullName() + ", зарплата " + employees[i].getSalary());
            }
        }
    }

    private static void findEmployerOfDepartmentWithSalaryMore(Employee[] employees, int standartSalary) {
        System.out.println("Сотрудники c зарплатой больше " + standartSalary + ": ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > standartSalary) {
                System.out.println(employees[i].getFullName() + ", зарплата " + employees[i].getSalary());
            }
        }
    }
}