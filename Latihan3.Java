package week4;

import java.util.Arrays;
import java.util.Scanner;

public class Latihan3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ulangiProgram = true;
        
        System.out.println("PROGRAM SORTING DALAM JAVA");
        System.out.println("==========================");
        
        while (ulangiProgram) {
            // Meminta input dari pengguna
            System.out.print("\nMasukkan angka-angka (pisahkan dengan spasi): ");
            String input = scanner.nextLine();
            
            // Mengubah input string menjadi array integer
            String[] stringArray = input.split(" ");
            int[] arr = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                arr[i] = Integer.parseInt(stringArray[i]);
            }
            
            System.out.println("\nArray awal: " + Arrays.toString(arr));
            
            // Menampilkan menu pilihan sorting
            System.out.println("\nPilih algoritma sorting:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Semua Algoritma");
            System.out.print("Masukkan pilihan (1-6): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline
            
            switch(pilihan) {
                case 1:
                    System.out.println("\n=== BUBBLE SORT ===");
                    bubbleSort(Arrays.copyOf(arr, arr.length));
                    break;
                case 2:
                    System.out.println("\n=== INSERTION SORT ===");
                    insertionSort(Arrays.copyOf(arr, arr.length));
                    break;
                case 3:
                    System.out.println("\n=== SELECTION SORT ===");
                    selectionSort(Arrays.copyOf(arr, arr.length));
                    break;
                case 4:
                    System.out.println("\n=== MERGE SORT ===");
                    mergeSort(Arrays.copyOf(arr, arr.length));
                    break;
                case 5:
                    System.out.println("\n=== QUICK SORT ===");
                    quickSort(Arrays.copyOf(arr, arr.length));
                    break;
                case 6:
                    System.out.println("\n=== SEMUA ALGORITMA SORTING ===");
                    System.out.println("\n1. BUBBLE SORT:");
                    bubbleSort(Arrays.copyOf(arr, arr.length));
                    
                    System.out.println("\n2. INSERTION SORT:");
                    insertionSort(Arrays.copyOf(arr, arr.length));
                    
                    System.out.println("\n3. SELECTION SORT:");
                    selectionSort(Arrays.copyOf(arr, arr.length));
                    
                    System.out.println("\n4. MERGE SORT:");
                    mergeSort(Arrays.copyOf(arr, arr.length));
                    
                    System.out.println("\n5. QUICK SORT:");
                    quickSort(Arrays.copyOf(arr, arr.length));
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            
            // Meminta input apakah ingin mengulang program
            System.out.print("\nApakah Anda ingin mengulang program? (ya/tidak): ");
            String jawaban = scanner.nextLine();
            
            if (!jawaban.equalsIgnoreCase("ya")) {
                ulangiProgram = false;
                System.out.println("\nTerima kasih telah menggunakan program sorting!");
            }
        }
        
        scanner.close();
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        System.out.println("Proses Bubble Sort:");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\nIterasi ke-" + (i + 1) + ":");
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Tukar arr[j] dan arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    // Cetak perubahan
                    System.out.println("Tukar " + arr[j + 1] + " dan " + arr[j] + 
                                      " -> " + Arrays.toString(arr));
                }
            }
        }
        System.out.println("\nHasil akhir Bubble Sort: " + Arrays.toString(arr));
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        System.out.println("Proses Insertion Sort:");
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            System.out.println("\nIterasi ke-" + i + ":");
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                
                // Cetak perubahan setelah pergeseran
                System.out.println("Geser " + arr[j + 1] + " ke kanan -> " + Arrays.toString(arr));
            }
            arr[j + 1] = key;
            
            // Cetak perubahan setelah insert
            if (j + 1 != i) {
                System.out.println("Insert " + key + " pada posisi " + (j + 1) + 
                                 " -> " + Arrays.toString(arr));
            }
        }
        System.out.println("\nHasil akhir Insertion Sort: " + Arrays.toString(arr));
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        System.out.println("Proses Selection Sort:");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\nIterasi ke-" + (i + 1) + ":");
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            // Tukar elemen terkecil dengan elemen pertama
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
                
                // Cetak perubahan
                System.out.println("Tukar " + arr[minIdx] + " dan " + arr[i] + 
                                  " -> " + Arrays.toString(arr));
            }
        }
        System.out.println("\nHasil akhir Selection Sort: " + Arrays.toString(arr));
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        System.out.println("Proses Merge Sort:");
        mergeSortHelper(arr, 0, arr.length - 1);
        System.out.println("\nHasil akhir Merge Sort: " + Arrays.toString(arr));
    }

    private static void mergeSortHelper(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            
            mergeSortHelper(arr, l, m);
            mergeSortHelper(arr, m + 1, r);
            
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        System.out.println("\nMenggabungkan subarray " + Arrays.toString(Arrays.copyOfRange(arr, l, m + 1)) + 
                         " dan " + Arrays.toString(Arrays.copyOfRange(arr, m + 1, r + 1)));
        
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = l;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        
        // Cetak perubahan setelah merge
        System.out.println("Hasil penggabungan: " + Arrays.toString(arr));
    }

    // Quick Sort
    public static void quickSort(int[] arr) {
        System.out.println("Proses Quick Sort:");
        quickSortHelper(arr, 0, arr.length - 1);
        System.out.println("\nHasil akhir Quick Sort: " + Arrays.toString(arr));
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        System.out.println("\nPartisi dengan pivot " + pivot + 
                         " pada subarray " + Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)));
        
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                
                // Tukar arr[i] dan arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                // Cetak perubahan jika ada swap
                if (i != j) {
                    System.out.println("Tukar " + arr[j] + " dan " + arr[i] + 
                                      " -> " + Arrays.toString(arr));
                }
            }
        }
        
        // Tukar arr[i+1] dan arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        // Cetak perubahan
        if (i + 1 != high) {
            System.out.println("Posisi pivot akhir: " + arr[i + 1] + 
                             " pada indeks " + (i + 1) + 
                             " -> " + Arrays.toString(arr));
        }
        
        return i + 1;
    }
}