package com.dawn.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtil
{
	public static final DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static ArrayList<ArrayList<String>> readExcel(MultipartFile mExcel)
	{
		ArrayList<ArrayList<String>> Row = new ArrayList<ArrayList<String>>();
		try
		{
			Workbook workBook = null;
			// if(mExcel!=null){
			
			try
			{
				workBook = new XSSFWorkbook(mExcel.getInputStream());
			} catch (Exception ex)
			{
				workBook = new HSSFWorkbook(mExcel.getInputStream());
			}
			/*
			 * }else{ try { workBook = new XSSFWorkbook(new
			 * FileInputStream(fExcel)); } catch (Exception ex) { workBook = new
			 * HSSFWorkbook(new FileInputStream(fExcel)); //} }
			 */

			FormulaEvaluator evaluator = workBook.getCreationHelper().createFormulaEvaluator();

			for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++)
			{
				Sheet sheet = workBook.getSheetAt(numSheet);
				if (sheet == null || !sheet.getSheetName().equals("Sheet1"))
				{
					continue;
				}
				// 循环行Row
				for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++)
				{
					Row row = sheet.getRow(rowNum);
					if (row == null)
					{
						continue;
					}

					// 循环列Cell
					ArrayList<String> arrCell = new ArrayList<String>();
					for (int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++)
					{
						Cell cell = row.getCell(cellNum);
						if (cell == null)
						{
							//arrCell.add("");
							continue;
						}
						
						//兼容日期类型
						if(Cell.CELL_TYPE_NUMERIC == cell.getCellType())
						{
							if (HSSFDateUtil.isCellDateFormatted(cell)) 
							{
								Date date = cell.getDateCellValue();
								String cellValue = formater.format(date);
								arrCell.add(cellValue);
							}
						}else{
							CellValue cellValue = evaluator.evaluate(cell);
							if(getValue(cellValue)!=null)
							{
								arrCell.add(getValue(cellValue)); 
							}
						}
						
						
					}
					if(arrCell!=null && !arrCell.isEmpty())
					{
						Row.add(arrCell);
					}
				}
			}
		} catch (IOException e)
		{
			System.out.println("e:" + e);
		}

		return Row;
	}

	private static String getValue(CellValue cell)
	{
		try
		{
			if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
			{
				return String.valueOf(cell.getBooleanValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			{
				return String.valueOf(cell.getNumberValue());
			} else
			{
				return String.valueOf(cell.getStringValue());
			}
		} catch (Exception e)
		{
			return null;
		}
	}
}