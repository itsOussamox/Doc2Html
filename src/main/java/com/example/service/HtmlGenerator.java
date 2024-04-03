package com.example.service;
//cc
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import com.aspose.words.Document;
import com.aspose.words.HtmlSaveOptions;

public class HtmlGenerator {
    public static String generateHtmlFromPdf(InputStream inputStream) throws IOException {
        PDDocument pdf = PDDocument.load(inputStream);
        PDFDomTree parser = new PDFDomTree();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer output = new PrintWriter(baos, true, StandardCharsets.UTF_8);
        parser.writeText(pdf, output);
        output.close();
        pdf.close();
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
       }
    
  public static String generateHtmlFromDoc(InputStream inputStream) throws IOException {
        try {
            // Load the DOC file from InputStream
            Document doc = new Document(inputStream);

            // Create a ByteArrayOutputStream to store the HTML content
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             HtmlSaveOptions options = new HtmlSaveOptions();
            options.setExportImagesAsBase64(true);
            doc.save(outputStream, options);
            String htmlContent = outputStream.toString("UTF-8");
            System.err.println(htmlContent);
            outputStream.close();
            inputStream.close();
            return (htmlContent);
        } catch (Exception e) {
            return ("Error: " + e.getMessage());
        }
    }
}


