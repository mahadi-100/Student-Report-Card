package records;

public class RecordInfo {
    private String name;
    private String ID;
    private int marks;

    public RecordInfo(String name, String ID, int marks) {
        this.name = name;
        this.ID = ID;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
