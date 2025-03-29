// Latihan 1: Class Array1 hasil modifikasi dari SingleArray
package week4;     
public class Latihan1 {
    public static void main(String[] args) {
        int[] angka = {5, 6, 7, 8, 9};
        Array1 array = new Array1(angka);
        array.tampilkanData();
        array.hitungHasil();
    }
}
class Array1 {
    private int[] data;
    
    public Array1(int[] data) {
        this.data = data;
    }
    
    public void tampilkanData() {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Data ke-" + i + " = " + data[i]);
        }
    }
    
    public void hitungHasil() {
        for (int i = 0; i < data.length - 1; i++) {
            System.out.println("Hasil nilai[" + i + "] * nilai[" + (i+1) + "] = " + (data[i] * data[i+1]));
        }
    }
}
