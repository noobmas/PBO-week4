package week4;

import java.util.Scanner;

public class KuisUtama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Kuis kuis;

        System.out.println("Selamat datang di Kuis Pengetahuan Umum!");

        boolean mainLagi;
        do {
            kuis = new Kuis(); 
            System.out.println("Jawab semua pertanyaan dengan memilih nomor opsi");

            // Looping untuk setiap pertanyaan
            int totalPertanyaan = kuis.dapatkanTotalPertanyaan();
            for (int i = 0; i < totalPertanyaan; i++) {
                kuis.tampilkanPertanyaan(i);
                System.out.print("Jawaban Anda: ");
                int jawabanPengguna = input.nextInt(); // Membaca jawaban pengguna
                kuis.periksaJawaban(i, jawabanPengguna); // Memeriksa jawaban
            }

            // Tampilkan skor akhir
            System.out.println("Skor akhir Anda adalah: " + kuis.dapatkanSkorAkhir());

            // Pesan berdasarkan skor
            int skorAkhir = kuis.dapatkanSkorAkhir();
            if (skorAkhir == 70) {  // Jika semua benar (7 pertanyaan x 10 poin)
                System.out.println("Luar biasa! Anda menjawab semua pertanyaan dengan benar!");
            } else if (skorAkhir >= 50) {
                System.out.println("Bagus! Anda hampir sempurna.");
            } else if (skorAkhir >= 30) {
                System.out.println("Cukup baik, tetapi Anda bisa lebih baik lagi.");
            } else {
                System.out.println("Jangan menyerah! Cobalah lagi untuk meningkatkan skor Anda.");
            }

            // Menanyakan apakah pengguna ingin bermain lagi
            System.out.print("Apakah Anda ingin bermain lagi? (y/n): ");
            String respon = input.next();
            mainLagi = respon.equalsIgnoreCase("y");
        } while (mainLagi);

        System.out.println("Terima kasih telah bermain!");
        input.close();
    }
}