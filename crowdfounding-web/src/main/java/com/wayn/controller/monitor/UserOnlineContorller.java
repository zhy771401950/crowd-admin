package com.wayn.controller.monitor;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wayn.commom.base.BaseControlller;
import com.wayn.commom.util.Response;
import com.wayn.domain.UserOnline;
import com.wayn.framework.util.ShiroUtil;
import com.wayn.service.UserOnlineService;

@RequestMapping("/monitor/online")
@Controller
public class UserOnlineContorller extends BaseControlller {
	private static final String PREFIX = "monitor/online";
	@Autowired
	private UserOnlineService userOnlineService;

	@RequiresPermissions("monitor:online:online")
	@GetMapping
	public String onlineIndex() {
		return PREFIX + "/online";
	}

	@RequiresPermissions("monitor:online:online")
	@ResponseBody
	@PostMapping("/list")
	public List<UserOnline> list(Model model, @RequestBody(required = false) Map<String, Object> params) {
		ShiroUtil.clearCachedAuthorizationInfo();
		return userOnlineService.list();
	}

	@RequiresPermissions("monitor:online:logout")
	@ResponseBody
	@DeleteMapping("/forceLogout/{id}")
	public Response forceLogout(Model model, @PathVariable("id") String id) {
		if (getSessionId().equals(id)) {
			return Response.error("当前登陆用户无法强退");
		}
		userOnlineService.forceLogout(id);
		return Response.success("强制下线用户成功！");

	}

	@RequiresPermissions("monitor:online:logout")
	@ResponseBody
	@PostMapping("/batchForceLogout")
	public Response batchForceLogout(Model model, @RequestParam("ids[]") String[] ids) {
		for (String id : ids) {
			if (getSessionId().equals(id)) {
				return Response.error("当前登陆用户无法强退");
			}
			userOnlineService.forceLogout(id);
		}
		return Response.success("强制下线用户成功！");

	}
}