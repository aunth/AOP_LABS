import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingMenuExample extends JFrame {

    private List<Shape> shapes = new ArrayList<>();

    public DrawingMenuExample() {
        setTitle("Drawing Shapes Menu");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu drawMenu = new JMenu("Draw");
        menuBar.add(drawMenu);

        JMenuItem triangleItem = new JMenuItem("Draw Triangle");
        triangleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        triangleItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!shapes.isEmpty()) {
                    shapes.remove(shapes.size() - 1);
                }
                drawTriangle();
            }
        });
        drawMenu.add(triangleItem);

        JMenuItem rectangleItem = new JMenuItem("Draw Rectangle");
        rectangleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        rectangleItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!shapes.isEmpty()) {
                    shapes.remove(shapes.size() - 1);
                }
                drawRectangle();
            }
        });
        drawMenu.add(rectangleItem);

        JMenuItem ellipseItem = new JMenuItem("Draw Ellipse");
        ellipseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        ellipseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!shapes.isEmpty()) {
                    shapes.remove(shapes.size() - 1);
                }
                drawEllipse();
            }
        });
        drawMenu.add(ellipseItem);
    }

    private void drawTriangle() {
        Shape triangle = new Polygon(new int[]{50, 100, 150}, new int[]{150, 50, 150}, 3);
        shapes.add(triangle);
        repaint();
    }

    private void drawRectangle() {
        Shape rectangle = new Rectangle(50, 50, 100, 100);
        shapes.add(rectangle);
        repaint();
    }

    private void drawEllipse() {
        // Draw ellipse logic
        Shape ellipse = new Ellipse2D.Double(50, 50, 100, 100);
        shapes.add(ellipse);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape shape : shapes) {
            g2d.setColor(Color.BLACK);
            g2d.draw(shape);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingMenuExample example = new DrawingMenuExample();
            example.setVisible(true);
        });
    }
}
