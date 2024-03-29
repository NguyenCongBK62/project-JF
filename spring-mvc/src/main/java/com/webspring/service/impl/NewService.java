package com.webspring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webspring.dto.NewDTO;
import com.webspring.entity.NewEntity;
import com.webspring.repository.NewRepository;
import com.webspring.service.INewService;
@Service
public class NewService implements INewService {
	@Autowired
	private NewRepository newRepository;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		entities.forEach((item) -> { 
			NewDTO newDTO = new NewDTO();
			newDTO.setTitle(item.getTitle());
			newDTO.setShortDescription(item.getShortDescription());
			models.add(newDTO);
		});
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}
//
//	@Override
//	public NewDTO findById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public NewDTO save(NewDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void delete(long[] ids) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}
