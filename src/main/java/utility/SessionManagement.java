package utility;

public class SessionManagement {

    private SessionManagement(){}
    private String session;
    private static  SessionManagement sessionHolder= new SessionManagement();

    public static SessionManagement getInstance(){
      return sessionHolder;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

}
