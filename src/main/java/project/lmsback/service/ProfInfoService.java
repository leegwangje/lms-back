package project.lmsback.service;

import project.lmsback.domain.ProfInfo;

import java.util.Optional;

public interface ProfInfoService {
    ProfInfo findByProfId(Integer profId);
}
