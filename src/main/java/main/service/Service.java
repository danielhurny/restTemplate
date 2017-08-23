package main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import main.DTO.CommentDTO;

public interface Service {
	
	String allComments();
	
	String oneComment(int number);
	
	CommentDTO oneDto(int number);
	
	ResponseEntity<CommentDTO> oneToResponse(int number);
	
	List<CommentDTO> listDto();
	
	ResponseEntity<List<CommentDTO>> entityDto();
	
	
}