# WebFlux 와 WebClient 예제 구현
 
API 간 통신을 Reactive 를 이용해 구현한다.<br>

## 예제는 3 개의 프로젝트와 도메인/테스트 모듈로 구성된다.
1. FRONT API<br>
클라이언트의 요청을 받아 데이터를 **조합**하는 API

2. BACKEND API<br>
DB 와 연동되며 **도메인 데이터를 처리**하는 API

3. THIRD PARTY API<br>
**추가적인 정보를 제공**하는 API

- DOMAIN

API 에서 사용되는 도메인 모듈

- TEST API

통합 테스트용 모듈

## 서버간 구조도

![API 서버 간 통신](/resource/image/api-flow.png)

- `WebFlux` 와 `WebClient` 를 사용하며 클라이언트의  `Reactor` 의 `Mono` 와 `Flux` 를 이용해 **비동기** 로 처리한다.

비동기로 여러 서버들을 호출하며 얻은 결과값을 가공하여 NonBlocking 으로 연결되어 있던 클라이언트에게 이벤트를 통해 알려준다.

## 예제

### POST localhost:8891/user {"name" : "jun", "age" : 30}
#### 사용자를 추가할 때 Mono 를 이용해 데이터를 전달하고 저장된 데이터를 돌려받는다.

### GET localhost:8891/users
#### BACKAND API 에게 API를 3번 호출하지만 비동기로 사용자 목록을 조합하므로 API 들 중 최장 처리 시간에 맞추어 완료된다.

### GET localhost:8891/adultsInSeoul
#### BACKAND API 에게 3번의 API 를 호출해 응답받은 데이터를 검증하고 THIRDPARTY API 를 통해 한번더 가공한다.
