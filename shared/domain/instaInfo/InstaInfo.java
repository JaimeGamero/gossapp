package gossapp.shared.domain.instaInfo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class InstaInfo implements Serializable{
	
	private InstaData data;
	
	public InstaData getData(){
		return data;
	}

}
