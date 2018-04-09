
import javax.swing.*;
import java.util.ArrayList;
public class frmGrafos extends javax.swing.JFrame {
 Grafo G;
 Grafo H;
 
    /** Creates new form Formulario */
    public frmGrafos() {
        initComponents();
        G=new Grafo();
        H=new Grafo();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCargarGrafo = new javax.swing.JToggleButton();
        ImprimirGrafo = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        barcosSalientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("GRAFOS DIRIGIDOS");

        btnCargarGrafo.setText("Leer Grafo");
        btnCargarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarGrafoActionPerformed(evt);
            }
        });

        ImprimirGrafo.setText("Imprimir Grafo");
        ImprimirGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirGrafoActionPerformed(evt);
            }
        });

        jta.setColumns(20);
        jta.setRows(5);
        jScrollPane1.setViewportView(jta);

        jButton9.setText("DFS");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton5.setText("BFS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        barcosSalientes.setText("Arcos Salientes");
        barcosSalientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcosSalientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnCargarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ImprimirGrafo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(barcosSalientes))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCargarGrafo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ImprimirGrafo)
                        .addComponent(barcosSalientes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarGrafoActionPerformed
        // TODO add your handling code here:        
        G.crearVertice("A");             
        G.crearVertice("B");         
        G.crearVertice("C");     
        G.crearVertice("D");     
        
        G.insertarArco("A", "B", 2);
        G.insertarArco("A", "D", 8);        
        G.insertarArco("B", "C", 3);
        G.insertarArco("B", "D", 4);        
        G.insertarArco("C", "A", 5);
        G.insertarArco("D", "C", 7);
        
            
    }//GEN-LAST:event_btnCargarGrafoActionPerformed

    private void ImprimirGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirGrafoActionPerformed
        // TODO add your handling code here:   
        //G.ordenarVertices();
       jta.setText(" ");
      
        G.imprimir(jta);
    }//GEN-LAST:event_ImprimirGrafoActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String A=JOptionPane.showInputDialog("Vertice inicial (DFS):");        
        G.ordenarVerticesAlf();                
        G.DFS(A,jta);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String A=JOptionPane.showInputDialog("Vertice inicial (BFS):");        
        G.ordenarVerticesAlf();        
        G.BFS(A,jta);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void barcosSalientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcosSalientesActionPerformed
        // TODO add your handling code here:
        jta.setText(" ");
        G.ArcosSalientes("A", jta);
    }//GEN-LAST:event_barcosSalientesActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGrafos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ImprimirGrafo;
    private javax.swing.JButton barcosSalientes;
    private javax.swing.JToggleButton btnCargarGrafo;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jta;
    // End of variables declaration//GEN-END:variables

}
