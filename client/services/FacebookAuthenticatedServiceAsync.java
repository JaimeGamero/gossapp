package gossapp.client.services;

import gossapp.shared.domain.facebook.FaceFeed;
import gossapp.shared.domain.facebook.FacebookFriends;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FacebookAuthenticatedServiceAsync {

	void findFriends(String access_token,
			AsyncCallback<FacebookFriends> callback);
	
	void feedFacebook(String access_token, AsyncCallback<FaceFeed> callback);

}
