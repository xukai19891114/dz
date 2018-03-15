package com.xuxu.service;

import com.xuxu.dto.AdDto;

/**
 * 广告服务接口
 * @author 许
 *
 */
public interface AdService {
	/**
	 * 添加广告
	 * @param adDto
	 * @return true 添加成功，false添加失败
	 */
	public boolean insert(AdDto adDto);
}
