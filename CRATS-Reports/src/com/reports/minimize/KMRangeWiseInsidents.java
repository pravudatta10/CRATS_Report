package com.reports.minimize;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class KMRangeWiseInsidents {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static void generateKMRangeWiseInsident(Document document) throws Exception {
		table = new PdfPTable(2);
		table.setWidthPercentage(100);

		// row1 of 1st Table
		cell = new PdfPCell(new Phrase(" KM RANGE WISE INCIDENTS ", boldFontHeading));
		cell.setColspan(2);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" "));
		cell.setColspan(2);
		cell.setMinimumHeight(10);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		// row2

		String headers[] = { "KMS RANGE (In Thousand)", "INCIDENTS" };
		for (int i = 0; i < headers.length; i++) {
			cell = new PdfPCell(new Phrase(headers[i], normalBold));
			cell.setPadding(3);
			cell.setMinimumHeight(20);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		// DynamicData
		String datas[] = { "Data 1", "Data 2", "Data 3", "Data 4", "Data 5", "Data 6", "Data 7", "Data 8" };
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

	public static void main(String[] args) throws Exception {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\KM Range Wise Insident.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		document.open();
		generateKMRangeWiseInsident(document);
		document.close();
		System.out.println("PDF created successfully");
	}
}
