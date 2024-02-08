package com.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class WhyAnalysis {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static void whyAnalysisReport(Document document) throws DocumentException {
		table = new PdfPTable(8);
		table.setWidths(new float[] { 1.5f, 1f, 1f, 1f, 1f, 1f, 1f, 1f });
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("Why Analysis", boldFontHeading));
		cell.setColspan(8);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		// row2
		cell = new PdfPCell(new Phrase(" "));
		cell.setColspan(8);
		cell.setMinimumHeight(15);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		// row3
		String headers[] = { "PROBABLE CAUSE (TO BE FETCH FROM CAUSE VERIFICATION FORM)", "WHY1", "WHY2", "WHY3",
				"WHY4", "WHY5", "ROOT CAUSE", "VALID" };
		for (int i = 0; i < headers.length; i++) {
			cell = new PdfPCell(new Phrase(headers[i], normalBold));
			cell.setPadding(4);
			cell.setMinimumHeight(20);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		// row4 Onwards DynamicData
		String[] dataArrays = { "Data 1", "Data 2", "Data 3", "Data 4", "Data 5", "Data 6", "Data 7", "Data 8",
				"Data 9", "Data 10", "Data 11", "Data 12", "Data 13", "Data 14", "Data 15", "Data 16", "Data 17",
				"Data 18", "Data 19", "Data 20", "Data 21" };

		for (String dataArray : dataArrays) {
			cell = new PdfPCell(new Phrase(dataArray, normalFont));
			cell.setMinimumHeight(20);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
		document.add(table);
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Why Analysis.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		document.open();
		whyAnalysisReport(document);
		document.close();
		System.out.println("PDF created successfully");
	}

}
