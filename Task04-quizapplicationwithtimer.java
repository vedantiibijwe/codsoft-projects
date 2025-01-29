import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    private JLabel questionLabel, timerLabel;
    private JRadioButton[] options = new JRadioButton[4];
    private JButton nextButton;
    private ButtonGroup bg;
    private int currentQuestion = 0, score = 0, timeLeft = 10;
    private Timer timer;

    // Questions and answers (with more questions added)
    private String[][] questions = {
            {"What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "3"},
            {"Who invented Java?", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum", "1"},
            {"Which is the largest planet?", "Earth", "Mars", "Jupiter", "Saturn", "3"},
            {"What is the boiling point of water?", "100°C", "90°C", "80°C", "120°C", "1"},
            {"Which programming language is known as the 'mother of all languages'?", "C", "Java", "Assembly", "Fortran", "3"},
            {"What is the speed of light?", "3 x 10^8 m/s", "3 x 10^6 m/s", "1 x 10^8 m/s", "5 x 10^8 m/s", "1"},
            {"Who developed the theory of relativity?", "Isaac Newton", "Albert Einstein", "Niels Bohr", "Galileo Galilei", "2"},
            {"What is the atomic number of oxygen?", "8", "7", "6", "10", "1"},
            {"Which element is most abundant in the Earth's crust?", "Oxygen", "Silicon", "Iron", "Aluminum", "1"},
            {"What is the currency of Japan?", "Yuan", "Won", "Yen", "Ringgit", "3"}
    };

    public Quiz() {
        setTitle("Quiz Application");
        setSize(500, 300);
        setLayout(new GridLayout(6, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        questionLabel = new JLabel("", JLabel.CENTER);
        add(questionLabel);

        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            bg.add(options[i]);
            add(options[i]);
        }

        timerLabel = new JLabel("Time left: 10 sec", JLabel.CENTER);
        add(timerLabel);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        loadQuestion();

        timer = new Timer(1000, e -> updateTimer());
        timer.start();

        setVisible(true);
    }

    private void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion][0]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(questions[currentQuestion][i + 1]);
                options[i].setSelected(false);
            }
            timeLeft = 10;
            timerLabel.setText("Time left: " + timeLeft + " sec");
        } else {
            showResult();
        }
    }

    private void updateTimer() {
        if (timeLeft > 0) {
            timeLeft--;
            timerLabel.setText("Time left: " + timeLeft + " sec");
        } else {
            checkAnswer();
        }
    }

    private void checkAnswer() {
        timer.stop();
        int correctAnswer = Integer.parseInt(questions[currentQuestion][5]) - 1;
        if (options[correctAnswer].isSelected()) {
            score++;
        }
        currentQuestion++;
        if (currentQuestion < questions.length) {
            loadQuestion();
            timer.start();
        } else {
            showResult();
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz Over!\nYour Score: " + score + "/" + questions.length);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkAnswer();
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
