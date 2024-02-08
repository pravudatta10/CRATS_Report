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

public class KmRangeWise {
	private static void setTableBorders(XSLFTable table) {
		for (int row = 0; row < table.getNumberOfRows(); row++) {
			for (int col = 0; col < table.getNumberOfColumns(); col++) {

				XSLFTableCell cell = table.getCell(row, col);
				cell.setBorderColor(BorderEdge.bottom, Color.BLACK);
				cell.setBorderColor(BorderEdge.top, Color.BLACK);
				if (row != 1) {
					cell.setBorderColor(BorderEdge.left, Color.BLACK);
					cell.setBorderColor(BorderEdge.right, Color.BLACK);
				}
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

	public static void KmRangeWiseInsident(XSLFSlide slide) {
		int totalColumn = 2;
		int totalRows = 5;
		double colWidth = 260.0;
		XSLFTable table = slide.createTable(totalRows, totalColumn);// rows,column
		table.setAnchor(new java.awt.Rectangle(50, 25, 0, 0));
		// Set column widths
		for (int col = 0; col < totalColumn; col++) {
			table.setColumnWidth(col, colWidth);
		}
		setTableBorders(table);

		table.mergeCells(0, 0, 0, 1); // startRow, endRow, startCol, endCol
		XSLFTableCell cell = table.getCell(0, 0);// row,column
		cell.setFillColor(Color.LIGHT_GRAY);
		cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		XSLFTextParagraph paragraph = cell.addNewTextParagraph();
		paragraph.setTextAlign(TextAlign.CENTER);
		XSLFTextRun run = paragraph.addNewTextRun();
		run.setText("KM RANGE WISE INCIDENTS");
		run.setFontSize(15.0);
		run.setBold(true);

		table.mergeCells(1, 1, 0, 1);
		String headers[] = { "KMS RANGE (In Thousand)", "INCIDENTS" };
		int index = 0;
		for (String heading : headers) {
			XSLFTableCell headersCell = table.getCell(2, index);
			headersCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
			table.setRowHeight(2, 30.0);
			XSLFTextParagraph headersParagraph = headersCell.addNewTextParagraph();
			headersParagraph.setTextAlign(TextAlign.CENTER);
			XSLFTextRun headersRun = headersParagraph.addNewTextRun();
			headersRun.setText(heading);
			headersRun.setFontSize(10.0);
			headersRun.setBold(true);
			index++;
		}
		// Fill dummy data into the table
		for (int row = 3; row < totalRows; row++) {
			for (int col = 0; col < totalColumn; col++) {
				XSLFTableCell Datacell = table.getCell(row, col);
				XSLFTextParagraph Dataparagraph = Datacell.addNewTextParagraph();
				Dataparagraph.setTextAlign(TextAlign.CENTER);
				XSLFTextRun Datarun = Dataparagraph.addNewTextRun();
				Datarun.setText("Data here");
				Datarun.setFontSize(10.0);
			}
		}

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow slideShow = new XMLSlideShow();
		slideShow.setPageSize(new java.awt.Dimension(620, 400));
		XSLFSlide slide = slideShow.createSlide();
		KmRangeWiseInsident(slide);
		addDate(slide);
		try (FileOutputStream out = new FileOutputStream(
				"C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Km Range Wise.pptx")) {
			slideShow.write(out);
		}
	}

}
