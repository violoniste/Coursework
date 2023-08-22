public class Main {

    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        book.addEmployee("Иван Иванович Иванов", 1, 5000);
        book.addEmployee("Василий Петрович Сидоров", 4, 2000);
        book.addEmployee("Михаил Васильевич Петров", 3, 7000);
        book.addEmployee("Клубника Николаевна Иванова", 2, 7000);
        book.addEmployee("Вишня Владимировна Петрова", 3, 4000);
        book.addEmployee("Курага Петровна Сидорова", 2, 8000);
        book.addEmployee("Чернослив Михайлович Иванов", 1, 5000);
        book.addEmployee("Миндаль Иванович Зарецкий", 5, 3000);
        book.addEmployee("Фундук Петрович Задорожный", 2, 7000);
        book.addEmployee("Вальдемар Иванович Романовский", 1, 300000);

        book.printEmployeesWithSalaryMore(2000);
    }

}