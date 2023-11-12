package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 관리자 페이지 전체 회원 조회
    public List<User> getUserList();

    // 관리자 페이지 특정 회원 상세 조회
    public User getSpecificUserList(String userId);
    
    // 관리자 등록
    public void adminRegister(User user);
    
    // 관리자의 회원정보 수정
    public void updateUserByAdmin(User user);
    
    // 사용자 등록
    public void memberRegister(User user);
    
    
    // 사용자 문화누리카드 등록정보 삭제
    public void userCardInfoDelete(String deleteTarget);
    // 회원의 등록한 이미지 파일 삭제
    public void userFileDelete(String deleteTarget);
    // 게시한 글 정보 삭제
    public void userBoardDelete(String deleteTarget);
    // 회원의 결제정보 삭제
    public void userPaymentInfoDelete(String deleteTarget);
    
}
