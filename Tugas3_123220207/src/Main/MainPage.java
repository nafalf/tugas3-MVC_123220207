package View;

import View.Dosen.ViewDataDosen;
import View.Mahasiswa.ViewDataMahasiswa;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainPage extends JFrame implements ActionListener{
    JLabel header = new JLabel("Selamat Datang di Database UPNVY");
    JLabel subHeader = new JLabel("Silahkan Pilih:");
    JButton pilihdosen = new JButton ("Database Dosen");
    JButton pilihmahasiswa = new JButton ("Database Mahasiswa");
    JButton tombolpilih = new JButton("Pilih");
    JButton tombolKeluar = new JButton("Keluar");
    
 public MainPage(){
        setVisible(true);
        setSize(400, 500);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        
        setLayout(null);
        add(header);
        header.setBounds(40, 10, 350, 24);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        
        add(subHeader);
        subHeader.setBounds(20, 45, 250, 30);
        
        ButtonGroup pilihJenisData = new ButtonGroup();
        pilihJenisData.add(pilihdosen);
        pilihJenisData.add(pilihmahasiswa);
        
        add (pilihdosen);
        pilihdosen.setBounds(20, 80, 170, 24);
        
        add(pilihmahasiswa);
        pilihmahasiswa.setBounds(210, 80, 170, 24);
        
        add(tombolKeluar);
        tombolKeluar.setBounds(20, 120, 360, 24);
        
        pilihmahasiswa.addActionListener(this);
        pilihdosen.addActionListener(this);
        tombolKeluar.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==pilihmahasiswa){
                dispose();
                new ViewDataMahasiswa();
            } else if(e.getSource()==pilihdosen){
                dispose();
                new ViewDataDosen();
            } else if(e.getSource()==tombolKeluar){
                System.exit(0);
            }
        } catch(Exception error){
            JOptionPane.showMessageDialog(null,"Database belum terhubung, \n Harap aktifkan XAMPP");
            System.exit(0);
        }
    }
}
