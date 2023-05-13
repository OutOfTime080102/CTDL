package Hw1;
import java.util.Scanner;
// BAI 1
public class Perfectnumber {
  public static boolean Perfect(int a){
    int sum = 0;
    for(int i=1;i<=a/2;i++){
      if(a%i==0) 
        sum+=i;
    }
    if(sum==a)return true;
    return false;
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
    System.out.print("Cac so hoan hao trong cac so vua nhap la: ");
    for (int i = 1; i < n;i++) {
      if(Perfect(a[i])){
        System.out.print(a[i] + "\t");
      }
    }
    System.out.println("\n");
  }
}