package week4;

public class Quiz {
    private String[] questions = {
        "Ikan bernapas di air dengan…?",
        "Hewan apa yang paling pendiam?",
        "Makan duit rakyat disebut...?",
        "presiden pertama indonesia adalah?",
        "penemu radio adalah?",
        "penulis manga one piece adalah?",
        "Seorang pejabat akan terkena masalah kalau tersangkut…"
    };
    
    private String[][] options = {
        {"1. tenang", "2. paru-paru", "3. kulit", "4. bakar"},
        {"1. Harimau", "2. Semute", "3. Gajah", "4. Kucing"},
        {"1. Debus", "2. korupsi", "3. Meminjam", "4. pajak"},
        {"1.sokerano","2.Bj habibie","3.SBY","4.Megawati"},
        {"1.Gugielmo marconi","2.elon musk","3.Budi","4.Mark"},
        {"1.Oda","2.Oppeinheimer","3.nanang","4.Malif"},
        {"1.Kasus","2.Jemuran","3.berita","4.Megawati"}
    };
    
    private int[] correctAnswers = {1, 2, 3}; 
    private int score = 0;
    
   
    public int getQuestionCount() {
        return questions.length;
    }
    
    
    public void displayQuestion(int index) {
        System.out.println("\nPertanyaan " + (index + 1) + ": " + questions[index]);
        for (int j = 0; j < options[index].length; j++) {
            System.out.println(options[index][j]);
        }
    }
    
    public void checkAnswer(int index, int userAnswer) {
        if (userAnswer == correctAnswers[index]) {
            System.out.println("Benar!");
            score += 10;
        } else {
            System.out.println("Salah! Jawaban yang benar adalah: " + 
                options[index][correctAnswers[index] - 1]);
        }
    }
    
    // Method untuk mendapatkan skor
    public int getScore() {
        return score;
    }

    public int getFinalScore() {
        return score;
    }

    public int getTotalQuestions() {
        return questions.length; // Mengembalikan jumlah total pertanyaan
    }
}