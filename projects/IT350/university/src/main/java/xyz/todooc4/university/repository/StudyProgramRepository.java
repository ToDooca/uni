package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.StudyProgram;

@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Integer>, JpaSpecificationExecutor<StudyProgram> {

}