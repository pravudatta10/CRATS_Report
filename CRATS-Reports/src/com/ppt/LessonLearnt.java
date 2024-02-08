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

public class LessonLearnt {

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

	public static void lessonLearntPPT(XSLFSlide slide) {
		XSLFTable table = slide.createTable();
		table.setAnchor(new Rectangle(50, 50, 600, 800));
		XSLFTableRow row;
		XSLFTableCell cell;

		for (int i = 0; i < 13; i++) {
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
		table.mergeCells(0, 1, 0, 1);
		setStyleToRun(table, "Lesson Learnt", true, 0, 0, "", "center");
		setStyleToRun(table, "Model", true, 0, 2, "", "");
		setStyleToRun(table, "Model Text", false, 0, 3, "", "");

		// row2
		setStyleToRun(table, "Author", true, 1, 2, "", "");
		setStyleToRun(table, "Author Text", false, 1, 3, "", "");

		// row3
		String arrr2Data[] = { "Lesson No ", "Data here", "Project Reference", "Project Reference Text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr2Data[i], true, 2, i, "", "");
			} else {
				setStyleToRun(table, arrr2Data[i], false, 2, i, "", "");
			}
		}

		// row4
		setStyleToRun(table, "Team", true, 3, 0, "", "");
		table.mergeCells(3, 3, 1, 3);
		setStyleToRun(table, "", false, 3, 1, "", "");

		// row5
		setStyleToRun(table, "Title", true, 4, 0, "", "");
		table.mergeCells(4, 4, 1, 3);
		setStyleToRun(table, "Title Text", false, 4, 1, "", "");

		// row6
		setStyleToRun(table, "Description", true, 5, 0, "", "");
		table.mergeCells(5, 5, 1, 3);
		setStyleToRun(table, "Description Text", false, 5, 1, "", "");

		// row7
		setStyleToRun(table, "What Went Right ? ", true, 6, 0, "", "");
		table.mergeCells(6, 6, 1, 3);
		setStyleToRun(table, "What Went Right ?   Text", false, 6, 1, "", "");

		// row8
		setStyleToRun(table, "What Went Wrong ?", true, 7, 0, "", "");
		table.mergeCells(7, 7, 1, 3);
		setStyleToRun(table, "What Went Wrong ? Text", false, 7, 1, "", "");

		// row9
		setStyleToRun(table, "Recommendation", true, 8, 0, "", "");
		table.mergeCells(8, 8, 1, 3);
		setStyleToRun(table, "Recommendation Text", false, 8, 1, "", "");

		// row10
		String arrr9Data[] = { "Category", "Category Text", "Core Process Affected", "Core Process Affected text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr9Data[i], true, 9, i, "", "");
			} else {
				setStyleToRun(table, arrr9Data[i], false, 9, i, "", "");
			}
		}

		// row11
		setStyleToRun(table, "Experience At", true, 10, 0, "", "");
		table.mergeCells(10, 10, 1, 3);
		setStyleToRun(table, "Experience At Text", false, 10, 1, "", "");

		// row12
		String arrr10Data[] = { "Department Name", "Department Name Text", "Department No. ", "Department No.   text" };
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				setStyleToRun(table, arrr10Data[i], true, 11, i, "", "");
			} else {
				setStyleToRun(table, arrr10Data[i], false, 11, i, "", "");
			}

		}

		// row13
		setStyleToRun(table, "Revision No", true, 12, 0, "", "");
		table.mergeCells(12, 12, 1, 3);
		setStyleToRun(table, "Revision No Text", false, 12, 1, "", "");
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow slideShow = new XMLSlideShow();
		slideShow.setPageSize(new java.awt.Dimension(700, 400));
		XSLFSlide slide = slideShow.createSlide();
		lessonLearntPPT(slide);
		try (FileOutputStream out = new FileOutputStream("C:\\Users\\kpds0\\Desktop\\CRTS OUTPUT\\Lesson Learnt.pptx")) {
			slideShow.write(out);
		}
	}

}
