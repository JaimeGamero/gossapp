package gossapp.shared.domain.facebook;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Cursors implements Serializable{
   	private String after;
   	private String before;

 	public String getAfter(){
		return this.after;
	}
	public void setAfter(String after){
		this.after = after;
	}
 	public String getBefore(){
		return this.before;
	}
	public void setBefore(String before){
		this.before = before;
	}
}