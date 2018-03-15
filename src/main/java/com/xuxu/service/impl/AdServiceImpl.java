package com.xuxu.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xuxu.bean.Ad;
import com.xuxu.dao.AdDao;
import com.xuxu.dto.AdDto;
import com.xuxu.service.AdService;

@Service
public class AdServiceImpl implements AdService{
	@Autowired
	private AdDao adDao;
	@Value("${adImage.savePath}")
	private String adImageSavePath;
	
	//添加广告
	@Override
	public boolean insert(AdDto adDto) {
		Ad ad = new Ad();
		ad.setTitle(adDto.getTitle());
		ad.setLink(adDto.getLink());
		ad.setWeight(adDto.getWeight());
		String fileName = System.currentTimeMillis()+"_"+adDto.getImgFile().getOriginalFilename();
		File file = new File(adImageSavePath+fileName);
		//判断是否传入空文件
		if(adDto.getImgFile()!=null && adDto.getImgFile().getSize()>0){
			File folder = new File(adImageSavePath);
			//判断是否存在存放文件夹
			if(!folder.exists()){
				folder.mkdirs();
			}
			try {
				adDto.getImgFile().transferTo(file);
				ad.setImgFileName(fileName);
				adDao.insert(ad);
				return true;
			} catch (IllegalStateException | IOException e) {
				return false;
			}
		}else{
			return false;
		}
	}
}
