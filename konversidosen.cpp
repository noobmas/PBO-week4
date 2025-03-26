#include <iostream>
#include <cmath>
#include <string>
#include <iomanip>
using namespace std;

// Fungsi untuk konversi hexadesimal ke desimal
int hexKeDesimal(string hex) {
    int desimal = 0;
    for(int i = 0; i < hex.length(); i++) {
        char c = hex[i];
        int digit;
        if(c >= '0' && c <= '9') digit = c - '0';
        else if(c >= 'A' && c <= 'F') digit = c - 'A' + 10;
        else if(c >= 'a' && c <= 'f') digit = c - 'a' + 10;
        desimal = desimal * 16 + digit;
    }
    return desimal;
}

// Fungsi untuk konversi desimal ke hexadesimal
string desimalKeHex(int desimal) {
    if(desimal == 0) return "0";
    string hex = "";
    while(desimal > 0) {
        int sisa = desimal % 16;
        char digit;
        if(sisa < 10) digit = sisa + '0';
        else digit = (sisa - 10) + 'A';
        hex = digit + hex;
        desimal /= 16;
    }
    return hex;
}

// Fungsi untuk konversi biner ke desimal
int binerKeDesimal(string biner) {
    int desimal = 0;
    int pangkat = 0;
    for(int i = biner.length()-1; i >= 0; i--) {
        if(biner[i] == '1') desimal += pow(2, pangkat);
        pangkat++;
    }
    return desimal;
}

// Fungsi untuk konversi desimal ke biner
string desimalKeBiner(int desimal) {
    if(desimal == 0) return "0";
    string biner = "";
    while(desimal > 0) {
        biner = to_string(desimal % 2) + biner;
        desimal /= 2;
    }
    return biner;
}

// Fungsi untuk konversi oktal ke desimal
int oktalKeDesimal(string oktal) {
    int desimal = 0;
    int pangkat = 0;
    for(int i = oktal.length()-1; i >= 0; i--) {
        desimal += (oktal[i] - '0') * pow(8, pangkat);
        pangkat++;
    }
    return desimal;
}

// Fungsi untuk konversi desimal ke oktal
string desimalKeOktal(int desimal) {
    if(desimal == 0) return "0";
    string oktal = "";
    while(desimal > 0) {
        oktal = to_string(desimal % 8) + oktal;
        desimal /= 8;
    }
    return oktal;
}

void tampilkanOperasi(string angka1, string angka2, char operasi, int basis) {
    int dec1, dec2;
    
    // Konversi ke desimal berdasarkan basis
    switch(basis) {
        case 1: // Biner
            dec1 = binerKeDesimal(angka1);
            dec2 = binerKeDesimal(angka2);
            break;
        case 2: // Oktal
            dec1 = oktalKeDesimal(angka1);
            dec2 = oktalKeDesimal(angka2);
            break;
        case 3: // Desimal
            dec1 = stoi(angka1);
            dec2 = stoi(angka2);
            break;
        case 4: // Hexa
            dec1 = hexKeDesimal(angka1);
            dec2 = hexKeDesimal(angka2);
            break;
        default:
            return;
    }
    
    int hasil;
    cout << "\nHasil:\n\n";
    cout << angka1 << "\t\t\t\t" << dec1 << endl;
    cout << angka2 << "\t\t\t\t" << dec2 << endl;
    cout << "---- " << operasi << "\t\t\t--------" << operasi << endl;
    
    switch(operasi) {
        case '+': 
            hasil = dec1 + dec2; 
            break;
        case '-': 
            hasil = dec1 - dec2; 
            break;
        case '*': 
            hasil = dec1 * dec2;
            cout << setw(16) << right << dec1 * (dec2 % 10) << endl;
            if(dec2 >= 10) {
                cout << setw(15) << right << dec1 * (dec2 / 10) << endl;
                cout << "\t\t\t   --------+" << endl;
            }
            break;
        case '/': 
            if(dec2 != 0) hasil = dec1 / dec2;
            else {
                cout << "Error: Pembagian dengan nol!" << endl;
                return;
            }
            break;
    }
    
    // Konversi hasil kembali ke basis yang dipilih
    string hasilString;
    switch(basis) {
        case 1: // Biner
            hasilString = desimalKeBiner(hasil);
            cout << setw(16) << right << hasilString << " (Bin)" << endl;
            break;
        case 2: // Oktal
            hasilString = desimalKeOktal(hasil);
            cout << setw(16) << right << hasilString << " (Oct)" << endl;
            break;
        case 3: // Desimal
            cout << setw(16) << right << hasil << " (Dec)" << endl;
            break;
        case 4: // Hexa
            hasilString = desimalKeHex(hasil);
            cout << setw(16) << right << hasilString << " (Hex)" << endl;
            break;
    }
}

int main() {
    char lanjut;
    do {
        system("cls");
        cout << "Bilangan yang akan di proses\n";
        cout << "1. biner\n";
        cout << "2. oktal\n";
        cout << "3. desimal\n";
        cout << "4. hexa\n\n";
        cout << "Masukkan pilihan anda ? ";
        
        int pilihan;
        cin >> pilihan;
        
        cout << "\nMasukan Operator proses :\n";
        cout << "1. +\n";
        cout << "2. -\n";
        cout << "3. *\n";
        cout << "4. /\n\n";
        cout << "pilihan anda : ";
        
        int op_pilihan;
        cin >> op_pilihan;
        char operasi;
        switch(op_pilihan) {
            case 1: operasi = '+'; break;
            case 2: operasi = '-'; break;
            case 3: operasi = '*'; break;
            case 4: operasi = '/'; break;
            default: operasi = '+';
        }
        
        string angka1, angka2;
        cout << "\nMasukkkan angka 1 : ";
        cin >> angka1;
        cout << "masukkan angka 2 : ";
        cin >> angka2;
        
        tampilkanOperasi(angka1, angka2, operasi, pilihan);
        
        cout << "\nKonversi lagi? [Y/n]: ";
        cin >> lanjut;
        
    } while (lanjut == 'Y' || lanjut == 'y');
    
    return 0;
}