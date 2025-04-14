package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.lmsback.domain.AssignmentSubmit;
import project.lmsback.domain.AssignmentsViewDTO;
import project.lmsback.domain.EvaluateUpdateDTO;
import project.lmsback.repository.AssignmentSubmitRepository;
import project.lmsback.repository.LectureInfoRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssignmentSubmitServiceImpl implements AssignmentSubmitService {
    private final AssignmentSubmitRepository assignmentSubmitRepository;
    private final LectureInfoRepository lectureInfoRepository;

    @Override
    public List<AssignmentsViewDTO> assignmentViews(int profId) {

        List<AssignmentsViewDTO> dtos = new ArrayList<>();
        lectureInfoRepository.findByProfessor_ProfId(profId).forEach(lectureInfo -> {
            log.info(">>> 개설강좌번호  >>  {}",lectureInfo.getLectureId());
            List<AssignmentSubmit> list = assignmentSubmitRepository.findByLecture_LectureId(lectureInfo.getLectureId());
            list.forEach(assignment -> {
                AssignmentsViewDTO dto = AssignmentsViewDTO.builder()
                        .assignmentId(assignment.getAssignmentSubmitId())
                        .stdt_id(assignment.getStudent().getStdtId())
                        .stdt_name(assignment.getStudent().getStdtName())
                        .assignment_name(assignment.getAssignment().getTitle())
                        .submissionDate(assignment.getSubmissionDate())
                        .fileName(assignment.getFile().getFileName())
                        .score(assignment.getScore())
                        .uuid(assignment.getFile().getUuid())
                        .build();

                log.info(">>> dto >>> {} " , dto.toString());
                dtos.add(dto);
            });
        });

        log.info(dtos.toString());

        return dtos;
    }

    @Override
    @Transactional
    public boolean evaluateUpdate(EvaluateUpdateDTO assignmentSubmit) {
        if( assignmentSubmitRepository.updateViews(assignmentSubmit.getAssignmentId(), assignmentSubmit.getScore()) > 0 ){
            return true;
        }
        return false;
    }
}
