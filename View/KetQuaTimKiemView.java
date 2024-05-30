package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Model.SinhVien;

public class KetQuaTimKiemView extends JFrame {
    public KetQuaTimKiemView(List<SinhVien> resultList) {
        setTitle("Kết quả tìm kiếm");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout());

        JTextArea resultArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        StringBuilder resultText = new StringBuilder();
        for (SinhVien sv : resultList) {
            resultText.append("Mã sinh viên: ").append(sv.getMa()).append("\n");
            resultText.append("Tên sinh viên: ").append(sv.getTen()).append("\n");
            resultText.append("Quê quán: ").append(sv.getQue()).append("\n");
            resultText.append("-------------------------\n");
        }
        resultArea.setText(resultText.toString());
        resultArea.setEditable(false);
    }
}
