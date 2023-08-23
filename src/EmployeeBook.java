import java.util.Objects;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    // Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
    public void addEmployee(String fullName, int department, int salary) {
        Employee employee = new Employee(fullName, department, salary);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return;
            }
        }
        System.out.println("В книге нет свободного места!");
    }

    // Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && Objects.equals(employees[i].getFullName(), fullName)) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудник не найден!");
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудник не найден!");
    }

    // Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
    public void changeEmployeeSalary(String fullName, int salary) {
        for (Employee employee : employees) {
            if (employee != null && Objects.equals(employee.getFullName(), fullName)) {
                employee.setSalary(salary);
                return;
            }
        }
        System.out.println("Сотрудник не найден!");
    }

    public void changeEmployeeDepartment(String fullName, int department) {
        for (Employee employee : employees) {
            if (employee != null && Objects.equals(employee.getFullName(), fullName)) {
                employee.setDepartment(department);
                return;
            }
        }
        System.out.println("Сотрудник не найден!");
    }

    // Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
    public void printAllEmployeesByDepartments() {
        for (int i = 1; i <= 5; i++) {
            printAllEmployees(i);
        }
    }

    //    1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //    2. Посчитать сумму затрат на зарплаты в месяц.
    public int getSalarySum() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    //    3. Найти сотрудника с минимальной зарплатой.
    public Employee getEmployeeWithMinSalary() {
        Employee minEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minEmployee.getSalary())
                minEmployee = employee;
        }
        return minEmployee;
    }

    //    4. Найти сотрудника с максимальной зарплатой.
    public Employee getEmployeeWithMaxSalary() {
        Employee maxEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxEmployee.getSalary())
                maxEmployee = employee;
        }
        return maxEmployee;
    }

    //    5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    public float getSalaryAverage() {
        float sum = getSalarySum();
        return sum / employees.length;
    }

    //    6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public void printAllEmployeesFullName() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    //    1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public void indexSalary(int percent) {
        for (Employee employee : employees) {
            employee.setSalary((int) (employee.getSalary() * (1 + percent / 100f)));
        }
    }

    //    1. Сотрудника с минимальной зарплатой по отделу.
    public Employee getEmployeeWithMinSalary(int department) {
        Employee minEmployee = null;
        for (Employee employee : employees) {
            if ((employee.getDepartment() == department) && (minEmployee == null || employee.getSalary() < minEmployee.getSalary())) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    //    2. Сотрудника с максимальной зарплатой по отделу.
    public Employee getEmployeeWithMaxSalary(int department) {
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if ((employee.getDepartment() == department) && (maxEmployee == null || employee.getSalary() > maxEmployee.getSalary())) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    //    2. Сумму затрат на зарплату по отделу.
    public int getSalarySum(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //    4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
    public float getSalaryAverage(int department) {
        float sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }

        float average = 0;

        if (count > 0)
            average = sum / count;

        return average;
    }

    //    5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    public void indexSalary(int department, int percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() * (1 + percent / 100f)));
            }
        }
    }

    //    6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void printAllEmployees(int department) {
        System.out.println("Сотрудники " + department + " отдела:");

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    //    1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void printEmployeesWithSalaryLess(int salary) {
        System.out.println("Сотрудники с зарплатой меньше " + salary + ":");

        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    //    2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void printEmployeesWithSalaryMore(int salary) {
        System.out.println("Сотрудники с зарплатой больше или равно " + salary + ":");

        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

}
