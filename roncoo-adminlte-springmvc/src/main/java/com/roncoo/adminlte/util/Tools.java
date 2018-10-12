package com.roncoo.adminlte.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * 常用工具类
 * 
 * @author lx
 * @date 2016-12-4
 */
public class Tools {
	protected static final Logger logger = LoggerFactory.getLogger(Tools.class);

	public static  void  main(String[] args){
		//System.out.println(getPeriodeDate());

		//System.out.println(isRowStrong(1,23));
		String numStr = "一、乳品一厂产品";
		System.out.println(numStr.endsWith(".0"));
		if (numStr.indexOf(".0")>-1){
			System.out.println("aaaaa："+numStr.substring(0,numStr.indexOf(".0")));
		}
		System.out.println("覅用方法："+getRowNumIntString(numStr));
	}

	/**
	 * 判断文本是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str) || "null".equalsIgnoreCase(str) || str.length()==0){
			return true;
		}
		return false;
	}

	/**
	 * 解决表格的数据值为空转换成BigDecimal
	 * @param cellVall
	 * @return
	 */
	public static BigDecimal getDecimalCellValue(String cellVall){
		String result = "0.0";
		if (StringUtils.trimToNull(cellVall) != null){
			result = cellVall;
		}
		try {
			BigDecimal bd = new BigDecimal(result.trim());
			return bd;
		} catch (Exception e) {
			logger.error("bigdecimal format exception: {}",e.getMessage(), e);
			return new BigDecimal(0);
		}
	}

	/**
	 * 是否是加粗的行
	 * @return
	 */
	public static boolean isRowStrong(int sheet,int rowIndex){

		boolean strong = false;

		if (sheet==1){
			//主要指标1
			Integer[] strongIndex = new Integer[]{1,6,10,11,12,13,14,15,19,20,21,22,23,24,25,25,27,28,29,30,31,32,33};
			for (Integer integer : strongIndex) {
				if(rowIndex==integer){
					strong = true;
					break;
				}
			}
		}else if(sheet==7){
			//利润表
			Integer[] strongIndex = new Integer[]{5,6,9,21,25,27,29,30};
			for (Integer integer : strongIndex) {
				if(rowIndex==integer){
					strong = true;
					break;
				}
			}
		}else if(sheet==8){
			//现金流量表
			Integer[] strongIndex = new Integer[]{4,10,17,18,25,30,31,32,38,43,44,45,46,48};
			for (Integer integer : strongIndex) {
				if(rowIndex==integer){
					strong = true;
					break;
				}
			}
		}else if(sheet==9){
			//主营业务收支总(本月/累计) 表
			Integer[] strongIndex = new Integer[]{5,6,14,22,29,37,43,53};
			for (Integer integer : strongIndex) {
				if(rowIndex==integer){
					strong = true;
					break;
				}
			}
		}else if(sheet==11){
			//主营业务收支明细(本月)
			Integer[] strongIndex = new Integer[]{5,87,88,133,134,171,172};
			for (Integer integer : strongIndex) {
				if(rowIndex==integer){
					strong = true;
					break;
				}
			}
		}


		return  strong;
	}

	/**
	 * 上个月的区间 例：201709
	 * @return
	 */
	public static String getPeriodeDate(){
		String period = null;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		SimpleDateFormat format =  new SimpleDateFormat("yyyyMM");
		period = format.format(c.getTime());
		return  period;
	}

	/**
	 * 返回JSON
	 * 
	 * @param response
	 * @throws IOException
	 */
	public static void responseJSON(HttpServletResponse response, JSONObject object) throws IOException {
		String str = JSONObject.toJSONString(object);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(str);
		writer.flush();
		writer.close();
	}

	/**
	 * 读取Cell值
	 * <p>
	 * <i>Create by Andrew 2017年11月14日<i/>
	 * </p>
	 * @param workbook Excel对象
	 * @param cell 单元格对象
	 * @return 字符串格式值
	 */
	public static String getCellValue(Cell cell, Workbook workbook) {
		String cellValue = "";
		if (cell!=null && cell.getCellTypeEnum()!=null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC: //数字
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat fmt = null;
                        if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                            fmt = new SimpleDateFormat("HH:mm");
                        } else {// 日期
                            fmt = new SimpleDateFormat("yyyy-MM-dd");
                        }
                        Date date = cell.getDateCellValue();
                        cellValue = fmt.format(date);
                    } else {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case STRING: //字符串
                    cellValue = cell.getStringCellValue();
                    break;
                case FORMULA://公式
                    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
					try {
						CellValue val = evaluator.evaluate(cell);
						cellValue = getCellValue(val);
					} catch (Exception e) {
						logger.error("公式读取错误，SHEET页名称：{},行：{}，列：{}", cell.getSheet().getSheetName(), cell.getRowIndex(), cell.getCellFormula());
						cellValue = null;
					}
					break;
                case BOOLEAN://布尔
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                default:
                    logger.warn("不可识别类型，取值失败, CellType: {}", cell.getCellTypeEnum());
                    cellValue = "";
                    break;
            }
        }
		return cellValue;
	}

	/**
	 * 根据CellValue对象获取String类型值
	 *
	 * <p>
	 * <i>Create by Andrew 2017年11月14日<i/>
	 * </p>
	 * @param val 单元格值对象
	 * @return 返回字符串类型值
	 */
	public static String getCellValue(CellValue val) {
		String cellValue = null;
		switch (val.getCellTypeEnum()) {
			case STRING:
				cellValue = val.getStringValue();
				break;
			case NUMERIC:
				// 保留两位小数
				DecimalFormat df = new DecimalFormat("#0.00");
				df.setRoundingMode(RoundingMode.DOWN);
				cellValue = df.format(val.getNumberValue());
				break;
			case BOOLEAN:
				cellValue = String.valueOf(val.getBooleanValue());
				break;
			default:
				logger.warn("不可识别类型，取值失败, CellType: {}", val.getCellTypeEnum());
				break;
		}
		return cellValue;
	}

	/**
	 * 数字字符串去掉结尾的".0"
	 * @param numStr
	 * @return
	 */
	public static String getRowNumIntString(String numStr){

		String result = "";
		if (!isEmpty(numStr)){
			if(numStr.indexOf(".0")>-1 && numStr.endsWith(".0")){
				result = numStr.substring(0,numStr.indexOf(".0"));
			}else{
				result =  numStr;
			}
		}
		return  result;
	}
	/**
	 * 上个月的区间 例：201709
	 * @return
	 */
	public static String getPeriodeYear(){
		String period = null;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		SimpleDateFormat format =  new SimpleDateFormat("yyyy");
		period = format.format(c.getTime());
		return  period;
	}

}
