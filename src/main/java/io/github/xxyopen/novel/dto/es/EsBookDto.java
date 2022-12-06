package io.github.xxyopen.novel.dto.es;

import io.github.xxyopen.novel.dao.entity.BookInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EsBookDto {

    private Long id;

    private Integer workDirection;

    private Long categoryId;

    private String categoryName;

    private String bookName;

    private Long authorId;

    private String authorName;

    private String bookDesc;

    private Integer score;

    private Integer bookStatus;

    private Long visitCount;

    private Integer wordCount;

    private Integer commentCount;

    private Long lastChapterId;

    private String lastChapterName;

    private Long lastChapterUpdateTime;

    private Integer isVip;

    public static EsBookDto build(BookInfo bookInfo){
        return EsBookDto.builder()
                .id(bookInfo.getId())
                .categoryId(bookInfo.getCategoryId())
                .categoryName(bookInfo.getCategoryName())
                .bookDesc(bookInfo.getBookDesc())
                .bookName(bookInfo.getBookName())
                .authorId(bookInfo.getAuthorId())
                .authorName(bookInfo.getAuthorName())
                .bookStatus(bookInfo.getBookStatus())
                .commentCount(bookInfo.getCommentCount())
                .isVip(bookInfo.getIsVip())
                .score(bookInfo.getScore())
                .visitCount(bookInfo.getVisitCount())
                .wordCount(bookInfo.getWordCount())
                .workDirection(bookInfo.getWorkDirection())
                .lastChapterId(bookInfo.getLastChapterId())
                .lastChapterName(bookInfo.getLastChapterName())
                .lastChapterUpdateTime(bookInfo.getLastChapterUpdateTime()
                        .toInstant(ZoneOffset.ofHours(8)).toEpochMilli())
                .build();
    }
}
