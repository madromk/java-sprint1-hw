import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();


        while (true) {
        printMenu();
        int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Введите название месяца:");
                String nameMonth = scanner.next();
                System.out.println("Введите день месяца:");
                int dayMonth = scanner.nextInt();
                System.out.println("Введите количество шагов:");
                int stepsDay = scanner.nextInt();
                    if(stepTracker.monthToData.containsKey(nameMonth) && dayMonth < 31 && stepsDay > 0) {
                        stepTracker.MonthData(nameMonth, dayMonth, stepsDay);
                    } else {
                        System.out.println("Неверный формат введенных данных. Повторите попытку");
                    }
            } else if (command == 2) {
                System.out.println("За какой месяц вы хотите получить статистику ?");
                String nameMonth =scanner.next();
                    if(stepTracker.monthToData.containsKey(nameMonth)) {
                        stepTracker.statMonthDays(nameMonth);
                        stepTracker.sumStepsMonth(nameMonth);
                        converter.distanceCalories(nameMonth, stepTracker);
                        stepTracker.bestSeries(nameMonth);
                    } else {
                        System.out.println("Неверный формат введенных данных. Повторите попытку");
                    }
            } else if (command == 3) {
                System.out.println("Введите новую цель:");
                int target = scanner.nextInt();
                stepTracker.setTarget(target);
                System.out.println("Цель сохранена");
            } else if (command == 0) {
                System.out.println("Приложение закрыто");
                break;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }
    public static void printMenu() {
        System.out.println("Добро пожаловать в Счётчик калорий. Выберете команду для продолжения:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}

