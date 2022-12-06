package io.github.xxyopen.novel.core.constant;

import io.github.xxyopen.novel.dao.entity.UserInfo;
import lombok.Getter;

public class DatabaseConsts {

    public static class AuthorInfoTable {
        private AuthorInfoTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        public static final String COLUMN_USER_ID = "user_id";
    }

    public static class BookTable {
        private BookTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }
        public static final String COLUMN_CATEGORY_ID = "category_id";
        public static final String COLUMN_BOOK_NAME = "book_name";
        public static final String COLUMN_AUTHOR_ID = "author_id";
        public static final String COLUMN_VISIT_COUNT = "visit_count";
        public static final String COLUMN_WORD_COUNT = "word_count";
        public static final String COLUMN_LAST_CHAPTER_UPDATE_TIME = "last_chapter_update_time";
    }

    public static class BookChapterTable {
        private BookChapterTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }
        public static final String COLUMN_BOOT_ID = "book_id";
        public static final String COLUMN_CHAPTER_NUM = "chapter_num";
    }

    public static class NewsContentTable {
        private NewsContentTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        public static final String COLUMN_NEWS_ID = "news_id";
    }

    public static class UserInfoTable {
        private UserInfoTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        public static final String COLUMN_USERNAME = "username";
    }

    public static class UserFeedBackTable {
        private UserFeedBackTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        public static final String COLUMN_USER_ID = "user_id";
    }

    public static class BookCommentTable {

        private BookCommentTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        public static final String COLUMN_BOOK_ID = "book_id";

        public static final String COLUMN_USER_ID = "user_id";

    }


    @Getter
    public enum SqlEnum {
        LIMIT_1("limit 1"),
        LIMIT_2("limit 2"),
        LIMIT_5("limit 5"),
        LIMIT_30("limit 30"),
        LIMIT_500("limit 500");

        private String sql;

        SqlEnum(String sql) {
            this.sql = sql;
        }
    }
    @Getter
    public enum CommonColumnEum {
        ID("id"),
        SORT("sort"),
        CREATE_TIME("create_time"),
        UPDATE_TIME("update_time");
        private String name;
        CommonColumnEum(String name) {
            this.name = name;
        }
    }
}
