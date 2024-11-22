package edu.cfd.e_learningPlatform.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "userTo")
    private User userTo;

    @ManyToOne
    @JoinColumn(name = "userFrom")
    private User userFrom;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    private String urlImage;

    private String urlFile;

    private LocalDateTime createdAt;

    private String type;

    private boolean recall;
}
