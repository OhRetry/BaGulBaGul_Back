package com.BaGulBaGul.BaGulBaGul.domain.user.alarm.service.creator.event;

import com.BaGulBaGul.BaGulBaGul.domain.user.alarm.constant.AlarmType;
import com.BaGulBaGul.BaGulBaGul.domain.user.alarm.service.creator.AlarmCreator;
import com.BaGulBaGul.BaGulBaGul.domain.user.alarm.service.creator.post.NewCommentChildAlarmInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class NewEventCommentChildAlarmCreator extends AlarmCreator {

    @Builder
    public NewEventCommentChildAlarmCreator(
            NewCommentChildAlarmInfo newCommentChildAlarmInfo
    ) {
        this.type = AlarmType.NEW_EVENT_COMMENT_CHILD;
        this.targetUserId = newCommentChildAlarmInfo.getTargetUserId();
        this.title = newCommentChildAlarmInfo.getTitle();
        this.message = newCommentChildAlarmInfo.getMessage();
        this.time = newCommentChildAlarmInfo.getTime();

        Subject subjectObject = Subject.builder()
                .targetSubject(newCommentChildAlarmInfo.getSubjectObject())
                .build();
        try {
            this.subject = makeSubjectJSON(subjectObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("AlarmCreator subject json 변환 실패");
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Subject {
        Long commentId;
        @Builder
        public Subject(NewCommentChildAlarmInfo.Subject targetSubject) {
            this.commentId = targetSubject.getCommentId();
        }
    }
}