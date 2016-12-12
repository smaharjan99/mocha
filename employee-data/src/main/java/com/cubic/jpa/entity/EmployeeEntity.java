package com.cubic.jpa.entity;

import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")

public class EmployeeEntity {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "employeeSeq", sequenceName = "EMPLOYSEQ", allocationSize = 1)
	@GeneratedValue(generator = "employeeSeq")
	private Long pk;

	@Column(name = "NAME")
	private String name;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "AGE")
	private int age;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "SALARY")
	private int salary;

	@Column(name = "DEPARTMENT")
	private String department;

	private int editNum;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEditNum() {
		return editNum;
	}

	public void setEditNum(int editNum) {
		this.editNum = editNum;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [pk=" + pk + ", name=" + name + ", gender=" + gender + ", age=" + age + ", address="
				+ address + ", salary=" + salary + ", department=" + department + "]";
	}

	public void menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("What do you wanna do?\n1.Add\n2.Update\n3.Delete\n4.Search\n5.Display\n6.EXIT");
		System.out.print("Your Choice - ");
		editNum = input.nextInt();
		// choice = editNum;

	}

	public void addData() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Name");
		name = input.nextLine();

		System.out.print("Enter gender - ");
		gender = input.next();

		System.out.print("Enter age - ");
		age = input.nextInt();

		System.out.print("Enter address- ");
		address = input.next();

		System.out.print("Enter salary - ");
		salary = input.nextInt();

		System.out.print("Enter department - ");
		department = input.next();

	}

	public void updateData() {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter ID - ");
		pk = input.nextLong();

		System.out.println("Enter Name - ");
		name = input.nextLine();

		System.out.print("Enter gender - ");
		gender = input.next();

		System.out.print("Enter age - ");
		age = input.nextInt();

		System.out.print("Enter address- ");
		address = input.next();

		System.out.print("Enter salary - ");
		salary = input.nextInt();

		System.out.print("Enter department - ");
		department = input.next();
	}

	public void removeData() {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter ID - ");
		pk = input.nextLong();
	}

}
