package truthtableconstructor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustomButton extends JButton{
	public CustomButton(String text , GUI gui) {
		super(text);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gui.getExpressionStrings().add(text);
				gui.update();
			}
		});
	}
}
