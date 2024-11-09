package com.BaGulBaGul.BaGulBaGul.domain.report.dto.api.request;

import com.BaGulBaGul.BaGulBaGul.domain.report.dto.ReportRegisterRequest;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentReportRegisterAPIRequest extends ReportRegisterApiRequest {
    @ApiModelProperty(value = "신고 대상 댓글 id")
    @NotNull(message = "신고 대상 댓글 id는 필수입니다")
    private Long commentId;
}