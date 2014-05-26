package gossapp.server;


import gossapp.client.services.FacebookAuthenticatedService;
import gossapp.server.resources.FacebookResource;
import gossapp.shared.domain.facebook.FacebookPhoto;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class FacebookAuthenticatedServiceImpl extends RemoteServiceServlet
		implements FacebookAuthenticatedService {
	public void shareContent(String access_token, String content)
			throws IllegalArgumentException {
		FacebookResource fbr = new FacebookResource(access_token);
		fbr.postContent(content);
	}

	@Override
	public FacebookPhoto findPhoto(String access_token)
			throws IllegalArgumentException {
		FacebookResource fbp = new FacebookResource(access_token);
		return fbp.getPhotos();
	}


}
