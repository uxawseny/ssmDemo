package com.demo1.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo1.entity.Area;
import com.demo1.entity.City;
import com.demo1.service.PC;

/**
 * 控制层
 */

@Controller
@RequestMapping("/")
public class PCAction {

	@Autowired
	PC service;// 调用业务层方法

	// 查询所有省位
	@RequestMapping("/showProvinceList")
	public String showProvinceList(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("proList", service.showProvinceList());// 存入作用域中
		return "/index.jsp";

	}

	// 根据ajax返回到控制器的省id来查询相对应的城市名
	@RequestMapping("/showCityListByPid")
	public void showCityListByPid(HttpServletRequest request, HttpServletResponse response, int pid) throws IOException {

		response.setContentType("text/html;charset=UTF-8");
		System.out.println(pid);// 打印前台ajax传来的省id
		List<City> city = service.showCityListByPid(pid);
		JSONArray json = JSONArray.fromObject(city);// 将集合转化为json格式
		response.getWriter().print(json.toString());
		response.getWriter().flush();
		response.getWriter().close();

	}

	// 根基ajax返回到控制器的城市id来查询相对应的区、县
	@RequestMapping("/showTownListByCid")
	public void showTownListByCid(HttpServletRequest request, HttpServletResponse response, int cid) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println(cid);// 打印前台ajax传来的城市id
		List<Area> area = service.showAreaListBycid(cid);
		JSONArray json = JSONArray.fromObject(area);// 将集合转化为json格式
		response.getWriter().print(json.toString());
		response.getWriter().flush();
		response.getWriter().close();

	}
}
