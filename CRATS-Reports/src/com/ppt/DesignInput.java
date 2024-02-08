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

public class DesignInput {

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

	public static void DesignInputPPT(XSLFSlide slide) {

		XSLFTable table = slide.createTable();
		table.setAnchor(new Rectangle(50, 50, 600, 800));
		XSLFTableRow row;
		XSLFTableCell cell;

		for (int i = 0; i < 10; i++) {
			row = table.addRow();
			for (int j = 0; j < 4; j++) {
				cell = row.addCell();
				cell.setBorderColor(BorderEdge.bottom, Color.BLACK);
				cell.setBorderColor(BorderEdge.top, Color.BLACK);
				cell.setBorderColor(BorderEdge.left, Color.BLACK);
				cell.setBorderColor(BorderEdge.right, Color.BLACK);
				table.setColumnWidth(j, 150);
			}

		}

		// row1
		table.mergeCells(0, 0, 0, 3);
		setStyleToRun(table, "DESIGN INPUT REQUIRMENTS", true, 0, 0, "f", "center");

		// row2
		table.mergeCells(1, 1, 0, 3);
		setStyleToRun(table, "Design Input", true, 1, 0, "", "");

		// row3
		String arrr2Data[] = { "Customer Complaint Received ", "Data here", "Date", "Date Text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr2Data[i], true, 2, i, "", "");
			} else {
				setStyleToRun(table, arrr2Data[i], false, 2, i, "", "");
			}
		}

		// row4
		String arrr3Data[] = { "Concern Name", "Concern Name Text", "On Date ", "On Date Text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr3Data[i], true, 3, i, "", "");
			} else {
				setStyleToRun(table, arrr3Data[i], false, 3, i, "", "");
			}
		}

		// row5
		String arrr4Data[] = { "Revision No", "Revision No Text", "Product Name", "Product Name" };
		for (int i = 0; i < 4; i++) {

			if (i % 2 == 0) {
				setStyleToRun(table, arrr4Data[i], true, 4, i, "", "");
			} else {
				setStyleToRun(table, arrr4Data[i], false, 4, i, "", "");
			}
		}

		// row6
		String arrr5Data[] = { "Sample / Prototype / Mock up Provided", "Sample / Prototype / Mock up Provided Text",
				"If Yes Details", "If Yes Details Text " };
		for (int i = 0; i < 4; i++) {

			if (i % 2 == 0) {
				setStyleToRun(table, arrr5Data[i], true, 5, i, "", "");
			} else {
				setStyleToRun(table, arrr5Data[i], false, 5, i, "", "");
			}
		}

		// row7
		setStyleToRun(table, "Design Input Requirments", true, 6, 0, "", "");
		table.mergeCells(6, 6, 1, 3);
		setStyleToRun(table, "Symptom (s) text", false, 6, 1, "", "");

		// row8
		String arrr7Data[] = { "Discussed With", "Discussed With Text", "Estimated Cost Impact / Vehicle",
				"Estimated Cost Impact / Vehicle text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr7Data[i], true, 7, i, "", "");
			} else {
				setStyleToRun(table, arrr7Data[i], false, 7, i, "", "");
			}
		}

		// row9
		String arrr8Data[] = { "Expected EN Date", "Expected EN Date Text", "Expected Implementation Date",
				"Expected Implementation Date text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr8Data[i], true, 8, i, "", "");
			} else {
				setStyleToRun(table, arrr8Data[i], false, 8, i, "", "");
			}

		}

		// row10
		String arrr9Data[] = { "Prepared By", "Prepared By Text", "Approved By", "Approved By text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr9Data[i], true, 9, i, "", "");
			} else {
				setStyleToRun(table, arrr9Data[i], false, 9, i, "", "");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow slideShow = new XMLSlideShow();
		slideShow.setPageSize(new java.awt.Dimension(700, 400));
		XSLFSlide slide = slideShow.createSlide();
		DesignInputPPT(slide);
		// addDate(slide);
		try (FileOutputStream out = new FileOutputStream("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Design Input.pptx")) {
			slideShow.write(out);
		}
	}
}
