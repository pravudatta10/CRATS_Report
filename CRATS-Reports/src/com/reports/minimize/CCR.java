package com.reports.minimize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CCR {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 8);
	static PdfPCell cell;
	static PdfPTable table;
	static Image image;

//*********************************Concern Closure Report***************************************
	public static void ConcernClosureReport(Document document) throws DocumentException {
		Font redFontForColour = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
		redFontForColour.setColor(BaseColor.RED);
		table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 5f, 5f, 5f, 5f });

		// row1
		cell = new PdfPCell(new Phrase("CONCERN CLOSURE REPORT", redFontForColour));
		cell.setColspan(4);
		cell.setMinimumHeight(35);
		cell.setUseAscender(true);
		cell.setBorder(0);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// row2
		cell = new PdfPCell(new Phrase("CCR CheckList", boldFontHeading));
		cell.setColspan(4);
		cell.setMinimumHeight(25);
		cell.setUseAscender(true);
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// row3 add "Required Data","Released Data","Justification Data"

		String datas[] = { "Item", "Required", " Released", "Justification If Not Applicable",
				"Field SOP / Field Kit / Quick Fix Solution for Field", "Required Data", "Released Data",
				"Justification Data", "DFMEA Updation", "Required Data", "Released Data", "Justification Data",
				"PFMEA Updation", "Required Data", "Released Data", "Justification Data", "DVP Updation",
				"Required Data", "Released Data", "Justification Data", "Recall /Retrofitment", "Required Data",
				"Released Data", "Justification Data", "Lesson Learnt / FFD updated ? ", "Required Data",
				"Released Data", "Justification Data", "Case file Prepared", "Required Data", "Released Data",
				"Justification Data", "Trishul Cutoff updated?", "Required Data", "Released Data",
				"Justification Data" };
		Set<Integer> headingIndexes = new HashSet<>(Arrays.asList(0, 1, 2, 3));
		Set<Integer> bodyIndexes = new HashSet<>(Arrays.asList(4, 8, 12, 16, 20, 24, 28));
		int index = 0;
		for (String data : datas) {
			if (headingIndexes.contains(index)) {
				cell = new PdfPCell(new Phrase(data, normalBold));
			} else if (bodyIndexes.contains(index)) {
				cell = new PdfPCell(new Phrase(data, normalFont));
			} else {
				cell = new PdfPCell(new Phrase(data, normalFont));
			}
			cell.setMinimumHeight(25);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			index++;
		}

		PdfPTable lastTable = new PdfPTable(5);
		lastTable.setWidthPercentage(100);
		lastTable.setWidths(new float[] { 5f, 5f, 5f, 5f, 5f });
		// replace with MIS Data
		String lastTableDatas[] = { "RPT", "RPT Before : 3MIS", "RPT Outlook :3MIS", "RPT Before :12MIS",
				"RPT Outlook :12MIS", "Before:3MIS Data", "Outlook:3MIS Data", "Before:12MIS Data",
				"Outlook:12MIS Data" };
		int lastTableindex = 0;
		Set<Integer> lastIndexes = new HashSet<>(Arrays.asList(1, 2, 3, 4));
		for (String lastTableData : lastTableDatas) {
			if (lastTableindex == 0) {
				cell = new PdfPCell(new Phrase(lastTableData, normalFont));
				cell.setRowspan(2);
			} else if (lastIndexes.contains(lastTableindex)) {
				cell = new PdfPCell(new Phrase(lastTableData, normalFont));

			} else if (lastTableindex != 0 && !lastIndexes.contains(lastTableindex)) {
				cell = new PdfPCell(new Phrase(lastTableData, normalFont));

			}
			cell.setMinimumHeight(25);
			cell.setUseAscender(true);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			lastTable.addCell(cell);
			lastTableindex++;
		}

		cell = new PdfPCell();
		cell.setPadding(0);
		cell.setBorderWidthRight(0);
		cell.addElement(lastTable);
		cell.setColspan(5);
		table.addCell(cell);
		document.add(table);
	}

// *****************************Why - Why Analysis Details  ******************************

	public static void Why_Why_Analysis(Document document) throws DocumentException {
		table = new PdfPTable(8);
		float[] columnWidths = { 1.5f, 1f, 1f, 1f, 1f, 1f, 1f, 1f };
		table.setWidths(columnWidths);
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("Why - Why Analysis Details", boldFontHeading));
		cell.setColspan(8);
		cell.setMinimumHeight(30);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		// row2
		String row2Headers[] = { "Activity", "WHY1", "WHY2", "WHY3", "WHY4", "WHY5", "ROOT CAUSE", "VALID" };
		for (int i = 0; i < row2Headers.length; i++) {
			cell = new PdfPCell(new Phrase(row2Headers[i], normalBold));
			cell.setPadding(4);
			cell.setMinimumHeight(20);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		// DynamicData
		String row3Datas[] = { "Activity", "WHY1", "WHY2", "WHY3", "WHY4", "WHY5", "ROOT CAUSE", "VALID" };
		for (int i = 0; i < row3Datas.length; i++) {
			cell = new PdfPCell(new Phrase(row3Datas[i], normalFont));
			cell.setPadding(3);
			cell.setMinimumHeight(10);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
		document.add(table);
	}

// ************* Cause & Effect ***************************
	public static void CauseAndEffect(Document document) throws DocumentException {
		table = new PdfPTable(6);
		float[] columnWidths = { 3f, 3f, 3f, 3f, 3f, 3f };
		table.setWidths(columnWidths);
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("Cause & Effect ", boldFontHeading));
		cell.setColspan(6);
		cell.setMinimumHeight(30);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

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
	}

// *********************** Cause Verification ********************
	public static void CauseVerification(Document document) throws DocumentException {
		table = new PdfPTable(6);
		float[] columnWidths = { 3f, 3f, 3f, 3f, 3f, 3f };
		table.setWidths(columnWidths);
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("Cause Verification", boldFontHeading));
		cell.setColspan(6);
		cell.setMinimumHeight(30);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		String[] headings = { "Problem Cause", "Verification of Most Likely Causes", "Testing Method", "Observation",
				"Remarks", "Valid / Not Valid" };
		for (String heading : headings) {
			cell = new PdfPCell(new Phrase(heading, normalBold));
			cell.setMinimumHeight(35);
			cell.setUseAscender(true);
			cell.setPadding(2);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

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
	}

//******************************G8D Report*********************************************
	public static void G8DReport(Document document) throws DocumentException {
		table = new PdfPTable(4);
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("G8D Report", boldFontHeading));
		cell.setColspan(6);
		cell.setMinimumHeight(30);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		// row1
		cell = new PdfPCell(new Phrase("Title", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Title TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Model", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Model TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row3
		cell = new PdfPCell(new Phrase("Date Opened", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Date Opened TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Last Updated", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Last Updated TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row 4
		cell = new PdfPCell(new Phrase("Oraganization / Location", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Oraganization / Location  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Product/Process Information", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Product/Process Information TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row 5
		cell = new PdfPCell(new Phrase("D0", normalBold));
		cell.setColspan(4);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row6
		cell = new PdfPCell(new Phrase("Symptom (s)", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Symptom (s) TEXT", normalFont));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row7
		cell = new PdfPCell(new Phrase("Emergency Responsive Action", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Emergency Responsive Action TEXT", normalFont));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row8
		cell = new PdfPCell(new Phrase("Customer Protection Action", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Customer Protection Action TEXT", normalFont));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row9
		cell = new PdfPCell(new Phrase("Verification & Validation ", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Verification & Validation  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("% Effectiveness", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("% Effectiveness TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		// row10
		cell = new PdfPCell(new Phrase("Date Implemented ", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Date Implemented  TEXT", normalFont));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row11
		cell = new PdfPCell(new Phrase("D1", normalBold));
		cell.setColspan(2);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("D2", normalBold));
		cell.setColspan(2);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		// row12
		cell = new PdfPCell(new Phrase("Champion", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Champion  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Problem Statement", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Problem Statement TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row13 &14
		cell = new PdfPCell(new Phrase("Leader", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Leader  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Problem Statement", normalBold));
		cell.setRowspan(2);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Problem Statemen", normalFont));
		cell.setRowspan(2);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Team", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row15

		cell = new PdfPCell(new Phrase("D3", normalBold));
		cell.setColspan(4);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row16

		cell = new PdfPCell(new Phrase("Root Cause (s)", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" Root Cause (s) TEXT", normalBold));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row17

		cell = new PdfPCell(new Phrase("Verification & Validation", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Verification & Validation  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("% Effectiveness", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("% Effectiveness  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row18

		cell = new PdfPCell(new Phrase("Date Implemented)", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Date Implemented TEXT", normalBold));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row19

		cell = new PdfPCell(new Phrase("D4", normalBold));
		cell.setColspan(4);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row20
		cell = new PdfPCell(new Phrase("Root Cause(s) Implemented)", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Root Cause(s) TEXT", normalBold));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row21

		cell = new PdfPCell(new Phrase("Verification & Validation", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Verification & Validation  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("% Contribution", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("% Contribution  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row22

		cell = new PdfPCell(new Phrase("D5", normalBold));
		cell.setColspan(4);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		// row23

		cell = new PdfPCell(new Phrase("Chosen Permanent Corrective Action(s))", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Chosen Permanent Corrective Action(s)TXT", normalBold));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row24

		cell = new PdfPCell(new Phrase("Verification & Validation", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Verification & Validation  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("% Effectiveness", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("% Effectiveness  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		// row25
		cell = new PdfPCell(new Phrase("D6", normalBold));
		cell.setColspan(4);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		// row26

		cell = new PdfPCell(new Phrase("Implemented Permanent  Corrective Action(s))", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Implemented Permanent Corrective Action(s)TXT", normalBold));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row27

		cell = new PdfPCell(new Phrase("Validation", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Validation  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Cut Off No ", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Cut Off No  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row28
		cell = new PdfPCell(new Phrase("D7", normalBold));
		cell.setColspan(4);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row29
		cell = new PdfPCell(new Phrase("Prevent Recurrence Action(s)", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("78945", normalBold));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row30

		cell = new PdfPCell(new Phrase("Verification & Validation", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Verification & Validation  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Date Implemented  ", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Date Implemented   TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row31
		cell = new PdfPCell(new Phrase("Prevent Recurrencet Recommendation(s) Systemic", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Prevent Recurrencet Recommendation(s) Systemi TEXT", normalBold));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		//// row32
		cell = new PdfPCell(new Phrase("Responsibility ", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" 7894", normalFont));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row33
		cell = new PdfPCell(new Phrase("D8", normalBold));
		cell.setColspan(4);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row34

		cell = new PdfPCell(new Phrase(" Team & Individual Recognition  ", normalBold));
		cell.setColspan(1);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" ", normalBold));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		// row35

		cell = new PdfPCell(new Phrase("Reported By", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Reported By  TEXT", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Date Closed ", normalBold));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("789456", normalFont));
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		document.add(table);
	}

//***********************Concern Closure Report****************************
	public static void ConcerClouserReport(Document document)
			throws DocumentException, MalformedURLException, IOException {
		normalBold = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD);
		normalFont = new Font(Font.FontFamily.HELVETICA, 6);
		table = new PdfPTable(10);
		table.setWidths(new float[] { 0.8f, 1.242f, 0.75f, 0.75f, 0.55f, 0.95f, 0.5f, 0.6f, 0.63f, 0.6f });
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("Concern Closure Report", boldFontHeading));
		cell.setColspan(10);
		cell.setMinimumHeight(30);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		// row1
		image = Image.getInstance("Assets//Logo.png");
		cell = new PdfPCell();
		cell.setRowspan(3);
		cell.setColspan(2);
		cell.addElement(image);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Concern Closure Report", boldFontHeading));
		cell.setRowspan(3);
		cell.setColspan(4);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Plant :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setColspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Plant Data", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setColspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		cell.setUseAscender(true);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Department :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setColspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Department Data", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setColspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		cell.setUseAscender(true);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Model :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		cell.setUseAscender(true);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Model Data", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setColspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		cell.setUseAscender(true);
		table.addCell(cell);

		// row2
		cell = new PdfPCell(new Phrase("Problem No :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("VERITO-BODY-05022024-2277", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Reported Date :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Reported Date", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Source :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Source Data", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Severity :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Severity Data", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Closure Date :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Closure Date", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		// row3
		cell = new PdfPCell(new Phrase("Concern Description :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Concern Description", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(4);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("CCR No :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Concern Data", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(3);
		table.addCell(cell);

		// row4
		cell = new PdfPCell(new Phrase("OBSERVATION & ANALYSIS :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setBorderWidthBottom(0);
		cell.setRowspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("OBSERVATION & ANALYSIS Data", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setBorderWidthBottom(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		cell.setRowspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("CORRECTIVE ACTIONS :", normalBold));
		cell.setColspan(6);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(10);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Customer Protect Action : ", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(30);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("CORRECTIVE ACTIONS ", normalFont));
		cell.setColspan(4);
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(30);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Root Cause :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setBorderWidthTop(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		cell.setRowspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Root Cause Data", normalFont));
		cell.setBorderWidthTop(0);
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		cell.setRowspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Containment Action : ", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Permemnent Containment Action", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(4);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Permemnent Action : ", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Permemnent Action Root", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(20);
		cell.setColspan(4);
		table.addCell(cell);

		// row5
		cell = new PdfPCell(new Phrase("Photograph/Nature Of Change", normalBold));
		cell.setColspan(10);
		cell.setMinimumHeight(15);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setUseAscender(true);
		table.addCell(cell);

		// row6
		cell = new PdfPCell(new Phrase("Before", normalBold));
		cell.setColspan(4);
		cell.setMinimumHeight(15);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("After", normalBold));
		cell.setColspan(6);
		cell.setMinimumHeight(15);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		// row7 images
		image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\Upload Things\\TestImage_2.jpeg");
		image.scaleToFit(250, 130);
		image.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell();
		cell.setPadding(5);
		cell.setFixedHeight(20);
		cell.setColspan(4);
		cell.setMinimumHeight(15);
		cell.addElement(image);
		table.addCell(cell);

		image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\Upload Things\\TestImage_2.jpeg");
		image.scaleToFit(250, 130);
		image.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setPadding(5);
		cell.setFixedHeight(20);
		cell.setMinimumHeight(15);
		cell.addElement(image);
		table.addCell(cell);

		// row8 images
		cell = new PdfPCell(new Phrase("DFMEA RPN : ", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidthRight(0);
		cell.setMinimumHeight(15);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Photograph/Nature Of Change", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		cell.setColspan(3);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("DFMEA RPN3 :", normalBold));
		cell.setBorderWidthRight(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setColspan(2);
		cell.setMinimumHeight(15);

		table.addCell(cell);
		cell = new PdfPCell(new Phrase("DFMEA Photograph RPN3 Photograph", normalFont));
		cell.setBorderWidthLeft(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		cell.setColspan(4);
		table.addCell(cell);

		// row9 images
		cell = new PdfPCell(new Phrase("Cut Off No.s :", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setColspan(4);
		cell.setMinimumHeight(15);
		table.addCell(cell);

		// Image at Merged Cells
		image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\Upload Things\\TestImage_2.jpeg");
		image.scaleToFit(250, 130);
		image.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell();
		cell.addElement(image);
		cell.setColspan(6);
		cell.setRowspan(5);
		cell.setMinimumHeight(20);
		cell.setPadding(5);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Containment Action : ", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidthRight(0);
		cell.setColspan(2);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Containment Action Text", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidthLeft(0);
		cell.setColspan(2);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		// t1 Here 2ndTable added to Cell

		PdfPTable table2 = new PdfPTable(3);
		table2.setWidthPercentage(100);

		cell = new PdfPCell(new Phrase("Sr.No ", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Cut Off No ", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Date", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Sr.No TEXT ", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Cut Off No TEXT ", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Date TEXT", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.addElement(table2);
		cell.setColspan(4);
		cell.setPadding(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Permenent Action :", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidthRight(0);
		cell.setColspan(2);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" ", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidthLeft(0);
		cell.setColspan(2);
		cell.setMinimumHeight(20);
		table.addCell(cell);

		// t3 Table3 created added to Cell

		PdfPTable table3 = new PdfPTable(3);
		table3.setWidthPercentage(100);

		cell = new PdfPCell(new Phrase("Sr.No ", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table3.addCell(cell);

		cell = new PdfPCell(new Phrase("Cut Off No ", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table3.addCell(cell);

		cell = new PdfPCell(new Phrase("Date", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table3.addCell(cell);

		cell = new PdfPCell(new Phrase("Sr.No TEXT ", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table3.addCell(cell);

		cell = new PdfPCell(new Phrase("Cut Off No TEXT ", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table3.addCell(cell);

		cell = new PdfPCell(new Phrase("Date TEXT", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		table3.addCell(cell);

		cell = new PdfPCell();
		cell.addElement(table3); // table 3 added here
		cell.setColspan(4);
		cell.setPadding(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Documents Updated :", normalBold));
		cell.setMinimumHeight(15);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setColspan(4);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Sustenance Plan Updated :", normalBold));
		cell.setMinimumHeight(15);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setColspan(6);
		table.addCell(cell);

		// t4 table4 Created

		PdfPTable table4 = new PdfPTable(6);
		table4.setWidths(new float[] { 1f, 4f, 1f, 4f, 1f, 4f });
		table4.setWidthPercentage(100);
		boolean uncheck = false;
		if (uncheck) {
			image = Image.getInstance("Assets//Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("Assets//Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}

		cell = new PdfPCell();
		cell.addElement(image);
		cell.setBorder(0);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase("POS/Process Sheet", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(0);
		table4.addCell(cell);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}
		cell = new PdfPCell();
		cell.setBorder(0);
		cell.addElement(image);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase("SOS/SOP,DCP", normalBold));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table4.addCell(cell);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}

		cell = new PdfPCell();
		cell.addElement(image);
		cell.setBorder(0);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase("Monitoring Plan / Control Plan", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(0);
		table4.addCell(cell);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}
		cell = new PdfPCell();
		cell.setBorder(0);
		cell.addElement(image);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase("Checkman Checklist", normalBold));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table4.addCell(cell);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}

		cell = new PdfPCell();
		cell.addElement(image);
		cell.setBorder(0);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase("OTHERS", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(0);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		table4.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table4.addCell(cell);

		cell = new PdfPCell();
		cell.setPadding(0);
		cell.setBorderWidthRight(0);
		cell.addElement(table4); // added table4 here to cell
		cell.setColspan(3);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorderWidthLeft(0);
		cell.setColspan(1);
		table.addCell(cell);

		// again using table4
		PdfPTable table5 = new PdfPTable(6);
		table5.setWidths(new float[] { 1f, 4f, 1f, 4f, 1f, 4f });
		table5.setWidthPercentage(100);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);

		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}

		cell = new PdfPCell();
		cell.addElement(image);
		cell.setBorder(0);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(" Self Check & Self Check Audit", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(0);
		table5.addCell(cell);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}
		cell = new PdfPCell();
		cell.setBorder(0);
		cell.addElement(image);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(" Supervisor Checklist", normalBold));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table5.addCell(cell);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}

		cell = new PdfPCell();
		cell.addElement(image);
		cell.setBorder(0);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(" Checkman Checklist(FIXED PART)", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(0);
		table5.addCell(cell);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}
		cell = new PdfPCell();
		cell.setBorder(0);
		cell.addElement(image);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(" JH Checklist", normalBold));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table5.addCell(cell);

		if (uncheck) {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Uncheck.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		} else {
			image = Image.getInstance("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Check.png");
			image.scaleAbsoluteWidth(10f);
			image.scaleAbsoluteHeight(5f);
		}

		cell = new PdfPCell();
		cell.addElement(image);
		cell.setBorder(0);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase("PM Checklist", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(0);
		table5.addCell(cell);

		cell = new PdfPCell();
		cell.addElement(image);
		cell.setBorder(0);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(" Process Audit", normalBold));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table5.addCell(cell);

		cell = new PdfPCell();
		cell.addElement(image);
		cell.setBorder(0);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase("OTHERS", normalBold));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		table5.addCell(cell);

		cell = new PdfPCell(new Phrase(""));
		cell.setBorder(0);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table5.addCell(cell);

		cell = new PdfPCell();
		cell.addElement(table5); // table 4 2nd column added here
		cell.setColspan(5);
		cell.setPadding(0);
		cell.setBorderWidthRight(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("", normalBold));
		cell.setColspan(1);
		cell.setBorderWidthLeft(0);
		table.addCell(cell);

		// Remarks
		cell = new PdfPCell(new Phrase("Remarks -:", normalBold));
		cell.setColspan(4);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidthBottom(0);
		table.addCell(cell);

		// Authorisation
		cell = new PdfPCell(new Phrase("Authorisation -:", normalBold));
		cell.setColspan(6);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidthBottom(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("", normalBold));
		cell.setColspan(4);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		// new table added here
		PdfPTable table6 = new PdfPTable(4);
		table6.setWidthPercentage(100);

		cell = new PdfPCell(new Phrase("Concern Owner", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		table6.addCell(cell);

		cell = new PdfPCell(new Phrase("PVT Platform Lead", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		table6.addCell(cell);

		cell = new PdfPCell(new Phrase("PVT COE ", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		table6.addCell(cell);

		cell = new PdfPCell(new Phrase("PVT HEAD", normalBold));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		table6.addCell(cell);

		cell = new PdfPCell(new Phrase("Concern Owner", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		table6.addCell(cell);

		cell = new PdfPCell(new Phrase("PVT Platform Lead", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		table6.addCell(cell);

		cell = new PdfPCell(new Phrase("PVT COE ", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		table6.addCell(cell);

		cell = new PdfPCell(new Phrase("PVT HEAD", normalFont));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(15);
		table6.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(6);
		cell.addElement(table6);
		cell.setPadding(0);
		table.addCell(cell);

		document.add(table);
	}

//*********************** Lesson Learnt ******************************
	public static void LessonLearnt(Document document) throws DocumentException {
		table = new PdfPTable(4);
		table.setWidths(new float[] { 5f, 5f, 5f, 5f });
		table.setWidthPercentage(100);

		// row1
		cell = new PdfPCell(new Phrase("Cause Verification", boldFontHeading));
		cell.setColspan(6);
		cell.setMinimumHeight(30);
		cell.setUseAscender(true);
		cell.setBorder(0);
		table.addCell(cell);

		String[] dataArrays = { "Lesson No", "Data here", "Project Reference", "Data here", "Team", "Data here",
				"Title", "Data here", "Description", "Data here", "What Went Right ?", "Data here", "What Went Wrong ?",
				"Data here", "Recommendation", "Data here", "Category", "Data here", "Core Process Affected",
				"Data here", "Experience At", "Data here", "Department Name", "Data here", "Department No.",
				"Data here", "Revision No", "Data here" };

		int dataIndex = 0;
		for (String dataArray : dataArrays) {
			if (dataIndex == 0 || dataIndex % 2 == 0) {
				cell = new PdfPCell(new Phrase(dataArray, normalBold));
			} else {
				cell = new PdfPCell(new Phrase(dataArray, normalFont));
				cell.setColspan(3);
			}
			cell.setMinimumHeight(25);
			cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			dataIndex++;
		}
		document.add(table);

	}

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		String filePath = "Pdf\\CCR.pdf";
		Document document = new Document();
		document.setMargins(20, 20, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		ConcernClosureReport(document);

		document.newPage(); // break Page
		Why_Why_Analysis(document);

		document.newPage();
		CauseAndEffect(document);

		document.newPage();
		CauseVerification(document);

		document.newPage();
		G8DReport(document);

		document.newPage();
		ConcerClouserReport(document);

		document.newPage();
		LessonLearnt(document);

		document.close();
		System.out.println("PDF created successfully");
	}
}