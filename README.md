**1. 시나리오: 콘서트 예약 서비스**
   
**2. 마일스톤**
![image](https://github.com/kkyuny/concert/assets/88278485/c7800d75-ac99-4c97-a68a-b2c4c88ab0fb)

**3. API 명세**

![image](https://github.com/kkyuny/concert/assets/88278485/65d1ca78-2693-4db8-921d-7aae93d5b0a4)

![image](https://github.com/kkyuny/concert/assets/88278485/b4a428e3-d434-47f0-ad37-258a8f08f70e)

![image](https://github.com/kkyuny/concert/assets/88278485/a397db1a-80c5-40c1-ac5c-ad46c4d7fc23)

![image](https://github.com/kkyuny/concert/assets/88278485/46b68a9b-04af-49d3-95ea-001ee1c707ee)

![image](https://github.com/kkyuny/concert/assets/88278485/5ff19b7f-cd07-4223-8962-488ae3ce3fc1)

![image](https://github.com/kkyuny/concert/assets/88278485/3021bdb0-b6eb-408c-b3ff-713cae3ecf27)

![image](https://github.com/kkyuny/concert/assets/88278485/629b09e5-81c5-41e3-a1ed-3304e0809f4f)

**4. ERD**

![image](https://github.com/kkyuny/concert/assets/88278485/81779844-d6cc-45e4-a00b-19f6bdebc1a4)
 reserve table
- 좌석 예약 요청 시 테이블에 consert_id와 seat_no이 복합키로 설정되어 해당 정보를 insert 함.
- 유효시간 동안에 해당 row가 존재하는 한 해당 reserve 테이블에 동일한 콘서트와 좌석의 insert 불가
- 유효시간 내 결제 완료 시 status -> 예약완료로 변경 -> 새로운 예약정보 여전히 insert 불가
- 유효시간 내 결제 미완료시 해당 row 삭제처리(reserve_history 테이블에 신청 정보는 남기려고함) -> 해당 콘서트와 좌석에 대해 새로운 예약정보 insert가 가능하게 만듬

 queue table
- queue는 유효시간이 초과하거나 결제완료 된 row는 삭제 진행하여 관리

**5. mock API 명세**
 1) 토큰 생성
- 엔드포인트: POST /api/token/create
- 요청
   - Content-Type: application/json
   - data:
      {
        "id": Long
      }
- 응답
   - 상태: 200
   - data: "tempToken"

 2) 예약 가능한 날짜 조회
- 엔드포인트: GET /api/reservation/dates
- 요청
   - header: Authorization(token)
- 응답
   - 상태: 200
   - data:
     [        
        {"YYYY-MM-DD"}
        , ...
     ]

 3) 예약 가능한 좌석 조회
- 엔드포인트: GET /api/reservation/seats
- 요청
   - header: Athorization(token)
   - parameter: String date(YYYY-MM-DD)
- 응답
  - 상태: 200
  - data:
   [ {
       "seatNo": Long,
       "status": String
     },
     ...
   ]

 4)좌석 예약
- 엔드포인트: POST /api/reservation/reserve
- 요청
   - header: Authorization(token)
   - Content-Type: application/json
   - data:
   {
     "concertDate": "YYYY-MM-DD",
     "seatNo": Long
   }
- 응답
   - 상태: 200
   - data: "예약 성공"

 5)사용자 잔액 조회
- 엔드포인트: GET /api/charge
- 요청
   - Content-Type: application/json
   - data:
   {
     "id": Long
   }
- 응답
   - 상태: 200
   - data:
   {
     "amount": Long
   }

6)사용자 잔액 충전
- 엔드포인트: POST /api/charge
- 요청
   - Content-Type: application/json
   - data:
   {
     "userId": Long,
     "amount": Long
   }
- 응답
   - 상태: 200
   - data: "충전 성공"

7) 결제 처리
- 엔드포인트: POST /api/payment
- 요청 
   - Content-Type: application/json
   - data:
   {
     "userId": Long,
     "amount": Long
   }
- 응답
   - 상태: 200
   - data: "결제 성공"
