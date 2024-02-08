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

public class PartAndVendorDetail {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static void PartVendorDetailsReport(Document document) throws DocumentException {

		table = new PdfPTable(3);
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("PART AND VENDOR DETAILS", boldFontHeading));
		cell.setColspan(8);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(new BaseColor(192, 192, 192));
		table.addCell(cell);

		// row2
		cell = new PdfPCell(new Phrase(" "));
		cell.setColspan(3);
		cell.setMinimumHeight(15);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		// row3 Onwards

		String headings[] = { "PART NUMBER", "PART DESCRIPTION", "VENDOR NAME" };
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
		String[] datas = { "Data 1", "Data 2", "Data 3", "Data 4", "Data 5", "Data 6", "Data 7", "Data 8", "Data 9",
				"Data 10", "Data 11", "Data 12", "Data 13", "Data 14", "Data 15", "Data 16", "Data 17", "Data 18",
				"Data 19", "Data 20", "Data 21" };
		for (int i = 0; i < datas.length; i++) {
			cell = new PdfPCell(new Phrase(datas[i], normalFont));
			cell.setPadding(3);
			cell.setMinimumHeight(15);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);
		}
		document.add(table);
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Part And Vendor Detail.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		document.open();
		PartVendorDetailsReport(document);
		document.close();
		System.out.println("PDF created successfully");
	}

}
