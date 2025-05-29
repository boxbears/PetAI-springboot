package com.petaiprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petaiprogram.config.URLConfig;
import com.petaiprogram.domain.Petbaseinformation;
import com.petaiprogram.domain.Petbreedsintroduction;
import com.petaiprogram.domain.Pethealthsupplements;
import com.petaiprogram.domain.Recommendedrecipes;
import com.petaiprogram.domain.dto.PageDTO;
import com.petaiprogram.domain.vo.RecommendData;
import com.petaiprogram.domain.vo.RecommendVo;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.PetbaseinformationService;
import com.petaiprogram.service.PetbreedsintroductionService;
import com.petaiprogram.service.PethealthsupplementsService;
import com.petaiprogram.service.RecommendedrecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2023/12/09  14:47
 */
@RestController
@RequestMapping("/miniTest")
public class HomeController {
    //    获取的推荐数据
    ArrayList<RecommendData> arrayList = new ArrayList<>();

    @Autowired
    private PethealthsupplementsService pethealthsupplementsService;

    @Autowired
    private RecommendedrecipesService recommendedrecipesService;

    @Autowired
    private URLConfig urlConfig;

    @GetMapping("/home/getRecommendGoods")
    public ResponseResult getRecommendGoods(@RequestParam(value = "page", required = false) int page, @RequestParam(value = "pageSize", required = false) int pageSize, @RequestParam(value = "subType", required = false) String subType) {

        if (subType == null) {
            arrayList.clear();
            System.out.println("subType为空！");
            System.out.println(getPethealthsupplements(page, pageSize));
            RecommendData<Pethealthsupplements> recommendData1 = getPethealthsupplements(page, pageSize);
            arrayList.add(recommendData1);

            System.out.println(getRecommendedrecipes(page, pageSize));
            RecommendData<Recommendedrecipes> recommendData2 = getRecommendedrecipes(page, pageSize);
            arrayList.add(recommendData2);
        } else {
            int subtype = Integer.parseInt(subType);
            if (subtype == 0) {
                System.out.println("参数标记" + subtype);
                RecommendData<Pethealthsupplements> recommendData = getPethealthsupplements(page, pageSize);
                arrayList.set(0, recommendData);
                System.out.println(arrayList);
            } else if (subtype == 1) {
                System.out.println("参数标记" + subtype);
                RecommendData<Recommendedrecipes> recommendData = getRecommendedrecipes(page, pageSize);
                arrayList.set(1, recommendData);
                System.out.println(arrayList);
            }
        }
        RecommendVo recommendVo = new RecommendVo("推荐模块", arrayList);
        return ResponseResult.ok(recommendVo);
    }

    /**
     * 获取宠物食谱 method
     *
     * @return id+name+分页数据
     */
    public RecommendData<Pethealthsupplements> getPethealthsupplements(int page, int pageSize) {
//      获取宠物食谱的分页数据
        Page<Pethealthsupplements> page1 = pethealthsupplementsService.page(Page.of(page, pageSize));
//        System.out.println("分页数据"+page1.getRecords());
//        System.out.println("当前页码"+page1.getCurrent());
//        System.out.println("一页有多少数据"+page1.getSize());
//        System.out.println("总记录数"+page1.getTotal());
//        System.out.println("总页数"+page1.getPages());

        return new RecommendData<>(1, "宠物食谱", new PageDTO<>(page1.getRecords(), page1.getCurrent(), page1.getSize(), page1.getTotal(), page1.getPages()));
    }

    /**
     * 获取宠物保健品 method
     *
     * @return id+name+分页数据
     */
    public RecommendData<Recommendedrecipes> getRecommendedrecipes(int page, int pageSize) {
//      获取宠物保健品分页数据
        Page<Recommendedrecipes> page2 = recommendedrecipesService.page(Page.of(page, pageSize));
        return new RecommendData<>(2, "保健品推荐", new PageDTO<>(page2.getRecords(), page2.getCurrent(), page2.getSize(), page2.getTotal(), page2.getPages()));
    }

    /**
     * 商品关键词搜索
     */
    @GetMapping("/searchGoods")
    public ResponseResult searchGoodsByKeyWords(@RequestParam("keyword") String keyword) {
        System.out.println(keyword);
        return ResponseResult.ok();
    }

    /**
     * 获取当前用户id下所拥有的所有宠物信息
     */
    @Autowired
    private PetbaseinformationService petbaseinformationService;

    @GetMapping("/AllPetInformation")
    public ResponseResult getAllPetInformation(@RequestParam("masterId") int masterId) {
        System.out.println(masterId);
        QueryWrapper<Petbaseinformation> qw = new QueryWrapper<>();
        qw.eq("masterID", masterId);
        List<Petbaseinformation> petList = petbaseinformationService.list(qw);

        // 添加前缀 baseurl
        String baseurl =  urlConfig.getBaseURL(); // 替换为实际的 baseurl
        petList.forEach(pet -> pet.setPhotourl(baseurl + pet.getPhotourl()));

        return ResponseResult.ok(petList);
    }
    /**
     * 获取指定宠物id的宠物信息
     */

    @GetMapping("/basePetInformation")
    public ResponseResult getBasePetInformation(@RequestParam("id") int id) {
        System.out.println(id);
        System.out.println(id);

        Petbaseinformation pet = petbaseinformationService.getById(id);

        String baseURL = urlConfig.getBaseURL(); // 替换为你的基础URL

        pet.setPhotourl(baseURL+pet.getPhotourl());
        System.out.println( "宠物信息:"+pet);

        return ResponseResult.ok(pet);
    }
    /**
     * 修改宠物的基本信息
     */
    @GetMapping("/setBasePetInformation")
    public ResponseResult setBasePetInformation(@RequestParam("id") int id,@RequestParam("index") int index, @RequestParam("text") String text) {
        System.out.println(index + "+" + text);
        UpdateWrapper<Petbaseinformation> wp = new UpdateWrapper<>();
        wp.eq("id", id);
        /**
         *   index == 1 '修改图片'
         *   index == 2 '修改名字:'
         *   index == 3 '修改出生日期'
         *   index == 4 '点击了性别~'
         *   index == 5 '点击了备注~'
          */
        if (index == 2) {
            wp.set("name", text);
        } else if (index == 3) {
            wp.set("birthday", text);
        } else if (index == 4) {
            wp.set("sex", text);
        } else if (index == 5) {
            wp.set("text", text);
        }
        if (petbaseinformationService.update(wp)) {
            return ResponseResult.ok();
        } else {
            return ResponseResult.error(500, "数据库更新失败");
        }
    }
    /**
     * 删除指定宠物id的宠物信息
     */

    @GetMapping("/deletePetInformation")
    public ResponseResult deletePetInformation(@RequestParam("index") int id) {
        Petbaseinformation petbaseinformation = new Petbaseinformation();
        petbaseinformation = petbaseinformationService.getById(id);
        String originalUrl =petbaseinformation.getPhotourl();
        String baseURL = urlConfig.getBaseURL();
        String newUrl = originalUrl.substring(baseURL.length());
        // 删除本地文件
        String filePath = "src/main/resources/static/" + newUrl; // 替换为你的文件路径
        File file = new File(filePath);
        boolean deletedFromFileSystem = file.delete();

        System.out.println("当前图片删除情况:"+deletedFromFileSystem);
        System.out.println("删除宠物"+id);
        return ResponseResult.ok(petbaseinformationService.removeById(id));
    }
    /**
     * 上传的宠物头像
     */
    @PostMapping("/uploadFile")
    public ResponseResult uploadFile(@RequestParam("id") int id,@RequestParam("file") MultipartFile file) {
        // 处理上传的文件
        if (!file.isEmpty()) {
            try {
                // 将文件路径保存至数据库
                String filePath= saveFileToDatabase(id, file);

                UpdateWrapper<Petbaseinformation> wp = new UpdateWrapper<>();
                wp.eq("id", id);
                wp.set("photoUrl", filePath);
                petbaseinformationService.update(wp);

                // 文件保存成功，可以执行其他操作或返回相应的结果
                return ResponseResult.ok();

            } catch (IOException e) {
                // 处理文件保存失败的异常情况
                e.printStackTrace();

                // 返回文件保存失败的结果
                return ResponseResult.error(500, "错误");
            }
        }

        // 如果没有选择上传文件，则可以返回相应的结果
        return ResponseResult.error(500, "空");
    }


    public String saveFileToDatabase(int id,MultipartFile file) throws IOException {
        // 指定存储文件的目录
        String uploadDir = "src/main/resources/static/";

        // 获取上传文件的原始文件名
        String originalFileName = file.getOriginalFilename();

        // 构造目标文件路径
        Path filePath = Path.of(uploadDir, originalFileName);

        // 将文件保存到目标路径
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("文件名称" + originalFileName);
        System.out.println("宠物id" + id);
        String onlinefilePath = urlConfig.getBaseURL()+originalFileName;
//        https://mfg8uf6pxn2i.ngrok.xiaomiqiu123.top/uploads/

        return originalFileName;
    }
    /**
     * 新增宠物信息
     */

    @PostMapping("/AddNewPet/unload")
    public String AddNewPet(@RequestParam("file") MultipartFile file) throws IOException {

        System.out.println("头像上传");
        String filePath=saveFileToDatabase(-1,file);
        return filePath;
    }

    @PostMapping("/AddNewPet/petInformation")
    public ResponseResult AddNewPetInformation(@RequestBody Petbaseinformation newPet) {
        System.out.println(newPet.toString());
        System.out.println(newPet.getName());
//        往数据库信息宠物数据
        petbaseinformationService.save(newPet);
        System.out.println("信息上传");
        return ResponseResult.ok();
    }
    /**
     * 宠物种类信息库
     *
     */
    @Autowired
    private PetbreedsintroductionService petbreedsintroductionService;
    @GetMapping("/IdentifyPet/petInformation")
    public ResponseResult GetPetInformation(@RequestParam("uid") int uid) {
        System.out.println("宠物的uid:"+uid);
        if (uid==-1){
            return ResponseResult.error(500,"图片识别错误");
        }
        else {
            QueryWrapper<Petbreedsintroduction> qw = new QueryWrapper<>();
            qw.eq("uid",uid);
            System.out.println(petbreedsintroductionService.list(qw));
            return ResponseResult.ok(petbreedsintroductionService.list(qw));
        }
    }
}
