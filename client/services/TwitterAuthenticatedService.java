package gossapp.client.services;

import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("twitter")
public interface TwitterAuthenticatedService extends RemoteService{

	public void inicioSesion();
	public Map<String, String> getTimeLine(Integer numTweets);
	public Map<String, String> getTimeLine();
}
