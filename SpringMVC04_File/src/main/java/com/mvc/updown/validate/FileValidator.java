package com.mvc.updown.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {	// target 객체에 대한 검증 실행

		UploadFile file = (UploadFile) target;

		if (file.getMpfile().getSize() == 0) {	// 아직 파일을 첨부하지 않았다면
			// rejectValue(String field, String errorCode, String defaultMessage)
			// mpfile에 fileNPE라는 에러 코드 추가, fileNPE에 대한 메시지가 존재하지 않을 경우, "Please select a file"을 mpfile에 담음
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
		}
	}

}
