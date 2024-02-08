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

public class Cause_Verification { 
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);//
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD); 
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static String CauseVerification(Document document, PdfWriter writer) throws DocumentException {
		table = new PdfPTable(7);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 2f, 3.5f, 3f, 2f, 2f, 2f, 2f });

		// here counting row from 1 not 0 .
		// row1
		cell = new PdfPCell(new Phrase("Cause Verification", boldFontHeading));
		cell.setColspan(7);
		cell.setMinimumHeight(25);
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		// row2 blank row
		cell = new PdfPCell(new Phrase(" "));
		cell.setColspan(7);
		cell.setBorder(0);
		table.addCell(cell);

		String[] topHeadings = { "Verification of the Probable Causes", "Concerns :- ", "Use Data Here ",
				"Refer to the Cause and Effect Diagram " };
		int headIndex = 0;
		for (String heading : topHeadings) {
			if (headIndex == 0) {
				cell = new PdfPCell(new Phrase(heading, normalBold));
				cell.setColspan(2);
				cell.setMinimumHeight(25);
			} else if (headIndex == 2) {
				cell = new PdfPCell(new Phrase(heading, normalBold));
				cell.setColspan(4);
				cell.setMinimumHeight(25);
			} else if (headIndex == 3) {
				cell = new PdfPCell(new Phrase(heading, normalBold));
				cell.setColspan(7);
				cell.setMinimumHeight(35);
			} else {
				cell = new PdfPCell(new Phrase(heading, normalBold));
			}
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			headIndex++;
		}

		// row5AllCell
		String[] headings = { "Sr.No", "Problem Cause", "Verification of Most Likely Causes", "Testing Method",
				"Observation", "Remarks", "Valid / Not Valid" };
		for (String heading : headings) {
			cell = new PdfPCell(new Phrase(heading, normalBold));
			cell.setMinimumHeight(35);
			cell.setUseAscender(true);
			cell.setPadding(2);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		// row6 Onwards

		String[] dataArrays = { "Data 1", "Data 2", "Data 3", "Data 4", "Data 5", "Data 6", "Data 7", "Data 8",
				"Data 9", "Data 10", "Data 11", "Data 12", "Data 13", "Data 14", "Data 15", "Data 16", "Data 17",
				"Data 18", "Data 19", "Data 20", "Data 21" };

		for (String dataArray : dataArrays) {
			cell = new PdfPCell(new Phrase(dataArray, normalFont));
			cell.setMinimumHeight(25);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
		document.add(table);
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Cause Verfication.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		document.open();
		CauseVerification(document, writer);
		document.close();
		System.out.println("PDF created successfully");
	}

}
