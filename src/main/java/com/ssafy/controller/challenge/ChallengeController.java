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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.model.dto.challenge.Challenge;
import com.ssafy.model.dto.challenge.SearchCondition;
import com.ssafy.model.service.challenge.ChallengeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/challenge")
public class ChallengeController {
	@Autowired
	private ChallengeService cs;

	@PostMapping("")
	@ApiOperation(value = "챌린지를 추가한다.")
	public ResponseEntity<?> insert(@RequestBody Challenge challenge) {
		cs.insert(challenge);
		return new ResponseEntity<Challenge>(challenge, HttpStatus.OK);
	}

	@PutMapping("")
	@ApiOperation(value = "챌린지를 수정한다.")
	public ResponseEntity<String> update(@RequestBody Challenge challenge) {
		cs.update(challenge);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Autowired
	private ResourceLoader resLoader;

	@PostMapping("/challenge-img")
	public ResponseEntity<String> addChallengIngImg(@RequestParam("challenge-img-edit") MultipartFile img) {
		Resource res = resLoader.getResource("classpath:/static/upload/challenge");
		String filePath = "";
		try {
			if (!res.getFile().exists())
				res.getFile().mkdir();
			if (img != null && img.getSize() > 0) {
				filePath = randomPath();
				img.transferTo(new File(res.getFile().getCanonicalPath() + "/" + filePath));
				return new ResponseEntity<String>(filePath, HttpStatus.OK);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	public String randomPath() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 30;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

	@GetMapping("/search")
	@ApiOperation(value = "옵션을 선택하여 챌린지를 검색한다.")
	public ResponseEntity<?> search(SearchCondition searchcondition) {
//		System.out.println(searchcondition);
		List<Challenge> list = cs.search(searchcondition);
		if (list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Challenge>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "챌린지{id}의 정보를 반환한다.")
	public ResponseEntity<?> detail(@PathVariable int id) {
		Challenge challenge = cs.select(id);
//		System.out.println(challenge);
		if (challenge == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Challenge>(challenge, HttpStatus.OK);
		}
	}

}
