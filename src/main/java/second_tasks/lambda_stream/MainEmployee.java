package second_tasks.lambda_stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainEmployee {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Adilkhan", 21, 400000.0),
                new Employee("Robert", 40, 450000.0),
                new Employee("Max", 31, 250000.0)
        );

        // 1.	Фильтрация сотрудников старше 30 лет и вывод их на экран.
        employees.stream().filter(employee -> employee.getAge() > 30).forEach(System.out::println);

        // 2.	Подсчёт средней зарплаты среди всех сотрудников
        Double salaryEmployee = employees.stream().mapToDouble(Employee::getSalary).sum() / employees.size();

        // 3.	Вывод имён сотрудников, отсортированных по возрасту.
        employees.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);

        // 4.	Поиск сотрудника с самой высокой зарплатой.
        Optional<Employee> employee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(employee.get());

        // 5.	Преобразовать в Map<Double, String>, где ключ — salary, а значение — name.
        Map<Double, String> map = employees.stream().collect(Collectors.toMap(Employee::getSalary, Employee::getName));
    }
}
