/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.util;

/**
 * 常量工具类
 * 
 * @author wujing
 */
public final class Constants {

	private Constants() {
	}

	public final static String INDEX_URL = "indexUrl";

	public final static String RESOURCES = "RESOURCES";

	/**
	 * 常量
	 * 
	 * @author wujing
	 */
	public interface Token {
		public final static String RONCOO = "KINGDEE_BI";
		public final static String USER_INFO = "USER_INFO";
		public final static String COMPANY_INFO = "COMPANY_INFO";
		public final static String COMPANY_NUMBER = "companyNumber";
		public final static String YZJ_OPEN_ID = "YZJ_OPEN_ID";
	}

	/**
	 * 资源类型
	 */
	public interface ResourceType {
		public final static String LABEL = "LABEL";
		public final static String MENU = "MENU";
		public final static String BUTTON = "BUTTON";
		public final static String REPORT = "REPORT";
	}

	/**
	 * 状态类型
	 * 
	 * @author wujing
	 */
	public interface Status {
		public final static String ZERO = "0";
		public final static String ONE = "1";
		public final static String TWO = "2";
		public final static String THREE = "3";
	}

	/**
	 * 数字类型
	 * 
	 * @author wujing
	 * @version 1.0
	 */
	public interface Num {
		public final static int ZERO = 0;
		public final static int ONE = 1;
		public final static int FIVE = 5;
		public final static int TEN = 10;
	}

	/**
	 * 指标类型
	 */
	public interface QuotaType {
		/**
		 * 牧场类
		 */
		public final static String PASTURE = "PASTURE";
		/**
		 * 乳业类
		 */
		public final static String MILK = "MILK";
		/**
		 * 财务类
		 */
		public final static String FINANCE = "FINANCE";
		/**
		 * 集团类
		 */
		public final static String GROUP = "GROUP";
	}

	/**
	 * 模板
	 */
	public interface Template {
		public final static String FINANCE_OTHER_TEMP = "FINANCE_OTHER_TEMPLATE.xlsx";
		public final static String FINANCE_REPORT_TEMP = "FINANCE_REPORT_TEMPLATE.xlsx";
	}

}
