package second_tasks.files_serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FileMain {

    public static final String PATH = "./text_files/users.txt";
    public static List<User> users = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int action = 0;

        while (action != 5) {

            System.out.println("""
                    Выберите действие (ввести номер цифры):
                    1.	Добавление пользователя (имя, возраст, email).
                    2.	Вывод всех пользователей из сохраненного файла.
                    3.	Сохранение списка пользователей в файл.
                    4.	Загрузка списка пользователей из файла.
                    5.  Выход.
                    """);
            action = Integer.parseInt(scanner.next());

            switch (action) {
                case 1 -> addUser();
                case 2 -> showAllUsers();
                case 3 -> addUserList();
                case 4 -> getAllUsers();
            }
        }

    }

    public static void addUser() {
        User user = new User();

        System.out.print("Введите имя: ");
        user.setName(scanner.next());
        System.out.print("Введите возраст: ");
        user.setAge(Integer.parseInt(scanner.next()));
        System.out.print("Введите почту: ");
        user.setEmail(scanner.next());

        users.add(user);

        System.out.println("Пользователь добавлен");
    }

    public static void addUserList(){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Пользователи успешно добавлены");
    }

    public static Optional<List<User>> getAllUsers() {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH))) {
            List<User> users = (List<User>) objectInputStream.readObject();
            System.out.println("Выгрузка завершена");
            return Optional.of(users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }

    }

    public static void showAllUsers() {

        Optional<List<User>> users = getAllUsers();

        if(users.isPresent()){
            users.get().forEach(System.out::println);
        } else {
            System.out.println("Пользователи отсутствуют или не были сохранены в файл");
        }
    }


}
