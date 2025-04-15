package project.lmsback.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.LectureInfo;
import project.lmsback.domain.RegisterCart;
import project.lmsback.domain.RegisterCartDTO;
import project.lmsback.domain.StudentInfo;
import project.lmsback.repository.LectureRepository;
import project.lmsback.repository.RegisterCartRepository;
import project.lmsback.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RegisterCartServiceImpl implements RegisterCartService {
    private final RegisterCartRepository registerCartRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Override
    public void saveCartPriorities(List<RegisterCartDTO> priorityList) {
        for (RegisterCartDTO dto : priorityList) {
            log.info("📦 DTO: stdtId={}, lectureId={}, priority={}",
                    dto.getStdtId(), dto.getLectureId(), dto.getPriorityOrder());

            StudentInfo student = studentRepository.findByStdtId(dto.getStdtId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 학생이 존재하지 않습니다."));

            LectureInfo lecture = lectureRepository.findByLectureId(dto.getLectureId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 강의가 존재하지 않습니다."));

            RegisterCart cart = registerCartRepository.findByStudentAndLecture(student, lecture)
                    .orElseGet(() -> {
                        RegisterCart newCart = new RegisterCart();
                        newCart.setStudent(student);
                        newCart.setLecture(lecture);
                        return newCart;
                    });

            cart.setPriorityOrder(dto.getPriorityOrder());
            registerCartRepository.save(cart); // 새거나 기존이나 save
        }
    }

    @Override
    public List<RegisterCartDTO> getCartDTOListByStdtId(Integer stdtId) {
        return registerCartRepository.findCartDTOByStdtId(stdtId);
    }

    @Override
    public void deleteCartItem(Integer stdtId, Integer lectureId) {
        StudentInfo student = studentRepository.findByStdtId(stdtId)
                .orElseThrow(() -> new IllegalArgumentException("학생 정보가 없습니다."));

        LectureInfo lecture = lectureRepository.findByLectureId(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("강의 정보가 없습니다."));

        RegisterCart cart = registerCartRepository.findByStudentAndLecture(student, lecture)
                .orElseThrow(() -> new IllegalStateException("장바구니 항목이 존재하지 않습니다."));

        registerCartRepository.delete(cart);
    }

}
