import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingApp extends JFrame implements ActionListener {
    private JButton drawPolylineButton;
    private JButton drawArcButton;
    private JButton drawLineButton;
    private JPanel drawingPanel; // Panel for drawing
    private int drawType = 0; // 0: none, 1: polyline, 2: arc, 3: line

    public DrawingApp() {
        setTitle("Drawing App");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating buttons
        drawPolylineButton = new JButton("Намалювати ламану");
        drawArcButton = new JButton("Намалювати дугу");
        drawLineButton = new JButton("Намалювати лінію");

        // Adding action listener to buttons
        drawPolylineButton.addActionListener(this);
        drawArcButton.addActionListener(this);
        drawLineButton.addActionListener(this);

        // Panel for drawing
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (drawType == 1) {
                    drawPolyline(g);
                } else if (drawType == 2) {
                    drawArc(g);
                } else if (drawType == 3) {
                    drawLine(g);
                }
            }
        };

        // Placing buttons and drawing panel in the window
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drawPolylineButton);
        buttonPanel.add(drawArcButton);
        buttonPanel.add(drawLineButton);
        add(buttonPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
    }

    private void drawPolyline(Graphics g) {
        // Drawing a polyline
        int[] xPoints = {50, 100, 150, 200};
        int[] yPoints = {100, 50, 150, 100};
        int nPoints = 4;
        g.drawPolyline(xPoints, yPoints, nPoints);
    }

    private void drawArc(Graphics g) {
        // Drawing an arc
        g.drawArc(50, 50, 100, 100, 90, 180);
    }

    private void drawLine(Graphics g) {
        // Drawing a line
        g.drawLine(50, 50, 150, 150);
    }

    public void actionPerformed(ActionEvent e) {
        // Update draw type based on which button is clicked
        if (e.getSource() == drawPolylineButton) {
            drawType = 1;
        } else if (e.getSource() == drawArcButton) {
            drawType = 2;
        } else if (e.getSource() == drawLineButton) {
            drawType = 3;
        }
        // Repaint the drawing panel
        drawingPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingApp app = new DrawingApp();
            app.setVisible(true);
        });
    }
}