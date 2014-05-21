package gossapp.server.resources;

import gossapp.shared.domain.facebook.FacebookFriends;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


public class FacebookFriendsResource {

	private String uri = "https://graph.facebook.com/me/friends";
	private String access_token = null;
	
	
	public FacebookFriendsResource(String access_token) {
		this.access_token = access_token;
	}
		
	/**
	 * 
	 * @return FacebookFriends
	 */
	public FacebookFriends getFriends() {
		
		ClientResource cr = null;
		FacebookFriends list = null;
		
		try {
			cr = new ClientResource(uri + "?access_token=" + access_token);
			list = cr.get(FacebookFriends.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving friends: " + cr.getResponse().getStatus());
			System.err.println(uri + "?access_token" + access_token);
		}
		
		return list;

	}
}
