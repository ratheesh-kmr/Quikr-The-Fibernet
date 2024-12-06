package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillingDialog extends JDialog {

    public BillingDialog(JFrame parent) {
        super(parent, "Billing", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(parent);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();
                Color startColor = new Color(255, 0, 0); // Red
                Color endColor = new Color(255, 100, 100); // Lighter Red
                GradientPaint gradientPaint = new GradientPaint(0, 0, startColor, width, height, endColor);
                g2d.setPaint(gradientPaint);
                g2d.fillRoundRect(0, 0, width, height, 20, 20); // Rounded rectangle
                g2d.dispose();
            }
        };
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Billing System");
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);

        JPanel contentPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        contentPanel.setOpaque(false);

        // Example components for billing functionalities
        JLabel customerLabel = new JLabel("Customer Name:");
        JTextField customerTextField = new JTextField(20);
        customerLabel.setForeground(Color.WHITE);

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountTextField = new JTextField(10);
        amountLabel.setForeground(Color.WHITE);

        JLabel billingDateLabel = new JLabel("Billing Date:");
        JTextField billingDateTextField = new JTextField(10);
        billingDateLabel.setForeground(Color.WHITE);

        JLabel billingPeriodLabel = new JLabel("Billing Period:");
        JTextField billingPeriodTextField = new JTextField(10);
        billingPeriodLabel.setForeground(Color.WHITE);

        JLabel planLabel = new JLabel("Select Plan:");
        String[] plans = {"Plan A", "Plan B", "Plan C"}; // Example plan options
        JComboBox<String> planComboBox = new JComboBox<>(plans);
        planLabel.setForeground(Color.WHITE);

        JButton generateBillButton = new JButton("Generate Bill");
        generateBillButton.setForeground(Color.WHITE);
        generateBillButton.setBackground(new Color(255, 0, 0));
        generateBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement bill generation logic here
                // For example, calculate total amount and generate bill
                String customerName = customerTextField.getText();
                double amount = Double.parseDouble(amountTextField.getText());
                String selectedPlan = (String) planComboBox.getSelectedItem();
                // Generate bill or perform other actions
                JOptionPane.showMessageDialog(BillingDialog.this, "Bill generated for " + customerName + " with amount $" + amount + " for " + selectedPlan);
            }
        });

        JLabel payLabel = new JLabel("Pay:");
        JButton payButton = new JButton("Pay Now");
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(new Color(0, 128, 0)); // Dark green
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement payment logic here
                JOptionPane.showMessageDialog(BillingDialog.this, "Payment process initiated.");
            }
        });

        contentPanel.add(customerLabel);
        contentPanel.add(customerTextField);
        contentPanel.add(amountLabel);
        contentPanel.add(amountTextField);
        contentPanel.add(billingDateLabel);
        contentPanel.add(billingDateTextField);
        contentPanel.add(billingPeriodLabel);
        contentPanel.add(billingPeriodTextField);
        contentPanel.add(planLabel);
        contentPanel.add(planComboBox);
        contentPanel.add(payLabel);
        contentPanel.add(payButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(generateBillButton, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BillingDialog billingDialog = new BillingDialog(null);
            billingDialog.setVisible(true);
        });
    }
}
