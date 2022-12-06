package io.github.xxyopen.novel.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.xxyopen.novel.dao.entity.BookInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xxyopen.novel.dto.req.BookSearchReqDto;
import io.github.xxyopen.novel.dto.resp.BookInfoRespDto;

import java.util.List;

/**
 * <p>
 * 小说信息 Mapper 接口
 * </p>
 *
 * @author lxx
 * @since 2022/11/30
 */
public interface BookInfoMapper extends BaseMapper<BookInfo> {

    List<BookInfo> searchBooks(IPage<BookInfoRespDto> page, BookSearchReqDto condition);

}
