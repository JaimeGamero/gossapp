package gossapp.server;


import gossapp.client.services.FacebookAuthenticatedService;
import gossapp.server.resources.FacebookFriendsResource;
import gossapp.server.resources.FacebookResource;
import gossapp.shared.domain.facebook.FaceFeed;
import gossapp.shared.domain.facebook.FacebookFriends;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class FacebookAuthenticatedServiceImpl extends RemoteServiceServlet
		implements FacebookAuthenticatedService {

	@Override
	public FacebookFriends findFriends(String access_token)
			throws IllegalArgumentException {
		FacebookFriendsResource fbr = new FacebookFriendsResource(access_token);
		return fbr.getFriends();
	}

	@Override
	public FaceFeed feedFacebook(String access_token)
			throws IllegalArgumentException {
		FacebookResource fb = new FacebookResource(access_token);
		return fb.getFeed();
	}

}
