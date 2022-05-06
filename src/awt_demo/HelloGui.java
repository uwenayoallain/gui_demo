package awt_demo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** The type Hello gui. */
public class HelloGui extends Frame {
  /** Instantiates a new Hello gui. */
  public HelloGui() {
    // getting the screen size
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();
    this.setBounds(screenWidth - 296, 2, 300, 200);
    this.setTitle("AWT Demo");
    this.setVisible(true);
    this.setBackground(Color.BLACK);
    this.setForeground(Color.WHITE);
    Label label = new Label("AWT Demo Application");
    label.setFont(new Font("Operator Mono Medium", Font.BOLD, 20));
    label.setBounds(screenWidth - 296, 5, 1000, 80);
    this.add(label);
    this.addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            label.setText("Window is closing");
            label.setFont(new Font("OPERATOR MONO MEDIUM", Font.BOLD, 20));
            try {
              Thread.sleep(1000);
            } catch (InterruptedException ex) {
              ex.printStackTrace();
            }
            dispose();
          }
        });
    this.setLayout(null);
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   *
   */
  public static void main(String[] args) {
    new HelloGui();
  }
}
