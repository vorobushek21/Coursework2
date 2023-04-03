package task;

public enum Type {
    WORK("Рабочая"),
    PERSONAL("Личная");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
}
