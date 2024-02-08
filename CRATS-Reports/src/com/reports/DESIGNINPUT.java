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

public class DESIGNINPUT {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static String DesignInput(Document document) throws DocumentException {

		table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 5f, 5f, 5f, 5f });

		// here counting row from 1 not 0 .
		// row1
		cell = new PdfPCell(new Phrase("DESIGN INPUT REQUIRMENTS", boldFontHeading));
		cell.setColspan(4);
		cell.setMinimumHeight(25);
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		// row2
		cell = new PdfPCell(new Phrase("Design Input", normalBold));
		cell.setColspan(4);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// row3 Onwards
		String[] datas = { "Customer Complaint Received From", "Data Here", "Date", "Data Here", "Concern Name",
				"Data here", "On Date", "Data here", "Revision No", "Data here", "Product Name", "Data here",
				"Sample / Prototype / Mock up Provided", "Data here", "If Yes Details", "Data here",
				"Design Input Requirments", "Data here", "Discussed With", "Data here",
				"Estimated Cost Impact / Vehicle", "Data here", "Expected EN Date", "Data here",
				"Expected Implementation Date", "Data here", "Prepared By ", "Data here", "Approved By", "Data here" };
		int index = 0;
		for (String data : datas) {
			if (index == 0 || index % 2 == 0) {
				cell = new PdfPCell(new Phrase(data, normalBold));
			} else if (index % 2 != 0 && index == 17) {
				cell = new PdfPCell(new Phrase(data, normalFont));
				cell.setColspan(3);
			} else {
				cell = new PdfPCell(new Phrase(data, normalFont));
			}
			cell.setMinimumHeight(25);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			index++;
		}

		document.add(table);
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Design Input.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
		DesignInput(document);
		document.close();
		System.out.println("PDF created successfully");
	}

}
