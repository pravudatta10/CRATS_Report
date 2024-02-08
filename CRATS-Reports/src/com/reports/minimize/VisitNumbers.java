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

public class VisitNumbers {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static void setStyleToReport(PdfPCell cell, String text, boolean isHeading, boolean isBold, boolean isNormal,
			int setRowHeight, int setColSpan, int setRowSpan, String border, int padding, boolean isVertical,
			boolean isHorizontal, BaseColor baseColor) {

		Font font = isHeading ? boldFontHeading : (isBold ? normalBold : normalFont);
		cell.setPhrase(new Phrase(text, font));
		cell.setUseAscender(true);
		cell.setMinimumHeight(setRowHeight);
		cell.setBackgroundColor(baseColor);
		cell.setPadding(padding);
		cell.setColspan(setColSpan > 0 ? setColSpan : 1);
		cell.setRowspan(setRowSpan > 0 ? setRowSpan : 1);
		cell.setVerticalAlignment(isVertical ? Element.ALIGN_MIDDLE : Element.ALIGN_UNDEFINED);
		cell.setHorizontalAlignment(isHorizontal ? Element.ALIGN_CENTER : Element.ALIGN_UNDEFINED);
		
		if (border.contains("l")) {
			cell.setBorderWidthLeft(0);
		}
		if (border.contains("r")) {
			cell.setBorderWidthRight(0);
		}

		if (border.contains("t")) {
			cell.setBorderWidthTop(0);
		}
		if (border.contains("r")) {
			cell.setBorderWidthBottom(0);
		} 		
	}

	public static void VisitNumbersReport(Document document) throws DocumentException {
		table = new PdfPTable(2);
		table.setWidthPercentage(100);

		// row1 
		cell = new PdfPCell();
		setStyleToReport(cell, "Visit Numbers", true, false, false, 20, 2, 1, "", 2, true, true, BaseColor.LIGHT_GRAY); 
		table.addCell(cell);
		// row2
		cell = new PdfPCell();
		setStyleToReport(cell, "", false, false, false, 15, 2, 0, "ltrb", 2, false, false, null); 
		table.addCell(cell);
		// row3
		String headers[] = { "SCHEDULE", "UNSCHEDULE" };
		for (String header : headers) {
			cell = new PdfPCell();
			setStyleToReport(cell, header, false, true, false, 20, 0, 1, "", 3, true, true, null);
			table.addCell(cell);
		}

		// DynamicData
		// cell, text, isHeading, isBold, isNormal,setRowHeight,setColSpan,setRowSpan,border, padding, isVertical,isHorizontal, baseColor

		String[] dataArrays = { "Data 1", "Data 2", "Data 3", "Data 4", "Data 5", "Data 6", "Data 7", "Data 8",
				"Data 9", "Data 10", "Data 11", "Data 12", "Data 13", "Data 14", "Data 15", "Data 16", "Data 17",
				"Data 18", "Data 19", "Data 20", "Data 21" };

		for (String dataArray : dataArrays) {
			cell = new PdfPCell();
			setStyleToReport(cell, dataArray, false, false, true, 20, 0, 0, "", 3, true, true, null);
			table.addCell(cell);
		}
		document.add(table);
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Visit Numbers.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		document.open();
		VisitNumbersReport(document);
		document.close();
		System.out.println("PDF created successfully");
	}

}
