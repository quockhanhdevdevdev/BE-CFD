package edu.cfd.e_learningPlatform.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private Long id;
    private String message;
    private String idUserTo;
    private String nameUserTo;
    private String avatarUserTo;
    private String idUserFrom;
    private String nameUserFrom;
    private Long idCourse;
    private String avatarUserFrom;
    private LocalDateTime createdAt;
    private String type;
}
