
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
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        svertices = new javax.swing.JTextArea();
        barcosentrantes = new javax.swing.JButton();
        bconexo = new javax.swing.JButton();
        bcantidadislas = new javax.swing.JButton();
        bexistecamino = new javax.swing.JButton();
        bcaminosexistentes = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bcrearvertice = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        svertice2 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        bcantidadcaminos = new javax.swing.JButton();
        bunicocamino = new javax.swing.JButton();
        bdijstra = new javax.swing.JButton();
        besarbolbinario = new javax.swing.JButton();
        bcantarcosent = new javax.swing.JButton();
        bsubgrafo = new javax.swing.JButton();
        BIMPRIMIRGRAFO = new javax.swing.JButton();

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

        jButton1.setText("Crear Vertice");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        svertices.setColumns(20);
        svertices.setRows(5);
        jScrollPane2.setViewportView(svertices);

        barcosentrantes.setText("Arcos Entrantes");
        barcosentrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcosentrantesActionPerformed(evt);
            }
        });

        bconexo.setText("CONEXO");
        bconexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bconexoActionPerformed(evt);
            }
        });

        bcantidadislas.setText("Cantidad de Islas");
        bcantidadislas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcantidadislasActionPerformed(evt);
            }
        });

        bexistecamino.setText("Existe Camino");
        bexistecamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexistecaminoActionPerformed(evt);
            }
        });

        bcaminosexistentes.setText("Caminos Existentes");
        bcaminosexistentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaminosexistentesActionPerformed(evt);
            }
        });

        jButton2.setText("Leer Grafo 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bcrearvertice.setText("Crear Vertice 2");
        bcrearvertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcrearverticeActionPerformed(evt);
            }
        });

        svertice2.setColumns(20);
        svertice2.setRows(5);
        svertice2.setAutoscrolls(false);
        jScrollPane3.setViewportView(svertice2);

        jButton3.setText("Son Iguales");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        bcantidadcaminos.setText("Cantidad de Caminos");
        bcantidadcaminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcantidadcaminosActionPerformed(evt);
            }
        });

        bunicocamino.setText("Unico Camino");
        bunicocamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bunicocaminoActionPerformed(evt);
            }
        });

        bdijstra.setText("Dijstra");
        bdijstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdijstraActionPerformed(evt);
            }
        });

        besarbolbinario.setText("Es Arbol Binario");
        besarbolbinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                besarbolbinarioActionPerformed(evt);
            }
        });

        bcantarcosent.setText("Cantidad Arcos Entrantes");
        bcantarcosent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcantarcosentActionPerformed(evt);
            }
        });

        bsubgrafo.setText("Es SubGrafo");
        bsubgrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsubgrafoActionPerformed(evt);
            }
        });

        BIMPRIMIRGRAFO.setText("IMPRIMIR GRAFO 2");
        BIMPRIMIRGRAFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIMPRIMIRGRAFOActionPerformed(evt);
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCargarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ImprimirGrafo)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bcantarcosent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bunicocamino, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barcosSalientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(barcosentrantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bconexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bcantidadislas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bexistecamino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bcaminosexistentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bcantidadcaminos, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bcrearvertice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bdijstra, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(besarbolbinario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bsubgrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BIMPRIMIRGRAFO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargarGrafo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ImprimirGrafo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barcosSalientes)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(bcrearvertice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barcosentrantes)
                            .addComponent(bdijstra))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bconexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcantidadislas)
                                .addGap(18, 18, 18)
                                .addComponent(bcantarcosent)
                                .addGap(60, 60, 60)
                                .addComponent(bexistecamino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcaminosexistentes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcantidadcaminos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bunicocamino))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(besarbolbinario)
                                .addGap(18, 18, 18)
                                .addComponent(bsubgrafo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BIMPRIMIRGRAFO)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarGrafoActionPerformed
        // TODO add your handling code here:        
            
        
        G.insertarArco(JOptionPane.showInputDialog("Introduzca el vertice de origen:"),JOptionPane.showInputDialog("Introduzca el vertice de destino:") ,Integer.parseInt(JOptionPane.showInputDialog("Introduzca el costo:")));
       
        
            
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
        
        G.ArcosSalientes(JOptionPane.showInputDialog("Introduzca el vertice:"), jta);
    }//GEN-LAST:event_barcosSalientesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
        svertices.setText(" ");
        G.crearVertice(JOptionPane.showInputDialog("Introduzca el vertice:"));             
       
        G.MostrarVertices(svertices);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void barcosentrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcosentrantesActionPerformed
        // TODO add your handling code here:
        jta.setText(" ");
        G.ArcosEntrantes(JOptionPane.showInputDialog("Introduzca el vertice:"), jta);
        
    }//GEN-LAST:event_barcosentrantesActionPerformed

    private void bconexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bconexoActionPerformed
        // TODO add your handling code here:
       
        if(G.esConexo())
        {
            JOptionPane.showMessageDialog(null, "ES CONEXO");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"NO ES CONEXO");
        }
    }//GEN-LAST:event_bconexoActionPerformed

    private void bcantidadislasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcantidadislasActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,String.valueOf(G.CantidadIslas()));
    }//GEN-LAST:event_bcantidadislasActionPerformed

    private void bexistecaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexistecaminoActionPerformed
        // TODO add your handling code here:
        String vi=JOptionPane.showInputDialog("Introduzca el vertice de inicio:");
        String vd=JOptionPane.showInputDialog("Introduzca el vertice de destino:");
        boolean x=G.existeCamino(vi, vd);
        if(x==true) JOptionPane.showMessageDialog(null,"Si hay camino");
        else{
        JOptionPane.showMessageDialog(null,"No hay camino");}
    }//GEN-LAST:event_bexistecaminoActionPerformed

    private void bcaminosexistentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaminosexistentesActionPerformed
        // TODO add your handling code here:
        jta.setText(" ");
         String vi=JOptionPane.showInputDialog("Introduzca el vertice de inicio:");
        String vd=JOptionPane.showInputDialog("Introduzca el vertice de destino:");
        G.MostrarCaminos(vi,vd,jta);
    }//GEN-LAST:event_bcaminosexistentesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         H.insertarArco(JOptionPane.showInputDialog("Introduzca el vertice de origen:"),JOptionPane.showInputDialog("Introduzca el vertice de destino:") ,Integer.parseInt(JOptionPane.showInputDialog("Introduzca el costo:")));
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bcrearverticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcrearverticeActionPerformed
        // TODO add your handling code here:
         svertice2.setText(" ");
        H.crearVertice(JOptionPane.showInputDialog("Introduzca el vertice:"));             
       
        H.MostrarVertices(svertice2);
    }//GEN-LAST:event_bcrearverticeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if(G.iguales(H)) JOptionPane.showMessageDialog(null,"Si son iguales");
        else
        {
            JOptionPane.showMessageDialog(null,"No son iguales");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bcantidadcaminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcantidadcaminosActionPerformed
        // TODO add your handling code here:
        
        jta.setText(" ");
        String vi=JOptionPane.showInputDialog("Introduzca el vertice de inicio:");
        String vd=JOptionPane.showInputDialog("Introduzca el vertice de destino:");
        jta.append(String.valueOf(G.cantidadCaminos(vi, vd)));
    }//GEN-LAST:event_bcantidadcaminosActionPerformed

    private void bunicocaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bunicocaminoActionPerformed
        // TODO add your handling code here:
        jta.setText(" ");
        String vi=JOptionPane.showInputDialog("Introduzca el vertice de inicio:");
        String vd=JOptionPane.showInputDialog("Introduzca el vertice de destino:");
       if(G.unicoCamino(vi, vd))
       {
           jta.append("Si solo tiene un camino");
       }
       else
       {
           jta.append("Tiene mas de un recorrido");
       }
    }//GEN-LAST:event_bunicocaminoActionPerformed

    private void bdijstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdijstraActionPerformed
        // TODO add your handling code here:
         jta.setText(" ");
        String vi=JOptionPane.showInputDialog("Introduzca el vertice de inicio:");
        String vd=JOptionPane.showInputDialog("Introduzca el vertice de destino:");
        G.dijstra(vi, vd, jta);
    }//GEN-LAST:event_bdijstraActionPerformed

    private void besarbolbinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_besarbolbinarioActionPerformed
        // TODO add your handling code here:
        if(G.esArbolBinario())
        {
            JOptionPane.showMessageDialog(null,"ES ARBOL BINARIO");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"NO ES ARBOL BINARIO");
        }
    }//GEN-LAST:event_besarbolbinarioActionPerformed

    private void bcantarcosentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcantarcosentActionPerformed
        // TODO add your handling code here:
       jta.setText(" ");
       
      Vertice v=G.buscarVertice(JOptionPane.showInputDialog("Introduzca el vertice"));
       jta.append(String.valueOf(G.CantidadArcosEntrantes(v)));
    }//GEN-LAST:event_bcantarcosentActionPerformed

    private void bsubgrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsubgrafoActionPerformed
        // TODO add your handling code here:
        
        if(G.esSubGrafo(H))
        {
            JOptionPane.showMessageDialog(null, "Es sub grafo");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No es sub grafo");
        }
        
    }//GEN-LAST:event_bsubgrafoActionPerformed

    private void BIMPRIMIRGRAFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIMPRIMIRGRAFOActionPerformed
        // TODO add your handling code here:
        jta.setText(" ");
        H.imprimir(jta);
    }//GEN-LAST:event_BIMPRIMIRGRAFOActionPerformed

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
    private javax.swing.JButton BIMPRIMIRGRAFO;
    private javax.swing.JToggleButton ImprimirGrafo;
    private javax.swing.JButton barcosSalientes;
    private javax.swing.JButton barcosentrantes;
    private javax.swing.JButton bcaminosexistentes;
    private javax.swing.JButton bcantarcosent;
    private javax.swing.JButton bcantidadcaminos;
    private javax.swing.JButton bcantidadislas;
    private javax.swing.JButton bconexo;
    private javax.swing.JButton bcrearvertice;
    private javax.swing.JButton bdijstra;
    private javax.swing.JButton besarbolbinario;
    private javax.swing.JButton bexistecamino;
    private javax.swing.JButton bsubgrafo;
    private javax.swing.JToggleButton btnCargarGrafo;
    private javax.swing.JButton bunicocamino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jta;
    private javax.swing.JTextArea svertice2;
    private javax.swing.JTextArea svertices;
    // End of variables declaration//GEN-END:variables

}
