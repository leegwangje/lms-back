TRUNCATE TABLE ROLE;

INSERT INTO ROLE (ROLE_ID, ROLE_NAME) VALUES (1, '관리자');
INSERT INTO ROLE (ROLE_ID, ROLE_NAME) VALUES (2, '교수');
INSERT INTO ROLE (ROLE_ID, ROLE_NAME) VALUES (3, '학생');
INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (1, 10, '남자');
INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (1, 20, '여자');
INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (2, 10, '1학기');
INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (2, 20, '2학기');
INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (3, 10, '재학');
INSERT INTO COMMON_CODE (CODE_GROUP, CODE, CODE_NAME) VALUES (3, 20, '졸업');
INSERT INTO FILE (FILE_ID, FILE_ORG_ID, UUID, FILE_NAME, FILE_PATH, FILE_SIZE) VALUES (1, 1, 'file_name_1', '/files/path_1', 'file_size_1', 1);
INSERT INTO FILE (FILE_ID, FILE_ORG_ID, UUID, FILE_NAME, FILE_PATH, FILE_SIZE) VALUES (2, 2, 'file_name_2', '/files/path_2', 'file_size_2',1);
INSERT INTO FILE (FILE_ID, FILE_ORG_ID, UUID, FILE_NAME, FILE_PATH, FILE_SIZE) VALUES (3, 3, 'file_name_3', '/files/path_3', 'file_size_3',1);
INSERT INTO BOARD_INFO (BOARD_ID, BOARD_TYPE, BOARD_NAME, USE_YN) VALUES (1, 'board_type_1', 'board_name_1', 'Y');
INSERT INTO BOARD_INFO (BOARD_ID, BOARD_TYPE, BOARD_NAME, USE_YN) VALUES (2, 'board_type_2', 'board_name_2', 'Y');
INSERT INTO BOARD_INFO (BOARD_ID, BOARD_TYPE, BOARD_NAME, USE_YN) VALUES (3, 'board_type_3', 'board_name_3', 'Y');
INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME, HP_NO, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (1, 'admin_name_1', 'hp_no_1', 'addr_1', 'addr_dtl_1', 'email_1', 'password_1', 1);
INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME, HP_NO, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (2, 'admin_name_2', 'hp_no_2', 'addr_2', 'addr_dtl_2', 'email_2', 'password_2', 2);
INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME, HP_NO, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (3, 'admin_name_3', 'hp_no_3', 'addr_3', 'addr_dtl_3', 'email_3', 'password_3', 3);
INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250001, 'stdt_name_1', 10, 'hp_no_1', 'addr_dtl_1', 3, 'addr_1', 'email_1', '컴퓨터공학과', '2000/10/23', 2025, '1234', 10, 3);
INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250002, 'stdt_name_1', 10, 'hp_no_1', 'addr_dtl_1', 3, 'addr_1', 'email_1', '경영학과', '2000/10/23', 2025, '1234', 10, 3);
INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250003, 'stdt_name_1', 10, 'hp_no_1', 'addr_dtl_1', 3, 'addr_1', 'email_1', '디자인학과', '2000/10/23', 2025, '1234', 10, 3);
INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250004, 'stdt_name_2', 20, 'hp_no_2', 'addr_dtl_2', 3, 'addr_2', 'email_2', '경제학과', '2000/10/23', 2025, '1234', 10, 3);
INSERT INTO STDT_INFO (STDT_ID, STDT_NAME, GEN_CD, HP_NO, ADDR_DTL, ZIP, ADDR, EMAIL, MAJOR, STDT_BIRTH, ENTRY_YEAR, PASSWORD, STATE_CD, ROLE_ID) VALUES (20250005, 'stdt_name_3', 10, 'hp_no_3', 'addr_dtl_3', 1, 'addr_3', 'email_3', '화학과', '2000/10/23', 2025, '1234', 10, 3);



INSERT INTO PROF_INFO (PROF_ID, PROF_NAME, GEN_CD, HP_NO, ZIP_CODE, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (1, 'prof_name_1', 10, 'hp_no_1', 4, 'addr_1', 'addr_dtl_1', 'email_1', 'password_1', 2);
INSERT INTO PROF_INFO (PROF_ID, PROF_NAME, GEN_CD, HP_NO, ZIP_CODE, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (2, 'prof_name_2', 10, 'hp_no_2', 2, 'addr_2', 'addr_dtl_2', 'email_2', 'password_2', 2);
INSERT INTO PROF_INFO (PROF_ID, PROF_NAME, GEN_CD, HP_NO, ZIP_CODE, ADDR, ADDR_DTL, EMAIL, PASSWORD, ROLE_ID) VALUES (3, 'prof_name_3', 20, 'hp_no_3', 6, 'addr_3', 'addr_dtl_3', 'email_3', 'password_3', 2);


INSERT INTO LECTURE_WEEK (WEEK_ID, LECTURE_ID) VALUES
                                                   (1, 101), (2, 101), (3, 101), (4, 101), (5, 101),
                                                   (6, 101), (7, 101), (8, 101), (9, 101), (10, 101),
                                                   (11, 101), (12, 101), (13, 101), (14, 101), (15, 101);

INSERT INTO LECTURE_WEEK (WEEK_ID, LECTURE_ID) VALUES
                                                   (1, 104), (2, 104), (3, 104), (4, 104), (5, 104),
                                                   (6, 104), (7, 104), (8, 104), (9, 104), (10, 104);
