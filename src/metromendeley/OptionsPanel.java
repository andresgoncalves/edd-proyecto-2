package metromendeley;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class OptionsPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public OptionsPanel() {
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
        loadSummaryButton = new javax.swing.JButton();
        searchAuthorButton = new javax.swing.JButton();
        searchKeywordButton = new javax.swing.JButton();
        analyzeSummaryButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("Seleccione una opción");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(titleLabel, gridBagConstraints);

        loadSummaryButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loadSummaryButton.setText("Cargar resumen");
        loadSummaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadSummaryButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 207;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 100);
        add(loadSummaryButton, gridBagConstraints);

        searchAuthorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchAuthorButton.setText("Buscar autor");
        searchAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAuthorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 244;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 100);
        add(searchAuthorButton, gridBagConstraints);

        searchKeywordButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchKeywordButton.setText("Buscar palabra clave");
        searchKeywordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKeywordButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 100);
        add(searchKeywordButton, gridBagConstraints);

        analyzeSummaryButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        analyzeSummaryButton.setText("Analizar resumen");
        analyzeSummaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzeSummaryButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 238;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 100);
        add(analyzeSummaryButton, gridBagConstraints);

        closeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        closeButton.setText("Cerrar programa");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 238;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 100);
        add(closeButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void analyzeSummaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzeSummaryButtonActionPerformed
        App.getInstance().showAnalyze();
    }//GEN-LAST:event_analyzeSummaryButtonActionPerformed

    private void searchKeywordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKeywordButtonActionPerformed
       App.getInstance().showSearchByKeyword();
    }//GEN-LAST:event_searchKeywordButtonActionPerformed

    private void searchAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAuthorButtonActionPerformed
        App.getInstance().showSearchByAuthor();
    }//GEN-LAST:event_searchAuthorButtonActionPerformed

    private void loadSummaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadSummaryButtonActionPerformed
        fileChooser.setMultiSelectionEnabled(true);
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            try{
                for(File file : files) {
                    Summary summary = Database.loadSummary(file);
                    App.getInstance().registerSummary(summary);
                }
                JOptionPane.showMessageDialog(null, "Carga Exitosa");
                App.getInstance().saveState();
            } catch(DuplicateKeyException ex){
                JOptionPane.showMessageDialog(this, "Este resumen ya fue cargado", "Resumen duplicado", JOptionPane.WARNING_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se encontró el archivo", "Archivo no encontrado", JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error de lectura", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "El archivo no es un archivo de resumen", "Error de formato", JOptionPane.WARNING_MESSAGE);
            } 
        }
    }//GEN-LAST:event_loadSummaryButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        App.getInstance().dispose();
    }//GEN-LAST:event_closeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analyzeSummaryButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton loadSummaryButton;
    private javax.swing.JButton searchAuthorButton;
    private javax.swing.JButton searchKeywordButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
