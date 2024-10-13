import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Scanner позволяет считывать строки или числа
        int result = 0; // Переменная для хранения результата
        boolean firstOperation = true; // Проверка первой операции

        System.out.println("Калькулятор!");
        while (true) {
            if (firstOperation) {
                System.out.println("Введите первое число (или 's' для выхода): ");
                if (scanner.hasNextInt()) {
                    result = scanner.nextInt(); // Считываем первое число
                } else {
                    String input = scanner.next();
                    if (input.equalsIgnoreCase("s")) {
                        break; // Выход из программы
                    } else if (input.equalsIgnoreCase("C")) {
                        result = 0; // Сброс результата
                        System.out.println("Результат сброшен.");
                        continue; // Пропускаем итерацию
                    }
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    continue; // Пропускаем итерацию
                }
                firstOperation = false; // Устанавливаем флаг на false после первой операции
            }

            System.out.println("Введите действие (+, -, *, /) или 'C' для сброса результата: ");
            char operation = scanner.next().charAt(0); // Считываем оператор

            if (operation == 'C' || operation == 'c') {
                result = 0; // Сброс результата
                System.out.println("Результат сброшен.");
                firstOperation = true; // Возвращаемся к началу
                continue; // Пропускаем итерацию
            }

            System.out.println("Введите второе число: ");
            if (scanner.hasNextInt()) {
                int operand2 = scanner.nextInt(); // Считываем второе число

                switch (operation) {
                    case '+':
                        result += operand2; // Сложение с результатом
                        break;
                    case '-':
                        result -= operand2; // Вычитание из результата
                        break;
                    case '*':
                        result *= operand2; // Умножение результата
                        break;
                    case '/':
                        if (operand2 == 0) {
                            System.out.println("Ошибка: Деление на ноль.");
                            continue; // Пропускаем итерацию в случае ошибки
                        } else {
                            result /= operand2; // Деление результата
                        }
                        break;
                    default:
                        System.out.println("Некорректное действие. Попробуйте снова.");
                        continue; // Пропускаем итерацию
                }

                System.out.println("Результат: " + result); // Выводим текущий результат
            } else {
                System.out.println("Некорректный ввод. Попробуйте снова.");
                scanner.next(); // Очищаем неправильный ввод
            }
        }

        scanner.close();
        System.out.println("Калькулятор закрыт!.");

    }
}