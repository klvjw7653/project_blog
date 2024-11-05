package com.hyun.board_back.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hyun.board_back.common.ResponseCode;
import com.hyun.board_back.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor// 클래스의 모든 필드를 매개변수로 받는 생성자를 자동으로 생성해 준다.
public class ResponseDto {
    
    private String code;
    private String message; 
    
    public static ResponseEntity<ResponseDto> databaseError(){
        
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATEBASE_ERROR, ResponseMessage.DATEBASE_ERROR);
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

   

}
