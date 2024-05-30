package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.QLSVview;

public class ClickMenu implements ActionListener {

	private QLSVview qlsVview;
	
	public ClickMenu(QLSVview qlsVview) {
		super();
		this.qlsVview = qlsVview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String click = e.getActionCommand();
		if(click.equals("")) {
			
		}
	}

}