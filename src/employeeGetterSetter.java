public class employeeGetterSetter {

    private int Id;
    private String EmpName;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String geEmptName() {
        return EmpName;
    }

    public void setName(String Empname) {
        this.EmpName = Empname;
    }

    @Override
    public String toString() {
        return "employeeGetterSetter{" +
                "Id=" + Id +
                ",Emp name='" + EmpName + '\'' +
                '}';
    }
}