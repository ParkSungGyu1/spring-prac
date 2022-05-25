package com.spring.springapiprac.controller;

import com.spring.springapiprac.dto.NoticeDto;
import com.spring.springapiprac.dto.PasswordCheckDto;
import com.spring.springapiprac.model.Notice;
import com.spring.springapiprac.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }

    //notice 전체 불러오기
    @GetMapping("/notice")
    public List<Notice> noticeView(){
        return noticeService.noticeView();
    }

    //게시글 디테일 확인
    //PathVariable 하는법  ==> /notice/detail/1
    @GetMapping("/notice/detail/{id}")
    public Notice detailView(@PathVariable Long id){
        return noticeService.detailView(id);
    }

    //RequestParam 하는법  ==> /notice/detail?id=1
    /*@GetMapping("/notice/detail")
    public Notice detailView(@RequestParam("id") Long id){
        return noticeService.detailView(id);
    }*/

    @PostMapping("/notice/detail/password")
    public boolean passwordCheck(@RequestBody PasswordCheckDto passwordCheckDto){
        PasswordCheckDto passwordCheckDto2 = noticeService.passwordCheck(passwordCheckDto);
        return passwordCheckDto2.isResult();
    }

    //저장 기능 ==> 저장이 완료 되었을 때 Http 상태를 리턴하고 싶다.
    @PostMapping("/notice/write")
    public String noticeWrite(@RequestBody NoticeDto noticeDto){
        noticeService.noticeWrite(noticeDto);
        return "1";
    }


}
