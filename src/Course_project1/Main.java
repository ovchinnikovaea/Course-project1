package Course_project1;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployeeBook("Крючкова Мария Матвеевна", 1, 54_000);
        employeeBook.addEmployeeBook("Мельников Николай Маркович", 2, 73_000);
        employeeBook.addEmployeeBook("Голубев Михаил Святославович", 3, 69_000);
        employeeBook.addEmployeeBook("Волков Владимир Александрович", 4, 95_000);
        employeeBook.addEmployeeBook("Миронова Александра Юрьевна", 5, 68_000);
        employeeBook.addEmployeeBook("Давыдов Артём Тимурович", 1, 55_000);
        employeeBook.addEmployeeBook("Климов Даниил Дмитриевич", 2, 56_000);
        employeeBook.addEmployeeBook("Белоусов Виктор Даниилович", 3, 67_000);
        employeeBook.addEmployeeBook("Карпова Мария Константиновна", 4, 57_000);
        employeeBook.addEmployeeBook("Котов Сергей Михайлович", 5, 93_000);


        employeeBook.printEmployees();

        int monthSalary = employeeBook.sumMonthSalary();
        System.out.println("Сумма затрат на зарплаты в месяц составляет: " + monthSalary);

        Employee employeeWithMinSalary = employeeBook.findEmployerWithMinSalary();
        System.out.println("Минимальная зарплата: " + employeeWithMinSalary.getSalary() + " руб. у сотрудника: " + employeeWithMinSalary.getFullName());

        Employee employeeWithMaxSalary = employeeBook.findEmployerWithMaxSalary();
        System.out.println("Максимальная зарплата: " + employeeWithMaxSalary.getSalary() + " руб. у сотрудника: " + employeeWithMaxSalary.getFullName());

        double middleSalary = employeeBook.calcMiddleSalary();
        System.out.println("Средняя зарплата: " + middleSalary);

        employeeBook.printFullName();

        employeeBook.indexSalary(10);

        Employee[] listOfDepartment = employeeBook.createListOfOneDepartment(4);
        Employee employerOfDepartmentWithMinSalary = employeeBook.findEmployerOfDepartmentWithMinSalary(listOfDepartment, 4);
        System.out.println("Минимальная зарплата в отделе " + employerOfDepartmentWithMinSalary.getDepartment() + ": " + employerOfDepartmentWithMinSalary.getSalary() + " руб. у сотрудника " + employerOfDepartmentWithMinSalary.getFullName());

        Employee employerOfDepartmentWithMaxSalary = employeeBook.findEmployerOfDepartmentWithMaxSalary(listOfDepartment, 4);
        System.out.println("Максимальная зарплата в отделе " + employerOfDepartmentWithMaxSalary.getDepartment() + ": " + employerOfDepartmentWithMaxSalary.getSalary() + " руб. у сотрудника " + employerOfDepartmentWithMaxSalary.getFullName());


        double middleSalaryOfDepartment = employeeBook.findMiddleSalaryOfDepartment(listOfDepartment, 4);
        System.out.println("Cредняя зарплата в отделе: " + middleSalaryOfDepartment + " руб.");

        employeeBook.indexSalaryOfDepartment(3, 10);

        employeeBook.printEmployeeOfDepartment(2);

        employeeBook.findEmployerOfDepartmentWithSalaryLess(60000);

        employeeBook.findEmployerOfDepartmentWithSalaryMore(70000);

        employeeBook.removeEmployee("Крючкова Мария Матвеевна");

        employeeBook.changeEmployeeSalary("Мельников Николай Маркович", 80000);

        employeeBook.changeEmployeeDepartment("Мельников Николай Маркович", 1);

        employeeBook.createListOfAllDepartment();



    }


}