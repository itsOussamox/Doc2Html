package com.example.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern; 
public class HtmlRemoveAds {
    private static String getBodyDiv(String newContext)
    {
        String stringToInsert = "<div style=\"position:absolute;width:100vw;height:100vh;background-color:white;z-index:-65536\"></div>";
        String bodyPattern = "<body[^>]*>";
        Pattern pattern = Pattern.compile(bodyPattern);
        Matcher matcher = pattern.matcher(newContext);
        if (!matcher.find())
            return newContext;
        String output = newContext.substring(0, matcher.end()) + stringToInsert + newContext.substring(matcher.end());
        return output;
    }
    public static String getCleanHtml(String htmlContext)
    {
        String topLicense = "Evaluation Only. Created with Aspose.Words. Copyright 2003-2022 Aspose Pty Ltd.";
        String bottomLicense = "Created with an evaluation copy of Aspose.Words. To discover the full versions of our APIs please visit: https://products.aspose.com/words/";
        String anotherLicense = "This document was truncated here because it was created in the Evaluation Mode.";
        String newContext = htmlContext.replace(topLicense, "");
        newContext = newContext.replace(bottomLicense, "");
        newContext = newContext.replace(anotherLicense, "");
        newContext = getBodyDiv(newContext);
        return (newContext);
    }
}