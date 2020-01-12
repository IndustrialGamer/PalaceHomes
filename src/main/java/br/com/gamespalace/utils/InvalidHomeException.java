package br.com.gamespalace.utils;

public class InvalidHomeException extends RuntimeException {
    private static final long serialVersionUID = 6163710183399028793L;

    String excName;

    public  InvalidHomeException() {
        super();
    }

    public InvalidHomeException(String s) {

        super(s);

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getExcName() {
        return excName;
    }

    public void setExcName(String excName) {
        this.excName = excName;
    }
}
