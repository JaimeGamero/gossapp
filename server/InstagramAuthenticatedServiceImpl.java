package gossapp.server;

import gossapp.client.services.InstagramAuthenticatedService;
import gossapp.server.resources.InstaFeedResource;
import gossapp.server.resources.InstaInfoResource;
import gossapp.shared.domain.instaFeed.InstaFeed;
import gossapp.shared.domain.instaInfo.InstaInfo;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class InstagramAuthenticatedServiceImpl extends RemoteServiceServlet
implements InstagramAuthenticatedService{

	@Override
	public InstaFeed getFeed(String access_token)
			throws IllegalArgumentException {
		InstaFeedResource ifr = new InstaFeedResource(access_token);
		return ifr.getMyFeed();
	}

	@Override
	public InstaInfo getInfo(String access_token)
			throws IllegalArgumentException {
		InstaInfoResource iir = new InstaInfoResource(access_token);
		return iir.getMyInfo();
	}
	
	

}
