import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PiselloColorato extends JFrame {
    private JPanel rettangoloPanel;
    private JButton cambiaColoreButton;

    public PiselloColorato() {
        setTitle("Pisello Colorato");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inizializzazione del pannello
        rettangoloPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawRettangoloConCerchi(g);
            }
        };

        // Impostazione del layout
        setLayout(new BorderLayout());
        add(rettangoloPanel, BorderLayout.CENTER);

        // Creazione del bottone
        cambiaColoreButton = new JButton("Cambia colore");
        cambiaColoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rettangoloPanel.repaint(); // Ridisegna il pannello
            }
        });

        // Aggiunta del bottone al pannello
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cambiaColoreButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void drawRettangoloConCerchi(Graphics g) {
        int panelWidth = rettangoloPanel.getWidth();
        int panelHeight = rettangoloPanel.getHeight();

        // Calcolo delle dimensioni del rettangolo
        int rectangleWidth = panelWidth / 6;
        int rectangleHeight = panelHeight * 3 / 5;

        // Calcolo delle coordinate del rettangolo
        int rectangleX = panelWidth / 2 - rectangleWidth / 2;
        int rectangleY = panelHeight / 8 + 20;

        // Disegno del rettangolo
        g.setColor(getRandomColor());
        g.fillRect(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        // Calcolo delle dimensioni dei cerchi
        int circleDiameter = rectangleWidth + 15;

        // Calcolo delle coordinate del primo cerchio
        int circle1X = rectangleX + rectangleWidth / 4 - circleDiameter / 2 - 20;
        int circle1Y = rectangleY + rectangleHeight/2 + 55;

        // Calcolo delle coordinate del secondo cerchio
        int circle2X = rectangleX + rectangleWidth * 3 / 4 - circleDiameter / 2 + 20;
        int circle2Y = rectangleY + rectangleHeight/2 + 55;

        // Disegno dei cerchi
        g.setColor(getRandomColor());
        g.fillOval(circle1X, circle1Y, circleDiameter, circleDiameter);
        g.setColor(getRandomColor());
        g.fillOval(circle2X, circle2Y, circleDiameter, circleDiameter);

        // Calcolo delle dimensioni e delle coordinate del semicerchio
        int semicircleRadius = rectangleWidth / 2;
        int semicircleX = rectangleX + rectangleWidth / 2 - semicircleRadius;
        int semicircleY = rectangleY - semicircleRadius;

        // Disegno del semicerchio
        g.setColor(getRandomColor());
        g.fillArc(semicircleX, semicircleY, semicircleRadius * 2, semicircleRadius * 2, 0, 180);
    }

    private Color getRandomColor() {
        // Genera un colore casuale
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PiselloColorato rettangoloConCerchi = new PiselloColorato();
                rettangoloConCerchi.setVisible(true);
            }
        });
    }
}

