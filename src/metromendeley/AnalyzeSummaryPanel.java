package metromendeley;

/**
 *
 * @author USUARIO
 */
public class AnalyzeSummaryPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalizeSummary
     */
    public AnalyzeSummaryPanel() {
        initComponents();
    }
    
    public void updateSummaries(List<Summary> summaries) {
        authorsTextArea.setText("");
        keywordsTextArea.setText("");
        summariesComboBox.removeAllItems();
        for(ListNode<Summary> node = summaries.getFirst(); node != null; node = node.getNext()) {
            summariesComboBox.addItem(node.getValue().getTitle());
        }
    }
    
    public void setSummary(Summary summary){
        
        titleTextField.setText(summary.getTitle());
        bodyTextArea.setText(summary.getBody());
        
        authorsTextArea.setText("");
        for(String author : summary.getAuthors()) {
            authorsTextArea.append(String.format("%s\n", author));
        }      
        
        keywordsTextArea.setText("");
        int i = 0;
        for(String keyword : summary.getKeywords()) {
            keywordsTextArea.append(String.format("%s (%d apariciones)\n", keyword, summary.getKeywordAppearances()[i++]));
        }
        
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

        centerPanel = new javax.swing.JPanel();
        selectLabel = new javax.swing.JLabel();
        summariesComboBox = new javax.swing.JComboBox<>();
        titleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        bodyLabel = new javax.swing.JLabel();
        bodyScrollPane = new javax.swing.JScrollPane();
        bodyTextArea = new javax.swing.JTextArea();
        authorsLabel = new javax.swing.JLabel();
        keywordsLabel = new javax.swing.JLabel();
        authorsScrollPane = new javax.swing.JScrollPane();
        authorsTextArea = new javax.swing.JTextArea();
        keywordsScrollPane = new javax.swing.JScrollPane();
        keywordsTextArea = new javax.swing.JTextArea();
        bottomPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new java.awt.BorderLayout());

        centerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 40, 20, 40));
        centerPanel.setLayout(new java.awt.GridBagLayout());

        selectLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectLabel.setText("Seleccione un Resumen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        centerPanel.add(selectLabel, gridBagConstraints);

        summariesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        summariesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summariesComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        centerPanel.add(summariesComboBox, gridBagConstraints);

        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("Título del Resumen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        centerPanel.add(titleLabel, gridBagConstraints);

        titleTextField.setEditable(false);
        titleTextField.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        centerPanel.add(titleTextField, gridBagConstraints);

        bodyLabel.setForeground(new java.awt.Color(0, 0, 0));
        bodyLabel.setText("Cuerpo del Resumen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 0);
        centerPanel.add(bodyLabel, gridBagConstraints);

        bodyTextArea.setEditable(false);
        bodyTextArea.setColumns(20);
        bodyTextArea.setLineWrap(true);
        bodyTextArea.setRows(5);
        bodyScrollPane.setViewportView(bodyTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        centerPanel.add(bodyScrollPane, gridBagConstraints);

        authorsLabel.setForeground(new java.awt.Color(0, 0, 0));
        authorsLabel.setText("Autores del Resumen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 0);
        centerPanel.add(authorsLabel, gridBagConstraints);

        keywordsLabel.setForeground(new java.awt.Color(0, 0, 0));
        keywordsLabel.setText("Palabras Claves:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 0);
        centerPanel.add(keywordsLabel, gridBagConstraints);

        authorsTextArea.setEditable(false);
        authorsTextArea.setColumns(20);
        authorsTextArea.setRows(5);
        authorsScrollPane.setViewportView(authorsTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        centerPanel.add(authorsScrollPane, gridBagConstraints);

        keywordsTextArea.setEditable(false);
        keywordsTextArea.setColumns(20);
        keywordsTextArea.setRows(5);
        keywordsScrollPane.setViewportView(keywordsTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        centerPanel.add(keywordsScrollPane, gridBagConstraints);

        add(centerPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 40, 20, 40));
        bottomPanel.setLayout(new java.awt.GridBagLayout());

        backButton.setText("Volver");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        bottomPanel.add(backButton, gridBagConstraints);

        add(bottomPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void summariesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summariesComboBoxActionPerformed
        String selected = (String) summariesComboBox.getSelectedItem();
        if(selected != null) {
            setSummary(App.getInstance().getSummaryByTitle(selected));
        }
    }//GEN-LAST:event_summariesComboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        App.getInstance().showMenu();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorsLabel;
    private javax.swing.JScrollPane authorsScrollPane;
    private javax.swing.JTextArea authorsTextArea;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel bodyLabel;
    private javax.swing.JScrollPane bodyScrollPane;
    private javax.swing.JTextArea bodyTextArea;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel keywordsLabel;
    private javax.swing.JScrollPane keywordsScrollPane;
    private javax.swing.JTextArea keywordsTextArea;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JComboBox<String> summariesComboBox;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    // End of variables declaration//GEN-END:variables
}
