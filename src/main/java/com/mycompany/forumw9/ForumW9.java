/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.forumw9;

/**
 *
 * @author Salma
 */
import java.util.Scanner;
import java.io.*;
public class ForumW9 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        DataBankApp app = new DataBankApp();
        
        while (true) {
            System.out.println("\n=== Menu Data Bank ===");
            System.out.println("1. Tambah Pengguna");
            System.out.println("2. Tampilkan Pengguna");
            System.out.println("3. Simpan ke File");
            System.out.println("4. Muat dari File");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan nomor rekening: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Masukkan saldo awal: ");
                    double balance = scanner.nextDouble();
                    app.addUser(name, accountNumber, balance);
                    break;
                case 2:
                    app.displayUsers();
                    break;
                case 3:
                    app.saveToFile();
                    break;
                case 4:
                    app.loadFromFile();
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi. Sampai jumpa!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}