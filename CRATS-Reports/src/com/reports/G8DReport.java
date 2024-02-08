package com.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class G8DReport {
	static Font boldFontHeading = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	static Font normalBold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	static Font normalFont = new Font(Font.FontFamily.HELVETICA, 9);
	static PdfPCell cell;
	static PdfPTable table;

	public static void generateG8DReport(Document document) throws DocumentException {
		table = new PdfPTable(4);
		table.setWidthPercentage(100);
		// row1
		cell = new PdfPCell(new Phrase("G8D REPORT (SUMMARY)", boldFontHeading));
		cell.setColspan(4);
		cell.setMinimumHeight(20);
		cell.setUseAscender(true);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		// row2
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

//	   		 row15

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

		cell = new PdfPCell(new Phrase(" Root Cause (s) TEXT", normalFont));
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

		cell = new PdfPCell(new Phrase("Date Implemented TEXT", normalFont));
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

		cell = new PdfPCell(new Phrase("Root Cause(s) TEXT", normalFont));
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

		cell = new PdfPCell(new Phrase("Chosen Permanent Corrective Action(s)TXT", normalFont));
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

		cell = new PdfPCell(new Phrase("Implemented Permanent Corrective Action(s)TXT", normalFont));
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
//	   		 row28
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

		cell = new PdfPCell(new Phrase("Prevent Recurrence Action(s) Text", normalFont));
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

		cell = new PdfPCell(new Phrase("Prevent Recurrencet Recommendation(s) Systemi TEXT", normalFont));
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

		cell = new PdfPCell(new Phrase(" Responsibility Text", normalFont));
		cell.setColspan(3);
		cell.setPadding(3);
		cell.setMinimumHeight(20);
		cell.setUseAscender(false);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		//// row33
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

		cell = new PdfPCell(new Phrase(" Team & Individual Recognition Text ", normalFont));
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

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String filePath = "C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\G8D Report.pdf";
		Document document = new Document();
		document.setMargins(20, 20, 30, 30);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
		FooterDateTime datetime = new FooterDateTime();
		writer.setPageEvent(datetime);
		generateG8DReport(document);
		document.close();
		System.out.println("PDF created successfully");
	}

}
