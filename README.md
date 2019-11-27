# reactive-server-flux-exmple

FRONT API <-> BACK API 간 통신을 Reactive 를 이용해 구현한다.

WebFlux 와 WebClient 를 이용해 클라이언트가 요청한 작업을 비동기로 처리한다.

Reactor 의 Mono 와 Flux 를 이용해 비동기 처리를 진행한다.

## 첫번째 API
### 사용자를 추가할 때 Mono 를 이용해 데이터를 전달하고 저장된 데이터를 돌려받는다.
- POST localhost:8891/user

## 두번째 API
### BACKAND API 에게 API를 3번 호출하지만 비동기로 사용자 목록을 조합하므로 API 들 중 최장 처리 시간에 맞추어 완료된다.
- GET localhost:8891/users
