package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import project.lmsback.domain.StudentInfo;
import project.lmsback.domain.StudentProfileDTO;
import project.lmsback.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentInfoService{
    private StudentRepository studentRepository;
    @Override
    public StudentProfileDTO stdtlist(Integer studentId) {
        StudentInfo dto = studentRepository.findByStdtId(studentId);
        return  StudentProfileDTO.builder()
                .stdtId(dto.getStdtId())
                .stdtName(dto.getStdtName())
                .email(dto.getEmail())
                .major(dto.getMajor())
                .hpNo(dto.getHpNo())
                .progressRate(0.0)
                .submissionRate(0.0).build();
    }
}
