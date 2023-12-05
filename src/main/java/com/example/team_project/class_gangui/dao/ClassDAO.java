package com.example.team_project.class_gangui.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.class_gangui.dto.ClassDTO;
import com.example.team_project.class_gangui.mapper.ClassMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ClassDAO {

    // 변재혁님 여기 아래부터 시작
    public boolean insertNewClass(ClassDTO classDTO) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int result = classMapper.insertNewClass(classDTO);
        if (result > 0) {
            log.info("새로운 강의 저장 성공 - 강의 PK: {}", classDTO.getClassIdx());
            sqlSession.commit();
            sqlSession.close();
            return true;
        } else {
            log.info("새로운 강의 저장 실패");
            sqlSession.close();
            return false;
        }
    }

    public int getAllUploadedClassesCountFilteredByTeacherIdx(int teacherIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int uploadedCount = classMapper.getAllUploadedClassesCountFilteredByTeacherIdx(teacherIdx);
        sqlSession.close();
        return uploadedCount;
    }

    public List<ClassDTO> getAllUploadedClassesListFilteredByTeacherIdx(Map<String, Object> map) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<ClassDTO> classList = classMapper.getAllUploadedClassListFilteredByTeacherIdxWithPaging(map);
        sqlSession.close();
        return classList;
    }

    public ClassDTO getOneClassInformationWithRelatedLessons(int classIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        ClassDTO result = classMapper.getOneClassInformationWithRelatedLessons(classIdx);
        log.info("한 개의 Class에 대한 information 조회. class_idx: ({})", result.getClassIdx());
        log.info("강의 번호 ({}) 에 대한 수업의 개수: ({})", result.getClassIdx(), result.getLessonList().size());
        sqlSession.close();
        return result;
    }

    public int checkIfSpecificTeacherIdxUploadedSpecificClassIdx(int classIdxInt, int teacherIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int validCount = classMapper.checkIfSpecificTeacherIdxUploadedSpecificClassIdx(classIdxInt, teacherIdx);
        sqlSession.close();
        return validCount;
    }

    public int getTotalUploadedClassesCount() {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int count = classMapper.getTotalUploadedClassesCount();
        sqlSession.close();
        return count;
    }

    public List<ClassDTO> getAllUploadedClassesList(Map<String, Object> map) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<ClassDTO> classList = classMapper.getAllUploadedClassesList(map);
        sqlSession.close();
        return classList;
    }

    public List<ClassDTO> getTop3ClassList() {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<ClassDTO> classList = classMapper.getTopThreeClassList();
        sqlSession.close();
        return classList;
    }

    public List<ClassDTO> getRecentClassList() {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<ClassDTO> classList = classMapper.getRecentClassList();
        sqlSession.close();
        return classList;
    }

    public int plusOneStudent(int classIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int result = classMapper.plusOneStudent(classIdx);
        if (result == 1) {
            sqlSession.commit();
        } else {
            System.out.println("강의 수강생 1 '증가' 중 오류 발생");
        }
        sqlSession.close();
        return result;
    }

    public int minusOneStudent(int classIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int result = classMapper.minusOneStudent(classIdx);
        if (result == 1) {
            sqlSession.commit();
        } else {
            System.out.println("강의 수강생 1 '감소' 중 오류 발생");
        }
        sqlSession.close();
        return result;
    }

    // 남원우님 여기 아래부터 작성 시작
    public List<Map<String, Object>> rankingClass() {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<Map<String, Object>> maps = classMapper.rankingClass();
        sqlSession.close();
        return maps;

    }
    public List<Map<String, Object>> uprankingClass() {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<Map<String, Object>> maps = classMapper.uprankingClass();
        sqlSession.close();
        return maps;
    }
    // 차소영님 여기 아래부터 작성 시작

    public boolean registerClass(int classIdx, int studentIdx) { //수업을 등록하는 메서드
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        // ClassMapper 인터페이스의 구현체를 얻어온다.
        // MyBatis는 개발자가 SQL 쿼리와 결과 매핑을 XML이나 인터페이스에 명시하면, 이를 처리해주는 구현체를 생성함.

        Map<String, Integer> map = new HashMap<>();
        map.put("classIdx", classIdx);
        map.put("studentIdx", studentIdx);
        // classIdx와 studentIdx를 키-값 쌍으로 가지는 HashMap 객체를 생성
        // 이 맵은 MyBatis에 파라미터를 전달하는 역할을 함.


        int result = classMapper.registerClass(map);
        // classMapper의 registerClass 메서드를 호출하여 SQL 쿼리를 실행
        // 학생이 클래스를 등록하는 작업을 수행함.

        if (result == 1) {
            sqlSession.commit();
            // SQL 쿼리의 결과를 데이터베이스에 반영 :
            // commit
            System.out.println("학생 수강신청 성공");
        } else {
            System.out.println("학생 수강신청 중 오류 발생");
        }


        sqlSession.close();
        // SQL 세션을 종료

        return result > 0;
        // SQL 쿼리의 결과가 성공적이면 true를, 그렇지 않으면 false를 반환
    }

    public boolean deleteClass(int classIdx, int studentIdx) { // 강의를 삭제하는 메소드
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("classIdx", classIdx);
        map.put("studentIdx", studentIdx);

        int result = classMapper.deleteClass(map);
        // classMapper의 deleteClass 메소드를 호출하여 SQL 쿼리를 실행
        // 학생이 클래스를 삭제하는 작업을 수행함.

        sqlSession.commit();
        sqlSession.close();

        return result > 0;
    }


    public List<Map<String, Object>> getRegisteredClasses(int studentIdx) { // 학생이 등록한 클래스 목록을 가져오는 메서드
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<Map<String, Object>> classList = classMapper.getRegisteredClasses(studentIdx);
        sqlSession.close();
        return classList;
        // 쿼리의 결과로 얻은 클래스 목록을 List에 담아 반환한다.
        // ClassDTO는 클래스 정보를 담는 데이터 전송 객체
    }

    public List<ClassDTO> getRegisteredClassesList(int studentIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<ClassDTO> result = classMapper.getRegisteredClassesList(studentIdx);
        sqlSession.close();
        return result;
    }

    public boolean checkIfStudentRegisteredClass(int classIdx, int studentIdx) { // 학생이 이미 수강 신청 했는지 확인하는 메서드
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("classIdx", classIdx);
        map.put("studentIdx", studentIdx);
        int result = classMapper.checkIfStudentRegisteredClass(map);
        sqlSession.close();
        return result > 0;
    }

    public int getStudentRegisteredClassCount(int studentIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int studentRegisteredClassCount = classMapper.getStudentRegisteredClassCount(studentIdx);
        sqlSession.close();
        return studentRegisteredClassCount;
    }

    // 특정 학생이 특정 강의를 등록했는지 확인하는 메서드
    public int checkIfSpecificStudentIdxRegisteredSpecificClassIdx(int classIdxInt, int studentIdx) {
        // 파라미터를 Map으로 묶기
        Map<String, Object> params = new HashMap<>();
        params.put("classIdx", classIdxInt);
        params.put("studentIdx", studentIdx);

        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

        // Map 파라미터를 메서드에 전달
        int validCount = classMapper.checkIfSpecificStudentIdxRegisteredSpecificClassIdx(params);
        sqlSession.close();
        return validCount;
    }

    // 유지호님 여기 아래부터 작성 시작
    public String getClassNameByClassIdx(String classIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        String className = mapper.getClassNameByClassIdx(classIdx);
        return className;
    }

}
