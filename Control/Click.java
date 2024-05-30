package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.QLSVview;
import View.Them;
import View.Xoa;

public class Click implements ActionListener {
    private QLSVview qlsVview;
    private Them them;
    private Xoa xoa;

    public Click(QLSVview qlsVview, Them them, Xoa xoa) {
        super();
        this.qlsVview = qlsVview;
        this.them = them;
        this.xoa = xoa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Thêm sinh viên")) {
            Them themview = new Them();
            themview.setVisible(true);
        } else if (src.equals("Xóa sinh viên")) {
            Xoa xoaview = new Xoa();
            xoaview.setVisible(true);
        }
    }
}
