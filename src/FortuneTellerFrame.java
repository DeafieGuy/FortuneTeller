import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortuneArea;
    private JButton readFortuneBtn;
    private JButton quitBtn;

    private ArrayList<String> fortunes;
    private Random rand = new Random();
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        super("Fortune Teller");

        // ====== MAIN FRAME SETTINGS ======
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Toolkit sizing: 3/4 of screen and centered
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
        int width = (int)(screen.width * 0.75);
        int height = (int)(screen.height * 0.75);
        setSize(width, height);
        setLocationRelativeTo(null);

        // ====== DEFINE FONTS ======
        Font titleFont = new Font("Serif", Font.BOLD, 48);
        Font fortuneFont = new Font("SansSerif", Font.PLAIN, 18);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 20);

        // ====== TOP PANEL ======
        JPanel topPanel = new JPanel(new BorderLayout());
        ImageIcon icon = new ImageIcon("fortuneteller.png");

        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setFont(titleFont);

        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // ====== MIDDLE PANEL ======
        JPanel middlePanel = new JPanel(new BorderLayout());

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(fortuneFont);

        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        middlePanel.add(scrollPane, BorderLayout.CENTER);

        add(middlePanel, BorderLayout.CENTER);

        // ====== FORTUNES ======
        fortunes = new ArrayList<>();
        fortunes.add("Your death is near...but don’t worry, it’s just a metaphor for your next big change.");
        fortunes.add("A mysterious cat will judge you today. Don’t take it personally.");
        fortunes.add("Your future is bright...unless you forget to charge your phone.");
        fortunes.add("You will accomplish great things...right after one more sleep.");
        fortunes.add("Beware of pigeons. They know what you did last summer.");
        fortunes.add("A surprise awaits you...probably in the basement.");
        fortunes.add("You will soon master something you’ve been avoiding. Like checking before class start.");
        fortunes.add("Someone will compliment you today. It might even be sincere.");
        fortunes.add("Your next big idea will come while you’re rotting in bed.");
        fortunes.add("Good fortune is coming...it’s just stuck in hell.");
        fortunes.add("You will soon laugh at something you shouldn’t. Again.");
        fortunes.add("Your confidence will rise, just like your WiFi signal when you stand in the right spot.");

        // ====== BOTTOM PANEL ======
        JPanel bottomPanel = new JPanel(new FlowLayout());

        readFortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");

        readFortuneBtn.setFont(buttonFont);
        quitBtn.setFont(buttonFont);

        // Quit button — already using lambda ✔
        quitBtn.addActionListener(e -> System.exit(0));

        // Read Fortune button — now using lambda ✔
        readFortuneBtn.addActionListener(e -> {
            int newIndex;
            do {
                newIndex = rand.nextInt(fortunes.size());
            } while (newIndex == lastIndex);

            lastIndex = newIndex;
            fortuneArea.append(fortunes.get(newIndex) + "\n");
        });

        bottomPanel.add(readFortuneBtn);
        bottomPanel.add(quitBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FortuneTellerFrame());
    }
}
