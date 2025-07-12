/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Pelanggan;
import repository.PelangganRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class DashboardGUI extends JFrame {
    PelangganRepository repo = new PelangganRepository();
    DefaultTableModel model;
    JTable table;

    JTextField txtNama, txtNoHp, txtJenisMobil, txtPlat, txtTanggal;
    JComboBox<String> cbJenisCuci;

    public DashboardGUI() {
        setTitle("Dashboard Cuci Mobil");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color bgColor = new Color(173, 216, 230); // Warna biru muda

        // Form input
        txtNama = new JTextField(20);
        txtNoHp = new JTextField(20);
        txtJenisMobil = new JTextField(20);
        txtPlat = new JTextField(20);
        cbJenisCuci = new JComboBox<>(new String[]{"Cuci Luar", "Cuci Dalam", "Cuci Lengkap"});
        txtTanggal = new JTextField(20);
        txtTanggal.setText(LocalDate.now().toString());

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Data Pelanggan"));
        formPanel.setBackground(bgColor);

        formPanel.add(new JLabel("Nama:"));
        formPanel.add(txtNama);
        formPanel.add(new JLabel("No HP:"));
        formPanel.add(txtNoHp);
        formPanel.add(new JLabel("Jenis Mobil:"));
        formPanel.add(txtJenisMobil);
        formPanel.add(new JLabel("Plat Nomor:"));
        formPanel.add(txtPlat);
        formPanel.add(new JLabel("Jenis Cuci:"));
        formPanel.add(cbJenisCuci);
        formPanel.add(new JLabel("Tanggal:"));
        formPanel.add(txtTanggal);

        JButton btnTambah = new JButton("Tambah");
        JButton btnUbah = new JButton("Ubah");
        JButton btnHapus = new JButton("Hapus");
        btnHapus.setBackground(Color.RED);
        btnHapus.setForeground(Color.WHITE);

        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(bgColor);
        buttonPanel.add(btnTambah);
        buttonPanel.add(btnUbah);
        buttonPanel.add(btnHapus);

        model = new DefaultTableModel(new String[]{
            "Nama", "No HP", "Jenis Mobil", "Plat", "Jenis Cuci", "Tanggal"
        }, 0);
        table = new JTable(model);

        JScrollPane tableScroll = new JScrollPane(table);
        table.setBackground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(200, 230, 255));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(bgColor);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(tableScroll, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);

        // Tombol aksi
        btnTambah.addActionListener(e -> {
            model.addRow(new Object[]{
                txtNama.getText(),
                txtNoHp.getText(),
                txtJenisMobil.getText(),
                txtPlat.getText(),
                cbJenisCuci.getSelectedItem().toString(),
                txtTanggal.getText()
            });
            clearForm();
        });

        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.setValueAt(txtNama.getText(), selected, 0);
                model.setValueAt(txtNoHp.getText(), selected, 1);
                model.setValueAt(txtJenisMobil.getText(), selected, 2);
                model.setValueAt(txtPlat.getText(), selected, 3);
                model.setValueAt(cbJenisCuci.getSelectedItem().toString(), selected, 4);
                model.setValueAt(txtTanggal.getText(), selected, 5);
                clearForm();
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.removeRow(selected);
                clearForm();
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                txtNama.setText(model.getValueAt(selected, 0).toString());
                txtNoHp.setText(model.getValueAt(selected, 1).toString());
                txtJenisMobil.setText(model.getValueAt(selected, 2).toString());
                txtPlat.setText(model.getValueAt(selected, 3).toString());
                cbJenisCuci.setSelectedItem(model.getValueAt(selected, 4).toString());
                txtTanggal.setText(model.getValueAt(selected, 5).toString());
            }
        });
    }

    private void clearForm() {
        txtNama.setText("");
        txtNoHp.setText("");
        txtJenisMobil.setText("");
        txtPlat.setText("");
        cbJenisCuci.setSelectedIndex(0); // reset ke "Cuci Luar"
        txtTanggal.setText(LocalDate.now().toString());
    }
}
