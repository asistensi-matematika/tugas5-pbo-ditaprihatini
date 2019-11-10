/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasasis5;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
public class MainPerpustakaan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner dita = new Scanner (System.in);
        Buku[] perpustakaan = new Buku[10000];
        int n = 3;
        double jumlah_halaman = 900;
        double halFiksi = 0;
        double halNonFiksi = 0;
        double sd = 0;
        double sdf = 0;
        double sdnf = 0;
        Random dita2 = new Random();
        int Fiksi = 0;
        int NonFiksi = 0;
        
        for(int i = 0; i<perpustakaan.length; i++){
            int coinflip = dita2.nextInt(2)+1;
            if (coinflip == 1){
                perpustakaan[i] = new Fiksi();
            }
            else if (coinflip == 2){
                perpustakaan[i] = new NonFiksi();
            }
        }
        
        for (int i = 0; i<3; i++){
            int coinflip = dita2.nextInt(2)+1;
            if (coinflip == 1){
                perpustakaan[i] = new Buku("Buku", "Dita Prihatini", 
                        "Fiksi", 300);
                Fiksi += 1;
                halFiksi += 300;
            }
            else if (coinflip == 2){
                perpustakaan[i] = new Buku ("Buku", "Dita Prihatini", 
                        "Non Fiksi", 300);
                NonFiksi += 1;
                halNonFiksi += 300;
            }
        }
        
        int awal = 1;
        do{
            garis2();
            header("Perpustakaan.txt");
            garis2();
            System.out.println("[1]. input buku baru");
            System.out.println("[2]. modifikasi detail buku");
            System.out.println("[3]. hapus buku");
            System.out.println("[0]. EXIT");
            garis2();
            
            double rata2 = jumlah_halaman/n;
            for(int i = 0; i<n; i++){
                sd = Math.pow((perpustakaan[i].getHalaman()- rata2),2);
            }
            
            double rataFiksi = halFiksi/Fiksi;
            double rataNonFiksi = halNonFiksi/NonFiksi;
            for(int i = 0; i<n;i++){
                if(perpustakaan[i].getJenis()=="Fiksi"){
                    sdf = Math.pow((perpustakaan[i].getHalaman()- rataFiksi),2);
                }else{
                    sdnf = Math.pow((perpustakaan[i].getHalaman()-rataNonFiksi),2);
                }
            }
            
            System.out.println("Jumlah buku di dalam perpustakaan\t\t:"+n);
            System.out.println("Rata - rata halaman buku dalam perpustakaan \t:"+rata2);
            System.out.println("Standar deviasi halaman buku dalam perpustakaan :"+Math.sqrt(sd/n));
            garis2();
            System.out.println("Jumlah buku fiksi di dalam perpustakaan\t\t\t:"+Fiksi);
            System.out.println("Rata - rata halaman buku fiksi dalam perpustakaan \t:"+rataFiksi);
            System.out.println("Standar deviasi halaman buku fiksi dalam perpustakaan \t:"+Math.sqrt(sdf/Fiksi));
            garis2();
            System.out.println("Jumlah buku non fiksi di dalam perpustakaan\t\t\t:"+NonFiksi);
            System.out.println("Rata - rata halaman buku non fiksi dalam perpustakaan \t\t:"+rataNonFiksi);
            System.out.println("Standar deviasi halaman buku non fiksi dalam perpustakaan \t:"+Math.sqrt(sdnf/NonFiksi));
            garis2();
            
            System.out.print("Pilih : ");
            int pilih = dita.nextInt();
            if (pilih == 1){
                    garis2();
                    header("BukuBaru.txt");
                    garis2();
                    n += 1;
                        System.out.println("Input judul buku : ");
                        String judul = dita.next();
                        perpustakaan[n-1].setJudul(judul);
                        System.out.println("Input pengarang buku : ");
                        String pengarang = dita.next();
                        perpustakaan[n-1].setPengarang(pengarang);
                        System.out.println("Input jumlah halaman : ");
                        int halaman = dita.nextInt();
                        perpustakaan[n-1].setHalaman(halaman);
                        
                        int coinflip = dita2.nextInt(2)+1;
                        if(coinflip == 1){
                            perpustakaan[n-1] = new Buku(judul,pengarang,
                                    "Fiksi",halaman);
                            Fiksi += 1;
                            halFiksi += halaman;
                        }
                        else if(coinflip == 2){
                            perpustakaan[n-1] = new Buku(judul,pengarang,
                                    "Non Fiksi",halaman);
                            NonFiksi += 1;
                            halNonFiksi += halaman;
                        }
            }else if (pilih == 2){
                    garis2();
                    header("UbahBuku.txt");
                    garis2();
                    System.out.println("Pilih buku yang akan diubah : ");
                    for(int i = 0; i<n ; i++){
                        System.out.println("[" + (i + 1) + "] " + perpustakaan[i].getJudul() 
                                + "\t--->\t " + perpustakaan[i].getPengarang());
                    }
                    int UbahBuku = dita.nextInt();
                    System.out.print("Input judul buku : ");
                    String judul = dita.next();
                    perpustakaan[UbahBuku-1].setJudul(judul);
                    System.out.print("Input pengarang buku : ");
                    String pengarang = dita.next();
                    perpustakaan[UbahBuku-1].setPengarang(pengarang);
                    
                    int halLama = perpustakaan[UbahBuku-1].getHalaman();
                    System.out.print("Input jumlah halaman buku : ");
                    int halaman = dita.nextInt();
                    perpustakaan[UbahBuku-1].setHalaman(halaman);
                    jumlah_halaman = jumlah_halaman - halLama + halaman;
                    if(perpustakaan[UbahBuku-1].getJenis() == "fiksi") {
                        halFiksi = halFiksi - halLama + perpustakaan[UbahBuku].getHalaman();
                    } else {
                        halNonFiksi = halNonFiksi - halLama + perpustakaan[UbahBuku].getHalaman();
                    }
                    
            }else if(pilih == 3){
                garis2();
                header("HapusBuku.txt");
                garis2();
                System.out.println("Pilih buku yang akan dihapus : ");
                for (int i = 0; i < n; i++) {
                    System.out.println("[" + (i + 1) + "] " + perpustakaan[i].getJudul() + "\t-->\t " + perpustakaan[i].getPengarang());
                }
                int HapusBuku = dita.nextInt();
                for (int i = HapusBuku; i < n; i++) {
                    perpustakaan[i - 1] = perpustakaan[i];
                }

                jumlah_halaman -= perpustakaan[HapusBuku].getHalaman();
                n -= 1;
                if (perpustakaan[HapusBuku].getJenis() == "Fiksi") {
                    Fiksi -= 1;
                    halFiksi -= perpustakaan[HapusBuku].getHalaman();
                } else {
                    NonFiksi -= 1;
                    halNonFiksi -= perpustakaan[HapusBuku].getHalaman();
                }
            } else {
                awal = 0;
            }
        } while (awal != 0);
        String path = "data.txt";
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter dita3 = new BufferedWriter(fw);
            for (int i = 0; i < n; i++) {
                int a = i + 1;
                dita3.write("Buku ke : [" + Integer.toString(a) + "]");
                dita3.newLine();
                dita3.write("Judul : " + perpustakaan[i].getJudul());
                dita3.newLine();
                dita3.write("Pengarang : " + perpustakaan[i].getPengarang());
                dita3.newLine();
                dita3.write("Jumlah Halaman : " + Integer.toString(perpustakaan[i].getHalaman()));
                dita3.newLine();
                dita3.write("Jenis Buku : " + perpustakaan[i].getJenis());
                dita3.newLine();
                dita3.newLine();
            }
            dita3.close();

        } catch (Exception e) {
        }
    }
    
    public static void garis2(){
        System.out.println("================================================================================================================================");
    }
    
    public static void header(String Perpustakaan){
        File file = new File(Perpustakaan);
        String encoding = "utf-8";
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding)){
            int data = isr.read();
            while (data != -1){
                System.out.print((char)data);
                data = isr.read();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
