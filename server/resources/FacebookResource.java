package gossapp.server.resources;



import gossapp.shared.domain.facebook.FacebookPhoto;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class FacebookResource {
<<<<<<< HEAD
	private String uri = "https://graph.facebook.com/v2.0/me/photos?type=uploaded";
=======
	private String uri = "https://graph.facebook.com/me/friends";
	private String uriShare = "https://graph.facebook.com/v2.0/me/feed";
	private String uriPhoto = "https://graph.facebook.com/v2.0/me/photos?fields=id,name,images,likes,comments&type=uploaded&limit=200";
>>>>>>> 1214a28a1eb712da0bca4182061451170376431f
	private String access_token = null;
	
	
	public FacebookResource(String access_token) {
		this.access_token = access_token;
	}
		
	
	public void postContent(String content){
		ClientResource cr = null;
		
		try{
			cr = new ClientResource (uriShare+"?access_token="+access_token+"&message="+content);
			cr.post(content);
		}catch (ResourceException re) {
			System.err.println("Error when retrieving friends: " + cr.getResponse().getStatus());
			System.err.println(uri + "?access_token" + access_token);
		}
	}

	public FacebookPhoto getPhotos() {
		ClientResource cr = null;
		FacebookPhoto photos = null;
		
		try{
			cr = new ClientResource(uriPhoto + "&access_token=" + access_token);
			photos = cr.get(FacebookPhoto.class);
		}catch (ResourceException re){
			System.err.println("Error when retrieving photos: " + cr.getResponse().getStatus());
			System.err.println(uri + "?access_token" + access_token);
		}
		
		return photos;
	}
	
	
}
