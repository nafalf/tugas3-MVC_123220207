package Model.Dosen;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODosen implements InterfaceDAODosen {

    @Override
    public void insert(ModelDosen dosen) {
       try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "INSERT INTO dosen (nama, nidn) VALUES (?, ?);";
            
            /* 
              Memasukkan nama dan nidn dari input user ke dalam query untuk 
              mengisi bagian "?, ?" (dalam hal ini berarti nama dan nidn)
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNidn());
            
            // Menjalankan query untuk memasukkan data dosen baru
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal input data.
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        } 
    }

    @Override
    public void update(ModelDosen dosen) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE dosen SET nama=?, nidn=? WHERE id=?;";
            
            /* 
              Memasukkan nama dan nidn dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNidn());
            statement.setInt(3, dosen.getId());
            
            // Menjalankan query untuk menghapus data dosen yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "DELETE FROM dosen WHERE id=?;";
            
            /* 
              Memasukkan id berdasarkan data yang mau dihapus ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            // Menjalankan query untuk menghapus data dosen yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal hapus data.
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelDosen> getAll() {
         List<ModelDosen> listDosen = null;

        try {
            /* 
              Membuat sebuah variabel bernama "listDosen".
              Variabel ini memiliki tipe data List karena berfungsi untuk menyimpan banyak data
              Variabel ini nantinya akan digunakan untuk menyimpan daftar dosen
              hasil query dari database.
            */
            listDosen = new ArrayList<>();
            
            // Membuat objek statement yang digunakan untuk melakukan query.
            Statement statement = Connector.Connect().createStatement();
            
            /* 
                Menyimpan query database ke dalam varibel "query".
                Dalam hal ini, kita akan mengambil seluruh data dosen pada tabel "dosen".
            */
            String query = "SELECT * FROM dosen;";
            
             // Mengeksekusi query dan menyimpannya ke dalam variabel "resultSet".
            ResultSet resultSet = statement.executeQuery(query);
            
            /* 
                Karena hasil query memiliki tipe data List, supaya dapat mencetak semua data dosen,
                Kita perlu melakukan looping (perulangan) untuk mencetak tiap-tiap elemen.
            */
            while (resultSet.next()) {
                // Membuat sebuah objek "Dosen" untuk menyimpan data tiap-tiap dosen
                ModelDosen dsn = new ModelDosen();
                
                // Memasukkan hasil query ke objek dosen
                dsn.setId(resultSet.getInt("id"));
                dsn.setNama(resultSet.getString("nama"));
                dsn.setNidn(resultSet.getString("nidn"));
                

                listDosen.add(dsn);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal mengambil data.
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }
}
