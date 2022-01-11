import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    int targetNumberOfSteps = 10000;                                // целевое количество шагов

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }
    static class MonthData {
        Integer[] daysOfMonth = new Integer[30];
        MonthData() {
            for (int i = 0; i < 30; i++) {
                daysOfMonth[i] = 0;
            }
        }

        // метод сохранения значений в массиве (число шагов в определенный день)
        void setTheNumberOfSteps(int dayOfTrackingSteps, int numberOfStepsPerDay) {
            daysOfMonth[dayOfTrackingSteps - 1] = numberOfStepsPerDay;
            System.out.println("Данные сохранены");
        }
    }

    // метод изменения целевого количества шагов
    void setTargetNumberOfSteps(int newTargetNumberOfSteps) {
        targetNumberOfSteps = newTargetNumberOfSteps;
        System.out.println("Изменения сохранены: " + targetNumberOfSteps);
    }

    // единый метод рассчета статистики
    void printMonthlyStepStatistics(int monthOfTrackingSteps) {
        System.out.println("Статистика за " + monthOfTrackingSteps + " месяц");
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < 30; i++) {
            if (i !=29) {
                System.out.print((i + 1) + " день: " + monthToData.get(monthOfTrackingSteps - 1)
                                                                  .daysOfMonth[i] + ", ");
            } else {
                System.out.println((i + 1) + " день: " + monthToData.get(monthOfTrackingSteps - 1)
                                                                    .daysOfMonth[i]);
            }
        }

        // далее рассчет и вывод 3 статистических показателей
        // используется 1 перебор элементов массива для всех показателей
        int totalStepsPerMonth = 0;                     // для  "Общее количество шагов"
        int maxNumberOfStepsPerDay = 0;                 // для "Максимальное количество пройденных шагов"
        int currentSeriesOfSteps = 0;                   // для лучшей серии
        int maxSeriesOfSteps = 0;                       // для лучшей серии
        for(Integer exp : monthToData.get(monthOfTrackingSteps - 1).daysOfMonth) {
            totalStepsPerMonth += exp;                  // для  "Общее количество шагов"
            if(exp > maxNumberOfStepsPerDay) {          // для "Максимальное количество пройденных шагов"
                maxNumberOfStepsPerDay = exp;
            }
            if (exp > targetNumberOfSteps) {            // для лучшей серии (с продолжением после цикла)
                currentSeriesOfSteps++;
            } else {
                if (currentSeriesOfSteps > maxSeriesOfSteps) {
                    maxSeriesOfSteps = currentSeriesOfSteps;
                }
                currentSeriesOfSteps = 0;
            }
        }
        if (currentSeriesOfSteps > maxSeriesOfSteps) {    // продолжение после цикла для лучшей серии
            maxSeriesOfSteps = currentSeriesOfSteps;
        }
        System.out.println("Общее количество шагов: " + totalStepsPerMonth);
        System.out.println("Максимальное количество пройденных шагов: " + maxNumberOfStepsPerDay);
        System.out.println("Среднее количество шагов: " + totalStepsPerMonth / 30);
        Converter converter = new Converter();            // для вызова методов конвертации
        converter.convertStepsToKm(totalStepsPerMonth);
        converter.convertStepsToKcal(totalStepsPerMonth);
        System.out.println("Лучшая серия (максимальное количество подряд идущих дней, в течение которых" +
                " количество шагов за день было выше целевого): " + maxSeriesOfSteps);
    }
}
