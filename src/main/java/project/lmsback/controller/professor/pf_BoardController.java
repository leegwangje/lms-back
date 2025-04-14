//package project.lmsback.controller.professor;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import project.lmsback.domain.LectureInfo;
//import project.lmsback.domain.ProfInfo;
//import project.lmsback.service.LectureInfoService;
//import project.lmsback.service.ProfInfoService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/prof")
//@RequiredArgsConstructor
//@Slf4j
//@CrossOrigin(origins = "http://localhost:8080")
//public class pf_BoardController {
//
//    private final LectureInfoService lectureInfoService;
//    private final ProfInfoService profInfoService;
//
//    @GetMapping("/myLecture")
//    public ResponseEntity<?> myLecture() {
//        ResponseEntity response = ResponseEntity.badRequest().build();
//
//        //교수 번호 임의 지정
//        int profid = 1;
//
//        List<LectureInfo> list = lectureInfoService.findByLecture_profId(profid);
//
//        if (list.size() > 0) {
//            response = ResponseEntity.ok().body(list);
//        }else{
//            response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        return response;
//    }
//
//    @GetMapping("/edit")
//    public ResponseEntity<?> edit() {
//        ResponseEntity response = ResponseEntity.badRequest().build();
//        int profid = 1;
//        ProfInfo dto = profInfoService.findByProfId(profid);
//        log.info("dto: {} ", dto);
//        if (dto == null) {
//            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return new ResponseEntity<>(profInfoService.findByProfId(profid), HttpStatus.OK);
//    }
//
//    @GetMapping("/lecturelist")
//    public ResponseEntity<?> lecturelist() {
//        System.err.println("contoller 진입");
//        ResponseEntity response = ResponseEntity.badRequest().build();
//
//
//
//        lectureInfoService.lectureList(1001);
//
//
//        return response;
//    }
//
//}
