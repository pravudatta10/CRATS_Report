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

public class RootCauseAnalysis {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD); 
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static String rootCause(Document document, PdfWriter writer) throws DocumentException {
		Font whiteFontForColour = new Font(Font.FontFamily.HELVETICA, 9);
		whiteFontForColour.setColor(BaseColor.WHITE);
		Font boldFont7 = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD);
		table = new PdfPTable(12);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 2f, 3.5f, 3.5f, 2f, 2f, 2f, 2f, 2f, 2f, 3.5f, 2f, 2f });

		// row1
		cell = new PdfPCell(new Phrase("Root Cause Analysis", boldFontHeading));
		cell.setColspan(12);
		cell.setMinimumHeight(25);
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		// row2
		cell = new PdfPCell(new Phrase(" "));
		cell.setColspan(12);
		cell.setBorder(0);
		table.addCell(cell);

		// row3

		String[] headings = { "FAILURE MODE", "% CONTRIBUTION",
				"ROOT CAUSE (data to be fetched from why why any report)", "ICA", "ICA DATE", "PCA", "PCA DATE", "ROYG",
				"TARGET DATE", "RESPONSIBILITY", "BATCH FROM", "BATCH TO" };
		for (String heading : headings) {
			cell = new PdfPCell(new Phrase(heading, boldFont7));
			cell.setMinimumHeight(35);
			cell.setUseAscender(true);
			cell.setPadding(2);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		// row4 Onwards
		String[] dataArrays = { "Data 1", "Data 2", "Data 3", "Data 4", "Data 5", "Data 6", "Data 7", "Red", "Data 9",
				"Data 10", "Data 11", "Data 12", "Data 13", "Data 14", "Data 15", "Green", "Data 17", "Data 18",
				"Data 19", "Park", "Data 21", "Data 22", "Data 23 ", "Data 24" };

		for (String dataArray : dataArrays) {
			if (dataArray.equals("Red")) {
				cell = new PdfPCell(new Phrase("Red", whiteFontForColour));
				cell.setBackgroundColor(BaseColor.RED);
			} else if (dataArray.equals("Orange")) {
				cell = new PdfPCell(new Phrase("Orange", normalFont));
				cell.setBackgroundColor(BaseColor.ORANGE);
			} else if (dataArray.equals("Yellow")) {
				cell = new PdfPCell(new Phrase("Yellow", normalFont));
				cell.setBackgroundColor(BaseColor.YELLOW);
			} else if (dataArray.equals("Green")) {
				cell = new PdfPCell(new Phrase("Green", normalFont));
				cell.setBackgroundColor(BaseColor.GREEN);
			} else if (dataArray.equals("Park")) {
				cell = new PdfPCell(new Phrase("Park", whiteFontForColour));
				cell.setBackgroundColor(BaseColor.BLUE);
			} else {
				cell = new PdfPCell(new Phrase(dataArray, normalFont));
				cell.setMinimumHeight(25);
				cell.setUseAscender(true);
			}
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
		document.add(table);
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Root Cause Analysis.pdf";
		Document document = new Document();
		document.setMargins(20, 20, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		rootCause(document, writer);
		document.close();
		System.out.println("PDF created successfully");
	}

}
