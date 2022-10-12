package com.example.springboot.service.sadelite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.sadelite.ShareHolderMapper;
import com.example.springboot.model.ShareHolder;

@Service
public class HolderServiceImpl implements HolderService {

	private ShareHolderMapper shareHolderMapper;

	@Autowired
	public HolderServiceImpl(ShareHolderMapper shareHolderMapper) {
		this.shareHolderMapper = shareHolderMapper;
	}

	@Override
	public ShareHolder buscarUno(long id) {
		ShareHolder accionista = new ShareHolder();
		accionista = shareHolderMapper.findSingleHolderById(id).get();
		return accionista;
	}
	
	
	
}
