package NHF;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

public class HirlapFrame extends JFrame {
    private HirlapData data;

    private void initComponents() {
        this.setLayout(new BorderLayout());
        JTable table = new JTable(data); //2. feladat
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);

        table.setRowSorter(new TableRowSorter<>(table.getModel()));

    }

    class KonyvTableCellRenderer implements TableCellRenderer {

        private TableCellRenderer renderer;

        public KonyvTableCellRenderer(TableCellRenderer defRenderer) {
            this.renderer = defRenderer;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            Component component = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

            data.fireTableRowsUpdated(row, row);
            return component;
        }
    }
    public HirlapFrame(ArrayList<Hirlap> kell){
        super("Keresési eredmények");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        data = new HirlapData();
        data.keres = kell;
        this.setMinimumSize(new Dimension(700, 200));
        initComponents();
    }
}
