package com.reports.minimize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class LessonLearnt {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static String lessonLearnt(Document document, PdfWriter writer) throws DocumentException {
		table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 5f, 5f, 5f, 5f });

		String headingDatas[] = { "Lesson Learnt", "Model", "Data here", "Author", "Data here" };
		int headingIndex = 0;
		for (String headingData : headingDatas) {
			if (headingIndex == 0) {
				cell = new PdfPCell(new Phrase(headingData, boldFontHeading));
				cell.setRowspan(2);
				cell.setColspan(2);
				cell.setMinimumHeight(50);
				// cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			} else if (headingIndex % 2 != 0) {
				cell = new PdfPCell(new Phrase(headingData, normalBold));
			} else {
				cell = new PdfPCell(new Phrase(headingData, normalFont));
			}
			cell.setUseAscender(true);
			cell.setMinimumHeight(25);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			headingIndex++;
		}

		String[] dataArrays = { "Lesson No", "Data here", "Project Reference", "Data here", "Team", "Data here",
				"Title", "Data here", "Description", "Data here", "What Went Right ?", "Data here", "What Went Wrong ?",
				"Data here", "Recommendation", "Data here", "Category", "Data here", "Core Process Affected",
				"Data here", "Experience At", "Data here", "Department Name", "Data here", "Department No.",
				"Data here", "Revision No", "Data here" };

		int dataIndex = 0;
		Set<Integer> specialIndices = new HashSet<>(Arrays.asList(5, 7, 9, 11, 13, 15, 21, 27));
		for (String dataArray : dataArrays) {
			if (dataIndex == 0 || dataIndex % 2 == 0) {
				cell = new PdfPCell(new Phrase(dataArray, normalBold));
			} else if (specialIndices.contains(dataIndex)) {
				cell = new PdfPCell(new Phrase(dataArray, normalFont));
				cell.setColspan(3);
			} else {
				cell = new PdfPCell(new Phrase(dataArray, normalFont));
			}
			cell.setMinimumHeight(25);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			dataIndex++;
		}
		document.add(table);
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Lesson Learnt.pdf";
		Document document = new Document();
		document.setMargins(30, 30, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		document.open();
		lessonLearnt(document, writer);
		document.close();
		System.out.println("PDF created successfully");
	}

}
