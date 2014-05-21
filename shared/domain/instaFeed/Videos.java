package gossapp.shared.domain.instaFeed;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)

public class Videos implements Serializable{
	
	private Standard_resolution standard_resolution;
	
	public Standard_resolution getStandardResolution(){
		return standard_resolution;
	}

}
