import java.util.HashMap;

public class StepTracker {
    int targetSteps = 10000;
    final int daysOfMonth = 30;
    HashMap<String, int[]> monthToData;

    StepTracker() {
        monthToData = new HashMap<>();
        monthToData.put("Январь", new int[this.daysOfMonth]);
        monthToData.put("Февраль", new int[this.daysOfMonth]);
        monthToData.put("Март", new int[this.daysOfMonth]);
        monthToData.put("Апрель", new int[this.daysOfMonth]);
        monthToData.put("Май", new int[this.daysOfMonth]);
        monthToData.put("Июнь", new int[this.daysOfMonth]);
        monthToData.put("Июль", new int[this.daysOfMonth]);
        monthToData.put("Август", new int[this.daysOfMonth]);
        monthToData.put("Сентябрь", new int[this.daysOfMonth]);
        monthToData.put("Октябрь", new int[this.daysOfMonth]);
        monthToData.put("Ноябрь", new int[this.daysOfMonth]);
        monthToData.put("Декабрь", new int[this.daysOfMonth]);
    }

    //Сохранение введенных данных пользователем
    void MonthData(String nameMonth, int dayMonth, int stepsDay) {
        if (monthToData.containsKey(nameMonth) && dayMonth < 31 && stepsDay > 0) {
            int[] allSteps = monthToData.get(nameMonth);
            allSteps[(dayMonth) - 1] = stepsDay;
            System.out.println("Данные сохранены");
        } else {
            System.out.println("Неверный формат введенных данных. Повторите попытку");
        }
    }

    //Выводим статистику за месяц день = шаги
    void printStepsByMonth(String nameMonth) {
        if (monthToData.containsKey(nameMonth)) {
            int[] currentMonth = monthToData.get(nameMonth);
            for (int i = 0; i < currentMonth.length; i++) {
                System.out.println((i + 1) + " день: " + currentMonth[i]);
            }
        } else {
            System.out.println("Неверный формат введенных данных. Повторите попытку");
        }
    }

    //Получение суммы шагов за месяц для метода sumStepsMonth и класса Converter
    int getSumStepsOfMonth(String nameMonth) {
        int sum = 0;
        int[] sumSteps = monthToData.get(nameMonth);
        for (Integer steps : sumSteps) {
            sum += steps;
        }
        return sum;
    }

    // Выводим статистику по сумме шагов за месяц
    void printStepsStat(String nameMonth) {
        int sum = getSumStepsOfMonth(nameMonth);
        int[] sumSteps = monthToData.get(nameMonth);
        double meanSteps = (double) sum / sumSteps.length;
        String resultMeanSteps = String.format("%.2f", meanSteps);
        System.out.println("За выбранный месяц в сумме вы прошли " + sum + " шагов");
        System.out.println("В среднем количество шагов за месяц составило " + resultMeanSteps);
    }

    //Лучшая серия по шагам
    void printBestSeries(String nameMonth) {
        int currentSeries = 0;
        int maxSeries = 0;
        int[] monthSteps = monthToData.get(nameMonth);
        for (int i : monthSteps) {
            if (i >= targetSteps) {
                currentSeries++;
                if (currentSeries > maxSeries) {
                    maxSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        System.out.println("В выбранном месяца лучшая серия, где кол-во шагов было " +
                "больше или равно вашей цели составила " + maxSeries + " дней");
    }

    //Изменение цели по кол-ву шагов в день
    void setTarget(int target) {
        this.targetSteps = target;
    }

}




