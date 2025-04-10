package project.lmsback.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import project.lmsback.domain.*;
import project.lmsback.repository.*;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final ProfRepository profInfoRepository;
    private final StudentRepository studentInfoRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("1 {}", username);
        // 관리자 체크
        Admin admin = adminRepository.findByAdminId(Integer.parseInt(username)).orElseThrow(
                () -> new UsernameNotFoundException("사용자가 존재하지 않습니다!!")
        );

        log.info("1a {}", admin);
        if (admin != null) {
            log.info("1b ");
            return new CustomUserDetails(admin.getAdminId().toString(), admin.getPassword(), "ADMIN");
        }

        log.info("2 ");
        // 교수 체크
        Optional<ProfInfo> professorOpt = profInfoRepository.findByProfId(Integer.parseInt(username));
        if (professorOpt.isPresent()) {
            ProfInfo professor = professorOpt.get();
            log.info("교수 로그인 확인: {}", professor.getProfId());
            return new CustomUserDetails(professor.getProfId().toString(), professor.getPassword(), "PROFESSOR");
        }

        log.info("3 ");
        // 학생 체크 - 여기 수정 🔥
        try {
            Optional<StudentInfo> studentOpt = studentInfoRepository.findByStdtId(Integer.parseInt(username));
            if (studentOpt.isPresent()) {
                StudentInfo student = studentOpt.get();
                log.info("학생 로그인 확인: {}", student.getStdtId());
                log.info(">>> student.getPassword() = {}", student.getPassword()); // 🔍 비밀번호 확인용 로그
                return new CustomUserDetails(student.getStdtId().toString(), student.getPassword(), "STUDENT");
            }
            log.info(">>> ");
        } catch (NumberFormatException e) {
            // 숫자가 아닌 username이 들어왔을 경우 예외 처리
            throw new UsernameNotFoundException("학생 ID 형식이 잘못되었습니다.");
        }

        throw new UsernameNotFoundException("사용자 정보를 찾을 수 없습니다.");
    }
}
