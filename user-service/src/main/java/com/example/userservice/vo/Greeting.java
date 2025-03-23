package com.example.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Greeting {

  // 컬리브레이스 (=중괄호)를 사용하여 appliation.yaml 파일에 선언한 값 가져옴
  @Value("${greeting.message}")
  private String message;
}
