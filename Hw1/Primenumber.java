package Hw1;
import java.util.Scanner;
// BAI 2
public class Primenumber {
  public static boolean isPrimeNumber(int a) {
        if (a <= 1) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(a);
        for (int i = 2; i <= squareRoot; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    System.out.println("\n\nNhap cac phan tu cho mang: ");
    n = sc.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
    }
    System.out.print("Cac so nguyen to trong cac so vua nhap la: ");
    for (int i = 1; i < n;i++) {
      if(isPrimeNumber(a[i])){
        System.out.print(a[i] + "\t");
      }
    }
    System.out.println("\n");
  }
}