package org.theme.web.controller;

import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkController {

	@Autowired
	private RepositoryService repositoryService;

	@RequestMapping(value = "/deploy")
	public String deploy() {
		repositoryService.createDeployment().addClasspathResource("diagrams/Leave.bpmn")
				.addClasspathResource("diagrams/Leave.png").deploy();
		return "deploy/detail";
	}
}
