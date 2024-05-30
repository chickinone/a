package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sua extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sua frame = new Sua();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Sua() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 427);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nhập mã sinh viên ");
        lblNewLabel.setBounds(28, 26, 155, 24);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Sửa");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code xử lý khi nhấn nút "Sửa"
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnNewButton.setBounds(405, 28, 87, 23);
        contentPane.add(btnNewButton);
        
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField.setBounds(212, 30, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNhpH = new JLabel("Nhập họ ");
        lblNhpH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNhpH.setBounds(28, 96, 155, 24);
        contentPane.add(lblNhpH);
        
        JLabel lblNhpTn = new JLabel("Nhập tên");
        lblNhpTn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNhpTn.setBounds(28, 142, 155, 24);
        contentPane.add(lblNhpTn);
        
        JLabel lblNmSinh = new JLabel("Năm sinh ");
        lblNmSinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNmSinh.setBounds(28, 194, 155, 24);
        contentPane.add(lblNmSinh);
        
        JLabel lblQuQun = new JLabel("Quê quán");
        lblQuQun.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblQuQun.setBounds(28, 246, 155, 24);
        contentPane.add(lblQuQun);
        
        JLabel lblGpa = new JLabel("GPA");
        lblGpa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblGpa.setBounds(28, 306, 155, 24);
        contentPane.add(lblGpa);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField_1.setColumns(10);
        textField_1.setBounds(212, 100, 96, 19);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField_2.setColumns(10);
        textField_2.setBounds(212, 146, 96, 19);
        contentPane.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField_3.setColumns(10);
        textField_3.setBounds(212, 198, 96, 19);
        contentPane.add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField_4.setColumns(10);
        textField_4.setBounds(212, 250, 96, 19);
        contentPane.add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField_5.setColumns(10);
        textField_5.setBounds(212, 310, 96, 19);
        contentPane.add(textField_5);
    }
}