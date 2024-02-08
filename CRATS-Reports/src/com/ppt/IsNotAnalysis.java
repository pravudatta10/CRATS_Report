package com.ppt;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

public class IsNotAnalysis {

	private static void setTableBorders(XSLFTable table) {
		for (int row = 0; row < table.getNumberOfRows(); row++) {
			for (int col = 0; col < table.getNumberOfColumns(); col++) {
				XSLFTableCell cell = table.getCell(row, col);
				cell.setBorderColor(BorderEdge.bottom, Color.BLACK);
				cell.setBorderColor(BorderEdge.top, Color.BLACK);
				cell.setBorderColor(BorderEdge.left, Color.BLACK);
				cell.setBorderColor(BorderEdge.right, Color.BLACK);
			}
		}
	}

	private static void addDate(XSLFSlide slide) {
		XSLFTextBox dateTextBox = slide.createTextBox();
		dateTextBox.setAnchor(new java.awt.Rectangle(50, 500, 300, 50));
		XSLFTextParagraph paragraph = dateTextBox.addNewTextParagraph();
		XSLFTextRun run = paragraph.addNewTextRun();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		String dateTimeString = dateFormat.format(calendar.getTime());
		run.setFontSize(15.0);
		run.setText(dateTimeString);
	}

	private static void IsNotAnalysisPpt(XSLFSlide slide) {
		int totalColumn = 5;
		int totalRows = 13;
		double colWidth = 125.0;
		XSLFTable table = slide.createTable(totalRows, totalColumn);// rows,column
		table.setAnchor(new java.awt.Rectangle(50, 25, 0, 0));
		// Set column widths
		for (int col = 0; col < totalColumn; col++) {
			table.setColumnWidth(col, colWidth);
		}
		setTableBorders(table);

		String topHeaders[] = { "Is Not Analysis", "PROBLEM SOLVING WORKSHEET", "Form: D2/3", "Problem Description : ",
				" Data here", "Problem Statement : ", "Data here" };
		int topIndex = 0;
		for (String topHeader : topHeaders) {
			XSLFTableCell cell = null;
			XSLFTextParagraph paragraph;
			XSLFTextRun run;
			if (topIndex == 0) {
				table.mergeCells(0, 0, 0, 4); // startRow, endRow, startCol, endCol
				cell = table.getCell(0, 0);
				cell.setFillColor(Color.LIGHT_GRAY);
			} else if (topIndex == 1) {
				table.mergeCells(1, 1, 0, 1);
				cell = table.getCell(1, 0);

			} else if (topIndex == 2) {
				table.mergeCells(1, 1, 2, 4);
				cell = table.getCell(1, 2);

			} else if (topIndex == 3) {
				table.mergeCells(2, 2, 0, 1);
				cell = table.getCell(2, 0);

			} else if (topIndex == 4) {
				table.mergeCells(2, 2, 2, 4);
				cell = table.getCell(2, 2);

			} else if (topIndex == 5) {
				table.mergeCells(3, 3, 0, 1);
				cell = table.getCell(3, 0);

			} else if (topIndex == 6) {
				table.mergeCells(3, 3, 2, 4);
				cell = table.getCell(3, 2);
			}
			cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
			paragraph = cell.addNewTextParagraph();
			paragraph.setTextAlign(TextAlign.CENTER);
			run = paragraph.addNewTextRun();
			run.setText(topHeader);
			if (topIndex != 4 && topIndex != 6) {
				run.setBold(true);
			}
			run.setFontSize(15.0);
			topIndex++;
		}
		// row5
		String[] headings = { "Problem Description", "IS", "IS NOT", "Get Information" };
		int index = 0;
		for (String heading : headings) {
			XSLFTableCell cell = table.getCell(4, index == 1 ? index = 2 : index);
			cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
			table.setRowHeight(4, 50.0);
			XSLFTextParagraph paragraph = cell.addNewTextParagraph();
			paragraph.setTextAlign(TextAlign.CENTER);
			XSLFTextRun run = paragraph.addNewTextRun();
			if (index == 0) {
				table.mergeCells(4, 4, 0, 1);
				run.setText(heading);
			}
			run.setText(heading);
			run.setFontSize(15.0);
			run.setBold(true);
			index++;
		}

		String[] siteHeadings = { "WHAT", "WHEN", "WHERE", "HOW BIG" };
		int startRow = 5;
		for (String siteHeading : siteHeadings) {
			int endRow = startRow + 1;
			table.mergeCells(startRow, endRow, 0, 0);
			XSLFTableCell cell = table.getCell(startRow, 0);
			XSLFTextParagraph paragraph = cell.addNewTextParagraph();
			paragraph.setTextAlign(TextAlign.CENTER);
			XSLFTextRun run = paragraph.addNewTextRun();
			run.setText(siteHeading);
			run.setFontSize(15.0);
			run.setBold(true);
			startRow += 2;
		}

		String[] objectDefects = { "Object", "Defect" };
		int objectDefectRow = 5;
		while (objectDefectRow <= 12) {
			for (String objectDefect : objectDefects) {
				XSLFTableCell cell = table.getCell(objectDefectRow, 1);
				XSLFTextParagraph paragraph = cell.addNewTextParagraph();
				paragraph.setTextAlign(TextAlign.CENTER);
				XSLFTextRun run = paragraph.addNewTextRun();
				run.setText(objectDefect);
				run.setFontSize(15.0);
				run.setBold(true);
				objectDefectRow++;
			}
		}

		// Fill dummy data into the table
		for (int row = 5; row < totalRows; row++) {
			for (int col = 2; col < totalColumn; col++) {
				XSLFTableCell cell = table.getCell(row, col);
				XSLFTextParagraph paragraph = cell.addNewTextParagraph();
				paragraph.setTextAlign(TextAlign.CENTER);
				XSLFTextRun run = paragraph.addNewTextRun();
				run.setText("Data here");
				run.setFontSize(15.0);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow slideShow = new XMLSlideShow();
		XSLFSlide slide = slideShow.createSlide();
		IsNotAnalysisPpt(slide);
		addDate(slide);
		try (FileOutputStream out = new FileOutputStream(
				"C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Is Not Analysis.pptx")) {
			slideShow.write(out);
		}
	}
}