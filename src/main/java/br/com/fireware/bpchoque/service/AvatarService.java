package br.com.fireware.bpchoque.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.fireware.bpchoque.entity.Avatar;
import br.com.fireware.bpchoque.repository.AvatarRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AvatarService {

	
	private static final Logger LOG = Logger.getLogger(AvatarService.class);
	
	@Autowired
	private AvatarRepository repository;
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(Avatar avatar){
		
		repository.save(avatar);
		
		
	}
	
	
	public Avatar findById(Long id) {
	
		return repository.findOne(id);
	}
	
	
	
	
	public Avatar getAvatarByUpload(MultipartFile file){
		
		Avatar avatar = new Avatar();
		
		if(file != null && file.getSize() > 0){
			try {
				avatar.setTitulo(file.getOriginalFilename());
				avatar.setTipo(file.getContentType());
				avatar.setAvatar(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOG.error("Aconteceu um erro em AvatarService"+ e.getMessage());
			}
		}
		return avatar; 
		
		
	}



}
