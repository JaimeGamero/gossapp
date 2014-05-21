package gossapp.shared.domain.facebook;

import java.io.Serializable;
import java.util.List;
import gossapp.shared.domain.facebookLikes.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Like implements Serializable{
	private List<Data> data;

	public List<Data> getData() {
		String s;
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
	
	

}
