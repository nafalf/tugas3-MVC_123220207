
package Model.Dosen;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableDosen extends AbstractTableModel {

    // Berfungsi untuk menyimpan daftar dosen
    List<ModelDosen> daftarDosen;

    /*
      Nama kolom tabelnya disimpan ke dalam variabel "namaKolom" yang memiliki 
      tipe data Array String.
     */
    String kolom[] = {"ID", "Nama", "NIDN"};

    /*
      Karena daftarDosen memiliki tipe data List, kita harus mengubahnya
      terlebih dahulu ke dalam tipe data Array Object supaya dapat 
      dimasukkan ke dalam table.
     */
    public ModelTableDosen(List<ModelDosen> daftarDosen) {
        this.daftarDosen = daftarDosen;
    }

    // Method untuk mengambil jumlah baris dari tabel
    @Override
    public int getRowCount() {
        return daftarDosen.size();
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
                return daftarDosen.get(rowIndex).getId();
            case 1:
                return daftarDosen.get(rowIndex).getNama();
            case 2:
                return daftarDosen.get(rowIndex).getNidn();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
