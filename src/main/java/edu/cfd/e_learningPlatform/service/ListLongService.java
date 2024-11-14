package edu.cfd.e_learningPlatform.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListLongService {
    public String listLongToString(List<Long> listLongNumbers) {
        if (listLongNumbers.isEmpty()) {
            return null;
        } else {
            return listLongNumbers.stream().map(String::valueOf).collect(Collectors.joining(","));
        }
    }

    public List<Long> stringToListLong(String listLongString) {
        if (listLongString.isEmpty()) {
            return null;
        } else {
            return Arrays.stream(listLongString.split(",")).map(Long::valueOf).collect(Collectors.toList());
        }
    }
}
