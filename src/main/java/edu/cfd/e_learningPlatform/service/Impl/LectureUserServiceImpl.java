package edu.cfd.e_learningPlatform.service.Impl;

import edu.cfd.e_learningPlatform.dto.LectureUserDto;
import edu.cfd.e_learningPlatform.dto.response.LectureUserResponse;
import edu.cfd.e_learningPlatform.mapstruct.LectureUserMapper;
import edu.cfd.e_learningPlatform.repository.LectureUserRepository;
import edu.cfd.e_learningPlatform.service.LectureUserService;
import edu.cfd.e_learningPlatform.service.ListLongService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LectureUserServiceImpl implements LectureUserService {

    LectureUserRepository lectureUserRepository;
    ListLongService listLongService;
    LectureUserMapper lectureUserMapper;

    @Override
    public List<LectureUserResponse> findByUserAndLecture(Long lectureId, String userId) {
        List<LectureUserDto> lectureUserDtos = lectureUserMapper.toLectureUserDtos(
                lectureUserRepository.findByLecture_IdAndUser_Id(lectureId, userId));
        List<LectureUserResponse> lectureUserResponses = lectureUserDtos.stream()
                .map(dto -> {
                    LectureUserResponse response = new LectureUserResponse();
                    response.setId(dto.getId());
                    response.setUserId(dto.getUserId());
                    response.setLectureId(dto.getLectureId());
                    response.setChoseOption(listLongService.stringToListLong(dto.getChoseOption()));
                    response.setUpdateAt(dto.getUpdateAt());
                    response.setDoneVideo(dto.isDoneVideo());
                    response.setDoneAssignment(dto.isDoneAssignment());
                    response.setUrlFileAssigment(dto.getUrlFileAssigment());
                    response.setDoneQuiz(dto.isDoneQuiz());
                    response.setStatus(dto.isStatus());
                    return response;
                })
                .collect(Collectors.toList());
        return lectureUserResponses;
    }

    @Override
    public LectureUserDto addProgress(LectureUserResponse lectureUserResponse) {
        LectureUserDto dto = new LectureUserDto(
                lectureUserResponse.getId(),
                lectureUserResponse.getUserId(),
                lectureUserResponse.getLectureId(),
                listLongService.listLongToString(lectureUserResponse.getChoseOption()),
                LocalDateTime.now(),
                lectureUserResponse.isDoneVideo(),
                lectureUserResponse.isDoneAssignment(),
                lectureUserResponse.getUrlFileAssigment(),
                lectureUserResponse.isDoneQuiz(),
                lectureUserResponse.isStatus());
        lectureUserRepository.save(lectureUserMapper.toLectureUser(dto));
        return dto;
    }

    @Override
    public LectureUserDto updateProgress(LectureUserResponse lectureUserResponse) {
        return null;
    }
}
