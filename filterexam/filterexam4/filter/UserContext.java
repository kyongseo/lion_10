package hello.filter.filterexam4.filter;


import hello.filter.filterexam4.entity.User;

/**
 * ThreadLocal 을 이용해서 필요한 정보를 저장 하는데,
 * ThreadLocal 을 가지고 있는 객체 -- UserContext
 * ThreadLocal 에 유저에 대한 값을 넣어줌 -- 필터에서 넣어줬음
 * 컨트롤러에서 사용 가능
 */
public class UserContext {
    private static final ThreadLocal<User> USER_THREAD_LOCAL = ThreadLocal.withInitial(()->null);

    public static void setUser(User user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static User getUser() {
        return USER_THREAD_LOCAL.get();
    }

    public static void clear() {
        USER_THREAD_LOCAL.remove();
    }
}