package com.mycompany.tiendasarita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaSarita {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TiendaSarita().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Tienda Sarita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblCliente = new JLabel("Nombre del Cliente:");
        JTextField txtCliente = new JTextField(15);
        JLabel lblMembresia = new JLabel("¿Tiene membresía?");
        JCheckBox chkMembresia = new JCheckBox("Sí");
        JLabel lblMontoCompra = new JLabel("Monto de la Compra:");
        JTextField txtMontoCompra = new JTextField(10);
        JButton btnCalcular = new JButton("Calcular Descuento");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(lblCliente, gbc);
        gbc.gridx = 1;
        frame.add(txtCliente, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(lblMembresia, gbc);
        gbc.gridx = 1;
        frame.add(chkMembresia, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(lblMontoCompra, gbc);
        gbc.gridx = 1;
        frame.add(txtMontoCompra, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        frame.add(btnCalcular, gbc);
        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDescuento(txtCliente.getText(), chkMembresia.isSelected(), txtMontoCompra.getText());
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void calcularDescuento(String cliente, boolean esMiembro, String montoTexto) {
        try {
            float montoCompra = Float.parseFloat(montoTexto);
            float mDescuento = 1250;
            double descuento1 = 0.1;
            double descuento2 = 0.05;
            double total = montoCompra;
            double descuentoAplicado = 0;
            String porcentajeDescuento = "0%";
            
            if (montoCompra >= mDescuento && esMiembro) {
                descuentoAplicado = montoCompra * descuento1;
                porcentajeDescuento = "10%";
            } else if (montoCompra >= mDescuento || esMiembro) {
                descuentoAplicado = montoCompra * descuento2;
                porcentajeDescuento = "5%";
            }
            total -= descuentoAplicado;
            
            mostrarResultado(cliente, montoCompra, porcentajeDescuento, descuentoAplicado, total);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un monto válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarResultado(String cliente, float montoCompra, String porcentajeDescuento, double descuentoAplicado, double total) {
        JFrame resultFrame = new JFrame("Detalle de Compra");
        resultFrame.setSize(500, 200);
        
        String[] columnNames = {"Cliente", "Monto Compra", "% Descuento", "Total Descuento", "Total"};
        Object[][] data = {
            {cliente, "Q " + montoCompra, porcentajeDescuento, "Q " + descuentoAplicado, "Q " + total}
        };
        
        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);
        
        resultFrame.add(scrollPane);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);
         System.out.println("Prueba de texto en este apartado");
         
    }
}
