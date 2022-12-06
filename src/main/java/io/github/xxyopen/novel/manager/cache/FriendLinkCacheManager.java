package io.github.xxyopen.novel.manager.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.xxyopen.novel.core.constant.CacheConsts;
import io.github.xxyopen.novel.core.constant.DatabaseConsts;
import io.github.xxyopen.novel.dao.entity.HomeFriendLink;
import io.github.xxyopen.novel.dao.mapper.HomeFriendLinkMapper;
import io.github.xxyopen.novel.dto.resp.HomeFriendLinkRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FriendLinkCacheManager {

    private final HomeFriendLinkMapper homeFriendLinkMapper;

    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value = CacheConsts.HOME_FRIEND_LINK_CACHE_NAME)
    public List<HomeFriendLinkRespDto> listFriendLinks() {
        QueryWrapper<HomeFriendLink> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(DatabaseConsts.CommonColumnEum.SORT.getName());
        return homeFriendLinkMapper.selectList(queryWrapper).stream().map(v -> {
            HomeFriendLinkRespDto respDto = new HomeFriendLinkRespDto();
            respDto.setLinkName(v.getLinkName());
            respDto.setLinkUrl(v.getLinkUrl());
            return respDto;
        }).toList();
    }
}
