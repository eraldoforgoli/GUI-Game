import javax.swing.JFrame;

public class GUIGameTest {
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		GUIGame game = new GUIGame();
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setTitle("Second Game.");
	}
}
