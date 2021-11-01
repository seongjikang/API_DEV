# API_DEV

- 회원 가입
  - HTTP POST: /members
  - input example
  {
    "name" : "kangseongji",
    "nickname" : "kangpig",
    "password" : "12345167890",
    "phoneNumber" : "01011341212",
    "email" : "abcd1A@gmail.com",
    "genderType" : "M"
  }
  -output example
  {
    "data": 21
  }
  
- 회원 로그인(인증)
  - 구현 예정 (jwt 활용...)
  
- 회원 로그아웃
  - 구현 예정
  
- 단일 회원 상세 정보 조회
    - HTTP GET: /members/{userId}
    - outputExample
    {
    "data": {
        "name": "testName0",
        "nickname": "testNickName0",
        "phoneNumber": "0100000000",
        "email": "test0@gmail.com",
        "genderType": "M"
      }
    }
    
- 단일 회원의 주문 목록 조회
   - HTTP GET: /members/orders/{userId}
   - output Example
   {
    "data": [
        {
            "memberName": "testName0",
            "orderNum": "100000000000",
            "productName": "product0",
            "paymentDate": "2021-03-01T00:00:00"
        },
        {
            "memberName": "testName0",
            "orderNum": "200000000000",
            "productName": "product0",
            "paymentDate": "2021-03-01T00:00:00"
        }
      ]
   }

- 여러 회원 목록 조회
   - 최적화 진행중 ...
