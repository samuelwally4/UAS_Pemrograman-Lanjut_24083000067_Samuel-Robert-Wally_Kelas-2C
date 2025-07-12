/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Pelanggan {
    private String nama;
    private String noHp;
    private String jenisMobil;

    public Pelanggan(String nama, String noHp, String jenisMobil) {
        this.nama = nama;
        this.noHp = noHp;
        this.jenisMobil = jenisMobil;
    }

    public String getNama() { return nama; }
    public String getNoHp() { return noHp; }
    public String getJenisMobil() { return jenisMobil; }

    public void setNama(String nama) { this.nama = nama; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
    public void setJenisMobil(String jenisMobil) { this.jenisMobil = jenisMobil; }
}
