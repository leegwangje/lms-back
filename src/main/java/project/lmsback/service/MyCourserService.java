package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.MycourseDTO;
import project.lmsback.domain.RegisterClass;
import project.lmsback.repository.RegisterClassRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyCourserService {

    private final RegisterClassRepository registerClassRepository;

    public List<MycourseDTO> getCoursesByStudentId(Integer stdtId) {
        log.info("getCoursesByStudentId: " + stdtId);

        // 수정된 부분: findByStudent_StdtId로 변경
        List<RegisterClass> registered = registerClassRepository.findByStudent_StdtId(stdtId);

        log.info("등록된 수강 강의 개수: {}", registered.size());

        // 강의 정보를 포함한 DTO 변환
        return registered.stream().map(reg -> {
            LectureInfo lecture = reg.getLecture();

            // lecture가 제대로 로드되는지 확인
            if (lecture == null) {
                log.warn("lecture is null for registerId: {}", reg.getRegisterId());
            }

            MycourseDTO dto = new MycourseDTO();
            dto.setLectureId(lecture.getLectureId());
            dto.setSubjectName(lecture.getSubjectName());
            dto.setDepartment(lecture.getDepartment());
            return dto;
        }).collect(Collectors.toList());
    }
}
