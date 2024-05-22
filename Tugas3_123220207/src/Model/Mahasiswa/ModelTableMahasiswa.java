
package Model.Mahasiswa;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableMahasiswa extends AbstractTableModel {

    // Berfungsi untuk menyimpan daftar mahasiswa
    List<ModelMahasiswa> daftarMahasiswa;

    /*
      Nama kolom tabelnya disimpan ke dalam variabel "namaKolom" yang memiliki 
      tipe data Array String.
     */
    String kolom[] = {"ID", "Nama", "NIM"};

    /*
      Karena daftarMahasiswa memiliki tipe data List, kita harus mengubahnya
      terlebih dahulu ke dalam tipe data Array Object supaya dapat 
      dimasukkan ke dalam table.
     */
    public ModelTableMahasiswa(List<ModelMahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    // Method untuk mengambil jumlah baris dari tabel
    @Override
    public int getRowCount() {
        return daftarMahasiswa.size();
    }

    // Method untuk mengambil jumlah kolom dari tabel
    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarMahasiswa.get(rowIndex).getId();
            case 1:
                return daftarMahasiswa.get(rowIndex).getNama();
            case 2:
                return daftarMahasiswa.get(rowIndex).getNim();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
