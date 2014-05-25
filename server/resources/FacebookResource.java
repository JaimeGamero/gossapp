package gossapp.server.resources;

import gossapp.shared.domain.facebook.FaceFeed;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class FacebookResource {
	private String uri = "https://graph.facebook.com/v2.0/me/photos?type=uploaded";
	private String access_token = null;
	
	
	public FacebookResource(String access_token) {
		this.access_token = access_token;
	}
		
	/**
	 * 
	 * @return FaceFeed
	 */
	public FaceFeed getFeed() {
		
		ClientResource cr = null;
		FaceFeed list = null;
		
		try {
			cr = new ClientResource(uri + "?access_token=" + access_token);
			list = cr.get(FaceFeed.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving feed: " + cr.getResponse().getStatus());
			System.err.println(uri + "?access_token" + access_token);
		}
		
		return list;

	}
}
