package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.dto.ResponseDto;
import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//역할: REST API 엔드포인트 정의 및 처리


@RestController//
@Slf4j //lombok확인용
public class QuickController {

    @Autowired
    private QuickService quickService;

//    @GetMapping("/dummy")//@GetMapping 을 통해서 http.get 관련되 요청은 이 메소드가 이 메소드가 처리 해준다.
//                            //그리고 정확하게 path 가  /dummy 라고 되어 있으면
//    public String dummy() { //이 메소드 가 호출이 된다.
//        log.info("dummy");  //lombok확인용
//        return "{}";        //이 것이 비지니스 로직('{}"는 빈 json 즉 emtpy json이라고 한다.)
//    }
//
//    @GetMapping("/dummy2")
//
//    public String dummy2() {
//        log.info("dummy");  //lombok 연관
//        return "dummy2";
//    }


    //Query Parameter
    @GetMapping("/member")
    public String getmember(@RequestParam("empNo") String empNo
    ,@RequestParam("yaer") int year) {// 사번을 받아주는 Stirng의 값을 가진 empNo가 있다 치고 http를 통해서 받아줘여한다.
                                                                    //그것을 받아주기 위해서 @requsetParam을 사용해여한다.
        log.info("empNo: {}",empNo);
        log.info("year: {}",year);
        return "ok" ;
    }

    //path parameter
    @GetMapping("/company/{id}")//  /로 받는것을 라고 한다.
    public String getCompony(@PathVariable("id") String id){
        log.info("year: {}",id);
        return "ok" ;
    }



    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item) {//주로 postMapping은 바디를 주로 보내기 때문에 무엇이 바디인지 표시가 필요하다.
        log.info("item: {}",item);

        QuickService quickService = new QuickService();
        boolean b = quickService.registerItem(item);//QuickSevice가 여기서 호출이 된다.
        if(b==true) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }
    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        ItemDto res = quickService.getItemById(id);
        return res;
    }

    @PutMapping("/item/{id}")
    public ResponseDto updateItem(@PathVariable("id") Long id, @RequestBody ItemDto item) {
        log.info("Updating item with id: {}", id);
        log.info("New item data: {}", item);
        // 업데이트 로직
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Item updated successfully");
        return responseDto;
    }

    @DeleteMapping("/item/{id}")
    public ResponseDto deleteItem(@PathVariable("id") Long id) {
        log.info("Deleting item with id: {}", id);
        // 삭제 로직
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Item deleted successfully");
        return responseDto;
    }

    @PatchMapping("/item/{id}")
    public ResponseDto partialUpdateItem(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        log.info("Partially updating item with id: {}", id);
        log.info("Updates: {}", updates);
        // 부분 업데이트 로직
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Item partially updated successfully");
        return responseDto;
    }

//    @OptionsMapping("/item")
//    public ResponseEntity<?> getOptions() {
//        // OPTIONS 메소드의 응답을 생성
//        return ResponseEntity.ok()
//                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE)
//                .build();
//    }
//
//    @HeadMapping("/item/{id}")
//    public ResponseEntity<?> headItem(@PathVariable("id") Long id) {
//        // HEAD 메소드의 응답을 생성
//        log.info("Checking existence of item with id: {}", id);
//        // 리소스 존재 여부를 확인하는 로직
//        return ResponseEntity.ok().build();
//    }

}
