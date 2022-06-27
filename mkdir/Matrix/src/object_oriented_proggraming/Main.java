package object_oriented_proggraming;

import java.util.Random;

class Matrix {

    Random random = new Random();

    //return a random mXn matrix
    public int[][] random(int m, int n) {
        int[] c[] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = random.nextInt(100);
            }
        }
        return c;
    }

    public int[][] multiply(int[][] a, int[] b[]) {
        int mA = a.length;
        int nA = a[0].length;
        int mB = b.length;
        int nB = b[0].length;
        if (nA != mB) {
            throw new RuntimeException("Illegal matrix dimensions");
        }
        int c[][] = new int[mA][nB];
        for (int i = 0; i < mA; i++) {
            for (int j = 0; j < nB; j++) {
                for (int k = 0; k < nA; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    //addition
    public int[][] add(int a[][], int b[][]) {
        int mA = a.length;
        int nA = a[0].length;
        int c[][] = new int[mA][nA];
        for (int i = 0; i < mA; i++) {
            for (int j = 0; j < nA; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    //subtraction
    public int[][] subtract(int a[][], int b[][]) {
        int mA = a.length;
        int nA = a[0].length;
        int c[][] = new int[mA][nA];
        for (int i = 0; i < mA; i++) {
            for (int j = 0; j < nA; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    public void print(int x[][]) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[] a[] = matrix.random(5, 5);
        int[][] b = matrix.random(5, 5);
        int[][] multiply = matrix.multiply(a, b);
        System.out.println("Result # 1 : \n Matrix Multiplication ");
        matrix.print(multiply);
    }
}
