package technology.digital.saksham.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPref {

	private static SharedPref mSharedPref;
	private static SharedPreferences mPreferences;
	private Editor editor;

	private SharedPref(Context context) {
		mPreferences = context.getSharedPreferences(C.APP_PREF, Context.MODE_PRIVATE);
		editor = mPreferences.edit();
	}

	public static final SharedPref getInstance(Context context) {
		if (mSharedPref == null)
			mSharedPref = new SharedPref(context);
		return mSharedPref;
	}


	public void clearPreference() {
		mPreferences.edit().clear().commit();
	}


	public String getUserId() {
		return mPreferences.getString(C.USERID, C.DEFAULT_USERID);
	}

	public void setUserIdInPref(String userId) {

		editor.putString(C.USERID, userId).commit();
	}

	public String getCurruntTitle() {
		return mPreferences.getString(C.TITLE, "");
	}

	public void setCurruntTitle(String title) {

		editor.putString(C.TITLE, title).commit();
	}

//	public void writePrentEmailInPref(String email) {
//		editor.putString(C.PAREN_EMAIL, email).commit();
//
//	}
//
//	public void writeUserIdWhenLoginWithfacebook(String userId) {
//		editor.putString(C.USERID, userId).commit();
//
//	}
//
//	public void writePrentFacebookIDAndParentFaceBookName(String fbId, String userName) {
//		editor.putString(C.PARENT_FACEBOOK_ID, fbId).commit();
//		editor.putString(C.PARENT_FACEBOOK_NAME, userName).commit();
//	}


	public void wirteUserMobilenumber(String mobile) {
		editor.putString(C.USER_MOBILE, mobile).commit();
	}

	public String getUserMobile() {
		return mPreferences.getString(C.USER_MOBILE, "");
	}

	public void wirteUserAddress(String address) {
		editor.putString(C.USER_ADDRESS, address).commit();
	}

	public String getUserAddress() {
		return mPreferences.getString(C.USER_ADDRESS, "");
	}

	public void wirteUserName(String name) {
		editor.putString(C.USER_NAME, name).commit();
	}

	public String getUserName() {
		return mPreferences.getString(C.USER_NAME, "");
	}

	public void wirteUserPassword(String password) {
		editor.putString(C.USER_PASSWORD, password).commit();
	}

	public String getUserPassword() {
		return mPreferences.getString(C.USER_PASSWORD, "");
	}

	public void wirteUserEmail(String email) {

		editor.putString(C.USER_EMAIL, email).commit();
	}

	public String getUserEmail() {
		return mPreferences.getString(C.USER_EMAIL, "");
	}

	public void wirteUserType(String userType) {
		editor.putString(C.USER_TYPE, userType).commit();
	}

	public String getUserType() {
		return mPreferences.getString(C.USER_TYPE, "");
	}

	public void setGcmId(String gcmid) {
		editor.putString(C.GCM_REG_ID, gcmid).commit();
	}

	public String getGcmID() {
		return mPreferences.getString(C.GCM_REG_ID, "");
	}


	public String getUserFirstname() {
		return mPreferences.getString(C.USER_FIRSTNAME, "");
	}

	public void wirteUserFirstname(String userType) {
		editor.putString(C.USER_FIRSTNAME, userType).commit();
	}

	public String getUserLastname() {
		return mPreferences.getString(C.USER_LASTNAME, "");
	}

	public void wirteUserLastname(String userType) {
		editor.putString(C.USER_LASTNAME, userType).commit();
	}

	public String getUserFaceBookId() {
		return mPreferences.getString(C.USER_FaceBookId, "");
	}

	public void wirteUserFaceBookId(String userType) {
		editor.putString(C.USER_FaceBookId, userType).commit();
	}


	public String getUserProfilepicture() {
		return mPreferences.getString(C.USER_PROFILEPICTURE, "");
	}

	public void wirteUserProfilepicture(String userType) {
		editor.putString(C.USER_PROFILEPICTURE, userType).commit();
	}

	public void setLoginState(boolean login) {
		editor.putBoolean(C.IS_LOGIN, login).commit();
	}

	public boolean isLogin() {
		return mPreferences.getBoolean(C.IS_LOGIN, false);
	}


	public void setLoginStatehint(boolean login) {
		editor.putBoolean(C.IS_LOGINhint, login).commit();
	}

	public boolean isLoginhint() {
		return mPreferences.getBoolean(C.IS_LOGINhint, false);
	}

	public void setSelctedProfileImage(String imageString) {
		editor.putString(C.SELECTED_IMAGE, imageString).commit();
	}

	public String getSelectedImage() {
		return mPreferences.getString(C.SELECTED_IMAGE, "");
	}

	public String getDeviceSizeType() {
		return mPreferences.getString(C.DEVICE_SIZE_TYPE, "");

	}

	public void setDeviceSizeType(String deviceSizeType) {
		editor.putString(C.DEVICE_SIZE_TYPE, deviceSizeType).commit();
	}

	public String getDeviceVersion() {
		return mPreferences.getString(C.DEVICE_VERSION, "");
	}

	public void setDeviceVersion(String deviceVersion) {
		editor.putString(C.DEVICE_VERSION, deviceVersion).commit();
	}

	public String getcoursename() {
		return mPreferences.getString(C.COURSE_NAME, "");
	}

	public void writecoursename(String name) {
		editor.putString(C.COURSE_NAME, name).commit();
	}


}
