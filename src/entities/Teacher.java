package entities;

public class Teacher extends Entity {
    private String teacherName;
    private String department;

    @Override
    public String toString() {
        return "Teacher{ id= " + id + " TeacherName=" + teacherName + ", department=" + department +"}";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
