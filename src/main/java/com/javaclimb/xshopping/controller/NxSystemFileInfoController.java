package com.javaclimb.xshopping.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.common.Result;
import com.javaclimb.xshopping.entity.NxSystemFileInfo;
import com.javaclimb.xshopping.exception.CustomException;
import com.javaclimb.xshopping.service.NxSystemFileInfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 系统文件增删改查控制器
 * @date 2023/1/14 7:03
 * @see
 */
@RestController
@RequestMapping(value = "/files")
public class NxSystemFileInfoController {

    /**
     * Todo 指定文件的存放目录：即当前用户的目录，并放到指定的静态资源目录下
     */
    private static final String BASE_PATH = System.getProperty("user.dir") + "src/main/resources/static/file";

    @Resource
    private NxSystemFileInfoService nxSystemFileInfoService;

    /**分页查询系统-不再需要/

    /**
     * Todo 上传系统文件：需要实现 MultipartFile 接口
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        if(originalName == null){
            return Result.error("1001", "文件名不能为空");
        }
        //指定上传图片的5种格式
        if(!originalName.contains(".png") && !originalName.contains(".jpg")
                && !originalName.contains(".jpeg") && !originalName.contains(".gif")
                && !originalName.contains(".jfif")){
            return Result.error("1002", "只能上传常规图片");
        }
        //给文件名加个时间戳：原文件名+时间戳+原文件的拓展名
        String fileName = FileUtil.mainName(originalName + System.currentTimeMillis()
                + "." + FileUtil.extName(originalName));
        //Todo 开始上传文件、信息入库并获取文件id
        FileUtil.writeBytes(file.getBytes(), BASE_PATH + fileName);
        NxSystemFileInfo info = new NxSystemFileInfo();
        info.setOriginname(originalName);
        info.setFilename(fileName);
        NxSystemFileInfo addInfo = nxSystemFileInfoService.add(info);
        if(addInfo != null){
            return Result.success(addInfo);
        }
        return Result.error("1003","上传失败");
    }

    /**
     * Todo 下载（图片）文件：输出图片到前端显示
     * @param id
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/{id}")
    public void download(@PathVariable String id, HttpServletResponse response) throws IOException {
        if(StrUtil.isBlank(id) || "null".equals(id)){
            throw new CustomException("1001", "您未上传图片");
        }
        NxSystemFileInfo nxSystemFileInfo = nxSystemFileInfoService.findById(Long.parseLong(id));
        if(nxSystemFileInfo == null){
            throw new CustomException("1002", "没找到该文件");
        }
        byte[] bytes = FileUtil.readBytes(BASE_PATH + nxSystemFileInfo.getFilename());
        response.reset();       //先清缓存
        //Todo 设置 response 的 header
        response.addHeader("Content-Disposition", "attachment;filename=" +
                URLEncoder.encode(nxSystemFileInfo.getOriginname(), "UTF-8"));
        response.addHeader("Content-Length", "" + bytes.length);
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(bytes);
        toClient.flush();
        toClient.close();
    }

    /**
     * 删除系统文件
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        nxSystemFileInfoService.delete(id);

        return Result.success();
    }

    /**
     * 根据 ID 查询一条系统文件
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){

        return Result.success(nxSystemFileInfoService.findById(id));
    }
}
