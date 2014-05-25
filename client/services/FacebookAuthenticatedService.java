package gossapp.client.services;


import gossapp.shared.domain.facebook.FacebookFriends;
import gossapp.shared.domain.facebook.FacebookPhoto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("facebook")
public interface FacebookAuthenticatedService extends RemoteService {
	
	void shareContent(String access_token, String content) throws IllegalArgumentException; 
	
	FacebookPhoto findPhoto(String access_token) throws IllegalArgumentException;

}
