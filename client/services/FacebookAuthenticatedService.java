package gossapp.client.services;


<<<<<<< HEAD

=======
>>>>>>> e0a1b3631478c4157433de7bbadf15f09813ded6
import gossapp.shared.domain.facebook.FacebookPhoto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("facebook")
public interface FacebookAuthenticatedService extends RemoteService {
	
	void shareContent(String access_token, String content) throws IllegalArgumentException; 
	
	FacebookPhoto findPhoto(String access_token) throws IllegalArgumentException;

}
