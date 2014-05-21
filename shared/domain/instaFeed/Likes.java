package gossapp.shared.domain.instaFeed;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Likes implements Serializable{
	
	private Integer count;
	
	public Integer getCount(){
		return count;
	}

}
