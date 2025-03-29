package week4;

import java.util.ArrayList;
import java.util.Scanner;

public class Latihan4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Pilih program:");
        System.out.println("1. Operasi ArrayList");
        System.out.println("2. Operasi Matriks");
        System.out.print("Masukkan pilihan (1-2): ");
        int pilihan = scanner.nextInt();
        
        if (pilihan == 1) {
            operasiArrayList();
        } else if (pilihan == 2) {
            operasiMatriks();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        
        scanner.close();
    }
    
    public static void operasiArrayList() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> nilai1 = new ArrayList<>();
        ArrayList<Integer> nilai2 = new ArrayList<>();
        ArrayList<Integer> hasilJumlah = new ArrayList<>();
        ArrayList<Integer> hasilKurang = new ArrayList<>();
        ArrayList<Integer> hasilKali = new ArrayList<>();
        ArrayList<Double> hasilBagi = new ArrayList<>();

        System.out.print("Masukkan jumlah data: ");
        int jumlahData = scanner.nextInt();
        
        System.out.println("Masukkan nilai pertama:");
        for (int i = 0; i < jumlahData; i++) {
            System.out.print("Data ke-" + (i + 1) + ": ");
            nilai1.add(scanner.nextInt());
        }
        
        System.out.println("Masukkan nilai kedua:");
        for (int i = 0; i < jumlahData; i++) {
            System.out.print("Data ke-" + (i + 1) + ": ");
            nilai2.add(scanner.nextInt());
        }
        
        for (int i = 0; i < jumlahData; i++) {
            hasilJumlah.add(nilai1.get(i) + nilai2.get(i));
            hasilKurang.add(nilai1.get(i) - nilai2.get(i));
            hasilKali.add(nilai1.get(i) * nilai2.get(i));
            hasilBagi.add(nilai2.get(i) != 0 ? (double) nilai1.get(i) / nilai2.get(i) : 0);
        }

        System.out.println("Hasil Penjumlahan: " + hasilJumlah);
        System.out.println("Hasil Pengurangan: " + hasilKurang);
        System.out.println("Hasil Perkalian  : " + hasilKali);
        System.out.println("Hasil Pembagian  : " + hasilBagi);
        
        scanner.close();
    }
    
    public static void operasiMatriks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris matriks: ");
        int rows = scanner.nextInt();
        System.out.print("Masukkan jumlah kolom matriks: ");
        int cols = scanner.nextInt();

        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];
        int[][] result = new int[rows][cols];

        System.out.println("Masukkan elemen matriks A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Masukkan elemen matriks B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                matrixB[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Pilih operasi: \n1. Penjumlahan \n2. Perkalian");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Hasil Penjumlahan Matriks:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = matrixA[i][j] + matrixB[i][j];
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else if (choice == 2) {
            System.out.println("Hasil Perkalian Matriks:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < cols; k++) {
                        result[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}