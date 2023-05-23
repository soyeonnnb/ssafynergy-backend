package com.ssafy.controller.challenge;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.model.dto.challenge.ChallengeIng;
import com.ssafy.model.service.challenge.ChallengeIngService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge-participate/ing")
public class ChallengeIngController {

	@Autowired
	private ChallengeIngService cs;
	

	@PostMapping("")
	@ApiOperation(value = "당일의 챌린지 현황을 등록한다.")
	public ResponseEntity<?> insert(@RequestBody ChallengeIng challengeIng) {
		cs.insert(challengeIng);
		return new ResponseEntity<ChallengeIng>(challengeIng, HttpStatus.OK);
	}
	
	@Autowired
	private ResourceLoader resLoader;

	
	@PostMapping("/challengIng-img")
	public ResponseEntity<String> addChallengIngImg(@RequestParam("challenge-img-edit") MultipartFile img) {
		Resource res = resLoader.getResource("classpath:/static/upload/challenge_ing");
		String filePath = "";
		try {
			if (!res.getFile().exists())
				res.getFile().mkdir();
			if (img != null && img.getSize() > 0) {
				filePath = randomPath();
				img.transferTo(new File(res.getFile().getCanonicalPath() + "/" + filePath));
				return new  ResponseEntity<String>(filePath, HttpStatus.OK);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	public String randomPath() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 30;
	    Random random = new Random();
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	                                   .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	                                   .limit(targetStringLength)
	                                   .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	                                   .toString();
	    return generatedString;
	  }
	
	
	@PutMapping("/{id}")
	@ApiOperation(value = "당일의 챌린지 현황을 수정한다.")
	public ResponseEntity<?> update(@RequestBody ChallengeIng challengeIng, @PathVariable int id) {
		cs.update(challengeIng);
		return new ResponseEntity<ChallengeIng>(challengeIng, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "해당 챌린지에 대한 현황 목록을 조회한다.")
	public ResponseEntity<List<ChallengeIng>> seleteAll(@PathVariable int id) {
		List<ChallengeIng> list = cs.selectByChallengeParticipateId(id);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ChallengeIng>>(list, HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}/{index}")
	@ApiOperation(value = "{index}날짜의 챌린지 현황을 삭제한다.")
	public ResponseEntity<String> delete(@PathVariable(value = "id") int id, @PathVariable(value = "index") int index) {
		cs.delete(index);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
