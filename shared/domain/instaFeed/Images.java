package gossapp.shared.domain.instaFeed;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Images implements Serializable{
	
   	private Standard_resolution standard_resolution;
   	
 	public Standard_resolution getStandard_resolution(){
		return this.standard_resolution;
	}
	public void setStandard_resolution(Standard_resolution standard_resolution){
		this.standard_resolution = standard_resolution;
	}

}
