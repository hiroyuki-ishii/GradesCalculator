package edu.gatech.seclass.gradescalculator;

public class Student {
	private String _name;
	private Object _gtid;
	private String _email;
	
	public Student(String name, Object gtid, String email) {
		_name = name;
		_gtid = gtid;
		_email = email;
	}
		
	public String getName() {
		// TODO Auto-generated method stub
		return _name;
	}

	public Object getGtid() {
		// TODO Auto-generated method stub
		return _gtid;
	}

	public Object getAttendance() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getTeam() {
		// TODO Auto-generated method stub
		return null;
	}


}
