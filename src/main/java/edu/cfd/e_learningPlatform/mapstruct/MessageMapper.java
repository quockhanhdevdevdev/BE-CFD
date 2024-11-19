package edu.cfd.e_learningPlatform.mapstruct;

import java.util.List;

import edu.cfd.e_learningPlatform.entity.Course;
import edu.cfd.e_learningPlatform.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.cfd.e_learningPlatform.dto.request.MessageRequest;
import edu.cfd.e_learningPlatform.dto.response.MessageResponse;
import edu.cfd.e_learningPlatform.entity.Message;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MessageMapper {
    public static final MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mapping(target = "userTo.id", source = "idUserTo")
    @Mapping(target = "userFrom.id", source = "idUserFrom")
    @Mapping(target = "course.id", source = "idCourse")
    Message toMessage(MessageRequest messageRequest);

    @Mapping(source = "userTo.id", target = "idUserTo")
    @Mapping(source = "userFrom.id", target = "idUserFrom")
    @Mapping(source = "course.id", target = "idCourse")
    MessageRequest toMessageRequest(Message message);

    @Mapping(source = "userTo.id", target = "idUserTo")
    @Mapping(source = "userTo.fullname", target = "nameUserTo")
    @Mapping(source = "userTo.avatarUrl", target = "avatarUserTo")
    @Mapping(source = "userFrom.id", target = "idUserFrom")
    @Mapping(source = "userFrom.fullname", target = "nameUserFrom")
    @Mapping(source = "userFrom.avatarUrl", target = "avatarUserFrom")
    @Mapping(source = "course.id", target = "idCourse")
    MessageResponse toMessageReponse(Message message);

    @Mapping(source = "userTo.id", target = "idUserTo")
    @Mapping(source = "userTo.fullname", target = "nameUserTo")
    @Mapping(source = "userTo.avatarUrl", target = "avatarUserTo")
    @Mapping(source = "userFrom.id", target = "idUserFrom")
    @Mapping(source = "userFrom.fullname", target = "nameUserFrom")
    @Mapping(source = "userFrom.avatarUrl", target = "avatarUserFrom")
    @Mapping(source = "course.id", target = "idCourse")
    List<MessageResponse> toMessageReponses(List<Message> messages);

}
