public class Counter extends Frame {

  private static final int[] SIZE = {250, 100};
  private Label counterLabel;
  private TextField counterField;
  private Button countButton;
  private int counter = 0;

  public Counter() {
    super("Counting");
    counterLabel = new Label("Counter");

    counterField = new TextField(String.valueOf(counter), 10);
    counterField.setEditable(false);

    countButton = new Button("Count");
    countButton.addActionListener(
        e -> counterField.setText(String.valueOf(++counter)));

    add(counterLabel);
    add(counterField);
    add(countButton);

    setLayout(new FlowLayout());
    setSize(SIZE[0], SIZE[1]);
    setLocationRelativeTo(null);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });
    setVisible(true);
  }
}