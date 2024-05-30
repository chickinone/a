package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.border.EmptyBorder;
import Data.FileHandler;
import Model.SinhVien;

public class QLSVview extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private List<SinhVien> sinhVienList;

    public static void main(String[] args) {
        try {
            QLSVview frame = new QLSVview();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QLSVview() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Quản Lý Sinh Viên");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        mnFile.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        menuBar.add(mnFile);

        JMenuItem mntmOpenFile = new JMenuItem("Open File");
        mnFile.add(mntmOpenFile);

        JMenuItem mntmCloseFile = new JMenuItem("Close File");
        mnFile.add(mntmCloseFile);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mnFile.add(mntmExit);

        JMenu them = new JMenu("Thêm sinh viên");
        them.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        menuBar.add(them);

        JMenuItem menuItemThemSV = new JMenuItem("Thêm sinh viên");
        menuItemThemSV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Them themView = new Them();
                themView.setVisible(true);
                dispose();
            }
        });
        them.add(menuItemThemSV);

        JMenu sua = new JMenu("Sửa thông tin sinh viên");
        sua.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        menuBar.add(sua);

        JMenuItem menuItemSuaSV = new JMenuItem("Sửa sinh viên");
        menuItemSuaSV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sua suaView = new Sua();
                suaView.setVisible(true);
                dispose();
            }
        });
        sua.add(menuItemSuaSV);

        JMenu xoa = new JMenu("Xóa sinh viên");
        xoa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        menuBar.add(xoa);

        // Thêm JMenuItem cho "Xóa sinh viên"
        JMenuItem menuItemXoaSV = new JMenuItem("Xóa sinh viên");
        menuItemXoaSV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Xoa xoaView = new Xoa();
                xoaView.setVisible(true);
                dispose();
            }
        });
        xoa.add(menuItemXoaSV);

        JMenu timKiem = new JMenu("Tìm sinh viên");
        timKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        menuBar.add(timKiem);

        JMenuItem mntmTimTheoMa = new JMenuItem("Tìm theo mã");
        timKiem.add(mntmTimTheoMa);

        JMenuItem mntmTimTheoTen = new JMenuItem("Tìm theo tên");
        timKiem.add(mntmTimTheoTen);

        JMenuItem mntmTimTheoQue = new JMenuItem("Tìm theo quê quán");
        timKiem.add(mntmTimTheoQue);

        JMenuItem menuItemShowSV = new JMenuItem("Hiển thị sinh viên");
        menuItemShowSV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSinhVienList();
                DanhSachSinhVienView danhSachView = new DanhSachSinhVienView(sinhVienList);
                danhSachView.setVisible(true);
                dispose();
            }
        });

        timKiem.add(menuItemShowSV);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBackground(new Color(245, 245, 245));
        setContentPane(contentPane);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblMaSinhVien = new JLabel("Mã sinh viên:");
        lblMaSinhVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(lblMaSinhVien, gbc);

        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPane.add(textField, gbc);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        contentPane.add(btnTimKiem, gbc);

        btnTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = textField.getText();
                if (searchText.equals("theo mã")) {
                    TimTheoMaView timTheoMaView = new TimTheoMaView(sinhVienList);
                    timTheoMaView.setVisible(true);
                } else if (searchText.equals("theo tên")) {
                    TimTheoTenView timTheoTenView = new TimTheoTenView(sinhVienList);
                    timTheoTenView.setVisible(true);
                } else if (searchText.equals("theo quê")) {
                    TimTheoQueView timTheoQueView = new TimTheoQueView(sinhVienList);
                    timTheoQueView.setVisible(true);
                }
            }
        });

        mntmTimTheoMa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TimTheoMaView timTheoMaView = new TimTheoMaView(sinhVienList);
                timTheoMaView.setVisible(true);
            }
        });

        mntmTimTheoTen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TimTheoTenView timTheoTenView = new TimTheoTenView(sinhVienList);
                timTheoTenView.setVisible(true);
            }
        });

        mntmTimTheoQue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TimTheoQueView timTheoQueView = new      TimTheoQueView(sinhVienList);
                timTheoQueView.setVisible(true);
            }
        });

        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }

    private void showSinhVienList() {
        sinhVienList = FileHandler.readFromFile();
        if (sinhVienList != null) {
            System.out.println("Danh sách sinh viên:");
            for (SinhVien sv : sinhVienList) {
                System.out.println(sv);
            }
        } else {
            System.out.println("Không thể đọc danh sách sinh viên từ file.");
        }
    }
}

