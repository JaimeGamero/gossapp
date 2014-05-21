package gossapp.server.resources;

import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterResource {

	private Twitter session;
	private Paging paging;

	public TwitterResource() {

		this.paging = new Paging();
	}

	public void inicioSesion() {
		 ConfigurationBuilder cb = new ConfigurationBuilder();
		 cb.setDebugEnabled(true)
		 .setOAuthConsumerKey("p2UnI7UjoKflAvDiE4K0MdiQF")
		 .setOAuthConsumerSecret("m4QB51uNd0OPwwvCwcMYUhN2itKsz3XBwVr2F31J9dEgQTWWui")
		 .setOAuthAccessToken("2362524919-bzGTIVTUh2nuJJl4CG7REkhreL2zeV2k40AChtr")
		 .setOAuthAccessTokenSecret("peJMM6gAaKtJsDAZYRJRpoV6DoOFEKsMHXOCW8loXYYh3");
		 TwitterFactory tf = new TwitterFactory(cb.build());
		 this.session = tf.getInstance();
	}

	public List<Status> getTimeLine(Integer numTweets) {
		List<Status> res = null;

		try {
			paging.setCount(numTweets);
			res = session.getHomeTimeline(paging);
		} catch (TwitterException e) {
			System.out.println("Error al obtener el Timeline: "
					+ e.getMessage());
		}

		return res;
	}

	public List<Status> getTimeLine() {
		List<Status> res = null;

		try {
			res = session.getHomeTimeline();
		} catch (TwitterException e) {
			System.out.println("Error al obtener el Timeline: "
					+ e.getMessage());
		}

		return res;
	}
}
