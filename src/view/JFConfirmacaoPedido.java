
package view;

public class JFConfirmacaoPedido extends javax.swing.JFrame {

    public JFConfirmacaoPedido() {
        initComponents();
        jLabel1.setText("<html><b><center>ESTAMOS QUASÉ LA!!!</center></b><br>Seu pedido de locação do veiculo: nome, foi concluido com sucesso!"
                + "<br>Já enviamos para seu endereço de email, o valor do pedido e a localização para você realizar o pagamento e retirar seu veiculo."
                 + "<br>Obs.: Você deve ir até nossa localização para buscar seu veiculo locado, até o seu primeiro de locação."
                + "<br>Por enquanto, é isso, qualquer duvida, entre em contato conosco, aproveite!</html>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmação Pedido");
        setName(""); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("ESTAMOS QUASE LÁ!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
