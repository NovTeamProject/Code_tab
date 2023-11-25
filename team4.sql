DROP DATABASE IF EXISTS team4;

CREATE DATABASE team4;
USE team4;

CREATE TABLE student (
	student_idx INT PRIMARY KEY AUTO_INCREMENT,
    student_id VARCHAR(100) UNIQUE NOT NULL,
    student_password VARCHAR(100),
    student_name VARCHAR(50),
    student_join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

CREATE TABLE teacher (
	teacher_idx INT PRIMARY KEY AUTO_INCREMENT,
    teacher_id VARCHAR(100) UNIQUE NOT NULL,
    teacher_password VARCHAR(100) NOT NULL,
    teacher_name VARCHAR(50) NOT NULL,
    teacher_join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

CREATE TABLE class (
	class_idx INT PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(200),
    class_explain TEXT,
    teacher_idx INT,
    class_register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    class_total_time INT,
    class_total_lesson_count INT,
    class_image_original_filename VARCHAR(100),
    class_image_saved_filename VARCHAR(100),
    listen_student INT DEFAULT 0,
    FOREIGN KEY(teacher_idx) REFERENCES teacher(teacher_idx));
    
CREATE TABLE lesson (
	lesson_idx INT PRIMARY KEY AUTO_INCREMENT, 
    lesson_name VARCHAR(100),
    lesson_sequence INT,
    class_idx INT,
    lesson_time INT,
    lesson_original_filename VARCHAR(100),
    lesson_saved_filename VARCHAR(100),
    FOREIGN KEY(class_idx) REFERENCES class(class_idx));
    
CREATE TABLE student_class ( 
	student_idx INT,
    class_idx INT,
    start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(student_idx, class_idx),
    FOREIGN KEY(student_idx) REFERENCES student(student_idx),
    FOREIGN KEY(class_idx) REFERENCES class(class_idx));

CREATE TABLE student_lesson ( 
	student_idx INT,
    class_idx INT,
    lesson_idx INT,
    study_time INT,
    PRIMARY KEY(student_idx, class_idx, lesson_idx),
    FOREIGN KEY(student_idx) REFERENCES student(student_idx),
    FOREIGN KEY(class_idx) REFERENCES class(class_idx),
    FOREIGN KEY(lesson_idx) REFERENCES lesson(lesson_idx));
    
CREATE TABLE board (
	board_idx INT PRIMARY KEY AUTO_INCREMENT,
    class_idx INT,
    student_idx INT,
    title VARCHAR(200),
    content TEXT,
    visitcount int default 0, # 조회수
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(class_idx) REFERENCES class(class_idx),
    FOREIGN KEY(student_idx) REFERENCES student(student_idx));
    
CREATE TABLE comment (
	comment_idx INT PRIMARY KEY AUTO_INCREMENT,
    board_idx INT,
    person_idx INT, # 누가(학생or선생) 댓글을 달았는지 그 사람의 pk 값
    person_type TINYINT, # if student then 0, if teacher then 1
    content VARCHAR(500),
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(board_idx) REFERENCES board(board_idx));
