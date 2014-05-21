package gossapp.client.services;
import gossapp.shared.domain.instaFeed.InstaFeed;
import gossapp.shared.domain.instaInfo.InstaInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InstagramAuthenticatedServiceAsync {
	
	void getFeed(String access_token, AsyncCallback<InstaFeed> callback);
	
	void getInfo(String access_token, AsyncCallback<InstaInfo> callback);

}
