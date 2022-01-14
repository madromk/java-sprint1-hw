
public class Converter {
    double stepKm = 0.00075; // Перевод 75 см в км
    double stepCal = 50;
    double kCal = 1000;

    void printDistanceAndCalories(String nameMonth, StepTracker stepTracker) {
        int sum = stepTracker.getSumStepsOfMonth(nameMonth);
        double distanceKm = sum * stepKm;
        double stepsKCal = sum * stepCal / kCal;
        String resultKm = String.format("%.2f",distanceKm);
        String resultCl = String.format("%.2f",stepsKCal);
        System.out.println("За месяц вы прошли " + resultKm + " км");
        System.out.println("За месяц вы сожгли " + resultCl + " килокалорий");
    }

}
