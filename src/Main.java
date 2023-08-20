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
        employees[9] = new Employee("Вальдемар Иванович Романовский", 1, 300000);


        printEmployeesWithSalaryMore(8000);
    }

    //    1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    private static void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //    2. Посчитать сумму затрат на зарплаты в месяц.
    private static int getSalarySum() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    //    3. Найти сотрудника с минимальной зарплатой.
    private static Employee getEmployeeWithMinSalary() {
        Employee minEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minEmployee.getSalary())
                minEmployee = employee;
        }
        return minEmployee;
    }

    //    4. Найти сотрудника с максимальной зарплатой.
    private static Employee getEmployeeWithMaxSalary() {
        Employee maxEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxEmployee.getSalary())
                maxEmployee = employee;
        }
        return maxEmployee;
    }

    //    5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    private static int getSalaryAverage() {
        int sum = getSalarySum();
        return sum / employees.length;
    }

    //    6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
    private static void printAllEmployeesFullName() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    //    1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    private static void indexSalary(int percent) {
        for (Employee employee : employees) {
            employee.setSalary((int) (employee.getSalary() * (1 + percent / 100f)));
        }
    }

    //    1. Сотрудника с минимальной зарплатой по отделу.
    private static Employee getEmployeeWithMinSalary(int department) {
        Employee minEmployee = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department)
                continue;

            if (minEmployee == null || employee.getSalary() < minEmployee.getSalary())
                minEmployee = employee;
        }
        return minEmployee;
    }

    //    2. Сотрудника с максимальной зарплатой по отделу.
    private static Employee getEmployeeWithMaxSalary(int department) {
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department)
                continue;

            if (maxEmployee == null || employee.getSalary() > maxEmployee.getSalary())
                maxEmployee = employee;
        }
        return maxEmployee;
    }

    //    2. Сумму затрат на зарплату по отделу.
    private static int getSalarySum(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //    4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
    private static int getSalaryAverage(int department) {
        int sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }

        int average = 0;

        if (count > 0)
            average = sum / count;

        return average;
    }

    //    5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    private static void indexSalary(int department, int percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() * (1 + percent / 100f)));
            }
        }
    }

    //    6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
    private static void printAllEmployees(int department) {
        System.out.println("Сотрудники " + department + " отдела:");

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println("Employee{" +
                        "id=" + employee.getId() +
                        ", fullName='" + employee.getFullName() + '\'' +
                        ", salary=" + employee.getSalary() +
                        '}');
            }
        }
    }

    //    1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void printEmployeesWithSalaryLess(int salary) {
        System.out.println("Сотрудники с зарплатой меньше " + salary + ":");

        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println("Employee{" +
                        "fullName='" + employee.getFullName() + '\'' +
                        ", salary=" + employee.getSalary() +
                        '}');
            }
        }
    }

    //    2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void printEmployeesWithSalaryMore(int salary) {
        System.out.println("Сотрудники с зарплатой больше или равно " + salary + ":");

        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println("Employee{" +
                        "fullName='" + employee.getFullName() + '\'' +
                        ", salary=" + employee.getSalary() +
                        '}');
            }
        }
    }

}