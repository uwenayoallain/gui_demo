package awt_demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.Normalizer;


/** The type Hello gui. */


public class HelloGui extends Frame {
  Label status = null;
  Button send = null;
  Button clear = null;
  TextField text = null;

  class ButtonClickEventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("SEND")) {
        status.setText("Sending: " + text.getText());
      }else if(e.getActionCommand().equals("CLEAR")) {
        text.setText("");
        status.setText("");
      }
    }
  }
  public HelloGui() {
    this.setBounds(0, 0, 1366, 768);
    this.setTitle("Application");
    this.setVisible(true);
    this.setBackground(Color.decode("#0f172a"));
    this.setForeground(Color.WHITE);
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    p1.setBounds(0, 0, 1366, 100);
    p2.setBounds(0, 100, 1366, 568);
    p3.setBounds(0, 668, 1366, 100);
    this.setLayout(null);
    this.add(p1);
    this.add(p2);
    this.add(p3);
    Label normal = new Label();
    text = new TextField();
    send = new Button("SEND");
    clear = new Button("CLEAR");
    status = new Label("Status");
    send.setActionCommand("SEND");
    text.setBounds(0, 0, 300, 30);
    send.setBounds(0, 40, 100, 30);
    clear.setBounds(100, 40, 100, 30);
    status.setBounds(0, 80, 300, 30);
    clear.setActionCommand("CLEAR");
    send.addActionListener(new ButtonClickEventHandler());
    clear.addActionListener(new ButtonClickEventHandler());
    p2.add(send);
    p2.add(clear);
    p2.add(text);
    p3.add(status);
    this.addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            normal.setText("Window is closing");
            try {
              Thread.sleep(10);
            } catch (InterruptedException ex) {
              ex.printStackTrace();
            }
            dispose();
          }
        });
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
