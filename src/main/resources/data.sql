# TRUNCATE TABLE ROLE;
#
# INSERT INTO ROLE (ROLE_ID, ROLE_NAME) VALUES (1, '관리자');
# INSERT INTO ROLE (ROLE_ID, ROLE_NAME) VALUES (2, '교수');
# INSERT INTO ROLE (ROLE_ID, ROLE_NAME) VALUES (3, '학생');
# INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (1, 10, '남자');
# INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (1, 20, '여자');
# INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (2, 10, '1학기');
# INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (2, 20, '2학기');
# INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (3, 10, '재학');
# INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (3, 20, '졸업');
# INSERT INTO FILE (FILE_ID, FILE_ORG_ID, UUID, FILE_NAME, FILE_PATH, FILE_SIZE) VALUES (1, 1, 'file_name_1', '/files/path_1', 'file_size_1', 1);
# INSERT INTO FILE (FILE_ID, FILE_ORG_ID, UUID, FILE_NAME, FILE_PATH, FILE_SIZE) VALUES (2, 2, 'file_name_2', '/files/path_2', 'file_size_2',1);
# INSERT INTO FILE (FILE_ID, FILE_ORG_ID, UUID, FILE_NAME, FILE_PATH, FILE_SIZE) VALUES (3, 3, 'file_name_3', '/files/path_3', 'file_size_3',1);
# INSERT INTO BOARD_INFO (BOARD_ID, BOARD_TYPE, BOARD_NAME, USE_YN) VALUES (1, 'board_type_1', 'board_name_1', 'Y');
# INSERT INTO BOARD_INFO (BOARD_ID, BOARD_TYPE, BOARD_NAME, USE_YN) VALUES (2, 'board_type_2', 'board_name_2', 'Y');
# INSERT INTO BOARD_INFO (BOARD_ID, BOARD_TYPE, BOARD_NAME, USE_YN) VALUES (3, 'board_type_3', 'board_name_3', 'Y');
# INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME, HP_NO, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (1, 'admin_name_1', 'hp_no_1', 'addr_1', 'addr_dtl_1', 'email_1', 'password_1', 1);
# INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME, HP_NO, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (2, 'admin_name_2', 'hp_no_2', 'addr_2', 'addr_dtl_2', 'email_2', 'password_2', 2);
# INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME, HP_NO, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (3, 'admin_name_3', 'hp_no_3', 'addr_3', 'addr_dtl_3', 'email_3', 'password_3', 3);
# INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250001, 'stdt_name_1', 10, 'hp_no_1', 'addr_dtl_1', 3, 'addr_1', 'email_1', '컴퓨터공학과', '2000/10/23', 2025, '1234', 10, 3);
# INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250002, 'stdt_name_1', 10, 'hp_no_1', 'addr_dtl_1', 3, 'addr_1', 'email_1', '경영학과', '2000/10/23', 2025, '1234', 10, 3);
# INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250003, 'stdt_name_1', 10, 'hp_no_1', 'addr_dtl_1', 3, 'addr_1', 'email_1', '디자인학과', '2000/10/23', 2025, '1234', 10, 3);
# INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250004, 'stdt_name_2', 20, 'hp_no_2', 'addr_dtl_2', 3, 'addr_2', 'email_2', '경제학과', '2000/10/23', 2025, '1234', 10, 3);
# INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250005, 'stdt_name_3', 10, 'hp_no_3', 'addr_dtl_3', 1, 'addr_3', 'email_3', '화학과', '2000/10/23', 2025, '1234', 10, 3);
#
#
#
# INSERT INTO PROF_INFO (PROF_ID, PROF_NAME, GEN_CD, HP_NO, ZIP_CODE, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (1, 'prof_name_1', 10, 'hp_no_1', 4, 'addr_1', 'addr_dtl_1', 'email_1', 'password_1', 2);
# INSERT INTO PROF_INFO (PROF_ID, PROF_NAME, GEN_CD, HP_NO, ZIP_CODE, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (2, 'prof_name_2', 10, 'hp_no_2', 2, 'addr_2', 'addr_dtl_2', 'email_2', 'password_2', 2);
# INSERT INTO PROF_INFO (PROF_ID, PROF_NAME, GEN_CD, HP_NO, ZIP_CODE, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (3, 'prof_name_3', 20, 'hp_no_3', 6, 'addr_3', 'addr_dtl_3', 'email_3', 'password_3', 2);
#
#
# -- 교수 1번
# INSERT INTO LECTURE_INFO (
#     LECTURE_ID, CLASS_YEAR, SEMESTER_CD, COURSE_TYPE, DEPARTMENT,
#     SUBJECT_CODE, SUBJECT_NAME, SUBJECT_LEVEL, CREDIT, MAX_CAPACITY,
#     TIMETABLE, START_DATE, END_DATE, MIN_CAPACITY, GRADE_LEVEL,
#     SUBJECT_PLAN, PROF_ID, FILE_ID, EVALUATOR_A, EVALUATOR_B
# ) VALUES
#       (1001, '2025', 10, '전필', '컴퓨터공학과', 'CS201', '알고리즘', '학부', '3', '40',
#        '월 1-2교시', '2025-03-02 00:00:00', '2025-06-14 00:00:00', '15', '3학년', '알고리즘 설계 및 분석', 1, 101, 2, 3),
#       (1002, '2025', 10, '전선', '컴퓨터공학과', 'CS202', '운영체제', '학부', '3', '35',
#        '화 3-4교시', '2025-03-02 00:00:00', '2025-06-14 00:00:00', '10', '3학년', '운영체제의 구조 및 실습', 1, 102, 2, 4);
#
# -- 교수 2번
# INSERT INTO LECTURE_INFO VALUES
#                              (1003, '2025', 10, '전필', '전자공학과', 'EE101', '디지털논리회로', '학부', '3', '45',
#                               '수 5-6교시', '2025-03-02 00:00:00', '2025-06-14 00:00:00', '20', '2학년', '논리회로 설계 기초', 2, 103, 1, 3),
#                              (1004, '2025', 10, '전선', '전자공학과', 'EE102', '마이크로프로세서', '학부', '3', '40',
#                               '목 3-4교시', '2025-03-02 00:00:00', '2025-06-14 00:00:00', '15', '3학년', '임베디드 시스템 개론', 2, 104, 1, 4);
#
# -- 교수 3번
# INSERT INTO LECTURE_INFO VALUES
#                              (1005, '2025', 10, '교양', '인문학부', 'HU101', '철학의이해', '학부', '2', '60',
#                               '월 5-6교시', '2025-03-02 00:00:00', '2025-06-14 00:00:00', '25', '1학년', '고대부터 현대까지의 철학 개론', 3, 105, 2, 4),
#                              (1006, '2025', 10, '교양', '인문학부', 'HU102', '문학과삶', '학부', '2', '60',
#                               '금 3-4교시', '2025-03-02 00:00:00', '2025-06-14 00:00:00', '20', '1학년', '문학작품을 통한 인간 이해', 3, 106, 1, 2);
#
#
# INSERT INTO FILE (
#     FILE_ID, FILE_ORG_ID, UUID, FILE_NAME, FILE_PATH, FILE_SIZE
# ) VALUES
#       (101, 1001, 'uuid-101', 'syllabus_algo.pdf', '/cdn/files/', 204800),
#       (102, 1002, 'uuid-102', 'syllabus_os.pdf', '/cdn/files/', 195000),
#       (103, 1003, 'uuid-103', 'syllabus_digital.pdf', '/cdn/files/', 150000),
#       (104, 1004, 'uuid-104', 'syllabus_micro.pdf', '/cdn/files/', 170000),
#       (105, 1005, 'uuid-105', 'syllabus_philo.pdf', '/cdn/files/', 180000),
#       (106, 1006, 'uuid-106', 'syllabus_lit.pdf', '/cdn/files/', 160000),
#       (107, 1007, 'uuid-107', 'syllabus_bizintro.pdf', '/cdn/files/', 200000),
#       (108, 1008, 'uuid-108', 'syllabus_marketing.pdf', '/cdn/files/', 210000);
#
# INSERT INTO LECTURE_WEEK (
#     WEEK_ID, LECTURE_ID
# ) VALUES
#       (1, 1001),
#       (2, 1001);
#
# INSERT INTO LECTURE_CONTENT (
#     LECTURE_MANAGEMENT_ID, YOUTUBE_VIDEO_ID, LECTURE_CALL_URL,
#     ONLINE_STATUS_TYPE, CHAPTER_NAME, ORDER_NAME,
#     WEEK_ID, VIDEO_DURATION, FILE_ID
# ) VALUES
#       (10001, 'vid-abc123', 'https://youtube.com/watch?v=abc123', '온라인', '1장: 알고리즘 개요', '1차시', 1, '15:00', 101),
#       (10002, 'vid-def456', 'https://youtube.com/watch?v=def456', '온라인', '2장: 정렬 알고리즘', '2차시', 2, '18:45', 102);
#
#
# INSERT INTO LECTURE_PROGRESS (
#     PROGRESS_ID, WATCH_TIME_TOTAL, WATCH_STATE, LAST_WATCH_TIME,
#     LECTURE_NAME, CONTENT_ID, WATCH_LIMIT, PROGRESS_RATE,
#     STDT_ID, FINAL_PLAYED_TIME, MAX_PLAY_TIME, LECTURE_MANAGEMENT_ID
# ) VALUES
# -- 학생 20250001이 알고리즘 1차시 거의 다 봄
# (1, '14:50', '완료', '14:50', '알고리즘', 'abc123', '3', 98.7, 20250001, 890, 905, 10001),
#
# -- 학생 20250001이 알고리즘 2차시는 절반 정도 봄
# (2, '09:20', '진행중', '09:20', '알고리즘', 'def456', '3', 49.5, 20250001, 560, 1130, 10002),
#
# -- 학생 20250002가 알고리즘 1차시 완강
# (3, '15:00', '완료', '15:00', '알고리즘', 'abc123', '3', 100.0, 20250002, 905, 905, 10001);
#
# INSERT INTO REGISTER_CLASS3 (REGISTER_ID, LECTURE_ID, APPLY_DATE, STDT_ID)
# VALUES (301, 1001, '2025-03-01', 20250001);