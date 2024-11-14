package edu.cfd.e_learningPlatform.mapstruct;

import edu.cfd.e_learningPlatform.dto.LectureUserDto;
import edu.cfd.e_learningPlatform.entity.LectureUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LectureUserMapper {
    public static final LectureUserMapper INSTANCE = Mappers.getMapper(LectureUserMapper.class);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "lectureId", target = "lecture.id")
    LectureUser toLectureUser(LectureUserDto lectureUserDto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "lecture.id", target = "lectureId")
    LectureUserDto toLectureUserDto(LectureUser lectureUser);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "lecture.id", target = "lectureId")
    List<LectureUserDto> toLectureUserDtos(List<LectureUser> lectureUsers);
}
