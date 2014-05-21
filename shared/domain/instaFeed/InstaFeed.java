package gossapp.shared.domain.instaFeed;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class InstaFeed implements Serializable{
	
	private List<FeedData> data;

	public List<FeedData> getData() {
		return data;
	}

	public void setData(List<FeedData> data) {
		this.data = data;
	}

}
