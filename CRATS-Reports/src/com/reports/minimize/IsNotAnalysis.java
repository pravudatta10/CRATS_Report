package com.reports.minimize;

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

public class IsNotAnalysis {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static void isNotAnalysisReport(Document document) throws DocumentException {
		table = new PdfPTable(2);
		table.setWidthPercentage(100);

		// table1
		cell = new PdfPCell(new Phrase("IS NOT Analysis", boldFontHeading));
		cell.setColspan(2);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		String TopTableheading[] = { "PROBLEM SOLVING WORKSHEET ", "Form: D2/3" };
		for (int i = 0; i < TopTableheading.length; i++) {
			cell = new PdfPCell(new Phrase(TopTableheading[i], normalBold));
			cell.setMinimumHeight(25);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		cell = new PdfPCell(new Phrase("Problem Description :", normalBold));
		cell.setColspan(2);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Problem Statement :", normalBold));
		cell.setColspan(2);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		document.add(table);

		// Added 2nd Table
		table = new PdfPTable(5);
		table.setWidthPercentage(100);

		String headers[] = { "Problem Description", "IS", "IS NOT ", "Get Information" };
		for (int i = 0; i < headers.length; i++) {
			cell = new PdfPCell(new Phrase(headers[i], normalBold));
			if (headers[i].equals("Problem Description")) {
				cell.setColspan(2);
			}
			cell.setMinimumHeight(20);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		// RealData
		cell = new PdfPCell(new Phrase("WHAT", normalFont));
		cell.setRowspan(2);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Object", normalFont));
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Object Text", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("WHAT", normalFont));
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("WHAT", normalFont));
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Defect", normalFont));
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("WHAT", normalFont));
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("WHAT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("WHAT", normalFont));
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		document.add(table);
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Is Not Analysis Report.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		document.open();
		isNotAnalysisReport(document);
		document.close();
		System.out.println("PDF created successfully");
	}

}
