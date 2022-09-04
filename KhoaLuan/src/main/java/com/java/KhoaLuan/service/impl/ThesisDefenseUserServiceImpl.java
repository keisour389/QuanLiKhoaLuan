package com.java.KhoaLuan.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.java.KhoaLuan.config.Constant;
import com.java.KhoaLuan.domain.ThesisDefenseUser;
import com.java.KhoaLuan.enums.ThesisDefenseRole;
import com.java.KhoaLuan.repository.ThesisDefenseUserRepository;
import com.java.KhoaLuan.repository.UserRepository;
import com.java.KhoaLuan.service.ThesisDefenseUserService;
import com.java.KhoaLuan.utils.SendEmailUtil;

@Service
@Transactional
public class ThesisDefenseUserServiceImpl implements ThesisDefenseUserService {
	
	private final ThesisDefenseUserRepository thesisDefenseUserRepository;
	
	private final UserRepository userRepository;
	
	public ThesisDefenseUserServiceImpl(ThesisDefenseUserRepository thesisDefenseUserRepository,
			UserRepository userRepository) {
		this.thesisDefenseUserRepository = thesisDefenseUserRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void createThesisDefenseUsers(Iterable<ThesisDefenseUser> thesisDefenseUsers) {
		thesisDefenseUserRepository.saveAll(thesisDefenseUsers);
		for (ThesisDefenseUser thesisDefenseUser : thesisDefenseUsers) {
			// Send email to counter argument
			if (thesisDefenseUser.getRole().equals(ThesisDefenseRole.ROLE_COUNTER_ARGUMENT)) {
				String emailTo = userRepository.findById(thesisDefenseUser.getUserId()).get().getEmail();
				SendEmailUtil.sendEmail(Constant.SUBJECT,
						String.format(Constant.CONTENT, thesisDefenseUser.getThesisDefenseId()),
						emailTo);
			}
		}		
	}
}
