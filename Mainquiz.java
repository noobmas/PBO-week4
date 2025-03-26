package week4;

import java.util.Scanner;

public class Mainquiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz;

        System.out.println("Selamat datang di kuis Pengetahuan Umum!");

        boolean playAgain;
        do {
            quiz = new Quiz(); 
            System.out.println("Jawab semua pertanyaan dengan memilih nomor opsi");

            // Looping untuk setiap pertanyaan
            int totalQuestions = quiz.getTotalQuestions();
            for (int i = 0; i < totalQuestions; i++) {
                quiz.displayQuestion(i);
                System.out.print("Jawaban Anda: ");
                int userAnswer = scanner.nextInt(); // Membaca jawaban pengguna
                quiz.checkAnswer(i, userAnswer); // Memeriksa jawaban
            }

            // Tampilkan skor akhir
            System.out.println("Skor akhir Anda adalah: " + quiz.getFinalScore());

            // Kondisional untuk pesan berdasarkan skor
            int finalScore = quiz.getFinalScore();
            if (finalScore == 3) {
                System.out.println("Luar biasa! Anda menjawab semua pertanyaan dengan benar!");
            } else if (finalScore == 2) {
                System.out.println("Bagus! Anda hampir sempurna.");
            } else if (finalScore == 1) {
                System.out.println("Cukup baik, tetapi Anda bisa lebih baik lagi.");
            } else {
                System.out.println("Jangan menyerah! Cobalah lagi untuk meningkatkan skor Anda.");
            }

            // Menanyakan apakah pengguna ingin bermain lagi
            System.out.print("Apakah Anda ingin bermain lagi? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        } while (playAgain);

        System.out.println("Terima kasih telah bermain!");
    }
}