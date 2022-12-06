package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.ImgVerifyCodeRespDto;
import io.github.xxyopen.novel.core.common.resp.RestResp;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ResourceService {

    RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException;

    RestResp<String> uploadImage(MultipartFile file) throws IOException;
}
