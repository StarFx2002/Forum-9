package com.mycompany.forumw9;

import java.io.Serializable;

/**
 * Kelas ini merepresentasikan pengguna dalam aplikasi bank.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L; // Versi serialisasi
    private String name; // Nama pengguna
    private String accountNumber; // Nomor rekening
    private double balance; // Saldo

    // Konstruktor untuk inisialisasi objek User
    public User(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter untuk nama
    public String getName() {
        return name;
    }

    // Getter untuk nomor rekening
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter untuk saldo
    public double getBalance() {
        return balance;
    }

    // Metode untuk menyetor uang
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Tambahkan jumlah ke saldo
        }
    }

    // Metode untuk menarik uang
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Kurangi jumlah dari saldo
            return true; // Penarikan berhasil
        }
        return false; // Penarikan gagal
    }

    // Override toString untuk menampilkan informasi pengguna
    @Override
    public String toString() {
        return "User {name='" + name + '\'' + ", accountNumber='" + accountNumber + '\'' + ", balance=" + balance + '}';
    }
}