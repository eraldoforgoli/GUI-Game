import java.security.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class GUIGame extends JComponent implements ActionListener, KeyListener {
	private int x;
	private int x2;
	private int y;

	private int velx;
	private int vely;
	private int velx2;
	private int points2;
	public static int points;
	Timer timer;
	private boolean hit;

	SecureRandom r = new SecureRandom();

	public GUIGame() {
		points = points2 = 0;
		x = x2 = 0;
		y = 400;
		velx = 0;
		vely = 0;
		velx2 = 5;
		hit = false;
		addKeyListener(this);
		setFocusable(true);
		timer = new Timer(8, this);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.drawString("POINTS : ", 15, 15);
		g2.setColor(Color.black);
		g2.drawString(Integer.toString(points2), 70, 15);
		Rectangle rect = new Rectangle(400 + x, 400, 60, 60);
		g2.fill(rect);
		Rectangle ell2 = new Rectangle(x2, 10, 60, 60);
		g2.fill(ell2);

		Ellipse2D.Double ell3 = new Ellipse2D.Double(-80, -80, 0, 0);

		if (hit) {
			ell3 = new Ellipse2D.Double(400 + x, y, 60, 60);
			g2.fill(ell3);

		}

		double a = Math.abs(ell3.getX() - ell2.getX());
		double b = Math.abs(ell3.getY() - ell2.getY());

		if (a <= 60 && b <= 60) {

			points++;

			x2 = r.nextInt(500);
			points2 = points;
		}

		timer.start(); // nisim timerin
	}

	public void actionPerformed(ActionEvent e) {
		if (x2 > 560 || x2 < 0) {
			velx2 = -velx2;
		}

		x2 += velx2;
		x += velx;
		velx = 0;
		y += -13;
		repaint();
	}

	public void left() {
		velx += -12;
	}

	public void right() {
		velx += 12;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == e.VK_LEFT) {
			left();
		}
		if (code == e.VK_RIGHT) {
			right();
		}

		if (code == e.VK_UP) {
			hit = true;
			if (y < 0) {
				y = 400;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}
