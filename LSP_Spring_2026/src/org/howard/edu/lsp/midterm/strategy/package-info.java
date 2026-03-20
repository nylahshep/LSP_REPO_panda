package org.howard.edu.lsp.midterm.strategy;

/**
 * All-in-one Strategy Pattern demonstration.
 */
public class Driver {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        // REGULAR customer
        calculator.setStrategy(new RegularDiscount());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        // MEMBER customer
        calculator.setStrategy(new MemberDiscount());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        // VIP customer
        calculator.setStrategy(new VIPDiscount());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        // HOLIDAY customer
        calculator.setStrategy(new HolidayDiscount());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }

    // ======= Strategy Interface =======
    interface PriceStrategy {
        double calculate(double price);
    }

    // ======= Concrete Strategies =======
    static class RegularDiscount implements PriceStrategy {
        @Override
        public double calculate(double price) {
            return price;
        }
    }

    static class MemberDiscount implements PriceStrategy {
        @Override
        public double calculate(double price) {
            return price * 0.9;
        }
    }

    static class VIPDiscount implements PriceStrategy {
        @Override
        public double calculate(double price) {
            return price * 0.8;
        }
    }

    static class HolidayDiscount implements PriceStrategy {
        @Override
        public double calculate(double price) {
            return price * 0.85;
        }
    }

    // ======= Context =======
    static class PriceCalculator {
        private PriceStrategy strategy;

        public void setStrategy(PriceStrategy strategy) {
            this.strategy = strategy;
        }

        public double calculatePrice(double price) {
            if (strategy == null) throw new IllegalStateException("Strategy not set");
            return strategy.calculate(price);
        }
    }
}