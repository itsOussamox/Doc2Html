package com.example.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.service.HtmlRemoveAds;
import com.example.service.HtmlGenerator;
import org.springframework.http.MediaType;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
@RestController
public class ConvertIt {
    @PostMapping("/hello")
    public static String helloIt() {
        return "Hello World";
    }

    @PostMapping("/convert-pdf")
    public ResponseEntity<String> convertToHtml(@RequestParam MultipartFile file) throws IOException {
        String html = HtmlGenerator.generateHtmlFromPdf(file.getInputStream());
        return ResponseEntity.ok(html);
    }

    @PostMapping("/convert-doc")
    public ResponseEntity<String> convertToHtmlFromWord() throws IOException {//@RequestParam String form
        // System.err.println("form :>>>>>>>>>>>>>>>>>>>> " + form);
        // if (form == null || form != "cnss") {
        //     throw new IllegalArgumentException("form error");
        // }
        FileInputStream inputStream = new FileInputStream("src/main/resources/cnss.doc");
        String html = HtmlGenerator.generateHtmlFromDoc(inputStream);
        html = HtmlRemoveAds.getCleanHtml(html);
        return ResponseEntity.ok(html);
    }

    // @PostMapping("/convert-html")
    // public ResponseEntity<byte[]> convertToHtmlFromHtml(@RequestParam String
    // html) throws IOException {
    // byte[] bytes = PdfGenerator.getPdfFromHtml(html);
    // return
    // ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(bytes);
    // }
    @PostMapping("/convert-html")
    public ResponseEntity<byte[]> convertToHtmlFromHtml(@RequestParam String html) throws IOException {
        try {
            ITextRenderer renderer = new ITextRenderer();
            if (html == null) {
                throw new IllegalArgumentException("html is null");
            }
            renderer.setDocumentFromString(html);
            renderer.layout();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            renderer.createPDF(baos);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header("Expires", "0")
                    .header("Cache-Control", "must-revalidate, post-check=0, pre-check=0")
                    .header("Pragma", "public")
                    .contentLength(baos.size())
                    .body(baos.toByteArray());
        } catch (Exception e) {
        }
        System.err.println("error while converting html to pdf error: ");
        System.err.println("html sent : " + html);
        return ResponseEntity.badRequest().body(null);
    }
}

/*
 * $file = $request->files->get('file');
 * $Dossier = $request->request->get('Dossier');
 * $fullname = $request->request->get('fullname');
 * $cin = $request->request->get('cin');
 * $Immatriculation = $request->request->get('Immatriculation');
 * $Adresse = $request->request->get('Adresse');
 * $Montant = $request->request->get('Montant');
 * $NombreDePiecesJointes = $request->request->get('NombreDePiecesJointes');
 * $birthdate = $request->request->get('birthdate');
 * $Medecin = $request->request->get('Medecin');
 * $Etablissement = $request->request->get('Etablissement');
 * $Enfant = $request->request->get('Enfant');
 * $Conjoint = $request->request->get('Conjoint');
 * 
 * 
 */
