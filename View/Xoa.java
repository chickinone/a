package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data.FileHandler;
import Model.SinhVien;

import java.util.List;
import java.util.Iterator;

public class Xoa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaSinhVien;
    private List<SinhVien> sinhVienList;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Xoa frame = new Xoa();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Xoa() {
        setTitle("Xóa Sinh Viên");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMaSinhVien = new JLabel("Mã Sinh Viên:");
        lblMaSinhVien.setBounds(10, 11, 100, 14);
        contentPane.add(lblMaSinhVien);

        txtMaSinhVien = new JTextField();
        txtMaSinhVien.setBounds(120, 8, 200, 20);
        contentPane.add(txtMaSinhVien);
        txtMaSinhVien.setColumns(10);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBounds(330, 7, 89, 23);
        contentPane.add(btnXoa);

        // Đọc danh sách sinh viên từ file
        sinhVienList = FileHandler.readFromFile();

        // Xử lý sự kiện xóa sinh viên
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maSinhVien = txtMaSinhVien.getText();
                if (maSinhVien.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập mã sinh viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (xoaSinhVien(maSinhVien)) {
                    // Lưu danh sách cập nhật vào file
                    FileHandler.saveToFile(sinhVienList);
                    JOptionPane.showMessageDialog(contentPane, "Đã xóa sinh viên có mã: " + maSinhVien, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Không tìm thấy sinh viên có mã: " + maSinhVien, "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean xoaSinhVien(String maSinhVien) {
        Iterator<SinhVien> iterator = sinhVienList.iterator();
        while (iterator.hasNext()) {
            SinhVien sv = iterator.next();
            if (sv.getMa().equals(maSinhVien)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
