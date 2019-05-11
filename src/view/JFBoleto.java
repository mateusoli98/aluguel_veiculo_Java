package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Image;
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

public class JFBoleto extends javax.swing.JFrame {

    Validacoes objValidacao = new Validacoes();

    public JFBoleto() {
        initComponents();
//        lblTexto.setText("<html><b>Numero do pedido: </b>" + objBoleto.getNumPedido() + ""
//                + "<br><b>Data Vencimento: </b>" + objBoleto.getDataVencimento() + ""
//                + "<br><b>Total Pedido: </b>" + objBoleto.getTotalPedido() + ""
//                + "</html>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPDF = new javax.swing.JButton();
        lblTexto = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BOLETO DE COBRANÇA");

        btnPDF.setText("Imprimir PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        lblTexto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTexto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void adcLinhaVazia(Paragraph p, int n) {
        for (int i = 0; i < n; i++) {
            p.add(new Paragraph(" "));
        }
    }

    Element tableteste() {
        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("Locações A&Ms"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorderWidthTop(0);
        c1.setBorderWidthLeft(0);
        c1.setBorderWidthRight(0);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("237-2"));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setBorderWidthTop(0);
        c1.setBorderWidthLeft(0);
        c1.setBorderWidthRight(0);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("92073072623903973171"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorderWidthTop(0);
        c1.setBorderWidthLeft(0);
        c1.setBorderWidthRight(0);
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

        c2 = new PdfPCell(new Phrase("Não receber após a data de vencimento. Será cobrado 0,10/dia"));
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

        c4 = new PdfPCell(new Phrase("Av. Brasil, 366 - Jardim Amanda - Hortolândia/SP - Locacões de Veiculos A&Ms - (19) 3897-3105 - Todos direitos reservados 2019"));
        c4.setHorizontalAlignment(Element.ALIGN_LEFT);
        c4.setPadding(50);
        c4.setColspan(3);
        c4.setRowspan(3);
        table.addCell(c4);

        table.setSpacingBefore(10);
        PdfPCell c5 = new PdfPCell();

        c5 = new PdfPCell(new Phrase("CODIGO DE BARRA"));
        c5.setHorizontalAlignment(Element.ALIGN_LEFT);
        c5.setPadding(10);
        c5.setColspan(3);
        c5.setRowspan(3);

        table.addCell(c5);

        return table;
    }


    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
            document.open();
            document.add(tableteste());
        } catch (DocumentException ex) {
            System.out.println("Error:" + ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex);
        } finally {
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File("documento.pdf"));
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        }


    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblTexto;
    // End of variables declaration//GEN-END:variables
}
