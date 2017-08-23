package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import main.DTO.CommentDTO;
import main.service.Service;

@Controller
public class CommentController {

	@Autowired
	Service service;

	RestTemplate restTemplate = new RestTemplate();

	// @GetMapping("/allcomments")
	// public String allComments() {
	// return service.allComments();
	//
	// }
	//
	// @GetMapping("/onecomment/{id}")
	// public String oneComment(@PathVariable int id) {
	// return service.oneComment(id);
	// }
	//
	// @GetMapping("/onedto")
	// public CommentDTO oneDto(@RequestParam(value = "id", required = true) int
	// id) {
	// return service.oneDto(id);
	// }

	@GetMapping("/oneentity")
	public ResponseEntity<CommentDTO> oneResponse(int number) {
		// public ResponseEntity<CommentDTO> oneResponse
		// (@RequestParam(value="id", required=true) int id) {

//		ResponseEntity<CommentDTO> oneToResponse = service.oneToResponse(2);

		return service.oneToResponse(number);
		
//		return oneToResponse;
	}

	@GetMapping("/alldto")
	public List<CommentDTO> allResponse() {
		return service.listDto();
	}

	@GetMapping("/allresponse")
	public ResponseEntity<List<CommentDTO>> response() {
		return service.entityDto();
	}

	@GetMapping("/test")
	public ResponseEntity<CommentDTO> responseTest(int number) {
		return restTemplate.getForEntity("http://jsonplaceholder.typicode.com/comments/2", CommentDTO.class);

	}

//	@GetMapping("/responsestring")
//	public ResponseEntity<CommentDTO> responseString(int number) {
//		return service.test(number);
//	}

}
