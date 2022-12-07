package io.github.xxyopen.novel.core.constant;

public class CacheConsts {

    public static final String REDIS_CACHE_MANAGER = "redisCacheManager";

    public static final String CAFFEINE_CACHE_MANAGER = "caffeineCacheManager";

    public static final String HOME_BOOK_CACHE_NAME = "homeBookCache";

    public static final String LATEST_NEWS_CACHE_NAME = "latestNewsCache";

    public static final String REDIS_CACHE_PREFIX = "Cache::Novel::";

    public static final String USER_INFO_CACHE_NAME = "userInfoCache";

    public static final String AUTHOR_INFO_CACHE_NAME = "authorInfoCache";

    public static final String HOME_FRIEND_LINK_CACHE_NAME = "homeFriendLinkCache";

    public static final String IMG_VERIFY_CODE_CACHE_KEY = REDIS_CACHE_PREFIX + "imgVerifyCodeCache::";

    public static final String BOOK_CATEGORY_LIST_CACHE_NAME = "bookCategoryListCache";

    public static final String BOOK_INFO_CACHE_NAME = "bookInfoCache";

    public static final String BOOK_CHAPTER_CACHE_NAME = "bookChapterCache";

    public static final String BOOK_CONTENT_CACHE_NAME = "bookContentCache";

    public static final String LAST_UPDATE_BOOK_ID_LIST_CACHE_NAME = "lastUpdateBookIdListCache";

    public static final String BOOK_VISIT_RANK_CACHE_NAME = "bookVisitRankCache";

    /**
     * 小说新书榜缓存
     */
    public static final String BOOK_NEWEST_RANK_CACHE_NAME = "bookNewestRankCache";

    /**
     * 小说更新榜缓存
     */
    public static final String BOOK_UPDATE_RANK_CACHE_NAME = "bookUpdateRankCache";
    public enum CacheEnum {

        USER_INFO_CACHE(2, USER_INFO_CACHE_NAME, 60 * 60 * 24, 10000);
        private int type;

        private String name;

        private int ttl;

        private int maxSize;


        CacheEnum(int type, String name, int ttl, int maxSize) {
            this.type = type;
            this.name = name;
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        public boolean isLocal() {
            return type <= 1;
        }

        public boolean isRemote() {
            return type >=1;
        }

        public String getName() {
            return name;
        }

        public int getTtl() {
            return ttl;
        }

        public int getMaxSize() {
            return maxSize;
        }
    }
}
