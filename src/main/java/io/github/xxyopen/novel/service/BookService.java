package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.req.PageReqDto;
import io.github.xxyopen.novel.core.common.resp.PageRespDto;
import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.req.BookAddReqDto;
import io.github.xxyopen.novel.dto.req.ChapterAddReqDto;
import io.github.xxyopen.novel.dto.req.UserCommentReqDto;
import io.github.xxyopen.novel.dto.resp.*;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface BookService {

    RestResp<Void> saveBook(BookAddReqDto dto);

    RestResp<PageRespDto<BookInfoRespDto>> listAuthorBooks(PageReqDto dto);

    RestResp<Void> saveBookChapter(ChapterAddReqDto dto);

    RestResp<PageRespDto<BookChapterRespDto>> listBookChapters(Long bookId, PageReqDto dto);

    RestResp<Void> saveComment(UserCommentReqDto dto);

    RestResp<Void> updateComment(Long userId, Long id, String content);

    RestResp<Void> deleteComment(Long userId, Long commentId);

    RestResp<List<BookCategoryRespDto>> listCategory(Integer workDirection);

    RestResp<BookInfoRespDto> getBookById(Long bookId);

    RestResp<Void> addVisitCount(Long bookId);

    RestResp<BookChapterAboutRespDto> getLastChapterAbout(Long bookId);

    RestResp<List<BookInfoRespDto>> listRecBooks(Long bookId) throws NoSuchAlgorithmException;

    RestResp<List<BookChapterRespDto>> listChapters(Long bookId);

    RestResp<BookContentAboutRespDto> getBookContentAbout(Long chapterId);

    RestResp<Long> getPreChapterId(Long chapterId);

    RestResp<Long> getNextChapterId(Long chapterId);

    RestResp<List<BookRankRespDto>> listVisitRankBooks();

    RestResp<List<BookRankRespDto>> listNewestRankBooks();

    RestResp<List<BookRankRespDto>> listUpdateRankBooks();

    RestResp<BookCommentRespDto> listNewestComments(Long bookId);
}
