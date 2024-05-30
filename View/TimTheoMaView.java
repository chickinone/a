package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.io.*;
import Model.SinhVien;
import java.util.ArrayList;
public class TimTheoMaView extends JFrame {
    private JTextField txtMa;

    public TimTheoMaView(List<SinhVien> sinhVienList) {
        setTitle("Tìm kiếm sinh viên theo mã");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblMa = new JLabel("Mã sinh viên:");
        lblMa.setBounds(50, 50, 100, 20);
        panel.add(lblMa);

        txtMa = new JTextField();
        txtMa.setBounds(160, 50, 150, 20);
        panel.add(txtMa);
        txtMa.setColumns(10);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setBounds(160, 100, 100, 30);
        panel.add(btnTimKiem);

        btnTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maCanTim = txtMa.getText();
                try {
                    FileInputStream fis = new FileInputStream("sinhvien.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    List<SinhVien> sinhVienList = (List<SinhVien>) ois.readObject();
                    ois.close();

                    List<SinhVien> ketQuaTimKiem = new ArrayList<>();
                    for (SinhVien sv : sinhVienList) {
                        if (sv.getMa().equalsIgnoreCase(maCanTim)) {
                            ketQuaTimKiem.add(sv);
                        }
                    }

                    // Hiển thị kết quả trên một giao diện mới
                    if (!ketQuaTimKiem.isEmpty()) {
                        KetQuaTimKiemView resultView = new KetQuaTimKiemView(ketQuaTimKiem);
                        resultView.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên có mã " + maCanTim, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
