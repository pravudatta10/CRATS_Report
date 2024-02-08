package com.reports.minimize;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class FooterDateTime extends PdfPageEventHelper {
	Font boldFont = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");

	public void onEndPage(PdfWriter writer, Document document) {
		PdfPTable table = new PdfPTable(1);
		table.setTotalWidth(100);
		PdfPCell cell = new PdfPCell();
		cell.addElement(new Phrase(dateFormat.format(new Date()), boldFont));
		cell.setBorder(0);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		table.writeSelectedRows(0, -1, 30, table.getTotalHeight() + 10, writer.getDirectContent());
	}
}
