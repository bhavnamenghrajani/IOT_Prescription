/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Drug.DrugItem;
import Business.Patient.Patient;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bhavna Menghrajani
 */
public class CreatePDF {

    public void createPDFfromInvoice(ArrayList<DrugItem> drugItemList, Patient patient, double totalAmount) {
        ArrayList<DrugItem> drugList = drugItemList;

        Document document = new com.lowagie.text.Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Invoice.pdf"));
            document.open();
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            Chunk chunk = new Chunk("Invoice has been generated");
            Font font = new Font(Font.COURIER);
            font.setStyle(Font.UNDERLINE);
            font.setStyle(Font.ITALIC);
            chunk.setFont(font);
            chunk.setBackground(Color.CYAN);

            Paragraph invoice = new Paragraph(chunk);
            invoice.setAlignment(Element.ALIGN_CENTER);

            document.add(invoice);

            Paragraph p = new Paragraph();
            // add 3 empty line
            addEmptyLine(p, 1);
            document.add(p);

            Chunk chunk2 = new Chunk("Patient name: " + patient.getFirstName() + " " + patient.getLastName());
            Font font2 = new Font(Font.COURIER);
            font2.setStyle(Font.HELVETICA);
            font.setStyle(Font.BOLD);
            chunk2.setFont(font2);
            // chunk2.setBackground(Color.CYAN);

            Paragraph name = new Paragraph(chunk2);
            name.setAlignment(Element.ALIGN_LEFT);

            document.add(name);

            // add 3 empty line
            addEmptyLine(p, 1);
            document.add(p);

            Chunk chunk3 = new Chunk("Bill generation date:  " + new Date());
            chunk3.setFont(font2);
            // chunk2.setBackground(Color.CYAN);

            Paragraph datePara = new Paragraph(chunk3);
            datePara.setAlignment(Element.ALIGN_LEFT);
            document.add(datePara);
            addEmptyLine(p, 2);
            document.add(p);

            PdfPTable table = new PdfPTable(5); // 3 columns.

            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Drug Id"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Drug Name"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Single Unit price"));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Quantity"));
            PdfPCell cell5 = new PdfPCell(new Paragraph("Total Price"));

            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);

            for (DrugItem di : drugList) {
                double total = di.getDrug().getPrice() * di.getQuantity();

                PdfPCell row1 = new PdfPCell(new Paragraph(String.valueOf(di.getDrug().getDrugId())));
                PdfPCell row2 = new PdfPCell(new Paragraph(di.getDrug().getDrugName()));
                PdfPCell row3 = new PdfPCell(new Paragraph(String.valueOf(di.getDrug().getPrice())));
                PdfPCell row4 = new PdfPCell(new Paragraph(String.valueOf(di.getQuantity())));
                PdfPCell row5 = new PdfPCell(new Paragraph(String.valueOf(total)));

                row1.setHorizontalAlignment(Element.ALIGN_CENTER);
                row2.setHorizontalAlignment(Element.ALIGN_CENTER);
                row3.setHorizontalAlignment(Element.ALIGN_CENTER);
                row4.setHorizontalAlignment(Element.ALIGN_CENTER);
                row5.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(row1);
                table.addCell(row2);
                table.addCell(row3);
                table.addCell(row4);
                table.addCell(row5);
            }

            document.add(table);
            Chunk chunk4 = new Chunk("Total amount: $ " + totalAmount);
            chunk4.setFont(font2);
            Paragraph billPara = new Paragraph(chunk4);
            billPara.setAlignment(Element.ALIGN_CENTER);

            document.add(billPara);

            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "File is in use");
        }

    }

    public void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
