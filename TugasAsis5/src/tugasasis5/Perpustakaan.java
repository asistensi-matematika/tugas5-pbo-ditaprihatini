/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasasis5;

/**
 *
 * @author Toshiba
 */
public class Perpustakaan {
}

class Buku extends Perpustakaan{
    private String judul;
    private String pengarang;
    private String jenis;
    private int halaman;
    
    public Buku(){
        judul = "tidak diketahui";
        pengarang = "tidak diketahui";
        halaman = 0;
        jenis = "tidak diketahui";
    }
    
    public Buku(String judul, String pengarang, String jenis, int halaman){
        this.judul = judul;
        this.pengarang = pengarang;
        this.halaman = halaman;
        this.jenis = jenis;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setJenis(String jenis_buku) {
        this.jenis = jenis;
    }

    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHalaman() {
        return halaman;
    }
    
    public void cetak(){
        System.out.println("judul \t\t= "+judul);
        System.out.println("pengarang \t= "+pengarang);
        System.out.println("jumlah halaman = "+halaman);
        System.out.println("jenis buku \t= "+jenis);
    }
    
}

class Fiksi extends Buku{
    private String jenis_buku;
    
    public Fiksi(){
        super();
        jenis_buku = "Fiksi";
    }
    
    public Fiksi(String judul, String pengarang, String jenis, int halaman, 
            String jenis_buku ){
        super(judul,pengarang,jenis,halaman);
        this.jenis_buku = jenis_buku;
    }

    public void setJenis_buku(String jenis_buku) {
        this.jenis_buku = jenis_buku;
    }

    public String getJenis_buku() {
        return jenis_buku;
    }
}

class NonFiksi extends Buku{
    private String jenis_buku;
    
    public NonFiksi(){
        super();
        jenis_buku = "Non Fiksi";;
    }
    
    public NonFiksi(String judul, String pengarang, String jenis, int halaman, 
            String jenis_buku){
        super(judul,pengarang,jenis,halaman);
        this.jenis_buku = jenis_buku;
    }

    public void setJenis_buku(String jenis_buku) {
        this.jenis_buku = jenis_buku;
    }

    public String getJenis_buku() {
        return jenis_buku;
    }
    
}