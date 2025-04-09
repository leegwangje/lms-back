package project.lmsback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.lmsback.domain.ProfInfo;
import project.lmsback.repository.ProfInfoRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfInfoServiceImpl implements ProfInfoService{
    private final ProfInfoRepository profInfoRepository;
    @Override
    public ProfInfo findByProfId(Integer profId) {
        return profInfoRepository.findByProfId(profId).orElse(null);
    }
}
