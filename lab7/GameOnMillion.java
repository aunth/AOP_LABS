import java.awt.*;
import java.awt.event.*;

public class GameOnMillion extends Frame implements ActionListener {
    private Label questionLabel;
    private CheckboxGroup answerGroup;
    private Button submitButton;
    private Label messageLabel;
    private int currentQuestionIndex = 0;

    private String[] questions = {
            "What is the capital of France?",
    };

    private String[] answerVariant = {
            "Berlin",
            "Paris",
            "Kyiv",
    };

    private String[] answers = {
            "Paris",
    };

    public GameOnMillion() {
        setTitle("Game on Million");
        setSize(600, 500);
        setLayout(null);

        questionLabel = new Label(questions[currentQuestionIndex]);
        questionLabel.setBounds(20, 30, 300, 20); 
        add(questionLabel);

        answerGroup = new CheckboxGroup();
        for (int i = 0; i < answerVariant.length; i++) {
            Checkbox option = new Checkbox(answerVariant[i], false, answerGroup);
            option.setBounds(20, 50 + i * 20, 100, 20);
            add(option);
        }

        submitButton = new Button("Submit");
        submitButton.addActionListener(this);
        submitButton.setBounds(20, 120, 100, 30);
        add(submitButton);

        int messageLabelX = submitButton.getX();
        int messageLabelY = submitButton.getY() + submitButton.getHeight() + 10;
        messageLabel = new Label("");
        messageLabel.setBounds(messageLabelX, messageLabelY, 300, 20);
        add(messageLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            Checkbox selectedCheckbox = answerGroup.getSelectedCheckbox();
            if (selectedCheckbox != null) {
                String userAnswer = selectedCheckbox.getLabel();
                String correctAnswer = answers[currentQuestionIndex];
                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    messageLabel.setText("Correct!");
                } else {
                    messageLabel.setText("Incorrect!");
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    questionLabel.setText(questions[currentQuestionIndex]);
                    answerGroup.setSelectedCheckbox(null);
                } else {
                    submitButton.setEnabled(false);
                }
            } else {
                messageLabel.setText("Please select an answer.");
            }
        }
    }

    public static void main(String[] args) {
        new GameOnMillion();
    }
}
