public class Converter {

    void convertStepsToKm(int totalStepsPerMonth) {
        double km = totalStepsPerMonth * 0.00075;
        System.out.println("Пройденная дистанция (в км): " + km);
    }

    void convertStepsToKcal(int totalStepsPerMonth) {
        int kcal = (int) (totalStepsPerMonth * 0.05);
        System.out.println("Количество сожженных килокалорий: " + kcal);
    }
}