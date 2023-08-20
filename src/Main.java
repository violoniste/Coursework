public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Иван Иванович Иванов", 1, 5000);
        employees[1] = new Employee("Василий Петрович Сидоров", 4, 2000);
        employees[2] = new Employee("Михаил Васильевич Петров", 3, 7000);
        employees[3] = new Employee("Клубника Николаевна Иванова", 2, 7000);
        employees[4] = new Employee("Вишня Владимировна Петрова", 3, 4000);
        employees[5] = new Employee("Курага Петровна Сидорова", 2, 8000);
        employees[6] = new Employee("Чернослив Михайлович Иванов", 1, 5000);
        employees[7] = new Employee("Миндаль Иванович Зарецкий", 5, 3000);
        employees[8] = new Employee("Фундук Петрович Задорожный", 2, 7000);
        employees[9] = new Employee("Вальдемар Иванович Романовский", 6, 300000);

        printAllEmployeesFullName();
    }

    private static void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int getSalarySum() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee getEmployeeWithMinSalary() {
        Employee minEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minEmployee.getSalary())
                minEmployee = employee;
        }
        return minEmployee;
    }

    private static Employee getEmployeeWithMaxSalary() {
        Employee maxEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxEmployee.getSalary())
                maxEmployee = employee;
        }
        return maxEmployee;
    }

    private static int getSalaryAverage() {
        int sum = getSalarySum();
        return sum / employees.length;
    }

    private static void printAllEmployeesFullName() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }



}

