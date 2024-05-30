package View;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.io.*;
import Model.SinhVien;

public class TimTheoTenView extends JFrame {
    private JTextField txtTen;

    public TimTheoTenView(List<SinhVien> sinhVienList) {
        setTitle("Tìm kiếm sinh viên theo tên");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblTen = new JLabel("Tên sinh viên:");
        lblTen.setBounds(50, 50, 100, 20);
        panel.add(lblTen);

        txtTen = new JTextField();
        txtTen.setBounds(160, 50, 150, 20);
        panel.add(txtTen);
        txtTen.setColumns(10);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setBounds(160, 100, 100, 30);
        panel.add(btnTimKiem);

        btnTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tenCanTim = txtTen.getText();
                try {
                    FileInputStream fis = new FileInputStream("sinhvien.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    List<SinhVien> sinhVienList = (List<SinhVien>) ois.readObject();
                    ois.close();

                    List<SinhVien> ketQuaTimKiem = new ArrayList<>();
                    for (SinhVien sv : sinhVienList) {
                        if (sv.getTen().equalsIgnoreCase(tenCanTim)) {
                            ketQuaTimKiem.add(sv);
                        }
                    }

                    // Hiển thị kết quả trên một giao diện mới
                    if (!ketQuaTimKiem.isEmpty()) {
                        KetQuaTimKiemView resultView = new KetQuaTimKiemView(ketQuaTimKiem);
                        resultView.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên có tên " + tenCanTim, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
