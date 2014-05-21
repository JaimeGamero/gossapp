package gossapp.client.services;

import gossapp.shared.domain.instaFeed.InstaFeed;
import gossapp.shared.domain.instaInfo.InstaInfo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("instagram")
public interface InstagramAuthenticatedService extends RemoteService {
	
	InstaFeed getFeed(String access_token) throws IllegalArgumentException;
	
	InstaInfo getInfo(String accesss_token) throws IllegalArgumentException;

}
