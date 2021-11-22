public class MyFrame extends JFrame {

  private static final int[] SIZE = {250, 100};
  private JLabel label;

  public MyFrame() {
    super("MyFrame");

    this.label = new JLabel("This is my first own frame.");
    this.label.setHorizontalAlignment(JLabel.CENTER);
    Font font = new Font(label.getFont().getName(), Font.BOLD + Font.ITALIC, 12);
    this.label.setFont(font);

    this.add(label);

    this.setSize(SIZE[0], SIZE[1]);
    
    // Center
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setVisible(true);
  }
}