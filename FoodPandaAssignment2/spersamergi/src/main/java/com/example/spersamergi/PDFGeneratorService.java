package com.example.spersamergi;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.util.Random;

public class PDFGeneratorService {
    Random rd = new Random();


    public void export(String client) throws FileNotFoundException {
        String path = "D:\\Facultate\\Anul3\\SD\\SecondAssignment\\thing"+rd.nextInt()+".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        Document document = new Document(pdfDocument);
        document.add(new Paragraph(client));
        document.close();
    }
}
