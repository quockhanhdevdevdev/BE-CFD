package edu.cfd.e_learningPlatform.repository;

import edu.cfd.e_learningPlatform.entity.LectureUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureUserRepository extends JpaRepository<LectureUser, Long> {

    List<LectureUser> findByLecture_IdAndUser_Id(Long idLecture, String idUser);
}
