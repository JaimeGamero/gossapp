package gossapp.client.services;


<<<<<<< HEAD


=======
>>>>>>> e0a1b3631478c4157433de7bbadf15f09813ded6

import gossapp.shared.domain.facebook.FacebookPhoto;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FacebookAuthenticatedServiceAsync {

	void shareContent(String access_token, String content, AsyncCallback<Void> callback);
	
	void findPhoto(String access_token, AsyncCallback<FacebookPhoto> callback);


}
