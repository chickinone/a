package Control;

import javax.swing.JPanel;

public class ChuyenManHinh {
private JPanel root;
private String kinselect = "";
public ChuyenManHinh(JPanel root) {
	
	this.root = root;
}
public void setView(JPanel jpitem, JPanel jbtieam) {
	kinselect = "Trang Chủ";
	jpitem.setBackground(null);
}
}