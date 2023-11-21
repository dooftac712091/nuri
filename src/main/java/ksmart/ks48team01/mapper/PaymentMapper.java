package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentMapper {

    // 결제 내역 조회 검색
    public List<Payment> getSearchPaymentList(List<Map<String, Object>> searchList);

    //결제 금액 조회
    public int getPaymentAmount();

    //결제 횟수 조회
    public int getPaymentCount();

    //결제 내역 조회
    public List<Payment> getPaymentList();
}
