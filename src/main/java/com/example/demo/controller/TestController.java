package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Demo;
import com.example.demo.repository.DemoRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@RestController
@RequestMapping("/api")
public class TestController {

	private final DemoRepository demoRepository;

	public TestController(DemoRepository demoRepository) {
		super();
		this.demoRepository = demoRepository;
	}

	@GetMapping("/demo")
	public String demo() {
		List<Demo> data = demoRepository.findAll();
		if (data.isEmpty())
			return "Data not found.";
		else
			return "Hello Demo";
	}

	@GetMapping("/demo/generate-pdf")
	public String generatePdf() {
		String directoryPath = "/common-doc/";
		String filePath = directoryPath + "sample.pdf";

		try {
			// Create the directory if it doesn't exist
			Files.createDirectories(Paths.get(directoryPath));

			// Create PDF writer
			PdfWriter writer = new PdfWriter(filePath);

			// Create PDF document
			PdfDocument pdf = new PdfDocument(writer);

			// Create document
			Document document = new Document(pdf);

			// Add content to PDF
			document.add(new Paragraph("Hello, this is a demo PDF document."));

			// Close the document
			document.close();

			return "PDF generated successfully at: " + filePath;
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed to generate PDF: " + e.getMessage();
		}
	}
}
