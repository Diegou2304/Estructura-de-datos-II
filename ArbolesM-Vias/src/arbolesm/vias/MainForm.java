/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesm.vias;
import javax.swing.JOptionPane;
/**
 *
 * @author Diego U
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    ArbolM arbol=new ArbolM();
    public MainForm() {
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

        Insertar = new javax.swing.JButton();
        INORDEN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Salida = new javax.swing.JTextArea();
        PreOrden = new javax.swing.JButton();
        PostOrden = new javax.swing.JButton();
        Altura = new javax.swing.JButton();
        Suma = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        Niveles = new javax.swing.JButton();
        SumaNiveles = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        BuscarNodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Insertar.setText("INSERTAR");
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        INORDEN.setText("INORDEN");
        INORDEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INORDENActionPerformed(evt);
            }
        });

        Salida.setColumns(20);
        Salida.setRows(5);
        jScrollPane2.setViewportView(Salida);

        PreOrden.setText("PREORDEN");
        PreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreOrdenActionPerformed(evt);
            }
        });

        PostOrden.setText("POSTORDEN");
        PostOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostOrdenActionPerformed(evt);
            }
        });

        Altura.setText("ALTURA");
        Altura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlturaActionPerformed(evt);
            }
        });

        Suma.setText("SUMA ELEMENTOS");
        Suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SumaActionPerformed(evt);
            }
        });

        Buscar.setText("BUSCAR");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Niveles.setText("BUSQUEDA POR NIVELES");
        Niveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivelesActionPerformed(evt);
            }
        });

        SumaNiveles.setText("SUMA NIVELES");
        SumaNiveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SumaNivelesActionPerformed(evt);
            }
        });

        Clear.setText("CLEAR");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        BuscarNodo.setText("BUSCAR NODO");
        BuscarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(INORDEN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PreOrden, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Insertar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Clear)
                        .addGap(257, 257, 257))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Buscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Suma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Altura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PostOrden, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                            .addComponent(Niveles))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SumaNiveles, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(BuscarNodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PreOrden)
                        .addGap(18, 18, 18)
                        .addComponent(INORDEN))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear))
                .addGap(18, 18, 18)
                .addComponent(PostOrden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Altura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Suma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buscar)
                .addGap(18, 18, 18)
                .addComponent(Niveles)
                .addGap(18, 18, 18)
                .addComponent(SumaNiveles)
                .addGap(18, 18, 18)
                .addComponent(BuscarNodo)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        // TODO add your handling code here:
       
       
            int dato=Integer.parseInt(JOptionPane.showInputDialog("Introduzca elemento"));
            arbol.Insertar(dato);
             

        
        
       
        
    }//GEN-LAST:event_InsertarActionPerformed

    private void INORDENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INORDENActionPerformed
        // TODO add your handling code here:
       
     Salida.setText("");
        arbol.InOrden(Salida); 
    }//GEN-LAST:event_INORDENActionPerformed

    private void PreOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreOrdenActionPerformed
        // TODO add your handling code here:
        Salida.setText("");
        arbol.PreOrden(Salida); 
    }//GEN-LAST:event_PreOrdenActionPerformed

    private void PostOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostOrdenActionPerformed
        // TODO add your handling code here:
          Salida.setText("");
        arbol.PostOrden(Salida);
        
    }//GEN-LAST:event_PostOrdenActionPerformed

    private void AlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlturaActionPerformed
        // TODO add your handling code here:
        Salida.setText(String.valueOf(arbol.Altura()));
    }//GEN-LAST:event_AlturaActionPerformed

    private void SumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SumaActionPerformed
        // TODO add your handling code here:
        Salida.setText("");
        Salida.setText(String.valueOf(arbol.SumaElementos()));
    }//GEN-LAST:event_SumaActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        int dato=Integer.parseInt(JOptionPane.showInputDialog("Introduzca elemento a buscar"));
        
       if(arbol.Existe(dato))
        {
            JOptionPane.showMessageDialog(null,"EL DATO EXISTE");

            
        }
       else
       {
           JOptionPane.showMessageDialog(null,"EL DATO NO EXISTE");

       }
               
    }//GEN-LAST:event_BuscarActionPerformed

    private void NivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivelesActionPerformed
        // TODO add your handling code here:
        int dato=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el nivel del cual quiere ver los elementos"));
        Salida.setText(" ");
        arbol.Nivel(dato, Salida);
        
    }//GEN-LAST:event_NivelesActionPerformed

    private void SumaNivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SumaNivelesActionPerformed
        // TODO add your handling code here:
        int dato=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el nivel para realizar la suma de los mismos"));
        Salida.setText(" ");
       Salida.setText(String.valueOf (arbol.SumaNivel(dato)));//Esto retorna un dato
    }//GEN-LAST:event_SumaNivelesActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearActionPerformed

    private void BuscarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNodoActionPerformed
        // TODO add your handling code here:
        Salida.setText(" ");
        int dato=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el elemento para buscar su nodo"));
        Nodo N=arbol.BuscarNodo(dato);
        if(N!=null)
        {
            for (int i = 1; i <= N.CantOcupados(); i++) 
           {
            Salida.append(String.valueOf(N.getElem(i))+ " ");
            
           }
        }
        else
        {
         JOptionPane.showMessageDialog(null,"EL ELEMENTO INGRESADO NO ESTA EN EL ARBOL, POR LO TANTO NO TIENE NODO");   
        }
    }//GEN-LAST:event_BuscarNodoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Altura;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton BuscarNodo;
    private javax.swing.JButton Clear;
    private javax.swing.JButton INORDEN;
    private javax.swing.JButton Insertar;
    private javax.swing.JButton Niveles;
    private javax.swing.JButton PostOrden;
    private javax.swing.JButton PreOrden;
    private javax.swing.JTextArea Salida;
    private javax.swing.JButton Suma;
    private javax.swing.JButton SumaNiveles;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
