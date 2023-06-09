package metromendeley;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class WelcomePanel extends javax.swing.JPanel {

    /**
     * Creates new form textPanel
     */
    public WelcomePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooser = new javax.swing.JFileChooser();
        titleLabel = new javax.swing.JLabel();
        createDatabaseButton = new javax.swing.JButton();
        loadDatabaseButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("Bienvenidos a Metromendeley");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(titleLabel, gridBagConstraints);

        createDatabaseButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createDatabaseButton.setText("Crear nueva base de datos");
        createDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDatabaseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 244;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 100);
        add(createDatabaseButton, gridBagConstraints);

        loadDatabaseButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loadDatabaseButton.setText("Cargar base de datos existente");
        loadDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDatabaseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 207;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 100);
        add(loadDatabaseButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void loadDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDatabaseButtonActionPerformed
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try{
                List<Summary> summaries = Database.loadState(file);
                for(ListNode<Summary> node = summaries.getFirst(); node != null; node = node.getNext()) {
                    App.getInstance().registerSummary(node.getValue());
                }
                App.getInstance().setDatabaseFile(file);
                JOptionPane.showMessageDialog(null, "Carga Exitosa");
                App.getInstance().showMenu();
            } catch(DuplicateKeyException ex){
                JOptionPane.showMessageDialog(this, "Se encontraron resumenes repetidos", "Resumen duplicado", JOptionPane.WARNING_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se encontró el archivo", "Archivo no encontrado", JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error de lectura", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "El archivo no es un archivo de base de datos", "Error de formato", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_loadDatabaseButtonActionPerformed

    private void createDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDatabaseButtonActionPerformed
        fileChooser.setSelectedFile(new File("metromendeley-db.txt"));
        if(fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if(!file.exists()) {
                App.getInstance().setDatabaseFile(file);
                App.getInstance().showMenu();
            }
            else {
                JOptionPane.showMessageDialog(this, "Seleccione un archivo nuevo", "Archivo existente", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_createDatabaseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createDatabaseButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton loadDatabaseButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
