package com.aspire.day4;
/*
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
*/

public class ExcelParamentTest {
	public Object[][] testData(String file){
		/*ArrayList<String> arrkey = new ArrayList<String>();
		Workbook workbook = WorkBookEhi.getWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		//��ȡ������
		int rowTotalNum = sheet.getLastRowNum()+1;
		//��ȡ������
		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		
		HashMap<String,String>[][] map = new HashMap[rowTotalNum-1][1];
		//������������Ԫ��hashmap���г�ʼ��
		if(rowTotalNum > 1) {
			for(int i = 0; i< rowTotalNum; i++) {
				map[i][0] =  new HashMap();
			}
		}else {
			log.error("����Excel"+file+"��û�����ݣ�");
		}
		//��ȡ���ȵ���������Ϊhashmap��Keyֵ
		for(int c = 0;c < columns;c++) {
			String celvalue = CelUit.getCellValue(sheet,0,c);
			arrkey.add(celvalue);
			//map[r-1][0].put(arrkey.get(c), celvalue);
		}*/
		return new Object[][] {
			{"aaa","bbb"}
		};
		
	}

}
