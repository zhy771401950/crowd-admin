package com.wayn.web.controller.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.wayn.commom.base.BaseControlller;
import com.wayn.commom.domain.Config;
import com.wayn.commom.service.ConfigService;
import com.wayn.commom.util.ParameterUtil;
import com.wayn.commom.util.Response;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 参数配置 控制层
 *
 * @author wayn
 * @date 2020-09-16
 */
@RequestMapping("/web/config")
@Controller
public class ConfigController extends BaseControlller {

    private static final String PREFIX = "web/config";

    @Autowired
    private ConfigService configService;

    @RequiresPermissions("web:config:list")
    @GetMapping
    public String ConfigIndex() {
        return PREFIX + "/config";
    }

    @RequiresPermissions("web:config:list")
    @ResponseBody
    @PostMapping("/list")
    public Page<Config> list(Model model, Config config) {
        Page<Config> page = getPage();
        ParameterUtil.set(config);
        return configService.selectConfigList(page, config);
    }

    @RequiresPermissions("web:config:add")
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        return PREFIX + "/add";
    }

    @RequiresPermissions("web:config:edit")
    @GetMapping("/edit/{id}")
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Config config = configService.selectById(id);
        modelMap.put("config", config);
        return PREFIX + "/edit";
    }

    @RequiresPermissions("web:config:add")
    @ResponseBody
    @PostMapping("/addSave")
    public Response addSave(ModelMap modelMap, Config config) {
        configService.save(config);
        return Response.success("新增成功");
    }

    @RequiresPermissions("web:config:edit")
    @ResponseBody
    @PostMapping("/editSave")
    public Response editSave(ModelMap modelMap, Config config) {
        configService.update(config);
        return Response.success("修改成功");
    }


    @RequiresPermissions("web:config:remove")
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    public Response remove(ModelMap modelMap, @PathVariable("id") Integer id) {
        configService.remove(id);
        return Response.success("删除成功");
    }

    @RequiresPermissions("web:config:remove")
    @ResponseBody
    @PostMapping("/batchRemove")
    public Response batchRemove(ModelMap modelMap, @RequestParam("ids[]") Integer[] ids) {
        configService.batchRemove(ids);
        return Response.success("删除成功");
    }

}