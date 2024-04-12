import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import dogCare.db.DTO.AlbumAddDTO;
import dogCare.db.DTO.CommentAddDTO;
import dogCare.db.DTO.DogAddDTO;
import dogCare.db.DTO.DogInfoAddDTO;
import dogCare.db.DTO.ImageAddDTO;
import dogCare.db.DTO.SupplyAddDTO;
import dogCare.db.VO.CommentVO;
import dogCare.db.VO.UserVO;
import dogCare.service.DogAlbumListService;
import dogCare.service.DogAlbumListServiceImpl;
import dogCare.service.DogInformationService;
import dogCare.service.DogInformationServiceImpl;
import dogCare.service.DogRegistrationService;
import dogCare.service.DogRegistrationServiceImpl;
import dogCare.service.PostService;
import dogCare.service.PostServiceImpl;
import dogCare.service.RegistrationService;
import dogCare.service.RegistrationServiceImpl;

@SuppressWarnings("all")
public class Test {

	public static void main(String[] args) {
		try {
			RegistrationService regisUI = new RegistrationServiceImpl();
			DogRegistrationService dogRegisUI = new DogRegistrationServiceImpl();
			DogInformationService dogInfoUI = new DogInformationServiceImpl();
			DogAlbumListService albumListUI = new DogAlbumListServiceImpl();
			PostService postUI = new PostServiceImpl();
			
			String userId = "hellonuri1234";
			String nickname = "hellonuri";
			String name = "손유철";
			String password = "1234";
			String confirmPassword = "4321";
			String email = "hellonuri1234@gmail.com";
			
			String dogName = "골골댕이";
			String breed = "골든 리트리버";
			Date birthDate = new Date(2024 - 1900, 4 - 1, 1);
			
			double weight = 12.0;
			double exerciseTime = 12.0;
			Collection<SupplyAddDTO> supplies= new ArrayList<>();
			DogInfoAddDTO dogInfo = new DogInfoAddDTO(weight, exerciseTime, null, new Timestamp(System.currentTimeMillis()));
			supplies.add(new SupplyAddDTO("사료", "골골댕이가 먹는 사료"));
			supplies.add(new SupplyAddDTO("치약", "골골댕이가 쓰는 치약"));
			
			String title = "제목";
			String content ="내용";
			Collection<ImageAddDTO> images = new ArrayList<>();
			images.add(new ImageAddDTO("이미지1"));
			images.add(new ImageAddDTO("이미지2"));
			Collection<Integer> dogTags = new ArrayList<>();
			dogTags.add(1);
			
			AlbumAddDTO album = new AlbumAddDTO(title, content, userId);
			
			CommentAddDTO comment = new CommentAddDTO("댓글", 2, userId);
			CommentAddDTO recomment1 = new CommentAddDTO("대댓글1", 1, userId);
			CommentAddDTO recomment2 = new CommentAddDTO("데댓글2", 1, userId);

			System.out.println("-----------로그인 테스트---------");
			System.out.println("ID를 입력하세요: hellonuri");
			System.out.println("PW를 입력하세요: 1234");
			System.out.println("로그인실패: " + regisUI.login("hellonuri", "12346"));
			System.out.println("로그인성공: " + regisUI.login("hellonuri", "0000"));
			System.out.println("\n\n");
			System.out.println("-----------회원가입 테스트---------");
			//DB에서 hellnuri124 삭제할것
			System.out.println("hellonuri124가 존재하지 않음: " + regisUI.getUserIdByEmail(email));
			System.out.println("유저 추가 실패(패스워드 중복): " + regisUI.register(new UserVO(userId, nickname, name, password, email), confirmPassword));
			System.out.println("유저 추가 성공: " + regisUI.register(new UserVO(userId, nickname, name, password, email), "1234"));
			System.out.println("hellonuri1234가 존재함: " + regisUI.getUserIdByEmail(email));
			System.out.println("\n\n");
			System.out.println("----------ID/PW찾기----------");
			System.out.println("hellonuri1234@gmail.com의 아이디: " + regisUI.getUserIdByEmail(email));
			System.out.println("비밀번호초기화하기: " + regisUI.resetPassword(userId, name, email));
			System.out.println("원래 비밀번호로 로그인: " + regisUI.login(userId, password));
			System.out.println("바뀐 비밀번호로 로그인: " + regisUI.login(userId, "0000"));
			System.out.println("\n\n");
			System.out.println("---------MAIN----------");
			System.out.println(regisUI.getNicknameById(userId) + "님 환영합니다.");
			System.out.println("\n\n");
			System.out.println("---------강아지 회원가입----------");
			//강아지 삭제하기
			int dogId = dogRegisUI.dogRegister(new DogAddDTO(dogName, breed, birthDate, 'F', 'Y', userId));
			System.out.println("강아지 추가하기 성공: " + dogRegisUI.getDog(dogId));
			System.out.println("hellonuri1234의 강아지 목록: " + dogRegisUI.getDogsByUserId(userId));
			System.out.println("\n\n");
			System.out.println("---------강아지 건강정보 입력----------");
			System.out.println("골골댕이의 체중(kg): " + weight);
			System.out.println("골골댕이의 운동량(시간/주): " + exerciseTime);
			System.out.println("골골댕이가 쓰는 용품: " + supplies);
			System.out.println("\n\n");
			System.out.println("골골댕이의 건강정보 추가하기: " + dogInfoUI.addDogHealthReport(dogId, dogInfo, supplies));
			System.out.println("---------강아지 앨범 목록----------");
			Collection<Integer> dogIds = new ArrayList<>();
			dogIds.add(1);
			dogIds.add(2);
			dogTags.add(dogId);
			System.out.println("나의 강아지 앨범목록: " + albumListUI.getAlbumListByUserId("1", 4));
			System.out.println("특정 강아지 앨범목록: " + albumListUI.getAlbumListByDogs(dogIds, 4));
			System.out.println("닉네임 검색 앨범목록: " + albumListUI.getAlbumListByNickname("댕집사", 4));
			System.out.println("제목 검색 앨범목록: " + albumListUI.getAlbumListByTitle("골댕", 4));
			System.out.println("\n\n");
			System.out.println("---------강아지 앨범 상세보기----------");
			
			System.out.println("앨범 쓰기: " + postUI.writePost(album, images, dogTags));
			System.out.println("댓글 쓰기: " + postUI.writeComment(comment));
			System.out.println("대댓글 쓰기: " + postUI.writeRecomment(recomment1));
			System.out.println("대댓글 쓰기: " + postUI.writeRecomment(recomment2));
			System.out.println("특정 앨범 열람: " + postUI.getPostById(2));
			CommentVO editComment = new CommentVO(1, "수정된 내용", new Timestamp(2), 1, "hellonuri1234"); 
			System.out.println("댓글 수정: " + postUI.editComment(editComment));
			System.out.println("특정 앨범 열람: " + postUI.getPostById(2));
			System.out.println("특정 앨범 삭제: " + postUI.deletePost(2, "hellonuri1234"));
			System.out.println("특정 앨범 열람: " + postUI.getPostById(2));//이거 왜 null 반환 안 됨?
			System.out.println("\n\n");
			System.out.println("---------강아지 인바디----------");
			System.out.println("강아지 체중정보(나의 강아지 체중/평균체중): " + dogInfoUI.getHealthGraphByDogId(1));
			System.out.println("\n\n");
			System.out.println("---------강아지 관련용품 통계----------");
			int startAge = 8;
			int endAge = 24;
			String category = "치약";
			System.out.println("검색조건 입력");
			System.out.println("품종: 골든 리트리버");
			System.out.println("나이: 8~24개월");
			System.out.println("통계낼 물품: 치약");
			System.out.println("통계: " + dogInfoUI.getSupplyStatistic(breed, startAge, endAge, category));
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
