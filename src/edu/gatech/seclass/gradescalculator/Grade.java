package edu.gatech.seclass.gradescalculator;

import java.util.Map;


public class Grade {
	private String _gtid;
	private Double _attendance;
	private Map<String,Double> _grade;
	private Map<String,Double> _contribs;

	public Grade(String gtid, Double attendance) { //, Map<String,Double> grade, Map<String,Double> contribs) {
		_gtid = gtid;
		_attendance = attendance;
		//_grade = grade;
		//_contribs = contribs;
	}
}
