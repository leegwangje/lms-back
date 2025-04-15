package project.lmsback.service;

import project.lmsback.domain.RegisterCartDTO;

import java.util.List;

public interface RegisterCartService {

    // 장바구니 우선순위들을 저장
    void saveCartPriorities(List<RegisterCartDTO> priorityList);

    // 특정 학생의 장바구니 목록을 DTO로 반환 (조회용)
    List<RegisterCartDTO> getCartDTOListByStdtId(Integer stdtId);

    void deleteCartItem(Integer stdtId, Integer lectureId);
}
