package com.cg.ndp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ndp.entity.DonationEntity;
import com.cg.ndp.entity.DonationItemEntity;
import com.cg.ndp.entity.DonationType;
import com.cg.ndp.entity.DonorEntity;
import com.cg.ndp.entity.UserEntity;
import com.cg.ndp.model.DonationItemModel;
import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;
import com.cg.ndp.model.UserModel;
import com.cg.ndp.repo.DonationItemRepo;
import com.cg.ndp.repo.DonationRepo;
import com.cg.ndp.repo.DonorRepo;


@Service
public class EMParser {
	@Autowired
	private DonorRepo donorRepo;
	
	@Autowired
	private DonationItemRepo donationItemRepo;
	@Autowired
	private DonationRepo donationRepo;
	
	public DonationModel parse(DonationEntity source) {
		return source==null?null:
			new DonationModel(source.getDonationId(),
					source.getDonor().getDonorId(),
					source.getItemz().getItemId(),
					source.getDonationAmount(),
					source.getDonationDate(),
			       
					String.valueOf(source.getDonationType())
					
					);
	}
	
	public DonationEntity parse(DonationModel source) {
		return source== null?null:
			new DonationEntity(source.getDonationId(),
					donorRepo.findById(source.getDonorId()).orElse(null),
					donationItemRepo.findById(source.getItemId()).orElse(null),
					source.getDonationAmount(),
					source.getDonationDate(),
					DonationType.valueOf(source.getDonationType())
				);
	}
	
	public DonationItemEntity parse(DonationItemModel source) {
		return source==null?null:
			new DonationItemEntity(source.getItemId(),
					DonationType.valueOf(source.getItem()),
					source.getItemDescription()
					);
	}
	public DonationItemModel parse(DonationItemEntity source) {
		return source == null?null:
			new DonationItemModel(source.getItemId(),
					String.valueOf(source.getItem()),
					source.getItemDescription()
					);
	}
	
	public DonorEntity parse(DonorModel source) {
		return source==null?null:
			new DonorEntity(source.getDonorId(),
					source.getDonorName(),
					source.getDonorEmail(),
					source.getDonorPhone(),
					source.getDonorUsername(),
					source.getDonorPassword(),
					source.getAddress()
					);
	}
	public DonorModel parse(DonorEntity source) {
		return source==null?null:
			new DonorModel(source.getDonorId(),
					source.getDonorName(),
					source.getDonorEmail(),
					source.getDonorPhone(),
					source.getDonorUsername(),
					source.getDonorPassword(),
					source.getAddress()
					);
	}
	public UserModel parse(UserEntity source) {
		return source==null?null:
			new UserModel(source.getDonorId(),source.getPassword(),source.getRole());
		
	}
	public UserEntity parse(UserModel source) {
		return source==null?null:
			new UserEntity(source.getUserId(),source.getPassword(),source.getRole());
		
	}
	
}
