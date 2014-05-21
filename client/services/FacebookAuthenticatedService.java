package gossapp.client.services;

import gossapp.shared.domain.facebook.FaceFeed;
import gossapp.shared.domain.facebook.FacebookFriends;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("facebook")
public interface FacebookAuthenticatedService extends RemoteService {
	
	FacebookFriends findFriends(String access_token) throws IllegalArgumentException;
	FaceFeed feedFacebook (String access_token) throws IllegalArgumentException;

}
