package perpustakaan;

/**
 *
 * @author Adji
 */

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Perpustakaan {
    
    public static void main(String[] args) {
        // Buat variable
        int jenis, totalDenda=0;
        String pinjam, kembali;
        LocalDate dPinjam, dKembali;
        
        // Scanner object
        Scanner input = new Scanner(System.in);
        
        // Menggunakan class buku
        Buku[] buku;
        buku = new Buku[3];
        
        // Inisiasi data buku
        buku[0] = new Buku("Pelajaran", 2000);
        buku[1] = new Buku("Novel", 5000);
        buku[2] = new Buku("Skripsi", 10000);
        
        System.out.println("=========================================");
        System.out.println("========== Perpustakaan David ===========");
        System.out.println("=========================================\n");
        
        System.out.println("Daftar Buku :");
        
        // Menampilkan data buku menggunakan looping
        for(int i=0; i < buku.length; i++){
            System.out.println((i+1) +". "+ buku[i].nama);
        }
        
        // Input buku
        System.out.print("\nPilih buku [1/2/3] : ");
        jenis = (Integer.parseInt(input.nextLine()))-1;
        
        // Input tanggal pinjam & kembali
        System.out.print("\nMasukkan tanggal pinjam (DD MM YYYY): ");
        pinjam = input.nextLine();
        System.out.print("Masukkan tanggal kembali (DD MM YYYY): ");
        kembali = input.nextLine();
        
        // Convert string to localdate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        dPinjam = LocalDate.parse(pinjam, formatter);
        dKembali = LocalDate.parse(kembali, formatter);
        
        // Hitung lama hari peminjaman
        long lamaPinjam = ChronoUnit.DAYS.between(dPinjam, dKembali);
        
        // Hitung denda jika peminjaman lebih dari 10 hari
        if(lamaPinjam>10){
            totalDenda = ((int)lamaPinjam-10)*buku[jenis].denda;
        }
        
        // Menampilkan hasil
        System.out.println("\nBuku yang dipinjam : "+buku[jenis].nama);
        System.out.println("Lama peminjaman : "+lamaPinjam+" Hari");
        System.out.println("Total denda : Rp"+totalDenda);
    }
    
}

// Membuat class buku untuk menyimpan data buku dan denda
class Buku{
    public String nama;
    public int denda;
    
    Buku(String nama, int denda){
        this.nama = nama;
        this.denda = denda;
    }
}
