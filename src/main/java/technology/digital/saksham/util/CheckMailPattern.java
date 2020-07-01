package technology.digital.saksham.util;

import android.os.PatternMatcher;
import android.util.Log;

import java.util.regex.Pattern;

public class CheckMailPattern {

	static String emailcheck = "";
	static String phonenumber = "";
	PatternMatcher pattern;

	public static boolean isCorerectEmailPattern(String email) {

		emailcheck = email;

		String emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
				+ "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
				+ "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";

		Pattern emailMatch = Pattern.compile(emailPattern);

		Log.v("mail check", emailMatch.matcher(emailcheck).matches() + "");

		return emailMatch.matcher(emailcheck).matches();
	}

	public static boolean isValidPhonenumber(String mob) {

		phonenumber = mob;

		String phonePattern = "\\d{3}-\\d{7}";

		Pattern emailMatch = Pattern.compile(phonePattern);

		Log.v("mail check", emailMatch.matcher(phonenumber).matches() + "");

		return emailMatch.matcher(phonenumber).matches();
	}

	public static boolean isPasswordAlphaNumeric(String password) {
		if (!password.matches(".*[A-Z].*"))
			return false;

		if (!password.matches(".*[a-z].*"))
			return false;

		if (!password.matches(".*\\d.*"))
			return false;

		return password.matches(".*[~!@#&].*");

	}

}
