package club.banyuan.mall.Controller;

import club.banyuan.mall.common.api.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    public CommonResult upload(@RequestParam("file")MultipartFile file) throws IOException {
        if (file.isEmpty()){
            //return "文件不存在，请重新上传";
        }

        return CommonResult.success("OK");
    }
}
