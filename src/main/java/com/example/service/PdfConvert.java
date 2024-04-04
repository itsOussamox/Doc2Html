package com.example.service;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PdfConvert {
    public static byte[] iTextConvert(String htmlContent) {
            try {
            // Create PDF document
            Document document = new Document(PageSize.A4);
            FileOutputStream fos = new FileOutputStream("output.pdf");
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fos);
            document.open();

            // Render HTML to PDF
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fos);

            // Close document
            document.close();
            fos.close();

            // Read PDF content and return as byte array (you may want to return it in a different way)
            return Files.readAllBytes(Paths.get("output.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}