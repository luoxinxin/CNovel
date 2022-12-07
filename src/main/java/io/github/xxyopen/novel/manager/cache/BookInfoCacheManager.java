package io.github.xxyopen.novel.manager.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.xxyopen.novel.core.constant.CacheConsts;
import io.github.xxyopen.novel.core.constant.DatabaseConsts;
import io.github.xxyopen.novel.dao.entity.BookCategory;
import io.github.xxyopen.novel.dao.entity.BookChapter;
import io.github.xxyopen.novel.dao.entity.BookInfo;
import io.github.xxyopen.novel.dao.mapper.BookCategoryMapper;
import io.github.xxyopen.novel.dao.mapper.BookChapterMapper;
import io.github.xxyopen.novel.dao.mapper.BookInfoMapper;
import io.github.xxyopen.novel.dto.resp.BookCategoryRespDto;
import io.github.xxyopen.novel.dto.resp.BookInfoRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookInfoCacheManager {

    private final BookInfoMapper bookInfoMapper;

    private final BookChapterMapper bookChapterMapper;

    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER, value = CacheConsts.BOOK_INFO_CACHE_NAME)
    public BookInfoRespDto getBookInfo(Long id) {
        return cachePutBookInfo(id);
    }

    @CachePut(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER, value = CacheConsts.BOOK_INFO_CACHE_NAME)
    public BookInfoRespDto cachePutBookInfo(Long id) {
        BookInfo bookInfo = bookInfoMapper.selectById(id);
        QueryWrapper<BookChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.BookChapterTable.COLUMN_BOOT_ID, id)
                .orderByAsc(DatabaseConsts.BookChapterTable.COLUMN_CHAPTER_NUM)
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        BookChapter bookChapter = bookChapterMapper.selectOne(queryWrapper);
        return BookInfoRespDto.builder()
                .id(bookInfo.getId())
                .bookName(bookInfo.getBookName())
                .bookDesc(bookInfo.getBookDesc())
                .bookStatus(bookInfo.getBookStatus())
                .authorId(bookInfo.getAuthorId())
                .authorName(bookInfo.getAuthorName())
                .categoryId(bookInfo.getCategoryId())
                .categoryName(bookInfo.getCategoryName())
                .commentCount(bookInfo.getCommentCount())
                .firstChapterId(bookChapter.getId())
                .lastChapterId(bookInfo.getLastChapterId())
                .picUrl(bookInfo.getPicUrl())
                .visitCount(bookInfo.getVisitCount())
                .wordCount(bookInfo.getWordCount())
                .build();
    }

    @CacheEvict(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER,
            value = CacheConsts.BOOK_INFO_CACHE_NAME)
    public void evictBookInfoCache(Long ignoredId){}

    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER,
            value = CacheConsts.LAST_UPDATE_BOOK_ID_LIST_CACHE_NAME)
    public List<Long> getLastUpdateIdList(Long categoryId) {
        QueryWrapper<BookInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.BookTable.COLUMN_CATEGORY_ID, categoryId)
                .gt(DatabaseConsts.BookTable.COLUMN_WORD_COUNT, 0)
                .orderByDesc(DatabaseConsts.BookTable.COLUMN_LAST_CHAPTER_UPDATE_TIME)
                .last(DatabaseConsts.SqlEnum.LIMIT_500.getSql());
        return bookInfoMapper.selectList(queryWrapper).stream().map(BookInfo::getId).toList();
    }
}
