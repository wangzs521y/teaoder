package com.newer.web.servlet;

import com.newer.domain.TeaOder;
import com.newer.service.TeaOderService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/tea")
public class TeaOderServlet extends HttpServlet {
    private TeaOderService teaOderService;

    @Override
    public void destroy() {
        teaOderService.close();
    }

    @Override
    public void init() throws ServletException {
        teaOderService=new TeaOderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeaOder teaOder=new TeaOder();
        try {
            BeanUtils.populate(teaOder,req.getParameterMap());
            int rows=teaOderService.addOder(teaOder);
            PrintWriter out=resp.getWriter();
            out.print(rows);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

