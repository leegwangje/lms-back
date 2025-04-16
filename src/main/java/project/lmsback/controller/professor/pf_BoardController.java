package project.lmsback.controller.professor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.lmsback.domain.*;
import project.lmsback.service.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/prof")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class pf_BoardController {

    private final LectureInfoService lectureInfoService;
    private final ProfInfoService profInfoService;
    private final StudentInfoService studentInfoService;
    private final RegisterClassService registerClassService;
    private final AssignmentSubmitService assignmentSubmitService;
    private final FileService fileService;
    private final LectureContentService lectureContentService;
    private final LectureAssingmentService lectureAssingmentService;

    // 나의 강좌 페이지
    @GetMapping("/myLecture")
    public ResponseEntity<?> myLecture(Authentication authentication) {
        ResponseEntity response = ResponseEntity.badRequest().build();

        int profid = Integer.parseInt(authentication.getName());
        List<ProfLecturesDTO> list = lectureInfoService.findByLecture_profId(profid);

        if (list.size() > 0) {
            response = ResponseEntity.ok().body(list);
        }else{
            response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return response;
    }

    // 개인정보 페이지
    @GetMapping("/edit")
    public ResponseEntity<?> edit(Authentication authentication) {
        ResponseEntity response = ResponseEntity.badRequest().build();

        int profid = Integer.parseInt(authentication.getName());

        ProfInfo dto = profInfoService.findByProfId(profid);
        if (dto == null) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(profInfoService.findByProfId(profid), HttpStatus.OK);
    }

    // 강의자료 페이지
    @GetMapping("/lecturelist")
    public ResponseEntity<?> lecturelist(Authentication authentication) {
        ResponseEntity response = ResponseEntity.badRequest().build();
        int profid = Integer.parseInt(authentication.getName());
        List<LectureListsDTO> dto = lectureInfoService.listLecture(profid);

        return ResponseEntity.ok().body(dto);
    }

    // 동영상, 자료 업로드 페이지
    @GetMapping("/videoUpload")
    public ResponseEntity<?> videoUpload(Authentication authentication) {
        ResponseEntity response = ResponseEntity.badRequest().build();
        int profid = Integer.parseInt(authentication.getName());
        List<LectureListsDTO> dtolist = lectureInfoService.lectureList(profid);

        if (dtolist.size() > 0) {
            return new ResponseEntity<>(dtolist, HttpStatus.OK);
        }
        return response;
    }

    // 학생 목록 페이지
    @GetMapping("/stdtlist")
    public ResponseEntity<?> stdtlist(Authentication authentication) {
        ResponseEntity response = ResponseEntity.badRequest().build();
        int profid = Integer.parseInt(authentication.getName());
        List<StudentProfileDTO> totalists = registerClassService.classUserList(profid);

        return ResponseEntity.ok().body(totalists);
    }

    //과제 평가 페이지
    @GetMapping("/stdtreport")
    public ResponseEntity<?> stdtreport(Authentication authentication){
        ResponseEntity response = ResponseEntity.badRequest().build();
        int profid = Integer.parseInt(authentication.getName());
        List<AssignmentsViewDTO> list = assignmentSubmitService.assignmentViews(profid);

        return ResponseEntity.ok().body(list);
    }

    //메세지 화면 페이지
    @GetMapping("/message")
    public ResponseEntity<?> message(Authentication authentication) {
        ResponseEntity response = ResponseEntity.badRequest().build();

        List<StudentProfileDTO> dtos = registerClassService.classMassageList(1001);

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    // 개인정보 수정 기능
    @PostMapping("/editUpdate")
    public ResponseEntity<?> editUpdata(@RequestBody ProfInfo dto,Authentication authentication) {
        ResponseEntity response = ResponseEntity.badRequest().build();

        ProfInfo saved = profInfoService.uploadProf(dto);

        return ResponseEntity.ok().body(saved);
    }

    // 파일 업로드 기능
    @PostMapping("/videoUploadInsert")
    public ResponseEntity<?> videoUploadInsert(
            @ModelAttribute LectureFileUploadDTO dto,
            @RequestParam("file") List<MultipartFile> file,
            Authentication authentication
    ) {
        log.info("📥 업로드 요청: {}", dto);

        File fileDTO = fileService.saveUploadFile(file);
        lectureContentService.lectureUpdateFile(dto, fileDTO);

        return ResponseEntity.ok().body(dto);
    }

    // 과제 등록 
    @PostMapping("/assignmentInsert")
    public ResponseEntity<?> assignment(AssignmentUploadDTO dto, @RequestParam MultipartFile file) {
        ResponseEntity response = ResponseEntity.badRequest().build();

        LectureAssignment assignment = lectureAssingmentService.assignmentUpload(dto, file);

        return ResponseEntity.ok().body(assignment);
    }

    // 과제 목록
    @GetMapping("/assignmentList")
    public ResponseEntity<?> assignmentList(Authentication authentication) {
        ResponseEntity response = ResponseEntity.badRequest().build();
        int profid = Integer.parseInt(authentication.getName());
        List<AssignmentDTO> lists = lectureAssingmentService.findByLectureAssignment(profid);

        return ResponseEntity.ok().body(lists);
    }

    // 과제 점수 기입
    @PostMapping("/evaluate")
    public ResponseEntity<?> evaluate(@RequestBody EvaluateUpdateDTO assignmentSubmit,Authentication authentication) {

        if(assignmentSubmitService.evaluateUpdate(assignmentSubmit) ) {
            Map<String, String> tokens = Map.of(
                    "msg", "success"
            );
            return ResponseEntity.ok().body(tokens);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("성적 점수 수정 실패");
        }
    }

    // 과제 다운
    @GetMapping("/down/{uuid}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String uuid,Authentication authentication) {
        File file = fileService.downFile_uuid(uuid);
        try {
            Path path = Path.of(file.getFilePath());
            byte[] fileBytes = java.nio.file.Files.readAllBytes(path);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.attachment()
                    .filename(file.getFileName())
                    .build());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileBytes);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}

