**1. 시나리오: 콘서트 예약 서비스**
   
**2. 마일스톤**
![image](https://github.com/kkyuny/concert/assets/88278485/c7800d75-ac99-4c97-a68a-b2c4c88ab0fb)

**3. API 명세**

![image](https://github.com/kkyuny/concert/assets/88278485/65d1ca78-2693-4db8-921d-7aae93d5b0a4)

![image](https://github.com/kkyuny/concert/assets/88278485/b4a428e3-d434-47f0-ad37-258a8f08f70e)

![image](https://github.com/kkyuny/concert/assets/88278485/951efa27-e66e-4894-aa3e-9010cfcb0eb8)

![image](https://github.com/kkyuny/concert/assets/88278485/a462bc01-11fe-437d-b7a9-c8606e281be4)

![image](https://github.com/kkyuny/concert/assets/88278485/5ff19b7f-cd07-4223-8962-488ae3ce3fc1)

![image](https://github.com/kkyuny/concert/assets/88278485/3021bdb0-b6eb-408c-b3ff-713cae3ecf27)

![image](https://github.com/kkyuny/concert/assets/88278485/629b09e5-81c5-41e3-a1ed-3304e0809f4f)

**4. ERD**

![image](https://github.com/kkyuny/concert/assets/88278485/2b73d313-fccf-4821-9191-b45bd437fdea)

- 좌석 예약 요청 시 reserve 테이블에 consert_id와 seat_no이 복합키로 설정되어 해당 정보가 insert 됌.
- 유효시간(reserveDate + vaildTime(분)) 동안에 해당 row가 존재하는 한 해당 reserve 테이블에 동일한 콘서트와 좌석의 insert 불가
- 유효시간 내 결제 완료 시 status -> 예약완료로 변경 -> 새로운 예약정보 insert 불가
- 유효시간 내 결제 미완료시 해당 row 삭제처리(reserve_history 테이블에 신청 정보는 남아 있음) -> 해당 콘서트와 좌석에 대해 새로운 예약정보 insert가 가능하게 만듬
   
