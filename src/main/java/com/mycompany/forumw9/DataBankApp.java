package com.mycompany.forumw9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Kelas ini mengelola data pengguna untuk aplikasi bank.
 */
public class DataBankApp {
    private static final String FILE_NAME = "users_data.ser"; // Nama file untuk menyimpan data
    private List<User> users; // Daftar pengguna

    // Konstruktor untuk inisialisasi daftar pengguna
    public DataBankApp() {
        users = new ArrayList<>();
    }

    // Metode untuk menambahkan pengguna baru
    public void addUser (String name, String accountNumber, double balance) {
        if (name == null || name.isEmpty() || accountNumber == null || accountNumber.isEmpty() || balance < 0) {
            System.out.println("Input tidak valid. Pastikan semua data diisi dengan benar.");
            return;
        }
        users.add(new User(name, accountNumber, balance)); // Tambahkan pengguna baru ke daftar
        System.out.println("Pengguna berhasil ditambahkan.");
    }

    // Metode untuk menampilkan semua pengguna
    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("Belum ada pengguna.");
        } else {
            System.out.println("Daftar Pengguna:");
            for (User  user : users) {
                System.out.println(user); // Tampilkan informasi pengguna
            }
        }
    }

    public void saveToFile() throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
        oos.writeObject(users);
        System.out.println("Data berhasil disimpan ke file.");
    } catch (FileNotFoundException e) {
        System.out.println("File tidak ditemukan: " + e.getMessage());
        throw e;
    } catch (IOException e) {
        System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        throw e;
    }
}

public void loadFromFile() throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
        users = (List<User>) ois.readObject();
        System.out.println("Data berhasil dimuat dari file.");
    } catch (FileNotFoundException e) {
        System.out.println("File tidak ditemukan. Silakan simpan data terlebih dahulu.");
        throw e;
    } catch (IOException e) {
        System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        throw e;
    } catch (ClassNotFoundException e) {
        System.out.println("Format file tidak valid: " + e.getMessage());
        throw e;
    }
}
}
