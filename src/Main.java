import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userinput = scanner.nextInt();

        StepTracker stepTracker = new StepTracker();

        while (userinput != 0) {
            if (userinput == 1) {
                System.out.println("Введите месяц (1-12)");
                int monthOfTrackingSteps = scanner.nextInt();
                System.out.println("Введите день (1-30)");
                int dayOfTrackingSteps = scanner.nextInt();
                System.out.println("Введите количество пройденных шагов за день");
                int numberOfStepsPerDay = scanner.nextInt();
                if (numberOfStepsPerDay < 0) {
                    System.out.println("Извините, введено некорректное значение (отрицательное)");
                    continue;
                }
                stepTracker.monthToData
                           .get(monthOfTrackingSteps - 1)
                           .setTheNumberOfSteps(dayOfTrackingSteps, numberOfStepsPerDay);
            } else if (userinput == 2) {
                System.out.println("Введите месяц (1-12)");
                int monthOfTrackingSteps = scanner.nextInt();
                stepTracker.printMonthlyStepStatistics(monthOfTrackingSteps);
            } else if (userinput == 3) {
                System.out.println("Текущее целевое значение: " + stepTracker.targetNumberOfSteps);
                System.out.println("Введите новое целевое значение");
                int newTargetNumberOfSteps = scanner.nextInt();
                if (newTargetNumberOfSteps < 0) {
                    System.out.println("Извините, введено некорректное значение (отрицательное)");
                    continue;
                }
                stepTracker.setTargetNumberOfSteps(newTargetNumberOfSteps);
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu();
            userinput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}