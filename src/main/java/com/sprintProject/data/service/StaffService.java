package com.sprintProject.data.service;

import java.util.List;

import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.entity.Store;

public interface StaffService {
	public List<Staff> getStaffByLastname(String ln);

    public List<Staff> getStaffByFirstname(String fn);

    public List<Staff> getStaffByEmail(String email);

    public List<Staff> getStaffByCity(String city);

    public List<Staff> getStaffByCountry(String country);

    public List<Staff> getStaffByPhoneNumber(String phone);
    
    public Staff updateStaffByFirstName(int id,Staff staff);
    Staff updateLastNameOfStaff(int StaffId , Staff Staff);

    Staff updateEmailOfStaff(int StaffId , Staff Staff);
    public Staff createStaff(Staff staff);

}
