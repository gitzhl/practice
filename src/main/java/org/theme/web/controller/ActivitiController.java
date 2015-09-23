package org.theme.web.controller;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivitiController {

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;
	/**
	 * @see 部署流程
	 * @return
	 */
	@RequestMapping(value = "/deploy")
	public String deploy() {
		repositoryService.createDeployment().addClasspathResource("diagrams/Leave.bpmn")
				.addClasspathResource("diagrams/Leave.png").deploy();
		return "deploy/detail";
	}
	/**
	 * @see 开始流程实例
	 * @return
	 */
	@RequestMapping(value = "/start")
	public String start(){
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("");
		return "start/result";
	}
}
