package gossapp.server;

import gossapp.client.services.TwitterAuthenticatedService;
import gossapp.server.resources.TwitterResource;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;




import twitter4j.Status;

public class TwitterAuthenticatedServiceImpl extends RemoteServiceServlet implements TwitterAuthenticatedService{

	private static final long serialVersionUID = 1262498418355584663L;
	private static TwitterResource rs;

	public Map<String, String> getTimeLine(Integer numTweets) {
		Map<String, String> tl = new HashMap<String,String>();
		for(Status stat : rs.getTimeLine(numTweets)){
			tl.put(stat.getUser().getName(), stat.getText());
		}
		return tl;
	}

	public Map<String, String> getTimeLine() {
		Map<String, String> tl = new HashMap<String,String>();
		for(Status stat : rs.getTimeLine()){
			tl.put(stat.getUser().getName(), stat.getText());
		}
		return tl;
	}

	@Override
	public void inicioSesion() {
		rs = new TwitterResource();
		rs.inicioSesion();
	}

}
