package technology.digital.saksham.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressLint("SimpleDateFormat")
public class AppUtil {
	public static void setListViewHeightBasedOnItems(ListView listView) {

		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter != null) {

			int numberOfItems = listAdapter.getCount();

			// Get total height of all items.
			int totalItemsHeight = 0;
			for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
				View item = listAdapter.getView(itemPos, null, listView);
				item.measure(0, 0);
				totalItemsHeight += item.getMeasuredHeight();
			}

			// Get total height of all item dividers.
			int totalDividersHeight = listView.getDividerHeight() *
					(numberOfItems - 1);

			// Set list height.
			ViewGroup.LayoutParams params = listView.getLayoutParams();
			params.height = totalItemsHeight + totalDividersHeight;
			listView.setLayoutParams(params);
			listView.requestLayout();
		}
	       /* return true;

	    } else {
	        return false;
	    }*/

	}

	public static String printKeyHash(Activity context) {
		PackageInfo packageInfo;
		String key = null;
		try {
			//getting application package name, as defined in manifest
			String packageName = context.getApplicationContext().getPackageName();

			//Retriving package info
			packageInfo = context.getPackageManager().getPackageInfo(packageName,
					PackageManager.GET_SIGNATURES);

			Log.e("Package Name=", context.getApplicationContext().getPackageName());

			for (Signature signature : packageInfo.signatures) {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				key = new String(Base64.encode(md.digest(), 0));

				// String key = new String(Base64.encodeBytes(md.digest()));
				Log.e("Key Hash=", key);
			}
		} catch (NameNotFoundException e1) {
			Log.e("Name not found", e1.toString());
		} catch (NoSuchAlgorithmException e) {
			Log.e("No such an algorithm", e.toString());
		} catch (Exception e) {
			Log.e("Exception", e.toString());
		}

		return key;
	}

	public static String getDeviceTokenId(Context context) {
		return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
	}

	public static String getDeviceName() {
		String manufacturer = Build.MANUFACTURER;
		Log.e("Manufacture", manufacturer);
		String model = Build.MODEL;
		return manufacturer;
	}

	/**
	 * THIS MEHTOD RETURN EITHER DEVICE IS ANDROID OR I-PHONE
	 *
	 * @return
	 */
	public static String getDevice() {
		return "ANDROID";
	}

	/**
	 * THIS METHOD RETURNS WHETHER DEVICE IS MOBILE OR TAB
	 *
	 * @return
	 */
	public static String getDeviceSizeType(Context context) {
		if ((context.getResources().getConfiguration().screenLayout
				& Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE)
			return "TAB";
		else
			return "MOBILE";

		// DisplayMetrics metrics = new DisplayMetrics();
		//
		// getWindowManager().getDefaultDisplay().getMetrics(metrics);
		//
		// float yInches = metrics.heightPixels / metrics.ydpi;
		// float xInches = metrics.widthPixels / metrics.xdpi;
		// double diagonalInches = Math.sqrt(xInches * xInches + yInches *
		// yInches);
		// if (diagonalInches >= 6.5) {
		// // 6.5inch device or bigger
		// } else {
		// // smaller device
		// }
	}

	// /**
	// * GET THE DEVICE CURRENT LOCATION
	// *
	// * @return
	// */
	// public static ArrayList<String> getDeviceLocation(Context context) {
	// ArrayList<String> locationList = new ArrayList<>();
	// AppLocationService locationService = new AppLocationService(context);
	// Location location =
	// locationService.getLocation(LocationManager.GPS_PROVIDER);
	//
	// if (location != null) {
	// // Toast.makeText(context, "long= " + location.getLongitude() +
	// // "\n Lat = " + location.getLatitude(), Toast.LENGTH_SHORT).show();
	// locationList.add(String.valueOf(location.getLatitude()));
	// locationList.add(String.valueOf(location.getLongitude()));
	// return locationList;
	// }
	// return locationList;
	// }

	/**
	 * THIS METHOD CONVERT INPUT STREAM TO STRING
	 *
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String convertStringFromInputStream(InputStream is) throws IOException {
		try {
			byte[] bytes = new byte[1024];

			StringBuilder x = new StringBuilder();

			int numRead = 0;
			while ((numRead = is.read(bytes)) >= 0) {
				x.append(new String(bytes, 0, numRead));
			}

			return x.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Checking for all possible internet providers, return true if data
	 * connection is available else false
	 **/
	public static boolean isConnectedToInternet(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++)
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}

		}
		return false;
	}

	public static void showCustomDialog(final Context context, final String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);

		builder.setMessage(msg).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();

			}
		}).show();
	}

	// public static void buildAlertMessageNoGps(final Context context) {
	// final AlertDialog.Builder builder = new AlertDialog.Builder(context);
	// builder.setMessage("Your GPS seems to be disabled, do you want to enable
	// it?").setCancelable(false)
	// .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	// public void onClick(@SuppressWarnings("unused") final DialogInterface
	// dialog, @SuppressWarnings("unused") final int id) {
	// context.startActivity(new
	// Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
	// }
	// }).setNegativeButton("No", new DialogInterface.OnClickListener() {
	// public void onClick(final DialogInterface dialog,
	// @SuppressWarnings("unused") final int id) {
	// dialog.cancel();
	// }
	// });
	// final AlertDialog alert = builder.create();
	// alert.show();
	// }
	public static void showSettingsAlert(final Activity activity, String message) {

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
		alertDialog.setTitle("Alert");

		alertDialog.setMessage(message);
		// On pressing Settings button
		alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
						Uri.fromParts("package", activity.getPackageName(), null));

				activity.startActivityForResult(intent, C.REQUEST_SETTINGS);
			}
		});
		// on pressing cancel button
		alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		alertDialog.show();
	}

	public static void showExitAlert(final Activity activity, String message) {

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
		alertDialog.setTitle("Alert");

		alertDialog.setMessage(message);
		// On pressing Settings button
		alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {

				activity.finishAffinity();

			}
		});
		// on pressing cancel button
		alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		alertDialog.show();
	}

	@SuppressLint("SimpleDateFormat")
	public static String changetimeto24Hours(String dateString) {
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		Date date;
		try {
			date = parseFormat.parse(dateString);
			System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));

			return displayFormat.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static String convertVedioInTobase64String(String uripath) {

		FileInputStream objFileIS = null;
		try {
			System.out.println("file = >>>> <<<<<" + uripath);
			objFileIS = new FileInputStream(uripath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ByteArrayOutputStream objByteArrayOS = new ByteArrayOutputStream();
		byte[] byteBufferString = new byte[1024];
		try {
			for (int readNum; (readNum = objFileIS.read(byteBufferString)) != -1; ) {
				objByteArrayOS.write(byteBufferString, 0, readNum);
				System.out.println("read " + readNum + " bytes,");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String videodata = Base64.encodeToString(objByteArrayOS.toByteArray(), Base64.DEFAULT);
		Log.d("VideoData**>  ", videodata);
		return videodata;
	}

	public static String getCurrentDayOfday(int year, int month, int day) {
		Calendar calendar = new GregorianCalendar(year, month, day); // Note that Month value is 0-based. e.g., 0 for January.
		int result = calendar.get(Calendar.DAY_OF_WEEK);
		String lDayOfWeak = "";
		switch (result) {
			case Calendar.MONDAY:
				lDayOfWeak = "Mon";
				break;
			case Calendar.TUESDAY:
				lDayOfWeak = "Tue";
				break;
			case Calendar.WEDNESDAY:
				lDayOfWeak = "Wed";
				break;
			case Calendar.THURSDAY:
				lDayOfWeak = "Thu";
				break;
			case Calendar.FRIDAY:
				lDayOfWeak = "Fri";
				break;
			case Calendar.SATURDAY:
				lDayOfWeak = "Sat";
				break;
			case Calendar.SUNDAY:
				lDayOfWeak = "Sun";
				break;

		}
		return lDayOfWeak;
	}

	/**
	 * Convert image to base64 string
	 *
	 * @param lPtProfileImage
	 * @return
	 */
	public static String convertImageToBaseCode(ImageView lPtProfileImage) {
		String imageString;
		lPtProfileImage.buildDrawingCache();
		Bitmap bmappg = lPtProfileImage.getDrawingCache();
		ByteArrayOutputStream bospg = new ByteArrayOutputStream();
		bmappg.compress(CompressFormat.PNG, 100, bospg);
		byte[] bb = bospg.toByteArray();
		imageString = Base64.encodeToString(bb, Base64.DEFAULT);
		return imageString;
	}

	/**
	 * Convert image to base64 string
	 *
	 * @param lPtProfileImage
	 * @return
	 */
	public static String convertImageToBaseCode(Bitmap lPtProfileImage) {
		String imageString;
		ByteArrayOutputStream bospg = new ByteArrayOutputStream();
		lPtProfileImage.compress(CompressFormat.PNG, 50, bospg);
		byte[] bb = bospg.toByteArray();
		imageString = Base64.encodeToString(bb, Base64.DEFAULT);
		return imageString;
	}

	/**
	 * Convert a YYYY-MM-DD date format to DD-MM-YYYY
	 *
	 * @param dateInYYYY_MM_DD
	 * @return
	 */
	public static String convertDateToDDMMYYY(String dateInYYYY_MM_DD) {
		try {
			SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");

			Date date = sdfSource.parse(dateInYYYY_MM_DD);

			SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");

			dateInYYYY_MM_DD = sdfDestination.format(date);

		} catch (ParseException pe) {
			System.out.println("Parse Exception : " + pe);
		}
		return dateInYYYY_MM_DD;
	}

	/**
	 * Convert a DD-MM-YYYY date format to YYYY-MM-DD
	 *
	 * @param dateInDD_MM_YYYY
	 * @return
	 */
	public static String convertDateToYYYYMMDD(String dateInDD_MM_YYYY) {
		try {
			SimpleDateFormat sdfSource = new SimpleDateFormat("dd-MM-yyyy");

			Date date = sdfSource.parse(dateInDD_MM_YYYY);

			SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");

			dateInDD_MM_YYYY = sdfDestination.format(date);

		} catch (ParseException pe) {
			System.out.println("Parse Exception : " + pe);
		}
		return dateInDD_MM_YYYY;
	}

	public static int getWallOfFrameColorStarsOnBasisOfThemdId(int themeId) {
		switch (themeId) {
			case 0:
				// return R.drawable.star_theme_0;
				// case 1:
				// return R.drawable.star_theme_1;
				// case 2:
				// return R.drawable.star_theme_2;
				// case 3:
				// return R.drawable.star_theme_3;
				// case 4:
				// return R.drawable.star_theme_4;
				// case 5:
				// return R.drawable.star_theme_5;
				// case 6:
				// return R.drawable.star_theme_6;
				// case 7:
				// return R.drawable.star_theme_7;
				// case 8:
				// return R.drawable.star_theme_8;
				// case 9:
				// return R.drawable.star_theme_9;
				// case 10:
				// return R.drawable.star_theme_10;
				// case 11:
				// return R.drawable.star_theme_11;
				// case 12:
				// return R.drawable.star_theme_12;
			default:
				return 0;
		}
	}

	public static int getWallOfFrameFadeStarsOnBasisOfThemdId(int themeId) {
		switch (themeId) {
			case 0:
				// return R.drawable.star_fade_00;
				// case 1:
				// return R.drawable.star_fade01;
				// case 2:
				// return R.drawable.star_fade_02;
				// case 3:
				// return R.drawable.star_fade_03;
				// case 4:
				// return R.drawable.star_fade_04;
				// case 5:
				// return R.drawable.star_fade_05;
				// case 6:
				// return R.drawable.star_fade_06;
				// case 7:
				// return R.drawable.star_fade_07;
				// case 8:
				// return R.drawable.star_fade_08;
				// case 9:
				// return R.drawable.star_fade_09;
				// case 10:
				// return R.drawable.star_fade_10;
				// case 11:
				// return R.drawable.star_fade_11;
				// case 12:
				// return R.drawable.star_fade_12;
			default:
				return 0;
		}
	}
}
