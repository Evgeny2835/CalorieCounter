public class Converter {

    double convertStepsToKm(int totalStepsPerMonth) {
        return totalStepsPerMonth * 0.00075;
    }

    int convertStepsToKcal(int totalStepsPerMonth) {
        return (int) (totalStepsPerMonth * 0.05);
    }
}