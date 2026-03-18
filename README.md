# 🚀 Spring-Board-Service
> **Spring Boot와 JPA를 활용한 RESTful 게시판 및 댓글 관리 시스템**

본 프로젝트는 백엔드의 핵심인 **CRUD 로직**과 **데이터 연관 관계(1:N)**를 안정적으로 구현하는 데 초점을 맞춘 게시판 서비스입니다.

## 📌 주요 기능 (Key Features)
*   **게시글 관리 (Post CRUD)**: 게시글 작성, 전체 목록 조회, 상세 조회, 수정 및 삭제 기능 구현
*   **댓글 시스템 (Comment CRUD)**: 특정 게시글에 종속된 댓글 작성 및 관리 기능
*   **데이터 연관 관계**: JPA를 활용하여 게시글(Post)과 댓글(Comment) 간의 **1:N 양방향 매핑** 적용
*   **계층별 아키텍처**: Controller - Service - Repository 계층 분리로 유지보수성 향상

## 🛠 기술 스택 (Tech Stack)
*   **Language**: Java 17
*   **Framework**: Spring Boot 3.4.12
*   **Database**: H2
*   **ORM**: Spring Data JPA
*   **Build Tool**: Gradle

## 🔥 개발 포인트 & 문제 해결 (Troubleshooting)
*   **데이터 무결성**: 게시글 삭제 시 해당 게시글의 모든 댓글이 함께 삭제되도록 `CascadeType.ALL` 및 `orphanRemoval` 설정 적용
*   **API 설계**: RESTful한 API 설계를 통해 클라이언트와의 데이터 통신 최적화
*   **비즈니스 로직 분리**: 도메인 로직과 서비스 로직을 명확히 분리하여 테스트가 용이한 구조 설계

## 📂 프로젝트 구조
src/main/java/com/example/firstproject
├── controller/      # 사용자의 요청(API)을 받고 응답을 반환하는 계층
├── service/         # 비즈니스 로직(핵심 기능)을 처리하는 계층
├── repository/      # DB에 접근하여 데이터를 저장/조회하는 인터페이스 (JPA)
├── entity/          # DB 테이블과 1:1로 매핑되는 자바 객체 (ORM)
├── dto/             # 계층 간 데이터 교환을 위한 객체 (Data Transfer Object)
├── api/             # 외부 서비스 연동 또는 API 응답 규격 정의
├── aop/             # 공통 관심사(로깅 등)를 분리하여 처리
├── ioc/             # 제어의 역전(IoC) 관련 설정 및 빈(Bean) 관리
├── objectmapper/    # JSON 데이터 변환 및 처리 로직
└── annotation/      # 프로젝트 전용 커스텀 어노테이션 정의
