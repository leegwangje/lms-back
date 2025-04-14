package project.lmsback.service;

import project.lmsback.domain.AssignmentSubmit;
import project.lmsback.domain.AssignmentsViewDTO;
import project.lmsback.domain.EvaluateUpdateDTO;

import java.util.List;

public interface AssignmentSubmitService {
    List<AssignmentsViewDTO> assignmentViews(int profId);
    boolean evaluateUpdate(EvaluateUpdateDTO assignmentSubmit);
}
