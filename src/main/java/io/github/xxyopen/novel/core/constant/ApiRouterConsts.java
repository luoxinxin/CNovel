package io.github.xxyopen.novel.core.constant;

public class ApiRouterConsts {

    private ApiRouterConsts() { throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);}

    public static final String API_URL_PREFIX = "/api";

    public static final String API_AUTHOR_URL_PREFIX = API_URL_PREFIX + "/author";

    public static final String API_FRONT_URL_PREFIX = API_URL_PREFIX + "/front";

    public static final String USER_URL_PREFIX = "/user";

    public static final String SEARCH_URL_PREFIX = "/search";
    public static final String HOME_URL_PREFIX = "/home";

    public static final String NEWS_URL_PREFIX = "/news";

    public static final String RESOURCE_URL_PREFIX = "/resources";

    public static final String BOOK_URL_PREFIX = "/book";

    public static final String API_FRONT_USER_URL_PREFIX = API_FRONT_URL_PREFIX + USER_URL_PREFIX;

    public static final String API_FRONT_SEARCH_URL_PREFIX = API_FRONT_URL_PREFIX + SEARCH_URL_PREFIX;

    public static final String API_FRONT_HOME_URL_PREFIX = API_FRONT_URL_PREFIX + HOME_URL_PREFIX;


    public static final String API_FRONT_NEWS_URL_PREFIX = API_FRONT_URL_PREFIX + NEWS_URL_PREFIX;

    public static final String API_FRONT_RESOURCE_URL_PREFIX = API_FRONT_URL_PREFIX + RESOURCE_URL_PREFIX;

    public static final String API_FRONT_BOOK_URL_PREFIX = API_FRONT_URL_PREFIX + BOOK_URL_PREFIX;

    public static final String API_ADMIN_URL_PREFIX = API_URL_PREFIX + "/admin";

}
