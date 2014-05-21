package gossapp.server.resources;

import org.restlet.resource.ClientResource;




import gossapp.shared.domain.instaFeed.InstaFeed;

public class InstaFeedResource {
	
	private String uri = "https://api.instagram.com/v1/users/self/media/recent/";
	private String access_token = null;
	
	public InstaFeedResource(String access_token){
		this.access_token = access_token;
	}
	
	public InstaFeed getMyFeed(){
		
		ClientResource cr = null;
		InstaFeed feed = null;
		
		cr = new ClientResource(uri+"?access_token="+access_token);
		feed = cr.get(InstaFeed.class);
		return feed;
	}

}
