/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Pelanggan;
import java.util.ArrayList;
import java.util.List;

public class PelangganRepository {
    private List<Pelanggan> list = new ArrayList<>();

    public void tambah(Pelanggan p) {
        list.add(p);
    }

    public void ubah(int index, Pelanggan p) {
        list.set(index, p);
    }

    public void hapus(int index) {
        list.remove(index);
    }

    public List<Pelanggan> getAll() {
        return list;
    }
}
