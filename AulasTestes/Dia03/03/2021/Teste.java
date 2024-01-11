import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Teste
 */
public class Teste {
public static void main(String[] args) {
  JFrame frame = new JFrame();
  JButton button = new javax.swing.JButton();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      button.setIcon(new javax.swing.ImageIcon("/home/icones/teste.jpg"));
      button.setText("TEXTO");
      button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      button.setVerticalAlignment(javax.swing.SwingConstants.TOP);
      button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
  
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
      frame.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addGap(58, 58, 58)
              .addComponent(button)
              .addContainerGap(238, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addGap(30, 30, 30)
              .addComponent(button)
              .addContainerGap(171, Short.MAX_VALUE))
      );
      frame.pack();
}
}
