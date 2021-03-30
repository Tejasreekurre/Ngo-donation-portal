package com.cg.ndp.service;

import java.util.List;

import com.cg.ndp.Exception.DuplicateDonorException;
import com.cg.ndp.Exception.NoSuchDonorException;
import com.cg.ndp.entity.DonorEntity;
import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;

public interface IDonorService {
	DonorModel getById(int donorId) throws NoSuchDonorException;

	boolean login(DonorModel donor) throws NoSuchDonorException;

	DonorModel add(DonorModel donor) throws DuplicateDonorException;

	List<DonationModel> getAllDonations(int donorId) throws NoSuchDonorException;

	boolean existsById(int donorId);

	DonorModel modifyPassword(DonorModel donorModel, int donorId) throws NoSuchDonorException;

}
