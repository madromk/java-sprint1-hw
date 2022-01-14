import java.util.HashMap;

public class StepTracker {
    int targetSteps = 10000;
    int daysOfMonth = 30;
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

    void MonthData (String nameMonth, int dayMonth, int stepsDay) { //Сохранение введенных данных пользователем
        int[] allSteps = monthToData.get(nameMonth);
        allSteps[(dayMonth)-1] = stepsDay;
        System.out.println("Данные сохранены");
    }

    void printStepsByMonth (String nameMonth) { //Выводим статистику за месяц день = шаги
        if(monthToData.containsKey(nameMonth)) {
            int[] currentMonth = monthToData.get(nameMonth);
            for (int i = 0; i < currentMonth.length; i++) {
                System.out.println((i + 1) + " день: " + currentMonth[i]);
            }
        } else {
            System.out.println("Неверный формат введенных данных. Повторите попытку");
        }
    }

    int getSumStepsOfMonth (String nameMonth) { //Получение суммы шагов за месяц для метода sumStepsMonth и класса Converter
        int sum = 0;
        int[] sumSteps = monthToData.get(nameMonth);
        for (Integer steps : sumSteps) {
            sum += steps;
        }
        return sum;
    }

    void printStepsStat (String nameMonth) { // Выводим статистику по сумме шагов за месяц
        int sum = getSumStepsOfMonth(nameMonth);
        int[] sumSteps = monthToData.get(nameMonth);
        System.out.println("За выбранный месяц в сумме вы прошли " + sum + " шагов");
        System.out.println("В среднем количество шагов за месяц составило " + (sum / sumSteps.length));
    }

    void printBestSeries (String nameMonth) { //Лучшая серия по шагам
        int currentSeries = 0;
        int maxSeries = 0;
        int[] monthsteps = monthToData.get(nameMonth);
        for (int i : monthsteps) {
           if(i >= targetSteps) {
               currentSeries++;
            } else {
               if (currentSeries > maxSeries) {
                   maxSeries = currentSeries;
               }
                currentSeries = 0;
           }
       }
        System.out.println("В выбранном месяца лучшая серия, где кол-во шагов было " +
                "больше или равно вашей цели составила " + maxSeries +" дней");
    }

    void setTarget(int target) { //Изменение цели по кол-ву шагов в день
        this.targetSteps = target;
    }

}




