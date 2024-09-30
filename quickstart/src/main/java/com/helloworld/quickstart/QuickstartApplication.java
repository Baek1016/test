package com.helloworld.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;//componetScan에 대해서 더 알아야함
//quick controller와 application위치 유의

//역할: 어플리케이션 초기화 및 설정
// rest api와의 관계:QuickstartApplication은 애플리케이션 전체의 진입점이며, REST API를 포함한 모든 기능이 동작할 수 있는 환경을 구축합니다.
// REST API 요청을 처리할 수 있도록 내장 서버(Tomcat 등)를 시작하고, 컨트롤러, 서비스, 리포지토리 등을 스캔하여 Spring 컨텍스트에 등록합니다.
//직접적으로 REST API를 처리하지는 않지만, REST API가 동작할 수 있는 기반을 제공합니다.

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

}
