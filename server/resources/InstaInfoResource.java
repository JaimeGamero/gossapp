package gossapp.server.resources;

import gossapp.shared.domain.instaInfo.InstaInfo;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class InstaInfoResource {
	
	private String uri = "https://api.instagram.com/v1/users/self/";
	private String access_token = null;
	
	public InstaInfoResource(String access_token){
		this.access_token = access_token;
	}
	
	public InstaInfo getMyInfo(){
		
		ClientResource cr = null;
		InstaInfo info = null;
		
		cr = new ClientResource(uri+"?access_token="+access_token);
		info = cr.get(InstaInfo.class);
		
		return info;
	}
	
	public String getMyId(){
		
		ClientResource cr = null;
		String id = null;
		
		try{
			cr = new ClientResource(uri);
			id = cr.get(InstaInfo.class).getData().getId();
		}catch(ResourceException re){
			System.err.println("Error when retrieving your information: " + cr.getResponse().getStatus());
			System.err.println(uri);
		}
		
		return id;
	}

}
