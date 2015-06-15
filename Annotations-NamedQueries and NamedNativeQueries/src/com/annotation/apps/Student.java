package com.annotation.apps;

import javax.persistence.*;

@Entity
@Table(name = "Student")
// @NamedQueries({@NamedQuery(name="p1",
// query="from Student st where st.sno>=10"),@NamedQuery(name="p2",query=" from Student st")})
@NamedNativeQueries({
		@NamedNativeQuery(name = "p1", query = "select * from Student st where st.sno>=1", resultClass = Student.class),
		@NamedNativeQuery(name = "p2", query = " select * from Student st", resultClass = Student.class) })
class Student {
	int sno;
	String sname;
	String addr;

	public void setSno(Integer x) {
		sno = x;
	}

	@Id
	@Column(name = "sno")
	public Integer getSno() {
		return sno;
	}

	public void setSname(String y) {
		sname = y;
	}

	@Column(name = "sname")
	// @Transient
	public String getSname() {
		return sname;
	}

	public void setAddr(String z) {
		addr = z;
	}

	@Column(name = "addr")
	// @Transient
	public String getAddr() {
		return addr;
	}
}
