package br.com.condesales;

import android.app.Activity;
import android.content.SharedPreferences;
import br.com.condesales.constants.FoursquareConstants;
import br.com.condesales.criterias.VenuesCriteria;
import br.com.condesales.listeners.AccessTokenRequestListener;
import br.com.condesales.listeners.FoursquareVenuesResquestListener;
import br.com.condesales.listeners.UserInfoRequestListener;
import br.com.condesales.tasks.FoursquareVenuesRequest;
import br.com.condesales.tasks.SelfInfoRequest;

/**
 * Class to handle methods used to perform requests to FoursquareAPI and
 * respond ASYNChronously.
 * 
 * @author Felipe Conde <condesales@gmail.com>
 * 
 */
public class EasyFoursquareAsync {

	private Activity mActivity;
	private FoursquareDialog mDialog;
	private String mAccessToken = "";

	public EasyFoursquareAsync(Activity activity) {
		mActivity = activity;
	}

	/**
	 * Requests the access to API
	 */
	public void requestAccess(AccessTokenRequestListener listener) {
		if (!hasAccessToken()) {
			loginDialog(listener);
		} else {
			listener.onAccessGrant(getAccessToken());
		}
	}

	/**
	 * Requests logged user information asynchronously.
	 * 
	 * @param listener
	 *            As the request is asynchronous, listener used to retrieve the
	 *            User object, containing the information.
	 */
	public void getUserInfo(UserInfoRequestListener listener) {
		SelfInfoRequest request = new SelfInfoRequest(mActivity, listener);
		request.execute(mAccessToken);
	}

	/**
	 * Requests the nearby Venues.
	 * 
	 * @param criteria
	 *            The criteria to your search request
	 * @param listener
	 *            As the request is asynchronous, listener used to retrieve the
	 *            User object, containing the information.
	 */
	public void getVenuesNearby(FoursquareVenuesResquestListener listener,
			VenuesCriteria criteria) {
		FoursquareVenuesRequest request = new FoursquareVenuesRequest(
				mActivity, listener, criteria);
		request.execute(mAccessToken);
	}

	private boolean hasAccessToken() {
		String token = getAccessToken();
		return !token.equals("");
	}

	private String getAccessToken() {
		if (mAccessToken.equals("")) {
			SharedPreferences settings = mActivity.getSharedPreferences(
					FoursquareConstants.SHARED_PREF_FILE, 0);
			mAccessToken = settings.getString(FoursquareConstants.ACCESS_TOKEN,
					"");
		}
		return mAccessToken;
	}

	/**
	 * Requests the Foursquare login though a dialog.
	 */
	private void loginDialog(AccessTokenRequestListener listener) {
		String url = "https://foursquare.com/oauth2/authenticate"
				+ "?client_id=" + FoursquareConstants.CLIENT_ID
				+ "&response_type=code" + "&redirect_uri="
				+ FoursquareConstants.CALLBACK_URL;

		mDialog = new FoursquareDialog(mActivity, url, listener);
		mDialog.show();
	}

}
