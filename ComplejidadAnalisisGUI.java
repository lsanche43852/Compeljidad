import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout; // Importación de BorderLayout

public class ComplejidadAnalisisGUI extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;

    public ComplejidadAnalisisGUI() {
        setTitle("Análisis de Complejidad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Uso correcto de BorderLayout

        // Crear tabla
        String[] columnNames = {"n", "T(n)", "c * n^3"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER); // Uso correcto de BorderLayout

        // Solicitar número de iteraciones
        String input = JOptionPane.showInputDialog(this, "Ingrese el número de iteraciones:");
        int iteraciones = Integer.parseInt(input);

        // Calcular y mostrar datos
        calcularYMostrarDatos(iteraciones);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcularYMostrarDatos(int iteraciones) {
        for (int i = 0; i < iteraciones; i++) {
            int n = i + 1;
            long tn = calcularT(n);
            long cn3 = (long) (4 * Math.pow(n, 3));
            tableModel.addRow(new Object[]{n, tn, cn3});
        }
    }

    private long calcularT(int n) {
        return (long) (4 * Math.pow(n, 3) - 2 * n - 1);
    }

    public static void main(String[] args) {
        new ComplejidadAnalisisGUI();
    }
}