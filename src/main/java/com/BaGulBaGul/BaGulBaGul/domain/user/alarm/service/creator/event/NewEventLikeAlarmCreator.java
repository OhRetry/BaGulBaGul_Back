package com.BaGulBaGul.BaGulBaGul.domain.user.alarm.service.creator.event;

import com.BaGulBaGul.BaGulBaGul.domain.user.alarm.constant.AlarmType;
import com.BaGulBaGul.BaGulBaGul.domain.user.alarm.service.creator.AlarmCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class NewEventLikeAlarmCreator extends AlarmCreator {

    private static final String titleFormat = "%s 글에 좋아요 %d개가 눌렸어요";

    private Subject subjectObject;

    @Builder
    public NewEventLikeAlarmCreator(
            Long targetUserId,
            LocalDateTime time,
            Long eventId,
            String postTitle,
            int likeCount
    ) {
        this.type = AlarmType.NEW_EVENT_LIKE;
        this.time = time;
        this.targetUserId = targetUserId;
        this.title = makeAlarmTitle(postTitle, likeCount);
        this.message = null;
        this.subjectObject = Subject.builder()
                .eventId(eventId)
                .build();
        try {
            this.subject = makeSubjectJSON(subjectObject);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException("AlarmCreator subject json 변환 실패");
        }
    }
    private String makeAlarmTitle(String postTitle, int likeCount) {
        return String.format(titleFormat, postTitle, likeCount);
    }


    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class Subject {
        Long eventId;
    }
}
