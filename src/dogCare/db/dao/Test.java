package dogCare.db.dao;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogCare.db.VO.ImageVO;
import dogCare.service.RegistrationService;
import dogCare.service.RegistrationServiceImpl;

@SuppressWarnings("unused")
public class Test {
//	static String url = "jdbc:oracle:thin:@localhost:1521:XE";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			UserDAOImpl userDao = new UserDAOImpl();
//			DogDAOImpl dogDao = new DogDAOImpl();
//			CommentDAOImpl comDao = new CommentDAOImpl(); 
//			AlbumDAOImpl alDao = new AlbumDAOImpl();
//			System.out.println(userDao.login("10", "123"));
//			System.out.println(userDao.isIdDuplicated("4"));

//			System.out.println(userDao.register(new UserVO("hellonuri","닉네임", "손유철", "1234", "hellonuri@gmail.com")));
//			System.out.println(userDao.resetPassword("hellonuri", "손유철", "hellonuri@gmail.com"));
			
//			System.out.println(userDao.getUserIdByEmail("손유철@gmail.com"));

//			System.out.println(dogDao.getDogsByUserId("1"));
			
//			System.out.println(dogDao.addDog(new DogVO("동댕이", "동든 리트리버", new Date(2024, 1, 1), 'M', 'Y', "1")));
//			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
//
//			// Timestamp to String
//			String currentTimestampToString = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(currentTimestamp);
//			System.out.println(currentTimestampToString);
//			Collection<SupplyVO> supplies = new ArrayList<SupplyVO>();
//			supplies.add(new SupplyVO("사료", "사료 테스트"));
//			supplies.add(new SupplyVO("칫솔", "칫솔 테스트"));
//			System.out.println(dogDao.addDogHealthReport(new DogInfoVO(10.0, 12.0, "테스트", new Timestamp(System.currentTimeMillis()), 12), supplies));
			
//			System.out.println(dogDao.getHealthDataByDogId("1"));
//			System.out.println(dogDao.getHealthDataByBreed("골든 리트리버"));
//			System.out.println(dogDao.getBreedByDogId("1"));
//			Map<Integer, Integer> testMap = new HashMap<>();
//			testMap.put(1, 1);
//			System.out.println(testMap.get(0));
//			System.out.println(dogDao.getHealthGraphByDogId("1"));
			
//			System.out.println(comDao.addComment(new CommentVO("테스트내용", new Timestamp(System.currentTimeMillis()), 1, "1")));
//			System.out.println(comDao.editComment(new CommentVO(100, "테스트내용321", new Timestamp(System.currentTimeMillis()), 1, "2")));
//			System.out.println(comDao.addRecomment(new CommentVO("테스트내용", new Timestamp(System.currentTimeMillis()), 1, "1")));
//			System.out.println(comDao.editRecomment(new CommentVO(2, "테스트내용3121", new Timestamp(System.currentTimeMillis()), 90, "1")));
//			System.out.println(comDao.deleteComment(100, "2"));
//			System.out.println(comDao.deleteRecomment(100, "3"));
			
//			System.out.println(comDao.getRecommentsByCommentId(101));
			
//			Collection<Integer> tags = new ArrayList<Integer>();
//			tags.add(1);
//			tags.add(2);
//			System.out.println(alDao.addDogTag(1, tags));
			
//			Collection<ImageVO> tags = new ArrayList<ImageVO>();
//			Collection<Integer> dogIds = new ArrayList<Integer>();
			
//			dogIds.add(1);
//			dogIds.add(3);
//			tags.add(new ImageVO("image1", 1));
//			tags.add(new ImageVO("image3", 1));
//			System.out.println(alDao.addImages(tags));
//			AlbumVO aVO = new AlbumVO("testTitle", "TestContent", "1");
//			System.out.println(alDao.addAlbum(aVO, dogIds, tags));
			
//			System.out.println(alDao.deleteDogTagsByAlbumId(7));
			
//			System.out.println(alDao.deleteImagesByAlbumId(8));
//			AlbumVO aVO = new AlbumVO("에딧", "에딧내용", "1");
//			System.out.println(alDao.editAlbum(aVO, dogIds, tags));
			
//			System.out.println(alDao.getAlbumVOById(6));
//			System.out.println(alDao.getImagesByAlbumId(6));
//			System.out.println(alDao.getAlbumById(6));
			
//			System.out.println(alDao.getAlbumListByTitle("에딧", 4));
			
//			Collection<Integer> dogIds = new ArrayList<Integer>();
//			dogIds.add(1);
//			dogIds.add(2);
			
//			System.out.println(alDao.getAlbumListByDogs(dogIds, 4));
//			System.out.println(userDao.login("2", "1234"));
			
			RegistrationService regisSv = new RegistrationServiceImpl();
			System.out.println(regisSv.getNicknameById("1"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
