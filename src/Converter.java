public class Converter {

    int lengthOfOneStep_cm = 75;
    int caloriesPerStep = 50;

    // метод конвертации
    // для дистанции использован double (в жизни пользователю важен каждый метр дистанции)
    void convert(int totalStepsPerMonth) {
        System.out.println("Пройденная дистанция (в км): " + (double) totalStepsPerMonth * lengthOfOneStep_cm / 100_000);
        System.out.println("Количество сожженных килокалорий: " + totalStepsPerMonth * caloriesPerStep / 1000);
    }
}