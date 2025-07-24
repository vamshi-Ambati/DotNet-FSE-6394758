package myPackage;

public class FutureForcast {
    public double predictFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue; // Base case
        }
        return predictFutureValue(presentValue, rate, years - 1) * (1 + rate); 
    }
}
