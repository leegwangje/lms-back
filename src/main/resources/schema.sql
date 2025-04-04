create table if not exists `LECTURE_INFO` (
                                `LECTURE_ID`   INTEGER   NOT NULL,
                                `CLASS_YEAR`   VARCHAR(50)   NULL,
                                `SEMESTER_CD`   INTEGER   NULL,
                                `COURSE_TYPE`   VARCHAR(6)   NULL,
                                `DEPARTMENT`   VARCHAR(200)   NULL,
                                `SUBJECT_CODE`   VARCHAR(200)   NULL,
                                `SUBJECT_NAME`   VARCHAR(50)   NULL,
                                `SUBJECT_LEVEL`   VARCHAR(10)   NULL,
                                `CREDIT`   VARCHAR(2)   NULL,
                                `MAX_CAPACITY`   VARCHAR(3)   NULL,
                                `TIMETABLE`   VARCHAR(100)   NULL,
                                `START_DATE`   DATETIME   NULL,
                                `END_DATE`   DATETIME   NULL,
                                `MIN_CAPACITY`   VARCHAR(3)   NULL,
                                `GRADE_LEVEL`   VARCHAR(10)   NULL,
                                `SUBJECT_PLAN`   VARCHAR(1000)   NULL,
                                `PROF_ID`   INTEGER   NOT NULL,
                                `FILE_ID`   INTEGER   NOT NULL,
                                `EVALUATOR_A`   INTEGER   NULL,
                                `EVALUATOR_B`   INTEGER   NULL
);

create table if not exists `COMMON_CODE` (
                               `CODE_GROUP`   INTEGER   NOT NULL,
                               `CODE`   INTEGER   NOT NULL,
                               `CODE_NAME`   VARCHAR(100)   NULL
);

create table if not exists `ROLE` (
                        `ROLE_ID`   INTEGER   NOT NULL,
                        `ROLE_NAME`   VARCHAR(50)   NULL
);

create table if not exists `STDT_INFO` (
                             `STDT_ID`   INTEGER   NOT NULL,
                             `STDT_NAME`   VARCHAR(50)   NULL,
                             `GEN_CD`   INTEGER   NULL,
                             `HP_NO`   VARCHAR(20)   NULL,
                             `ADDR_DTL`   VARCHAR(200)   NULL,
                             `ZIP`   VARCHAR(6)   NULL,
                             `ADDR`   VARCHAR(200)   NULL,
                             `EMAIL`   VARCHAR(50)   NULL,
                             `MAJOR`   VARCHAR(50)   NULL,
                             `STDT_BIRTH`   VARCHAR(50)   NULL,
                             `ENTRY_YEAR`   VARCHAR(50)   NULL,
                             `PASSWORD`   VARCHAR(100)   NULL,
                             `STATE_CD`   INTEGER   NULL,
                             `ROLE_ID`   INTEGER   NOT NULL
);

create table if not exists `LECTURE_ASSIGNMENT` (
                                      `ASSIGNMENT_ID`   INTEGER   NOT NULL,
                                      `TITLE`   VARCHAR(100)   NULL,
                                      `DESCRIPTION`   VARCHAR(500)   NULL,
                                      `START_DATETIME`   DATETIME   NULL,
                                      `END_DATETIME`   DATETIME   NULL,
                                      `SUBMISSION_COUNT`   INTEGER   NULL,
                                      `FILE_ID`   INTEGER   NOT NULL,
                                      `LECTURE_ID`   INTEGER   NOT NULL

);

create table if not exists `FILE` (
                        `FILE_ID`   INTEGER   NOT NULL,
                        `FILE_ORG_ID`   INTEGER   NOT NULL,
                        `UUID`   VARCHAR(36)   NULL,
                        `FILE_NAME`   VARCHAR(255)   NULL,
                        `FILE_PATH`   VARCHAR(255)   NULL,
                        `FILE_SIZE`   INTEGER   NULL
);

create table if not exists `LECTURE_PROGRESS` (
                                    `PROGRESS_ID`   INTEGER   NOT NULL,
                                    `WATCH_TIME_TOTAL`   VARCHAR(10)   NULL,
                                    `WATCH_STATE`   VARCHAR(10)   NULL,
                                    `LAST_WATCH_TIME`   VARCHAR(10)   NULL,
                                    `LECTURE_NAME`   VARCHAR(100)   NULL,
                                    `CONTENT_ID`   VARCHAR(10)   NULL,
                                    `WATCH_LIMIT`   VARCHAR(10)   NULL,
                                    `PROGRESS_RATE`   DOUBLE   NULL   COMMENT '(max/영상시간)*100',
                                    `STDT_ID`   INTEGER   NOT NULL,
                                    `FINAL_PLAYED_TIME`   INTEGER   NULL,
                                    `MAX_PLAY_TIME`   INTEGER   NULL,
                                    `LECTURE_MANAGEMENT_ID`    INTEGER   NOT NULL
);

create table if not exists `REGISTER_CLASS` (
                                  `REGISTER_ID`   INTEGER   NOT NULL,
                                  `LECTURE_ID`   INTEGER   NOT NULL,
                                  `APPLY_DATE`   DATETIME   NULL,
                                  `ATTENDANCE_RATE`   INTEGER   NULL,
                                  `ATTENDANCE_SCORE`   INTEGER   NULL,
                                  `ASSIGNMENT_SCORE`   INTEGER   NULL,
                                  `PERCENTILE_SCORE`   INTEGER   NULL   COMMENT '출석+과제',
                                  `GRADE_EVALUATION`   VARCHAR(100)   NULL,
                                  `GPA_SCORE`   VARCHAR(100)   NULL,
                                  `STDT_ID`   INTEGER   NOT NULL
);

create table if not exists `LECTURE_CONTENT` (
                                   `LECTURE_MANAGEMENT_ID`   INTEGER   NOT NULL,
                                   `YOUTUBE_VIDEO_ID`   VARCHAR(50)   NULL,
                                   `LECTURE_CALL_URL`   VARCHAR(200)   NULL,
                                   `ONLINE_STATUS_TYPE`   VARCHAR(20)   NULL,
                                   `CHAPTER_NAME`   VARCHAR(100)   NULL,
                                   `ORDER_NAME`   VARCHAR(100)   NULL,
                                   `WEEK_ID`   INTEGER   NOT NULL,
                                   `VIDEO_DURATION`   VARCHAR(10)   NULL,
                                   `FILE_ID`   INTEGER   NOT NULL
);

create table if not exists `REGISTER_CART` (
                                 `CART_ID`   INTEGER   NOT NULL,
                                 `STDT_ID`   INTEGER   NOT NULL,
                                 `PRIORITY_ORDER`   INTEGER   NULL,
                                 `LECTURE_ID`   INTEGER   NOT NULL
);

create table if not exists `BOARD_INFO` (
                              `BOARD_ID`   INTEGER   NOT NULL,
                              `BOARD_TYPE`   VARCHAR(20)   NULL,
                              `BOARD_NAME`   VARCHAR(50)   NULL,
                              `USE_YN`   VARCHAR(1)   NULL
);

create table if not exists `PROF_INFO` (
                             `PROF_ID`   INTEGER   NOT NULL,
                             `PROF_NAME`   VARCHAR(50)   NULL,
                             `GEN_CD`   INTEGER   NULL,
                             `HP_NO`   VARCHAR(20)   NULL,
                             `ZIP_CODE`   VARCHAR(6)   NULL,
                             `ADDR`   VARCHAR(200)   NULL,
                             `ADDR_DTL`   VARCHAR(200)   NULL,
                             `EMAIL`   VARCHAR(50)   NULL,
                             `PASSWORD`   VARCHAR(255)   NULL,
                             `ROLE_ID`   INTEGER   NOT NULL
);

create table if not exists `ASSIGNMENT_SUBMIT` (
                                     `ASSIGNMENT_SUBMIT_ID`   INTEGER   NOT NULL,
                                     `SUBMISSION_TYPE`   VARCHAR(100)   NULL,
                                     `SUBMISSION_DATE`   DATETIME   NULL,
                                     `SCORE`   INTEGER   NULL,
                                     `ASSIGNMENT_ID`   INTEGER   NOT NULL,
                                     `FILE_ID`   INTEGER   NOT NULL,
                                     `LECTURE_ID`   INTEGER   NOT NULL
);

create table if not exists `COMMENT` (
                           `COMMENT_ID`   INTEGER   NOT NULL,
                           `CONTENT`   VARCHAR(1000)   NULL,
                           `WRITER`   VARCHAR(50)   NULL,
                           `CREATED_AT`   VARCHAR(20)   NULL,
                           `POST_ID`   INTEGER   NOT NULL, #-------------INTEGER
                                          `PARENT_COMMENT_ID`   INTEGER   NOT NULL
);

create table if not exists `ACADEMIC_RECORD` (
                                   `RECORD_ID`   INTEGER   NOT NULL,
                                   `COURSE_YEAR`   VARCHAR(4)   NULL,
                                   `CREDIT_APPLIED`   VARCHAR(5)   NULL,
                                   `CREDIT_EARNED`   VARCHAR(5)   NULL,
                                   `GRADE_PERCENTAGE`   VARCHAR(5)   NULL,
                                   `TERM_AVG_SCORE`   VARCHAR(5)   NULL,
                                   `TERM_RANK_SCORE`   VARCHAR(5)   NULL,
                                   `GRADE_AVG_SCORE`   VARCHAR(5)   NULL,
                                   `TERM_AVG_GRADE`   VARCHAR(5)   NULL,
                                   `GRADE_EVAL_COUNT`   VARCHAR(5)   NULL,
                                   `JOINT_MAJOR_CREDIT`   VARCHAR(5)   NULL,
                                   `JOINT_MINOR_CREDIT`   VARCHAR(5)   NULL,
                                   `RETAKEN_CREDIT_COUNT`   VARCHAR(5)   NULL,
                                   `SEMESTER_CD`   INTEGER   NULL,
                                   `LECTURE_ID`   INTEGER   NOT NULL
);

create table if not exists `POST` (
                        `POST_ID`   INTEGER   NOT NULL,
                        `PARENT_POST_ID`   INTEGER   NULL,
                        `TITLE`   VARCHAR(100)   NULL,
                        `CONTENT`   VARCHAR(1000)   NULL,
                        `WRITER`   VARCHAR(50)   NULL,
                        `CREATED_AT`   VARCHAR(20)   NULL,
                        `IS_SECRET`   VARCHAR(1)   NULL,
                        `BOARD_ID`   INTEGER   NOT NULL, # ------------- INTEGER
                            `PREV_POST_ID`   INTEGER   NOT NULL,
                        `FILE_ID`   INTEGER   NOT NULL
);

create table if not exists `ADMIN` (
                         `ADMIN_ID`   INTEGER   NOT NULL,
                         `ADMIN_NAME`   VARCHAR(50)   NULL,
                         `HP_NO`   VARCHAR(20)   NULL,
                         `ADDR`   VARCHAR(200)   NULL,
                         `ADDR_DTL`   VARCHAR(200)   NULL,
                         `EMAIL`   VARCHAR(50)   NULL,
                         `PASSWORD`   VARCHAR(100)   NULL,
                         `ROLE_ID`   INTEGER   NOT NULL
);

create table if not exists `LECTURE_WEEK` (
                                `WEEK_ID`   INTEGER   NOT NULL   COMMENT 'INTEGER',
                                `LECTURE_ID`   INTEGER   NOT NULL
);


-- 제약조건 ----------------------------
ALTER TABLE ADMIN ADD PRIMARY KEY (ADMIN_ID);
ALTER TABLE ROLE ADD PRIMARY KEY (ROLE_ID);
ALTER TABLE ASSIGNMENT_SUBMIT ADD PRIMARY KEY (ASSIGNMENT_SUBMIT_ID);
ALTER TABLE ACADEMIC_RECORD ADD PRIMARY KEY (RECORD_ID);
ALTER TABLE BOARD_INFO ADD PRIMARY KEY (BOARD_ID);
ALTER TABLE POST ADD PRIMARY KEY (POST_ID);
ALTER TABLE COMMENT ADD PRIMARY KEY (COMMENT_ID);
ALTER TABLE LECTURE_ASSIGNMENT ADD PRIMARY KEY (ASSIGNMENT_ID);#FFFFFFFFFF
ALTER TABLE FILE ADD PRIMARY KEY (FILE_ID,FILE_ORG_ID);#FFFFFFFFFF
ALTER TABLE REGISTER_CLASS ADD PRIMARY KEY (REGISTER_ID,LECTURE_ID);#FFFFFFFFFF
ALTER TABLE LECTURE_CONTENT ADD PRIMARY KEY (LECTURE_MANAGEMENT_ID);#FFFFFFFFFF
ALTER TABLE `COMMON_CODE` ADD PRIMARY KEY (`CODE_GROUP`, `CODE`);
ALTER TABLE `STDT_INFO` ADD PRIMARY KEY (`STDT_ID`);
ALTER TABLE `LECTURE_PROGRESS` ADD PRIMARY KEY (`PROGRESS_ID`);
ALTER TABLE `REGISTER_CART` ADD PRIMARY KEY (`CART_ID`);
ALTER TABLE `LECTURE_WEEK` ADD PRIMARY KEY (`WEEK_ID`);
ALTER TABLE LECTURE_INFO ADD PRIMARY KEY (LECTURE_ID);
ALTER TABLE PROF_INFO ADD PRIMARY KEY (PROF_ID);




# --- FK
ALTER TABLE ADMIN ADD CONSTRAINT FK_ADMIN_ID FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ROLE_ID);

ALTER TABLE ASSIGNMENT_SUBMIT ADD CONSTRAINT FK_ASSIGNMENT_ID FOREIGN KEY (ASSIGNMENT_ID) REFERENCES LECTURE_ASSIGNMENT(ASSIGNMENT_ID);
ALTER TABLE ASSIGNMENT_SUBMIT ADD CONSTRAINT FK_FILE_ID FOREIGN KEY (FILE_ID) REFERENCES FILE(FILE_ID);

ALTER TABLE POST ADD CONSTRAINT FK_BOARD_ID FOREIGN KEY (BOARD_ID) REFERENCES BOARD_INFO(BOARD_ID);
ALTER TABLE POST ADD CONSTRAINT FK_PREV_POST_ID FOREIGN KEY (PREV_POST_ID) REFERENCES POST(POST_ID);
ALTER TABLE POST ADD CONSTRAINT FK_FILE_ID_POST FOREIGN KEY (FILE_ID) REFERENCES FILE(FILE_ID);

ALTER TABLE COMMENT ADD CONSTRAINT FK_POST_ID_COMMENT FOREIGN KEY (POST_ID) REFERENCES POST(POST_ID);
ALTER TABLE COMMENT ADD CONSTRAINT FK_PARENT_COMMENT_ID FOREIGN KEY (PARENT_COMMENT_ID) REFERENCES COMMENT(COMMENT_ID);

ALTER TABLE REGISTER_CLASS ADD CONSTRAINT FK_REGISTER_CLASSFOREIGN1 FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE_INFO(LECTURE_ID);
ALTER TABLE REGISTER_CLASS ADD CONSTRAINT FK_REGISTER_CLASSFOREIGN2 FOREIGN KEY (STDT_ID) REFERENCES STDT_INFO(STDT_ID);

ALTER TABLE ASSIGNMENT_SUBMIT ADD CONSTRAINT FK_LECTURE_ID FOREIGN KEY (LECTURE_ID) REFERENCES REGISTER_CLASS(LECTURE_ID);
ALTER TABLE ACADEMIC_RECORD ADD CONSTRAINT FK_LECTURE_ID_ACA FOREIGN KEY (LECTURE_ID) REFERENCES REGISTER_CLASS(LECTURE_ID);

# --------------



ALTER TABLE `STDT_INFO`ADD CONSTRAINT `FK_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLE`(`ROLE_ID`);
ALTER TABLE `LECTURE_PROGRESS` ADD CONSTRAINT `FK_STDT_NO` FOREIGN KEY (`STDT_ID`) REFERENCES `STDT_INFO`(`STDT_ID`);
ALTER TABLE `LECTURE_PROGRESS` ADD CONSTRAINT `FK_LECTURE_ID2` FOREIGN KEY (`LECTURE_MANAGEMENT_ID`) REFERENCES `LECTURE_CONTENT`(`LECTURE_MANAGEMENT_ID`);
ALTER TABLE `REGISTER_CART` ADD CONSTRAINT `FK_STDT_ID1` FOREIGN KEY (`STDT_ID`) REFERENCES `STDT_INFO`(`STDT_ID`);
ALTER TABLE `REGISTER_CART` ADD CONSTRAINT `FK_STNT_ID2` FOREIGN KEY (`LECTURE_ID`) REFERENCES `LECTURE_INFO`(`LECTURE_ID`);
ALTER TABLE `LECTURE_WEEK` ADD CONSTRAINT `FK_LECTURE_ID3` FOREIGN KEY (`LECTURE_ID`) REFERENCES `LECTURE_INFO`(`LECTURE_ID`);


# -----------


#--------------------

ALTER TABLE LECTURE_INFO ADD CONSTRAINT FK_LECTURE_IN1 FOREIGN KEY (PROF_ID) REFERENCES PROF_INFO(PROF_ID);
ALTER TABLE LECTURE_INFO ADD CONSTRAINT FK_LECTURE_IN2 FOREIGN KEY (FILE_ID) REFERENCES FILE(FILE_ID);

ALTER TABLE PROF_INFO ADD CONSTRAINT FK_PROF_INFO FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ROLE_ID);


ALTER TABLE LECTURE_CONTENT ADD CONSTRAINT FK_LECTURE_CONTENT1 FOREIGN KEY (WEEK_ID) REFERENCES LECTURE_WEEK(WEEK_ID);
ALTER TABLE LECTURE_CONTENT ADD CONSTRAINT FK_LECTURE_CONTENT2 FOREIGN KEY (FILE_ID) REFERENCES FILE(FILE_ID);

ALTER TABLE LECTURE_ASSIGNMENT ADD CONSTRAINT FK_LECTURE_ASSIGNMENT1 FOREIGN KEY (FILE_ID) REFERENCES FILE(FILE_ID);
ALTER TABLE LECTURE_ASSIGNMENT ADD CONSTRAINT FK_LECTURE_ASSIGNMENT2 FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE_INFO(LECTURE_ID);



