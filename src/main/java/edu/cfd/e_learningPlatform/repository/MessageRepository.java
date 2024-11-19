package edu.cfd.e_learningPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.cfd.e_learningPlatform.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(
            value = "Select * from message m " + "where (m.user_to = :idUserTo and m.user_from = :idUserFrom)"
                    + "or (m.user_to = :idUserFrom and m.user_from = :idUserTo) "
                    + "order by m.created_at asc ",
            nativeQuery = true)
    List<Message> findMessage(String idUserTo, String idUserFrom);
}
