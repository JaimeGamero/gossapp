package gossapp.shared.domain.facebook;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class FaceFeed implements Serializable{
	
	private List<FaceData> data;

	public List<FaceData> getData() {
		return data;
	}

	public void setData(List<FaceData> data) {
		this.data = data;
	}
}
