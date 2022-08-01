package com.learn.quiz.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.learn.quiz.dto.QuestionDto;

public class ExcelReader {
	public static List<QuestionDto> getQuestion(InputStream inputStream) {
		List<QuestionDto> questionSets = new ArrayList<QuestionDto>();
		try (XSSFWorkbook wb = new XSSFWorkbook(inputStream)) {
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			if (itr.hasNext()) {
				itr.next();
			}
			while (itr.hasNext()) {
				Row row = itr.next();
				String question = null;
				String optionA = null;
				String optionB = null;
				String optionC = null;
				String optionD = null;
				String correctOption = null;
				int i = 0;
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					cell.setCellType(CellType.STRING);
					switch (i) {
					case 0:
						question = cell.getStringCellValue();
						break;
					case 1:
						optionA = cell.getStringCellValue();
						break;
					case 2:
						optionB = cell.getStringCellValue();
						break;
					case 3:
						optionC = cell.getStringCellValue();
						break;
					case 4:
						optionD = cell.getStringCellValue();
						break;
					case 5:
						correctOption = cell.getStringCellValue();
						break;
					default:
					}
					i++;
				}
				questionSets.add(new QuestionDto(question, optionA, optionB, optionC, optionD, correctOption));
			}
			return questionSets;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
