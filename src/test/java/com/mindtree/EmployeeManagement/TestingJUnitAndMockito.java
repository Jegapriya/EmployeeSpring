package com.mindtree.EmployeeManagement;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestingJUnitAndMockito {

	public static void main(String [] args)
	{
		Result result=JUnitCore.runClasses(TestSuiteEmployee.class);
		for(Failure failure:result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
