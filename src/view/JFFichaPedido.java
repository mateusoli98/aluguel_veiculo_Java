package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;
import controller.Validacoes;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import model.Boleto;
import model.Pagamento;

public class JFFichaPedido extends javax.swing.JFrame {
    
    Validacoes objValidacao = new Validacoes();
    double vPedido;
    
    public JFFichaPedido(Boleto objBoleto, Pagamento objPagamento) {
        initComponents();
        mostraConteudo(objBoleto, objPagamento);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPDF = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPDF.setBackground(new java.awt.Color(1, 111, 185));
        btnPDF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnPDF.setText("Gerar PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 107, 41));

        btnSair.setBackground(new java.awt.Color(197, 36, 39));
        btnSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 107, 41));

        lblTexto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTexto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 355, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 250));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void mostraConteudo(Boleto objBoleto, Pagamento objPagamento) {
        if (objPagamento.getTipoPag().equals("Boleto")) {
            lblTexto.setText("<html><b>Numero: </b>" + objPagamento.getNumPedido() + ""
                    + "<br><b>Data Vencimento: </b>" + objBoleto.getDataVencimento() + ""
                    + "<br><b>Total: </b>" + objPagamento.getTotalPedido() + ""
                    + "<br><b>*Dica: </b> Para consultar suas locações, abra o menu de Locações e em seguida o sub-menu de Minhas Locações"
                    + "</html>");
            
            vPedido = objPagamento.getTotalPedido();
        } else if (objPagamento.getTipoPag().equals("Cartao")) {
            btnPDF.setVisible(false);
            lblTexto.setText("<html><b>Numero: </b>" + objPagamento.getNumPedido() + ""
                    + "<br><b>Data Vencimento: </b>" + objBoleto.getDataVencimento() + ""
                    + "<br><b>Total: </b>" + objPagamento.getTotalPedido() + ""
                    + "<br><b>*Dica: </b> Para consultar suas locações, abra o menu de Locações e em seguida o sub-menu de Minhas Locações"
                    + "</html>");
            
        }
        
    }

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("boleto.pdf"));
            document.open();
            document.add(geraDadosTabela());
        } catch (DocumentException ex) {
            System.out.println("Error:" + ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex);
        } finally {
            document.close();
        }
        
        try {
            Desktop.getDesktop().open(new File("boleto.pdf"));
            dispose();
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed
    
    Element geraDadosTabela() {
        PdfPTable table = new PdfPTable(3);
        
        PdfPCell c1 = new PdfPCell(new Phrase("Locações A&Ms"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("237-2"));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setBorderWidthLeft(0);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("92073072623903973171"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorderWidthLeft(0);
        table.addCell(c1);
        
        table.setSpacingBefore(10);
        PdfPCell c2 = new PdfPCell();
        c2 = new PdfPCell(new Phrase("Local de pagamento: AGÊNCIAS BANCARIAS E/OU LOTÉRICA"));
        c2.setColspan(2);
        c2.setRowspan(2);
        c2.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c2);
        
        c2 = new PdfPCell(new Phrase("Vencimento: " + objValidacao.dataAtual()));
        c2.setHorizontalAlignment(Element.ALIGN_LEFT);
        c2.setBorderWidthTop(0);
        c2.setBorderWidthLeft(0);
        c2.setColspan(2);
        c2.setRowspan(2);
        table.addCell(c2);
        
        c2 = new PdfPCell(new Phrase("Av. Brasil, 366 - Jardim Amanda - Hortolândia/SP - (19) 3897-3105"));
        c2.setHorizontalAlignment(Element.ALIGN_LEFT);
        c2.setBorderWidthTop(0);
        c2.setColspan(2);
        c2.setRowspan(2);
        table.addCell(c2);
        
        table.setSpacingBefore(10);
        PdfPCell c3 = new PdfPCell();
        
        c3 = new PdfPCell(new Phrase("Cedente: Locações A&Ms LTDA"));
        c3.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c3);
        
        c3 = new PdfPCell(new Phrase("Data de documento: " + objValidacao.dataAtual()));
        c3.setHorizontalAlignment(Element.ALIGN_LEFT);
        c3.setBorderWidthTop(0);
        c3.setBorderWidthLeft(0);
        table.addCell(c3);
        
        table.setSpacingBefore(10);
        PdfPCell c4 = new PdfPCell();
        
        c4 = new PdfPCell(new Phrase("Não receber após a data de vencimento. Será cobrado 0,10/dia"));
        c4.setHorizontalAlignment(Element.ALIGN_LEFT);
        c4.setPadding(50);
        c4.setColspan(3);
        c4.setRowspan(3);
        table.addCell(c4);
        
        table.setSpacingBefore(10);
        PdfPCell c5 = new PdfPCell();
        c5 = new PdfPCell(new Phrase("aqui vai a img de um codigo de barra"));
        c5.setColspan(2);
        c5.setRowspan(2);
        c5.setPadding(5);
        c5.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c5);
        
        c5 = new PdfPCell(new Phrase("Valor do documento: R$ " + vPedido));
        c5.setHorizontalAlignment(Element.ALIGN_LEFT);
        c5.setBorderWidthTop(0);
        c5.setBorderWidthLeft(0);
        c5.setColspan(2);
        c5.setRowspan(2);
        table.addCell(c5);
        
        return table;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTexto;
    // End of variables declaration//GEN-END:variables
}
