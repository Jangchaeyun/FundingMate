package com.fund.fundingmate;

import com.fund.fundingmate.domain.payment.dto.InvestPeopleDTO;
import com.fund.fundingmate.domain.payment.dto.PaymentDTO;
import com.fund.fundingmate.domain.payment.repository.InvestPeopleRepository;
import com.fund.fundingmate.domain.payment.repository.PaymentRepository;
import com.fund.fundingmate.domain.payment.service.InvestPeopleService;
import com.fund.fundingmate.domain.payment.service.PaymentService;
import com.fund.fundingmate.domain.reward.dto.*;
import com.fund.fundingmate.domain.reward.repository.RewardCommentRepository;
import com.fund.fundingmate.domain.reward.repository.RewardRepository;
import com.fund.fundingmate.domain.reward.service.RewardCommentService;
import com.fund.fundingmate.domain.reward.service.RewardService;
import com.fund.fundingmate.domain.user.repository.UserRepository;
import com.fund.fundingmate.domain.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FundingmateApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RewardService rewardService;

	@Autowired
	private RewardCommentService rewardCommentService;

	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private RewardCommentRepository rewardCommentRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private InvestPeopleRepository investPeopleRepository;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void insertMember() {
		User user = new User();

		user.setBirthday("2000/11/12");
		user.setEmail("sally1112@naver.com");
		user.setUserid("sally1112");
		user.setName("장채리");
		user.setNotificationStatus("N");
		user.setPassword("123421");
		user.setTel("010-1233-2456");
		user.setVitalization(1);

		userRepository.save(user);
	}

	@Test
	void insertReward() {
		Long targetUserId = 1L;

		Optional<User> userOptional = userRepository.findById(targetUserId);
		if(userOptional.isEmpty()) {
			System.out.println("User not found with ID: " + targetUserId);
			return;
		}

		User user = userOptional.get();

		RewardDTO rewardDTO = new RewardDTO();
		rewardDTO.setProjName("My Project");
		rewardDTO.setProjTargetAmout(10000);
		rewardDTO.setProjDateStart(LocalDate.of(2023, 6, 6));
		rewardDTO.setProjDateEnd(LocalDate.of(2023, 7, 6));
		rewardDTO.setRewardRepImgSavedName("project_image.jpg");
		rewardDTO.setProjKeyWord("technology, innovation");
		rewardDTO.setRewardVideoAddress("https://www.youtube.com/watch?v=abcd1234");
		rewardDTO.setRewardContentImgSavedName("content_image.jpg");
		rewardDTO.setProjContent("Project content goes here");
		rewardDTO.setRewardRefundExchangePolicy("Refund and exchange policy details");
		rewardDTO.setRewardContact("Contact information");
		rewardDTO.setRewardEmail("reward@example.com");
		rewardDTO.setRewardCategory("Technology");
		rewardDTO.setModelName("Model X");
		rewardDTO.setCountryOfOrigin("United States");
		rewardDTO.setManufacturer("Tesla Inc.");
		rewardDTO.setAsPhoneNumber("123-456-7890");
		rewardDTO.setRewardIdBusinessLicenseImgSavedName("business_license_image.jpg");
		rewardDTO.setBusinessAddress("Business address");
		rewardDTO.setBank("Bank name");
		rewardDTO.setAccNumber("1234567890");
		rewardDTO.setDepositorName("Depositor name");
		rewardDTO.setRewardBankAccountCopyImgSavedName("bank_account_copy_image.jpg");
		rewardDTO.setTaxBillEmail("tax@example.com");
		rewardDTO.setWebsiteUrl("https://www.example.com");
		rewardDTO.setFacebookUrl("https://www.facebook.com/example");
		rewardDTO.setInstagramUrl("https://www.instagram.com/example");
		rewardDTO.setBlogUrl("https://www.example.com/blog");
		rewardDTO.setTwitterUrl("https://twitter.com/example");

		// Create reward type DTOs
		List<RewardTypeDTO> rewardTypeDTOs = new ArrayList<>();
		RewardTypeDTO rewardTypeDTO = new RewardTypeDTO();
		rewardTypeDTO.setRewardAmount(500);
		rewardTypeDTO.setRewardAvailableLimit(true);
		rewardTypeDTO.setRewardAvailableCount(5);
		rewardTypeDTO.setRewardTitle("Reward Type 1");
		rewardTypeDTO.setRewardContent("Reward Type 1 Content");
		// Set other properties of the rewardTypeDTO

		// Create reward option DTO
		RewardOptionDTO rewardOptionDTO = new RewardOptionDTO();
		rewardOptionDTO.setRewardOptName("Option 1");
		rewardOptionDTO.setRewardOptCon("Option 1 Content");
		rewardTypeDTO.setRewardOption(rewardOptionDTO);

		rewardTypeDTOs.add(rewardTypeDTO);
		rewardDTO.setRewardTypes(rewardTypeDTOs);

		Long userId = user.getId();

		rewardService.createReward(rewardDTO, userId);
	}

	@Test
	void insertRewardComment() {
		Long rewardId = 1L;
		Long userId = 1L;

		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isEmpty()) {
			System.out.println("User not found with ID: " + userId);
			return;
		}

		User user = userOptional.get();

		RewardCommentDTO rewardCommentDTO = new RewardCommentDTO();
		rewardCommentDTO.setComTitle("My Comment Title");
		rewardCommentDTO.setComContent("My Comment Content");

		RewardDTO rewardDTO = new RewardDTO();
		rewardDTO.setId(rewardId);

		rewardCommentDTO.setReward(rewardDTO);
		rewardCommentDTO.setUser(user.toDTO());

		rewardCommentService.insertRewardComment(rewardCommentDTO);
	}

	@Test
	void insertRewardCommentReply() {
		Long rewardId = 1L;
		Long commentId = 1L;

		RewardReplyDTO rewardReplyDTO = new RewardReplyDTO();
		rewardReplyDTO.setRepContent("My Reply Content");
		rewardReplyDTO.setRewardId(rewardId);
		rewardReplyDTO.setCommentId(commentId);

		rewardCommentService.insertRewardCommentReply(rewardReplyDTO);
	}

	@Test
	void insertPayment() {
		Long targetUserId = 1L;

		Optional<User> userOptional = userRepository.findById(targetUserId);
		if (userOptional.isEmpty()) {
			System.out.println("User not found with ID: " + targetUserId);
			return;
		}

		User user = userOptional.get();

		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setUser(user);
		paymentDTO.setCardnumber("0123456789012345");
		paymentDTO.setCardpassword("8765");
		paymentDTO.setPaymentcode(true);
		paymentDTO.setPaymentamount(12345678);
		paymentDTO.setPayenddate("1123");
		paymentDTO.setBirthday("001112");
		paymentDTO.setPayperiod("일시불");
		paymentDTO.setShippingadress("경기도 부천시 상2동 569-3");
		paymentDTO.setShippingadressdesc("3층");

		paymentService.createPayment(paymentDTO);
	}

	@Test
	void insertInvestPeople() {
		Long targetUserId = 1L;

		Optional<User> userOptional = userRepository.findById(targetUserId);
		if (userOptional.isEmpty()) {
			System.out.println("User not found with ID: " + targetUserId);
			return;
		}

		User user = userOptional.get();

		InvestPeopleDTO investPeopleDTO = new InvestPeopleDTO();
		investPeopleDTO.setUser(user);
		investPeopleDTO.setName("장채리");
		investPeopleDTO.setSecuritynumber1("001112");
		investPeopleDTO.setSecuritynumber2("4789535");
		investPeopleDTO.setCalltype("KT");
		investPeopleDTO.setCallnumber("01078965841");

		InvestPeopleService investPeopleService = new InvestPeopleService(investPeopleRepository);
		investPeopleService.createInvestPeople(investPeopleDTO);
	}

	@Test
	void selectRewardById() {
		Long rewardId = 1L;

		try {
			Map<String, Object> rewardMap = rewardService.getRewardById(rewardId);
			RewardDTO rewardDTO = (RewardDTO) rewardMap.get("reward");
			System.out.println(rewardDTO.toString());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void findByProjDateEndBefore() {
		try {
			List<RewardDTO> rewards = rewardService.getRewardWithProjDateEndBeforeToday();
			System.out.println(rewards.toString());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void findByProjDateEndAfter() {
		try {
			List<RewardDTO> rewards = rewardService.getRewardWithProjDateEndBefore();
			System.out.println(rewards.toString());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void findByProjStartAfter() {
		try {
			List<RewardDTO> rewards = rewardService.getRewardWithProjDateStartAfter();
			System.out.println(rewards.toString());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
