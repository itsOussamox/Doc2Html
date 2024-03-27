package com.example.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.service.HtmlRemoveAds;
import com.example.service.HtmlGenerator;



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
    public ResponseEntity<String> convertToHtmlFromWord(@RequestParam MultipartFile file) throws IOException {
        String html = HtmlGenerator.generateHtmlFromDoc(file.getInputStream());
        html = HtmlRemoveAds.getCleanHtml(html);
        return ResponseEntity.ok(html);
    }
}
