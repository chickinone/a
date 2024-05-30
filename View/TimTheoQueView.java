package View;
import View.KetQuaTimKiemView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.io.*;
import Model.SinhVien;
import java.util.ArrayList;
public class TimTheoQueView extends JFrame {
    private JTextField txtQue;

    public TimTheoQueView(List<SinhVien> sinhVienList) {
        setTitle("Tìm kiếm sinh viên theo quê quán");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblQue = new JLabel("Quê quán:");
        lblQue.setBounds(50, 50, 100, 20);
        panel.add(lblQue);

        txtQue = new JTextField();
        txtQue.setBounds(160, 50, 150, 20);
        panel.add(txtQue);
        txtQue.setColumns(10);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setBounds(160, 100, 100, 30);
        panel.add(btnTimKiem);

     // Trong phương thức actionPerformed của lớp TimTheoQueView:
        btnTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String queCanTim = txtQue.getText();
                try {
                    FileInputStream fis = new FileInputStream("sinhvien.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    List<SinhVien> sinhVienList = (List<SinhVien>) ois.readObject();
                    ois.close();

                    List<SinhVien> ketQuaTimKiem = new ArrayList<>();
                    for (SinhVien sv : sinhVienList) {
                        if (sv.getQue().equalsIgnoreCase(queCanTim)) {
                            ketQuaTimKiem.add(sv);
                        }
                    }

                    // Hiển thị kết quả tìm kiếm trên giao diện mới
                    KetQuaTimKiemView ketQuaTimKiemView = new KetQuaTimKiemView(ketQuaTimKiem);
                    ketQuaTimKiemView.setVisible(true);
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
