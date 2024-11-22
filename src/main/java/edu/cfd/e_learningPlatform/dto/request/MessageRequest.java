package edu.cfd.e_learningPlatform.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private Long id;
    private String message;
    private String idUserTo;
    private String idUserFrom;
    private Long idCourse;
    private String urlImage;
    private String urlFile;
    private LocalDateTime createdAt;
    private String type;
}
