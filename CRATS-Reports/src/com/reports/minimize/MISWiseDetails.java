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

public class MISWiseDetails {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static void MISWiseDetailsReports(Document document) throws DocumentException {
		table = new PdfPTable(4);
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("MIS Wise Details", boldFontHeading));
		cell.setColspan(4);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" "));
		cell.setColspan(4);
		cell.setMinimumHeight(10);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		// row2
		String headings[] = { "MIS", "INCIDENTS", "RPT", "CPU" };
		for (int i = 0; i < headings.length; i++) {
			cell = new PdfPCell(new Phrase(headings[i], normalBold));
			cell.setPadding(3);
			cell.setMinimumHeight(20);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		// DynamicData

		String datas[] = { "WHY1 PROBABLON FOR", "WHY2", "WHY3", "WHY4", "WHY5", "ROOT CAUSE", "ABC", "VALID" };
		for (int i = 0; i < datas.length; i++) {
			cell = new PdfPCell(new Phrase(datas[i], normalFont));
			cell.setPadding(3);
			cell.setMinimumHeight(20);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);
		}
		document.add(table);
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Mis Wise Details.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		document.open();
		MISWiseDetailsReports(document);
		document.close();
		System.out.println("PDF created successfully");
	}
}
