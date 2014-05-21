package gossapp.client.services;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TwitterAuthenticatedServiceAsync {

	public void inicioSesion(AsyncCallback<Void> callback);
	public void getTimeLine(Integer numTweets, AsyncCallback<Map<String, String>> callback);
	public void getTimeLine(AsyncCallback<Map<String, String>> callback);
}
