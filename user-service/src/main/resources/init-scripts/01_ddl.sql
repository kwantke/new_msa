-- 연결 문자셋 설정
SET NAMES utf8mb4;

-- 클라이언트와 서버 간 문자셋 설정
SET CHARACTER SET utf8mb4;

-- 연결 정렬 순서 설정
SET collation_connection = 'utf8mb4_0900_ai_ci';

CREATE TABLE `users` (
                       `id` bigint NOT NULL AUTO_INCREMENT,
                       `email` varchar(50) NOT NULL,
                       `name` varchar(50) NOT NULL,
                       `encrypted_pwd` varchar(255) NOT NULL,
                       `user_id` varchar(255) NOT NULL,
                       PRIMARY KEY (`id`),
                       UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
                       UNIQUE KEY `UK_d0xwk3cyqbi384375x5m7ttl7` (`encrypted_pwd`),
                       UNIQUE KEY `UK_6efs5vmce86ymf5q7lmvn2uuf` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;