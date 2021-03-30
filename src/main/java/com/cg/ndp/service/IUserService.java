package com.cg.ndp.service;

import com.cg.ndp.Exception.DuplicateDonorException;
import com.cg.ndp.Exception.UserException;
import com.cg.ndp.model.UserModel;

public interface IUserService {
	UserModel signIn(UserModel user) throws UserException;
	UserModel findById(int userId);
	UserModel add(UserModel user) throws DuplicateDonorException;

}