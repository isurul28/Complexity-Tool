package Cs;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cs_c {
	ArrayList<String> lines;
	ArrayList<Integer> CsUnit;
	ArrayList<String> token;

	// Expressions for checking Keywords
	String keyword_regx = "\\b(?!public |static |else |else\\{|try |try\\{|return |class |private )[\\d\\w]+|(\\\".*?\\\")|(?<=\\w)\\.(?=\\w)|(\\+\\+|\\-\\-|\\*|\\/|\\%|\\+|\\-)|(&&|\\|\\||!)|(\\^|\\||\\~|\\<\\<\\<|\\>\\>\\>|\\>\\>|\\<\\<)|(\\,|\\-\\>|\\:\\:)|(\\>\\>\\>\\=|\\<\\<\\=|\\>\\>\\=|\\^\\=|\\|\\=|\\&\\=|\\%\\=|\\/\\=|\\*\\=|\\-\\=|\\+\\=|\\=)|(==|!=|>=|<=|>|<)";
	// Expression for checking the special words throw,throws,new,delete
	String special_reg = "\\b(new |delete |throw |throws |throw\\{|throws\\{)";
	// Expression for checking the relational operators
	String relation_reg = "\\b\\w\\s*(==| == |!=| != |>=| >= |<=| <= |>| > |<| < )\\s*\\w";
	// Expression for checking the Arithmetic operators
	String arithmetic_reg = "\\b\\w\\s*(\\++| \\+\\+ |\\-\\-| \\-\\- |\\*| \\* |\\/| \\/ |\\%| \\% |\\+| \\+ |\\-| \\-)\\s*\\w";
	// Expression for checking the Logical operators
	String logical_reg = "\\b(&&| \\&& |\\|\\|| \\|\\| |!| ! )";
	// Expression for checking the Bitwise operators
	String bitwise_reg = "\\b\\w\\s*(\\^| \\^ |\\|| \\| |\\~| \\~ |\\<\\<\\<| <<< |\\>\\>\\>| >>> |\\>\\>| \\>\\> |\\<\\<| \\<\\< )\\s*\\w";
	// Expression for checking the Miscellaneous operators
	String mic_reg = "\\b\\w\\s*(\\,| \\, |\\-\\>| \\-\\> |\\.| \\. |\\:\\:| \\:\\: )\\s*\\w";
	// Expression for checking the Assignment operators
	String ass_reg = "\\b\\w\\s*(\\>\\>\\>\\=| \\>\\>\\>\\= |\\<\\<\\=| \\<\\<\\= |\\>\\>\\=| \\>\\>\\= |\\^\\=| \\^\\= |\\|\\=| \\|\\= |\\&\\=| \\&\\= |\\%\\=| \\%\\= |\\/\\=| \\/\\= |\\*\\=| \\*\\= |\\-\\=| \\-\\= |\\+\\=| \\+\\= |\\=| \\= )\\s*\\w";
	// Expression for checking the Manipulators operators
	String man_reg = "((endl)\\b|(\"\\\\n\"))";
	// Express for checking the String
	String str_reg ="\\\"(.*?)\\\"";

	public Cs_c(ArrayList<String> lines) {
		this.lines = lines;
		CsUnit = new ArrayList<Integer>(lines.size());
		token = new ArrayList<String>(lines.size());
	}

	

	// this method will count the keywords in the code
	public int keyword_count(String line,int no) {

		Pattern pattern = Pattern.compile(keyword_regx);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		String tokens="";
		while(matcher.find()) {
			if(tokens.matches(""))
				tokens+=matcher.group();
			else
				tokens+=","+matcher.group();
			if(matcher.group().matches("new") || matcher.group().matches("delete") || matcher.group().matches("throw") || matcher.group().matches("throws") || matcher.group().matches("&"))
				count += 2;
			else
				count++;
		}
		token.add(tokens);
		
		return count;
	}

	public int special_count(String line) {

		Pattern pattern = Pattern.compile(special_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}

	public int relation_count(String line) {

		Pattern pattern = Pattern.compile(relation_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}

	public int arithmatic_count(String line) {

		Pattern pattern = Pattern.compile(arithmetic_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}

	public int logical_count(String line) {

		Pattern pattern = Pattern.compile(logical_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}

	public int bitwise_count(String line) {

		Pattern pattern = Pattern.compile(bitwise_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}

	public int mic_count(String line) {

		Pattern pattern = Pattern.compile(mic_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}

	public int ass_count(String line) {

		Pattern pattern = Pattern.compile(ass_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}

	public int man_count(String line) {

		Pattern pattern = Pattern.compile(man_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}
	public int str_count(String line) {

		Pattern pattern = Pattern.compile(str_reg);
		Matcher matcher = pattern.matcher(line);

		int count = 0;
		while (matcher.find()) {
			count++;

		}

		return count;
	}


	public void addtoArray() {
		for (int i = 0; i < lines.size(); i++) {
			int keyword_count = keyword_count(lines.get(i),i);
			CsUnit.add(keyword_count);
		}
	}

	public ArrayList<Integer> getCs() {
		addtoArray();
		return CsUnit;
	}

	// get total cs
	public int getTotalCs() {
		int total = 0;

		for (int i = 0; i < CsUnit.size(); i++) {
			total += CsUnit.get(i);
		}

		return total;
	}
	public void Print_Token() 
	{
		for (int i = 0; i < token.size(); i++) {
			System.out.println(token.get(i));
		}		
	}
}
