package gossapp.client.services;





import gossapp.shared.domain.facebook.FacebookPhoto;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FacebookAuthenticatedServiceAsync {

	void shareContent(String access_token, String content, AsyncCallback<Void> callback);
	
	void findPhoto(String access_token, AsyncCallback<FacebookPhoto> callback);


}
