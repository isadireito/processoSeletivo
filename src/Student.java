package src;


public class Student {
    private String name;
    private String studentId;
    private String phone;
    private String email;
    private String uffMail;
    private String status;

    public Student(String name, String studentId, String phone, String email, String uffMail, String status){
        this.name = name;
        this.studentId = studentId;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public Boolean canCreateUffMail(){
        return (this.status.equalsIgnoreCase("Ativo") && this.uffMail == null );

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUffMail() {
        return uffMail;
    }

    public void setUffMail(String uffMail) {
        this.uffMail = uffMail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    


}
