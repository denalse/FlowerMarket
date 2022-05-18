package nus.project.BeerMarket.repository;

public interface Queries {
    
    //POSTING, Save post into databse
    public static final String SQL_INSERT_POST =
    "insert into post(photo, comment, poster, mediatype) values (?, ?, ?, ?)";

    public static final String SQL_GET_POST_BY_POST_ID =
    "select photo, comment, poster, mediatype, post_id from post where post_id = ?";
    
    //GET all post
    
    //Posting, saving file
    public static final String SQL_GET_POST_IMAGES =
    "select * from post";

    //getting image from admin (me)
    public static final String SQL_GET_IMAGE_BY_ID =
    "select * from admin where image_id = ?";
    
    
    //LOGIN, Save user into database
    public static final String SQL_INSERT_USER =
    "insert into user(username, password) values (?, ?)";

    public static final String SQL_GET_USER_BY_USERNAME = 
    "select * from user where username = ?";

    //username and password authenticate/verify
    public static final String SQL_AUTHENTICATE_USER =
    "select count(*) as user_count from user where username = ? and password = ?";
    
    // "select count(*) as user_count from user where username='${username}' and password='${password}'";
    // "select * from user where username="${username}" and password="${password}"";
    //"select * from user where password = '....' and username = '...'";
}