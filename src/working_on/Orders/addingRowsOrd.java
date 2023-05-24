package working_on.Orders;

import working_on.DbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class addingRowsOrd extends JFrame implements ActionListener {

    DbConnection db = new DbConnection();
    Connection conn = db.connect_to_db("pharmacy_base", "postgres", "qwe123");
    JFrame forAdding = new JFrame("Добавление заказов");
    JButton addingRow, getBackButton;
    JTextField text1, text2, text3, text4, text5, text6, text7;
    JLabel n1, n2, n3, n4, n5, n6, n7;
    public addingRowsOrd() {
        forAdding.getContentPane().setLayout(new GridBagLayout());
        forAdding.setLocationRelativeTo(null);
        forAdding.setSize(new Dimension(1000, 400));
        forAdding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addingRow = new JButton("Принять");
        getBackButton = new JButton("Назад");
        addingRow.addActionListener(this);
        getBackButton.addActionListener(this);

        n1 = new JLabel("Номер заказа");
        n2 = new JLabel("Номер рецепта");
        n3 = new JLabel("Дата приема");
        n4 = new JLabel("Дата изготовления");
        n5 = new JLabel("Дата выдачи");
        n6 = new JLabel("Стоимость");
        n7 = new JLabel("Статус");

        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        text5 = new JTextField();
        text6 = new JTextField();
        text7 = new JTextField();

        text1.setPreferredSize(new Dimension(240, 40));
        text2.setPreferredSize(new Dimension(240, 40));
        text3.setPreferredSize(new Dimension(240, 40));
        text4.setPreferredSize(new Dimension(240, 40));
        text5.setPreferredSize(new Dimension(240, 40));
        text6.setPreferredSize(new Dimension(240, 40));
        text7.setPreferredSize(new Dimension(240, 40));

        forAdding.add(n1, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(n2, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(n3, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(n4, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(n5, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(n6, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(n7, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));

        forAdding.add(text1, new GridBagConstraints(1, 0, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(text2, new GridBagConstraints(1, 1, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(text3, new GridBagConstraints(1, 2, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(text4, new GridBagConstraints(1, 3, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(text5, new GridBagConstraints(1, 4, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(text6, new GridBagConstraints(1, 5, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(text7, new GridBagConstraints(1, 6, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));

        forAdding.add(addingRow, new GridBagConstraints(0, 8, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        forAdding.add(getBackButton, new GridBagConstraints(1, 8, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));

        forAdding.setVisible(true);
        forAdding.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) throws NullPointerException {
        if (e.getSource()==addingRow) {
            try {
                OrdersTableModel arord = new OrdersTableModel();
                arord.insert_data_ord(conn, "pharmacy_db.Заказы", Integer.parseInt(text1.getText()), Integer.parseInt(text2.getText()),
                        text3.getText(), text4.getText(), text5.getText(), Integer.parseInt(text6.getText()), text7.getText());
                JOptionPane.showMessageDialog(null, "Данные добавлены в базу! " +
                                "Примечание: если данные не добавлены, значит номер " +
                                "добавляемого заказа уже есть в базе.",
                        "Подтверждение", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception w) {
                System.out.println(w);
                JOptionPane.showMessageDialog(null, "Проверьте " +
                                "корректность введённых данных. Поля номер заказа, рецепта, " +
                                "даты должны быть вписаны.", "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource()==getBackButton) {
            forAdding.dispose();
            new TableOrders();
        }
    }
}