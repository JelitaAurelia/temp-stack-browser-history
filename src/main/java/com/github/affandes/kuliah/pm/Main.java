package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private LinkedList<String> history;

    public Main() {
        history = new LinkedList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
            return;
        }
        System.out.println("History Browser (dari yang terbaru):");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((history.size() - i) + ". " + history.get(i));
        }
    }

    public void browse(String website) {
        history.addFirst(website);
        System.out.println("Website " + website + " telah ditambahkan ke history.");
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
        } else {
            String removedWebsite = history.removeFirst(); // Menghapus website terbaru
            System.out.println("Kembali dari website: " + removedWebsite);
        }
    }

    public static void main(String[] args) {
        Main browserHistory = new Main();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Selamat datang di simulasi Browser History.");
        do {
            System.out.println("\nMasukkan perintah (view/browse/back/exit): ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "view":
                    browserHistory.view();
                    break;
                case "browse":
                    System.out.print("Masukkan URL website: ");
                    String website = scanner.nextLine();
                    browserHistory.browse(website);
                    break;
                case "back":
                    browserHistory.back();
                    break;
                case "exit":
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Perintah tidak dikenali. Silakan coba lagi.");
                    break;
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
