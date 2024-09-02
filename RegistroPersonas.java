/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ALEZ ZAVALA
 */
public class RegistroPersonas extends JFrame {
    private JTextField txtNIT, txtNombres, txtApellidos, txtDireccion, txtTelefono, txtNacimiento;
    private JButton btnAgregar, btnActualizar;
    private JTable tabla;
    private DefaultTableModel modelo;

    public RegistroPersonas() {
        setTitle("Registro de Personas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior para el formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(7, 2));

        panelFormulario.add(new JLabel("NIT:"));
        txtNIT = new JTextField();
        panelFormulario.add(txtNIT);

        panelFormulario.add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        panelFormulario.add(txtNombres);

        panelFormulario.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panelFormulario.add(txtApellidos);

        panelFormulario.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelFormulario.add(txtDireccion);

        panelFormulario.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelFormulario.add(txtTelefono);

        panelFormulario.add(new JLabel("Fecha Nacimiento:"));
        txtNacimiento = new JTextField(); // Formato: YYYY-MM-DD
        panelFormulario.add(txtNacimiento);

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnActualizar);

        // Tabla para mostrar datos
        modelo = new DefaultTableModel(new String[]{"ID", "NIT", "Nombres", "Apellidos", "Dirección", "Teléfono", "Nacimiento"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Agregar componentes al frame
        add(panelFormulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Acciones de los botones
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRegistro();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRegistro();
            }
        });
    }

    private void agregarRegistro() {
        String nit = txtNIT.getText();
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String nacimiento = txtNacimiento.getText();

        modelo.addRow(new Object[]{modelo.getRowCount() + 1, nit, nombres, apellidos, direccion, telefono, nacimiento});
        limpiarCampos();
    }

    private void actualizarRegistro() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            modelo.setValueAt(txtNIT.getText(), filaSeleccionada, 1);
            modelo.setValueAt(txtNombres.getText(), filaSeleccionada, 2);
            modelo.setValueAt(txtApellidos.getText(), filaSeleccionada, 3);
            modelo.setValueAt(txtDireccion.getText(), filaSeleccionada, 4);
            modelo.setValueAt(txtTelefono.getText(), filaSeleccionada, 5);
            modelo.setValueAt(txtNacimiento.getText(), filaSeleccionada, 6);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para actualizar");
        }
    }

    private void limpiarCampos() {
        txtNIT.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtNacimiento.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistroPersonas().setVisible(true);
        });
    }
}
