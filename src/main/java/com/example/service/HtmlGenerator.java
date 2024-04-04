package com.example.service;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
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
            Document doc = new Document(inputStream);
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
    public static byte[] generatePdfFromHtml(String htmlContent) {
        try {
            Document doc = new Document();
            doc.removeAllChildren();
            doc.appendDocument(new Document(new ByteArrayInputStream(htmlContent.getBytes())), 0);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            doc.save(outputStream, com.aspose.words.SaveFormat.PDF);
            doc.save("C:\\Users\\User\\Desktop\\output.pdf");
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
}}
