package org.openhab.designerx.domainobject;

public final class DomainObjectConstansts {
	// System
	public static final String CURRENT_WORKING_DIR = System.getProperty("user.dir");
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final String USER_HOME_DIR = System.getProperty("user.home");

	// charset
	public static final String CHARSET_NAME_UTF_8 = "utf-8";
	
	// marks
	public static final String COLON_MARK = ":";
	public static final String COMMA_MARK = ",";
	public static final String DOUBLE_QUOTE_MARK = "\"";
	public static final String EQU_MARK = "=";
	public static final String OPEN_SQUARE_BRACKET_MARK = "[";
	public static final String OPEN_CURLY_BRACE_MARK = "{";
	public static final String CLOSE_SQUARE_BRACKET_MARK = "]";
	public static final String CLOSE_CURLY_BRACE_MARK = "}";
	public static final String SPACE_MARK = " ";

	// private constructor
	private DomainObjectConstansts() {}
}
