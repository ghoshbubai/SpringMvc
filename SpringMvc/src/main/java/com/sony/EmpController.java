package com.sony;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	
	@Autowired
	EmployeeDao dao;
	
	@RequestMapping("addEmployee")
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("index");
		}
		dao.addEmployee(employee);
		
		ModelAndView mv=new ModelAndView();
		System.out.println(employee);
		
		mv.addObject("emp",employee);
		mv.setViewName("empDetails");
		
		return mv;
	}

}
