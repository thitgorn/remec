package touchyou.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import touchyou.util.GuiUtil;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8718047311675995150L;

	// get the width and height from Util class.
	private final int Width = GuiUtil.WIDTH;
	private final int Height = GuiUtil.HEIGHT;

	/**
	 * construct MainFrame.
	 */
	public MainFrame() {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(Width, Height);
		initComponent();
	}

	/**
	 * create layout.
	 */
	private void initComponent() {
		JPanel jp = new JPanel(new BorderLayout(0, 0)) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8955978584032699840L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(GuiUtil.getImage("/images/background.jpg"), 0, 0, null);
			}
		};
		jp.add(new Setting(Width * 3 / 10, Height), BorderLayout.WEST);
		jp.add(new Model(Width * 4 / 10, Height), BorderLayout.CENTER);

		JPanel wg = new JPanel(new BorderLayout(0, 0));
		wg.setPreferredSize(new Dimension(Width * 3 / 10, Height));
		wg.add(new Widget(Width * 2 / 10, Height), BorderLayout.NORTH);
		wg.add(new SyncButton(Width * 2 / 10, Height * 3 / 10 - 1), BorderLayout.SOUTH);

		jp.add(wg, BorderLayout.EAST);
		super.add(jp);
	}
}
