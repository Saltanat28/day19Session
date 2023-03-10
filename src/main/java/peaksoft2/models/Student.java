package peaksoft2.models;

public class Student {
    private Long id;
    private String name;
    private byte age;

    public Student(Long id, String name, byte age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
