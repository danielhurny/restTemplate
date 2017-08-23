package main.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import main.DTO.CommentDTO;

@Component
public class CommentService implements Service {
	RestTemplate restTemplate = new RestTemplate();

	final String url = "http://jsonplaceholder.typicode.com/comments/";

	public String allComments() {

		String response = restTemplate.getForObject(url, String.class);
		return response;

	}

	public String oneComment(int number) {

		return restTemplate.getForObject(url + number, String.class);

	}

	public CommentDTO oneDto(int number) {
		return restTemplate.getForObject(url + number, CommentDTO.class);
		
	}

	public ResponseEntity<CommentDTO> oneToResponse(int number) {
		
		ResponseEntity<CommentDTO> response = restTemplate.getForEntity(url + number, CommentDTO.class);
		 HttpHeaders header = response.getHeaders();
		 
		 header.add("ahoj", "mozno");
		 System.out.println(header);
		
//		System.out.println("Telo: "+ response.getBody());
//		System.out.println(response);
		
		return response;
	}

	public List<CommentDTO> listDto() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "password");
		params.add("client_id",	"3MVG94DzwlYDSHJi7KdpL.OxTLwtx4e5fSNppIGM");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		ResponseEntity<List<CommentDTO>> response = restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<CommentDTO>>() {});
		List<CommentDTO> comments = response.getBody();
		return comments;
	}
	
	public ResponseEntity<List<CommentDTO>> entityDto() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "password");
		params.add("client_id",	"3MVG94DzwlYDSHJi7KdpL.OxTLwtx4e5fSNppIGM");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		ResponseEntity<List<CommentDTO>> response = restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<CommentDTO>>() {});

		System.out.println(response);
		return response;
	}
	
//	public ResponseEntity<CommentDTO> test(int number) {
//		ResponseEntity<CommentDTO> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/comments/2", CommentDTO.class);
//		System.out.println(response);
//		return response;
//	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
