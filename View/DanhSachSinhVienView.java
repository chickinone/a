package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.SinhVien;

import java.awt.BorderLayout;
import java.util.List;

public class DanhSachSinhVienView extends JFrame {

    private static final long serialVersionUID = 1L;

    public DanhSachSinhVienView(List<SinhVien> sinhVienList) {
        setTitle("Danh sách sinh viên");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"Mã sinh viên", "Họ", "Tên", "Năm sinh", "Quê quán", "Điểm trung bình"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        for (SinhVien sv : sinhVienList) {
            Object[] rowData = {sv.getMa(), sv.getHo(), sv.getTen(), sv.getNam(), sv.getQue(), sv.getGpa()};
            model.addRow(rowData);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
    }
}
