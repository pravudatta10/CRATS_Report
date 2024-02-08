package com.ppt;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

public class G8DPPT {

	public static void setStyleToRun(XSLFTable table, String Text, boolean bold, int rowno, int cellno, String Heading,
			String alignment) {

		XSLFTableCell cell = table.getCell(rowno, cellno);

		if (!Heading.equals("")) {
			cell.setFillColor(Color.LIGHT_GRAY);
		}

		XSLFTextParagraph para = cell.addNewTextParagraph();
		if (alignment.equals("center")) {
			para.setTextAlign(TextAlign.CENTER);
		} else {
			para.setTextAlign(TextAlign.LEFT);
		}

		XSLFTextRun run = para.addNewTextRun();
		cell = table.getCell(0, 0);
		run.setText(Text);
		run.setFontSize(10.0);
		run.setBold(bold);
	}

	public static void generateG8DPPT(XSLFSlide slide) {

		XSLFTable table = slide.createTable();
		table.setAnchor(new Rectangle(50, 50, 600, 800));
		int numRows = 34;
		int numCols = 4;

		// Add rows and cells
		XSLFTableRow row;
		XSLFTableCell Cells;
		XSLFTextParagraph para;
		XSLFTextRun run;

		for (int i = 0; i < numRows; i++) {
			row = table.addRow();
			for (int j = 0; j < numCols; j++) {
				XSLFTableCell cell = row.addCell();
				cell.setBorderColor(BorderEdge.bottom, Color.BLACK);
				cell.setBorderColor(BorderEdge.top, Color.BLACK);
				cell.setBorderColor(BorderEdge.left, Color.BLACK);
				cell.setBorderColor(BorderEdge.right, Color.BLACK);
				table.setColumnWidth(j, 150);
			}
		}

		// row1
		table.mergeCells(0, 0, 0, 3);
		setStyleToRun(table, "G8D REPORT (SUMMARY)", true, 0, 0, "f", "center");

		// row2
		String arrr2Data[] = { "Title", "Data here", "Model", "VERITO" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr2Data[i], true, 1, i, "", "");
			} else {
				setStyleToRun(table, arrr2Data[i], false, 1, i, "", "");
			}
		}

		// row3
		String arrr3Data[] = { "Date Opened", "05-02-2024", "Last Updated ", "05-02-2024" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr3Data[i], true, 2, i, "", "");
			} else {
				setStyleToRun(table, arrr3Data[i], false, 2, i, "", "");
			}
		}

		// row4
		String arrr4Data[] = { "Oraganization / Location", "05-02-2024", "Product/Process Information", "05-02-2024" };
		for (int i = 0; i < 4; i++) {

			if (i % 2 == 0) {
				setStyleToRun(table, arrr4Data[i], true, 3, i, "", "");
			} else {
				setStyleToRun(table, arrr4Data[i], false, 3, i, "", "");
			}
		}

		// row5
		table.mergeCells(4, 4, 0, 3);
		setStyleToRun(table, "D0", true, 4, 0, "", "");

		// row6
		setStyleToRun(table, "Symptom (s)", true, 5, 0, "", "");
		table.mergeCells(5, 5, 1, 3);
		setStyleToRun(table, "Symptom (s) text", false, 5, 1, "", "");

		// row7
		setStyleToRun(table, "Emergency Responsive Action", true, 6, 0, "", "");
		table.mergeCells(6, 6, 1, 3);
		setStyleToRun(table, "Emergency Responsive Action text", false, 6, 1, "", "");

		// row8
		setStyleToRun(table, "Customer Protection Action", true, 7, 0, "", "");
		table.mergeCells(7, 7, 1, 3);
		setStyleToRun(table, "Customer Protection Action text", false, 7, 1, "", "");

		// row9
		String arrr5Data[] = { "Verification & Validation", "Verification & Validation Text", "% Effectiveness",
				"% Effectiveness text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr5Data[i], true, 8, i, "", "");
			} else {
				setStyleToRun(table, arrr5Data[i], false, 8, i, "", "");
			}
		}

		// row 10
		setStyleToRun(table, "Date Implemented ", true, 9, 0, "", "");
		table.mergeCells(9, 9, 1, 3);
		setStyleToRun(table, "Date Implemented  text", false, 9, 1, "", "");

		// row11
		table.mergeCells(10, 10, 0, 1);
		setStyleToRun(table, "D1", true, 10, 0, "", "");
		table.mergeCells(10, 10, 2, 3);
		setStyleToRun(table, "D2", true, 10, 2, "", "");

		// row12
		String arrr6Data[] = { "Champion", "Champion Text", "Problem Statement", "Problem Statement text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr6Data[i], true, 11, i, "", "");
			} else {
				setStyleToRun(table, arrr6Data[i], false, 11, i, "", "");
			}
		}

		// row13
		setStyleToRun(table, "Leader", true, 12, 0, "", "");
		setStyleToRun(table, "Leader Text", false, 12, 1, "", "");

		// row14
		table.mergeCells(12, 13, 2, 2);
		setStyleToRun(table, "Problem Defination", true, 12, 2, "", "");
		table.mergeCells(12, 13, 3, 3);
		setStyleToRun(table, "Problem Defination text", false, 12, 3, "", "");
		setStyleToRun(table, "Team", true, 13, 0, "", "");
		setStyleToRun(table, "", false, 13, 1, "", "");

		// row15
		table.mergeCells(14, 14, 0, 3);
		setStyleToRun(table, "D3", true, 14, 0, "", "");

		// row16
		setStyleToRun(table, "Interim Containment Action(s) ", true, 15, 0, "", "");
		table.mergeCells(15, 15, 1, 3);
		setStyleToRun(table, "Interim Containment Action(s)  text", false, 15, 1, "", "");

		// row17
		String arrr7Data[] = { "Verification & Validation", "Verification & Validation Text", "% Effectiveness",
				"% Effectiveness text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr7Data[i], true, 16, i, "", "");
			} else {
				setStyleToRun(table, arrr7Data[i], false, 16, i, "", "");
			}
		}

		// row18
		setStyleToRun(table, "Date Implemented ", true, 17, 0, "", "");
		table.mergeCells(17, 17, 1, 3);
		setStyleToRun(table, "Date Implemented  text", false, 17, 1, "", "");

		// row19
		table.mergeCells(18, 18, 0, 3);
		setStyleToRun(table, "D4", true, 18, 0, "", "");

		// row20
		setStyleToRun(table, "Root Cause(s) ", true, 19, 0, "", "");
		table.mergeCells(19, 19, 1, 3);
		setStyleToRun(table, "Root Cause(s)  text", false, 19, 1, "", "");

		// row21
		String arrr8Data[] = { "Verification & Validation", "Verification & Validation Text", "%Contribution",
				"%Contribution text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr8Data[i], true, 20, i, "", "");
			} else {
				setStyleToRun(table, arrr8Data[i], false, 20, i, "", "");
			}
		}

		// row22
		table.mergeCells(21, 21, 0, 3);
		setStyleToRun(table, "D5", true, 21, 0, "", "");

		// row23
		setStyleToRun(table, "Chosen Permanent Corrective Action(s) ", true, 22, 0, "", "");
		table.mergeCells(22, 22, 1, 3);
		setStyleToRun(table, "Chosen Permanent Corrective Action(s)  text", false, 22, 1, "", "");

		// row24
		String arrr9Data[] = { "Verification & Validation", "Verification & Validation Text", "%Effectiveness",
				"%Effectiveness text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr9Data[i], true, 23, i, "", "");
			} else {
				setStyleToRun(table, arrr9Data[i], false, 23, i, "", "");
			}
		}

		// row25
		table.mergeCells(24, 24, 0, 3);
		setStyleToRun(table, "D6", true, 24, 0, "", "");

		// row26
		setStyleToRun(table, "Implemented PermanentCorrective Action(s) ", true, 25, 0, "", "");
		table.mergeCells(25, 25, 1, 3);
		setStyleToRun(table, "Implemented PermanentCorrective Action(s)  text", false, 25, 1, "", "");

		// row27
		String arrr10Data[] = { " Validation", "Validation Text", "Cut Off No", "Cut Off No text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr10Data[i], true, 26, i, "", "");
			} else {
				setStyleToRun(table, arrr10Data[i], false, 26, i, "", "");
			}
		}

		// row28
		table.mergeCells(27, 27, 0, 3);
		setStyleToRun(table, "D7", true, 27, 0, "", "");

		// row29
		setStyleToRun(table, "Prevent Recurrence Action(s) ", true, 28, 0, "", "");
		table.mergeCells(28, 28, 1, 3);
		setStyleToRun(table, "Prevent Recurrence Action(s)  text", false, 28, 1, "", "");

		// row30
		String arrr11Data[] = { " Verification & Validation", "Verification & Validation Text", "Date Implemented",
				"Date Implemented text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr11Data[i], true, 29, i, "", "");
			} else {
				setStyleToRun(table, arrr11Data[i], false, 29, i, "", "");
			}
		}

		// row31
		setStyleToRun(table, "Responsibility ", true, 30, 0, "", "");
		table.mergeCells(30, 30, 1, 3);
		setStyleToRun(table, "Responsibility  text", false, 30, 1, "", "");

		// row32
		table.mergeCells(31, 31, 0, 3);
		setStyleToRun(table, "D8", true, 31, 0, "", "");

		// row33
		setStyleToRun(table, "Team & Individual Recognition ", true, 32, 0, "", "");
		table.mergeCells(28, 28, 1, 3);
		setStyleToRun(table, "Team & Individual Recognition  text", false, 32, 1, "", "");

		// row34
		String arrr12Data[] = { "Reported By", "Reported By Text", "Date Closed", "Date Closed" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr12Data[i], true, 33, i, "", "");
			} else {
				setStyleToRun(table, arrr12Data[i], false, 33, i, "", "");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow slideShow = new XMLSlideShow();
		slideShow.setPageSize(new java.awt.Dimension(700, 880));
		XSLFSlide slide = slideShow.createSlide();
		generateG8DPPT(slide);
		// addDate(slide);
		try (FileOutputStream out = new FileOutputStream("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\G8D PPT.pptx")) {
			slideShow.write(out);
		}
	}
}