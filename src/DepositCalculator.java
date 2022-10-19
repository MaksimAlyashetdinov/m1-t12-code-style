import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {

    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return makeCalculation(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount + amount * yearRate * depositPeriod;
        return makeCalculation(pay, 2);
    }

    double makeCalculation(double pay, int places) {
        double scale = Math.pow(10, places);
        return Math.round(pay * scale) / scale;
    }

    void makeContribution() {
        int depositPeriod;
        int command;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        command = scanner.nextInt();

        double amountWithPercent = 0;

        if (command == 1) {
            amountWithPercent = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (command == 2) {
            amountWithPercent = calculateComplexPercent(amount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + amountWithPercent);
    }
}
