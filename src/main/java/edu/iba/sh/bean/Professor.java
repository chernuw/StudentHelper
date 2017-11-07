package edu.iba.sh.bean;


public class Professor {
    private Integer id;
    private String firstName;
    private String secondName;
    private String fatherName;
    private String birthDate;
    private Double avgMark;
    

    public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
    

	public String getBirthDate() {
		return birthDate;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(Double avgMark) {
        this.avgMark = avgMark;
    }

}
