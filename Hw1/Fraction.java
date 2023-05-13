package Hw1;
import java.util.Scanner;

public class Fraction{

    private int numerator;
    private int denominator;


    public Fraction(Fraction another) {
        this.numerator = another.numerator;
        this.denominator = another.denominator;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public boolean equals(Fraction other) {
        return (double) this.numerator * other.denominator == (double) other.numerator / this.denominator;
    }

    private static int gcd(int m, int n) {
        if (Math.max(m, n) % Math.min(m, n) == 0) return Math.min(m, n);
        return gcd(Math.min(m, n), Math.max(m, n) % Math.min(m, n));
    }

    private Fraction simplify() {
        return new Fraction(numerator / gcd(numerator, denominator), denominator / gcd(numerator, denominator));
    }

    public Fraction add(Fraction other) {
        int lcm = denominator * other.getDenominator() / gcd(denominator, other.getDenominator());
        int newNumerator = this.numerator * (lcm / denominator) + other.getNumerator() * (lcm / other.getDenominator());
        return new Fraction(newNumerator, lcm);
    }

    public Fraction subtract(Fraction other) {
        int lcm = denominator * other.getDenominator() / gcd(denominator, other.getDenominator());
        int newNumerator = this.numerator * (lcm / denominator) - other.getNumerator() * (lcm / other.getDenominator());
        return new Fraction(newNumerator, lcm);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(other.getNumerator() * this.getNumerator(), other.getDenominator() * this.getDenominator());
    }

    public Fraction divide(Fraction other) {
        return new Fraction(other.getDenominator() * this.getNumerator(), other.getNumerator() * this.getDenominator());

    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fraction A: ");
        String[] intFractionA = scanner.nextLine().split("/");
        Fraction fractionA = new Fraction(Integer.parseInt(intFractionA[0]), Integer.parseInt(intFractionA[1]));
        System.out.println("Enter fraction B: ");
        String[] intFractionB = scanner.nextLine().split("/");
        Fraction fractionB = new Fraction(Integer.parseInt(intFractionB[0]), Integer.parseInt(intFractionB[1]));
        System.out.println("A + B = " + fractionA.add(fractionB).toString());
        System.out.println("A - B = " + fractionA.subtract(fractionB).toString());
        System.out.println("A * B = " + fractionA.multiply(fractionB).simplify().toString());
        System.out.println("A / B = " + fractionA.divide(fractionB).toString());
    }
}