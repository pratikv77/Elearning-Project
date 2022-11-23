package study.Pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ZoomDetailsPojo {
	
	
	@Value("${zoom.api.key}")
	private String apiKey;
	
	@Value("${zoom.api.secret}")
	private String apiSecret;

	public ZoomDetailsPojo() {
		super();
		
	}

	public String getApiKey() {
		return apiKey;
	}
	
	public String getApiSecret() {
		return apiSecret;
	}

}
